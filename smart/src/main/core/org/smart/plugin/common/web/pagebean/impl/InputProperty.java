package org.smart.plugin.common.web.pagebean.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.smart.framework.util.CollectionUtil;
import org.smart.framework.util.MapUtil;
import org.smart.plugin.common.web.pagebean.IInputProperty;

public class InputProperty implements IInputProperty {
	//一个组件对应多个属性
	private Map<String, List<String>> property=new HashMap<>();
	//设置聚焦位置，最后设置聚焦的组件为聚焦位置
	String focus="";
	/**
	 * 此方法用于添加指定组件的属性
	 * 如果组件不存在则先创建（组件表示形式为id）
	 * 方法加锁是为了在并发的时候避免idList的值被篡改
	 * <br>create by on TY
	 * <br>2017年12月11日 下午12:39:05
	 * @param id
	 * @param pro
	 */
	private synchronized void setProperty(String id,String pro){
		List<String> idList=property.get(id);
		if(CollectionUtil.isEmpty(idList)){
			idList=new ArrayList<>();
			property.put(id, idList);
		}
		idList.add(pro);
	}
	@Override
	public void setReadOnly(String id) {
		this.setProperty(id, READONLY);
	}

	@Override
	public void setEnable(String id) {
		this.setProperty(id, ENABLE);
	}

	@Override
	public void setDisabled(String id) {
		this.setProperty(id, DISABLED);
	}

	@Override
	public void setHide(String id) {
		this.setProperty(id, HIDE);
	}

	@Override
	public void setShow(String id) {
		this.setProperty(id, SHOW);
	}

	@Override
	public void setRequed(String id) {
		this.setProperty(id, REQUIRED);
	}

	@Override
	public void setDisRequed(String id) {
		this.setProperty(id, DISREQUIRED);
	}

	@Override
	public void setFocus(String id) {
		this.setProperty(id, FOCUS);
		this.focus=id;//最后设置聚焦的组件为聚焦位置
	}

	@Override
	public void setChecked(String id) {
		this.setProperty(id,CHECKED);
	}


	@Override
	public Map<String, List<String>> getProperty() {
		return this.property;
	}

	@Override
	public List<String> getPropertyById(String id) {
		return this.property.get(id);
	}

}
