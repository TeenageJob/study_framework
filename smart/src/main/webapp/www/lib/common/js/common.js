/**一种方法*/
//Base1 = {submit : function(a, b, c) {alert(a + b + c);}}
/**第二种方法*/
//function Base2() {this.name = "car";}
//Base2.submit = function() {alert("base2");}
/**第三种方法*/
//var Base3 = Object.create(Base2);
//Base3.submit = function() {alert("Base3");};
/**
 * 框架基础方法
 *
 * @auther TY
 */
/**
 *
 * var options = {
   target: '#output',          //把服务器返回的内容放入id为output的元素中
   beforeSubmit: showRequest,  //提交前的回调函数
   success: showResponse,      //提交后的回调函数
   //url: url,                 //默认是form的action， 如果申明，则会覆盖
   //type: type,               //默认是form的method（get or post），如果申明，则会覆盖
   //dataType: null,           //html(默认), xml, script, json...接受服务端返回的类型
   //clearForm: true,          //成功提交后，清除所有表单元素的值
   //resetForm: true,          //成功提交后，重置所有表单元素的值
   timeout: 3000               //限制请求的时间，当请求大于3秒后，跳出请求
}

 function showRequest(formData, jqForm, options){
   //formData: 数组对象，提交表单时，Form插件会以Ajax方式自动提交这些数据，格式如：[{name:user,value:val },{name:pwd,value:pwd}]
   //jqForm:   jQuery对象，封装了表单的元素
   //options:  options对象
   var queryString = $.param(formData);   //name=1&address=2
   var formElement = jqForm[0];              //将jqForm转换为DOM对象
   var address = formElement.address.value;  //访问jqForm的DOM元素
   return true;  //只要不返回false，表单都会提交,在这里可以对表单元素进行验证
};

 function showResponse(responseText, statusText){
   //dataType=xml
   var name = $('name', responseXML).text();
   var address = $('address', responseXML).text();
   $("#xmlout").html(name + "  " + address);
   //dataType=json
   $("#jsonout").html(data.name + "  " + data.address);
};

 $("#myForm").ajaxForm(options);

 $("#myForm2").submit(funtion(){
   $(this).ajaxSubmit(options);
   return false;   //阻止表单默认提交
});
 *
 *
 * @type {{submitForm: Base.submitForm, submit: Base.submit}}
 */
