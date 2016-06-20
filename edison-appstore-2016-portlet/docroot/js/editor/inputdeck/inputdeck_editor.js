var variableMap;
//폼 생성 후, condition에 따른 event listener를 add할 form id를 가지는 map
var eventMap = new HashMap();
//Group에 포함된 variable을 관리한다
var groupVariableMap = new HashMap();
//eventMap에 파라미터 정보는 처음만 등록
var isFirstCheck = true;

//vectorForm 정보
var braceDisplayArray = ["[", "]"];
var isVectorSpace = true;
var vectorDelimiter = ",";

//lineForm 정보
commentChar = null;
isLineSpace = null;
valueDelimiter = null;
lineDelimiter = null;

function createInputDeckFormData()
{
	var inputdeckForm = new InputdeckForm();
	var variableMap = inputdeckForm.getVariableMap();
	
	inputdeckForm.setDefaultLanguageId( defaultLanguage );
	inputdeckForm.setAvailableLanguageIds( availableLanguages );
	
	var vectorForm = inputdeckForm.getVectorForm();
	vectorForm.setBraceChar( InputdeckConstants.BRACE_TYPE_SQUARE_SPACE );
	vectorForm.setSample("P=[1,2,3];");
	vectorForm.setSpace( true );
	vectorForm.setDelimiter(",");
	
	var lineForm = inputdeckForm.getLineForm();
	lineForm.setSpace(true);
	lineForm.setValues("=",";","#");
	
	// Variable Sample Numeric01
	var numVariable = variableMap.createVariable("varNum01");
	numVariable.setType( InputdeckConstants.VARIABLE_TYPE_NUMERIC );
	numVariable.setValue( 3 );
	//numVariable.setSweepable(false);
	
	var localizedTextMap = numVariable.getNameTextMap();
	localizedTextMap.addLocalizedText("en_US","Number Param01");
	localizedTextMap.addLocalizedText("ko_KR","숫자 변수01");
	
	var activateCondition = numVariable.getActivateConditionContainer();
	activateCondition.addNumericActivateCondition("varNum03", 1, 9, "=>");
	activateCondition.addListItemActivateCondition("varList01", 3);
	
	var valueDomain = numVariable.getValueDomain();
	valueDomain.setValues(1,5,"==");
	
	//var sweepDomain = numVariable.getSweepDomain();
	//sweepDomain.setValues(2,3,"<>");
	
	var descriptionMap = new LocalizedTextMap();
	descriptionMap.addLocalizedText("en_US","Number Description01");
	descriptionMap.addLocalizedText("ko_KR","숫자 설명01");
	numVariable.setDescriptionMap(descriptionMap);
	
	// Variable Sample Numeric02
	var numVariable = variableMap.createVariable("varNum02");
	numVariable.setType( InputdeckConstants.VARIABLE_TYPE_NUMERIC );
	numVariable.setValue( 1 );
	
	//set domain
	numVariable.setValueDomainValues(2,10,"<>");
	
	//set sweep
	numVariable.setSweepable(true);
	numVariable.setSweepDomainValues(3,8,"<=");
	
	var localizedTextMap = numVariable.getNameTextMap();
	localizedTextMap.addLocalizedText("en_US","Number Param02");
	localizedTextMap.addLocalizedText("ko_KR","숫자 변수02");
	
	var activateCondition = numVariable.getActivateConditionContainer();
	activateCondition.addNumericActivateCondition("varNum03", 3, 7, "<>");
	
	//var descriptionMap = numVariable.getDescriptionMap();
	var descriptionMap = new LocalizedTextMap();
	descriptionMap.addLocalizedText("en_US","Number Description02");
	descriptionMap.addLocalizedText("ko_KR","숫자 설명02");
	numVariable.setDescriptionMap(descriptionMap);
	
	// Variable Sample Numeric03
	var numVariable = variableMap.createVariable("varNum03");
	numVariable.setType( InputdeckConstants.VARIABLE_TYPE_NUMERIC );
	numVariable.setValue( 6 );
	
	//set domain
	numVariable.setValueDomainValues(1,12,"<>");
	
	//set sweep
	numVariable.setSweepable(false);
	numVariable.setSweepDomainValues(4,9,"==");
	
	var localizedTextMap = numVariable.getNameTextMap();
	localizedTextMap.addLocalizedText("en_US","Number Param03");
	localizedTextMap.addLocalizedText("ko_KR","숫자 변수03");
	
	// varNum03은 activeCondition의 메인 변수임으로 condition을 가질 수 없다. 1단계
	//var activateCondition = numVariable.getActivateConditionContainer();
	//activateCondition.addNumericActivateCondition("numberCondition", 4, 7, "<>");
	//activateCondition.addListItemActivateCondition("listCondition", 1);
	
	//var descriptionMap = numVariable.getDescriptionMap();
	var descriptionMap = new LocalizedTextMap();
	descriptionMap.addLocalizedText("en_US","Number Description03");
	descriptionMap.addLocalizedText("ko_KR","숫자 설명03");
	numVariable.setDescriptionMap(descriptionMap);
	
	// Variable Sample Numeric04
	var numVariable = variableMap.createVariable("varNum04");
	numVariable.setType( InputdeckConstants.VARIABLE_TYPE_NUMERIC );
	numVariable.setValue( 99 );
	
	var localizedTextMap = numVariable.getNameTextMap();
	localizedTextMap.addLocalizedText("en_US","Number Param04");
	localizedTextMap.addLocalizedText("ko_KR","숫자 변수04");
	
	// Variable Sample Numeric05
	var numVariable = variableMap.createVariable("varNum05");
	numVariable.setType( InputdeckConstants.VARIABLE_TYPE_NUMERIC );
	numVariable.setValue( 33 );
	
	var localizedTextMap = numVariable.getNameTextMap();
	localizedTextMap.addLocalizedText("en_US","Number Param05");
	localizedTextMap.addLocalizedText("ko_KR","숫자 변수05");
	
	//set domain
	numVariable.setValueDomainUpperLimit(50);
	numVariable.setValueDomainOperand("=>");
	
	// Variable Sample Numeric06
	var numVariable = variableMap.createVariable("varNum06");
	numVariable.setType( InputdeckConstants.VARIABLE_TYPE_NUMERIC );
	numVariable.setValue( 11 );
	
	var localizedTextMap = numVariable.getNameTextMap();
	localizedTextMap.addLocalizedText("en_US","Number Param06");
	localizedTextMap.addLocalizedText("ko_KR","숫자 변수06");
	
	//set domain
	numVariable.setValueDomainLowerLimit(9);
	numVariable.setValueDomainOperand("==");
	
	// Variable Sample String
	var stringVariable = variableMap.createVariable("varString");
	stringVariable.setType( InputdeckConstants.VARIABLE_TYPE_STRING );
	stringVariable.setValue( "Default Value" );

	var localizedTextMap = stringVariable.getNameTextMap();
	localizedTextMap.addLocalizedText("en_US","String Param");
	localizedTextMap.addLocalizedText("ko_KR","문자열 변수");
	
	var descriptionMap = new LocalizedTextMap();
	descriptionMap.addLocalizedText("en_US","Number Description");
	descriptionMap.addLocalizedText("ko_KR","문자열 설명");
	stringVariable.setDescriptionMap(descriptionMap);
	
	// Variable Sample Comment
	var stringVariable = variableMap.createVariable("varComment");
	stringVariable.setType( InputdeckConstants.VARIABLE_TYPE_COMMENT );
	stringVariable.setValue( "Comment Line" );
	
	// Variable Sample Vector
	var vectorVariable = variableMap.createVariable("varVector");
	vectorVariable.setType( InputdeckConstants.VARIABLE_TYPE_VECTOR );
	vectorVariable.setDimension( "4" );
	vectorVariable.setValue("[ 1 , 4 , 7 , 8 ]");

	var localizedTextMap = vectorVariable.getNameTextMap();
	localizedTextMap.addLocalizedText("en_US","Vector Param");
	localizedTextMap.addLocalizedText("ko_KR","벡터 변수");
	
	var descriptionMap = new LocalizedTextMap();
	descriptionMap.addLocalizedText("en_US","Vetor Description");
	descriptionMap.addLocalizedText("ko_KR","벡터 설명");
	vectorVariable.setDescriptionMap(descriptionMap);

	// Variable Sample List01
	var listVariable = variableMap.createVariable("varList01");
	listVariable.setType( InputdeckConstants.VARIABLE_TYPE_LIST );
	listVariable.setValue("listItem01");

	var localizedTextMap = listVariable.getNameTextMap();
	localizedTextMap.addLocalizedText("en_US","List Param01");
	localizedTextMap.addLocalizedText("ko_KR","리스트 변수01");
	
	var descriptionMap = new LocalizedTextMap();
	descriptionMap.addLocalizedText("en_US","List Description01");
	descriptionMap.addLocalizedText("ko_KR","리스트 설명01");
	listVariable.setDescriptionMap(descriptionMap);
	
	var listMap = listVariable.getListMap();		
	
	var listItem01 = new ListItem();
	listItem01.addLocalizedText("en_US","LIST01");
	listItem01.addLocalizedText("ko_KR","리스트01");
	
	var listItem02 = new ListItem();
	listItem02.addLocalizedText("en_US","LIST02");
	listItem02.addLocalizedText("ko_KR","리스트02");
	
	var listItem03 = new ListItem();
	listItem03.addLocalizedText("en_US","LIST03");
	listItem03.addLocalizedText("ko_KR","리스트03");
	
	listMap.addListItem("listItem01", listItem01);
	listMap.addListItem("listItem02", listItem02);
	listMap.addListItem("listItem03", listItem03);
	
	// Variable Sample List02
	var listVariable = variableMap.createVariable("varList02");
	listVariable.setType( InputdeckConstants.VARIABLE_TYPE_LIST );
	listVariable.setValue(30);

	var localizedTextMap = listVariable.getNameTextMap();
	localizedTextMap.addLocalizedText("en_US","List Param02");
	localizedTextMap.addLocalizedText("ko_KR","리스트 변수02");
	
	var descriptionMap = new LocalizedTextMap();
	descriptionMap.addLocalizedText("en_US","List Description02");
	descriptionMap.addLocalizedText("ko_KR","리스트 설명02");
	listVariable.setDescriptionMap(descriptionMap);
	
	var listMap = listVariable.getListMap();		
	
	var listItem01 = new ListItem();
	listItem01.setItemValue(5);
	listItem01.addLocalizedText("en_US","list01");
	listItem01.addLocalizedText("ko_KR","리스트01");
	
	var listItem02 = new ListItem();
	listItem02.setItemValue(62);
	listItem02.addLocalizedText("en_US","list02");
	listItem02.addLocalizedText("ko_KR","리스트02");
	
	var listItem03 = new ListItem();
	listItem03.setItemValue(4);
	listItem03.addLocalizedText("en_US","list03");
	listItem03.addLocalizedText("ko_KR","리스트03");
	
	listMap.addListItem(10, listItem01);
	listMap.addListItem(20, listItem02);
	listMap.addListItem(30, listItem03);
	
	var groupVariable = variableMap.createVariable("varGroup01");
	groupVariable.setType( InputdeckConstants.VARIABLE_TYPE_GROUP );
	groupVariable.setValue("varGroup01");
	
	var activateCondition = groupVariable.getActivateConditionContainer();
	activateCondition.addGroupActivateCondition("varNum01");
	activateCondition.addGroupActivateCondition("varNum02");
	activateCondition.addGroupActivateCondition("varNum03");
	activateCondition.addGroupActivateCondition("varList01");
	activateCondition.addGroupActivateCondition("varString");
	
	var groupVariable = variableMap.createVariable("varGroup02");
	groupVariable.setType( InputdeckConstants.VARIABLE_TYPE_GROUP );
	groupVariable.setValue("varGroup02");
	
	var activateCondition = groupVariable.getActivateConditionContainer();
	activateCondition.addGroupActivateCondition("varList02");
	
	return inputdeckForm;
}

