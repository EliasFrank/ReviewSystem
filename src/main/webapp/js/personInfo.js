function loadPersonInfo(){
    var xmlhttp;
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    
    }
    else{
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange==function(){
        if (xmlhttp.readyState==4 && xmlhttp.status==200) {
            document.getElementById("userInput").innerHTML="<input type='text' class='' name='userName'>";
        }
    }
}