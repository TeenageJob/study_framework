package org.plugin.security.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

public class SmartAuthcFilter extends FormAuthenticationFilter {

	/**
	 * 死循环
	 */
	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {
		boolean flag = true;  
        String successUrl = this.getSuccessUrl();  
        if("".equals(successUrl)){  
            successUrl = DEFAULT_SUCCESS_URL;  
        }  
        WebUtils.issueRedirect(request, response, successUrl, null, flag);  
        //we handled the success redirect directly, prevent the chain from continuing:  
        return false;  
	}
	
	

}
