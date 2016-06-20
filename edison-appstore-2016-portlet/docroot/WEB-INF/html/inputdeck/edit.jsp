<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.kisti.edison.science.service.constants.InputdeckConstants"%>
<%@ include file="/common/init.jsp"%>
<style type="text/css">
	.inputdeck-portlet div.content{
		width: 100%;
		margin: auto;
	}
	
	.inputdeck-portlet div.left{
		width: 51%;
		float: left;
	}
	
	.inputdeck-portlet div.right{
		width: 48%;
		float: right;
	}
	
	.inputdeck-portlet div.activate{
		position: absolute;
	}
	
	.inputdeck-portlet div.activateSearch{
		position: absolute;
	}
	
	.inputdeck-portlet .long_field{
		width: 350px;
	}
	
	.inputdeck-portlet .short_field{
		width: 150px;
	}
	
	.inputdeck-portlet .to_short_field{
		width: 50px;
		margin-right: 5px;
	}
	
	.inputdeck-portlet .numberCheck{
		-webkit-ime-mode : disabled; 
		-moz-ime-mode : disabled; 
		-ms-ime-mode : disabled; 
		ime-mode : disabled; 
	}
	
	.inputdeck-portlet .parameter{
		display: none;
	}
	
	.inputdeck-portlet .actieveBtn{
		display: none;
	}
	
	.aui .checkbox{
		font-weight: 600;
	}
	
	.aui input[type="radio"], .aui input[type="checkbox"]{
		margin: 0px;
	}
	
	.aui select{
		width: auto;
	}
	
	.aui .input-text-wrapper{
		display: initial;
	}
</style>
<div class="virtitlebox">
	<img src="${contextPath}/images/title_virtual.png" width="20" height="20" /> 
	<div class="virtitle">
		<liferay-ui:message key='edison-science-appstore-inputdeck-title' />
	</div>
</div>
<div class="h10" style="display: inline-block;"></div>

<div class="table1_list" >
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data">
		<colgroup>
			<col width="10%">
			<col width="20%">
			<col width="10%">
			<col width="20%">
			<col width="10%">
			<col width="20%">
			<col width="10%">
			<col width="*%">
		</colgroup>
		<tr>
			<th>value delimiter</th>
			<td align="center">
				<select onChange="<portlet:namespace/>lineFormat();" id="valueDelimiter">
					<option value=" = ">EQUAL</option>
					<option value=" ">SPACE</option>
				</select>
			</td>
			
			<th>Line delimiter</th>
			<td align="center">
				<select onChange="<portlet:namespace/>lineFormat();" id="lineDelimiter">
					<option value=" ;">SEMICOLON</option>
					<option value=" :">COLON</option>
					<option value="">NULL</option>
				</select>
			</td>
			
			<th>Comment Char</th>
			<td align="center">
				<input type="text" size="5" maxlength="1" id="lineChar" onkeyup="<portlet:namespace/>lineFormat();"/>
			</td>
			
			<th><liferay-ui:message key='preview' /></th>
			<td align="center">
				<input type="text" id="linePreview" size="20" style="font-size: 13px;font-weight: bold;" readonly="readonly"/>
			</td>
		</tr>
		<tr>
			<th>Vector bracket</th>
			<td align="center">
				<select onChange="<portlet:namespace/>vectorFormat();" id="vectorBracket">
					<option value="SQUARE">SQUARE</option>
					<option value="SQUARE_SPACE">SQUARE_SPACE</option>
					<option value="ROUND">ROUND</option>
					<option value="ROUND_SPACE">ROUND_SPACE</option>
				</select>
			</td>
			
			<th>Vector Delimiter</th>
			<td align="center">
				<select onChange="<portlet:namespace/>vectorFormat();" id="vectorDelimiter">
					<option value=" ">SPACE</option>
					<option value=",">COMMA</option>
				</select>
			</td>
			
			<th><liferay-ui:message key='preview' /></th>
			<td colspan="3">
				<input type="text" id="vectorPreview" size="20" style="font-size: 13px;font-weight: bold;" readonly="readonly"/>
			</td>
		</tr>
	</table>
</div>

<div class="h10"></div>

