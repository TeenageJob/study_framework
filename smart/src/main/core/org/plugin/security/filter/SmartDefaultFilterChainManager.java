package org.plugin.security.filter;

import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.NamedFilterList;
import org.smart.framework.util.ConstantUtil;

import javax.servlet.Filter;

public class SmartDefaultFilterChainManager extends DefaultFilterChainManager {

	
	@Override
	public void addToChain(String chainName, String filterNames, String chainSpecificFilterConfig) {
		if (!StringUtils.hasText(chainName)) {
			throw new IllegalArgumentException("chainName cannot be null or empty.");
		}
		String[] filters = filterNames.split(ConstantUtil.COMMA_S);
		for (String filterName : filters) {
			Filter filter = getFilter(filterName);
			if (filter == null) {
				throw new IllegalArgumentException("There is no filter with name '" + filterName
						+ "' to apply to chain [" + chainName + "] in the pool of available Filters.  Ensure a "
						+ "filter with that name/path has first been registered with the addFilter method(s).");
			}

			applyChainConfig(chainName, filter, chainSpecificFilterConfig);

			NamedFilterList chain = ensureChain(chainName);
			chain.add(filter);
		}
	}

}