Base = {
    submitForm: function (form_id, url, type) {
        var id = form_id = "#" + form_id;
        $(id).attr("action", url);
        $(id).attr("method", type);
        $(id).submit();
    },
    /**
     * ajaxForm 异步提交 <br>
     * 参数： <br>
     * INPUTID, 需要提交的组件id 必填 <br>
     * URL, url 必填 <br>
     * BEFORE, 提交之前的方法 <br>
     * SUCCESS, 成功后的方法 <br>
     * error:function(){}, //提交失败执行的函数 <br>
     * TYPE, 提交类型：get、post 默认post <br>
     * DATATYPE, 后台返回数据类型：html、json、text、script。。。 <br>
     * RESETFORM, 成功提交后，清除所有表单元素的值 默认false <br>
     * CLEARFORM, 成功提交后，重置所有表单元素的值 默认false <br>
     * OUTTIME 限制请求的时间，当请求大于时间，跳出请求 默认3秒
     */
    submit: function () {
        var ID = null, URL = null, BEFORE = null, SUCCESS = null,
            TYPE = null, DATATYPE = null, RESETFORM = null, CLEARFORM = null, OUTTIME = null;
        if (arguments.length < 2 && arguments.length > 9 && arguments[1] == "") {
            return;
        } else {
            ID = arguments[0];
            if (arguments[0].startsWith("/")) {
                URL = "/smart" + arguments[1];
            } else {
                URL = "/smart/" + arguments[1];
            }
            TYPE = arguments[2];
            SUCCESS = arguments[3];
            BEFORE = arguments[4];
            DATATYPE = arguments[5];
            RESETFORM = arguments[6];
            CLEARFORM = arguments[7];
            OUTTIME = arguments[8];
        }
        var options = {
            target: '#output', // 把服务器返回的内容放入id为output的元素中
            beforeSubmit: function () {
                if (BEFORE != null) {
                    BEFORE = eval(BEFORE);
                    BEFORE.call();
                }
            }, // 提交前的回调函数
            success: SUCCESS == null ? fnBack
                : SUCCESS, // 提交后的回调函数
            url: URL, // 默认是form的action， 如果申明，则会覆盖
            type: TYPE == null ? "POST" : TYPE, // 默认是form的method（get or
            // post），如果申明，则会覆盖
            dataType: DATATYPE == null ? "html" : DATATYPE, // html(默认),
            // xml, script,
            // json...接受服务端返回的类型
            clearForm: RESETFORM == null ? false : CLEARFORM, // 成功提交后，清除所有表单元素的值
            resetForm: CLEARFORM == null ? false : RESETFORM, // 成功提交后，重置所有表单元素的值
            timeout: OUTTIME == null ? 0 : 3000
            // 限制请求的时间，当请求大于3秒后，跳出请求
        };
        $("#" + ID).ajaxSubmit(options);
    },

    submitA: function () {
        var URL = null, BEFORE = null, SUCCESS = null,
            TYPE = null, DATATYPE = null, COMPETE = null, ERROR = null, ASYNC = null,
            CONTENTYPE = null, DATA = null;
        if (arguments.length < 1 && arguments.length > 10 && arguments[0] == "") {
            return;
        } else {
            if (arguments[0].startsWith("/")) {
                URL = "/smart" + arguments[0];
            } else {
                URL = "/smart/" + arguments[0];
            }
            SUCCESS = arguments[1];
            ERROR = arguments[2];
            DATA = arguments[3];
            TYPE = arguments[4];
            DATATYPE = arguments[5];
            COMPETE = arguments[6];
            BEFORE = arguments[7];
            ASYNC = arguments[8];
            CONTENTYPE = arguments[9];
        }
        var options = {
            data: DATA == null ? null : DATA,//传输数据
            beforeSend: BEFORE == null ? null : BEFORE, // 提交前的回调函数
            success: (SUCCESS == null || SUCCESS == null) ? null : SUCCESS, // 提交后的回调函数
            contentType: (CONTENTYPE == null || CONTENTYPE == null) ? "application/x-www-form-urlencoded" : CONTENTYPE,
            url: URL, // 默认是form的action， 如果申明，则会覆盖
            type: TYPE == null ? "POST" : TYPE, // 默认是form的method（get or post），如果申明，则会覆盖
            dataType: DATATYPE == null ? "json" : DATATYPE, // html(默认), xml, script,json...接受服务端返回的类型
            complete: COMPETE == null ? ajax_complete : COMPETE, // 请求完成后回调函数 (请求成功或失败之后均调用)
            error: ERROR == null ? null : ERROR, // 成功提交后，重置所有表单元素的值
            async: ASYNC == null ? false : ASYNC // 限制请求的时间，当请求大于3秒后，跳出请求
        };
        $.ajax(options);
    },

    //弹窗
    alert: function (options, data) {
        if (typeof options == null) {
            options = "hahahaha";
        }
        options = options.toString().toLowerCase();
        switch (options) {
            case "info":
                $("#ty_alertDiv").append(Base.shape_up);
                $("#myModalLabel").html("你有新的消息。");
                $(".modal-body").html(data);
                $('#infobtn').click();
                break;
            case "error":
                $("#ty_alertDiv").append(Base.shape_up);
                $("#myModalLabel").html("警告、警告、警告");
                $(".modal-body").html(data);
                $('#infobtn').click();
                break;
            case "affirm":
                $("#ty_alertDiv").append(Base.shape_up);
                $(".modal-footer").append(Base.btn_cancel);
                $("#myModalLabel").html("你真的要这样做吗？");
                $(".modal-body").html(data);
                $('#infobtn').click();
                break;
            default:
                $("#ty_alertDiv").append(Base.shape_up);
                $("#myModalLabel").html("你有新的消息。");
                $(".modal-body").html(options);
                $('#infobtn').click();
                break;
        }
        ;
        /* $("#affirm").click(function () {
            // $('#myModal').modal('hide');
            /!* $('#pop-up').on('hidden.bs.modal', function (e) {
                 $("#pop-up").remove();
             });*!/
         });*/
    },
    shape_up:
    '<div id="pop-up" >' +
    '<button id="infobtn" type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal"></button>' +
    '<div class="modal fade bs-example-modal-sm" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">' +
    '<div class="modal-dialog modal-sm"  style="margin-top:20%"  role="document">' +
    '<div class="modal-content">' +
    '<div class="modal-header">' +
    '<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>' +
    '<h4 class="modal-title" id="myModalLabel">Modal title</h4></div>' +
    '<div  class="modal-body"></div>' +
    '<div class="modal-footer">' +
    '<button id="affirm" type="button" onclick="closeAlert()" class="btn btn-primary">确定</button></div></div></div></div></div>',
    btn_cancel: '<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>',

    //设置数据
    setData: function (id, data) {
        $("#" + id).val(data);
        $("#" + id).selectpicker('val', data);
    },
    setDisabled: function () {
        if (arguments.length < 1) {
            return;
        } else {
            for (var id in arguments) {
                $("#" + arguments[id]).attr("disabled", true);

            }
        }
    },
    setEnabled: function () {
        if (arguments.length < 1) {
            return;
        } else {
            for (var id in arguments) {
                $("#" + arguments[id]).attr("disabled", false);
            }
        }
    },
    clearData: function () {
        if (arguments.length < 1) {
            return;
        } else {
            for (var id in arguments) {
                $("#" + arguments[id]).val("");
            }
        }
    },
    getVal: function () {
        if (arguments.length < 1) {
            return;
        } else {
            return $("#" + arguments[0]).val();
        }
    },
    setHide: function () {
        if (arguments.length < 1) {
            return;
        } else {
            for (var id in arguments) {
                $("#" + arguments[id] + "_div").hide();
                $("#" + arguments[id]).hide();
            }
        }
    },
    setFocus: function (id) {
        $("#" + id).focus();
    },
    setReadOnly: function () {
        if (arguments.length < 1) {
            return;
        } else {
            for (var id in arguments) {
                //$("#" + arguments[id]).readOnly();
                $("#" + arguments[id]).attr("readOnly", "readOnly");
            }
        }
    },
    setShow: function () {
        if (arguments.length < 1) {
            return;
        } else {
            for (var id in arguments) {
                $("#" + arguments[id] + "_div").show();
                $("#" + arguments[id]).show();
            }
        }
    },
    setSelectInput: function (id, data) {
        $("#" + id).empty();
        for (var key in data) {
            var val = data[key].toString().split(",");
            var html = "<option aid=\"" + val[0] + "\" value=\"" + val[1] + "\">" + val[1] + "</option>";
            $("#" + id).append(html);
        }
        $('.selectpicker').selectpicker('refresh');
    },
    setGridData: function (key, data) {
        $("#" + key).bootstrapTable('load', data);
    }
}


