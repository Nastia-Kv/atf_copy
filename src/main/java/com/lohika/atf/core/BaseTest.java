package com.lohika.atf.core;

import static com.lohika.atf.core.DriverMaster.getDriver;
import static com.lohika.atf.core.Configuration.setGlobalEnvironment;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.*;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.opera.OperaDriver;
//import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.AfterSuite;

public abstract class BaseTest {
	
	protected WebDriver driver;
//  ChromeDriverManager.setup(); 
//	InternetExplorerDriverManager.setup(); 
//	OperaDriverManager.setup(); 

//	@BeforeSuite(alwaysRun = true)
//	@Parameters({"browser"})
//	public void setUp(@Optional("firefox") String browser){
//		driver = getDriver(browser);
		
	@BeforeSuite(alwaysRun = true)
	@Parameters({"browser", "environment"})
	public void setUp(@Optional("firefox") String browser, @Optional("local") String environment){
		driver = getDriver(browser);
		System.out.println("Yey!");
		setGlobalEnvironment(environment);
}

		

//	@AfterSuite(alwaysRun = true)
//	public void tearDown(){
//		driver.quit();
	}
//}
