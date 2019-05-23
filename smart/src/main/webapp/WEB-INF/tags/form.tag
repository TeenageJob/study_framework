<%@ tag import="org.smart.framework.util.StringUtil" %>
<%@tag language="java" pageEncoding="UTF-8"
       trimDirectiveWhitespaces="true" %>
<%@attribute name="method" type="java.lang.String" required="true"
             description="提交方法" %>
<%@attribute name="url" type="java.lang.String" description="url" required="true" %>
<%@attribute name="before" type="java.lang.String" description="url" %>
<form id="form_ty" method="${method}" action="/smart/${url}" style="height: 100%;" before="${before}">
    <div id="check_page_div">
        <jsp:doBody/>
    </div>
</form>
<script type="text/javascript">
    $(function () {
        $('#form_ty').bootstrapValidator({
            live: 'enabled',//验证时机，enabled是内容有变化就验证（默认），disabled和submitted是提交再验证
            excluded: [':disabled', ':hidden', ':not(:visible)'],//排除无需验证的控件，比如被禁用的或者被隐藏的
            //submitButtons: '[id="btn_save"]',
            submitButtons: 'input[id="btn_save"]',
            events: {
                fieldSuccess: function (e, data) {
                    console.log(e);
                    alert("fieldSuccess");
                }
            },
            submitHandler: function () {

            },
            onSuccess: function (e) {
                console.log(e);
                alert("onSuccess");
            },
            trigger: function () {
                alert("trigger");
            },
            onError: function (e) {
                console.log(e);
                alert("onError");
            },
            threshold: null,
            fields: {}
        });
    });
    $('#form_ty').bootstrapValidator('disableSubmitButtons', true);


    $("#btn_save").click(function () {
        console.log($('#form_ty').data('bootstrapValidator').validate());
        if ($("#form_ty").data('bootstrapValidator').isValid()) {
            var fun = $("#form_ty").attr("before");
            if (fun != undefined && fun != null && fun != "") {
                fun = eval(fun);
                var flag = fun.call();
                if (flag == false) {
                    Base.alert("请按要求填写");
                    return;
                }
            }
            var t = $("#form_ty").serializeArray();
            //console.log(t);
            //checkbox
            $.each($('input:checkbox:checked'), function () {
                $(this).attr("checked", "checked");
            });
            $("input:checkbox").each(function () {
                $(this).attr("onclick", "return false;");
            });
            $.each(t, function () {
                $("#" + this.name).attr("value", this.value);
            });
            var html = $("#form_ty").html();
            $("#bpmn_form_html").val(html.toString());
            Base.submit("form_ty", "${url}", "${method}", function () {
                Base.alert("成功！");
                Base.setHide("btn_save", "btn_reset");
            });
        } else {
            alert("未验证通过");
            $('#form_ty').bootstrapValidator('disableSubmitButtons', true);
        }
    });
</script>