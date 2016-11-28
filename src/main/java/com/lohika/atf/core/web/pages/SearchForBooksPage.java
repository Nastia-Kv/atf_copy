package com.lohika.atf.core.web.pages;
import static com.lohika.atf.core.Configuration.getConfig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.lohika.atf.core.Configuration;
import com.lohika.atf.core.Environment;
//import com.lohika.atf.core.web.WebComponent;
import com.lohika.atf.core.web.WebPage;
import com.lohika.atf.core.web.elements.Button;
import com.lohika.atf.core.web.elements.Link;
import com.lohika.atf.core.web.elements.Text;
//import com.lohika.atf.core.web.elements.Button;
//import com.lohika.atf.core.web.elements.Link;
import com.lohika.atf.core.web.elements.TextInput;

public class SearchForBooksPage extends WebPage<SearchForBooksPage> {
	
	private static final Configuration CONFIG = getConfig();
	private static final Environment ENVIRONMENT = CONFIG.getEnvironmentSettings();
	private static final String PAGE_URL = ENVIRONMENT.scheme + "://" + ENVIRONMENT.host;
	
	public SearchForBooksPage(WebDriver driver) {
		super(driver);
		
	}

	@Override
	public SearchForBooksPage load() {
		driver.get(PAGE_URL);
		return this;
	}

	@Override
	public boolean isAvailable() {
		
		return getSearchForBooksButton().isAvailable();
				
	}
	
	public SearchForBooksPage fillInSearchField(String bookName) {
		getSearchAndAddBooksInput().inputText(bookName);		
		return this;
	}
	
	public SearchForBooksPage searchButtonMethod(){
		getSearchForBooksButton().click();
		return this;
		
	}
	
	
//	public SearchForBooksPage searchForBookError() {
//		getPageErrorMessage().getText();
//		return this.waitUntilAvailable();
//		
//	}
	
	public String getPageErrorMessage(){
		return new Text(driver, By.xpath(".//*[@id='rightCol']/div[7]")).getText();
	}
	
	public TextInput getSearchAndAddBooksInput(){
		 return new TextInput(driver, By.xpath(".//input[@id='sitesearch_field']"));
		
		}
	
	private Button getSearchForBooksButton(){
		return new Button(driver, By.cssSelector("img[alt='search']"));
	}
	
	public SignedOutPage signout(){
		getSignoutLink().click();
		return new SignedOutPage(driver).waitUntilAvailable(); 
		
	}

	private Link getSignoutLink() {
		return new Link(driver, By.xpath("html/body/div[1]/div[1]/div/div/header/ul/li[4]/div/div/ul/li[12]/a"));
	}
}
