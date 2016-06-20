<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp" %>
<%@ include file="/common/science_platform_events.jspf" %>
<liferay-portlet:resourceURL var="getEditorPortletUrl" escapeXml="false" id="getEditorPortlet" copyCurrentRenderParameters="false"/>
<liferay-portlet:resourceURL var="getAuthTokenUrl" escapeXml="false" id="getAuthToken" copyCurrentRenderParameters="false"/>
<liferay-portlet:resourceURL var="getIcebreakerAccessTokenUrl" escapeXml="false" id="getIcebreakerAccessToken" copyCurrentRenderParameters="false"/>
<liferay-portlet:resourceURL var="getSiteGroupIdUrl" escapeXml="false" id="getSiteGroupId" copyCurrentRenderParameters="false"/>
<liferay-portlet:resourceURL var="getWorkflowInstancesUrl" escapeXml="false" id="getWorkflowInstances" copyCurrentRenderParameters="false"/>
<liferay-portlet:resourceURL var="updateWorkflowConfUrl" escapeXml="false" id="updateWorkflowConf" copyCurrentRenderParameters="false"/>
<liferay-portlet:renderURL var="resultDownLoadURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString()%>"  copyCurrentRenderParameters="false">
  <liferay-portlet:param name="myaction" value="resultDownLoad" />
</liferay-portlet:renderURL>
<style>
.aui .tooltip {
	display: none; 
}
</style>
<script>
var var_save_success_message =  Liferay.Language.get("edison-workflow-save-success-message");
var var_new_workflow_confirm_message = Liferay.Language.get("edison-workflow-new-confirm-message");
var var_remove_workflow_confirm_message = Liferay.Language.get("edison-workflow-remove-confirm-message");
var var_prepare_remove_workflow_message = Liferay.Language.get("edison-workflow-prepare-remove-message");
var var_success_remove_workflow_message = Liferay.Language.get("edison-workflow-success-remove-message");
var var_prepare_copy_workflow_message = Liferay.Language.get("edison-workflow-prepare-copy-message");
var var_success_copy_workflow_message = Liferay.Language.get("edison-workflow-success-copy-message");
var var_validation_required_message = Liferay.Language.get("edison-workflow-validation-required-message");
var var_data_empty_message = Liferay.Language.get("edison-workflow-data-empty-message");
var var_success_run_workflow_message = Liferay.Language.get("edison-workflow-success-run-message");
var var_run_workflow_save_err_message = Liferay.Language.get("edison-workflow-run-save-err-message");
var var_run_workflow_empty_err_message = Liferay.Language.get("edison-workflow-run-empty-err-message");
var var_remove_app_confirm = Liferay.Language.get("edison-workflow-remove-app-confirm");
var var_confirm_romove_workflow_instance_message = Liferay.Language.get("edison-workflow-remove-workflow-instance-confirm");
var var_private_default_editor_message = Liferay.Language.get("edison-workflow-privat-default-editor-message");
var var_conf_workflow_empty_err_message = Liferay.Language.get("edison-workflow-empty-workflow-conf-message");
var var_cannot_load_analyzer_message = Liferay.Language.get("edison-workflow-cannot-load-analyzer-message");
var contextPath = '${contextPath}';
</script>
<h1><liferay-ui:message key="edison-simulation-workflow"/></h1>
<div id="science-app" class="wf-container">
  <div class="wftitlebox001">
    <input type="text" name="worfklow-definition-name" id="worfklow-definition-name"/>
    <span>
      <input class="addIp button03" id="wf-new-button" value="<liferay-ui:message key='edison-workflow-create-new'/>" type="button">
      <input class="addIp button03" id="wf-save-button" value="<liferay-ui:message key='edison-button-save'/>" type="button">
      <input class="addIp button03" id="wf-copy-button" value="<liferay-ui:message key='edison-workflow-copy'/>" type="button">
      <input class="addIp button03" id="wf-remove-button" value="<liferay-ui:message key='edison-button-board-delete'/>" type="button">
      <input class="addIp button03" id="wf-run-button" value="<liferay-ui:message key='edison-table-list-header-run'/>" type="button">
      <input class="addIp button03" id="wf-conf-button" value="<liferay-ui:message key='edison-wf-conf-button'/>" type="button">
      <input class="addIp button03" id="wf-list-refresh-button" value="refresh" type="button" style="display: none !important;">
    </span>
  </div>
  <div class="lefttabm">
    <ul>
      <li class="on science-app"><liferay-ui:message key="edison-workflow-science-app"/></li>
      <li class="running-workflow"><liferay-ui:message key="edison-workflow-running-workflow"/></li>
      <li class="my-workflow"><liferay-ui:message key="edison-workflow-my-workflow"/></li>
      <li class="public-workflow"><liferay-ui:message key="edison-workflow-open-workflow"/></li>
    </ul>
  </div>
  <div class="leftwrap wrap">
    <div class="lefttreemenu science-app">
      <div class="searchbox">
        <input id="science-app-search" name="science-app-search" type="text" size="40" value="" autocomplete="off" placeholder="<liferay-ui:message key='edison-workflow-science-app-filter'/>"/>
        <input type="button" id="keyWordB">
      </div>
      <div class="lefttreemenu1 wf-jstree" id="app-list">
      </div>
    </div>
  </div>
  <div class="alert"></div>
  <div class="rightwrap">
    <div id="wf-workflow-canvas" class="apparea wf-drop jsplumb-drag-select" >
    </div>
  </div>
