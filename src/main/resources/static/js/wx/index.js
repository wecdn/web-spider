$(function(){
    initPage();
    bindBtn();
});

/**
 * 页面初始化
 */
function initPage(){
    [].slice.call( document.querySelectorAll( 'select.cs-skin-boxes' ) ).forEach( function(el) {
        new SelectFx(el, {
            stickyPlaceholder: false,
            onChange: function(val){
                document.querySelector('span.cs-placeholder').style.backgroundColor = val;
            }
        });
    } );
    [].slice.call( document.querySelectorAll( 'select.cs-skin-underline' ) ).forEach( function(el) {
        new SelectFx(el);
    } );

    $("#colorful-background-image").colorfulTab({
        theme: "flatline",
        backgroundImage: "true",
        overlayColor: "#002F68",
        overlayOpacity: "0.8"
    });
}

/**
 * 绑定按钮事件
 */
function bindBtn(){
    $("#btnAnalysis").click(function(){
        analysisWx();
    });
}

/**
 * loding加载效果
 */
function loading(){
    $('body').loading({
        loadingWidth: 240,
        title: '请稍等!',
        name: 'analysis-loading',
        discription: '正在玩儿命解析中 ... ',
        direction: 'column',
        type: 'origin',
        // originBg:'#71EA71',
        originDivWidth: 40,
        originDivHeight: 40,
        originWidth: 6,
        originHeight: 6,
        smallLoading: false,
        loadingMaskBg: 'rgba(0,0,0,0.2)'
    });
}

/**
 * 解析微信文章
 */
function analysisWx(){
    $.ajax({
        type: "GET",
        //请求的媒体类型
        contentType: "application/json;charset=UTF-8",
        //请求地址
        url: "/spider/wx/analysis",
        //数据，json字符串
        data: {
            articleType: $('#articleType').val(),
            articleOrder: $('#articleOrder').val(),
            articleUrl: $('#articleUrl').val(),
        },
        beforeSend: function(){
            loading();
        },
        complete: function(){
            removeLoading('analysis-loading');
        },
        //请求成功
        success: function(result) {
            console.log(result);
            alert(result.data);
        },
        //请求失败，包含具体的错误信息
        error: function(e){
            console.log(e);
            alert("请求发生异常，请查看日志");
        }
    });
}