
function login(){
    var name = document.getElementById("UserName").value;
    var pwd = document.getElementById("Password").value;

    if(name == null || name.length != 11){
        alert("用户名错误");
        return ;
    }
    
    var login = document.getElementById("loginForm");
    login.action = "/ReviewSystem/LoginServlet";
    login.submit();
}

  $(function(){
      $("[data-toggle='tooltip']").tooltip();
  })