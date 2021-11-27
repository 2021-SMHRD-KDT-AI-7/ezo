function getXMLHttpRequest() {
    if (window.ActiveXObject) {
        try {
            return new ActiveXObject("Msxml2.XMLHTTP");
        } catch(e) {
            try {
                return new ActiveXObject("Microsoft.XMLHTTP");
            } catch(e1) { return null; }
        }
    } else if (window.XMLHttpRequest) {
        return new XMLHttpRequest();
    } else {
        return null;
    }
}
var httpRequest = null;
 
function sendRequest(url, params, callback, method) { 
    //어디로 요청할건지 :url 어떤값을 전송할지를 : params 어떤 전송방식인지 : method 어떤 함수로 처리할지  : callback
    httpRequest = getXMLHttpRequest();
    var httpMethod = method ? method : 'GET';
    if (httpMethod != 'GET' && httpMethod != 'POST') {
        httpMethod = 'GET';
    }
    var httpParams = (params == null || params == '') ? null : params;
    var httpUrl = url;
    if (httpMethod == 'GET' && httpParams != null) {
        httpUrl = httpUrl + "?" + httpParams;
    }
    httpRequest.open(httpMethod, httpUrl, true);
    httpRequest.setRequestHeader(
        'Content-Type', 'application/x-www-form-urlencoded');
    httpRequest.onreadystatechange = callback;
	try{
		httpRequest.send(httpMethod == 'POST' ? httpParams : null);	
	}
	catch(error){
		console.error("ERROR 발생 >>" + error);
	}
	finally{
		sleep(2000);
	}
    
}