function createInputDeckEditor( inputdeckForm )
{
	$("#"+portletNameSpace+"variableTable tbody").empty();
	isFirstCheck = true;
	eventMap.clear();
	groupVariableMap.clear();

	//Group에 포함된 variable을 관리한다
	variableMap = inputdeckForm.getVariableMap();
	
	//Add LineForm
	var lineForm = inputdeckForm.getLineForm();
	commentChar = lineForm.getCommentChar();
	isLineSpace = lineForm.isSpace();
	valueDelimiter = lineForm.getValueDelimiter();
	lineDelimiter = lineForm.getLineDelimiter();
	//addLabelForm( "<h4>Line Form : " + "P" +(isLineSpace?" ":"")+valueDelimiter + (isLineSpace?" ":"")+"1234"+lineDelimiter+"<br/>Comment Char : " +commentChar+"</h4>");
	
	//Add VectorForm
	var vectorForm = inputdeckForm.getVectorForm();
	braceChar = vectorForm.getBraceChar();
	braceDisplayArray = getBraceDisplayText(braceChar);
	isVectorSpace = vectorForm.getSpace();
	vectorDelimiter = vectorForm.getDelimiter();
	
	//addLabelForm( "<h4>Vector Form : " + braceDisplayArray[0] +(isVectorSpace?" ":"")+"1"+vectorDelimiter+(isVectorSpace?" ":"") +
	//		(isVectorSpace?" ":"")+"2"+vectorDelimiter+(isVectorSpace?" ":"")+(isVectorSpace?" ":"")+"3"+(isVectorSpace?" ":"")+ braceDisplayArray[1] +"</h4>");
	
	//Add VariableMap
	var variable;
	var dimension;
	var delimiter;
	
	var variableNames = variableMap.getVariableNames();
	
	// Group 정보를 따로 담아서 view 하단 마지막에 배치
	var groupVariableNames = variableMap.getVariableNamesByType(InputdeckConstants.VARIABLE_TYPE_GROUP);
	
	for(var i=0; i<groupVariableNames.length;i++)
	{
		var groupVariableName = groupVariableNames[i];
		
		var container =  variableMap.getVariable(groupVariableName).getActivateConditionContainer().getContainer();
		
		container.forEach(function(condition, index) {
			var conditionArray = new Array();
			
			if( typeof (groupVariableMap.get(condition.getVariableName()))  == InputdeckConstants.UNDEFINED)
			{
				conditionArray[0] = groupVariableName;
			}
			else 
			{
				conditionArray = eventMap.get(condition.getVariableName());
				conditionArray[conditionArray.length] = groupVariableName;
			}
			groupVariableMap.set(condition.getVariableName(), conditionArray);
		});
	}

	var groupHtml = "";

	for(var i=0; i<variableNames.length;i++)
	{
		var variable = variableMap.getVariable(variableNames[i]);
		var inputHtml = "";
		switch( variable.getType() )
		{
			case InputdeckConstants.VARIABLE_TYPE_STRING:
				inputHtml = getStringFormHtml( variableNames[i], variable );
				break;
			case InputdeckConstants.VARIABLE_TYPE_NUMERIC:
				inputHtml = getNumberFormHtml( variableNames[i], variable );
				break;
			case InputdeckConstants.VARIABLE_TYPE_LIST:
				inputHtml = getListFormHtml( variableNames[i], variable );
				break;
			case InputdeckConstants.VARIABLE_TYPE_VECTOR:
				inputHtml = getVectorFormHtml( variableNames[i], variable, vectorDelimiter );
				break;
			case InputdeckConstants.VARIABLE_TYPE_COMMENT:
				inputHtml = getCommentFormHtml( variableNames[i], variable );
				break;
		}
		
		if( typeof (groupVariableMap.get(variableNames[i]))  == InputdeckConstants.UNDEFINED )
		{
			$('#'+portletNameSpace+'variableTable tbody').append( inputHtml );
		}
		else
		{
			// 이미 선언된 group 이 있다면 그룹명을 추가하지 않는다.
			var groupTitleHtml =  "<tr><td><h4>"+groupVariableMap.get(variableNames[i])+"</h4></td></tr>";
			if(groupHtml.indexOf(groupTitleHtml) <0)
				groupHtml += groupTitleHtml+inputHtml;
			else
				groupHtml += inputHtml;
		}
	}
	
	if( 0 < groupVariableMap.count() )
	{
		$('#'+portletNameSpace+'variableTable tbody').append( groupHtml );
	}
	
	var checkVariableNames = variableMap.getVariableNamesByType(InputdeckConstants.VARIABLE_TYPE_NUMERIC);
	for(var i=0; i<checkVariableNames.length;i++)
	{
		var variable = variableMap.getVariable(checkVariableNames[i]);
		if(!checkAtivateCondition( variableNames[i], variable ))
		{
			onloadHiddenForm[ onloadHiddenForm.length ] = portletNameSpace+'div_'+checkVariableNames[i];
		}
	}
	
	checkVariableNames = variableMap.getVariableNamesByType(InputdeckConstants.VARIABLE_TYPE_LIST);
	for(var i=0; i<checkVariableNames.length;i++)
	{
		var variable = variableMap.getVariable(checkVariableNames[i]);
		if(!checkAtivateCondition( variableNames[i], variable ))
		{
			onloadHiddenForm[ onloadHiddenForm.length ] = portletNameSpace+'div_'+checkVariableNames[i];
		}
	}
	
	isFirstCheck = false;
	
	return inputdeckForm;
}

