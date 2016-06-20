function showPreView( formId, formData)
{
	var inputdeckPreForm = new InputdeckForm();
	inputdeckPreForm.setData( formData );
	
	$("#"+formId).html( getInputDeckHtml( inputdeckPreForm ) );
}

function getInputDeckHtml( inputdeckPreForm )
{
	var variableMap = inputdeckPreForm.getVariableMap();
	
	//Add LineForm
	var lineForm = inputdeckPreForm.getLineForm();
	var commentChar = lineForm.getCommentChar();
	var isLineSpace = lineForm.isSpace();
	var valueDelimiter = lineForm.getValueDelimiter();
	var lineDelimiter = lineForm.getLineDelimiter();
	
	//Add VectorForm
	var vectorForm = inputdeckPreForm.getVectorForm();
	var braceChar = vectorForm.getBraceChar();
	var braceDisplayArray = getBraceDisplayText(braceChar);
	var isVectorSpace = vectorForm.getSpace();
	var vectorDelimiter = vectorForm.getDelimiter();
	
	//Add VariableMap
	var variable;
	var dimension;
	var delimiter;
	var preInputHtml = "";
	var isSweepable = false;
	var sweepName = "";
	var sweepStep = 0;
	var sweepMin = 0;
	var sweepMax = 0;
	var sweepOp = "";
	var name;
	//sweap시 순서를 저장하기 위해 앞쪽 변수 내용을 미리 저장한다.
	var preHtml = "";
	var variableNames = variableMap.getVariableNames();
	
	for(var i=0; i<variableNames.length;i++)
	{
		var value = "";
		variable = variableMap.getVariable(variableNames[i]);
		name = variable.getName();
		//List type 일경우 Key 값 출력
		if(variable.getType() == InputdeckConstants.VARIABLE_TYPE_LIST){
			var viewDefaultLanguage;
			if(typeof defaultLanguage == 'undefined'){
				viewDefaultLanguage = Liferay.ThemeDisplay.getLanguageId()
			}else{
				viewDefaultLanguage = defaultLanguage;
			}
			var listMap = variable.getLocalizedListMap(viewDefaultLanguage);
			
			for (var key in listMap){
				if(value ==""){
					value = key;
				}else{
					value += " OR "+key;
				}
			}
		}else{
			value = variable.getValue();
		}
		
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
					if((opperand.charAt(1) != '=' && upperLimit <= targetValue) || (opperand.charAt(1) == '=' && upperLimit < targetValue))
					{
						useVariable = false;
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
			if( variable.getType() == InputdeckConstants.VARIABLE_TYPE_NUMERIC && variable.isSweepable())
			{
				isSweepable = true;
				sweepName = name;
				sweepStep = value;
				sweepMin = variable.getSweepDomainLowerLimit();
				sweepMax = Number(variable.getSweepDomainUpperLimit());
				sweepOp = variable.getSweepDomainOperand();
				preHtml = preInputHtml;
			}
			else if( variable.getType() == InputdeckConstants.VARIABLE_TYPE_COMMENT )
	    	{
				preInputHtml += "<h5>"+ commentChar + value+ "</h5>";
	    	}
			else if( variable.getType() != InputdeckConstants.VARIABLE_TYPE_GROUP )
			{
				preInputHtml += "<h4>"+name +(isLineSpace?" ":"")+valueDelimiter + (isLineSpace?" ":"")+ value+ lineDelimiter +"</h4>";
			}
		}
	}
	
	if(isSweepable)
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
			// sweep comment
			preInputHtml += "<h5>"+commentChar +sweepName+" Sweep"+(index+1)+"</h5>"+parameterSet.substr(0, preHtml.length)+"<h4>"+sweepName +(isLineSpace?" ":"")
			+valueDelimiter + (isLineSpace?" ":"")+ sweepValue + lineDelimiter +"</h4>" + parameterSet.substr(preHtml.length)+"<br/>";
			index++;;
			
			sweepValue = Number(sweepValue) + Number(sweepStep);
			
			if( 0 < floatPos) sweepValue = sweepValue.toFixed(floatPos);
		}
	}
	
	return preInputHtml;
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