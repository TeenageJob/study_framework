package org.mvc.ty.common.common_s.service.impl;

import java.util.Map;

import org.mvc.ty.common.common_s.service.CommonFQService;
import org.mvc.ty.common.common_s.service.CommonSService;
import org.mvc.ty.common.vo.MenusVO;
import org.smart.framework.ioc.annotation.Inject;
import org.smart.framework.tx.annotation.Service;

@Service
public class CommonFQServiceImpl implements CommonFQService {

	@Inject
	private CommonSService commonSService;
	
	@Override
	public boolean login(Map<String,String> paramMap) {
		return commonSService.login(paramMap);
	}

	@Override
	public boolean loginOut() {
		return commonSService.loginOut();
	}

	@Override
	public MenusVO getLoginInfo() {
		return commonSService.getLoginInfo();
	}

}