function generateInputFile( inputdeckUserForm )
{
	var inputdeckUserFormArray = new Array();
	
	var variableMap = inputdeckUserForm.getVariableMap();
	
	//Add LineForm
	var lineForm = inputdeckUserForm.getLineForm();
	var commentChar = lineForm.getCommentChar();
	var isLineSpace = lineForm.isSpace();
	var valueDelimiter = lineForm.getValueDelimiter();
	var lineDelimiter = lineForm.getLineDelimiter();
	
	//Add VectorForm
	var vectorForm = inputdeckUserForm.getVectorForm();
	var braceChar = vectorForm.getBraceChar();
	var braceDisplayArray = getBraceDisplayText(braceChar);
	var isVectorSpace = vectorForm.getSpace();
	var vectorDelimiter = vectorForm.getDelimiter();
	
	//Add VariableMap
	var variable;
	var dimension;
	var delimiter;
	var preInputHtml = "";
	var isSweep = false;
	var sweepName = "";
	var sweepStep = 0;
	var sweepMin = 0;
	var sweepMax = 0;
	var sweepOp = "";
	var name;
	var value;
	//sweap시 순서를 저장하기 위해 앞쪽 변수 내용을 미리 저장한다.
	var preHtml = "";
	var variableNames = variableMap.getVariableNames();
	
	for(var i=0; i<variableNames.length;i++)
	{
		variable = variableMap.getVariable(variableNames[i]);
		name = variable.getName();
		value = variable.getValue();
		
		//condition을 먼저 체크
		var container = variable.getActivateConditionContainer().getContainer();
		var useVariable = true;
		
		container.forEach(function(condition, index) {
			var targetVariable = variableMap.getVariable(condition.getVariableName());
			var targetValue = targetVariable.getValue();
			
			switch( condition.getType() )
			{
				case InputdeckConstants.VARIABLE_TYPE_NUMERIC:
					var lowerLimit = condition.getDomainLowerLimit();
					var upperLimit = condition.getDomainUpperLimit();
					var opperand = condition.getDomainOperand();
					
					// min compare
					if((opperand.charAt(0) != '=' &&  targetValue <= lowerLimit) ||(opperand.charAt(0) == '=' && targetValue < lowerLimit)) 
					{
						useVariable = false;
					}
					// max compare
					else if((opperand.charAt(1) != '=' && upperLimit <= targetValue) || (opperand.charAt(1) == '=' && upperLimit < targetValue))
					{
						useVariable = false;
					}
					else
					{
						useVariable = true;	
					}
					break;
				case InputdeckConstants.VARIABLE_TYPE_LIST:
					if( condition.getListItemValue() == targetValue)
					{
						useVariable = true;
					}
					break;
			}
		});
		
		if( useVariable )
		{
			if( variable.getType() == InputdeckConstants.VARIABLE_TYPE_NUMERIC && $('#'+portletNameSpace+name+"_check").is(':checked')==true)
			{
				isSweep = true;
				sweepName = name;
				sweepStep = value;
				sweepMin = variable.getSweepDomainLowerLimit();
				sweepMax = Number(variable.getSweepDomainUpperLimit());
				sweepOp = variable.getSweepDomainOperand();
				preHtml = preInputHtml;
			}
			else if( variable.getType() == InputdeckConstants.VARIABLE_TYPE_COMMENT )
	    	{
				preInputHtml += commentChar + value+ "\n";
	    	}
			else if( variable.getType() != InputdeckConstants.VARIABLE_TYPE_GROUP )
			{
				preInputHtml += name +(isLineSpace?" ":"")+valueDelimiter + (isLineSpace?" ":"")+ value+ lineDelimiter +"\n";
			}
		}
	}
	
	if( isSweep )
	{
		var sweepValue = Number(sweepMin)+Number(sweepOp.charAt(0)=="="?0:sweepStep);
		var parameterSet = preInputHtml;
		preInputHtml = "";
		
		var count = parseInt((sweepMax-sweepValue)/sweepStep);
		if( sweepOp.charAt(1) =="=" )
		{
			count++;
		}
		
		// 자바스크립트 메모리 계산 방식으로 인해 부동소수점 계산시 오차가 발생한다, 따라서 자릿수를 임의로 통일해줘야한다.
		var floatPos = 0;
		if(sweepStep.toString().split("\.")[1])
		{
			floatPos = sweepStep.toString().split("\.")[1].length;
			sweepMax = sweepMax.toFixed(floatPos);
		}
		
		var index=0;
		while( index <= count && sweepValue <= sweepMax)
		{
			preInputHtml =parameterSet.substr(0, preHtml.length)+sweepName +(isLineSpace?" ":"")
			+valueDelimiter + (isLineSpace?" ":"")+ sweepValue + lineDelimiter +"\n" + parameterSet.substr(preHtml.length)+"\n";

			var cloneUserForm =  inputdeckUserForm.clone();
			cloneUserForm.getVariable(sweepName).setValue(sweepValue);
			cloneUserForm.getVariable(sweepName).cleanSweep();
			cloneUserForm.setFileContent(preInputHtml);
			inputdeckUserFormArray[index] = cloneUserForm;
			
			sweepValue = Number(sweepValue) + Number(sweepStep);
			if( 0 < floatPos) sweepValue = sweepValue.toFixed(floatPos);
			index++;
		}
	}
	else
	{
		var cloneUserForm =  inputdeckUserForm.clone();
		cloneUserForm.setFileContent(preInputHtml);
		inputdeckUserFormArray[0] = cloneUserForm;
	}
	return inputdeckUserFormArray;
}