</div>
<div id="running-workflow" class="wf-container hidden">
  <div class="wftitlebox001">
    <h2 class="workflow-name-h2"></h2>
    <span>
      <input class="addIp button03" style="display: none;" id="wf-runing-pause-button" value="<liferay-ui:message key='edison-workflow-runing-pause'/>" type="button">
      <input class="addIp button03" style="display: none;" id="wf-runing-resume-button" value="<liferay-ui:message key='edison-workflow-runing-resume'/>" type="button">
      <input class="addIp button03" id="wf-runing-remove-button" value="<liferay-ui:message key='edison-button-board-delete'/>" type="button">
    </span>
  </div>
  <div class="lefttabm">
    <ul>
      <li class="on science-app"><liferay-ui:message key="edison-workflow-science-app"/></li>
      <li class="running-workflow"><liferay-ui:message key="edison-workflow-running-workflow"/></li>
      <li class="my-workflow"><liferay-ui:message key="edison-workflow-my-workflow"/></li>
      <li class="public-workflow"><liferay-ui:message key="edison-workflow-open-workflow"/></li>
    </ul>
  </div>
  <div class="wfconwrap wrap">
    <div class="lefttablemenu" >
      <div class="searchbox">
        <input id="search-running-workflow-name" name="search-running-workflow-name" type="text" size="40" value="" autocomplete="off" placeholder="<liferay-ui:message key='edison-workflow-workflow-instance-name-filter'/>"/>
        <input id="search-running-workflow-name-large-btn" type="button">
      </div>
      <div class="tabletopwf line-per-page">
        <select id="running-workflow-line-per-page" name="running-workflow-line-per-page"
          class="selectview">
            <option value="10">10<liferay-ui:message key="edison-search-views"/></option>
            <option value="20">20<liferay-ui:message key="edison-search-views"/></option>
            <option value="30">30<liferay-ui:message key="edison-search-views"/></option>
            <option value="40">40<liferay-ui:message key="edison-search-views"/></option>
        </select>
      </div>
      <div class="tabletopwf status">
        <select id="running-workflow-search-status" name="running-workflow-search-status"
          class="selectview">
            <option value="" selected="selected"><liferay-ui:message key="edison-workflow-running-status"/></option>
            <option value="RUNNING">Running</option>
            <option value="COMPLETED">Completed</option>
            <option value="PAUSED">Paused</option>
            <option value="FAILED">Failed</option>
            <option value="CANCELED">Canceled</option>
        </select>
      </div>
      <div class="slideclosearrow">
        <a class="wf-slide-toggle" href="#slide-close"><img src="${contextPath}/images/Workflow/slideclose_arrow.png" width="30" height="48"></a>
      </div>
      <div style="height:37px;"></div>
      <div>
        <div class="tablemf_list borderno">
          <table>
            <colgroup>
              <col width="20%">
              <col width="20%">
              <col width="15%">
              <col width="15%">
              <col width="15%">
              <col width="15%"> </colgroup>
            <thead>
              <tr>
                <th scope="col"><liferay-ui:message key="edison-workflow-instance-name"/></th>
                <th scope="col"><liferay-ui:message key="edison-workflow-definition"/></th>
                <th scope="col"><liferay-ui:message key="edison-table-list-header-run"/>ID</th>
                <th scope="col"><liferay-ui:message key="edison-workflow-running-status"/></th>
                <th scope="col"><liferay-ui:message key="edison-workflow-running-start-date"/></th>
                <th scope="col"><liferay-ui:message key="edison-workflow-running-end-date"/></th>
              </tr>
            </thead>
            <tbody class="workflow-list-tbody">
            </tbody>
          </table>
        </div>
      </div>
      <div id="running-workflow-paging"  class="paging">
      </div>
    </div>
  </div>
  <div class="leftwrap wrap" style="display: none;">
    <div class="lefttreemenu running-workflow">
      <div class="searchbox">
        <input id="search-running-workflow-name-small" name="search-running-workflow-name" type="text" size="40" value="" autocomplete="off" placeholder="<liferay-ui:message key='edison-workflow-workflow-instance-name-filter'/>"/>
        <input type="button" id="search-running-workflow-name-small-btn">
      </div>
      <div class="openslidearrow">
        <a class="wf-slide-toggle" href="#slide-open"><img src="${contextPath}/images/Workflow/slideopen_arrow.png" width="32" height="51"></a>
      </div>
      <div class="lefttreemenu1 wf-jstree" id="workflow-instance-list">
      </div>
    </div>
  </div>
  <div class="alert"></div>
  <div class="rightwrap"  style="display: none;">
    <div id="running-workflow-canvas" class="right apparea" >
    </div>
  </div>
  <div id="running-workflow-log"  style="display: none;">
    <div class="tablemf_list borderno">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <colgroup>
              <col width="*%">
              <col width="15%">
              <col width="25%">
              <col width="25%">
              <!-- <col width="*"> --> 
          </colgroup>
          <thead>
              <tr>
                  <th scope="col"><liferay-ui:message key="edison-virtuallab-app-name"/></th>
                  <th scope="col"><liferay-ui:message key="edison-table-list-header-status"/></th>
                  <th scope="col"><liferay-ui:message key="edison-workflow-running-start-date"/></th>
                  <th scope="col"><liferay-ui:message key="edison-workflow-running-end-date"/></th>
                  <!-- <th scope="col">실행결과</th> -->
              </tr>
          </thead>
          <tbody id="running-workflow-log-tbody">
            <tr class="bgcolor"><td class="TC" colspan="4"><liferay-ui:message key="edison-workflow-data-empty-message"/></td></tr>
          </tbody>
      </table>
    </div>
  </div>
