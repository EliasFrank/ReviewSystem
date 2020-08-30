function agreeChooseExpert(userId, itemId, selectId){
    var select = document.getElementById("select" + selectId);
    var experts = "";
    for (var i = 0; i < select.length; i++) {
        if (select.options[i].selected == true)
            experts += select.options[i].value + ",";
    }
    var xmlHttp = get();

    xmlHttp.open("POST", "/ReviewSystem/DistributeExpertServlet", true);

    xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    xmlHttp.send("experts=" + experts + "&itemId=" + itemId);

    xmlHttp.onreadystatechange = function(){
        if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
            var result = xmlHttp.responseText;
            alert(result);
            chooseExpert();
        }
    };
}
function chooseExpert() {
    var xmlHttp = get();

    xmlHttp.open("POST", "/ReviewSystem/ChooseExpertServlet", true);

    xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    xmlHttp.send();

    xmlHttp.onreadystatechange = function(){
        if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
            var result = xmlHttp.responseText;
            var choice = eval("(" + result + ")");
            addChoose(choice);
            getExperts(choice.length);
        }
    };
}
function getExperts(chioces) {
    var xmlHttp = get();
    var experts;
    xmlHttp.open("POST", "/ReviewSystem/SelectExpertServlet", true);

    xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    xmlHttp.send();
    xmlHttp.onreadystatechange = function() {
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
            var result = xmlHttp.responseText;
            experts = eval("(" + result + ")");
            addSelectExpert(chioces,experts);
        }
    }
}
function addSelectExpert(choices, experts) {

    for(var i = 0; i < choices ; i++){
        var select = document.getElementById("select" + i);
        for(var j = 0; j < experts.length; j++){
            var option = document.createElement("option");
            option.setAttribute("value", experts[j].userId);
            option.appendChild(document.createTextNode(experts[j].name));
            select.appendChild(option);
        }
    }
}
function addChoose(choice) {
    var tbody = document.getElementById("chooseExpert");
    tbody.innerHTML = "";
    for(var i = 0; i < choice.length; i++){
        var tr = document.createElement("tr");

        var td = document.createElement("td");
        var span = document.createElement("span");
        span.appendChild(document.createTextNode(choice[i].userName));
        td.appendChild(span);

        var td2 = document.createElement("td");
        var span2 = document.createElement("span");
        span2.appendChild(document.createTextNode(choice[i].itemName));
        td2.appendChild(span2);

        var td3 = document.createElement("td");
        var span3 = document.createElement("span");
        span3.appendChild(document.createTextNode(choice[i].gameName));
        td3.appendChild(span3);

        var td5 = document.createElement("td");
        var span5 = document.createElement("span");
        span5.appendChild(document.createTextNode(choice[i].subTime));
        td5.appendChild(span5);

        var td4 = document.createElement("td");
        var a = document.createElement("a");
        a.appendChild(document.createTextNode("确认分配"));
        var str = "agreeChooseExpert(" + choice[i].userId + ", " + choice[i].itemId + ", " + i + ")";
        a.setAttribute("onclick", str);
        a.setAttribute("class", "btn btn-info");
        td4.appendChild(a);

        var td6 = document.createElement("td");
        var select = document.createElement("select");
        select.setAttribute("name", "select");
        select.setAttribute("class", "form-control");
        select.setAttribute("multiple", "multiple");
        select.setAttribute("id", "select" + i);

        td6.appendChild(select);
        tr.appendChild(td);
        tr.appendChild(td2);
        tr.appendChild(td3);
        tr.appendChild(td5);
        tr.appendChild(td6);
        tr.appendChild(td4);
        tbody.appendChild(tr);
    }
}
function toBeExpert(userId) {

    var xmlHttp = get();

    xmlHttp.open("POST", "/ReviewSystem/CheckExpertServlet", true);

    xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    xmlHttp.send("id=" + userId);

    xmlHttp.onreadystatechange = function(){
        if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
            alert("已同意该请求");
            selectAllCheck();
        }
    };
}
function agreeApply(id) {

    var xmlHttp = get();

    xmlHttp.open("POST", "/ReviewSystem/AgreeApplyServlet", true);

    xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    xmlHttp.send("id=" + id);

    xmlHttp.onreadystatechange = function(){
        if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
            alert("已同意该请求");
            checkUserApply();
        }
    };
}
function selectAllCheck() {
    var xmlHttp = get();

    xmlHttp.open("POST", "/ReviewSystem/SelectCheckServlet", true);

    xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    xmlHttp.send();

    xmlHttp.onreadystatechange = function(){
        if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
            var result = xmlHttp.responseText;
            var users = eval("(" + result + ")");
            addCheckUser(users);
        }
    };
}
function addCheckUser(users) {

    var tbody = document.getElementById("checkUser");
    tbody.innerHTML = "";
    for(var i = 0; i < users.length; i++){
        var tr = document.createElement("tr");

        var td = document.createElement("td");
        var span = document.createElement("span");
        span.appendChild(document.createTextNode(users[i].name));
        td.appendChild(span);

        var td2 = document.createElement("td");
        var span2 = document.createElement("span");
        var identify;
        if(users[i].userflag == 0)
            identify = "管理员";
        else if (users[i].userflag == 1)
            identify = "专家";
        else
            identify = "普通用户";
        span2.appendChild(document.createTextNode(identify));
        td2.appendChild(span2);

        var td3 = document.createElement("td");
        var span3 = document.createElement("span");
        span3.appendChild(document.createTextNode(users[i].email));
        td3.appendChild(span3);

        var td4 = document.createElement("td");
        var a = document.createElement("a");
        a.appendChild(document.createTextNode("同意成为专家"));
        var str = "toBeExpert(" + users[i].userId + ")";
        a.setAttribute("onclick", str);
        a.setAttribute("class", "btn btn-info");
        td4.appendChild(a);

        tr.appendChild(td);
        tr.appendChild(td2);
        tr.appendChild(td3);
        tr.appendChild(td4);
        tbody.appendChild(tr);
    }
}
function checkUserApply() {

    var xmlHttp = get();

    xmlHttp.open("POST", "/ReviewSystem/SelectUserApplyServlet", true);

    xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    xmlHttp.send();

    xmlHttp.onreadystatechange = function(){
        if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
            var result = xmlHttp.responseText;
            var applys = eval("(" + result + ")");
            addUserApply(applys);
        }
    };
}
function addUserApply(applys) {

    var tbody = document.getElementById("checkUserApply");
    tbody.innerHTML = "";
    for(var i = 0; i < applys.length; i++){
        var tr = document.createElement("tr");

        var td = document.createElement("td");
        var span = document.createElement("span");
        span.appendChild(document.createTextNode(applys[i].number));
        td.appendChild(span);

        var td2 = document.createElement("td");
        var span2 = document.createElement("span");
        span2.appendChild(document.createTextNode(applys[i].userName));
        td2.appendChild(span2);

        var td3 = document.createElement("td");
        var span3 = document.createElement("span");
        span3.appendChild(document.createTextNode(applys[i].gameType));
        td3.appendChild(span3);

        var td5 = document.createElement("td");
        var span5 = document.createElement("span");
        span5.appendChild(document.createTextNode(applys[i].gameName));
        td5.appendChild(span5);

        var td4 = document.createElement("td");
        var a = document.createElement("a");
        a.appendChild(document.createTextNode("同意申报项目"));
        var str = "agreeApply(" + applys[i].id + ")";
        a.setAttribute("onclick", str);
        a.setAttribute("class", "btn btn-info");
        td4.appendChild(a);

        tr.appendChild(td);
        tr.appendChild(td2);
        tr.appendChild(td3);
        tr.appendChild(td5);
        tr.appendChild(td4);
        tbody.appendChild(tr);
    }
}
function selectAllGames() {
    var xmlHttp = get();

    xmlHttp.open("POST", "/ReviewSystem/SelectAllGmaesServlet", true);

    xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    xmlHttp.send();

    xmlHttp.onreadystatechange = function(){
        if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
            var result = xmlHttp.responseText;
            var games = eval("(" + result + ")");
            addGames(games);
        }
    };
}
function addGames(games) {

    var tbody = document.getElementById("games");
    tbody.innerHTML = "";
    for(var i = 0; i < games.length; i++){
        var tr = document.createElement("tr");

        var td = document.createElement("td");
        var span = document.createElement("span");
        span.appendChild(document.createTextNode(games[i].gameId));
        td.appendChild(span);

        var td2 = document.createElement("td");
        var span2 = document.createElement("span");
        span2.appendChild(document.createTextNode(games[i].type));
        td2.appendChild(span2);

        var td3 = document.createElement("td");
        var span3 = document.createElement("span");
        span3.appendChild(document.createTextNode(games[i].gameName));
        td3.appendChild(span3);

        var td4 = document.createElement("td");
        var a = document.createElement("a");
        a.appendChild(document.createTextNode("查看排名"));
        var str = "/ReviewSystem/SelectRankServlet?id=" + games[i].gameId;
        a.setAttribute("href", str);
        a.setAttribute("class", "btn btn-info");
        a.setAttribute("role", "button");
        td4.appendChild(a);

        tr.appendChild(td);
        tr.appendChild(td2);
        tr.appendChild(td3);
        tr.appendChild(td4);
        tbody.appendChild(tr);
    }
}
function get(){
    try {
        return new XMLHttpRequest();
    } catch (e) {
        try {
            return new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
            try {
                return new ActiveXObject("Microsoft.XMLHTTP")
            } catch (e) {
                alert("error");
                throw e;
            }
        }
    }
}