function addLabelForm( text )
{
	var html = $("#"+portletNameSpace+"formDiv").html();
	$("#"+portletNameSpace+"formDiv").html(html+ "<p>"+text+"</p>");
}

function getStringFormHtml( id, variable )
{
	var inputHtml = '<tr id="'+portletNameSpace+'div_'+id+'"><td>'+variable.getNameLocalizedText( defaultLanguage )+'</td><td><input type="text" id="'+portletNameSpace+''+id+'" value="'+variable.getValue()+'" name="'+id+'" onchange="changeValueEvent( \'value\', this)" style="width:80%;" /></td><td class="TC"><img src="' + contextPath + '/images/btn_question.jpg" width="20" style="cursor:pointer" height="20" title="'+variable.getLocalizedDescription( defaultLanguage )+'" /></td>';
	//$('#'+portletNameSpace+'variableTable tbody').append('<tr id="'+portletNameSpace+'div_'+id+'"><td>'+variable.getNameLocalizedText( defaultLanguage )+'</td><td><input type="text" id="'+portletNameSpace+''+id+'" value="'+variable.getValue()+'" name="'+id+'" onchange="changeValueEvent( \'value\', this)" style="width:80%;" /></td><td>'+variable.getLocalizedDescription( defaultLanguage )+'</td></tr>');
	return inputHtml;
}