<div class="content">
	<div class="left table2_list activate" id="activateDiv" style="display: none;">
		<table id="<portlet:namespace/>activateTable" style="width: 100%;">
			<colgroup>
				<col width="20%">
				<col width="20%">
				<col width="17%">
				<col width="11%">
				<col width="17%">
			</colgroup>
			<thead>
				<tr>
					<th><liferay-ui:message key='edison-science-appstore-inputdeck-variable-activation-condition' /></th>
					<th>Name</th>
					<th colspan="3">Value</th>
				</tr>
			</thead>
			<tbody id="inputDeckActivateBody">
			</tbody>
		</table>
		<div id="btnGroupBottom">
			<input type="button" class="button0801" onclick="<portlet:namespace/>closeActivateDiv();" value="<liferay-ui:message key='cancel' />" />
			<input type="button" class="button0801" id="inputDeckAcivateSave" value="<liferay-ui:message key='add' />" />
		</div>
	</div>
	
	
	
	<div class="left table2_list activateSearch" id="activateSearchDiv" style="display: none;">
		<table id="<portlet:namespace/>activateSearchTable" style="width: 100%;">
			<colgroup>
				<col width="20%">
				<col width="*">
			</colgroup>
			<thead>
				<tr>
					<th>Name</th>
					<th>Value</th>
				</tr>
			</thead>
			<tbody id="inputDeckActivateSearchBody">
			</tbody>
		</table>
		<div id="btnGroupBottom">
			<input type="button" class="button0801" onclick="<portlet:namespace/>closeActivateSearchDiv();" value="<liferay-ui:message key='edison-button-board-ok' />" />
		</div>
	</div>
	
	
	
	<div class="left table2_list" id="inputDeckParameterLeft">
		<table id="<portlet:namespace/>variableTable" style="width: 100%;">
			<thead>
				<tr>
					<th width="20%">Variable Name</th>
					<th width="*">Value</th>
					<th width="10%">Description</th>
				</tr>
			</thead>
			<tbody>
			
			</tbody>
		</table>
	</div>
	<aui:form name="frm">
	<div class="right">
		<div class="table1_list" >
			<table border="0" width="100%" class="data_property">
				<colgroup>
					<col width="25%">
					<col width="20%">
					<col width="10%">
					<col width="*%">
				</colgroup>
				<tbody id="inputParameterBody">
					<!--타입 -->
					<tr>
						<th>
							<liferay-ui:message key='edison-table-list-header-type' /> <span class="requiredField">*</span>
						</th>
						<td colspan="3">
							<select id="inputDeckType" onChange="<portlet:namespace/>changeType(this.value,'add');">
								<option value=""><liferay-ui:message key='choice'/></option>
								<option value="<%=InputdeckConstants.TYPE_NUMERIC%>"><%=InputdeckConstants.TYPE_NUMERIC%></option>
								<option value="<%=InputdeckConstants.TYPE_STRING%>"><%=InputdeckConstants.TYPE_STRING%></option>
								<option value="<%=InputdeckConstants.TYPE_LIST%>"><%=InputdeckConstants.TYPE_LIST%></option>
								<option value="<%=InputdeckConstants.TYPE_VECTOR%>"><%=InputdeckConstants.TYPE_VECTOR%></option>
								<option value="<%=InputdeckConstants.TYPE_GROUP%>"><%=InputdeckConstants.TYPE_GROUP%></option>
								<option value="<%=InputdeckConstants.TYPE_COMMENT%>"><%=InputdeckConstants.TYPE_COMMENT%></option>
							</select>
							<span class="requiredField"> ※  <liferay-ui:message key='edison-science-appstore-inputdeck-init-message' /></span>
						</td>
					</tr>
					<!--변수명 -->
					<tr>
						<th>
							<liferay-ui:message key='edison-table-list-header-variable-name' /> <span class="requiredField">*</span>
						</th>
						<td colspan="3">
							<input type="text" class="long_field" id="inputDeckName"/>
						</td>
					</tr>
					
					<!--변수반복-->
					<tr id="varRepet" class="parameter">
						<th>
							<liferay-ui:message key='edison-science-appstore-inputdeck-variable-clone' />
						</th>
						<td colspan="3">
							<select style="width: 100px;" id="inputDeckVarClone">
								<option value=""><liferay-ui:message key='--empty--' /></option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
								<option value="10">10</option>
							</select>
						</td>
					</tr>
					
					<!--별칭 -->
					<tr id="nickName" class="parameter" validation="required">
						<th>
							<liferay-ui:message key='edison-table-list-header-nick-name' /><span class="requiredField">*</span>
						</th>
						<td colspan="3">
							<c:choose>
								<c:when test="${targetLanuage eq 'full'}">
									<liferay-ui:input-localized name="inputDeckNickName" xml=" " cssClass="long_field"  type="input"/>
								</c:when>
								<c:otherwise>
									<input type="text" name="text" class="long_field" id="inputDeckNickName">
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					
					<!--설명 -->
					<tr id="description" class="parameter">
						<th>
							<liferay-ui:message key='edison-simulation-execute-simulation-description' />
						</th>
						<td colspan="3">
							<c:choose>
								<c:when test="${targetLanuage eq 'full'}">
									<liferay-ui:input-localized name="inputDeckDescription" xml=" " cssClass="long_field"  type="input"/>
								</c:when>
								<c:otherwise>
									<input type="text" id="inputDeckDescription" class="long_field">
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					
					<!--단위-->
					<tr id="unit" class="parameter">
						<th>
							Unit
						</th>
						<td colspan="3">
							<input type="text" id="inputDeckUnit" class="short_field noupdate" maxlength="15"/>
						</td>
					</tr>
					
					<!--최소값 -->
					<tr id="valueDomainMin" class="parameter">
						<th>
							<liferay-ui:message key='edison-appstore-min' />
						</th>
						<td class="TC">
							<select style="width: 60px;" id="inputDeckMinSelect" class="noupdate">
								<option value="<">></option>
								<option value="=">>=</option>
							</select>
						</td>
						<td colspan="2">
							<input type="text" id="inputDeckMinValue" class="to_short_field noupdate numberCheck" onkeydown="return checkNumberExp(event,this.value);"/>
						</td>
					</tr>
					
					<!--최대값 -->
					<tr id="valueDomainMax" class="parameter">
						<th>
							<liferay-ui:message key='edison-appstore-max' />
						</th>
						<td class="TC">
							<select style="width: 60px;" id="inputDeckMaxSelect" class="noupdate">
								<option value=">"><</option>
								<option value="="><=</option>
							</select>
						</td>
						<td colspan="2">
							<input type="text" id="inputDeckMaxValue" class="to_short_field noupdate numberCheck" onkeydown="return checkNumberExp(event,this.value);"/>
						</td>
					</tr>
					
					<!--Numeric 기본값 -->
					<tr id="numericValue" class="parameter" validation="required">
						<th>
							<liferay-ui:message key='edison-table-list-header-default-data' /> <span class="requiredField">*</span>
						</th>
						<td colspan="3">
							<input type="text" id="inputDeckNumericValue" class="short_field noupdate numberCheck" onkeydown="return checkNumberExp(event,this.value);"/>
						</td>
					</tr>
					
					<!--String 기본값 -->
					<tr id="stringValue" class="parameter" validation="required">
						<th>
							<liferay-ui:message key='edison-table-list-header-default-data' /> <span class="requiredField">*</span>
						</th>
						<td colspan="3">
							<input type="text" class="long_field noupdate" id="inputDeckStringValue" />
						</td>
					</tr>
					
					<!--sweep -->
					<tr id="sweep" class="parameter" >
						<th id="sweepTh" rowspan="2">
							<input type="checkbox" name="inputDeckSweepCheck" id="inputDeckSweepCheck" onchange="<portlet:namespace/>changeSweep();" class="noupdate"/>
							<label for="inputDeckSweepCheck" style="display: inline;font-weight: 600;">Sweep</label>
						</th>
						<th>
							<liferay-ui:message key='edison-appstore-min' />
						</th>
						<td class="TC">
							<select style="width: 60px;" id="inputDeckSweepMinSelect" class="noupdate">
								<option value="<">></option>
								<option value="=">>=</option>
							</select>
						</td>
						<td>
							<input type="text" class="short_field sweepInput" class="short_field noupdate numberCheck" onkeydown="return checkNumberExp(event,this.value);" id="inputDeckSweepMinValue" />
						</td>
					</tr>
					<tr id="sweep" class="parameter">
						<th>
							<liferay-ui:message key='edison-appstore-max' />
						</th>
						<td class="TC">
							<select style="width: 60px;" id="inputDeckSweepMaxSelect" class="noupdate">
								<option value=">"><</option>
								<option value="="><=</option>
							</select>
						</td>
						<td>
							<input type="text" class="short_field sweepInput" class="short_field noupdate numberCheck" onkeydown="return checkNumberExp(event,this.value);" id="inputDeckSweepMaxValue"/>
						</td>
					</tr>
					
					<!--dimension -->
					<tr id="dimension" class="parameter">
						<th>
							Dimension
						</th>
						<td colspan="3">
							<select onChange="<portlet:namespace/>changeDimension(this.value);" id="inputDeckDemensionSelect" class="noupdate">
								<option value ="2"><liferay-ui:message key='edison-science-appstore-inputdeck-dimension-2'/></option>
								<option value ="3"><liferay-ui:message key='edison-science-appstore-inputdeck-dimension-3'/></option>
								<option value ="4"><liferay-ui:message key='edison-science-appstore-inputdeck-dimension-4'/></option>
							</select>
						</td>
					</tr>
					<tr id="dimension" class="parameter">
						<th>
							<liferay-ui:message key='edison-table-list-header-default-data'/> <span class="requiredField">*</span>
						</th>
						<td colspan="3" id="dimensionValueTd">
							<input type="text" class="to_short_field noupdate" id="inputDeckDimensionValue_0"/>
							<input type="text" class="to_short_field noupdate" id="inputDeckDimensionValue_1"/>
						</td>
					</tr>
					
					
					
					<!--list-->
					<tr id="list" class="parameter">
						<th>
							Name
						</th>
						<td>
							<c:choose>
								<c:when test="${targetLanuage eq 'full'}">
									<liferay-ui:input-localized name="inputDeckListName" xml=" " cssClass="short_field noupdate"  type="input"/>
								</c:when>
								<c:otherwise>
									<input type="text" id="inputDeckListName" class="short_field noupdate">
								</c:otherwise>
							</c:choose>
						</td>
						<td rowspan="2" class="TC">
							<input type="button" value="<liferay-ui:message key='add'/>" onClick="<portlet:namespace/>listBtnEvent('add');" class="noupdate"><br/>
							<input type="button" value="<liferay-ui:message key='delete'/>" onClick="<portlet:namespace/>listBtnEvent('delete');" class="noupdate">
						</td>
						<td rowspan="2">
							<select id="inputDeckListParemter" style="width: 120px;">
								
							</select>
						</td>
					</tr>
					<tr id="list" class="parameter">
						<th>
							Value
						</th>
						<td>
							<input type="text" id="para_listValue" class="short_field noupdate"/>
						</td>
					</tr>
					
					<!--comment-->
					<tr id="comment" class="parameter">
						<th>
							<liferay-ui:message key='edison-table-list-header-content' />
						</th>
						<td colspan="3">
							<input type="text" class="long_field noupdate" id="inputDeckComment"/>
						</td>
					</tr>
					
					<!--그룹선택-->
					<tr id="groupChoice" class="parameter">
						<th>
							<liferay-ui:message key='edison-science-appstore-inputdeck-group-choice' />
						</th>
						<td colspan="3">
							
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div id="btnGroupBottom" class="addBtnGroup">
			<input type="button" class="button0801 parameter" id="variableActivationBtn" onclick="<portlet:namespace/>addActivateOpen();" value="<liferay-ui:message key='edison-science-appstore-inputdeck-variable-activation-conditions' />" />
			<input type="button" class="button0801 actieveBtn" onclick="<portlet:namespace/>changeType('','add');" value="<liferay-ui:message key='cancel' />" />
			<input type="button" class="button0801 actieveBtn" onclick="<portlet:namespace/>paraSave(true);" value="<liferay-ui:message key='add' />" />
		</div>
		<div id="btnGroupBottom" class="updateBtnGroup">
			<input type="button" class="button0801 actieveBtn" onclick="<portlet:namespace/>activateSearchOpen();" value="<liferay-ui:message key='edison-science-appstore-inputdeck-variable-activation-conditions' />" />
			<input type="button" class="button0801 actieveBtn" onclick="<portlet:namespace/>changeType('','add');" value="<liferay-ui:message key='cancel' />" />
			<input type="button" class="button0801 actieveBtn" onclick="<portlet:namespace/>paraUpdate();" value="<liferay-ui:message key='update' />" />
			<input type="button" class="button0801 actieveBtn" onclick="<portlet:namespace/>paraDelete();" value="<liferay-ui:message key='edison-button-board-delete' />" />
		</div>
	</div>
	</aui:form>
