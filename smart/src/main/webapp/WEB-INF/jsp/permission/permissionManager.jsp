<%--
  Created by IntelliJ IDEA.
  User: tianyuan
  Date: 2018/2/27
  Time: 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ty" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ty:panel id="panl_1" cols="3">
    <ty:box id="box_1">
        <ty:list id="li_user" checkbox="true" style="margin-left:150px;" onclick="getUserPermission(this)"/>
    </ty:box>
    <ty:box id="box_2" span="1" cssStyle="overflow-y:auto">
        <ty:button id="btn_save" name="保存" onClick="save()"/>
        <ty:tree id="tr_menu" checkbox="true" showCheckbox="true"/>
    </ty:box>
</ty:panel>
</body>
</html>
<script>
    $(function () {
        $("#box_2").height(getContextHeight());
    });
    var userNode = [];//记录非重复节点
    var role;
    function getUserPermission(radio) {
        $('#tr_menu').treeview('uncheckAll', { silent: true });
        var info = {
            role: $(radio).val()
        }
        role=info.role;
        Base.submitA("/permission/getRolePermissionPage.do", function (data) {
            //var json = JSON.parse(data);
            datas = data.data;
            var nodeId = [];//记录要被选中的节点
            var nodesId=[];//记录非重复节点
            $("#tr_menu").find("ul li").each(function () {
                var text = $(this).html();
                text = text.substring(text.lastIndexOf(">") + 1);
                for (var length = datas.length, i = 0; i < length; i++) {
                    if (datas[i].url_name == text) {
                        var node_id = $(this).attr("data-nodeid");
                        if (isInArray(nodesId, node_id)) {
                            break;
                        }else{
                            var nodes=$('#tr_menu').treeview('findNodes', [node_id, 'nodeId']);
                            nodeId.push(nodes[nodes.length-1]);
                            var parentNode=$('#tr_menu').treeview('getParents', nodes[nodes.length-1]);
                            if (!isInArray(nodesId, parentNode[0].nodeId)) {
                                nodesId.push(parentNode[0].nodeId);
                                nodeId.push(parentNode[0]);
                                parentNode=$('#tr_menu').treeview('getParents', parentNode[0]);
                                if (!isInArray(nodesId, parentNode[0].nodeId)) {
                                    nodesId.push(parentNode[0].nodeId);
                                    nodeId.push(parentNode[0]);
                                }
                            }
                            nodesId.push(node_id);
                        }
                        break;
                    }
                }
            });
            userNode=nodesId;
            $('#tr_menu').treeview('checkNode', [nodeId, {silent: true}]);
        }, null, info);
    }

    function save(){
        var add=[];
        var del=[];
        //所有选中的节点
        var nodes=$('#tr_menu').treeview('getChecked');
        for(var id in nodes){
            if (!isInArray(userNode, nodes[id].nodeId)) {
                add.push(nodes[id].text);
            }
        }
        //所有未选中的节点
        nodes=$('#tr_menu').treeview('getUnchecked');
        for(var id in nodes){
            if (isInArray(userNode, nodes[id].nodeId)) {
                del.push(nodes[id].text);
            }
        }
        var info={
            add:JSON.stringify(add),
            del:JSON.stringify(del),
            role:role
        }
        Base.submitA("/permission/updateRolePage.do",function(data){
            Base.alert("设置成功");
        },null,info);
    }
</script>
