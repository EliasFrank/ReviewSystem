function add(userId) {

    var xmlHttp = get();

    xmlHttp.open("POST", "/ReviewSystem/AddExpertServlet", true);

    xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    xmlHttp.send("id=" + userId);

    xmlHttp.onreadystatechange = function(){
        if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
            alert("申请成功");
        }
    };
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