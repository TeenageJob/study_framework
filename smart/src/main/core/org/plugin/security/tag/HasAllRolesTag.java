package org.plugin.security.tag;

import java.util.Arrays;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.tags.RoleTag;

/**
 * 判断当前用户是否拥有其中所有的角色（逗号分隔，表示“与”的关系）
 * 
 * @author TY
 * @Time 2017年11月10日 下午4:51:19
 * @since 1.0.0
 */
public class HasAllRolesTag extends RoleTag {

	/**
	 * create by ty on TY 2017年11月10日 下午2:16:49
	 */
	private static final long serialVersionUID = -5624910664205663936L;
	private static final String ROLE_NAMES_DELIMETER = ",";

	@Override
	protected boolean showTagBody(String roleNames) {
		boolean hasAllRole = false;
		Subject subject = getSubject();
		if (subject != null) {
			if (subject.hasAllRoles(Arrays.asList(roleNames.split(ROLE_NAMES_DELIMETER)))) {
				hasAllRole = true;
			}
		}
		return hasAllRole;
	}
}
