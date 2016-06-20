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
				conditionArray = groupVariableMap.get(condition.getVariableName());
				conditionArray[conditionArray.length] = groupVariableName;
			}
			groupVariableMap.set(condition.getVariableName(), conditionArray);
		});
	}

	var groupHtml = "";
	var usedGroupName="";
	
	for(var i=0; i<variableNames.length;i++)
	{
		var variable = variableMap.getVariable(variableNames[i]);
		var inputHtml = "";
		var isGroup = (typeof (groupVariableMap.get(variableNames[i]))  != InputdeckConstants.UNDEFINED);
		
		switch( variable.getType() )
		{
			case InputdeckConstants.VARIABLE_TYPE_STRING:
				inputHtml = getStringFormHtml( variableNames[i], variable, isGroup );
				break;
			case InputdeckConstants.VARIABLE_TYPE_NUMERIC:
				inputHtml = getNumberFormHtml( variableNames[i], variable, isGroup );
				break;
			case InputdeckConstants.VARIABLE_TYPE_LIST:
				inputHtml = getListFormHtml( variableNames[i], variable, isGroup );
				break;
			case InputdeckConstants.VARIABLE_TYPE_VECTOR:
				inputHtml = getVectorFormHtml( variableNames[i], variable, vectorDelimiter, isGroup );
				break;
			case InputdeckConstants.VARIABLE_TYPE_COMMENT:
				inputHtml = getCommentFormHtml( variableNames[i], variable, isGroup );
				break;
		}
		
		if( isGroup )
		{
			// 이미 선언된 group 이 있다면 그룹명을 추가하지 않는다.
			var groupName = groupVariableMap.get(variableNames[i]);
			var groupTitleHtml = getGroupFormHtml( groupName );
			if(groupHtml.indexOf(groupTitleHtml) <0)
				groupHtml += groupTitleHtml+inputHtml;
			else
				groupHtml += inputHtml;
			
			usedGroupName += groupName+",";
		}
		else
		{
			$('#'+portletNameSpace+'variableTable tbody').append( inputHtml );
		}
	}
	
	if( 0 < groupVariableMap.count() )
	{
		$('#'+portletNameSpace+'variableTable tbody').append( groupHtml );
	}
	
	for(var i=0; i<groupVariableNames.length;i++)
	{
		if( usedGroupName.indexOf(groupVariableNames[i]+",") < 0)
			$('#'+portletNameSpace+'variableTable tbody').append( getGroupFormHtml( groupVariableNames[i], variable ) );
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

function getStringFormHtml( id, variable, isGroup )
{
	var inputHtml = '<tr id="'+portletNameSpace+'div_'+id+'">';
	inputHtml += '<td style="cursor:pointer;" onClick="'+portletNameSpace+'searchParameter(\''+variable.getName()+'\');">'+(isGroup?'&nbsp;&nbsp;&bull;&nbsp;':'')+id+'</td>';
	inputHtml += '<td><input type="text" id="'+portletNameSpace+''+id+'" value="'+variable.getValue()+'" name="'+id+'" onchange="changeValueEvent( \'value\', this)" class="long_field"/></td>';
	inputHtml += '<td class="TC"><img src="' + contextPath + '/images/btn_question.jpg" width="20" style="cursor:pointer" height="20" title="'+variable.getLocalizedDescription( defaultLanguage )+'" /></td>';
	inputHtml += '</tr>';
	return inputHtml;
}

function getCommentFormHtml( id, variable, isGroup )
{
	var inputHtml = '<tr id="'+portletNameSpace+'div_'+id+'" style="cursor:pointer;" onClick="'+portletNameSpace+'searchParameter(\''+variable.getName()+'\');">';
	inputHtml += '<td>'+(isGroup?'&nbsp;&nbsp;&bull;&nbsp;':'')+id+'</td><td><input type="text" id="'+portletNameSpace+''+id+'" value="'+commentChar+variable.getValue()+'" name="'+id+'" style="width:98%;" readOnly /></td>';
	inputHtml += '<td class="TC"><img src="' + contextPath + '/images/btn_question.jpg" width="20" style="cursor:pointer" height="20" title="Comment Parameter" /></td>';
	inputHtml += '</tr>';

	return inputHtml;
}

function getGroupFormHtml( id )
{
	var inputHtml = '<tr id="'+portletNameSpace+'div_'+id+'">';
	inputHtml += '<td colspan=3 style="cursor:pointer;background-color:#6a8ec6;color:white;font-weight:bold;font-size:15px;" onClick="'+portletNameSpace+'searchParameter(\''+id+'\');">['+id+']</td>';
	inputHtml += '</tr>';
	return inputHtml;
}

function getNumberFormHtml( id, variable, isGroup )
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
	var lowerSweep =variable.getSweepDomainLowerLimit();
	var upperSweep =variable.getSweepDomainUpperLimit();
	var opSweep = variable.getSweepDomainOperand();
	
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
	
	var inputHtml = '<tr id="'+portletNameSpace+'div_'+id+'">';
	
	if( variable.isSweepable() )
	{
		inputHtml +='<td style="cursor:pointer;" onClick="'+portletNameSpace+'searchParameter(\''+variable.getName()+'\');">'+(isGroup?'&nbsp;&nbsp;&bull;&nbsp;':'')+id+'&nbsp;<input type="checkbox" id="'+portletNameSpace+''+id+'_check" name="' + id + '"onchange="changeSweepable(this);" checked/></td>'
		+'<td><span id="'+portletNameSpace+id+'_sweep_on">'
		+'Step : <input type="text" id="'+portletNameSpace+id+'_step" name="'+id+'"value="'+value+'" onchange="changeValueEvent( \'step\', this)" style="width: 60px;margin-right: 5px;"/>'
		+'<input type="hidden" id="'+portletNameSpace+id+'_op" value="'+opSweep+'" name="'+id+'" />'
		+'Min : <input type="text" id="'+portletNameSpace+id+'_min" value="'+lowerSweep+'" name="'+id+'" onchange="changeValueEvent( \'lowerSweep\', this)" style="width: 60px;margin-right: 5px;"/>'
		+'Max : <input type="text" id="'+portletNameSpace+id+'_max" value="'+upperSweep+'" name="'+id+'" onchange="changeValueEvent( \'upperSweep\', this)" style="width: 60px;margin-right: 5px;"/></span>'
		+'<span id="'+portletNameSpace+id+'_sweep_off" style="display:none">'+lowerHtml
		+'<input type="text" id="'+portletNameSpace+id+'" name="'+id+'"value="'+value+'" onchange="if( validateNumericInput(this,'+lowerLimit+','+upperLimit+',\''+lowerOp+'\',\''+upperOp+'\') ){checkAtivationEvent(this)};"/>'+upperHtml+'</td>';
	}
	else
	{
		inputHtml += '<td style="cursor:pointer;" onClick="'+portletNameSpace+'searchParameter(\''+variable.getName()+'\');">'+(isGroup?'&nbsp;&nbsp;&bull;&nbsp;':'')+id+'</td><td>'+lowerHtml
		+'<input type="text" id="'+portletNameSpace+id+'" name="'+id+'"value="'+value+'" onchange="if( validateNumericInput(this,'+lowerLimit+','+upperLimit+',\''+lowerOp+'\',\''+upperOp+'\') ){checkAtivationEvent(this)};"/>'
		+upperHtml+'</td>';
	}

	inputHtml += '<td class="TC"><img src="' + contextPath + '/images/btn_question.jpg" width="20" style="cursor:pointer" height="20" title="'+desc+'" /></td></tr>';
	
	return inputHtml;
}