function getCommentFormHtml( id, variable )
{
	var inputHtml =  '<tr id="comment"><td>Comment Param</td><td colspan=2><input type="text" id="'+portletNameSpace+''+id+'" value="'+commentChar+variable.getValue()+'" name="'+id+'" style="width:95%;" readOnly /></td></tr>'; 
	//$('#'+portletNameSpace+'variableTable tbody').append('<tr id="comment"><td>Comment Param</td><td colspan=2><input type="text" id="'+portletNameSpace+''+id+'" value="'+commentChar+variable.getValue()+'" name="'+id+'" style="width:95%;" readOnly /></td></tr>');
	return inputHtml;
}

function getNumberFormHtml( id, variable)
{
	var name = variable.getNameLocalizedText( defaultLanguage );
	var value = variable.getValue();
	var desc = variable.getLocalizedDescription( defaultLanguage );
	var hasLowerLimit = (typeof(variable.getValueDomainLowerLimit()) == InputdeckConstants.UNDEFINED)?false:true;
	var hasUpperLimit = (typeof(variable.getValueDomainUpperLimit()) == InputdeckConstants.UNDEFINED)?false:true;

	var lowerLimit;
	var lowerOp;
	var lowerHtml="";
	var upperLimit;
	var upperOp;
	var upperHtml="";
	
	if(hasLowerLimit)
	{
		lowerLimit = variable.getValueDomainLowerLimit();
		lowerOp = variable.getValueDomainOperand().charAt(0);
		lowerHtml =  lowerLimit+(lowerOp=='='?" &lE; ":" < ");
	}
	
	if(hasUpperLimit)
	{
		upperLimit =variable.getValueDomainUpperLimit();
		upperOp = variable.getValueDomainOperand().charAt(1);
		upperHtml= (upperOp=='='?" &lE; ":" < ")+upperLimit;
	}
	
	var inputHtml = '<tr id="'+portletNameSpace+'div_'+id+'" >';
	
	if( variable.isSweepable() )
	{
		var lowerSweep =variable.getSweepDomainLowerLimit();
		var upperSweep =variable.getSweepDomainUpperLimit();
		var opSweep = variable.getSweepDomainOperand();
		
		inputHtml +='<td>'+name+'&nbsp;<input type="checkbox" id="'+portletNameSpace+''+id+'_check" name="'+portletNameSpace+''+id+'"onchange="changeSweepable(this);" checked/></td>'
		+'<td><span id="'+portletNameSpace+id+'_sweep_on">Step : <input type="text" id="'+portletNameSpace+id+'_step" name="'+id+'"value="'+value+'" onchange="changeValueEvent( \'step\', this)"/>'
		+'<input type="hidden" id="'+portletNameSpace+id+'_op" value="'+opSweep+'" name="'+id+'" />'
		+'Min : <input type="text" id="'+portletNameSpace+id+'_min" value="'+lowerSweep+'" name="'+id+'" onchange="changeValueEvent( \'lowerSweep\', this)"/>'
		+'Max : <input type="text" id="'+portletNameSpace+id+'_max" value="'+upperSweep+'" name="'+id+'" onchange="changeValueEvent( \'upperSweep\', this)"/></span>'
		+'<span id="'+portletNameSpace+id+'_sweep_off" style="display:none">'+lowerHtml
		+'<input type="text" id="'+portletNameSpace+id+'" name="'+id+'"value="'+value+'" onchange="if( validateNumericInput(this,'+lowerLimit+','+upperLimit+',\''+lowerOp+'\',\''+upperOp+'\') ){checkAtivationEvent(this)};"/>'
		+upperHtml+'</span></td>';
	}
	else
	{
		inputHtml += '<td>'+name+'</td><td>'+lowerHtml
		+'<input type="text" id="'+portletNameSpace+id+'" name="'+id+'"value="'+value+'" onchange="if( validateNumericInput(this,'+lowerLimit+','+upperLimit+',\''+lowerOp+'\',\''+upperOp+'\') ){checkAtivationEvent(this)};"/>'
		+upperHtml+'</td>';
	}
	
	inputHtml += '<td class="TC"><img src="' + contextPath + '/images/btn_question.jpg" width="20" style="cursor:pointer" height="20" title="'+desc+'" /></td></tr>';
	
	return inputHtml;
}

