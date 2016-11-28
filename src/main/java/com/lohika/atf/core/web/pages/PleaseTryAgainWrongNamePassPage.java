package com.lohika.atf.core.web.pages;

//import javax.xml.crypto.dsig.SignedInfo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//import com.lohika.atf.core.web.WebComponent;
//import com.lohika.atf.core.web.WebComponent;
import com.lohika.atf.core.web.WebPage;
import com.lohika.atf.core.web.elements.Button;
import com.lohika.atf.core.web.elements.Link;
//import com.lohika.atf.core.web.elements.TextInput;
import com.lohika.atf.core.web.elements.TextInput;

public class PleaseTryAgainWrongNamePassPage extends WebPage<PleaseTryAgainWrongNamePassPage> {
	
	private static final String PAGE_URL = "https://www.goodreads.com";
	public PleaseTryAgainWrongNamePassPage(WebDriver driver) {
		super(driver);
		
	}

	@Override
	public PleaseTryAgainWrongNamePassPage load() {
		driver.get(PAGE_URL);
		return this;
	}
	
	@Override
	public boolean isAvailable(){
		return getWithFacebookButton().isAvailable();
	}
	
	public PleaseTryAgainWrongNamePassPage loginAsWrong(String username, String password) {
		getUserNameInputW().inputText(username);
		getPasswordInputW().inputText(password);
		getLoginButtonW().click();
		return new PleaseTryAgainWrongNamePassPage(driver).waitUntilAvailable();
	}
	private TextInput getUserNameInputW(){
		return new TextInput(driver, By.xpath(".//*[@id='user_email']"));
	}
	
	private TextInput getPasswordInputW(){
		
		return new TextInput(driver, By.xpath(".//*[@id='user_password']"));
	}
	
	private Button getLoginButtonW(){
		return new Button(driver, By.xpath(".//*[@id='emailForm']/form/fieldset/div[5]/input"));

	}
	
	private Button getWithFacebookButton(){
	return new Button(driver, By.xpath("dsadasdasdasdasdas"));
}
	
	public FacebookLoginPage SignInFacebook(){
		getFacebookLink().click();
		return new FacebookLoginPage(driver);
	}

	private Link getFacebookLink() {
		return new Link(driver, By.xpath(".//*[@id='choices']/div/div/a[1]"));
	}

	}

