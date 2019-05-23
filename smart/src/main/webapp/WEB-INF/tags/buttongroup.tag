<%@tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%--@doc--%>
<%@tag
	description='buttonGroup,按钮组合,只能放button,submit,selectButton,如果button或者submit，要与selectButton混用，则必须外层套上buttonGroup组件'
	display-name="buttonGroup"%>
<%@attribute
	description='center/left/right，默认center。设置容器内button的对齐方式，例如:align="center"'
	name='align' type='java.lang.String'%>
<%@attribute description='设置组件id，页面唯一' name='id' type='java.lang.String'%>
<%@attribute description='给该组件添加自定义样式，如:cssStyle="padding-top:10px"'
	name='cssStyle' type='java.lang.String'%>
<%@attribute description='给该组件添加自定义样式class，如:cssClass="no-padding"'
	name='cssClass' type='java.lang.String'%>
<%@attribute
	description='数字，当该容器被父容器作为column方式布局的时候，设置span表明当前组件需要占用多少列'
	name='span' type='java.lang.String'%>
<%@attribute
	description='设置layout为column布局的时候自定义占用宽度百分比，可设置值为0-1之间的小数，如:0.1'
	name='columnWidth' type='java.lang.String'%>
<%@attribute description='是否需要权限控制' name='fieldsAuthorization'
	type='java.lang.String'%>
<%--@doc--%>

<div class="btn-group" role="group">
	<jsp:doBody />
</div>