function getVectorFormHtml( id , variable, delimiter, isGroup )
{
	var value = variable.getValue();
	value = changeVectorToValue( value );
	
	var valueArr = value.split( delimiter );
	var inputHtml = '<tr id="'+portletNameSpace+'div_'+id+'_vector">';
	inputHtml += '<td style="cursor:pointer;" onClick="'+portletNameSpace+'searchParameter(\''+variable.getName()+'\');">'+(isGroup?'&nbsp;&nbsp;&bull;&nbsp;':'')+id+'</td>';
	inputHtml += '<td>';

	for(var i=0; i<variable.getDimension();i++)
	{
		inputHtml += '<input type="text" id="'+portletNameSpace+id+'_'+i+'" value="'+trim(valueArr[i])+'" name="'+id+'_'+i+'" onchange="changeValueEvent( \'vector\', this)" class="to_short_field"/>';			
	}
	inputHtml += '</td><td class="TC"><img src="' + contextPath + '/images/btn_question.jpg" width="20" style="cursor:pointer" height="20" title="'+variable.getLocalizedDescription( defaultLanguage )+'" /></td></tr>';

	return inputHtml;
}

function getListFormHtml( id, variable, isGroup )
{
	var inputHtml = '<tr id="'+portletNameSpace+'div_'+id+'">';
	inputHtml += '<td style="cursor:pointer;" onClick="'+portletNameSpace+'searchParameter(\''+variable.getName()+'\');">'+(isGroup?'&nbsp;&nbsp;&bull;&nbsp;':'')+id+'</td>';
	inputHtml += '<td ><select id="'+portletNameSpace+id+'" name="'+id+'"onchange="checkAtivationEvent(this)">';
	
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
	 var variable = variableMap.getVariable( checkboxItem.name );
	 if($('#'+checkboxItem.id).is(':checked'))
	 {
	  	$('#'+portletNameSpace+checkboxItem.name+'_sweep_on').css("display","");
	  	$('#'+portletNameSpace+checkboxItem.name+'_sweep_off').css("display","none");
	  	variable.setSweepable(true);
	 }
	 else
	{
		$('#'+portletNameSpace+checkboxItem.name+'_sweep_on').css("display","none");
	    $('#'+portletNameSpace+checkboxItem.name+'_sweep_off').css("display","");
	    variable.setSweepable(false);
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