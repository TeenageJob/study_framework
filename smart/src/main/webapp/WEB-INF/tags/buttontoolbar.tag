<%@tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%--@doc--%>
<%@attribute description='容器组件在页面上的唯一id' name='id' type='java.lang.String' %>
<%@attribute description='是否显示toolbar' name='display' type='java.lang.String' %>
<%@attribute description='cssClass' name='cssClass' type='java.lang.String' %>
<%@tag description='工具栏' display-name='toolbar' %>
<%@attribute description='是否需要权限控制' name='fieldsAuthorization' type='java.lang.String' %>
<%--@doc--%>

<div class="btn-toolbar" role="toolbar">
	<jsp:doBody />
</div>