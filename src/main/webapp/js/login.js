
function login(){
    var name = document.getElementById("UserName").value;
    var pwd = document.getElementById("Password").value;

    if(name == null || name.length != 8 || name.length != 13){
        alert("用户名错误");
        return ;
    }
    if(pwd == null || pwd.length < 8 || pwd.length > 16){
        alert("密码长度错误");
        return ;
    }
    var login = document.getElementById("loginForm");
    login.action = "/ReviewSystem/LoginServlet";
    login.submit();
}

  $(function(){
      $("[data-toggle='tooltip']").tooltip();
  })