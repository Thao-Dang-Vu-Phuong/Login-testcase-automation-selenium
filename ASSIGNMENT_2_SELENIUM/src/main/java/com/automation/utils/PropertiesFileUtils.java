package com.automation.utils;
import java.util.Properties;
import java.io.File;

import java.io.FileReader;

public class PropertiesFileUtils {
public static String getProperty(String key) {
	String result = null;
	File file = new File("./configuration/configs.properties");
	Properties prop = new Properties();
	FileReader filereader;
	try {
		filereader = new FileReader(file);
		prop.load(filereader);
		result = prop.getProperty(key).toString();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("Unable to read property file");
	}
	return result;
}
}
