package org.smart.java;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mvc.ty.common.vo.MenuVO;
import org.smart.framework.util.MapUtil;
import org.smart.framework.util.StringUtil;

public class NewMapTest {

	public static void main(String[] args) {
		Map<String, List<MenuVO>> map = new HashMap<>();
		MenuVO s=new MenuVO();
		if(StringUtil.isEmpty(s.getSpan_class())){
			System.out.println("Null");
		}else{
			System.out.println("not null");
		}
		if (MapUtil.isEmpty(map)) {
			System.out.println("null");
		} else {
			System.out.println("not null");
		}

	}
}
