package org.plugin.security.tag;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.tags.PermissionTag;

/**
 * 判断当前用户是否拥有其中某一种权限（逗号分隔，表示“或”的关系）
 * 
 * @author TY
 * @Time 2017年11月10日 下午4:51:29
 * @since 1.0.0
 */
public class HasAnyPermissionsTag extends PermissionTag {

	/**
	 * create by ty on TY 2017年11月10日 下午2:16:54
	 */
	private static final long serialVersionUID = 2581655154555169349L;
	private static final String PERMISSION_NAMES_DELIMETER = ",";

	@Override
	protected boolean showTagBody(String permissionNames) {
		boolean hasAnyPermission = false;
		Subject subject = getSubject();
		if (subject != null) {
			for (String permissionName : permissionNames.split(PERMISSION_NAMES_DELIMETER)) {
				if (subject.isPermitted(permissionName.trim())) {
					hasAnyPermission = true;
					break;
				}
			}
		}
		return hasAnyPermission;
	}
}
