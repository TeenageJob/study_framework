package org.smart.plugin.common.web.pagebean.vo;

import java.util.ArrayList;
import java.util.List;

public class TreeVO {
    private String id;//节点id
    private String icon=null;//图标
    private String iconColor=null;//The color used on a given node's icon.
    private String image=null;//The image displayed on a given node, overrides the icon.
    private String color=null;//The foreground color used on a given node, overrides global color option.
    private String backColor=null;//The background color used on a given node, overrides global color option.
    private String text;//节点名称
    private String href=null;//节点值
    private List<TreeVO> nodes=new ArrayList<>();//子节点


    public void addChrildren(TreeVO treeVO){
        nodes.add(treeVO);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<TreeVO> getNodes() {
        return nodes;
    }

    public void setNodes(List<TreeVO> nodes) {
        this.nodes = nodes;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIconColor() {
        return iconColor;
    }

    public void setIconColor(String iconColor) {
        this.iconColor = iconColor;
    }

    public String getBackColor() {
        return backColor;
    }

    public void setBackColor(String backColor) {
        this.backColor = backColor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
