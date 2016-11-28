package com.lohika.atf.core.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.lohika.atf.core.web.WebPage;
import com.lohika.atf.core.web.elements.Button;
import com.lohika.atf.core.web.elements.TextInput;

public class SignedOutPage extends WebPage<SignedOutPage> {
	
	private static final String PAGE_URL = "https://www.goodreads.com/";
	public SignedOutPage(WebDriver driver) {
		super(driver);
		
	}

	@Override
	public SignedOutPage load() {
		driver.get(PAGE_URL);
		return this;
	}

	@Override
	public boolean isAvailable() {
		
		return getUserNameInput().isAvailable()&&
				getPasswordInput().isAvailable()&&
				getLoginButton().isAvailable();
	}

	
	public AdminHomePage loginAs(String username, String password){
		getUserNameInput().inputText(username);
		getPasswordInput().inputText(password);
		getLoginButton().click();
		return new AdminHomePage(driver).waitUntilAvailable();
	}
	
	
	private TextInput getUserNameInput(){
		return new TextInput(driver, By.id("userSignInFormEmail"));
	}
	
	private TextInput getPasswordInput(){
		
		return new TextInput(driver, By.id("user_password"));
	}
	

	private Button getLoginButton(){
		return new Button(driver, By.xpath(".//*[@value='Sign in']"));

	}
	
	
	public PleaseTryAgainWrongNamePassPage loginAsWrong(String username, String password){
		getUserNameInputW().inputText(username);
		getPasswordInputW().inputText(password);
		getLoginButtonW().click();
		return new PleaseTryAgainWrongNamePassPage(driver).waitUntilAvailable();
	}
	
	
	private TextInput getUserNameInputW(){
		return new TextInput(driver, By.id("userSignInFormEmail"));
	}
	
	private TextInput getPasswordInputW(){
		
		return new TextInput(driver, By.id("user_password"));
	}
	

	private Button getLoginButtonW(){
		return new Button(driver, By.xpath(".//*[@value='Sign in']"));

	}
	
	
	

	public SignedOutPage loadAsAnonymousUser(){
		load();
		return new SignedOutPage(driver).waitUntilAvailable();
	}
}
