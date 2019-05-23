package org.plugin.security.tag;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.tags.PermissionTag;

/**
 * 判断当前用户是否拥有其中所有的权限（逗号分隔，表示“与”的关系）
 * 
 * @author TY
 * @Time 2017年11月10日 下午4:51:10
 * @since 1.0.0
 */
@SuppressWarnings("serial")
public class HasAllPermissionsTag extends PermissionTag {

	private static final String PERMISSION_NAMES_DELIMETER = ",";

	@Override
	protected boolean showTagBody(String permNames) {
		boolean hasAllPermission = false;
		Subject subject = getSubject();
		if (subject != null) {
			if (subject.isPermittedAll(permNames.split(PERMISSION_NAMES_DELIMETER))) {
				hasAllPermission = true;
			}
		}
		return hasAllPermission;
	}
}
