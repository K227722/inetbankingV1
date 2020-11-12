package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws Exception {
		
		
		driver.get(baseURL);
		logger.info("URL Opened");

		LoginPage lp = new LoginPage(driver);
		
		
		lp.setUserName(username);
		logger.info("Entered Username");
		
		lp.setPassword(password);
		logger.info("Entered Password");
		
		lp.clickSubmit();
		
		Thread.sleep(3000);

		// Welcome To Manager's Page of Guru99 Bank
		if (driver.getTitle().equalsIgnoreCase("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
		} else {
			
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login Failed");
		}
	}
}