function closeAlert() {
    $('#myModal').modal('hide');
    setTimeout("closeAlerts()", "200"); //200毫秒后执行testFunction()函数，只执行一次。

}

function closeAlerts() {
    $("#ty_alertDiv").empty();
}


function loadHtml(data) {
    fnBack(data);
}


function show_page(url) {
    if (url == "/menuManager/menuManager.do") {
        Base.submitA(url, fnBack, fnError, null, null, "html");//两次刷新 获取bootstrap 插件
    }
    Base.submitA(url, fnBack, fnError, null, null, "html");

}

function fnBack(responseText) {
    $("#context_div").empty();
    if (responseText.toString().indexOf("div") > 0 ||
        responseText.toString().indexOf("table") > 0 ||
        responseText.toString().indexOf("input") > 0) {
        $("#context_div").html(responseText);
    } else {
        $("#context_div").append('<iframe frameborder="0" marginwidth="0" height="100%" width="100%" overflow="auto" marginheight="0" id="context_iframe" name="context_iframe"></iframe>');
        $("#context_iframe").attr("src", "../" + responseText.substring(1, responseText.length - 1));
    }
    //var obj=window.frames["context_iframe"];
    //obj.document.innerHTML = responseText;

    //$("#context_iframe body").html(responseText);

}

function fnError(data) {
    Base.submitA("/common/notFoundPage.do", function (data) {
        loadHtml(data);
    });
}