</div>



<%-- <link rel="stylesheet" type="text/css" href="${contextPath}/css/style.css"> --%>
<%-- <link rel="stylesheet" type="text/css" href="${contextPath}/css/jquery/jquery-ui.min.css"> --%>
<%-- <link rel="stylesheet" type="text/css" href="${contextPath}/css/jquery/jquery-ui.theme.min.css"> --%>
<%-- <script type="text/javascript" src="${contextPath}/js/jquery-1.10.2.min.js"></script> --%>
<%-- <script type="text/javascript" src="${contextPath}/js/jquery-ui.min.js"></script> --%>

<link rel="stylesheet" type="text/css" href="${contextPath}/css/style.css">
<link rel="stylesheet" type="text/css" href="${contextPath}/css/jquery/jquery-ui.min.css">
<link rel="stylesheet" type="text/css" href="${contextPath}/css/jquery/jquery-ui.theme.min.css">
<script type="text/javascript" src="${contextPath}/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/jquery-ui.min.js"></script>


<script type="text/javascript" src="${contextPath}/js/editor/inputdeck/hashmap.js"></script>
<script type="text/javascript" src="${contextPath}/js/editor/inputdeck/inputdeck_form.js"></script>
<!-- <script type="text/javascript" src="${contextPath}/js/editor/inputdeck/inputdeck_maker.js"></script>  --> 
<%@ include file="/js/editor/inputdeck/inputdeck_maker.jspf"%>
<script type="text/javascript">
 	var portletNameSpace = "<portlet:namespace/>";
 	var contextPath  = "${contextPath}";

	var targetLanuage = "${targetLanuage}";//full
	var defaultLanguage = "${defaultLanguage}";//lanuage
	var availableLanguages = "${availableLanguages}";
	var availableLanguagesArray = availableLanguages.replace(/^{*|}*$/g, '').split(",");
	
	var inputdeckForm = new InputdeckForm();
	inputdeckForm.setVectorFormSpace(false);
	inputdeckForm.setLineFormSpace(false);
	
	var editorVariableMap = inputdeckForm.getVariableMap();
	
	$(function(){
		<portlet:namespace/>init();
		<portlet:namespace/>lineFormat();
		<portlet:namespace/>vectorFormat();
		$(document).tooltip();
		
// 		var form =  createInputDeckFormData();
// 		console.log(JSON.stringify(form));
// 		createInputDeckEditor(form);
	});
	
	
	
	function log(functionName){
		console.log(functionName);
		console.log(inputdeckForm);
		console.log(availableLanguagesArray);
		console.log(JSON.stringify(inputdeckForm));
	}
	
	function <portlet:namespace/>init(){
		//초반 객체 생성
		inputdeckForm.setDefaultLanguageId(defaultLanguage);
		inputdeckForm.setAvailableLanguageIds(availableLanguages);
		log("init");
	}
	
	
	function <portlet:namespace/>lineFormat(val){
		var valueDelimiter = $("#valueDelimiter option:selected").val();
		var lineDelimiter = $("#lineDelimiter option:selected").val();
		var lineChar = $("#lineChar").val();
		
		var text = lineChar+"KEY"+valueDelimiter+"VALUE"+lineDelimiter;
		$("#linePreview").val(text);
		
		var lineForm = inputdeckForm.getLineForm();
		lineForm.setValues(valueDelimiter,lineDelimiter,lineChar);
		
// 		$("#<portlet:namespace/>variableTable > tbody").find("tr").remove();
		createInputDeckEditor(inputdeckForm);
	}
	
	function <portlet:namespace/>vectorFormat(){
		var vectorBracketStartValue = "";
		var vectorBracketEndValue = "";
		
		var vectorBracket = $("#vectorBracket option:selected").val();
		
		if(vectorBracket==InputdeckConstants.BRACE_TYPE_SQUARE){
			vectorBracketStartValue = "[";
			vectorBracketEndValue = "]";
		}else if(vectorBracket==InputdeckConstants.BRACE_TYPE_SQUARE_SPACE){
			vectorBracketStartValue = "[ ";
			vectorBracketEndValue = " ]";
		}else if(vectorBracket==InputdeckConstants.BRACE_TYPE_ROUND){
			vectorBracketStartValue = "(";
			vectorBracketEndValue = ")";
		}else if(vectorBracket==InputdeckConstants.BRACE_TYPE_ROUND_SPACE){
			vectorBracketStartValue = "( ";
			vectorBracketEndValue = " )";
		}
		
		var vectorDelimiter = $("#vectorDelimiter option:selected").val();
		
		var text = vectorBracketStartValue+"A"+vectorDelimiter+"B"+vectorDelimiter+"C"+vectorBracketEndValue;
		$("#vectorPreview").val(text);
		
		var vectorForm = inputdeckForm.getVectorForm();
		vectorForm.setBraceChar(vectorBracket);
		vectorForm.setSample(text);
		vectorForm.setDelimiter(vectorDelimiter);
		
		
		//1|2|3
		//기존 vector value 변경
		var nameArray = inputdeckForm.getVariableNamesByType(InputdeckConstants.VARIABLE_TYPE_VECTOR);
		if(nameArray.length!=0){
			for(var i=0; i<nameArray.length;i++){
				var vectorVariableMap = inputdeckForm.getVariable(nameArray[i])
				var replaceChar = vectorVariableMap[InputdeckConstants.VALUE].replace(/[^0-9]/g,'|');
				
				var charIndex = 0;
				for(var j=0;j<replaceChar.length;j++){
					var  isNanChar = Number(replaceChar.charAt(j));
					if(isNaN(isNanChar)){
						charIndex++;
					}else{
						break;
					}
				}
				vectorVariableMap.setValue(<portlet:namespace/>createVectorValue(replaceChar.substring(charIndex,replaceChar.length-charIndex)));
			}
		}
	}
	
	
	function <portlet:namespace/>addActivateOpen(){
		if(!$('#activateDiv').is(":visible")){
			if(confirm(Liferay.Language.get('edison-science-appstore-inputdeck-activation-add-message'))){
	 			var paraName = $("#inputDeckName").val().trim();
	 			
	 			
	 			if(<portlet:namespace/>paraSave(true)){
		 			<portlet:namespace/>drowActivateOption();
		 			//저장 버튼 이벤트 정의
		 			$("#inputDeckAcivateSave").attr("onclick","<portlet:namespace/>inputDeckActivate('"+paraName+"')");
		 			
					$('#activateDiv').show('slide', {direction: 'left'}, 700);
					$('#inputDeckParameterLeft').hide(600);
	 			}
			}
		}
	}
	
	//활성화 조건 DIV open
	function <portlet:namespace/>activateSearchOpen(){
		if(!$('#activateSearchDiv').is(":visible")){
			<portlet:namespace/>drowActivateSearchOption();
			
			$('#activateSearchDiv').show('slide', {direction: 'left'}, 700);
			$('#inputDeckParameterLeft').hide(600);
		}
	}
	
	
	//활성화 조건 변수 출력
	function <portlet:namespace/>drowActivateOption(){
		var variableActivateArray = inputdeckForm.getVariableNamesActivateList();
		if(variableActivateArray[0]!=""){
			for(var i=0;i<variableActivateArray.length;i++){
				var variable = inputdeckForm.getVariable(variableActivateArray[i]);
				switch( variable.getType() ){
					case InputdeckConstants.VARIABLE_TYPE_NUMERIC:
						<portlet:namespace/>drowActivateInputNumberForm(variable);
						break;
					case InputdeckConstants.VARIABLE_TYPE_LIST:
						<portlet:namespace/>drowActivateListForm(variable );
						break;
				}
			}
		}
	}
	
	//활성화 조건 변수 조회
	function <portlet:namespace/>drowActivateSearchOption(){
		var name = $("#inputDeckName").val().trim();
		
		//variable 객체 조회
		var activateSearchVariable = editorVariableMap.getVariable(name);
		var container = activateSearchVariable.getActivateConditionContainer().getContainer();
		
		container.forEach(function(condition, index) {
			switch( condition.getType() ){
				case InputdeckConstants.VARIABLE_TYPE_NUMERIC:
					var lowerLimit = condition.getDomainLowerLimit();
					var upperLimit = condition.getDomainUpperLimit();
					var opperand = condition.getDomainOperand();
					
					$tbody = $("#inputDeckActivateSearchBody");
					
					$tr = $("<tr/>")
					$("<td/>").html(condition.getVariableName()).appendTo($tr);
					
					$valueTd = $("<td/>").addClass("TC").appendTo($tr);
					
					$("<input/>").attr("type","text").addClass("to_short_field")
								 .prop("disabled",true)
								 .val(lowerLimit).appendTo($valueTd);
					
					$minSelect = $("<select/>").append(
							$("<option/>").val("<").html("<")
							 ).append(
							$("<option/>").val("=").html("<=")
							 ).css("margin","5px").prop("disabled",true).appendTo($valueTd);
					
					$minSelect.find("option[value='"+opperand.charAt(0)+"']").prop("selected",true);
					
					$maxSelect = $("<select/>").append(
							$("<option/>").val(">").html(">")
							 ).append(
							$("<option/>").val("=").html(">=")
							 ).css("margin","5px").prop("disabled",true).appendTo($valueTd);
					
					$maxSelect.find("option[value='"+opperand.charAt(1)+"']").prop("selected",true);
					
					
					$("<input/>").attr("type","text").addClass("to_short_field")
								 .prop("disabled",true)
								 .val(upperLimit).appendTo($valueTd);
					
					$tr.appendTo($tbody);
				break;
				case InputdeckConstants.VARIABLE_TYPE_LIST:
					$tbody = $("#inputDeckActivateSearchBody");
					
					$tr = $("<tr/>")
					$("<td/>").html(condition.getVariableName()).appendTo($tr);
					
					$select = $("<select/>");
					var listMap = variable.getLocalizedListMap(defaultLanguage);
					
					for (var key in listMap){
						$("<option/>").val(key).html(listMap[key]).appendTo($select);
					}
				break;
			}
		});
	}
	
	
	function <portlet:namespace/>drowActivateInputNumberForm(variable){
		$tbody = $("#inputDeckActivateBody");
		
		var lowerLimit = variable.getValueDomainLowerLimit();
		var upperLimit =variable.getValueDomainUpperLimit();
		var name = variable.getNameLocalizedText( defaultLanguage );
		
		$tr = $("<tr/>").attr("activateType",InputdeckConstants.VARIABLE_TYPE_NUMERIC).attr("activateName",variable.getName());
		
		$("<td/>").append(
				$("<input/>").attr("type","checkbox").css("margin","0px")
				).addClass("TC").appendTo($tr);
		
		$("<td/>").html(name).appendTo($tr);
		
		$numericTd = $("<td/>").attr("colspan","3").addClass("TC");
		
		$("<input/>").attr("type","text").addClass("to_short_field")
					 .attr("onkeydown","return onlyNumber(event)")
					 .attr("onkeyup","removeChar(event)")
					 .attr("id","inputDeckActivateMinValue")
					 .val(lowerLimit)
					 .css("ime-mode","disabled").appendTo($numericTd);
		
		$("<select/>").append(
					$("<option/>").val("<").html("<")
					 ).append(
					$("<option/>").val("=").html("<=")
					 ).attr("id","inputDeckActivateMinSelect").css("margin","5px").appendTo($numericTd);

		$("<span/>").html("value").appendTo($numericTd);
		
		$("<select/>").append(
					$("<option/>").val(">").html(">")
					 ).append(
					$("<option/>").val("=").html(">=")
					 ).attr("id","inputDeckActivateMaxSelect").css("margin","5px").appendTo($numericTd);
		
		
		$("<input/>").attr("type","text").addClass("to_short_field")
					 .attr("onkeydown","return onlyNumber(event)")
					 .attr("onkeyup","removeChar(event)")
					 .attr("id","inputDeckActivateMaxValue")
					 .val(upperLimit)
					 .css("ime-mode","disabled").appendTo($numericTd);
		
		$numericTd.appendTo($tr);
		
		$tr.appendTo($tbody);
	}
	
	function <portlet:namespace/>drowActivateListForm(variable){
		
		$tbody = $("#inputDeckActivateBody");
		var text = variable.getNameLocalizedText(defaultLanguage);
		var name = variable.getName();
		
		$tr = $("<tr/>").attr("activateType",InputdeckConstants.VARIABLE_TYPE_LIST).attr("activateName",name);
		$("<td/>").append(
				$("<input/>").attr("type","checkbox").css("margin","0px")
				).addClass("TC").appendTo($tr);
		
		$("<td/>").html(text).appendTo($tr);
		
		$select = $("<select/>").attr("id","inputDeckActivateListFrom_"+name);
		
		var listMap = variable.getLocalizedListMap(defaultLanguage);
		
		for (var key in listMap){
			$("<option/>").val(key).html(listMap[key]).appendTo($select);
		}
		
		$("<td/>").append($select).addClass("TC").appendTo($tr);
		
		$("<td/>").append(
					$("<input/>").val(Liferay.Language.get('add')).attr("type","button")
					.attr("onClick","<portlet:namespace/>activateListMove('add','"+name+"')")
				).append(
					$("<br/>")
				).append(
					$("<input/>").val(Liferay.Language.get('delete')).attr("type","button")
					.attr("onClick","<portlet:namespace/>activateListMove('remove','"+name+"')")
				).addClass("TC").appendTo($tr);
		
		$("<td/>").addClass("TC").append($("<select/>").attr("id","inputDeckActivateListTarget_"+name)).appendTo($tr);
		
		$tr.appendTo($tbody);
	}
	
	
	//활성화 select event
	function <portlet:namespace/>activateListMove(state,name){
		var fromSelect 
		var targetSelect;
		if(state=='add'){
			fromSelect = $("#inputDeckActivateListFrom_"+name);
			targetSelect = $("#inputDeckActivateListTarget_"+name);
		}else{
			fromSelect = $("#inputDeckActivateListTarget_"+name);
			targetSelect = $("#inputDeckActivateListFrom_"+name);
		}
		
		fromSelect.find("option:selected").clone().appendTo(targetSelect);
		fromSelect.find("option:selected").remove();
	}
	
	
	function <portlet:namespace/>closeActivateSearchDiv(){
		$("#activateSearchDiv").hide('slide', {direction: 'left'}, 500);
		$('#inputDeckParameterLeft').show(400);
		$("#inputDeckActivateSearchBody tr").remove();
	}
	
	function <portlet:namespace/>closeActivateDiv(){
		$("#activateDiv").hide('slide', {direction: 'left'}, 500);
		$('#inputDeckParameterLeft').show(400);
		$("#inputDeckActivateBody tr").remove();
	}
	
	//활성화 변수 저장
	function <portlet:namespace/>inputDeckActivate(paraName){
		var targetVariable = inputdeckForm.getVariable(paraName);
		var activateCondition = targetVariable.getActivateConditionContainer();
		
		$("#inputDeckActivateBody ").children("tr").each(function(){
			if($(this).find(":checkbox").prop("checked")){
				if($(this).attr("activatetype")==InputdeckConstants.VARIABLE_TYPE_NUMERIC){
					var name = $(this).attr("activateName");
					var minValue = $(this).find("input[id=inputDeckActivateMinValue]").val();
					var maxValue = $(this).find("input[id=inputDeckActivateMaxValue]").val();
					
					var minChar = $(this).find("select[id=inputDeckActivateMinSelect] option:selected").val();
					var maxChar = $(this).find("select[id=inputDeckActivateMaxSelect] option:selected").val();
					
					var numericActivate = activateCondition.addNumericActivateCondition(name, minValue, maxValue, minChar+maxChar);
					if(numericActivate==InputdeckErrors.LOWER_LIMIT_INVALID){
						$(this).find("input[id=inputDeckActivateMinValue]").focus();
						throw stop;
					}else if(numericActivate==InputdeckErrors.UPPER_LIMIT_INVALID){
						$(this).find("input[id=inputDeckActivateMaxValue]").focus();
						throw stop;
					}
				}
				
				if($(this).attr("activatetype")==InputdeckConstants.VARIABLE_TYPE_LIST){
					var name = $(this).attr("activateName");
					$(this).find($("#inputDeckActivateListTarget_"+name)).find("option").each(function(){
						activateCondition.addListItemActivateCondition(name, $(this).val());
					});
				}
			}
		});
		
		<portlet:namespace/>closeActivateDiv();
	}
	
	//조회
	function <portlet:namespace/>searchParameter(searchVariableName){
		var searchVariable = inputdeckForm.getVariable(searchVariableName);
		
		$('#inputDeckType option[value='+searchVariable.getType()+']').prop('selected', true);
		<portlet:namespace/>changeType(searchVariable.getType(),'update');
		
		$("#varRepet").show();
		$("#inputDeckVarClone").val("");
		
		//변수명
		$("#inputDeckName").val(searchVariable.getName());
		
		var searchJson;
		var type = searchVariable.getType();
		
		if(type==InputdeckConstants.VARIABLE_TYPE_NUMERIC){
			searchJson = JSON.parse(numericShowTrJson);
		}else if(type==InputdeckConstants.VARIABLE_TYPE_STRING){
			searchJson = JSON.parse(stringShowTrJson);
		}else if(type==InputdeckConstants.VARIABLE_TYPE_LIST){
			searchJson = JSON.parse(listShowTrJson);
		}else if(type==InputdeckConstants.VARIABLE_TYPE_VECTOR){
			searchJson = JSON.parse(vectorShowTrJson);
		}else if(type==InputdeckConstants.VARIABLE_TYPE_GROUP){
			searchJson = JSON.parse(groupShowTrJson);
		}else if(type==InputdeckConstants.VARIABLE_TYPE_COMMENT){
			searchJson = JSON.parse(commentShowTrJson);
		}
		
		$("#inputParameterBody > tr[class=parameter]").each(function() {
			var key = $(this).attr("id");
			
			if($(this).is(":visible")&&searchJson[key]){
				//nickName
				if(key=='nickName'){
					if(targetLanuage=='full'){
						<portlet:namespace/>localizedInputSet('inputDeckNickName',searchVariable.getNameLocalizedXML(availableLanguages,defaultLanguage));
					}else{
						$("#inputDeckNickName").val(searchVariable.getNameLocalizedText(defaultLanguage));
					}
				}else if(key=='description'){
					if(targetLanuage=='full'){
						<portlet:namespace/>localizedInputSet('inputDeckDescription',searchVariable.getLocalizedDescriptionXML(availableLanguages,defaultLanguage));
					}else{
						$("#inputDeckDescription").val(searchVariable.getLocalizedDescription(defaultLanguage));
					}
				}else if(key=='groupChoice'){
					//현재 variable이 속해 있는 Group을 가지고 올수 있는 함수가 필요함.
				}else if(key=='stringValue'){
					$("#inputDeckStringValue").val(searchVariable.getValue());
				}else if(key=='list'){
					var listMap = searchVariable.getLocalizedListMap(defaultLanguage);
					$select  = $("#inputDeckListParemter");
					for ( val in listMap){
						$("<option/>").val(val).html(listMap[val]).appendTo($select);
					}
				}else if(key=='dimension'){
					var vectorForm = inputdeckForm.getVectorForm();
					var delimiter = vectorForm.getDelimiter();
					
					var value = searchVariable.getValue();
					value = changeVectorToValue(value);
					
					var valueArr = value.split(delimiter);
					var dimension = searchVariable.getDimension(); 
					
					$("#inputDeckDemensionSelect option[value="+dimension+"]").prop("selected",true);
					
					for(var i=0; i<dimension;i++){
						$("#inputDeckDimensionValue_"+i).val(trim(valueArr[i]));
					}
				}else if(key=='valueDomainMin'){
					var lowerLimit = searchVariable.getValueDomainLowerLimit();
					if(typeof lowerLimit != "undefined"){
						$("#inputDeckMinValue").val(lowerLimit);
						$("#inputDeckMinSelect option[value='"+searchVariable.getValueDomainOperand().charAt(0)+"']").prop("selected",true);
					}
				}else if(key=='valueDomainMax'){
					var upperLimit = searchVariable.getValueDomainUpperLimit();
					if(typeof upperLimit != "undefined"){
						$("#inputDeckMaxValue").val(upperLimit);
 						$("#inputDeckMaxSelect option[value='"+searchVariable.getValueDomainOperand().charAt(1)+"']").prop("selected",true);
					}
					
				}else if(key=='sweep'){
					if(searchVariable.isSweepable()){
						var lowerSweep =searchVariable.getSweepDomainLowerLimit();
						var upperSweep =searchVariable.getSweepDomainUpperLimit();
						var opSweep = searchVariable.getSweepDomainOperand();
						
						$("#inputDeckSweepCheck").prop("checked",true);
						
						$("#inputDeckSweepMinValue").val(lowerSweep);
						$("#inputDeckSweepMaxValue").val(upperSweep);
						
						$("#inputDeckSweepMinSelect option[value='"+opSweep.charAt(0)+"']").prop("selected",true);
						$("#inputDeckSweepMaxSelect option[value='"+opSweep.charAt(1)+"']").prop("selected",true);
					}
				}else if(key=='numericValue'){
					$("#inputDeckNumericValue").val(searchVariable.getValue());
				}else if(key=='comment'){
					$("#inputDeckComment").val(searchVariable.getValue());
				}
				
				searchJson[key] = false;
			}
		});
		
	}
	
	//다국어 필드 값 셋팅
	function <portlet:namespace/>localizedInputSet(paramName,xmlData){
		var xml = $.parseXML( xmlData );
		$("#<portlet:namespace/>"+paramName+"ContentBox div:last").click();
		var upperParamName = paramName.charAt(0).toUpperCase() + paramName.substr(1);
		
		var size = availableLanguagesArray.length;
		for(var i=0;i<size;i++){
			var lanuage = availableLanguagesArray[i];
			$("#<portlet:namespace/>"+paramName+"_"+lanuage).val($(xml).find("[language-id ='"+lanuage+"']").text());
		}
		$("#<portlet:namespace/>"+paramName).attr("placeholder",$(xml).find("[language-id ='"+defaultLanguage+"']").text());
		$("#<portlet:namespace/>"+paramName+"ContentBox").find("li[data-value='"+defaultLanguage+"']").trigger("click");
		
	}
	
	function <portlet:namespace/>paraDelete(){
		if(confirm(Liferay.Language.get('edison-science-appstore-inputdeck-delete-message'))){
			var paraName = $("#inputDeckName").val().trim();
			editorVariableMap.removeVariable(paraName);
// 			$("#<portlet:namespace/>variableTable > tbody").find("tr").remove();
			<portlet:namespace/>changeType('','add');
			createInputDeckEditor(inputdeckForm);
		}
		
	}
	
	
	function <portlet:namespace/>paraUpdate(){
		var paraType = $("#inputDeckType option:selected").val();
		var paraName = $("#inputDeckName").val().trim();
		
		var json;
		if(paraType==InputdeckConstants.VARIABLE_TYPE_NUMERIC){
			json = JSON.parse(numericShowTrJson);
		}else if(paraType==InputdeckConstants.VARIABLE_TYPE_STRING){
			json = JSON.parse(stringShowTrJson);
		}else if(paraType==InputdeckConstants.VARIABLE_TYPE_LIST){
			json = JSON.parse(listShowTrJson);
		}else if(paraType==InputdeckConstants.VARIABLE_TYPE_VECTOR){
			json = JSON.parse(vectorShowTrJson);
		}else if(paraType==InputdeckConstants.VARIABLE_TYPE_GROUP){
			json = JSON.parse(groupShowTrJson);
		}else if(paraType==InputdeckConstants.VARIABLE_TYPE_COMMENT){
			json = JSON.parse(commentShowTrJson);
		}
		
		//validation
		$("#inputParameterBody > tr[class=parameter]").each(function() {
			var key = $(this).attr("id");
			if(json[key]){
				if(typeof $(this).attr("validation") != "undefined"){
					if(!<portlet:namespace/>checkRequiredField(key)){
						throw "stop";
					}
				}
			}
		});
		
		
		//variable 객체 조회
		var updateVariable = editorVariableMap.getVariable(paraName);
		
		$("#inputParameterBody > tr[class=parameter]").each(function() {
			var key = $(this).attr("id");
			if(json[key]){
				//nickName
				if(key=='nickName'){
					<portlet:namespace/>dynamicInputSave(updateVariable,key);
				}else if(key=='description'){
					<portlet:namespace/>dynamicInputSave(updateVariable,key);
				}
			}
		});
		
		//변수복사
		if($("#inputDeckVarClone option:selected").val()!=""){
			var cnt = $("#inputDeckVarClone option:selected").val();
			if(updateVariable.getType()==InputdeckConstants.VARIABLE_TYPE_GROUP){
				inputdeckForm.cloneVariableGroup(updateVariable,cnt);
			}else{
				inputdeckForm.cloneVariable(updateVariable,cnt);
			}
		}
		
		<portlet:namespace/>changeType('','add');
// 		$("#<portlet:namespace/>variableTable > tbody").find("tr").remove();
		createInputDeckEditor(inputdeckForm);
	}

	
	function <portlet:namespace/>paraSave(saveAfterClose){
		
		var paraType = $("#inputDeckType option:selected").val();
		var paraName = $("#inputDeckName").val().trim();
		
		if(paraName==''){
			alert(Liferay.Language.get('this-field-is-mandatory'));
			$("#inputDeckName").focus();
			return false;
		}
		
		if(!/^[\_?a-zA-Z0-9]+$/.test(paraName)){
			alert(Liferay.Language.get('expression-is-not-valid-ex-3',['parma_1','param1','param']));
			$("#inputDeckName").focus();
			return false;
		}
		
		var json;
		if(paraType==InputdeckConstants.VARIABLE_TYPE_NUMERIC){
			json = JSON.parse(numericShowTrJson);
		}else if(paraType==InputdeckConstants.VARIABLE_TYPE_STRING){
			json = JSON.parse(stringShowTrJson);
		}else if(paraType==InputdeckConstants.VARIABLE_TYPE_LIST){
			json = JSON.parse(listShowTrJson);
		}else if(paraType==InputdeckConstants.VARIABLE_TYPE_VECTOR){
			json = JSON.parse(vectorShowTrJson);
		}else if(paraType==InputdeckConstants.VARIABLE_TYPE_GROUP){
			json = JSON.parse(groupShowTrJson);
		}else if(paraType==InputdeckConstants.VARIABLE_TYPE_COMMENT){
			json = JSON.parse(commentShowTrJson);
		}
		
		//validation
		$("#inputParameterBody > tr[class=parameter]").each(function() {
			var key = $(this).attr("id");
			if(json[key]){
				if(typeof $(this).attr("validation") != "undefined"){
					if(!<portlet:namespace/>checkRequiredField(key)){
						throw "stop";
					}
				}
				
				//리스트 일 경우
				if(key=='list'){
					if($("#inputDeckListParemter option").length==0){
						alert(Liferay.Language.get('this-field-is-mandatory'));
						$("#inputDeckListParemter").focus();
						throw "stop";
					}
				}
				
				//벡터 일경우 
				if(key=='dimension'){
					$("#dimensionValueTd").find(":text").each(function(){
						if($(this).val()==""){
							alert(Liferay.Language.get('this-field-is-mandatory'));
							$(this).focus();
							throw "stop";
						}
						
					})
				}
				
				
				if(key=='valueDomainMax'){
					var valueDomainMinValue = parseFloat($("#inputDeckMinValue").val());
					var valueDomainMaxValue = parseFloat($("#inputDeckMaxValue").val());
					if(valueDomainMinValue!=""&&valueDomainMaxValue!=""){
						if(valueDomainMinValue>=valueDomainMaxValue){
							alert(Liferay.Language.get('edison-science-appstore-inputdeck-numeric-size-error-message'));
							$(this).focus();
							throw "stop";
						}
					}
				}
				
				if(key=='sweep'){
					if($("#inputDeckSweepCheck").prop( "checked" )){
						var sweepDomainMinValue = $("#inputDeckSweepMinValue").val();
						var sweepDomainMaxValue = $("#inputDeckSweepMaxValue").val();
					}
					
					if(sweepDomainMinValue>=sweepDomainMaxValue){
						alert(Liferay.Language.get('edison-science-appstore-inputdeck-numeric-size-error-message'));
						throw "stop";
					}
				}
				
				
			}
		});
		
		//variable 객체 생성
		var variable = editorVariableMap.createVariable(paraName);
		
		if(variable==null){
			alert(Liferay.Language.get('edison-table-list-header-variable-name')+" "+Liferay.Language.get('duplicate'));
			$("#inputDeckName").focus();
			return false;
		}
		
		variable.setType(paraType);
		
		//GROUP 타입 일경우  setValue
		if(paraType==InputdeckConstants.VARIABLE_TYPE_GROUP){
			variable.setValue(paraName);
		}
		
		
		//data 저장
		<portlet:namespace/>saveData(variable,json);
		
		log("paraSave");
		
		//data save 후 초기화
		if(saveAfterClose){
			<portlet:namespace/>changeType('','add');
// 			$("#<portlet:namespace/>variableTable > tbody").find("tr").remove();
			createInputDeckEditor(inputdeckForm);
		}
		
		log("createInputDeckEditor");
		
		return true;
		
	}
	
	
	function <portlet:namespace/>saveData(variable,json){
		var saveJson = json;
		$("#inputParameterBody > tr[class=parameter]").each(function() {
			var key = $(this).attr("id");
			
			if(saveJson[key]){
				//nickName
				if(key=='nickName'){
					<portlet:namespace/>dynamicInputSave(variable,key);
				}else if(key=='description'){
					<portlet:namespace/>dynamicInputSave(variable,key);
				}else if(key=='groupChoice'){
					var groupValue = $("#inputDeckGroupChoiceSelect option:selected").val();
					if(groupValue!=""){
						var groupVariable = inputdeckForm.getVariable(groupValue);
						var activateCondition = groupVariable.getActivateConditionContainer();
						activateCondition.addGroupActivateCondition(variable.getName());
					}
				}else if(key=='unit'){
					variable.setUnit($("#inputDeckUnit").val());
				}else if(key=='valueDomainMax'){
					var valueDomainMinChar = $("#inputDeckMinSelect option:selected").val();
					var valueDomainMinValue = $("#inputDeckMinValue").val();
					
					var valueDomainMaxChar = $("#inputDeckMaxSelect option:selected").val();
					var valueDomainMaxValue = $("#inputDeckMaxValue").val();
					
					if(valueDomainMinValue!=""&&valueDomainMaxValue!=""){
						variable.setValueDomainValues(valueDomainMinValue,valueDomainMaxValue,valueDomainMinChar+valueDomainMaxChar);
					}
				}else if(key=='numericValue'){
					variable.setValue($("#inputDeckNumericValue").val());
				}else if(key=='stringValue'){
					variable.setValue($("#inputDeckStringValue").val());
				}else if(key=='sweep'){
					if($("#inputDeckSweepCheck").prop( "checked" )){
						variable.setSweepable(true);
						
						var sweepDomainMinChar = $("#inputDeckSweepMinSelect option:selected").val();
						var sweepDomainMinValue = $("#inputDeckSweepMinValue").val();
						var sweepDomainMaxChar = $("#inputDeckSweepMaxSelect option:selected").val();
						var sweepDomainMaxValue = $("#inputDeckSweepMaxValue").val();
						
						if(sweepDomainMinValue!=""&&sweepDomainMaxValue!=""){
							variable.setSweepDomainValues(sweepDomainMinValue,sweepDomainMaxValue,sweepDomainMinChar+sweepDomainMaxChar);
						}
					}else{
						variable.setSweepable(false);
					}
					
					
				}else if(key=='dimension'){
					var value = $("#inputDeckDemensionSelect option:selected").val();
					variable.setDimension(value);
					var text = "";
					for(var i=0;i<value;i++){
						var inputDeckDimensionValue = $("#inputDeckDimensionValue_"+i).val();
						if(i==0){
							text+=inputDeckDimensionValue;
						}else{
							text+="|"+inputDeckDimensionValue;
						}
					}
					variable.setValue(<portlet:namespace/>createVectorValue(text));
				}else if(key=='list'){
					var listMap = variable.getListMap();
					var size = availableLanguagesArray.length;
					var i=1;
					var defaultValue = "";
					$("#inputDeckListParemter option").each(function(){
						var listItem = new ListItem();
						listItem.setItemValue($(this).val());
						if(defaultValue==""){
							defaultValue = $(this).val();
						}
						
						if(targetLanuage=='full'){
							for(var j=0;j<size; j++){
								var lanuage = availableLanguagesArray[j];
								var lanuageValue = $(this).attr(lanuage);
								listItem.addLocalizedText(lanuage,lanuageValue);
							}
						}else{
							listItem.addLocalizedText(defaultLanguage,$(this).html());
						}
						
						listMap.addListItem($(this).val(), listItem);
						i++;
					});
					//List Type 일 경우 option의 첫번째 값이 default 값이 된다.
					variable.setValue(defaultValue);
					
				}else if(key=='comment'){
					variable.setValue($("#inputDeckComment").val());
				}
				saveJson[key] = false;
			}
		});
	}
	
	//Vector value 변경
	//ex)1|2|3|4
	function <portlet:namespace/>createVectorValue(value){
		var vectorBracketStartValue = "";
		var vectorBracketEndValue = "";
		
		var vectorBracket = $("#vectorBracket option:selected").val();
		
		if(vectorBracket==InputdeckConstants.BRACE_TYPE_SQUARE){
			vectorBracketStartValue = "[";
			vectorBracketEndValue = "]";
		}else if(vectorBracket==InputdeckConstants.BRACE_TYPE_SQUARE_SPACE){
			vectorBracketStartValue = "[ ";
			vectorBracketEndValue = " ]";
		}else if(vectorBracket==InputdeckConstants.BRACE_TYPE_ROUND){
			vectorBracketStartValue = "(";
			vectorBracketEndValue = ")";
		}else if(vectorBracket==InputdeckConstants.BRACE_TYPE_ROUND_SPACE){
			vectorBracketStartValue = "( ";
			vectorBracketEndValue = " )";
		}
		
		var vectorDelimiter = $("#vectorDelimiter option:selected").val();
		
		var text = "";
		var valueArray = value.split("|");
		text += vectorBracketStartValue;
		
		for(var i=0;i<valueArray.length;i++){
			if(i==0){
				text += valueArray[i];
			}else{
				text += vectorDelimiter+valueArray[i];
			}
		}
		text += vectorBracketEndValue;
		
		return text;
	}
	
	//다국어 필드 및 일반 필드 저장
	function <portlet:namespace/>dynamicInputSave(variable,key){
		$tr = $("tr[class=parameter][id="+key+"]");
		$input = $tr.children("td").find("input");
		var localizedTextMap;
		
		if(key=="nickName"){
			localizedTextMap = variable.getNameTextMap();
		}else if(key=="description"){
			localizedTextMap = new LocalizedTextMap();
		}
		
		if($tr.children("td").children("span").hasClass("input-localized-input")){
			var size = availableLanguagesArray.length;
			var id=$input.attr("id");
			
			for(var i=0;i<size; i++){
				var lanuage = availableLanguagesArray[i];
				var lanuageValue = $("#"+id+"_"+lanuage).val();
				
				localizedTextMap.addLocalizedText(lanuage,lanuageValue);
			}
			
		}else{
			localizedTextMap.addLocalizedText(defaultLanguage,$input.val());
		}
		
		if(key=="description"){
			variable.setDescriptionMap(localizedTextMap);
		}
		
	}
	
	function <portlet:namespace/>checkRequiredField(key){
		$tr = $("tr[class=parameter][id="+key+"]");
		$input = $tr.children("td").find("input");
		var result = true;
		//다국어 필드 일 경우
		if($tr.children("td").children("span").hasClass("input-localized-input")){
			var size = availableLanguagesArray.length;
			var id=$input.attr("id");
			
			for(var i=0;i<size; i++){
				var lanuage = availableLanguagesArray[i];
				var lanuageValue = $("#"+id+"_"+lanuage).val();
				if(typeof lanuageValue == "undefined"){
					alert(Liferay.Language.get('edison-error-another-language-alret-message'));
					$input.focus();
					return false;
				}else if(lanuageValue == ''){
					alert(Liferay.Language.get('edison-error-another-language-alret-message'));
					$input.focus();
					return false;
				}
			}
		}else{
			if($input.val()==""){
				alert(Liferay.Language.get('this-field-is-mandatory'));
				$input.focus();
				return false;
			}
		}
		
		return result;
	}
	
	var numericShowTrJson 	= '{"nickName":true,"description":true,"groupChoice":true,"varRepet":false,"unit":true,"valueDomainMin":true,"valueDomainMax":true,"numericValue":true,"stringValue":false,"sweep":true,"dimension":false,"list":false,"comment":false,"variableActive":true}';
	var stringShowTrJson	= '{"nickName":true,"description":true,"groupChoice":true,"varRepet":false,"unit":false,"valueDomainMin":false,"valueDomainMax":false,"numericValue":false,"stringValue":true,"sweep":false,"dimension":false,"list":false,"comment":false,"variableActive":true}';
	var listShowTrJson 		= '{"nickName":true,"description":true,"groupChoice":true,"varRepet":false,"unit":false,"valueDomainMin":false,"valueDomainMax":false,"numericValue":false,"stringValue":false,"sweep":false,"dimension":false,"list":true,"comment":false,"variableActive":true}';
	var vectorShowTrJson 	= '{"nickName":true,"description":true,"groupChoice":true,"varRepet":false,"unit":false,"valueDomainMin":false,"valueDomainMax":false,"numericValue":false,"stringValue":false,"sweep":false,"dimension":true,"list":false,"comment":false,"variableActive":true}';
	var groupShowTrJson 	= '{"nickName":true,"description":false,"groupChoice":false,"varRepet":false,"unit":false,"valueDomainMin":false,"valueDomainMax":false,"numericValue":false,"stringValue":false,"sweep":false,"dimension":false,"list":false,"comment":false,"variableActive":false}';
	var commentShowTrJson	= '{"nickName":false,"description":false,"groupChoice":true,"varRepet":false,"unit":false,"valueDomainMin":false,"valueDomainMax":false,"numericValue":false,"stringValue":false,"sweep":false,"dimension":false,"list":false,"comment":true,"variableActive":false}';
	
	//activeType - add
	//activeType - update
	function <portlet:namespace/>changeType(val,activeType){
		
		if($('#activateDiv').is(":visible")){
			<portlet:namespace/>closeActivateDiv();
		}
		
		if($('#activateSearchDiv').is(":visible")){
			<portlet:namespace/>closeActivateSearchDiv();
		}
		
		
		var json;
		if(val==InputdeckConstants.VARIABLE_TYPE_NUMERIC){
			json = JSON.parse(numericShowTrJson);
		}else if(val==InputdeckConstants.VARIABLE_TYPE_STRING){
			json = JSON.parse(stringShowTrJson);
		}else if(val==InputdeckConstants.VARIABLE_TYPE_LIST){
			json = JSON.parse(listShowTrJson);
		}else if(val==InputdeckConstants.VARIABLE_TYPE_VECTOR){
			json = JSON.parse(vectorShowTrJson);
		}else if(val==InputdeckConstants.VARIABLE_TYPE_GROUP){
			json = JSON.parse(groupShowTrJson);
		}else if(val==InputdeckConstants.VARIABLE_TYPE_COMMENT){
			json = JSON.parse(commentShowTrJson);
		}
		
		$(".parameter").hide();
		
		if(val!=""){
			$(".actieveBtn").show();
			
			if(json["variableActive"]){
				$("#variableActivationBtn").show();
			}
			
			$("#inputDeckType option:eq(0)").removeAttr("selected");
			
		}else{
			$("#inputDeckType option:eq(0)").attr("selected", "selected");
			
			$(".actieveBtn").hide();
		}
		
		$(".parameter").each(function() {
			if(val!=""){
				var key = $(this).attr("id");
				if(json[key]){
					$(this).show();

					//group 조회 화면일 경우
					if(key=="groupChoice"){
						if(activeType=='add'){
							var variableGroupArray = inputdeckForm.getVariableNamesByType(InputdeckConstants.VARIABLE_TYPE_GROUP);
							$td = $("#"+key).children("td");
							$td.empty();
							
							if(variableGroupArray[0]!=""){
								$select = $("<select/>").attr("id","inputDeckGroupChoiceSelect");
								
								$("<option/>").val("").html(Liferay.Language.get('--empty--')).appendTo($select);
								for(var i=0;i<variableGroupArray.length;i++){
									var variableGroup = inputdeckForm.getVariable(variableGroupArray[i]);
									
									$("<option/>").val(variableGroup.getName()).html(variableGroup.getNameLocalizedText(defaultLanguage)).appendTo($select);
								}
								$select.appendTo($td);
							}
						}else{
							$(this).hide();
// 							$td = $("#"+key).children("td");
// 							$td.empty();
// 							$("<input/>").attr("type","text")
// 										 .attr("id","intputDeckGroupValue")
// 										 .addClass("short_field noupdate").appendTo($td);


						}
						
					}
					
					//list 일 경우
					if(key=='list'){
						$("#inputDeckListParemter").empty();
					}else if(key=='sweep'){
						$("#inputDeckSweepCheck").prop("checked",false);
						$(".sweepInput").prop('readOnly', true);
					}
					
					if(activeType=='add'){
						if($(this).find(".noupdate").length>0){
							$(this).find(".noupdate").prop('disabled', false);
						}
					}else{
						if($(this).find(".noupdate").length>0){
							$(this).find(".noupdate").prop('disabled', true);
						}
					}
				}
			}
			
			//파라미터 초기화
			$("#inputDeckName").val("");
			$(this).children("td").find(":text").val("");
			$(this).children("td").find(":text").removeAttr("placeholder");
			$(this).children("td").find("input[type=hidden]").val("");
			
		});
		
		
		
		
		if(activeType=='add'){
			$("#inputDeckName").prop("disabled",false);
			$(".addBtnGroup").show();
			$(".updateBtnGroup").hide();
		}else{
			$("#inputDeckName").prop("disabled",true);
			$(".addBtnGroup").hide();
			$(".updateBtnGroup").show();
		}
		
	}
	
	function <portlet:namespace/>changeSweep(){
		if(!$('#activateDiv').is(":visible")){
			if($("#inputDeckSweepCheck").prop( "checked" )){
				//Inputdeck 에서는 하나의 Sweep 변수가 가질수 있다.
// 				if(inputdeckForm.getSweepedVariable() != null){
// 					alert(Liferay.Language.get('edison-science-appstore-inputdeck-duplicate-sweep-error-message'));
// 					$("#inputDeckSweepCheck").prop("checked",false);
// 					return false;
// 				}else{
					$(".sweepInput").prop('readOnly', false);
					$("#variableActivationBtn").hide();
// 				}
			}else{
				$(".sweepInput").prop('readOnly', true);
				$("#variableActivationBtn").show();
			}
		}else{
			alert(Liferay.Language.get('edison-science-appstore-inputdeck-sweep-activation-error-message'));
			return false;
		}
	}
	
	function <portlet:namespace/>changeDimension(val){
		$td = $("#dimensionValueTd");
		$td.empty();
		for(var i=0;i<val;i++){
			$("<input/>").attr("type","text")
						 .addClass("to_short_field")
						 .attr("name","inputDeckDimensionValue_"+i)
						 .attr("id","inputDeckDimensionValue_"+i)
						 .appendTo($td);
		}
	}
	
	function <portlet:namespace/>listBtnEvent(type){
		$selectBox = $("#inputDeckListParemter");
		$option = $("<option/>")
		if(type=='add'){
			var value = $("#para_listValue").val();
			if(value==''){
				alert(Liferay.Language.get('this-field-is-mandatory'));
				$("#para_listValue").focus();
				return false;
			}else{
				if($selectBox.find("option[value='"+value+"']").length>0){
					alert("value "+Liferay.Language.get('duplicate'));
					$("#para_listValue").focus();
					return false;
				}
			}
			
			if(targetLanuage=='full'){
				var size = availableLanguagesArray.length;
				for(var i=0;i<size; i++){
					var lanuage = availableLanguagesArray[i];
					var lanuageValue = $("#<portlet:namespace/>inputDeckListName_"+lanuage).val();
					if(typeof lanuageValue == "undefined"){
						alert(Liferay.Language.get('edison-error-another-language-alret-message'));
						$("#<portlet:namespace/>inputDeckListName").focus();
						return false;
					}else if(lanuageValue == ''){
						alert(Liferay.Language.get('edison-error-another-language-alret-message'));
						$("#<portlet:namespace/>inputDeckListName").focus();
						return false;
					}else{
	 					$option.attr(lanuage,lanuageValue);
	 					
	 					if(lanuage==defaultLanguage){
	 						$option.html(lanuageValue);
	 					}
					}
					
					$("#<portlet:namespace/>inputDeckListName_"+lanuage).val("");
				}
				
				$option.val(value);
				$("#<portlet:namespace/>inputDeckListName").val("");
				$("#<portlet:namespace/>inputDeckListName").removeAttr("placeholder");
				$("#para_listValue").val("");
			}else{
				var lanuageValue = $("#inputDeckListName").val();
				$option.val(value);
				$option.html(lanuageValue);
			}
			
			$option.appendTo($selectBox);
			
			$("#inputDeckListName").val("");
			$("#para_listValue").val("");
		}else{
			$("#inputDeckListParemter option:selected").remove();
		}
	}
	
	function checkNumberExp(event,value){
		event = event || window.event;
		var keyID = (event.which) ? event.which : event.keyCode;
		if ( (keyID >= 48 && keyID <= 57) || (keyID >= 96 && keyID <= 105) || keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39 || keyID == 189 || keyID == 190 || keyID == 69){
			return;
		}else{
			event.target.value = value;
			return false;
		}

	}
	
	function onlyNumber(event){
		event = event || window.event;
		var keyID = (event.which) ? event.which : event.keyCode;
		if ( (keyID >= 48 && keyID <= 57) || (keyID >= 96 && keyID <= 105) || keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39 ) 
			return;
		else
			return false;
	}
	
	function removeChar(event) {
		event = event || window.event;
		var keyID = (event.which) ? event.which : event.keyCode;
		if ( keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39 ) 
			return;
		else
			event.target.value = event.target.value.replace(/[^0-9]/g, "");
	}
	
	function changeVectorToValue( value)
	{
		//vector의 brace와 space 치환
		value = value.replace(braceDisplayArray[0], "");
		value = value.replace(braceDisplayArray[1], "");
		value = trim(value);
		return value;
	}
</script>