</div>

<div id="my-workflow" class="wf-container hidden">
  <div class="wftitlebox001">
    <h2 id="my-workflow-name" class="workflow-name-h2"></h2>
    <span>
      <input class="addIp button03" id="wf-modify-button" value="<liferay-ui:message key='edison-workflow-edit'/>" type="button"/>
      <input class="addIp button03" id="wf-my-copy-button" value="<liferay-ui:message key='edison-workflow-copy'/>" type="button">
    </span>
  </div>
  <div class="lefttabm">
    <ul>
      <li class="science-app"><liferay-ui:message key="edison-workflow-science-app"/></li>
      <li class="running-workflow"><liferay-ui:message key="edison-workflow-running-workflow"/></li>
      <li class="my-workflow"><liferay-ui:message key="edison-workflow-my-workflow"/></li>
      <li class="public-workflow"><liferay-ui:message key="edison-workflow-open-workflow"/></li>
    </ul>
  </div>
  <div class="wfconwrap wrap" style="display: none;">
    <div class="lefttablemenu" >
      <div class="searchbox">
        <input id="search-my-workflow-name-large" name="search-my-workflow-name" type="text" size="40" value="" autocomplete="off" placeholder="<liferay-ui:message key='edison-workflow-workflow-name-filter'/>"/>
        <input id="search-my-workflow-name-large-btn" type="button">
      </div>
      <div class="tabletopwf">
        <select id="my-workflow-line-per-page" name="my-workflow-line-per-page"
          class="selectview">
            <option value="10">10<liferay-ui:message key="edison-search-views"/></option>
            <option value="20">20<liferay-ui:message key="edison-search-views"/></option>
            <option value="30">30<liferay-ui:message key="edison-search-views"/></option>
            <option value="40">40<liferay-ui:message key="edison-search-views"/></option>
        </select>
      </div>
      <div class="slideclosearrow">
        <a class="wf-slide-toggle" href="#slide-close"><img src="${contextPath}/images/Workflow/slideclose_arrow.png" width="30" height="48"></a>
      </div>
      <div style="height:37px;"></div>
      <div>
        <div class="tablemf_list borderno">
          <table>
            <colgroup>
              <col width="20%">
              <col width="20%">
              <col width="15%">
              <col width="15%">
              <col width="15%">
              <col width="15%"> 
            </colgroup>
            <thead>
              <tr>
                <th scope="col"><liferay-ui:message key="edison-workflow-name"/></th>
                <th scope="col"><liferay-ui:message key="edison-simulation-execute-simulation-description"/></th>
                <th scope="col"><liferay-ui:message key="edison-virtuallab-owner"/></th>
                <th scope="col">Copied from</th>
                <th scope="col"><liferay-ui:message key="edison-workflow-create-date"/></th>
                <th scope="col"><liferay-ui:message key="edison-workflow-public-status"/></th>
              </tr>
            </thead>
            <tbody id="my-workflow-tbody" class="workflow-list-tbody">
            </tbody>
          </table>
        </div>
      </div>
      <div id="my-workflow-paging" class="paging">
      </div>
    </div>
  </div>
  <div class="leftwrap wrap">
    <div class="leftlistbox my-workflow">
      <div class="searchbox">
        <input id="search-my-workflow-name-small" name="search-my-workflow-name" type="text" size="40" value="" autocomplete="off" placeholder="<liferay-ui:message key='edison-workflow-workflow-name-filter'/>"/>
        <input type="button" id="search-my-workflow-name-small-btn">
      </div>
      <div class="openslidearrow">
        <a class="wf-slide-toggle" href="#"><img src="${contextPath}/images/Workflow/slideopen_arrow.png" width="32" height="51"></a>
      </div>
      <div class="listboxtopsp" >
        <div class="workflow-list-div" id="my-workflow-div">
        </div>
      </div>
    </div>
  </div>
  <div class="alert"></div>
  <div class="rightwrap">
    <div id="my-workflow-canvas" class="right apparea">
    </div>
  </div>
</div>