function getVectorFormHtml( id , variable, delimiter )
{
	var value = variable.getValue();
	value = changeVectorToValue( value );
	
	var valueArr = value.split( delimiter );
	var inputHtml = '<tr id="'+portletNameSpace+'div_'+id+'_vector"><td>'+variable.getNameLocalizedText( defaultLanguage )+'</td><td>';
	
	for(var i=0; i<variable.getDimension();i++)
	{
		inputHtml += '<input type="text" id="'+portletNameSpace+id+'_'+i+'" value="'+trim(valueArr[i])+'" name="'+id+'_'+i+'" onchange="changeValueEvent( \'vector\', this)"/>';			
	}
	inputHtml += '</td><td class="TC"><img src="' + contextPath + '/images/btn_question.jpg" width="20" style="cursor:pointer" height="20" title="'+variable.getLocalizedDescription( defaultLanguage )+'" /></td></tr>';
	
	return inputHtml;
}

function getListFormHtml( id, variable )
{
	var inputHtml = '<tr  id="'+portletNameSpace+'div_'+id+'"><td>'+variable.getNameLocalizedText( defaultLanguage )+'</td><td><select id="'+portletNameSpace+id+'" name="'+id+'"onchange="checkAtivationEvent(this)">';
	var listMap = variable.getLocalizedListMap(defaultLanguage);
	for ( val in listMap)
	{
		inputHtml += '<option value="'+val+'" '+ (variable.getValue()==val?'selected':'') + '>'+listMap[val]+'</option>';	
	}
	
	inputHtml +='</select></td><td class="TC"><img src="' + contextPath + '/images/btn_question.jpg" width="20" style="cursor:pointer" height="20" title="' +variable.getLocalizedDescription( defaultLanguage )+'" /></td></tr>';
	return inputHtml;
}

function trim( str )
{
	return str.replace(/(^\s*)|(\s*$)/gi, "");	
}

function getBraceDisplayText( braceChar )
{
	var array = [];
	
	switch(braceChar)
	{
		case InputdeckConstants.BRACE_TYPE_SQUARE:
			array[0]="[";
			array[1]="]";
			break;
		case InputdeckConstants.BRACE_TYPE_SQUARE_SPACE:
			array[0]="[ ";
			array[1]=" ]";
			break;
		case InputdeckConstants.BRACE_TYPE_ROUND:
			array[0]="(";
			array[1]=")";
			break;
		case InputdeckConstants.BRACE_TYPE_ROUND_SPACE:
			array[0]="( ";
			array[1]=" )";
			break;
		default:
			array[0]="[";
			array[1]="]";
			break;
	}
	return array;
}

