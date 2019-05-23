package org.smart.plugin.template;

import java.util.HashMap;
import java.util.Map;

import org.plugin.template.TemplateEngine;
import org.plugin.template.impl.VelocityTemplateEngine;

public class test {
public static void main(String[] args) {
	TemplateEngine te=new VelocityTemplateEngine();
	Map<String, Object> ctx = new HashMap<>();
	
	ctx.put("classNameLowCase", "teacher");
	ctx.put("classNameUpCase", "Teacher");
	String[][] attrs = {
			{"Integer","id"},
			{"String","name"},
			{"String","serializeNo"},
			{"String","titile"},
			{"String","subject"}
	};
	ctx.put("attrs", attrs);
	te.mergeTemplateFile("ActionTemplate.vm", ctx, test.class.getClassLoader().getResource("").getFile() + "../../src/main/core");
}
}
