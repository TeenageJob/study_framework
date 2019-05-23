<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="ty" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<ty:panel id="main">
    <ty:panel id="panl_1" value="所有模型">
        <table width="80%" class="table table-bordered table-hover table-condensed">
            <thead>
            <tr>
                <th>模型ID</th>
                <th>模型名称</th>
                <th>模型KEY</th>
                <th>版本号</th>
                <th>创建时间</th>
                <th>最后更新时间</th>
                <th>操作</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${modelList }" var="model">
                <tr>
                    <td>${model.id }</td>
                    <td>${model.name }</td>
                    <td>${model.key }</td>
                    <td>${model.version }</td>
                    <td>${model.createTime }</td>
                    <td>${model.lastUpdateTime}</td>
                    <td>
                        <ty:button name="启动" id="startModel" cssStyle="text-align:center"
                                   onClick="delRosurce('/activitis/deployProcess.do?deploymentId=${model.id }')"></ty:button>
                    </td>
                    <td>
                        <ty:button name="删除" id="startModel" cssStyle="text-align:center"
                                   onClick="delRosurce('/activitis/deleteModel.do?deploymentId=${model.id }')"></ty:button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </ty:panel>
    <ty:panel id="panl_2" value="所有部署的流程">
        <table width="80%" class="table table-bordered table-hover table-condensed">
            <thead>
            <tr>
                <th>流程定义ID</th>
                <th>部署ID</th>
                <th>流程定义名称</th>
                <th>流程定义KEY</th>
                <th>版本号</th>
                <th>XML资源名称</th>
                <th>图片资源名称</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${processDefinitionList }" var="pd">
                <tr>
                    <td>${pd.id }</td>
                    <td>${pd.deploymentId }</td>
                    <td>${pd.name }</td>
                    <td>${pd.key }</td>
                    <td>${pd.version }</td>
                    <td><a target="_blank"
                           href='/smart/activitis/readResource.do?pdid=${pd.id }&resourceName=${pd.resourceName }'>${pd.resourceName }</a>
                    </td>
                    <td><a target="_blank"
                           href='/smart/activitis/readResource.do?pdid=${pd.id }&resourceName=${pd.diagramResourceName }'>${pd.diagramResourceName }</a>
                    </td>
                    <td>
                        <ty:button name="删除" id="delRosource" cssStyle="text-align:center"
                                   onClick="delRosurce('/activitis/deleteProcess.do?deploymentId=${pd.deploymentId }')"></ty:button>
                            <%--<a class="btn" href='${ctx }/chapter6/getform/start/${pd.id }'><i class="icon-play"></i>启动</a>--%>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </ty:panel>
</ty:panel>
<script>
    function delRosurce(url) {
        Base.submitA(url,function () {
            Base.alert("成功");
            clickUrl("模型管理");
        });
    }
</script>