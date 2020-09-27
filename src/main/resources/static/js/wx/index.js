$(function(){

    $("#btnGetWordPressArticle").click(function(){
        getWordPressArticleFormWx();
    });
});

function getWordPressArticleFormWx(){

    $.ajax({
        type : "GET",
        //请求的媒体类型
        contentType: "application/json;charset=UTF-8",
        //请求地址
        url : "/spider/wx/get",
        //数据，json字符串
        data : {
            articleUrl: $('#articleUrl').val(),
            articleOrder: $('#articleOrder').val(),
            articleType: $('#articleType').val()
        },
        //请求成功
        success : function(result) {
            console.log(result.data);
        },
        //请求失败，包含具体的错误信息
        error : function(e){
            alert("请求发生异常");
        }
    });
}