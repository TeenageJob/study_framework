<%@ tag import="org.smart.plugin.common.util.PageUtil" %>
<%@ tag import="org.smart.plugin.common.web.pagebean.IPageBean" %>
<%@ tag import="org.smart.framework.util.StringUtil" %>
<%@ tag import="java.util.List" %>
<%@ tag import="org.smart.framework.util.ValidataUtil" %>
<%@ tag import="java.util.Map" %>
<%@ tag import="org.smart.framework.util.CollectionUtil" %>
<%@ tag import="org.smart.framework.util.ConstantUtil" %>
<%@ tag import="java.util.HashMap" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag language="java" pageEncoding="UTF-8"
       trimDirectiveWhitespaces="true" %>

<%@attribute name="id" type="java.lang.String" description="列表id" required="true" %>
<%@attribute name="value" type="java.lang.String" description="列表值" %>
<%@attribute name="checkbox" type="java.lang.String" description="是否需要选择框" required="true" %>
<%@attribute name="span" type="java.lang.String" description="占格多少" %>
<%@attribute name="style" type="java.lang.String" description="radio样式" %>
<%@attribute name="cssStyle" type="java.lang.String" description="radio样式" %>
<%@attribute name="onclick" type="java.lang.String" description="点击事件" %>


<%
    IPageBean pageBean = PageUtil.getPageBean();
    Map<String, String> map = new HashMap<>();
    if (CollectionUtil.isNotEmpty(pageBean.getSelectDataById(id))) {
        List<String> list = (List<String>) pageBean.getSelectDataById(id);
        for (String str : list) {
            String[] user = str.split(ConstantUtil.COMMA_S);
            map.put(user[0].trim(), user[1].trim());
        }
    }
%>

<div id="${id}_div" <%if (StringUtil.isNotEmpty(span)) { %>
     span="${span }" <%} else { %> span="1" <%} %>>
    <label>${value}</label>
    <%if (ValidataUtil.isEquals(checkbox, "true")) {%>
    <c:if test="<%=map.size() != 0%>">
        <c:forEach items="<%=map%>" var="sl">
            <div class="radio" style="${style}">
                <label>
                    <input name="${id}" type="radio" onclick="${onclick}" value="${sl.key}">${sl.value }
                </label>
            </div>
        </c:forEach>
    </c:if>
    <%} else {%>
    <c:if test="<%=map.size() != 0%>">
        <div class="list-group" style="overflow-y: auto;padding:0;margin: 0">
            <c:forEach items="<%=map%>" var="sl">
                <a href="javascript:;" onclick="${onclick}" name="${id}" style="border:none!important;${style}"
                   value="${sl.value}"
                   class="list-group-item">${sl.value }</a>
            </c:forEach>
        </div>
    </c:if>
    <%}%>
</div>

<script>
    $('.list-group').css("max-height", clienth_height - 62);
    var span_1 = parseFloat($("#${id}_div").parent().attr("cols"));
    var span_2 = $("#${id}_div").attr("span");
    var span = parseFloat(span_2) / parseFloat(span_1);
    $("#${id}_div").attr("style",
        "margin-top:15px;flex:0 0 " + span * 100 + "%;max-height:100%;${cssStyle}");
</script>