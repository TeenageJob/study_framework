<%@tag language="java" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- @doc --%>
<%@attribute name="id" type="java.lang.String"
	description="容器组件在页面上的唯一id"%>
<%@attribute name="value" type="java.lang.String"
	description="容器组件在页面上的唯一id"%>
<%@attribute name="type" type="java.lang.String"
	description="容器组件在页面上的唯一id"%>
<%-- @doc --%>

<div class="input-group">
	<span class="input-group-addon"> 
		<c:choose>
			<c:when test="${value.length != 0}">
	  			${value}
	  		</c:when>
			<c:when test="${type !=''}">
					<input type="${type}">
			</c:when>
		</c:choose>
	</span> 
	<input type="text" id="${id }" class="form-control"
		placeholder="Username" aria-describedby="basic-addon1" />
</div>