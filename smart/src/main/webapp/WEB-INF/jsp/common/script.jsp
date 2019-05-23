<%@page import="org.smart.framework.util.StringUtil" %>
<%@ page pageEncoding="UTF-8" %>
<%
    String BASEPATH = request.getContextPath();
    if (StringUtil.isEmpty(BASEPATH)) {
        BASEPATH = "/smart";

    }
    request.setAttribute("BASEPATH", BASEPATH);

%>


<!-- 引入 jquery -->
<script type="text/javascript"
	src="${BASEPATH}/www/lib/jquery/1.11.1/jquery.min.js"></script>
<%--<script type="text/javascript"
        src="${BASEPATH}/www/lib/jquery/3.0.0/jquery-3.0.0.js"></script>--%>

<!-- 引入boostrap js -->
<script type="text/javascript"
        src="${BASEPATH}/www/lib/bootstrap/bootstrap-3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript"
        src="${BASEPATH}/www/lib/bootstrap/bootstrap-3.3.7/js/popover.js"></script>
<script type="text/javascript"
        src="${BASEPATH}/www/lib/bootstrap/bootstrap-3.3.7/js/bootstrap-treeview.js"></script>


<!--jquery插件-->
<script type="text/javascript"
        src="${BASEPATH}/www/lib/common/js/jquery.form.js"></script>
<script type="text/javascript"
        src="${BASEPATH}/www/lib/jquery-cookie/1.4.0/jquery.cookie.min.js"></script>

<!--核心文件-->
<script type="text/javascript"
        src="${BASEPATH}/www/lib/common/js/common.js"></script>


<!--引入颜色插件-->
<script type="text/javascript" src="${BASEPATH}/www/lib/colpick/js/colpick.js"></script>
<!--bootstrap-->
<script type="text/javascript" src="${BASEPATH}/www/lib/bootstrap/bootstrap-3.3.7/js/bootstrap-colorpicker.js"></script>

<!--下拉框-->
<script type="text/javascript"
        src="${BASEPATH}/www/lib/bootstrap-select-1.12.4/js/bootstrap-select.min.js"></script>

<!--时间组件-->
<script type="text/javascript"
        src="${BASEPATH}/www/lib/bootstrap-date/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript"
        src="${BASEPATH}/www/lib/bootstrap-date/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>

<!--验证组件-->
<script type="text/javascript"
        src="${BASEPATH}/www/lib/bootstrap-validator/js/bootstrapValidator.js"></script>
<script type="text/javascript"
        src="${BASEPATH}/www/lib/bootstrap-validator/js/language/zh_CN.js"></script>


<%--
<script type="text/javascript"
        src="${BASEPATH}/www/lib/js/jquery-latest.min.js"></script>--%>
<script>
    var client_width = document.documentElement.clientWidth || document.body.clientWidth;//屏幕宽度
    var clienth_height = document.documentElement.clientHeight || document.body.clientHeight;//屏幕高度
</script>
