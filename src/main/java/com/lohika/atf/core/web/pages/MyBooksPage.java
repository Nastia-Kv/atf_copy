package com.lohika.atf.core.web.pages;
import static com.lohika.atf.core.Configuration.getConfig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.lohika.atf.core.Configuration;
import com.lohika.atf.core.Environment;
import com.lohika.atf.core.web.WebPage;
//import com.lohika.atf.core.web.elements.Button;
import com.lohika.atf.core.web.elements.Link;

public class MyBooksPage extends WebPage<MyBooksPage> {
	
	private static final Configuration CONFIG = getConfig();
	private static final Environment ENVIRONMENT = CONFIG.getEnvironmentSettings();
	private static final String PAGE_URL = ENVIRONMENT.scheme + "://" + ENVIRONMENT.host;
	
	public MyBooksPage(WebDriver driver) {
		super(driver);
		
	}

	@Override
	public MyBooksPage load() {
		driver.get(PAGE_URL);
		return this;
	}

	@Override
	public boolean isAvailable() {
		
		return getMyBooksLink().isAvailable();
				
	}
	
	public SearchForBooksPage goToSeacrhForBooksPage(){
		getMyBooksLink().click();
		return new SearchForBooksPage(driver).waitUntilAvailable();
	}
	private Link getMyBooksLink(){
		return new Link(driver, By.xpath(".//a[@href='/review/list/56456743']"));
	}


}
