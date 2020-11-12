package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {

		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	public String getApplicationURL() {
		String url = pro.getProperty("baseURL");
		return url;
	}

	public String getusername() {
		String uname = pro.getProperty("username");
		return uname;
	}

	public String getpassword() {
		String upassword = pro.getProperty("password");
		return upassword;
	}

	public String getchromePath() {
		String chromePath = pro.getProperty("chromepath");
		return chromePath;
	}

	public String getfirefoxpath() {
		String firefox = pro.getProperty("firefox");
		return firefox;
	}
	
	public String clicklogout() {
		String log=pro.getProperty("logout");
		return log;
	}
}
