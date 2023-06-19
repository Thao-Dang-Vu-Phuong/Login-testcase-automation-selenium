package com.automation.testcase;



import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

import com.automation.pom.LoginPage;
import com.automation.base.DriverInstance;
import com.automation.utils.CaptureScreenshot;
import com.automation.utils.PropertiesFileUtils;

public class TC_LoginTest extends DriverInstance{

	@Test(dataProvider = "Excel")
	public void TC01_LoginFirstAccount(String email, String password) throws InterruptedException {
		
		driver.get(PropertiesFileUtils.getProperty("baseURL"));
		
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickLogin_SignupButton();
		loginPage.enterEmail(email);
		loginPage.enterPassword(password);
		loginPage.clickSigninButton();
		loginPage.clickLogoutButton();
	}
	
	@DataProvider(name = "Excel")
	public Object[][] testDataGenerator() throws InvalidFormatException, IOException{
		File excel = new File("./data/assignment2_data_test.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(excel);
		XSSFSheet sheet = workbook.getSheet("Login");
		int numberOfRows = sheet.getPhysicalNumberOfRows();
		Object[][] testData = new Object[numberOfRows][2];
		for (int i=0; i<numberOfRows; i++) {
			XSSFRow row = sheet.getRow(i);
			XSSFCell email = row.getCell(0);
			XSSFCell password = row.getCell(1);
			testData[i][0] = email.getStringCellValue();
			testData[i][1] = password.getStringCellValue();
			workbook.close();
		}
		return testData;
	}
	
	@AfterMethod
	public void takeScreenshot(ITestResult result) {
		if(ITestResult.FAILURE == result.getStatus()) {
			try {
				String email = (String) result.getParameters()[0];
				int index = email.indexOf("@");
				String accountName = email.substring(0, index);
				if(result.getParameters()[0] == null)accountName = "blank";
				CaptureScreenshot.takeScreenshot(driver, accountName);
				CaptureScreenshot.attachScreenshot();
			}
			catch (Exception e) {
				System.out.println("Lỗi xảy ra khi screenshot " + e.getMessage());
			}
		}
	}
}
