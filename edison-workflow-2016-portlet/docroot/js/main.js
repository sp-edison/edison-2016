$(function() {
  if(typeof isNotLoaded !== 'undefined' && isNotLoaded){
    isNotLoaded = false;
    var workflowStatusTimer;
    var modifyingWorkflow;
    var currentJsPlumbInstance;
    var currentWorkflowInstanceId;
    var currentDoneWorkflowInstanceId;
    var slideClosure = (function(){
      var workflowId;
      var thisJsplumbInstance;
      return {
        reset: function(){
          workflowId = undefined;
          thisJsplumbInstance = undefined;
        },
        set: function(argWorkflowId, argJsplumbInstance){
          workflowId = argWorkflowId;
          thisJsplumbInstance = argJsplumbInstance;
        },
        run: function(loadWorkflowFunc){
          if(workflowId && thisJsplumbInstance){
            loadWorkflowFunc(workflowId, thisJsplumbInstance);
          }
        }
      };
    })();
    
    $(document).ready(function () {
      consoleLog.setLoggingLevel({
        error : true,
        info : true,
        debug : false
      });
      
      /** application **/
      var portDropOption = {
        // tolerance: "touch",
        hoverClass: "dropHover",
        activeClass: "dragActive"
      };
      
      var WF_STATUS_CODE = {
          CREATED : "CREATED", 
          RUNNING : "RUNNING",
          PAUSED : "PAUSED", 
          COMPLETED : "COMPLETED", 
          DONE : "DONE",
          FAILED : "FAILED",
          CANCELED : "CANCELED"
      };
      var WF_STATUS_CODE_STRING = {
          CREATED : "Created", 
          RUNNING : "Running",
          PAUSED : "Paused", 
          COMPLETED : "Completed", 
          DONE : "Done",
          FAILED : "Failed",
          CANCELED : "Canceled"
      };
      
      var WF_JSPLUMB_TYPES = {
        ENDPOINT : "endpoint",
        INPUT : "input",
        OUTPUT : "output"
      };
      
      var inputPortColor = "#416EC5";
      var outputPortColor = "#D6442D";
      var connectionColor = "#11C7E7";
      
      var outputPortPoint = {
          endpoint: "Rectangle",
          type: WF_JSPLUMB_TYPES.ENDPOINT + " " + WF_JSPLUMB_TYPES.OUTPUT,
          paintStyle: { width: 18, height: 18, fillStyle: outputPortColor },
          isSource: true,
          maxConnections : -1,
          connectorStyle: {
            lineWidth: 5,
            strokeStyle: connectionColor
          },
          ConnectionsDetachable : true,
          isTarget: false,
          dropOptions: portDropOption
      };
      
      var inputPortPoint = {
          endpoint: ["Rectangle", {cssClass : "input-port"}],
          type: WF_JSPLUMB_TYPES.ENDPOINT + " " + WF_JSPLUMB_TYPES.INPUT,
          paintStyle: { width: 18, height: 18, fillStyle: inputPortColor },
          isSource: false,
          isTarget: true,
          ConnectionsDetachable : true,
          beforeDrop: function (params) {
            //consoleLog.debug(params);
            var sourceEndpoint = params.connection.endpoints[0].getParameter("data"); 
            var targetEndpoint = params.dropEndpoint.getParameter("data");
            return targetEndpoint.isCompatible(sourceEndpoint.getPortTypeId()) 
              && !(params.sourceId === params.targetId)
              && sourceEndpoint.form === "file";
          },
          dropOptions: portDropOption
      };
   
      var wfWorkflowJsPlumbInstance = jsPlumb.getInstance({
        Container : "wf-workflow-canvas",
        DragOptions : { containment : true ,cursor: 'pointer'},
        Endpoint: "Rectangle",
        ConnectionsDetachable: true,
        Anchors: ["TopCenter", "TopCenter"],
        Overlays: [["Arrow", { location: 1, id: "arrow", length: 14, foldback: 1}]]
      });
      
      /** document ready batch**/
      currentJsPlumbInstance = wfWorkflowJsPlumbInstance;
      
      var runningWorkflowJsPlumbInstance = jsPlumb.getInstance({
        Container : "running-workflow-canvas",
        DragOptions : { containment : false ,cursor: 'pointer'},
        Endpoint: "Rectangle",
        ConnectionsDetachable: false,
        Anchors: ["TopCenter", "TopCenter"],
        Overlays: [["Arrow", { location: 1, id: "arrow", length: 14, foldback: 1}]]
      });
      
      var myWorkflowJsPlumbInstance = jsPlumb.getInstance({
        Container : "my-workflow-canvas",
        DragOptions : { containment : true ,cursor: 'pointer'},
        Endpoint: "Rectangle",
        ConnectionsDetachable: false,
        Anchors: ["TopCenter", "TopCenter"],
        Overlays: [["Arrow", { location: 1, id: "arrow", length: 14, foldback: 1}]]
      });
      
      var publicWorkflowJsPlumbInstance = jsPlumb.getInstance({
        Container : "public-workflow-canvas",
        DragOptions : { containment : true ,cursor: 'pointer'},
        Endpoint: "Rectangle",
        ConnectionsDetachable: false,
        Anchors: ["TopCenter", "TopCenter"],
        Overlays: [["Arrow", { location: 1, id: "arrow", length: 14, foldback: 1}]]
      });
      
      function jsplumbContextMenuCallback(e) {
        e.preventDefault();
        consoleLog.debug("jsplumbContextMenuCallback");
        consoleLog.debug(e);
        var wfBox = $(e.target);
        consoleLog.debug(wfBox);
        if(!wfBox.hasClass("wf-box")){
          return false;
        }
      }
      function jsPlumbConnectionDetachedCallback(info, originalEvent) {
        var outputPortData = info.sourceEndpoint.getParameter("data");
        var inputPortData = info.targetEndpoint.getParameter("data");
        var sourceClientId = $(info.sourceEndpoint.getElement()).attr("id");
        var targetClientId = $(info.targetEndpoint.getElement()).attr("id");
        var sourceApp = $(info.sourceEndpoint.getElement()).data();
        var targetApp = $(info.targetEndpoint.getElement()).data();
        if(sourceApp["childNodes"] && $.inArray(targetClientId, sourceApp["childNodes"]) > -1){
          sourceApp["childNodes"].splice($.inArray(targetClientId, sourceApp["childNodes"]), 1);
        }
        if(targetApp["parentNodes"] && $.inArray(sourceClientId, targetApp["parentNodes"]) > -1){
          targetApp["parentNodes"].splice($.inArray(sourceClientId, targetApp["parentNodes"]), 1);
        }
        if(targetApp["inputports"] && targetApp["inputports"][inputPortData["name"]]){
          delete targetApp["inputports"][inputPortData["name"]]["expectedSource"];
          delete targetApp["inputports"][inputPortData["name"]]["expectedValue"];
          delete targetApp["inputports"][inputPortData["name"]]["hasParent"];
        }
        consoleLog.debug($(info.sourceEndpoint.getElement()).data());
        consoleLog.debug($(info.targetEndpoint.getElement()).data());
      }
      
      function jsPlumbConnectionCallback(info, originalEvent) {
        var outputPortData = info.sourceEndpoint.getParameter("data");
        var inputPortData = info.targetEndpoint.getParameter("data");
        var sourceClientId = $(info.sourceEndpoint.getElement()).attr("id");
        var targetClientId = $(info.targetEndpoint.getElement()).attr("id");
        var sourceApp = $(info.sourceEndpoint.getElement()).data();
        var targetApp = $(info.targetEndpoint.getElement()).data();
        if(!sourceApp["childNodes"]){
          sourceApp["childNodes"] = [];
        }
        if($.inArray(targetClientId, sourceApp["childNodes"]) === -1){
          sourceApp["childNodes"].push(targetClientId);
        }
        if(!targetApp["parentNodes"]){
          targetApp["parentNodes"] = [sourceClientId];
        }
        if($.inArray(sourceClientId, targetApp["parentNodes"]) === -1){
          targetApp["parentNodes"].push(sourceClientId);
        }
        if(targetApp["inputports"] && targetApp["inputports"][inputPortData["name"]]){
          targetApp["inputports"][inputPortData["name"]]["expectedSource"] = sourceClientId;
          targetApp["inputports"][inputPortData["name"]]["expectedValue"] = outputPortData["file-name"];
          targetApp["inputports"][inputPortData["name"]]["hasParent"] = true;
        }
        consoleLog.debug($(info.sourceEndpoint.getElement()).data());
        consoleLog.debug($(info.targetEndpoint.getElement()).data());
      }
      
      function runningWorkflowJsPlumbInstanceDblClickCallback(element, event){
        if(element.hasType(WF_JSPLUMB_TYPES.ENDPOINT)
            && element.hasType(WF_JSPLUMB_TYPES.OUTPUT)){
          var sciApp = $(element.getElement()).data();
          if(!sciApp["workflowStatus"] && (currentWorkflowInstanceId || currentDoneWorkflowInstanceId)){
            var wStatus = updateWorkflowInstanceDiagram(currentWorkflowInstanceId ? currentWorkflowInstanceId : currentDoneWorkflowInstanceId);
            var simulations = wStatus.workflow.simulations;
            for(var i=0; i<simulations.length; i++){
              var clientId = "#running-workflow-canvas #"+simulations[i].clientId;
              var appData = $(clientId).data();
              appData["workflowStatus"] = simulations[i];
              appData["workflowStatus"]["workflowUuid"] = wStatus["workflow"]["uuid"];
              if(appData["uuid"] === sciApp["uuid"]){
                sciApp = appData;
              }
            }
          }
          var sciAppStatus = sciApp["workflowStatus"]["status"];
          var jobUuid = sciApp["workflowStatus"]["jobs"][0]["ibUuid"];
          if(sciAppStatus === WF_STATUS_CODE.COMPLETED 
              || sciAppStatus === WF_STATUS_CODE.DONE){
            var port = element.getParameter("data");
            var portAnalyzers = synchronousAjaxHelper.get("/delegate/services/app/"
                + sciApp["scienceAppId"] + "/outputports/" + port.getPortTypeId());
            $.each(portAnalyzers, function(i){
              if(port && portAnalyzers[i]["portTypeAnalyzerLinkId"] == port.getDefaultAnalyzerId()){
                var analyzer = portAnalyzers[i];
                if(analyzer["status"] && analyzer["status"] == 1901003){
                  alert(var_private_default_editor_message);
                  return false;
                }
                var jsPlumbWindowId = element.elementId;
                //sciApp["inputports"][port["name"]]["defaultAnalyzerType"] = portAnalyzers[i]["editorType"]; /*save defaultEditorType*/ 
                popAnalyzerWindow(analyzer, port, jsPlumbWindowId, sciApp["groupId"], jobUuid);
              }
            });
            $(element.getElement()).data(sciApp);
          }else{
            alert(var_cannot_load_analyzer_message);
          }
        }
      }
      
      function jsPlumbDblClickCallback(element, event){
        consoleLog.debug("dblclick");
        consoleLog.debug(element);
        if(element.hasType(WF_JSPLUMB_TYPES.ENDPOINT)
          && element.hasType(WF_JSPLUMB_TYPES.INPUT)
          && element.connections.length === 0){
          /*call parent Div data*/
          var sciApp = $(element.getElement()).data();
          var port = element.getParameter("data");
          var portEditors = synchronousAjaxHelper.get("/delegate/services/app/"
              + sciApp["scienceAppId"] + "/inputports/" + port.getPortTypeId());
          
          $.each(portEditors, function(i){
            if(port && portEditors[i]["portTypeEditorLinkId"] == port.getDefaultEditorId()){
              var editor = portEditors[i];
              if(editor["status"] && editor["status"] == 1901003){
                alert(var_private_default_editor_message);
                return false;
              }
              var jsPlumbWindowId = element.elementId;
              sciApp["inputports"][port["name"]]["defaultEditorType"] = portEditors[i]["editorType"]; /*save defaultEditorType*/ 
              popEditorWindow(editor, port, jsPlumbWindowId, sciApp["groupId"]);
            }
          });
          consoleLog.debug($(element.getElement()).data());
          $(element.getElement()).data(sciApp);
          consoleLog.debug($(element.getElement()).data());
        }
      }
        
      wfWorkflowJsPlumbInstance.bind("dblclick", jsPlumbDblClickCallback);
      wfWorkflowJsPlumbInstance.bind("connection", jsPlumbConnectionCallback);
      wfWorkflowJsPlumbInstance.bind("connectionDetached", jsPlumbConnectionDetachedCallback);
      
      var initData = synchronousAjaxHelper.get(
      "/delegate/services/app/all");

      $("#app-list").jstree({
        "core": {
          "check_callback": function (operation, node, node_parent, node_position, more) {
            if(operation === 'move_node') {
              return false;
            }
            return true;
          },
          "data": initData
        },
        "types" : {
          "category" : {},
            "subCategory" : {},
          "app" : {}
        },
        "search": {
          "case_sensitive": false,
          "show_only_matches" : true
        },
        "dnd": {
          "is_draggable" : isDraggableNode,
          "check_while_dragging" : true
        },
        "plugins": ["types", "dnd", "search"]
      }).bind("hover_node.jstree", function(node){
      }).bind("loaded.jstree", function (event, data) {
        $("#science-app-search").keyup(function(e){
          var searchString = $(this).val();
          $('#app-list').jstree(true).search(searchString);
        });
      }).bind("select_node.jstree", function (event, data) {
        consoleLog.debug("select_node.jstree");
        var nodeId = data.node.id;
        var node = data.node;
        if(node.type !== "app"){
          if(!$("#" + nodeId).hasClass("jstree-open")){
            $("#app-list").jstree("open_node", node);
          }else{
            $("#app-list").jstree("close_node", node);
          }
        }
      });
      
      $(document).on("dnd_start.vakata", function (event, data) {
        var nodeId = data.data.nodes[0];
        var nodeData = $('#app-list').jstree(true).get_node(nodeId).data;
      });
      
      $(document).on("dnd_stop.vakata", function (event, data) {
        var eventTarget = $(data.event.target);
        if(!eventTarget.closest('.jstree').length) {
          if(eventTarget.closest('.wf-drop').length) {
            var nodeId = data.data.nodes[0];
            var node = $('#app-list').jstree(true).get_node(nodeId);
            addScienceApp(eventTarget.closest('.wf-drop'), data.event.pageX, data.event.pageY, node.data);
          }
        }
      });
      
      $(document).on("dnd_move.vakata", function (event, data) {
        var nodeId = data.data.nodes[0];
        var nodeData = $('#app-list').jstree(true).get_node(nodeId).data;
        var eventTarget = $(data.event.target);
        if (!eventTarget.closest('.jstree').length) {
          if (eventTarget.closest('.wf-drop').length) {
            data.helper.find('.jstree-icon').removeClass('jstree-er').addClass('jstree-ok');
          }
        }
      });
      
      function isDraggableNode(data, event) {
        if(!data[0]) return false;
        if(data[0].type === "group") {
          return false;
        } else if (data[0].type === "app") {
          return true;
        } else {
          return false;
        }
      }
      
      function drawScienceAppDiv(target, pageX, pageY, data, savedId){
        consoleLog.debug(pageX + ", " + pageY);
        consoleLog.debug(data.scienceAppId);
        var wfId = savedId ? savedId : getGUID();
        var $wfDiv = $("<div class='waitingbox wf-box ui-selectee' id='"+wfId+"'><div class='wf-app-title' alt='"+data.text+"'>"+data.name
            +"</div><div class='addIp buttonwait wf-app-status'>Waiting</div></div>")
            .appendTo(target);
        $wfDiv.offset({top : pageY, left : pageX});
        currentJsPlumbInstance.draggable($wfDiv);
        return wfId;
      }
      
      function addScienceApp(target, pageX, pageY, data){
        var wfId = drawScienceAppDiv(target, pageX, pageY, data);
        var inputports = addScienceAppInputPort(wfId, data.scienceAppId);
        var outputports = addScienceAppOutputPort(wfId, data.scienceAppId);
        
        data["inputports"] = inputports;
        data["outputports"] = outputports;
        $("#" + wfId).data(data);
        //$("#" + wfId).on("contextmenu.jsplumb", jsplumbContextMenuCallback);
      }
      
      function addScienceAppInputPort(wfId, scienceAppId){
        var inputports = synchronousAjaxHelper.get("/delegate/services/app/"+scienceAppId+"/inputports");
        var inputportsJson = $.parseJSON(inputports);
        if(!$.isEmptyObject(inputportsJson)){
          var addEndPoint = prepareEndpoint(wfId, inputportsJson, true); 
          addEndPoint(currentJsPlumbInstance);
          return inputportsJson;
        }
      }
      
      function addScienceAppOutputPort(wfId, scienceAppId){
        var outputports = synchronousAjaxHelper.get("/delegate/services/app/"+scienceAppId+"/outputports");
        var outputportsJson = $.parseJSON(outputports);
        delete outputportsJson["temp"]; /* 중간 확인 포트 제거  */
        if(!$.isEmptyObject(outputportsJson)){
          var addEndPoint = prepareEndpoint(wfId, outputportsJson, false); 
          addEndPoint(currentJsPlumbInstance);
          return outputportsJson;
        }
      }
      
      function getPortsArrayFromPortJson(portJson, isInputPort){
        var portMap = new PortMap();
        portMap.setData(portJson, isInputPort);
        return portMap.getPortArray();
      }
      
      function prepareEndpoint(appDivId, portJson, isInputPort){
        var ports = getPortsArrayFromPortJson(portJson, isInputPort);
        var anchorUnit = getAnchorUnit(ports);
        function getAnchorUnit(ports){
          var anchorUnit = 0.7;
          if(ports && ports.length > 1){
            anchorUnit = anchorUnit / (ports.length-1);
          }
          return anchorUnit;
        }
        return function traversePortsAndAddEndPoint(jsPlumbInstance){
          var endPointType = isInputPort ? inputPortPoint : outputPortPoint;
          var defaultAnchor = isInputPort ? [0, 0.15, -1, 0]: [1, 0.15, 1, 0];
          $.each(ports, function(_, port){
            endPointType["scope"] = port.getPortTypeId();
            var labelLocation = 
              isInputPort
              ? [-1 * ((port["name"]+"").length/5.7), 0]
              : [((port["name"]+"").length/4.3) + 1, 1];
            var endPointGuid = appDivId + port.getName() + isInputPort;
            var endPoint = jsPlumbInstance.addEndpoint(
                appDivId, 
                {anchor: defaultAnchor, uuid: endPointGuid, 
                  overlays: [["Label", {label: isInputPort ? port["name"] :  port["file-name"], location:labelLocation}]]}, 
                endPointType);
            defaultAnchor[1] = defaultAnchor[1] + anchorUnit;
            endPoint.setParameter("data", port);
          });
        };
      }
      
      function removeSicenceApps($el){
        if(confirm(var_remove_app_confirm)){
          $el.each(function(_){
            var elId = $(this).attr("id");
            if(wfPortletGlobalData 
                && wfPortletGlobalData.hasOwnProperty('wfElements') 
                && wfPortletGlobalData["wfElements"].hasOwnProperty(elId)){
              delete wfPortletGlobalData["wfElements"][elId];
            }
            currentJsPlumbInstance.detachAllConnections(elId);
            currentJsPlumbInstance.removeAllEndpoints(elId);
            currentJsPlumbInstance.detach(elId);
          });
          $el.remove();
          return true;
        }else{
          return false;
        }
      }
      
      /** context menu **/
      $.contextMenu({
        selector : '.wf-box',
        build: function($trigger, e){
          var appData = $trigger.data();
          var cpuNumber = appData["cpuNumber"] ? appData["cpuNumber"] : ""+appData["defaultCpus"];
          var items = {
              items : {
                "open-info" : {
                  name: "App Information",
                  icon: "info",
                  callback: function(key, options){
                    var scienceAppId = appData["scienceAppId"];
                    openSolverDeatilPopup(scienceAppId);
                  }
                }
              }
            };
          if($(currentJsPlumbInstance.getContainer()).attr("id") == "wf-workflow-canvas"){
            if(appData["runType"] === "Parallel"){
              items["items"]["mpi-title"] = {
                  name: "MPI Setting",
                  icon: "edit",
                  disabled: true
              };
              items["items"]["mpi-input"] = {
                  name: "Cpu Number (scope : "+appData["defaultCpus"]+" ~ "+appData["maxCpus"]+")", 
                  type: 'text', 
                  value: cpuNumber, 
                  events: {
                    keyup: function(e) {
                      appData["cpuNumber"] = $(this).val();
                    }
                  }
              };
              items["items"]["sep1"] = "---------";
            }
            items["items"]["delete"] = {
                name : "Delete App",
                icon : "delete",
                callback: function(key, options){
                  if($(".ui-selected").length > 0){
                    currentJsPlumbInstance.removeFromPosse($(".wf-box"), "posse");
                    removeSicenceApps($(".ui-selected"));
                  }else{
                    removeSicenceApps($(this));
                  }
                }
            };
          }else if($(currentJsPlumbInstance.getContainer()).attr("id") == "running-workflow-canvas"){
            if(appData["workflowStatus"]["status"] === WF_STATUS_CODE.COMPLETED 
                || appData["workflowStatus"]["status"] === WF_STATUS_CODE.DONE){
              items["items"]["sep2"] = "---------";
              items["items"]["log"] = {
                  name : "Log",
                  icon : "log",
                  callback: function(key, options){
                    synchronousAjaxHelper.get("/delegate/services/workflows/instance/workflow/"
                        + appData["workflowStatus"]["workflowUuid"] +
                        "/simulation/"+ appData["workflowStatus"]["uuid"] +"/log", function(_){
                      openWorkflowSimulationLogPopup(_, "Log");
                    });
                  }
              };
              items["items"]["results"] = {
                  name : "Download results",
                  icon : "log",
                  callback: function(key, options){
                    var jobUuid = appData["workflowStatus"]["jobs"][0]["ibUuid"];
                    var groupId = appData["groupId"];
                    workflowAppResultDownload(jobUuid, groupId);
                  }
              };
            }else if(appData["workflowStatus"]["status"] === WF_STATUS_CODE.FAILED){
              items["items"]["sep2"] = "---------";
              items["items"]["log"] = {
                  name : "Error Log",
                  icon : "error",
                  callback: function(key, options){
                    synchronousAjaxHelper.get("/delegate/services/workflows/instance/workflow/"
                        + appData["workflowStatus"]["workflowUuid"] +
                        "/simulation/"+ appData["workflowStatus"]["uuid"] +"/errorlog", function(_){
                      openWorkflowSimulationLogPopup(_, "Error Log");
                    });
                  }
              };
              
            }
              
          }
          return items;
        }
      });
      /* resizable */
      $("#running-workflow-log").resizable({
        handles: 'n',
        maxHeight: 700,
        minHeight: 74});
      
      /** save & load Workflow**/
      function saveWorkflowDefinition(currentJsPlumbInstance){
        var wfData = {elements: [], connections: []};
        if(wfPortletGlobalData){
          wfData["wfPortletGlobalData"] = wfPortletGlobalData;
        }
        
        $(currentJsPlumbInstance.getContainer()).children(".wf-box").each(function(){
          var scienceAppClientId = $(this).attr("id");
          var thisData = jQuery.extend(true, {}, $(this).data()); /*deep copy*/
          delete thisData['selectableItem']; /* prevent converting circular structure error */
          if(thisData["inputports"] && wfPortletGlobalData){
            for(var key in thisData["inputports"]){
              if(wfPortletGlobalData["wfElements"][""+scienceAppClientId]){
                var inputValue = wfPortletGlobalData["wfElements"][""+scienceAppClientId][key];
                thisData["inputports"][key]["input-value"] = inputValue;
              }
            }
          }
          wfData.elements.push({
            id: scienceAppClientId,
            offset: $(this).offset(),
            data: thisData
          });
        });
        $.each(currentJsPlumbInstance.getAllConnections(), function(idx, connection) {
          consoleLog.debug(connection);
          wfData.connections.push({
            connectionId : connection.id,
            pageSourceId : connection.sourceId,
            pageTargetId : connection.targetId,
            sourceUuid : connection.endpoints[0].getUuid(),
            targetUuid : connection.endpoints[1].getUuid()
          });
        });
        consoleLog.debug("before saving!");
        consoleLog.debug(wfData);
        return wfData;
      }
      
      function loadWorkflowInstance(workflowInstanceId, currentJsPlumbInstance){
        resetCurrentJsPlumbInstance();
        var workflowInstance = synchronousAjaxHelper.get("/delegate/services/workflows/instance/"+ workflowInstanceId);
        $("#running-workflow .workflow-name-h2").text(workflowInstance["title"]);
        var wfData = $.parseJSON(workflowInstance["screenLogic"]);
        $.each(wfData.elements, function(i){
          loadScienceApp(this["id"], this["offset"], this["data"]);
        });
        $.each(wfData.connections, function(i){
          var sourceEndpointUuid = this["sourceUuid"];
          var targetEndpointUuid = this["targetUuid"];
          currentJsPlumbInstance.connect({uuids:[sourceEndpointUuid, targetEndpointUuid]});
        });
        if($(currentJsPlumbInstance.getContainer()).attr("id") == "running-workflow-canvas" && workflowInstanceId){
          updateWorkflowInstanceStatus(workflowInstanceId, 0);
          currentJsPlumbInstance.bind("dblclick", runningWorkflowJsPlumbInstanceDblClickCallback);
        }
      }
      
      function loadWorkflowDefinition(workflowId, currentJsPlumbInstance, workflowInstanceId){
        resetCurrentJsPlumbInstance();
        var workflow = synchronousAjaxHelper.get("/delegate/services/workflows/"+ workflowId);
        var wfData = $.parseJSON(workflow["screenLogic"]);
        if($(currentJsPlumbInstance.getContainer()).attr("id") == "wf-workflow-canvas"){
          $("#worfklow-definition-name").val(workflow["title"]);
          currentJsPlumbInstance.bind("dblclick", jsPlumbDblClickCallback);
          currentJsPlumbInstance.bind("connectionDetached", jsPlumbConnectionDetachedCallback);
          currentJsPlumbInstance.bind("connection", jsPlumbConnectionCallback);
        }
        $.each(wfData.elements, function(i){
          loadScienceApp(this["id"], this["offset"], this["data"]);
        });
        $.each(wfData.connections, function(i){
          var sourceEndpointUuid = this["sourceUuid"];
          var targetEndpointUuid = this["targetUuid"];
          currentJsPlumbInstance.connect({uuids:[sourceEndpointUuid, targetEndpointUuid]});
        });
        wfPortletGlobalData = wfData["wfPortletGlobalData"];
        if($(currentJsPlumbInstance.getContainer()).attr("id") == "running-workflow-canvas" && workflowInstanceId){
          updateWorkflowInstanceStatus(workflowInstanceId, 0);
        }
        return workflow;
      }
      
      function drawWorkflowInstanceStatus(workflowStatus){
        var simulations = workflowStatus.workflow.simulations;
        var currentCanvasId = "#running-workflow-canvas";
        if(!simulations.length || simulations.length <1){
          $("#running-workflow .wftitlebox001 .workflow-name-h2").text("");
          return false;
        }else{
          simulations.sort(function (a, b){
            if(!a.startTime || !b.startTime)
              return 1;  
            if(a.startTime > b.startTime)
              return 1;
            if(a.startTime < b.startTime)
              return -1;
            return 0; 
          });
          $("#running-workflow .wftitlebox001 .workflow-name-h2").text(workflowStatus.workflow.title);
        }
        var $logTbody = $("#running-workflow-log-tbody");
        $logTbody.children().remove();
        for(var i=0; i<simulations.length; i++){
          var clientId = currentCanvasId+" #"+simulations[i].clientId;
          var appData = $(clientId).data();
          appData["workflowStatus"] = simulations[i];
          appData["workflowStatus"]["workflowUuid"] = workflowStatus["workflow"]["uuid"]; 
          $(clientId).removeClass("waitingbox runningbox pausebox failbox donebox");
          if(simulations[i].status === WF_STATUS_CODE.CREATED){
            $(clientId).addClass("waitingbox");
            $(clientId + " .wf-app-status").text("Waiting");
          }else if(simulations[i].status === WF_STATUS_CODE.RUNNING){
            $(clientId).addClass("runningbox");
            $(clientId + " .wf-app-status").html("Running");
          }else if(simulations[i].status === WF_STATUS_CODE.PAUSED){
            $(clientId).addClass("pausebox");
            $(clientId + " .wf-app-status").html("Paused");
          }else if(simulations[i].status === WF_STATUS_CODE.CANCELED){
            $(clientId).addClass("failbox");
            $(clientId + " .wf-app-status").text("Canceled");
          }else if(simulations[i].status === WF_STATUS_CODE.FAILED){
            $(clientId).addClass("failbox");
            $(clientId + " .wf-app-status").text("Failed");
          }else if(simulations[i].status === WF_STATUS_CODE.COMPLETED 
              ||simulations[i].status === WF_STATUS_CODE.DONE){
            $(clientId).addClass("donebox");
            $(clientId + " .wf-app-status").text("Done");
          }else{
            $(clientId).addClass("waitingbox");
            $(clientId + " .wf-app-status").text("Waiting");
          }
          var $tr = $("<tr>").addClass("bgcolor");
          $tr.append($("<td>").addClass("pdleft20").text(simulations[i].title));
          if(simulations[i].status){
            $tr.append($("<td>").addClass("TC").text(WF_STATUS_CODE_STRING[simulations[i].status]));
          }else{
            $tr.append($("<td>").addClass("TC").text("Waiting"));
          }
          $tr.append($("<td>").addClass("TC").text(
              simulations[i].startTime
              ? $.format.date(new Date(simulations[i].startTime), "yyyy.MM.dd HH:mm:ss")
                  : ''));
          $tr.append($("<td>").addClass("TC").text(
              simulations[i].endTime
              ? $.format.date(new Date(simulations[i].endTime), "yyyy.MM.dd HH:mm:ss")
              : ''));
          //$tr.append($("<td>").addClass("TC").text(""));
          $logTbody.append($tr);
        }
      }
      
      function drawWorkflowInstanceJstree(instanceJstree, workflowInstanceId){
        $('#workflow-instance-list').jstree("destroy");
        $("#workflow-instance-list").jstree({
          "core": {
            "check_callback": function (operation, node, node_parent, node_position, more) {
              if(operation === 'move_node') {
                return false;
              }
              return true;
            },
            "data": instanceJstree
          },"search": {
            "case_sensitive": false,
            "show_only_matches" : true
          },
          "types" : {
            "root" : {},
            "workflow" : {},
            "instance" : {}
          },
          "plugins": ["types", "search"]
        }).bind("loaded.jstree", function (event, data) {
          $("#search-running-workflow-name-small").keyup(function(e){
            var searchString = $(this).val();
            $('#workflow-instance-list').jstree(true).search(searchString);
            $("#workflow-instance-list .jstree-node#"+workflowInstanceId).addClass("selected-jstree");
          });
          $('#workflow-instance-list').jstree(true).open_all();
          $("#workflow-instance-list > ul").scrollTop($("#workflow-instance-list .jstree-node#"+workflowInstanceId).offset().top - $("#workflow-instance-list > ul").offset().top);
          if($("#search-running-workflow-name-small").val()){
            $('#workflow-instance-list').jstree(true).search($("#search-running-workflow-name-small").val());
          }
          $("#workflow-instance-list .jstree-node#"+workflowInstanceId).addClass("selected-jstree");
        }).bind("refresh.jstree", function (event, data) {
        }).bind("select_node.jstree", function (event, data) {
          var nodeId = data.node.id;
          var node = data.node;
          if(node.type !== "instance"){
            if(!$("#" + nodeId).hasClass("jstree-open")){
              $("#workflow-instance-list").jstree("open_node", node);
            }
          }else if(node.type === "instance"){
            var workflowInstanceId = node["data"]["workflowInstanceId"];
            clearTimeout(workflowStatusTimer);
            loadWorkflowInstance(workflowInstanceId, currentJsPlumbInstance);
          }
        });
      }
      
      function updateWorkflowInstanceStatusImmediate(workflowInstanceId){
        synchronousAjaxHelper.get(
            "/delegate/services/workflows/instance/" + workflowInstanceId +"/siblings",
            function(instanceJstree){
              if(currentWorkflowInstanceId && currentWorkflowInstanceId == workflowInstanceId){
              }else{
                drawWorkflowInstanceJstree(instanceJstree, workflowInstanceId);
              }
            });
        currentWorkflowInstanceId = workflowInstanceId;
        updateWorkflowInstanceDiagram(workflowInstanceId);
      }
      
      function updateWorkflowInstanceDiagram(workflowInstanceId){
        return synchronousAjaxHelper.get(
            "/delegate/services/workflows/instance/" + workflowInstanceId +"/status",
            function(workflowStatus){
              drawWorkflowInstanceStatus(workflowStatus);
              drawRunningWorkflowsWithPaging(
                  $("#running-workflow-paging > ul > li.select").text(), 
                  "running-workflow");
              if(workflowStatus.workflow.status === WF_STATUS_CODE.COMPLETED){
                currentDoneWorkflowInstanceId = currentWorkflowInstanceId;
                currentWorkflowInstanceId = undefined;
                $("#wf-runing-pause-button").hide();
                $("#wf-runing-resume-button").hide();
              }else if(workflowStatus.workflow.status === WF_STATUS_CODE.PAUSED){
                $("#wf-runing-pause-button").hide();
                $("#wf-runing-resume-button").show();
              }else if(workflowStatus.workflow.status === WF_STATUS_CODE.RUNNING 
                  ||workflowStatus.workflow.status === WF_STATUS_CODE.CREATED){
                $("#wf-runing-pause-button").show();
                $("#wf-runing-resume-button").hide();
                updateWorkflowInstanceStatus(workflowInstanceId, 3000);
              }
        });
      }
      
      function updateWorkflowInstanceStatus(workflowInstanceId, interval){
        clearTimeout(workflowStatusTimer);
        workflowStatusTimer = setTimeout(function(){
          updateWorkflowInstanceStatusImmediate(workflowInstanceId);
        }, interval);
      }
      
      function copyWorkflowDefinition(workflowId, currentJsPlumbInstance){
        resetCurrentJsPlumbInstance();
        var workflow = synchronousAjaxHelper
          .jsonPost("/delegate/services/workflows/"+ workflowId + "/copy", {}, function(_){
            drawPublicWorkflows(loadPublicWorkflows());
          drawMyWorkflows(loadMyWorkflows());
          });
        var wfData = $.parseJSON(workflow["screenLogic"]);
        if($(currentJsPlumbInstance.getContainer()).attr("id") == "wf-workflow-canvas"){
          $("#worfklow-definition-name").val(workflow["title"]);
        }
        
        $.each(wfData.elements, function(i){
          loadScienceApp(this["id"], this["offset"], this["data"]);
        });
        $.each(wfData.connections, function(i){
          var sourceEndpointUuid = this["sourceUuid"];
          var targetEndpointUuid = this["targetUuid"];
          currentJsPlumbInstance.connect({uuids:[sourceEndpointUuid, targetEndpointUuid]});
        });
        return workflow;
      }
      
      function loadScienceAppPort(wfId, portJson, isInputPort){
        var addEndPoint = prepareEndpoint(wfId, portJson, isInputPort); 
        addEndPoint(currentJsPlumbInstance);
      }
      
      function loadScienceApp(id, offset, data){
        var wfId = drawScienceAppDiv($(currentJsPlumbInstance.getContainer()), offset.left, offset.top, data, id);
        var conainerId = $(currentJsPlumbInstance.getContainer()).attr("id");
        loadScienceAppPort(wfId, data.inputports, true);
        loadScienceAppPort(wfId, data.outputports, false);
        $("#"+conainerId + " #" + wfId).data(data);
      }
      
      /** selectable **/
      $("#wf-workflow-canvas").click(function(e){
        if($(".ui-selected").length > 0){
          currentJsPlumbInstance.removeFromPosse($(".wf-box"), "posse");
        }
        if($(e.target).hasClass("wf-box") && $(e.target).hasClass("ui-selectee")){
          /*currentJsPlumbInstance.addToPosse($(e.target), "posse");*/
        }else{
          /*$(".wf-box").removeClass("ui-selected");
          $(e.target).addClass("ui-selected");
          $(".wf-box").each(function(_){
            currentJsPlumbInstance.removeFromPosse($(this), "posse");
          });*/
        }
      });
      
      $("#wf-workflow-canvas").selectable({
        filter: ".wf-box",
        selected: function(event, ui){
          $(ui.selected).each(function(_){
            currentJsPlumbInstance.addToPosse($(this), "posse");
          });
        },
        unselected: function(event, ui){
          $(ui.unselected).each(function(_){
            currentJsPlumbInstance.removeFromPosse($(this), "posse");
          });
        }
      });
      
      $(document).keydown(function (event) {
        if(event.which === 46 && $(".ui-selected").length > 0){
          currentJsPlumbInstance.removeFromPosse($(".wf-box"), "posse");
          removeSicenceApps($(".ui-selected"))
        }
      });
      
      /**button click event handler**/
      function resetCurrentJsPlumbInstance(){
        currentJsPlumbInstance.reset();
        $(currentJsPlumbInstance.getContainer()).children(".wf-box").remove();
      }
      function resetModifyingWorkflow(){
        resetCurrentJsPlumbInstance();
        currentJsPlumbInstance.bind("dblclick", jsPlumbDblClickCallback);
        currentJsPlumbInstance.bind("connectionDetached", jsPlumbConnectionDetachedCallback);
        currentJsPlumbInstance.bind("connection", jsPlumbConnectionCallback);
        $("#science-app #worfklow-definition-name").val("");
        wfPortletGlobalData = {wfElements : {}};
        modifyingWorkflow = undefined;
      }
     
      $("#wf-new-button").click(function(e){
        e.preventDefault();
        if(confirm(var_new_workflow_confirm_message)){
          resetModifyingWorkflow()
        }
      });
      $("#wf-remove-button").click(function(e){
        e.preventDefault();
        if(!modifyingWorkflow){
          //alert(var_prepare_remove_workflow_message);
          $("#science-app > .alert").removeClass("alert-success alert-error").addClass("alert-error").text(var_prepare_remove_workflow_message);
          $("#science-app > .alert").fadeIn(100, function(_){$("#science-app > .alert").fadeOut(2000);});
          return false;
        }
        if(confirm(var_remove_workflow_confirm_message)){
          var localWorkflow = modifyingWorkflow;
          var removedWf = synchronousAjaxHelper.jsonPost("/delegate/services/workflows/"
              + localWorkflow["workflowId"]  +"/delete", {}, function(_){
                drawPublicWorkflows(loadPublicWorkflows());
                drawMyWorkflows(loadMyWorkflows());
                $("#science-app > .alert").removeClass("alert-success alert-error")
                  .addClass("alert-success").text(var_success_remove_workflow_message);
                $("#science-app > .alert").fadeIn(100, function(_){$("#science-app > .alert").fadeOut(2000);});
              });
          resetModifyingWorkflow()
          consoleLog.debug("removed");
          consoleLog.debug(removedWf);
        }
      });
      
      $("#workflow-instance-dialog").dialog({
        autoOpen: false,
        width: '700',
        height: '200',
        modal: true,
        resizable: false,
        show: {effect:'fade', speed: 800}, 
        hide: {effect:'fade', speed: 800},
        draggable: false,
        open: function(event, ui) {
            $(this).removeClass("ui-widget-content");
            $(this).parent().removeClass("ui-widget-content");
            $(this).parent().css('overflow','visible');
            
            $("body").css('overflow','hidden');
            $("#workflow-instance-dialog-close-btn").bind('click',function(){
              $("#workflow-instance-dialog").dialog("close");
            });
            $('.ui-widget-overlay').bind('click',function(){
              $("#workflow-instance-dialog").dialog("close");
            })
          },
          close: function() {
            $("body").css('overflow','');
          }
      }).dialog("widget").find(".ui-dialog-titlebar").remove();
      
      $("#workflow-instance-run").click(function(e){
        e.preventDefault();
        if($("#workflow-instance-name-input").val()){
          var localWorkflow = modifyingWorkflow;
          var postData = getIcebreakerAccessToken();
          postData["workflowInstanceTitle"] = $("#workflow-instance-name-input").val();
          var workflowRquestJson = synchronousAjaxHelper.post(
              "/delegate/services/workflows/"+localWorkflow["workflowId"]+"/run", postData, 
              function(workflowInstance){
                controlTab($("#my-workflow .running-workflow"));
                $("#running-workflow > .alert").removeClass("alert-success alert-error").addClass("alert-success").text(var_success_run_workflow_message);
                $("#running-workflow > .alert").fadeIn(100, function(_){$("#running-workflow > .alert").fadeOut(2000);});
                if(workflowInstance){
                  loadWorkflowInstance(workflowInstance["workflowInstanceId"], currentJsPlumbInstance);
                }
              });
          consoleLog.debug(localWorkflow);
          consoleLog.debug(workflowRquestJson);
          $("#workflow-instance-dialog").dialog("close");
        }else{
          $("#workflow-instance-name-input").attr("placeholder", var_validation_required_message);
          $("#workflow-instance-name-input").addClass("form-validation-error");
          $("#workflow-instance-name-input").focus();
          $("#workflow-instance-name-input").on("focusout.wfname input.wfname", function(){
            if($(this).hasClass("form-validation-error")){
              $(this).removeClass("form-validation-error");
              $(this).removeAttr("placeholder");
            }
            $(this).off("focusout.wfname input.wfname");
          });
        }
      });
      
      $("#wf-conf-button").click(function(e){
        // TODO : config popup
        if(!modifyingWorkflow || !modifyingWorkflow["workflowId"]){
          alert(var_conf_workflow_empty_err_message);
          return false;
        }
        openWorkflowConfigPopup(synchronousAjaxHelper.get("/delegate/services/workflows/"+ modifyingWorkflow["workflowId"]));
      });
      $("#wf-run-button").click(function(e){
        e.preventDefault();
        if(!$("#wf-workflow-canvas .wf-box") || $("#wf-workflow-canvas .wf-box").length === 0){
          alert(var_run_workflow_empty_err_message);
          return false;
        }
        else if(!saveOrUpdateWorkflowDefinition(true)){
          $("#science-app > .alert").removeClass("alert-success alert-error").addClass("alert-error").text(var_prepare_copy_workflow_message);
          $("#science-app > .alert").fadeIn(100, function(_){$("#science-app > .alert").fadeOut(2000);});
          return false;
        }
        else{
          $("#workflow-instance-dialog").dialog("open");
        }
      });
      
      function saveOrUpdateWorkflowDefinition(backgroudSave){
        var result;
        var localWorkflow = modifyingWorkflow;
        var title = $("#science-app #worfklow-definition-name").val();
        var wfData = saveWorkflowDefinition(currentJsPlumbInstance);
        
        /* validation */
        if(!title || title === "" || title.trim() === ""){
          if(!$("#science-app #worfklow-definition-name").hasClass("form-validation-error")){
            $("#science-app #worfklow-definition-name").attr("placeholder", var_validation_required_message);
            $("#science-app #worfklow-definition-name").addClass("form-validation-error");
            $("#science-app #worfklow-definition-name").focus();
            $("#science-app #worfklow-definition-name").on("focusout.wf input.wf" , function(){
              if($(this).hasClass("form-validation-error")){
                $(this).removeClass("form-validation-error");
                $(this).removeAttr("placeholder");
              }
              $(this).off("focusout.wf input.wf");
            });
          }
          return false;
        }
        var wfDataJsonString = JSON.stringify(wfData);
        if(localWorkflow){
          localWorkflow["title"] =  title;
          localWorkflow["screenLogic"] =  wfDataJsonString;
          consoleLog.debug(localWorkflow);
          modifyingWorkflow = synchronousAjaxHelper.jsonPost("/delegate/services/workflows/"
              + localWorkflow["workflowId"]  +"/update", JSON.stringify(localWorkflow), function(_){
                drawPublicWorkflows(loadPublicWorkflows(""));
                drawMyWorkflows(loadMyWorkflows(""));
                if(!backgroudSave){
                  $("#science-app > .alert").removeClass("alert-success alert-error").addClass("alert-success").text(var_save_success_message);
                  $("#science-app > .alert").fadeIn(100, function(_){$("#science-app > .alert").fadeOut(2000);});
                }
              });
          consoleLog.debug(modifyingWorkflow);
        }else{
          modifyingWorkflow = synchronousAjaxHelper
          .post("/delegate/services/workflows/add", { 
            title: title,
            screenLogic: wfDataJsonString 
          }, function(_){
            drawPublicWorkflows(loadPublicWorkflows(""));
            drawMyWorkflows(loadMyWorkflows(""));
            /*alert-error*/
            if(!backgroudSave){
              $("#science-app > .alert").removeClass("alert-success alert-error").addClass("alert-success").text(var_save_success_message);
              $("#science-app > .alert").fadeIn(100, function(_){$("#science-app > .alert").fadeOut(2000);});
            }
          });
        }
        consoleLog.debug(modifyingWorkflow ? $.parseJSON(modifyingWorkflow["screenLogic"]) : "result is empty");
        if(modifyingWorkflow){
          return true;
        }else{
          return false;
        }
      }
      
      $("#wf-list-refresh-button").click(function(e){
        e.preventDefault();
        drawMyWorkflows(loadMyWorkflows());
        drawPublicWorkflows(loadPublicWorkflows());
      });
      
      $("#wf-save-button").click(function(e){
        e.preventDefault();
        saveOrUpdateWorkflowDefinition();
      });
      
      $("#wf-copy-button").click(function(e){
        e.preventDefault();
        if(!modifyingWorkflow){
          //alert(var_prepare_copy_workflow_message);
          $("#science-app > .alert").removeClass("alert-success alert-error").addClass("alert-error").text(var_prepare_copy_workflow_message);
          $("#science-app > .alert").fadeIn(100, function(_){$("#science-app > .alert").fadeOut(2000);});
          return false;
        }
        var currentWorkflowId = modifyingWorkflow["workflowId"];
        modifyingWorkflow = copyWorkflowDefinition(currentWorkflowId, currentJsPlumbInstance);
        $("#science-app > .alert").removeClass("alert-success alert-error").addClass("alert-success").text(var_success_copy_workflow_message);
        $("#science-app > .alert").fadeIn(100, function(_){$("#science-app > .alert").fadeOut(2000);});
      });
      
      $(".wf-container").each(function(){
        (function(tabId){
          $("#" + tabId + " .wf-slide-toggle").click(function(e){
            e.preventDefault();
            $("#" + tabId + " .wfconwrap").animate({width: "toggle"}, 500);
            $("#" + tabId + " .leftwrap").animate({width: "toggle"}, 500);
            $("#" + tabId + " .rightwrap").animate({width: "toggle"},500);
            $("#" + tabId + " #running-workflow-log").toggle();
          });
        })($(this).attr("id"));
      });
      
      /* draw workflow list */
      function drawWorkflowDiv(workflowsMap, wfContainderId){
        var workflows = workflowsMap["workflows"];
        $("#" + wfContainderId + " .workflow-list-div").children().remove();
        if(workflows && workflows.length > 0){
          if(workflowsMap["curPage"] > 1){
            var $aTag = $("<a>").text("Previous");
            var div = $("<div>")
            .addClass("workflowRow listbox navigation").append($("<ul>").append($("<li>").append($aTag)));
            div.click(function(e){
              e.preventDefault();
              if(wfContainderId === "my-workflow"){
                drawMyWorkflowsWithPaging(Number(workflowsMap["curPage"])-1);
              }else{
                drawPublicWorkflowsWithPaging(Number(workflowsMap["curPage"])-1);
              }
            });
            $("#" + wfContainderId + " .workflow-list-div").append(div);
          }
          $.each(workflows, function(i){
            var onRowClass = "st-" +workflows[i]["workflowId"];
            var div = $("<div>")
              .addClass("workflowRow listbox " + onRowClass);
            var ul = $("<ul>");
            var parentTitle = workflows[i]["parentTitle"];
            var createDate = $.format.date(new Date(workflows[i]["createDate"]), "yyyy.MM.dd HH:mm");
            parentTitle = parentTitle ? parentTitle : "";
            ul.append($("<li>")
                .append($("<a>").text(workflows[i]["title"])));
            ul.append($("<li>").addClass("date")
                .append($("<span>").text(workflows[i]["screenName"]))
                .append(createDate));
            div.append(ul);
            div.click(function(e){
              e.preventDefault();
              $("#" + wfContainderId + " .workflow-name-h2").text(workflows[i]["title"]);
              $("#" + wfContainderId + " .workflow-list-div").children(".listbox").removeClass("on");
              $("#" + wfContainderId + " .workflowRow").removeClass("on");
              $("#" + wfContainderId + " ." + onRowClass).addClass("on");
              loadWorkflowDefinition(workflows[i]["workflowId"], currentJsPlumbInstance);
            });
            $("#" + wfContainderId + " .workflow-list-div").append(div);
          });
          consoleLog.debug(workflowsMap["curPage"] , workflowsMap["totalPage"]);
          if(workflowsMap["curPage"] < workflowsMap["totalPage"]){
            var $aTag = $("<a>").text("Next");
            var div = $("<div>")
            .addClass("workflowRow listbox navigation").append($("<ul>").append($("<li>").append($aTag)));
            div.click(function(e){
              e.preventDefault();
              if(wfContainderId === "my-workflow"){
                drawMyWorkflowsWithPaging(Number(workflowsMap["curPage"])+1);
              }else{
                drawPublicWorkflowsWithPaging(Number(workflowsMap["curPage"])+1);
              }
            });
            $("#" + wfContainderId + " .workflow-list-div").append(div);
          }
        }else{
          $("#" + wfContainderId +" .workflow-list-div")
            .append($("<span>").text(var_data_empty_message));
        }
      }
      function drawWorkflowTable(workflowsMap, wfContainderId){
        var workflows = workflowsMap["workflows"];
        $("#" + wfContainderId + " .workflow-list-tbody").children().remove();
        $("#" + wfContainderId + " .paging").children().remove();
        if(workflows && workflows.length > 0){
          $.each(workflows, function(i){
            var onRowClass = "st-" +workflows[i]["workflowId"];
            var tr = $("<tr>")
              .addClass("workflowRow bgcolor " + onRowClass)
              .attr("id", workflows[i]["workflowId"]);
            var parentTitle = workflows[i]["parentTitle"];
            var createDate = $.format.date(new Date(workflows[i]["createDate"]), "yyyy.MM.dd HH:mm");
            parentTitle = parentTitle ? parentTitle : "";
            var titleTd = $("<td>").addClass("pdleft20 titleTd").text(workflows[i]["title"]);
            tr.append(titleTd);
            tr.append($("<td>").addClass("pdleft20").text(workflows[i]["description"]));
            tr.append($("<td>").addClass("TC").text(workflows[i]["screenName"]));
            tr.append($("<td>").addClass("TC").text(parentTitle));
            tr.append($("<td>").addClass("TC").text(createDate));
            tr.append($("<td>").addClass("TC").text(workflows[i]["isPublic"] == true || workflows[i]["isPublic"] == "true" ? "Y" : "N" ));
            titleTd.click(function(e){
              e.preventDefault();
              $("#" + wfContainderId + " .workflow-name-h2").text(workflows[i]["title"]);
              $("#" + wfContainderId + " .workflowRow").removeClass("on");
              $("#" + wfContainderId + " ." + onRowClass).addClass("on");
              slideClosure.set(workflows[i]["workflowId"], currentJsPlumbInstance);
              e.preventDefault();
              $("#" + wfContainderId + " .wfconwrap").animate({width: "toggle"}, 500);
              $("#" + wfContainderId + " .leftwrap").animate({width: "toggle"}, 500);
              $("#" + wfContainderId + " .rightwrap").animate({width: "toggle"}, {
                duration:500,
                complete: function(){
                  slideClosure.run(loadWorkflowDefinition);
                  slideClosure.reset();
                }
              });
            });
            $("#" + wfContainderId + " .workflow-list-tbody").append(tr);
          });
          var $paging = $(workflowsMap["pagingHtml"]);
          $paging.find("img").each(function(_){
            $(this).attr("src", contextPath + $(this).attr("src"));
          });
          $paging.find("a").each(function(_){
            var pagenum = $(this).attr("pagenum");
            $(this).click(function(e){
              e.preventDefault();
              if(wfContainderId === "my-workflow"){
                drawMyWorkflowsWithPaging(pagenum);
              }else{
                drawPublicWorkflowsWithPaging(pagenum);
              }
            });
          });
          $("#" + wfContainderId + " .paging").append($paging);
        }else{
          $("#" + wfContainderId + " .workflow-list-tbody")
            .html("<tr><td class='TC' colspan='6'>"+var_data_empty_message+"</td></tr>");
        }
      }
      
      /* my-workflow */
      function drawMyWorkflowsWithPaging(p_curPage){
        drawMyWorkflows(loadMyWorkflows(p_curPage));
      }
      
      function loadWorkflowList(searchKeyword, p_curPage, linePerPage, isPublic){
        consoleLog.debug("loadWorkflows");
        var url = "/delegate/services/workflows" ;
        var params = {};
        if(searchKeyword || searchKeyword === 0){
          params["title"] = searchKeyword;
        }
        if(p_curPage){
          params["p_curPage"] = p_curPage;
        }
        if(linePerPage){
          params["linePerPage"] = linePerPage;
        }
        if(isPublic){
          params["isPublic"] = "true";
          params["pagingClassName"] = "public-workflow-paging";
        }else{
          params["pagingClassName"] = "my-workflow-paging";
        }
        var result = synchronousAjaxHelper.post(url, params);
        return result;
      }
      
      function loadMyWorkflows(p_curPage){
        var searchKeyword = $("input[name='search-my-workflow-name']:visible").val();
        var linePerPage = $("#my-workflow-line-per-page").val();
        var result = loadWorkflowList(searchKeyword, p_curPage, linePerPage, false);
        return result;
      }
      
      function drawMyWorkflows(myWorkflows){
        drawWorkflowTable(myWorkflows, "my-workflow")
        drawWorkflowDiv(myWorkflows, "my-workflow")
      }
      $("#search-my-workflow-name-small-btn").click(function(e){
        drawMyWorkflows(loadMyWorkflows());
      });
      $("#search-my-workflow-name-large-btn").click(function(e){
        drawMyWorkflows(loadMyWorkflows());
      });
      $("input[name='search-my-workflow-name']").change(function(e){
        var searchKeyword = $("input[name='search-my-workflow-name']:visible").val();
        $("input[name='search-my-workflow-name']").val(searchKeyword);
      });
      $("input[name='search-my-workflow-name']").on("keydown", function(e){
        if(e.which == 13){
          drawMyWorkflows(loadMyWorkflows());
        }
      });
      $("#wf-modify-button").click(function(e){
        e.preventDefault();
        var currentWorkflowId = $("#my-workflow .workflowRow.bgcolor.on").attr("id");
        controlTab($("#my-workflow .science-app"));
        modifyingWorkflow = loadWorkflowDefinition(currentWorkflowId, currentJsPlumbInstance);
      });
      $("#wf-my-copy-button").click(function(e){
        e.preventDefault();
        var currentWorkflowId = $("#my-workflow .workflowRow.bgcolor.on").attr("id");
        controlTab($("#my-workflow .science-app"));
        modifyingWorkflow = copyWorkflowDefinition(currentWorkflowId, currentJsPlumbInstance);
        $("#science-app > .alert").removeClass("alert-success alert-error").addClass("alert-success").text(var_success_copy_workflow_message);
        $("#science-app > .alert").fadeIn(100, function(_){$("#science-app > .alert").fadeOut(2000);});
      });
      
      /* public-workflow */
      function drawPublicWorkflowsWithPaging(p_curPage){
        drawPublicWorkflows(loadPublicWorkflows(p_curPage));
      }
      
      function loadPublicWorkflows(searchKeyword, p_curPage, linePerPage){
        var searchKeyword = $("input[name='search-public-workflow-name']:visible").val();
        var linePerPage = $("#public-workflow-line-per-page").val();
        var result = loadWorkflowList(searchKeyword, p_curPage, linePerPage, true);
        return result;
      }
      
      function drawPublicWorkflows(publicWorkflows){
        drawWorkflowTable(publicWorkflows, "public-workflow")
        drawWorkflowDiv(publicWorkflows, "public-workflow")
      }
      $("#search-public-workflow-name-small-btn").click(function(e){
        drawPublicWorkflows(loadPublicWorkflows());
      });
      $("#search-public-workflow-name-large-btn").click(function(e){
        drawPublicWorkflows(loadPublicWorkflows());
      });
      $("input[name='search-public-workflow-name']").change(function(e){
        var searchKeyword = $("input[name='search-public-workflow-name']:visible").val();
        $("input[name='search-public-workflow-name']").val(searchKeyword);
      });
      $("input[name='search-public-workflow-name']").on("keydown", function(e){
        if(e.which == 13){
          drawPublicWorkflows(loadPublicWorkflows());
        }
      });
      $("#wf-public-copy-button").click(function(e){
        e.preventDefault();
        var currentWorkflowId = $("#public-workflow .workflowRow.bgcolor.on").attr("id");
        controlTab($("#public-workflow .science-app"));
        modifyingWorkflow = copyWorkflowDefinition(currentWorkflowId, currentJsPlumbInstance);
        $("#science-app > .alert").removeClass("alert-success alert-error").addClass("alert-success").text(var_success_copy_workflow_message);
        $("#science-app > .alert").fadeIn(100, function(_){$("#science-app > .alert").fadeOut(2000);});
      });
      
      /** Tab 제어 **/
      function controlTab($tab){
        if(!$tab.hasClass("on")){
          $(".lefttabm > ul > li.on").removeClass("on");
          var thisTabClass = $tab.attr("class");
          switch(thisTabClass){
          case "science-app":
            clearTimeout(workflowStatusTimer);
            currentJsPlumbInstance = wfWorkflowJsPlumbInstance;
            break;
          case "running-workflow":
            if(currentWorkflowInstanceId){
              updateWorkflowInstanceStatus(currentWorkflowInstanceId, 0);
            }
            currentJsPlumbInstance = runningWorkflowJsPlumbInstance;
            break;
          case "my-workflow":
            clearTimeout(workflowStatusTimer);
            currentJsPlumbInstance = myWorkflowJsPlumbInstance;
            break;
          case "public-workflow":
            clearTimeout(workflowStatusTimer);
            currentJsPlumbInstance = publicWorkflowJsPlumbInstance;
            break;
          }
          
          $("." + thisTabClass).addClass("on");
          $(".wf-container").each(function(i){
            if($(this).attr("id") === thisTabClass){
              $(this).removeClass("hidden");
            }else if(!$(this).hasClass("hidden")){
              $(this).addClass("hidden");
            }
          });
        }
      }
      $(".lefttabm > ul > li").click(function(e){
        e.preventDefault();
        controlTab($(this));
      });
      
      // TODO : draw running worklfow list
      $("#wf-runing-pause-button").click(function(e){
        e.preventDefault();
        var workflowInstanceId = currentWorkflowInstanceId;
        if(currentWorkflowInstanceId){
          synchronousAjaxHelper.post(
              "/delegate/services/workflows/instance/"+workflowInstanceId+"/pause", {}, 
              function(_){
                updateWorkflowInstanceStatus(workflowInstanceId, 0);
              });
        }
      });
      $("#wf-runing-resume-button").click(function(e){
        e.preventDefault();
        var workflowInstanceId = currentWorkflowInstanceId;
        if(currentWorkflowInstanceId){
          synchronousAjaxHelper.post(
              "/delegate/services/workflows/instance/"+workflowInstanceId+"/resume", {}, 
              function(_){
                updateWorkflowInstanceStatus(workflowInstanceId, 0);
              });
        }
      });
      $("#wf-runing-remove-button").click(function(e){
        e.preventDefault();
        if(confirm(var_confirm_romove_workflow_instance_message)){
          clearTimeout(workflowStatusTimer);
          var workflowInstanceId = currentWorkflowInstanceId;
          if(!workflowInstanceId){
            workflowInstanceId = currentDoneWorkflowInstanceId;
          }
          if(workflowInstanceId){
            synchronousAjaxHelper.post(
                "/delegate/services/workflows/instance/"+workflowInstanceId+"/delete", {}, 
                function(_){
                  currentWorkflowInstanceId = undefined;
                  resetCurrentJsPlumbInstance();
                  $('#workflow-instance-list').jstree("destroy");
                  $("#running-workflow .workflow-name-h2").text("");
                  $("#running-workflow-log-tbody").children().remove();
                  drawRunningWorkflows();
                  if($("#running-workflow" + " #running-workflow-log").is(":visible")){
                    $("#running-workflow" + " .wfconwrap").animate({width: "toggle"}, 500);
                    $("#running-workflow" + " .leftwrap").animate({width: "toggle"}, 500);
                    $("#running-workflow" + " .rightwrap").animate({width: "toggle"},500);
                    $("#running-workflow" + " #running-workflow-log").toggle();
                  }
                });
          }
        }else{
        }
      });
      
      $("#search-running-workflow-name-large-btn").click(function(e){
        e.preventDefault();
        drawRunningWorkflows();
      });
      $("input[name='search-running-workflow-name']").change(function(e){
        var searchKeyword = $("input[name='search-running-workflow-name']:visible").val();
        $("input[name='search-running-workflow-name']").val(searchKeyword);
      });
      $("input[name='search-running-workflow-name']").on("keydown", function(e){
        if(e.which == 13){
          drawRunningWorkflows();
        }
      });
      
      function drawRunningWorkflowsWithPaging(p_curPage){
        drawRunningWorkflowTable(loadRunningWorkflows(p_curPage), "running-workflow");
      }
      function drawRunningWorkflows(){
        drawRunningWorkflowTable(loadRunningWorkflows(), "running-workflow");
      }
      
      function loadRunnigWorkflowList(searchKeyword, p_curPage, linePerPage, status){
        return getWorkflowInstances(searchKeyword, p_curPage, linePerPage, status);
      }
      
      function loadRunningWorkflows(p_curPage){
        var searchKeyword = $("input[name='search-running-workflow-name']:visible").val();
        var linePerPage = $("#running-workflow-line-per-page").val();
        var status = $("#running-workflow-search-status").val();
        var result = loadRunnigWorkflowList(searchKeyword, p_curPage, linePerPage, status);
        return result;
      }
      
      function drawRunningWorkflowTable(workflowInstancesMap, wfContainderId){
        var workflowInstances = workflowInstancesMap["workflowInstances"];
        $("#" + wfContainderId + " .workflow-list-tbody").children().remove();
        $("#" + wfContainderId + " .paging").children().remove();
        if(workflowInstances && workflowInstances.length > 0){
          $.each(workflowInstances, function(i){
            var onRowClass = "st-" +workflowInstances[i]["workflowInstanceId"];
            var tr = $("<tr>")
              .addClass("workflowRow bgcolor " + onRowClass)
              .attr("id", workflowInstances[i]["workflowInstanceId"]);
            var startTime = $.format.date(new Date(workflowInstances[i]["startTime"]), "yyyy.MM.dd HH:mm");
            var endTime = workflowInstances[i]["endTime"] ? $.format.date(new Date(workflowInstances[i]["endTime"]), "yyyy.MM.dd HH:mm") : "";
            var titleTd = $("<td>").addClass("pdleft20 titleTd").text(workflowInstances[i]["title"]);
            tr.append(titleTd);
            tr.append($("<td>").addClass("pdleft20").text(workflowInstances[i]["workflowTitle"]));
            tr.append($("<td>").addClass("TC").text(workflowInstances[i]["screenName"]));
            tr.append($("<td>").addClass("TC").text(workflowInstances[i]["status"]));
            tr.append($("<td>").addClass("TC").text(startTime));
            tr.append($("<td>").addClass("TC").text(endTime));
            titleTd.click(function(e){
              e.preventDefault();
              $("#" + wfContainderId + " .workflowRow").removeClass("on");
              $("#" + wfContainderId + " ." + onRowClass).addClass("on");
              slideClosure.set(workflowInstances[i]["workflowInstanceId"], currentJsPlumbInstance);
              e.preventDefault();
              $("#" + wfContainderId + " .wfconwrap").animate({width: "toggle"}, 500);
              $("#" + wfContainderId + " .leftwrap").animate({width: "toggle"}, 500);
              $("#" + wfContainderId + " .rightwrap").animate({width: "toggle"}, {
                duration:500,
                complete: function(){
                  $("#" + wfContainderId + " #running-workflow-log").toggle();
                  slideClosure.run(loadWorkflowInstance);
                  slideClosure.reset();
                }
              });
            });
            if(currentWorkflowInstanceId && currentWorkflowInstanceId == workflowInstances[i]["workflowInstanceId"]){
              tr.addClass("on");
            }
            $("#" + wfContainderId + " .workflow-list-tbody").append(tr);
          });
          var $paging = $(workflowInstancesMap["pagingHtml"]);
          $paging.find("img").each(function(_){
            $(this).attr("src", contextPath + $(this).attr("src"));
          });
          $paging.find("a").each(function(_){
            var pagenum = $(this).attr("pagenum");
            $(this).click(function(e){
              e.preventDefault();
              drawRunningWorkflowsWithPaging(pagenum);
            });
          });
          $("#" + wfContainderId + " .paging").append($paging);
        }else{
          $("#" + wfContainderId + " .workflow-list-tbody")
            .html("<tr><td class='TC' colspan='6'>"+var_data_empty_message+"</td></tr>");
        }
      }
      
      /** document ready batch**/
      drawMyWorkflows(loadMyWorkflows());
      drawPublicWorkflows(loadPublicWorkflows());
      drawRunningWorkflows();
    });
  }
  
});