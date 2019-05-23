<%@tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="security" uri="/security" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%

%>

<nav id="header" class="navbar navbar-default"
     style="background: #72d0eb; margin: 0; padding-top: 6px; padding-bottom: 6px;border:none;">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header" style="width: 18%; padding-left: 3%;">
            <img class="navbar-brand" style="background: none!important" src="${BASEPATH }/www/lib/img/B.png">
            <a class="navbar-brand" style="background: none!important">社保系统</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse"
             id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav" role="tablist">
                <c:set var="flag" value="true"/>
                <c:forEach items="${INFO.menu }" var="tl">
                    <c:choose>
                        <c:when test="${flag=='true' }">
                            <li role="presentation" class="active"><c:set var="flag"
                                                                          value="false"/>
                        </c:when>
                        <c:otherwise>
                            <li role="presentation">
                        </c:otherwise>
                    </c:choose>
                    <a role="tab" data-toggle="tab" href="#${tl.value.getTab_id() }"
                       style="font-size: 15px; background-color: #72d0eb !important">
						<span class="${tl.value.getSpan_class()}"
                              style="margin-right: 4px;color:${tl.value.getSpan_style()}"
                              aria-hidden="true"> </span> ${tl.key }
                    </a>
                    </li>
                </c:forEach>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#" style="font-size: 14px;"><span
                        class="glyphicon glyphicon-comment" style="margin-right: 4px;"
                        aria-hidden="true"></span>通知</a></li>
                <li><a href="#" style="font-size: 14px;">帮助提示</a></li>
                <li><a href="#" style="font-size: 16px;">
                    ${INFO.userInformationVO.username } </a>
                <li><a href="${BASEPATH}/logout.do" style="font-size: 16px;"><span
                        class="glyphicon glyphicon-off"
                        style="margin-right: 4px; top: 2.4px" aria-hidden="true"></span>退出</a></li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>
<div id="header_sidebar" class="tab-content" style="padding: 0;margin-left:0;width: 15%;height: auto">
        <jsp:doBody/>
</div>