function checkAtivateCondition( id, variable )
{
	var container = variable.getActivateConditionContainer().getContainer();
	var result = true;
	
	container.forEach(function(condition, index) {
		var targetVariable = variableMap.getVariable(condition.getVariableName());
		var targetValue = targetVariable.getValue();
		
		switch( condition.getType() )
		{
			case InputdeckConstants.VARIABLE_TYPE_NUMERIC:
				var lowerLimit = condition.getDomainLowerLimit();
				var upperLimit = condition.getDomainUpperLimit();
				var opperand = condition.getDomainOperand();
				
				//varNum01 Condition : varNum03", 1, 9, "=>");
				//varNum01 Condition : varList01", 3
				//varNum02 Condition : varNum03", 3, 7, "<>");
				
				// min compare
				if((opperand.charAt(0) != '=' &&  targetValue <= lowerLimit) ||(opperand.charAt(0) == '=' && targetValue < lowerLimit)) 
				{
					result = false;
				}
				
				// max compare
				if((opperand.charAt(1) != '=' && upperLimit <= targetValue) || (opperand.charAt(1) == '=' && upperLimit < targetValue))
				{
					result = false;
				}
				break;
			case InputdeckConstants.VARIABLE_TYPE_LIST:
				if( condition.getListItemValue() == targetValue)
				{
					result = true;
				}
				break;
		}

		if( isFirstCheck )
		{
			//eventMap에 target 정보를 add, 처음에만 세팅
			var conditionArray = new Array();
			
			if( typeof (eventMap.get(condition.getVariableName()))  == InputdeckConstants.UNDEFINED)
			{
				conditionArray[0] = id;
			}
			else 
			{
				conditionArray = eventMap.get(condition.getVariableName());
				conditionArray[conditionArray.length] = id;
			}
			eventMap.set(condition.getVariableName(), conditionArray);
		}
	});
	
	//condition 조건(Number of List)이 하나라도 보일경우에 show
	if(result)
	{
		$('#'+portletNameSpace+'div_'+id).css("display","");
		
		if( variable.isSweepable() )
		{
			$('#'+portletNameSpace+id+'_sweep_on').css("display","");
		  	$('#'+portletNameSpace+id+'_sweep_off').css("display","none");
		  	$('#'+portletNameSpace+id+'_check').attr("checked",true);
		}
	}
	else
	{
		$('#'+portletNameSpace+'div_'+id).css("display","none");
		/*if( variable.isSweepable() )
		{
			$('#'+portletNameSpace+id+'_sweep_on').css("display","none");
		  	$('#'+portletNameSpace+id+'_sweep_off').css("display","");
			$('#'+portletNameSpace+id+'_check').attr("checked",false);
		}*/
	}
	return result;
}

function changeSweepable(checkboxItem)
{
	 if($('#'+checkboxItem.id).is(':checked'))
	 {
	  	$('#'+checkboxItem.name+'_sweep_on').css("display","");
	  	$('#'+checkboxItem.name+'_sweep_off').css("display","none");
	 }
	 else
  	{
		$('#'+checkboxItem.name+'_sweep_on').css("display","none");
	    $('#'+checkboxItem.name+'_sweep_off').css("display","");
  	}
}

//생성된 input 값의 데이터가 변경될때마다 각각 타입에 맞게 inputdeckUserData에 반영, type:value, lowerSweep, upperSweep, ,step, vector
function changeValueEvent( type, e )
{
	var value = e.value;
	var variable = variableMap.getVariable( e.name );
	
	if( type=='value')
	{
		variable.setValue(value);
	}
	else if( type=='lowerSweep')
	{
		validateInputText(variable.setSweepDomainLowerLimit(value));	
	}
	else if( type=='upperSweep')
	{
		validateInputText(variable.setSweepDomainUpperLimit(value));	
	}
	else if( type=='step')
	{
		variable.setSweepSlice(value);
		variable.setValue(value);
	}
	else if( type=='vector')
	{
		var vectorInfo = e.name.split("_");
		var id = vectorInfo[0];
		var position = vectorInfo[1];
		
		variable = variableMap.getVariable( id );
		
		var vectorValues = variable.getValue().split( vectorDelimiter );
		var newValue = "";	
		
		if( position == 0)
			vectorValues[position] = braceDisplayArray[0]+value+(isVectorSpace?" ":"");
		else if( position == (vectorValues.length-1))
			vectorValues[position] =(isVectorSpace?" ":"")+value+braceDisplayArray[1];
		else
			vectorValues[position] =(isVectorSpace?" ":"")+value+(isVectorSpace?" ":"");
		
		for(var i=0; i<vectorValues.length;i++)
		{
			newValue += vectorValues[i] + (i!= (vectorValues.length-1)?vectorDelimiter:"");
		}
		
		variable.setValue(newValue);
	}
}

function checkAtivationEvent( e )
{
	var value = e.value;
	var checkIds = new Array();
	var variable = variableMap.getVariable( e.name );
	variable.setValue(value);
	
	if( typeof ( checkIds = eventMap.get(e.name))  != InputdeckConstants.UNDEFINED)
	{
		for(var i = 0; i < checkIds.length; i++)
		{
			checkAtivateCondition( checkIds[i], variableMap.getVariable( checkIds[i] ) );
		}
	}
}

function validateInputText( resultMsg)
{
	switch(resultMsg)
	{
		case InputdeckErrors.LOWER_LIMIT_INVALID :
			alert( InputdeckErrors.LOWER_LIMIT_INVALID);
			break;
		case InputdeckErrors.UPPER_LIMIT_INVALID :
			alert( InputdeckErrors.UPPER_LIMIT_INVALID );
			break;
		case InputdeckErrors.OPERAND_INVALID :
			alert( InputdeckErrors.OPERAND_INVALID );
			break;
	}
}

function validateNumericInput( obj, min, max, minOp, maxOp )
{
	var value = obj.value;
	var name = obj.name;
    var  isNumeric = /^[-+]?(\d+|\d+\.\d*|\d*\.\d+)$/;
    var result = false;
    
    if( !isNumeric.test(value) )
   	{
    	alert(name + "은 숫자만 입력 가능합니다.");
   	}
    else if( minOp=='=' && value < min)
   	{
    	alert("입력 값이 최소값보다 작을 수 없습니다.");
    	obj.value = "";
   	}
    else if( minOp !='=' && value <= min)
   	{
    	alert("입력 값이 최소값보다 같거나 작을 수 없습니다.");
    	obj.value = "";
   	}
    else if( maxOp =='=' &&max < value)
   	{
    	alert("입력 값이 최대값보다 클 수 없습니다.");
    	obj.value = "";
   	}
    else if( maxOp !='=' &&max <= value)
   	{
    	alert("입력 값이 최대값보다 같거나 클 수 없습니다.");
    	obj.value = "";
   	}
    else
    	result = true;
    
    if(! result)
   	{
	    obj.value = "";
	    obj.focus();
   	}
    
    return result;
}

