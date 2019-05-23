package org.mvc.ty.common.vo;

import java.util.HashMap;
import java.util.Map;

import org.smart.framework.core.bean.BaseBean;

/**
 * 菜单
 * 
 * @author TY
 * @Time 2018年1月7日 下午3:44:02
 * @since 1.0.0
 */
public class MenuVO extends BaseBean{
	private String role;//角色
	private String label_name;// 菜单名
	private String tab_id;// tab_id,业务功能tab元素的id
	private String span_class;// 菜单名样式
	private String span_style;//样式颜色
	private String warp_id;//外层用于收缩的div的id
	
	private Map<String,BusinessTitleVO> business=new HashMap<>();//标题


	public Map<String, BusinessTitleVO> getBusiness() {
		return business;
	}

	public void setBusiness(Map<String, BusinessTitleVO> business) {
		this.business = business;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getTab_id() {
		return tab_id;
	}

	public void setTab_id(String tab_id) {
		this.tab_id = tab_id;
	}

	public String getSpan_class() {
		return span_class;
	}

	public void setSpan_class(String span_class) {
		this.span_class = span_class;
	}

	public String getWarp_id() {
		return warp_id;
	}

	public void setWarp_id(String warp_id) {
		this.warp_id = warp_id;
	}

	public String getSpan_style() {
		return span_style;
	}

	public void setSpan_style(String span_style) {
		this.span_style = span_style;
	}

	public String getLabel_name() {
		return label_name;
	}

	public void setLabel_name(String label_name) {
		this.label_name = label_name;
	}
}
