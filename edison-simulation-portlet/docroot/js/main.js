

function customAlert(p_msg){
	alert(p_msg);
}


function customConfirm(p_msg){
	return confirm(p_msg);
}


function nullToStr(str){
	if(str==null||typeof str =="undefined"){
		return "";
	}else{
		return str;
	}
}


function nullToStrReplace(str, replaceStr){
	if(str==null || typeof str =="undefined" || str==""){
		return replaceStr;
	}else{
		return str;
	}
}


function replaceAll(str, orgStr, repStr){
    return str.split(orgStr).join(repStr);
}

/**
 * 공백없애기
 * str -> 공백을 제거할 Parameter
 * retrun 공백이 제거된 Parameter
 */
function spaceDelete(str){
	var sDstr = str.replace(/\s/g,'');
	return sDstr;
}

function bStart(){
	$.blockUI({ 
        message: $('#loadingBox'),
        css: { 
        	color: '#FFF',
            top:  ($(window).height() - 400) /2 + 'px', 
            left: (window.innerWidth - 700) /2 + 'px',  
//            left: '500px',
            width: '700px' 
        }, 
        onBlock: function() { 
        	$("body").css('overflow','hidden')
        } 
    });	
}

function bEnd(){	
	$.unblockUI({ 
		onUnblock: function(){$("body").css('overflow','');} 
	}); 
}

//콤마 제거
function removeComma(n){ //제거
	n=new String(n); 
	return parseInt(n.replace(/,/gi,""));
}
//3자리 마다 콤마 찍기 
function addComma(num){		
	if(num=="")	num = 0;
	if(isNaN(num))  num = 0;	
    if(num == 0) return num;
    
	num = removeComma(num);
	
	var sign="";	
    if(num < 0){ 
        num = num * (-1); 
        sign="-"; 
    }else{ 
        num=num*1; 
    }
       
    num = new String(num) 
    var temp=""; 
    var pos=3;     
    num_len=num.length; 
    
    while (num_len>0){ 
        num_len=num_len-pos; 
        if(num_len<0) { 
            pos=num_len+pos; 
            num_len=0; 
        } 
        temp=","+num.substr(num_len,pos)+temp; 
    } 

	num = sign+temp.substr(1);	
	return num;	
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
* 문자열 길이 구하기
*/
function getByte(str) {
	var len = str.length;
	for (var i = 0; i < str.length; i++)
   		if (str.charCodeAt(i) > 127 ) len++;
	return len;
}