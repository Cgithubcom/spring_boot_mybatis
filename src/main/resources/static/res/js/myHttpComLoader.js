myHttpComLoader.useCach=false;//是否使用缓存
myHttpComLoader.doc=document.implementation.createHTMLDocument('');
function myHttpComLoader(url,name) {
    var comp = myHttpComLoader.parseComponentUR(url);
    return comp;
}
myHttpComLoader.parseComponentUR=function(url){
    function require(moduleName) {

        return window[moduleName];
    }
    var html=myHttpComLoader.httpRequest(url);
    var pHtml=myHttpComLoader.parse(html);
    var module = { exports:{} };
    Function('module', 'require', pHtml.strScipt)(module, require);
    var com=module.exports;
    com.template=pHtml.strHtml
    myHttpComLoader.addStyle(pHtml.strStyle);
    return com;
}
myHttpComLoader.addStyle=function(strStyle){
    var divId="myStyle"
    var divStyle=document.getElementById(divId);
    if(divStyle==null){
        divStyle=document.createElement("div");
        divStyle.id=divId;
        document.body.appendChild(divStyle);
    }
    divStyle.innerHTML=strStyle;
}
myHttpComLoader.httpRequest = function(url) {
    if(!myHttpComLoader.useCach){
        if(url.indexOf("?")>=0){
            url+="&myHttpComLoader=" + Math.random();
        }else{
            url+="?myHttpComLoader=" + Math.random();
        }
    }
    var xhr = new XMLHttpRequest();
    xhr.open('GET', url, false);
    xhr.send(null);
    if ( xhr.status === 200 )
        return xhr.responseText;
    else
        alert(xhr.status, xhr.statusText);
}
myHttpComLoader.parse=function(html){
    var doc=myHttpComLoader.doc;
    doc.body.innerHTML=html;
    var templateElt = null;
    var scriptElt = null;
    var styleElts = [];
    for ( var it = doc.body.firstChild; it; it = it.nextSibling ) {

        switch ( it.nodeName ) {
            case 'TEMPLATE':
                templateElt = it.innerHTML;
                break;
            case 'SCRIPT':
                scriptElt = it.innerHTML;
                break;
            case 'STYLE':
                styleElts.push(it.outerHTML);
                break;
        }
    }
    return {
        strStyle:styleElts,
        strScipt:scriptElt,
        strHtml:templateElt
    }
}