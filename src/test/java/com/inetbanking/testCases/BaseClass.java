package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {

	ReadConfig ReadConfig = new ReadConfig();

	public String baseURL = ReadConfig.getApplicationURL();
	public String username = ReadConfig.getusername();
	public String password = ReadConfig.getpassword();
	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {

		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("C://Users//dell//eclipse-workspace//inetBankingV1//log4j.properties");

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", ReadConfig.getchromePath());
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.firefox.driver", ReadConfig.getfirefoxpath());
			driver = new FirefoxDriver();
		}

		else {
			System.out.println("open IE browser");
		}

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(baseURL);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public static void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileHandler.copy(source, target);
		System.out.println("Screenshot Captured");

	}
}