<div id="public-workflow" class="wf-container hidden">
  <div class="wftitlebox001">
    <h2 id="public-workflow-name" class="workflow-name-h2"></h2>
    <span>
      <input class="addIp button03" id="wf-public-copy-button" value="<liferay-ui:message key='edison-workflow-copy'/>" type="button">
    </span>
  </div>
  <div class="lefttabm">
    <ul>
      <li class="science-app"><liferay-ui:message key="edison-workflow-science-app"/></li>
      <li class="running-workflow"><liferay-ui:message key="edison-workflow-running-workflow"/></li>
      <li class="my-workflow"><liferay-ui:message key="edison-workflow-my-workflow"/></li>
      <li class="public-workflow"><liferay-ui:message key="edison-workflow-open-workflow"/></li>
    </ul>
  </div>
  <div class="wfconwrap wrap" style="display: none;">
    <div class="lefttablemenu" >
      <div class="searchbox">
        <input id="search-public-workflow-name-large" name="search-public-workflow-name" type="text" size="40" value="" autocomplete="off" placeholder="<liferay-ui:message key='edison-workflow-workflow-name-filter'/>"/>
        <input id="search-public-workflow-name-large-btn" type="button">
      </div>
      <div class="tabletopwf">
        <select id="public-workflow-line-per-page" name="public-workflow-line-per-page"
          class="selectview">
            <option value="10">10<liferay-ui:message key="edison-search-views"/></option>
            <option value="20">20<liferay-ui:message key="edison-search-views"/></option>
            <option value="30">30<liferay-ui:message key="edison-search-views"/></option>
            <option value="40">40<liferay-ui:message key="edison-search-views"/></option>
        </select>
      </div>
      <div class="slideclosearrow">
        <a class="wf-slide-toggle" href="#slide-close"><img src="${contextPath}/images/Workflow/slideclose_arrow.png" width="30" height="48"></a>
      </div>
      <div style="height:37px;"></div>
      <div>
        <div class="tablemf_list borderno">
          <table>
            <colgroup>
              <col width="20%">
              <col width="20%">
              <col width="15%">
              <col width="15%">
              <col width="15%">
              <col width="15%"> 
            </colgroup>
            <thead>
              <tr>
                <th scope="col"><liferay-ui:message key="edison-workflow-name"/></th>
                <th scope="col"><liferay-ui:message key="edison-simulation-execute-simulation-description"/></th>
                <th scope="col"><liferay-ui:message key="edison-virtuallab-owner"/></th>
                <th scope="col">Copied from</th>
                <th scope="col"><liferay-ui:message key="edison-workflow-create-date"/></th>
                <th scope="col"><liferay-ui:message key="edison-workflow-public-status"/></th>
              </tr>
            </thead>
            <tbody id="public-workflow-tbody" class="workflow-list-tbody">
            </tbody>
          </table>
        </div>
      </div>
      <div id="public-workflow-paging" class="paging">
      </div>
    </div>
  </div>
  <div class="leftwrap wrap">
    <div class="leftlistbox public-workflow">
      <div class="searchbox">
        <input id="search-public-workflow-name-small" name="search-public-workflow-name" type="text" size="40" value="" autocomplete="off" placeholder="<liferay-ui:message key='edison-workflow-workflow-name-filter'/>"/>
        <input type="button" id="search-public-workflow-name-small-btn">
      </div>
      <div class="openslidearrow">
        <a class="wf-slide-toggle" href="#"><img src="${contextPath}/images/Workflow/slideopen_arrow.png" width="32" height="51"></a>
      </div>
      <div class="listboxtopsp">
        <div class="workflow-list-div" id="public-workflow-div">
        </div>
      </div>
    </div>
  </div>
  <div class="alert"></div>
  <div class="rightwrap">
    <div id="public-workflow-canvas" class="right apparea" >
    </div>
  </div>
</div>
<div id="workflow-instance-dialog" style="display:none; background-color:white; padding:0px;" class="newWindow">
  <div class="newWheader" id="workflow-instance-dialog-title">
    <div class="newWtitlebox"><img src="<%=renderRequest.getContextPath()%>/images/title_newWindow.png" width="34" height="34">
      <div class="newWtitle">Workflow Instance Name</div>
    </div>
    <div class="newWclose" style="cursor: pointer;">
      <img  id="workflow-instance-dialog-close-btn" src="<%=renderRequest.getContextPath()%>/images/btn_closeWindow.png" width="21" height="21">
    </div>
  </div>
  <div id="workflow-instance-dialog-cont" style="padding: 30px;" class="newWcont01">
    <p><liferay-ui:message key="edison-workflow-running-instance-name-message"/>.</p>
    <input id="workflow-instance-name-input" type="text" name="workflow-instance-name" style="width: 85%;" />
    <input id="workflow-instance-run" class="button03" style="float: right;"  type="button" name="save" value="Run"/>
  </div>
</div>
<div id="<portlet:namespace/>error-dialog" style="display:none; background-color:white; padding:0px;" class="newWindow">
  <div class="newWheader" id="<portlet:namespace/>error-dialog-title" style="cursor: move;">
    <div class="newWtitlebox"><img src="<%=renderRequest.getContextPath()%>/images/title_newWindow.png" width="34" height="34">
      <div id="<portlet:namespace/>error-dialog-title-text" class="newWtitle">Log</div>
    </div>
    <div class="newWclose" style="cursor: pointer;">
      <img id="<portlet:namespace/>error-dialog-close-btn" name="<portlet:namespace/>jobparameter-dialog-dialog-close-btn" src="<%=renderRequest.getContextPath()%>/images/btn_closeWindow.png" width="21" height="21">
    </div>
  </div>
  <div id="<portlet:namespace/>error-dialog-content" style="padding: 30px;" class="newWcont01">
  </div>
