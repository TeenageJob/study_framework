package org.mvc.ty.common.vo;

import java.util.ArrayList;
import java.util.List;

import org.smart.framework.core.bean.BaseBean;

public class BusinessTitleVO extends BaseBean {
	/**
	 * create by ty on TY 
	 * <br>2018年1月8日 下午3:41:33
	 */
	private static final long serialVersionUID = 5743203017827501467L;
	private String title_name;// 资源名称
	private String id_flag;//id
	private String collapse;//id
	private String span_class;// 名称样式
	private String span_style;// 名称样式
	private String label_name;//菜单名称
	List<BusinessUrlVO> business_url = new ArrayList<>();// 业务功能url

	public String getId_flag() {
		return id_flag;
	}

	public void setId_flag(String id_flag) {
		this.id_flag = id_flag;
	}

	public String getCollapse() {
		return collapse;
	}

	public void setCollapse(String collapse) {
		this.collapse = collapse;
	}

	public List<BusinessUrlVO> getBusiness_url() {
		return business_url;
	}

	public void setBusiness_url(List<BusinessUrlVO> business_url) {
		this.business_url = business_url;
	}

	public String getLabel_name() {
		return label_name;
	}

	public void setLabel_name(String label_name) {
		this.label_name = label_name;
	}

	public String getSpan_class() {
		return span_class;
	}

	public void setSpan_class(String span_class) {
		this.span_class = span_class;
	}

	public String getSpan_style() {
		return span_style;
	}

	public void setSpan_style(String span_style) {
		this.span_style = span_style;
	}

	public String getTitle_name() {
		return title_name;
	}

	public void setTitle_name(String title_name) {
		this.title_name = title_name;
	}
}
