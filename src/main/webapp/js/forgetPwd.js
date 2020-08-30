forgetPwd();


function checkEmail(str){
    var re = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
    if(re.test(str)){
        return true;
    }else{
        return false;
    }
}

function checkPwd(value){
    var ptr_digit = /^.*[0-9]+.*$/;
    var ptr_lowcase = /^.*[a-z]+.*$/;
    var ptr_upcase = /^.*[A-Z]+.*$/;
    var ptr_special = /((?=[\x21-\x7e]+)[^A-Za-z0-9])/;
    if(value.length < 8) {
        return 1;
      }
      else if((ptr_digit.test(value) && ptr_lowcase.test(value) && ptr_upcase.test(value) && ptr_special.test(value))
              || (!ptr_digit.test(value) && ptr_lowcase.test(value) && ptr_upcase.test(value) && ptr_special.test(value))
              || (ptr_digit.test(value) && !ptr_lowcase.test(value) && ptr_upcase.test(value) && ptr_special.test(value))
              || (ptr_digit.test(value) && ptr_lowcase.test(value) && !ptr_upcase.test(value) && ptr_special.test(value))
              || (ptr_digit.test(value) && ptr_lowcase.test(value) && ptr_upcase.test(value) && !ptr_special.test(value))){
       return 3;
      }
      else {
        return 2;
      }
}

function checkPwdSame(str1, str2){
    if(str != str2){
        return false;
    }
    else{
        return true;
    }
}

function forgetPwd(){
    document.getElementById("reset").onclick = function(){
        if (!checkEmail(document.getElementById("inputEmail").value)){
            document.getElementById("emailError").innerHTML="电子邮箱格式错误";
        }
        else{
            document.getElementById("emailError").innerHTML="";
        }
        if(checkPwd(document.getElementById("inputPwd").value) == 1){           
            document.getElementById("pwdError").innerHTML = "密码至少8位";
        }else if(checkPwd(document.getElementById("inputPwd").value) == 2){
            
            document.getElementById("pwdError").innerHTML = "至少包含大写字母、小写字母、数字、特殊字符中的三类字符";
        }else{
            document.getElementById("pwdError").innerHTML = "";
        }
        if(!checkPwdSame(document.getElementById("inputSame").value)){
            document.getElementById("sameError").innerHTML = "密码不一致错误";
        }
        else{
            document.getElementById("sameError").innerHTML = "";
        }
    }
}