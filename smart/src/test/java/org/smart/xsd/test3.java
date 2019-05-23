package org.smart.xsd;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class test3 {

	public static void main(String[] args) {
		System.out.println("jurisdiction.xsd validates against jurisdiction.xml? \n"
				+ validateXMLSchema("src/ty/login/org/mvc/ty/resource/xsd/jurisdiction.xsd", "src/ty/login/org/mvc/ty/jurisdiction/xml/jurisdiction.xml"));
	}

	public static boolean validateXMLSchema(String xsdPath, String xmlPath) {

		try {
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = factory.newSchema(new File(xsdPath));
			Validator validator = schema.newValidator();
			validator.validate(new StreamSource(new File(xmlPath)));
		} catch (IOException | SAXException e) {
			System.out.println("Exception: " + e.getMessage());
			return false;
		}
		return true;
	}
}
