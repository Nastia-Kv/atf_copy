package com.lohika.atf.tests;

import org.testng.annotations.Test;

import com.lohika.atf.core.BaseTest;
//import com.lohika.atf.core.web.pages.AdminHomePage;
import com.lohika.atf.core.web.pages.LoginPage;

public class SecondTest extends BaseTest{
	
	@Test 
	public void testMethod2(){
		new LoginPage(driver)
		.loadAsAnonymousUser()
		.loginAsWrong("nastia.kvas.89@gmail.com323224234", "123Cat12fdfdfsdfsdf3")
		.loginAsWrong("nastia.kvas.89@gmail.com323224234", "123Cat12fdfdfsdfsdf3")
		.SignInFacebook();
	}
}
