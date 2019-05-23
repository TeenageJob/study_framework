package org.smart.framework.util;

public class UrlPathUtil {

	public static String getWEB_INFUrl(){
		String url=System.getProperty("catalina.home")+"/webapps/smart/WEB-INF/";
		url.replace(ConstantUtil.USPRIT_S, ConstantUtil.SPRIT_S);
		return url;
	}

	public static String getIDEAUrl(){
		String path = UrlPathUtil.class.getClassLoader().getResource("shiro.xml").getPath();
		System.out.println(path);
		path.replace(ConstantUtil.USPRIT_S, ConstantUtil.SPRIT_S);
		return path;
	}
}
