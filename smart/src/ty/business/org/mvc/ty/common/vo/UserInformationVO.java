package org.mvc.ty.common.vo;

import org.smart.framework.core.bean.BaseBean;

/**
 * 用户基本信息
 * @author TY
 * @Time 2018年1月7日 下午3:58:03
 * @since 1.0.0
 */
public class UserInformationVO extends BaseBean{
	private String username;//用户名
	private String email;//邮箱
	private String phone;//电话
	private String operator;//经办人
	private String operatorId;//经办人id
	private String operatorOrganization;//经办机构
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
	public String getOperatorOrganization() {
		return operatorOrganization;
	}
	public void setOperatorOrganization(String operatorOrganization) {
		this.operatorOrganization = operatorOrganization;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
