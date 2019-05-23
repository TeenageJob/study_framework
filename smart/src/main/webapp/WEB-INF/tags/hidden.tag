<%@ tag import="org.smart.plugin.common.web.pagebean.impl.PageBean" %>
<%@ tag import="org.smart.plugin.common.util.PageUtil" %>
<%@ tag import="org.smart.framework.util.StringUtil" %>
<%@tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@attribute name="id" type="java.lang.String" description="id" required="true" %>
<%@attribute name="value" type="java.lang.String" description="值" %>
<%@attribute name="flag" type="java.lang.String" description="标识" %>
<%
    PageBean pageBean = PageUtil.getPageBean();
    String val = (String) pageBean.getData(id);
%>
<input type="hidden" id="${id}" name="${id}"
        <% if (StringUtil.isNotEmpty(val)) {%>
       value="<%=val%>"
        <%} else {%>
       value="${value}"
        <%}%>
/>