function changeVectorToValue( value)
{
	//vector의 brace와 space 치환
	value = value.replace(braceDisplayArray[0], "");
	value = value.replace(braceDisplayArray[1], "");
	value = trim(value);
	return value;
}

function showJsonScript( json)
{
	//$("#"+div).html("<p>"+JSON.stringify(json, null, "<br/>")+"</p>");
	$("#"+portletNameSpace+"inputJSON").html(JSON.stringify(json));
};

function showInputFile()
{
	var html = "";
	var isSweep = false;
	var sweepName = "";
	var sweepStep = 0;
	var sweepMin = 0;
	var sweepMax = 0;
	var sweepOp = "";
	var name;
	var value;
	//sweap시 순서를 저장하기 위해 앞쪽 변수 내용을 미리 저장한다.
	var preHtml = "";
	//실제 파일에 들어갈 내용을 따로 관리
	
	$.each($('input[type="text"], select', '#'+portletNameSpace+'inputdeckForm'),function(k){
	 	name = $(this).attr('name');
	 	value = $(this).val();
	    if( $(this).is(':visible') && typeof(name) != InputdeckConstants.UNDEFINED)
	    {
	    	//sweep일 경우 sweep을 뺀 파라미터 셋을 만든 후, sweep 시킨다.
	    	if( 0< $(this).closest("tr").attr('id').indexOf("_vector"))
	    	{
	    		var vectorName = name.split("_");
	    		if( vectorName[1] == 0)
		    		html += "<h4>"+vectorName[0]+(isVectorSpace?" ":"")+valueDelimiter+(isVectorSpace?" ":"")+braceDisplayArray[0]+value+(isVectorSpace?" ":"")+vectorDelimiter;
				else if( typeof($(this).next(':input').attr('id')) == InputdeckConstants.UNDEFINED)
					html += (isVectorSpace?" ":"")+value+braceDisplayArray[1]+(isVectorSpace?" ":"")+lineDelimiter+"</h4>";
				else
					html += (isVectorSpace?" ":"")+value+(isVectorSpace?" ":"")+vectorDelimiter;
	    	}
	    	else if( $(this).closest("tr").attr('id') == "comment")
	    	{
	    		html += "<h5>"+ value+ "</h5>";
	    	}
	    	else if( typeof( $(this).closest("span").attr('id') ) != InputdeckConstants.UNDEFINED && 0< $(this).closest("span").attr('id').indexOf("sweep_on") )
 			{
	    		if(  0< $(this).attr('id').indexOf("_step")  )
 				{
	    			// 의미없다, 최초1회만 세팅하려고
	    			isSweep = true;
		    		sweepName = name;
	    			sweepOp = $(this).next().val()
	    			sweepStep = value;
	    			preHtml = html;
 				}
	    		else if( 0< $(this).attr('id').indexOf("_min") )
				{
	 				sweepMin = value;
	 			}
	 			else if( 0< $(this).attr('id').indexOf("_max") )
				{
	 				sweepMax = Number(value);
	 			}
	 		}
	 		else
	 		{
	    		html += "<h4>"+name +(isLineSpace?" ":"")+valueDelimiter + (isLineSpace?" ":"")+ value+ lineDelimiter +"</h4>";
	 		}
		}
	});
	
	// isSweep 일 경우, sweepMin, Max를 기준으로 html 파라미터 셋을 재생성한다
	if( isSweep )
	{
		var sweepValue = Number(sweepMin)+Number(sweepOp.charAt(0)=="="?0:sweepStep);
		var parameterSet = html;
		html = "";
		
		var count = parseInt((sweepMax-sweepValue)/sweepStep);
		if( sweepOp.charAt(1) =="=" )
		{
			count++;
		}
		
		// 자바스크립트 메모리 계산 방식으로 인해 부동소수점 계산시 오차가 발생한다, 따라서 자릿수를 임의로 통일해줘야한다.
		var floatPos = 0;
		if(sweepStep.toString().split("\.")[1])
		{
			floatPos = sweepStep.toString().split("\.")[1].length;
			sweepMax = sweepMax.toFixed(floatPos);
		}
		
		var index=0;
		while( index <= count && sweepValue <= sweepMax)
		{
			html += "<h5>"+commentChar +sweepName+" Sweep"+(index+1)+"</h5>"+parameterSet.substr(0, preHtml.length)+"<h4>"+sweepName +(isLineSpace?" ":"")
			+valueDelimiter + (isLineSpace?" ":"")+ sweepValue + lineDelimiter +"</h4>" + parameterSet.substr(preHtml.length)+"<br/>";
			index++;
			
			sweepValue = Number(sweepValue) + Number(sweepStep);
			
			if( 0 < floatPos) sweepValue = sweepValue.toFixed(floatPos);
		}
	}
	$("#"+portletNameSpace+"inputFILE").html(html);
}