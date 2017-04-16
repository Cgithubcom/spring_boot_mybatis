$.ajax({
    url:'/auth/sysRole/list',
    type:'POST', //GET
    async:true,    //或false,是否异步
    data:{
        pageNum:0,
        pageSize:10,
        name:'22'
    },
    timeout:5000,    //超时时间
    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
    success:function(data,textStatus,jqXHR){
        console.log(data)
        console.log(textStatus)
        console.log(jqXHR)
    },
    error:function(xhr,textStatus){
        console.log('错误')
        console.log(xhr)
        console.log(textStatus)
    },
    complete:function(){
        console.log('结束')
    }
})