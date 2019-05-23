package org.mvc.shiro;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mvc.ty.common.vo.BusinessUrlVO;
import org.plugin.security.IInterceptUrl;
import org.smart.framework.dao.DatabaseHelper;

public class InterceptUrl implements IInterceptUrl {
	
	@Override
	public Map<String, String> getInterceptURL() {
		Map<String, String> paramMap=new HashMap<>();
		String sql="select url,permission from business_url";
		List<BusinessUrlVO> queryEntityList = DatabaseHelper.queryEntityList(BusinessUrlVO.class, sql);
		for(BusinessUrlVO bu:queryEntityList){
			paramMap.put(bu.getUrl(), bu.getPermission());
		}
		return paramMap;
	}
}
