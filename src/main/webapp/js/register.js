function checkUser(str){
    var re = /^[1-9][0-9]{7}$/;
       if(re.test(str)){
          return true;
       }else{
           return false;
       }          
   }

function  checkMobile(str) {
    var  re = /^1\d{10}$/;
    if (re.test(str)) {
        return true;
    } else {
        return false;
    }
}

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
    var ptr_lowcase = /^.*[a-zA-Z]+.*$/;
    // var ptr_upcase = /^.*[A-Z]+.*$/;
    var ptr_special = /((?=[\x21-\x7e]+)[^A-Za-z0-9])/;
    if(value.length < 8 || value.length > 16) {
        return 1;
      }
      else if((ptr_digit.test(value) && ptr_lowcase.test(value) && ptr_special.test(value))
              || (!ptr_digit.test(value) && ptr_lowcase.test(value) && ptr_special.test(value))
              || (ptr_digit.test(value) && !ptr_lowcase.test(value) && ptr_special.test(value))
              || (ptr_digit.test(value) && ptr_lowcase.test(value) && ptr_special.test(value))
              || (ptr_digit.test(value) && ptr_lowcase.test(value) && !ptr_special.test(value))){
       return 3;
      }
      else {
        return 2;
      }
}

function checkPwdSame(str1, str2){
    if(str1 != str2){
        return false;
    }
    else{
        return true;
    }
}

function register(){
    if(!checkMobile(document.getElementById("inputTel").value)){
        document.getElementById("telError").innerHTML = "电话格式错误";
        return;
    }
    else{
        document.getElementById("telError").innerHTML = "";
    }
    if(!checkUser(document.getElementById("inputName").value)){
        document.getElementById("userError").innerHTML = "用户名格式错误";
        return;
    }
    else{
        document.getElementById("userError").innerHTML = "";
    }
    if(checkPwd(document.getElementById("inputPwd").value) == 1){
        document.getElementById("pwdError").innerHTML = "密码8-16位";
        return;
    }else if(checkPwd(document.getElementById("inputPwd").value) == 2){

        document.getElementById("pwdError").innerHTML = "至少包含大写字母、小写字母、数字、特殊字符中的三类字符";
        return;
    }else{
        document.getElementById("pwdError").innerHTML = "";
    }
    if(!checkPwdSame(document.getElementById("inputSame").value,
        document.getElementById("inputPwd").value)){
        document.getElementById("sameError").innerHTML = "密码不一致";
        return;
    }
    else{
        document.getElementById("sameError").innerHTML = "";
    }
    
    var name = document.getElementById("RealName").value;
    if(name == null || name.length > 20 || name.length == 0){
        alert("姓名不能为空且不能超过20个字符");
        return;
    }
    var form = document.getElementById("register");
    form.action = "/ReviewSystem/RegisterServlet";
    form.submit();

}
