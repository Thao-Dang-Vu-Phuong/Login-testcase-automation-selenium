package com.automation.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
public class CaptureScreenshot {
	static String imageName = "";
public static void takeScreenshot (WebDriver driver, String email) {
	try {
	imageName = email + ".png";
	TakesScreenshot screenshot = (TakesScreenshot)driver;
	File source = screenshot.getScreenshotAs(OutputType.FILE);
	File destiny = new File("./Screenshots/" + imageName);
FileHandler.copy(source, destiny);
		
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("Unable to take screenshot");
		e.printStackTrace();
	}
	
}

public static void attachScreenshot () {
	try {
	System.setProperty("org.uncommons.reportng.escape-output", "false");
	File destiny = new File("./Screenshots/" + imageName);
	Reporter.log("<br> <a title= \"Screenshots\" href=\"" + destiny.getAbsolutePath() + "\">");
	Reporter.log("<img alt='" + destiny.getName() +"' src='" + destiny + "' height='240' width='418'/></a><br>");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("Unable to take screenshot");
		e.printStackTrace();
	}
}


}
