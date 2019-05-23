package org.mvc.ty.common.common_c.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.mvc.ty.common.common_c.service.CommonService;
import org.mvc.ty.common.common_s.service.CommonFBService;
import org.mvc.ty.common.common_s.service.CommonFQService;
import org.mvc.ty.common.vo.MenusVO;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.mvc.bean.Params;
import org.smart.framework.tx.annotation.Service;

@Service
public class CommonServiceImpl implements CommonService {

	@Inject
	private CommonFBService commonFBService;
	@Inject
	private CommonFQService commonFQService;

	@Override
	public void login(Params params) {
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("account", params.getString("account"));
		paramMap.put("password", params.getString("password"));
		paramMap.put("isRememberMe", params.getString("isRememberMe"));
		commonFQService.login(paramMap);
	}

	@Override
	public void loginOut() {
		commonFQService.loginOut();
	}

	@Override
	public boolean register(Params params) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("username", params.getString("account"));
		paramMap.put("email", params.getString("email"));
		paramMap.put("password", params.getString("password"));
		return commonFBService.register(paramMap);
	}

	@Override
	public MenusVO getLoginInfo() {
		return commonFQService.getLoginInfo();
	}

}
