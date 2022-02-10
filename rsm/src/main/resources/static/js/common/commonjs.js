var update=function (url,data,callfuncOk,callfuncErr){
    $.ajax({
        url:url,
        data:JSON.stringify(data),
        contentType:"application/json",
        dataType:"json",
        type:"PUT",
        success:function (data) {
            if(data.errorCode == 0){
                callfuncOk
            }
        },
        error:function (err) {
            callfuncErr
        }
    })

}