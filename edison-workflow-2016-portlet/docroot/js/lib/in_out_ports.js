var PortConstants = {
    NAME : 'name',
    MANDATORY : 'mandatory',
    PORT_TYPE_ID : 'port-type-id',
    PORT_TYPE_NAME : 'port-type-name',
    DEFAULT_EDITOR_ID : 'default-editor-id',
    DEFAULT_ANALYZER_ID : 'default-analyzer-id',
    ORDER : 'order',
    FILE_NAME : 'file-name',
    CONTAINER : 'container',
    UNDEFINED : 'undefined',
    INPUTDECKPORTTYPE : 'inputdeckporttype',
  
  FORM_FILE : 'file',
  FORM_FOLDER : 'folder',
  FORM_EXTENSION : 'extention',
  
  INPUT_FORM : 'form',
  OUTPUT_FORM : 'form',
  
  getDefinedDataForms : function(){
    var form = [];
    form.push(this.FORM_FILE);
    form.push(this.FORM_FOLDER);
    form.push(this.FORM_EXTENSION);
    
    return form;
  }
  };
  
  var PortErrors = {
    INVALID_PORT_NAME : 'invalid-port-name',
    DUPLICATED_PORT_NAME : 'duplicated-port-name',
  };

  function Port(){
    this.getName = function(){
      return this[PortConstants.NAME];
    };
    this.setName = function(name){
      var verified = this.verifyPortName(name);
      if( verified != true )
        return verified;
      this[PortConstants.NAME] = name;
      return true;
    };
    this.isMandatory = function(){
      return this[PortConstants.MANDATORY];
    };
    this.setMandatory = function(flag){
      this[PortConstants.MANDATORY]=flag;
    };
    this.getPortTypeId = function(){
      return this[PortConstants.PORT_TYPE_ID];
    };
    this.setPortTypeId = function(id){
      this[PortConstants.PORT_TYPE_ID] = id;
    };
    this.getPortTypeName = function(){
      return this[PortConstants.PORT_TYPE_NAME];
    };
    this.setPortTypeName = function(name){
      this[PortConstants.PORT_TYPE_NAME] = name;
    };
    this.getInputDeckPortType = function(){
      return this[PortConstants.INPUTDECKPORTTYPE];
    };
    this.setInputDeckPortType = function(type){
      this[PortConstants.INPUTDECKPORTTYPE] = type;
    };
    this.isInputDeckPortType = function(){
      return this[PortConstants.INPUTDECKPORTTYPE];
    };
    this.isCompatible = function(portTypeid){
      if( this.getPortTypeId() == portTypeid )
        return true;
      else
        return false;
    };
    this.verifyPortName = function(name){
      if(!/^[-|_]?[a-zA-Z0-9_]+$/.test(name))  return PortErrors.INVALID_PORT_NAME;
      else  return true;
    };
  };

  function InputPort(){
    Port.apply(this);
    this.getDefaultEditorId = function(){
      return this[PortConstants.DEFAULT_EDITOR_ID];
    };
    this.setDefaultEditorId = function(id){
      this[PortConstants.DEFAULT_EDITOR_ID] = id;
    } ;
    this.getOrder = function() {
      return this[PortConstants.ORDER];
    };
    this.setOrder = function(order){
      this[PortConstants.ORDER] = order;
    };
    this.getInputForm = function(){
    return this[PortConstants.INPUT_FORM];
  };
  this.setInputForm = function(form){
    this[PortConstants.INPUT_FORM] = form;
  };
    this.setData = function(jsonData){
      var property;
      for(property in jsonData ){
        this[property] = jsonData[property];
      }
    };
  };

  function OutputPort(){
    Port.apply(this);
    this.getDefaultAnalyzerId = function(){
      return this[PortConstants.DEFAULT_ANALYZER_ID];
    };
    this.setDefaultAnalyzerId = function(id){
      this[PortConstants.DEFAULT_ANALYZER_ID] = id;
    };
    this.getFileName = function(){
      return this[PortConstants.FILE_NAME];
    };
    this.setFileName = function(fileName){
      this[PortConstants.FILE_NAME] = fileName;
    };
    this.getOutputForm = function(){
    return this[PortConstants.OUTPUT_FORM];
  };
  this.setOutputForm = function(form){
    this[PortConstants.OUTPUT_FORM] = form;
  };
    this.setData = function(jsonData){
      var property;
      for(property in jsonData ){
        this[property] = jsonData[property];
      }
    };
  };

  function PortMap(){
    var that = this;
    this.getPort = function(portName){
      return this[portName];
    };
    this.addPort = function(port){
      var name = port.getName();
      var unique = this.isPortNameDuplicated(name);
      if( unique == false ) 
        return PortErrors.DUPLICATED_PORT_NAME;
      this[name] = port;
      return true;
    };
    this.createInputPort = function(portName){
      var port = new InputPort();
      var verified = port.setName(portName);
      if( !verified ) 
        return PortErrors.INVALID_PORT_NAME;
      var unique = this.isPortNameDuplicated(portName);
      if( !unique )
        return PortErrors.DUPLICATED_PORT_NAME;
      this.addPort(port);
      return port;
    };
    this.createOutputPort = function(portName){
      var port = new OutputPort();
      var verified = port.setName(portName);
      if( !verified ) 
        return PortErrors.INVALID_PORT_NAME;
      var unique = this.isPortNameDuplicated(portName);
      if( !unique )
        return PortErrors.DUPLICATED_PORT_NAME;
      this.addPort(port);
      return port;
    };
    this.removePort = function(portName){
      delete this[portName];
    };
    this.getPortArray = function(){
      var ports = [];
      var property;
      for(property in this ){
        var port = this[property];
        if( typeof port == 'object' )
          ports.push(port);
      }
      return ports;
    };
    this.getPortNameArray = function(){
      var portNames = [];
      var property;
      for(property in this){
        var port = this[property];
        if( typeof port == 'object' )
          portNames.push(property);
      }
      return portNames;
    };
    this.isInputDeckPortType = function(){
      var result = false;
      var portNames = that.getPortNameArray();
      for(var i=0, item; item=portNames[i]; i++) {
        var port = that.getPort(item);
        if(port.isInputDeckPortType()){
          result = true;
          break;
        }
      }
      return result;
    };
    this.isPortNameDuplicated = function(name){
      if ( this.hasOwnProperty(name) ){
        if(console){
          console.log(PortErrors.DUPLICATED_PORT_NAME);
        }
        return false;
      }
      else
        return true;
    };
    this.setData = function(jsonData, isInput){
      var property;
      for( property in jsonData){
        var port;
        if( isInput )
          port = this.createInputPort(property);
        else
          port = this.createOutputPort(property);
        port.setData(jsonData[property]);
        this[property] = port;
      }
    };
  };