</div>
<div id="<portlet:namespace/>wf-conf-dialog" title="<liferay-ui:message key='edison-workflow-conf-title' />"
  class="newWindow" style="display: none; background-color: white; padding: 0px;">
  <div class="newWheader">
    <div class="newWtitlebox">
      <img src="<%=renderRequest.getContextPath()%>/images/title_newWindow.png" width="34" height="34">
      <div class="newWtitle">
        <liferay-ui:message key='edison-workflow-conf-title' />
      </div>
    </div>
    <div class="newWclose" style="cursor: pointer;">
      <img id="<portlet:namespace/>wf-conf-dialog-close-btn" name="wf-conf-dialog-close-btn"
        src="<%=renderRequest.getContextPath()%>/images/btn_closeWindow.png" width="25" height="25"
        style="cursor: pointer; float: right;" />
    </div>
  </div>
  <div style="padding: 30px;" class="newWcont01">
    <aui:form action="<%=updateWorkflowConfUrl%>" method="post" id="updateWorkflowConfForm" name="updateWorkflowConfForm" target="updateWorkflowConfFrame">
      <div class="table1_list" style="width: 85%; padding: 15px; margin: 0 auto;">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <colgroup>
            <col width="25%" />
            <col width="75%" />
          </colgroup>
          <tbody>
            <tr>
              <td><liferay-ui:message key='edison-workflow-conf-title-input' /></td>
              <td>
                <div>
                  <liferay-ui:input-localized id="title" name="title" xml="" type="input" spellcheck="false" style="width: 95%;">
                  </liferay-ui:input-localized>
                </div>
              </td>
            </tr>
            <tr>
              <td><liferay-ui:message key='edison-workflow-conf-lang-input' /></td>
              <td>&nbsp;&nbsp;
              <label style="display:inline;">
                <input type="checkbox" id="<portlet:namespace/>serviceLanguageAll" name="<portlet:namespace/>select_languageId" value="all">
              </label>
              <liferay-ui:message key="full" />
              <c:forEach var="lang" items="${ableLang}">
                <label style="display:inline;">
                  <input type="checkbox" id="<portlet:namespace/>select_languageId" name="<portlet:namespace/>select_languageId" value="${lang}"/>
                  <img width="17px" height="12px" src="${contextPath}/images/Workflow/toplink_${lang}.gif" />
                  <liferay-ui:message key='edison-board-radiobutton-${lang}' />
                </label>
              </c:forEach>
              </td>
            </tr>
            <tr>
              <td><liferay-ui:message key='edison-workflow-conf-public-input' /></td>
              <td>&nbsp;&nbsp;
              <label style="display:inline;">
                <input type="checkbox" id="<portlet:namespace/>isPublic" name="<portlet:namespace/>isPublic" value="1">
              </label>
			 </td>
            </tr>
            <tr>
              <td><liferay-ui:message key='edison-workflow-conf-description-input' /></td>
              <td>
                <div>
                  <liferay-ui:input-localized name="description" id="description" xml="" type="textarea" rows="3"
                    spellcheck="false" style="width: 95%; resize:none;">
                  </liferay-ui:input-localized>
                </div>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
      <aui:input id="workflowId" name="workflowId" value="${mode}" type="hidden"/>
      <div style="float: right; padding-right: 60px;">
        <input id="<portlet:namespace />updateWorkflowConf" name="<portlet:namespace />updateWorkflowConf" onclick="updateWorkflowConf();" class="button03"
          type="button" value="<liferay-ui:message key='edison-workflow-conf-save-button' />"/>
      </div>
    </aui:form>
  </div>