function ajax_complete(event, xhr) {
    var json = event.responseText;
    if (json.toString().indexOf("div") > 0) {
        return;
    }
    var json = JSON.parse(event.responseText);
    var success = json.success;
    var message = json.message;
    var messageType = json.messageType;
    var inputData = json.inputData;
    for (var key in inputData) {
        Base.setData(key, inputData[key]);

    }

    var selectData = json.selectData;
    var tableData = json.tableData;

    for (var key in tableData) {
        Base.setGridData(key, tableData[key].list);
    }

    // var focus=json.focus;
    //  Base.setFocus(focus);
    var operation = json.operation;
    for (var key in operation) {
        var values = operation[key];
        for (var pro in values) {
            var keyDiv = key + "_div";
            switch (values[pro]) {
                case "hide":
                    Base.setHide(keyDiv, key);
                    break;
                case "foucs":
                    Base.setFocus(keyDiv, key);
                    break;
                case "readonly":
                    Base.setReadOnly(keyDiv, key);
                    break;
                case "disabled":
                    Base.setDisabled(keyDiv, key);
                    break;
                case "enable":
                    Base.setEnabled(keyDiv, key);
                    break;
                case "show":
                    Base.setShow(keyDiv, key);
                    break;
                case "required":
                    Base.setShow(keyDiv, key);
                    break;
                case "disrequired":
                    Base.setShow(keyDiv, key);
                    break;
            }
        }

    }

}


function Ajax() {
    $.ajax({
        url: "/Handler/AjaxHandlerHelper.ashx?no.=" + Math.random(),
        type: "Post",
        async: false,
        data: {
            Ajax_Type: "Email",
            jsonData: JSON.stringify(jsonData)
        },
        dataType: "json",
        beforeSend: function () { // 发送请求前
            $("#btnPost").attr('disabled', "true");
        },
        complete: function () { // 发送请求完成后
            $("#btnPost").removeAttr("disabled");
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("error!" + errorThrown);
            // alert("请求错误，请重试！");
        },
        success: function (data) {
            Data(data, "Jquery $.ajax");
        }
    });
}

// jquery $.post方法
function Post() {
    $.post("/Handler/AjaxHandlerHelper.ashx?no.=" + Math.random(), {
        Ajax_Type: "Email",
        jsonData: JSON.stringify(jsonData)
    }, function (data) {
        Data(data, "Jquery $.post");
    });
}

// jquery $.getJSON方法
function GetJSON() {
    $.getJSON("/Handler/AjaxHandlerHelper.ashx?no.=" + Math.random(), {
        Ajax_Type: "Email",
        jsonData: JSON.stringify(jsonData)
    }, function (data) {
        Data(data, "Jquery $.getJSON");
    });
}

// jquery $.get方法
function Get() {
    $.get("/Handler/AjaxHandlerHelper.ashx?no.=" + Math.random(), {
        Ajax_Type: "Email",
        jsonData: JSON.stringify(jsonData)
    }, function (data) {
        Data(data, "Jquery $.get");
    });
}


function getContextHeight() {
    return clienth_height - panel_pandding_top - panel_pandding_top - box_margin_bottom - box_margin_bottom;
}

function isInArray(arr, value) {
    for (var i = 0; i < arr.length; i++) {
        if (value === arr[i]) {
            return true;
        }
    }
    return false;
}


function getTime(model) {
    var today = new Date();   // 获取当前时间
    /*
    var str=
        today.getFullYear()+ //获取完整的年份(4位,1970-????)
    today.getMonth()+1+ //获取当前月份(0-11,0代表1月)
    today.getDate()+ //获取当前日(1-31)
    today.getDay()+ //获取当前星期X(0-6,0代表星期天)
    today.getTime()+ //获取当前时间(从1970.1.1开始的毫秒数)
    today.getHours()+ //获取当前小时数(0-23)
    today.getMinutes()+ //获取当前分钟数(0-59)
    today.getSeconds(); //获取当前秒数(0-59)
    today.getMilliseconds(); //获取当前毫秒数(0-999)
    today.toLocaleDateString(); //获取当前日期
    today.toLocaleTimeString(); //获取当前时间
    today.toLocaleString(); //获取日期与时间
    */
    var rnd = "";
    for (var i = 0; i < 5; i++)
        rnd += Math.floor(Math.random() * 10);
    return today.getTime() + rnd;  //格式化时间
}