package com.lohika.atf.core.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.lohika.atf.core.web.WebPage;
import com.lohika.atf.core.web.elements.Button;
import com.lohika.atf.core.web.elements.TextInput;

public class FacebookLoginPage extends WebPage<FacebookLoginPage> {
	
	//private static final String PAGE_URL = "https://www.goodreads.com";
	public FacebookLoginPage(WebDriver driver) {
		super(driver);
		
	}

	@Override
	public FacebookLoginPage load() {
		driver.get("https://api.twitter.com/oauth/authenticate?oauth_token=Ltll-AAAAAAAAKqrAAABVitIsTQ");
		return this;
	}

	@Override
	public boolean isAvailable() {
		
		return getUserNameInputF().isAvailable()&&
				getPasswordInputF().isAvailable()&&
				getLoginButtonF().isAvailable();
	}

	
	public FacebookLoginPage loginWithFacebook(){
		getLoginButtonF().click();
		return new FacebookLoginPage(driver).waitUntilAvailable();
	}
	
	
	private TextInput getUserNameInputF(){
		return new TextInput(driver, By.xpath(".//*[@id='oauth_form']/fieldset[1]/div[1]/label"));
	}
	
	private TextInput getPasswordInputF(){
		
		return new TextInput(driver, By.xpath(".//*[@id='password']"));
	}
	

	private Button getLoginButtonF(){
		return new Button(driver, By.xpath(".//*[@id='allow']"));

	}	

}