</div>
<div id="<portlet:namespace />result-down-dialog" style="display:none; background-color:white; padding:0px;" class="newWindow">
</div>
<iframe id="updateWorkflowConfFrame" name="updateWorkflowConfFrame" style="display: none;" ></iframe>
<script>
  var isNotLoaded = true;
  var wfPortletGlobalData = wfPortletGlobalData ? wfPortletGlobalData : {wfElements : {}};
  function getEditorPortletUrl(portletId){
    var url = "<%=getEditorPortletUrl%>";
    return synchronousAjaxHelper.post(url, {"<portlet:namespace/>portletId" : portletId})["portletURL"];
  }
  function getAuthToken(portletId){
    var url = "<%=getAuthTokenUrl%>";
    return synchronousAjaxHelper.post(url, {"<portlet:namespace/>portletId" : portletId});
  }
  function getIcebreakerAccessToken(){
    var url = "<%=getIcebreakerAccessTokenUrl%>";
    var result = synchronousAjaxHelper.post(url, {});
    return result;
  }
  function getSiteGroupId(){
    var url = "<%=getSiteGroupIdUrl%>";
    return synchronousAjaxHelper.post(url, {})["groupId"];
  }
  
  function getWorkflowInstances(searchKeyword, p_curPage, linePerPage, status){
    var url = "<%=getWorkflowInstancesUrl%>" ;
    var params = {};
    if(searchKeyword || searchKeyword === 0){
      params["<portlet:namespace/>title"] = searchKeyword;
    }
    if(p_curPage){
      params["<portlet:namespace/>p_curPage"] = p_curPage;
    }
    if(linePerPage){
      params["<portlet:namespace/>linePerPage"] = linePerPage;
    }
    if(status){
      params["<portlet:namespace/>status"] = status;
    }
    params["<portlet:namespace/>pagingClassName"] = "running-workflow-paging";
    var result = synchronousAjaxHelper.post(url, params);
    return result["workflowMap"];
  }
  
  function popAnalyzerWindow(analyzer, port, jsPlumbWindowId, appGroupId, jobUuid)
  {
    var portletTitle = analyzer["title"];
    var portletId = analyzer["exeFileName"];
    var portType = analyzer["editorType"];
    var portName = port.getName();
    var portTypeId = port.getPortTypeId();
    var endPointId = jsPlumbWindowId + "|" + port.getName();
    var taskId = jsPlumbWindowId;
  	var authToken = getAuthToken(portletId);
  	var plid = authToken["plid"];
  	var token = authToken["authToken"];
  	var fileListType = (""+port.getOutputForm()).toUpperCase();
  	var fileListValue = port.getFileName();
  	var portData;
	AUI().use("liferay-portlet-url", function(a) {
  	var renderURL = Liferay.PortletURL.createRenderURL();
  	  	renderURL.setPortletId(portletId);
  	  	renderURL.setPlid(plid);
    	renderURL.setParameter("taskId", taskId);
    	renderURL.setParameter("fileListType", fileListType);
    	renderURL.setParameter("fileListValue", fileListValue);
    	renderURL.setParameter("portName", portName);
    	renderURL.setParameter("jobUuid", jobUuid);
    	renderURL.setParameter("portletTitle", portletTitle);
    	renderURL.setParameter("groupId", appGroupId);
    	renderURL.setParameter("token", token);
    	renderURL.setParameter("width", 1230);
    	renderURL.setParameter("height", 850);
    	openWindow(renderURL);
  	});
  }

  function popEditorWindow(editor, port, jsPlumbWindowId, appGroupId){
    var portletTitle = editor["title"];
    var portletId = editor["exeFileName"];
    var portType = editor["editorType"];
    var portName = port.getName();
    var portTypeId = port.getPortTypeId();
    var endPointId = jsPlumbWindowId + "|" + port.getName();
    var taskId = jsPlumbWindowId;
  	var authToken = getAuthToken(portletId);
  	var plid = authToken["plid"];
  	var token = authToken["authToken"];
  	var portData;
  	/* if(wfPortletGlobalData["wfElements"][jsPlumbWindowId]){
  	  portData = wfPortletGlobalData["wfElements"][jsPlumbWindowId][portName];
  	} */
  	
  	AUI().use("liferay-portlet-url", function(a) {
    	var renderURL = Liferay.PortletURL.createRenderURL();
  	  	renderURL.setPortletId(portletId);
  	  	renderURL.setPlid(plid);
      	renderURL.setParameter("taskId", taskId);
      	renderURL.setParameter("portName", portName);
      	renderURL.setParameter("portletTitle", portletTitle);
      	renderURL.setParameter("token", token);
      	renderURL.setParameter("portTypeId", portTypeId);
      	renderURL.setParameter("groupId", appGroupId);
      	
    	if(portType == "Inputdeck") {
          renderURL.setParameter("width", 900);
          renderURL.setParameter("height", 600);
    	}else if(portType == "File") {
    	  if(port["sampleFilePath"]){
  	    	renderURL.setParameter("useSampleFile", "Y");
		  } else {
  	  		renderURL.setParameter("useSampleFile", "N");
    	  }
          renderURL.setParameter("width", 900);
          renderURL.setParameter("height", 800);
    	}else {
          renderURL.setParameter("width", 400);
          renderURL.setParameter("height", 230);
    	}
    	openWindow(renderURL, endPointId);
  	});
  }
  

  function openWindow(renderURL, endPointId) {
    var dialogId = endPointId;
    renderURL.setName("Popup");
    renderURL.setWindowState("pop_up");
    renderURL.setParameter("dialogId", dialogId);
    renderURL.setParameter("workflowType", "workflow");

    var url = renderURL.toString();
    Liferay.Util.openWindow({
      dialog : {
        cache : false,
        destroyOnClose : true,
        centered : true,
        modal : true,
        resizable : false,
        width : renderURL.params.width,
        height : renderURL.params.height
      },
      id : dialogId,
      title : renderURL.params.portletTitle,
      uri : url + '&p_p_auth=' + renderURL.params.token
    });
  }

  function serviceLanguageCheckBox() {
    /*서비스 언어 전체선택/해제 */
    $("#<portlet:namespace/>serviceLanguageAll").click(function() {
      if ($("#<portlet:namespace/>serviceLanguageAll").prop("checked")) {
        $("input[id=<portlet:namespace/>select_languageId]").prop("checked", true);
      } else {
        $("input[id=<portlet:namespace/>select_languageId]").prop("checked", false);
      }
    });

    var ableLangLength = '<c:out value="${fn:length(ableLang)}"/>'; //available Language Length
    $("input[id=<portlet:namespace/>select_languageId]").click(function() {
      var checkLength = $("input[id=<portlet:namespace/>select_languageId]:checked").length;

      if (ableLangLength == checkLength) {
        $("#<portlet:namespace/>serviceLanguageAll").prop("checked", true);
      } else {
        $("#<portlet:namespace/>serviceLanguageAll").prop("checked", false);
      }
    });
  }

  Liferay.provide(window, 'fetchResult', function(taskId, portName, value) {
    var content = {
      taskId : taskId,
      portName : portName,
      value : value
    };

    var payload = new SciencePlatformEvent("stringPort", SciencePlatformEvents.TYPE_BROADCAST,
        '<portlet:namespace/>', '', content);

    Liferay.fire(SciencePlatformEvents.IPC_EVENT_CONTENT_BROADCAST, payload);
  }, [ 'aui-base', 'liferay-util-window', 'aui-dialog-iframe-deprecated', 'liferay-util-window' ]);

  Liferay.provide(window, 'closePopup', function(popupId) {
    var popupDialog = Liferay.Util.Window.getById(popupId);
    popupDialog.destroy();
  }, [ 'aui-base', 'aui-dialog', 'aui-dialog-iframe', 'liferay-util-window' ]);

  Liferay.on(SciencePlatformEvents.IPC_EVENT_CONTENT_BROADCAST, function(event) {
    var json = event.getEventData();
    var jsonData = JSON.stringify(json);

    consoleLog.debug(event);
    consoleLog.debug(json);

    if (wfPortletGlobalData["wfElements"][json["taskId"]]) {
      wfPortletGlobalData["wfElements"][json["taskId"]][json["portName"]] = json["value"];
    } else {
      var portJson = {};
      portJson[json["portName"]] = json["value"];
      wfPortletGlobalData["wfElements"][json["taskId"]] = portJson;
    }
  });

  $("#<portlet:namespace/>error-dialog").dialog({
    autoOpen : false,
    width : '855',
    height : '580',
    modal : true,
    resizable : false,
    show : {
      effect : 'fade',
      speed : 800
    },
    hide : {
      effect : 'fade',
      speed : 800
    },
    draggable : true,
    open : function(event, ui) {
      $(this).removeClass("ui-widget-content");
      $(this).parent().removeClass("ui-widget-content");
      $(this).parent().css('overflow', 'visible');

      $("body").css('overflow', 'hidden');
      $("#<portlet:namespace/>error-dialog-close-btn").bind('click', function() {
        $("#<portlet:namespace/>error-dialog").dialog("close");
      });

      $('.ui-widget-overlay').bind('click', function() {
        $("#<portlet:namespace/>error-dialog").dialog("close");
      })
    },
    close : function() {
      $("#<portlet:namespace/>error-dialog-content").empty();
      $("body").css('overflow', '');
    }
  }).draggable({
    handle : "#<portlet:namespace/>error-dialog-title"
  }).dialog("widget").find(".ui-dialog-titlebar").remove();

  $("#<portlet:namespace/>wf-conf-dialog").dialog({
    autoOpen : false,
    width : '855',
    height : '500',
    modal : true,
    resizable : false,
    show : {
      effect : 'fade',
      speed : 800
    },
    hide : {
      effect : 'fade',
      speed : 800
    },
    draggable : true,
    open : function(event, ui) {
      $(this).removeClass("ui-widget-content");
      $(this).parent().removeClass("ui-widget-content");
      $(this).parent().css('overflow', 'visible');

      $("body").css('overflow', 'hidden');
      $("#<portlet:namespace/>wf-conf-dialog-close-btn").bind('click', function() {
        $("#<portlet:namespace/>wf-conf-dialog").dialog("close");
      });

      $('.ui-widget-overlay').bind('click', function() {
        $("#<portlet:namespace/>wf-conf-dialog").dialog("close");
      })
    },
    close : function() {
      $("#<portlet:namespace/>wf-conf-dialog-content").empty();
      $("body").css('overflow', '');
    }
  }).draggable({
    handle : "#<portlet:namespace/>wf-conf-dialog-title"
  }).dialog("widget").find(".ui-dialog-titlebar").remove();
  
  function updateWorkflowConf(){
    var defaultLang = '${defaultLang}';
    $("#worfklow-definition-name").val($("#<portlet:namespace/>title_"+defaultLang+"").val());
    $("#<portlet:namespace/>wf-conf-dialog").dialog("close");
    $("#<portlet:namespace/>updateWorkflowConfForm").submit();
  }
  
  function refreshListButtonClick(){
    $("#wf-list-refresh-button").click();
  }

  function openWorkflowConfigPopup(workflowData) {
    $("#<portlet:namespace/>updateWorkflowConfForm")[0].reset();
    $("#<portlet:namespace/>workflowId").val(workflowData["workflowId"]);
    var defaultLang = '${defaultLang}';
    $("#<portlet:namespace/>titleContentBox div:last").click();
    $("#<portlet:namespace/>descriptionContentBox div:last").click();
    if(workflowData["titleMap"] && workflowData["titleMap"].indexOf("<?xml") > -1){
      var xmlTitleDoc = $.parseXML(workflowData["titleMap"]);
      var xmlDescriptionDoc = $.parseXML(workflowData["descriptionMap"]);
      var $xmlTitle = $(xmlTitleDoc);
      var $xmlDescription = $(xmlDescriptionDoc);
      var lang, title, description;
    <c:forEach var="lang" items="${ableLang}">
      lang = "${lang}";
      title = $xmlTitle.find("Title[language-id='"+lang+"']").text();
      description = $xmlDescription.find("Description[language-id='"+lang+"']").text();
      $("#<portlet:namespace/>title_"+lang+"").val(title);
      $("#<portlet:namespace/>description_"+lang+"").val(description);
    </c:forEach>
    }else{
      $("#<portlet:namespace/>titleContentBox div:last").click();
      $("#<portlet:namespace/>descriptionContentBox div:last").click();
      $("#<portlet:namespace/>title_"+defaultLang+"").val(workflowData["title"]);
      $("#<portlet:namespace/>description_"+defaultLang+"").val(workflowData["description"]);
    }
    $("#<portlet:namespace/>title").attr("placeholder",$(xmlTitleDoc).find("[language-id ='"+defaultLang+"']").text()).val($(xmlTitleDoc).find("[language-id ='"+defaultLang+"']").text());
    $("#<portlet:namespace/>description").attr("placeholder",$(xmlDescriptionDoc).find("[language-id ='"+defaultLang+"']").text()).val($(xmlDescriptionDoc).find("[language-id ='"+defaultLang+"']").text());
    $("#<portlet:namespace/>titleContentBox").find("li[data-value='"+defaultLang+"']").trigger("click");
    $("#<portlet:namespace/>descriptionContentBox").find("li[data-value='"+defaultLang+"']").trigger("click");
    var isPublic = workflowData["isPublic"];
    $("input:checkbox[id='<portlet:namespace/>isPublic']").prop("checked", isPublic);
    $targetLanguage = workflowData["targetLanguage"];
    if($targetLanguage != ""){
		$checkedVal = $targetLanguage.split(",");
		if($checked =! ""){
			$("input[name=<portlet:namespace/>select_languageId]").each(function() {
				$box = $(this).val();
				for(var i=0; i< $checkedVal.length; i++){
					if($box == $checkedVal[i]){
						$(this).attr("checked", true);
					}
				}
			});
		}
	}
    $("#<portlet:namespace/>wf-conf-dialog").dialog("open");
  }

  function openWorkflowSimulationLogPopup(data, logType) {
    var $content = $("#<portlet:namespace/>error-dialog-content");
    $("#<portlet:namespace/>error-dialog-title-text").text(logType);
    data = data.replace(/'/g, "&apos;").replace(/"/g, "&quot;");
    $content.html(data);
    $("#<portlet:namespace/>error-dialog").dialog("open");
  }

  function openSolverDeatilPopup(scienceAppId) {
    var groupId = getSiteGroupId();
    AUI().use("liferay-portlet-url", function(a) {
      var portletURL = Liferay.PortletURL.createRenderURL();
      portletURL.setPlid("${appstorePlid}"); /*앱스토어 Plid*/
      portletURL.setPortletId("edisonscienceAppstore_WAR_edisonappstore2016portlet"); /*앱스토어 포틀릿 ID*/
      portletURL.setParameter("groupId", groupId); /*현재 groupId*/
      portletURL.setParameter("solverId", scienceAppId); /*선택된 solverId*/
      portletURL.setParameter("myaction", "detailView"); /*상세보기 페이지 action*/
      window.open(portletURL.toString());
    });
  }

  function addScienceAppData(endPointId, arrData) {
    var inputJson = $.parseJSON(JSON.stringify(arrData[0]));

    if (typeof endPointId === 'string') {
      var portName = endPointId.substr(endPointId.lastIndexOf("|") + 1);
      var elementId = endPointId.substr(0, (endPointId.lastIndexOf("|")));
      if (wfPortletGlobalData["wfElements"][elementId]) {
        wfPortletGlobalData["wfElements"][elementId][portName] = inputJson;
      } else {
        var portJson = {};
        portJson[portName] = inputJson;
        wfPortletGlobalData["wfElements"][elementId] = portJson;
      }
    }
  }
  function workflowAppResultDownload(jobUuid, groupId){
    console.log(jobUuid, groupId);
  	var URL = "<%=resultDownLoadURL%>&<portlet:namespace/>jobUuid="+jobUuid+"&<portlet:namespace/>groupId="+groupId;
  	$resultDialog = $("#<portlet:namespace/>result-down-dialog").dialog({
  		autoOpen: true,
  		width: '500',
  		height: '580',
  		modal: true,
  		resizable: true,
  		show: {effect:'fade', speed: 800}, 
  		hide: {effect:'fade', speed: 800},
  		open: function(event, ui) {
  	    	$(this).removeClass("ui-widget-content");
  	    	$(this).parent().removeClass("ui-widget-content");
  	    	$(this).parent().css('overflow','visible');
  	    	$(this).load(URL);
  	    	
  	    	$("body").css('overflow','hidden')
  	    	
  	    	$("#<portlet:namespace/>result-down-dialog-close-btn").bind('click',function(){
  	    		$("#<portlet:namespace/>result-down-dialog").dialog("close");
  	    	});
  	    	
  	    	$('.ui-widget-overlay').bind('click',function(){
  	    		$("#<portlet:namespace/>result-down-dialog").dialog("close");
  			})
  	    },
  	    close: function() {
  	    	$("body").css('overflow','');
  	    }
  	}).draggable({
  			handle: "#<portlet:namespace/>result-dialog-title"
  	}).dialog("widget").find(".ui-dialog-titlebar").remove();
  }

  serviceLanguageCheckBox();
</script>