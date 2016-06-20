
/**
 * 공백없애기
 * str -> 공백을 제거할 Parameter
 * retrun 공백이 제거된 Parameter
 */
function spaceDelete(str){
	var sDstr = str.replace(/\s/g,'');
	return sDstr;
}

/**
 * 공백수정
 * str -> 공백을 변환할 Parameter
 * changeStr -> 공백을 변환할 문자
 * retrun 공백이 제거된 Parameter
 */
function spaceChange(str,changeStr){
	var sDstr = str.replace(/\s/g,changeStr);
	return sDstr;
}


/**
 *문자열이 null 일 경우 ""반환
 *
 */
function nullToStr(str){
	if(str==null||typeof str =="undefined"){
		return "";
	}else{
		return str;
	}
}

/**
 * 문자열 자르기
 * @param str 긴 문자열
 * @param limit 문자 길이
 * @returns {String}
 */
function cutStr(str,limit){
	var tmpStr = str;
	var byte_count = 0;
	var len = str.length;
	var dot = "";

	for(var i=0; i<len; i++){
		byte_count += getByte(str.charAt(i));
		if(byte_count == limit-1){
			if(getByte(str.charAt(i+1)) == 2){
				tmpStr = str.substring(0,i+1);
				dot = "...";
			}else {
				if(i+2 != len) dot = "...";
				tmpStr = str.substring(0,i+2);
			}
			break;
		}else if(byte_count == limit){
			if(i+1 != len) dot = "...";
				tmpStr = str.substring(0,i+1);
			break;
		}
	}
	return tmpStr+dot;
}


/**
* 항목 문자열 체크
* item - 항목 ID
* itemName - 항목명
* minLen - 최소Byte
* maxLen - 최대Byte
*/
function checkValue(item, itemName, minLen, maxLen){
	var check = true;
	var itemVal = item.value;
	var itemByte = getByte(itemVal);

	if( minLen!=0 ){	// 최소Byte 체크
		if( isEmpty(itemVal) ){
			alert("'"+itemName+"' 항목을 입력하세요.");
			check = false;
		} else if( itemByte<minLen ){
			alert("'"+itemName+"' 항목은 최소 "+minLen+" Byte (현재 "+itemByte+" Byte) 이상이어야 합니다.");
			check = false;
		}
	}

	if( check && maxLen!=0 ){	// 최대Byte 체크
		if( itemByte>maxLen ){
			alert("'"+itemName+"' 항목은 최대 "+maxLen+" Byte (현재 "+itemByte+" Byte) 이내이여야 합니다.");
			check = false;
		}
	}


	if( check ) {
		return true;
	} else {
		item.focus();
		return false;
	}
}

/**
* 문자열 길이 구하기
*/
function getByte(str) {
	var len = str.length;
	for (var i = 0; i < str.length; i++)
   		if (str.charCodeAt(i) > 127 ) len++;
	return len;
}

/**
* 문자열 공백 제거 후 공백문자 인지 아닌지 확인
*/
function isEmpty(str) {
	var str = removeSpace(str);
	if( str.length==0 ) return true;
	else return false;
}

/**
* 문자열 공백제거
*/
function removeSpace(str) {
	return str.replace(/\s/gi, "" );
}


/**
* 양쪽 공백 제거 trim()
*/
function strTrim(str) {
	return str.replace(/(^\s*)|(\s*$)/gi, "");
}


/*
 * 대상 문자가 undefined, null , "null" 일 경우 "" 반환
 */
function strNull(str){
	if(str==null || str==undefined || str=="null"){
		str = "";
	}
	return str;
}

function bStart(){
	$.blockUI({ 
        message: $('#loadingBox'),
        css: { 
        	color: '#FFF',
            top:  ($(window).height() - 400) /2 + 'px', 
            //left: ($(window).width() - 400) /2 + 'px', 
            left: '500px',
            width: '700px' 
        } 
    });	
}

function bEnd(){	
	$.unblockUI();
}

function fileExtensionImageReturn(str){
	alert(str);
}


/*
 * 문자열 개인정보 보호 * 문자 치환2
 * 2의 배수로 증가
 * (ex. AA -> A*, AAAA -> AA**, AAAAAA -> AA****, AAAAAAAA -> AAA*****)
 */
function privateTextConverter2(privateText) {
	var replaceText = privateText;
	var power = 0;
	if(typeof privateText == 'string' || privateText instanceof String) {
		if(privateText.length > 1) {
			power++;
			for (var textLength = privateText.length; textLength > 2; textLength /= 2) {
				power++;
			}
			for (var i = power; i < privateText.length; i++) {
				replaceText = replaceText.replaceAt(i, "*");
			}
			return replaceText;
		}else {
			return privateText;
		}
	}
}

/*
 * E-mail 개인정보 보호 * 문자 치환2 (@ 이전 문자열만 치환)
 */
function privateEmailConverter2(emailText) {
	var replaceText = emailText;
	if(emailText.indexOf("@") > 0) {
		return privateTextConverter2(replaceText.substr(0, replaceText.indexOf("@"))) + emailText.substr(emailText.indexOf("@"), emailText.length);
	}else {
		return privateTextConverter2(replaceText);
	}
}

/*
 * 문자열의 index 번째 글자를 character로 치환해주는 함수
 */
String.prototype.replaceAt=function(index, character) {
	return this.substr(0, index) + character + this.substr(index+character.length);
}


function privateInformationConverter(text) {
	var replaceText = text;
	var replaceLength = text.length - 4;
	if(replaceLength > 0) {
		for(var i = 0; i < replaceLength; i++) {
			replaceText = replaceText.replaceAt(4 + i, "*");
		}
	}
	return replaceText;
}