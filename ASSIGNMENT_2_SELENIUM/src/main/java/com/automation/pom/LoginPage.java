package com.automation.pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.automation.utils.PropertiesFileUtils;

public class LoginPage {
private WebDriverWait wait;
public WebDriver driver;

public LoginPage(WebDriver driver) {
	this.driver = driver;
	wait = new WebDriverWait(driver,Duration.ofSeconds(30));
}

public void clickLogin_SignupButton() throws InterruptedException {
	String buttonLocator = PropertiesFileUtils.getProperty("icon_signin");
	WebElement icon_signin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buttonLocator)));
	Assert.assertEquals(icon_signin.isDisplayed(), true, "Button is not found");
	icon_signin.click();
	Thread.sleep(2000);
}

public void enterEmail(String email) throws InterruptedException {
	String emailLocator = PropertiesFileUtils.getProperty("login_email");
	WebElement inputEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(emailLocator)));
	Assert.assertEquals(inputEmail.isDisplayed(), true, "Textbox is not found");
	inputEmail.sendKeys(email);
	Thread.sleep(2000);
}

public void enterPassword(String password) throws InterruptedException {
	String passwordLocator = PropertiesFileUtils.getProperty("login_pasword");
	WebElement inputPass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(passwordLocator)));
	Assert.assertEquals(inputPass.isDisplayed(), true, "Textbox is not found");
	inputPass.sendKeys(password);
	Thread.sleep(2000);
}

public void clickSigninButton() throws InterruptedException {
	String buttonLocator = PropertiesFileUtils.getProperty("login_signin");
	WebElement signinButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buttonLocator)));
	Assert.assertEquals(signinButton.isDisplayed(), true, "Button is not found");
	signinButton.click();
	Thread.sleep(2000);
}

public void clickLogoutButton() throws InterruptedException {
	String buttonLocator = PropertiesFileUtils.getProperty("icon_signout");
	WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buttonLocator)));
	Assert.assertEquals(logoutButton.isDisplayed(), true, "Button is not found");
	logoutButton.click();
	Thread.sleep(2000);
}
	
}
