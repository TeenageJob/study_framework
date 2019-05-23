<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ty" tagdir="/WEB-INF/tags" %>
<ty:panel id="panl_1" value="清除菜单缓存">
    <ty:box id="box_1">
        <ty:button id="btn_clear_cache" name="刷新缓存" onClick="clearCache()"/>
    </ty:box>
</ty:panel>

<script>
    function clearCache() {
        Base.submitA("/cache/clearMenuCache.do", function () {
            Base.alert("info", "更新成功！");
        })
    }
</script>
