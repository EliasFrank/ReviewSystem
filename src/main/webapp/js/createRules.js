function storeGame() {
    var gameForm = document.getElementById("gameForm");
    gameForm.action="/ReviewSystem/StoreGameServlet";
    gameForm.submit();
}
function addGame() {
   var type = document.getElementById("type").value;
    if(type.length > 10 || myTrim(type) == ""){
        alert("项目类型必须在10字以内，且不能为空或全是空格");
        return;
    }
    var name = document.getElementById("name").value;
    if(name.length > 10 || myTrim(name) == ""){
        alert("项目名必须在10字以内，且不能为空或全是空格");
        return;
    }
    var welcome = document.getElementById("welcome").value;
    if(welcome.length > 20 || myTrim(welcome) == ""){
        alert("欢迎标语必须在20字以内，且不能为空或全是空格");
        return;
    }
    var standards = document.getElementsByName("standard");
    var standardGrades = document.getElementsByName("standardGrade");
    for (var i = 0; i < standards.length; i++){
        var str = standards[i].value;
        var grade = standardGrades[i].value;
        if (str.length > 10 || myTrim(str) == "") {
            alert("评分标准在10字以内，不能全为空格");
            return;
        }
        if(!(/(^[1-9]\d*$)/.test(grade)) || grade > 1000){
            alert("分数只能是小于1000的正整数！");
            return;
        }
    }
    var startTime = document.getElementById("startTime").value;
    var endTime = document.getElementById("endTime").value;
    if(startTime == "" || endTime == ""){
        alert("请选择申报时间");
        return;
    }
    if(!checkdate(startTime, endTime)){
        alert("结束日期不能小于开始日期");
        return;
    }
    var introduce = document.getElementById("introduce").value;
    if(introduce.length > 200 || myTrim(introduce) == ""){
        alert("项目类型必须在200字以内，且不能为空或全是空格");
        return;
    }
   var inputFile = document.getElementById("exampleInputFile").value;
   if(inputFile == ""){
       alert("请选择要上传的文件");
       return ;
   }
   var gameForm = document.getElementById("gameForm");
   gameForm.action="/ReviewSystem/AddGameServlet";
    gameForm.submit();
}
var n = 1;
var tbody = document.getElementById("standard");
window.onload = function btn(){
    document.getElementById("add").onclick = function(){
        add();
        // alert(n);
        // console.log(n);
    }
    document.getElementById("del").onclick = function(){
        del();
        // alert(n);
        // console.log(n);
    }
}

function add(){
    if (document.getElementsByName("standard").length >= 10){
        alert("最多设置10条评分标准");
        return;
    }
    // var code = "<tr id='row"+n+"'><td><span class='star'>*</td><td></td><td><input type='text' class='form-control' placeholder='评分标准名' name='standard' id='standard"+n
    // +"'></td><td><input type='text' class='form-control' placeholder='分数' name='standardGrade' id='standardGrade"+n+"'></td></tr>";
    var tr = document.createElement("tr");
    tr.setAttribute("id", "row"+n);
    var td1 = document.createElement("td");
    td1.innerHTML = "<td><span class='star'>*</td>";
    var td2 = document.createElement("td");
    var td3 = document.createElement("td");
    td3.innerHTML = "<input type='text' class='form-control' placeholder='评分标准名' name='standard' id='standard"+n+"'>";
    var td4 = document.createElement("td");
    td4.innerHTML = "<input type='text' class='form-control' placeholder='分数占比' name='standardGrade' id='standardGrade"+n+"'>";
    tr.appendChild(td1);
    tr.appendChild(td2);
    tr.appendChild(td3);
    tr.appendChild(td4);
    tbody.appendChild(tr);
    n+=1;
}

function del(){
    if(n <= 1){
        return 0;
    }
    var row = document.getElementById("standard");
    // console.log("row is " + row.childNodes[row.childNodes.length-1]);
    // alert(row.childNodes);
    var childnode = row.childNodes[row.childNodes.length - 1];

    var childnodes = childnode.childNodes;
    console.log(childnodes);
    console.log("childsnodes is " + childnodes.length);
    for(var i = 0; i < childnodes.length; i++){
        childnode.removeChild(childnodes[i]);
    }

    row.removeChild(childnode);
    n-=1;
}
function myTrim(x) {
    return x.replace(/^\s+|\s+$/gm,'');
}
function checkdate(startTime, endTime)
{

//得到日期值并转化成日期格式，replace(//-/g, "//")是根据验证表达式把日期转化成长日期格式，这样

//再进行判断就好判断了
    var sDate = new Date(startTime.replace(/-/g, "//"));
    var eDate = new Date(endTime.replace(/-/g, "//"));
    if(sDate > eDate)
        return false;
    return true;
}