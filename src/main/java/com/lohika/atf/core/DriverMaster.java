package com.lohika.atf.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverMaster {
	private DriverMaster(){};
	
	public static WebDriver getDriver(String driverKey){
		BrowserType browser = BrowserType.get(driverKey);
		
		WebDriver driver;
		switch (browser) {
		case FIREFOX:
			driver = new FirefoxDriver();
			break;
		case CHROME:
			driver = new ChromeDriver();
			break;
		default:
			driver = new FirefoxDriver();
			
		}
		return driver;
	}
}
//fantom