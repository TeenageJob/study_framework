<%@ tag import="org.smart.framework.util.StringUtil" %>
<%@tag language="java" pageEncoding="UTF-8"
       trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="key" description="按钮名称" type="java.lang.String" %>
<div>
    <div style="text-align: right;margin-right: 50px;">
        <input type="button" class="btn btn-primary" id="btn_reset" onclick="reset()" value="重置"/>
        <input type="button" class="btn btn-primary" id="btn_save"
                <%if (StringUtil.isNotEmpty(key)) {%>
               value="${key}"
                <%} else {%>
               value="提交"
                <%}%>
        />
    </div>

</div>
<script type="text/javascript">
    function reset() {
        $("form")[0].reset();
    }
</script>