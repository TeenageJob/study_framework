<%@ page import="org.smart.framework.util.StringUtil" %><%--
  Created by IntelliJ IDEA.
  User: tianyuan
  Date: 2018/2/6
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        .box_1 {
            overflow-y: auto;
            overflow-x: hidden;
        }

        .box_2 {
            padding-left: 50px;
            margin-top: 20px;
        }

        .tree_1 {
            padding-left: 15%;
        }
    </style>
    <%@ taglib prefix="ty" tagdir="/WEB-INF/tags" %>
</head>
<body>

<ty:panel id="panl_1" cols="3">
    <ty:box id="box_1" cssStyle="overflow-y:auto">
        <ty:tree id="tree_1" cssClass="tree_1" showIcon="true" addNodeName="addNode" button="true" delNodeName="delNode" edtNodeName="edtNode"
                 nodeSelected="seleced"/>
    </ty:box>
    <ty:box id="box_2" span="2" cssClass="box_2">
        <ty:text id="menu" name="菜单名称"/>
        <ty:text id="title" name="标题"/>
        <ty:text id="url_name" name="页面名称"/>
        <ty:text id="url" name="路径"/>
        <ty:text id="flag" name="选择图标" icon="true"/>
        <ty:text id="color" name="图标颜色" colorpicker="true" value="#6D2781"/>
        <ty:button id="btn_add" name="保存" onClick="saveNode()" cssStyle="padding-left:100px"/>
    </ty:box>
</ty:panel>

<script type="text/javascript">
    var thisNode;
    var nodeIdLength = 0;
    var flag = 0;
    $(function () {
        $("#box_1").height(getContextHeight());
        $("#box_2").hide();
    });

    function addNode(event,node) {
        flag = 1;
        seleced(event, node);
        $("#btn_add").show();
        switch (nodeIdLength) {
            case 5:
                Base.setEnabled("title");
                Base.clearData("title");
                break;
            case 7:
                Base.setEnabled("url_name", "url");
                Base.clearData("url_name", "url");
                break;
        }
    }

    function delNode(event,node) {
        thisNode = node;
        var nodeText = [];
        getText(thisNode, nodeText);
        var info = {
            node: JSON.stringify(nodeText)
        };
        Base.submitA("/menuManager/delNode.do", function (data) {
            Base.alert("成功！");
        }, null, info);
    }
    function edtNode(event,node){
        seleced(event, node);
        $("#btn_add").show();
        flag=3;
    }

    function seleced(event, node) {
        $("#btn_add").hide();
        $("#box_2").show();
        thisNode = node;
        var id = nodeIdLength = node.nodeId.toString().length;
        Base.setEnabled("title", "url_name", "url");
        Base.clearData("menu", "title", "url_name", "url");
        switch (id) {
            case 3:
                Base.setDisabled("title", "url_name", "url","menu","flag","color");
                break;
            case 5:
                Base.setData("menu", node.text);
                Base.setEnabled("menu");
                Base.setDisabled("title", "url_name", "url");
                break;
            case 7:
                var nodes = $("#tree_1").treeview("findNodes", ["^" + node.nodeId.substring(0, 5) + "$", 'nodeId'])[0];
                Base.setData("menu", nodes.text);
                Base.setData("title", node.text);
                Base.setDisabled("url_name", "url","menu");
                break;
            case 9:
                Base.setData("menu", $("#tree_1").treeview("findNodes", ["^" + node.nodeId.substring(0, 5) + "$", 'nodeId'])[0].text);
                Base.setData("title", $("#tree_1").treeview("findNodes", ["^" + node.nodeId.substring(0, 7) + "$", 'nodeId'])[0].text);
                Base.setData("url_name", node.text);
                Base.setData("url", node.href);
                Base.setDisabled("menu","title");
        }
    }


    function saveNode() {
        var info = {
            menu: Base.getVal("menu") + "",
            title: $("#title").val() + "",
            url_name: $("#url_name").val() + "",
            url: $("#url").val() + "",
            span_class: "glyphicon " + $("#flag").val() + "",
            color: $("#color").val() + ""
        };
        if (flag == 1) {
            Base.submitA("/menuManager/addNode.do", function (data) {
                $("#tree_1").treeview("addChrildrenNode", [thisNode, {silent: true}])
                var node = $('#tree_1').treeview('findNodes', ['未命名', 'text']);
                var newNode = node[0];
                newNode.text = info.url_name == "" ? info.title == "" ? info.menu : info.title : info.url_name;
                newNode.icon = info.span_class;
                newNode.iconColor = info.color;
                $("#tree_1").treeview("updateNode", [node[0], newNode, {silent: true}])
                Base.alert("info", "添加成功！");
                $("#btn_add").hide();
            }, null, info);

        } else if (flag == 3) {
            info.text=thisNode.text;
            Base.submitA("/menuManager/edtNode.do", function (data) {
               Base.alert("成功！");
                var newNode=thisNode;
                newNode.icon=info.span_class;
                newNode.iconColor=info.color;
                switch (nodeIdLength){
                    case 5:newNode.text=info.menu;break;
                    case 7:newNode.text=info.title;break;
                    case 9:newNode.text=info.url_name;newNode.href=info.url;break;
                }
                $("#tree_1").treeview("updateNode", [thisNode, newNode, {silent: true}])
            }, null, info);
        }
    }

    /**
     * 递归获取父节点值
     * @param node
     * @param nodeText
     */
    function getText(node, nodeText) {
        if (!node) {
            return;
        }
        else {
            nodeText.push(node.text);
            getText($("#tree_1").treeview("getParents", node)[0], nodeText);
        }
    }
</script>
</body>
</html>
<jsp:include page="../common/popover.jsp"/>