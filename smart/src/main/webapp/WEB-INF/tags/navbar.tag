<%@tag language="java" pageEncoding="UTF-8"
       trimDirectiveWhitespaces="true" %>

<%-- @doc --%>
<%@attribute name="id" type="java.lang.String"
             description="容器组件在页面上的唯一id" %>
<%@attribute name="value" type="java.lang.String"
             description="容器组件在页面上的唯一id" %>
<%-- @doc --%>


<div class="form-group div-css" style="margin-left: 100px">
    <label class="label-css" style="color:#35b558;float:left;line-height: 34px;vertical-align: middle">查询 ：</label>
    <input id="queryBaseInfo" type="text" class="form-control" style="width: 40%;float: left;margin-right: 20px"
           placeholder="Search...输入用户名或单位名查询">
    <button type="button" class="btn btn-default btn-lg" onclick="queryNavInfo()">
        <span class="glyphicon glyphicon-search" style="color:#5bc0de" aria-hidden="true"></span>
    </button>
</div>
<script type="text/javascript">
    $(".btn-lg").css("font-size", "13px");

    function queryNavInfo(data) {
        Base.submitA("publicQuery/queryBaseInfo.do", function (data) {
            var json = JSON.parse(data.data);
            for (var key in json) {
                Base.setData(key, json[key]);
            }
        }, null, {value: $("#queryBaseInfo").val()})
    }
</script>

