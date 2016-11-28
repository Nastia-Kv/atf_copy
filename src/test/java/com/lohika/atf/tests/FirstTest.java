package com.lohika.atf.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

//import org.hamcrest.Matcher;
import org.testng.annotations.Test;

import com.lohika.atf.core.BaseTest;
//import com.lohika.atf.core.web.elements.Text;
import com.lohika.atf.core.web.pages.LoginPage;
import com.lohika.atf.core.web.pages.SearchForBooksPage;


public class FirstTest extends BaseTest{

	
	
	@Test
	public void testMethod(){

		
		 SearchForBooksPage targetPage = new LoginPage(driver)
		.loadAsAnonymousUser()
		.loginAs("nastia.kvas.89@gmail.com", "123Cat123")
		.goToMyBooksPage()
		.goToSeacrhForBooksPage()
		.fillInSearchField("Malalalala123")
		.searchButtonMethod();
		 
		assertThat("Page error message should be as expected", targetPage.getPageErrorMessage(), is(equalTo("You have no books matching \"Malalalala123\"")));
		try{Thread.sleep(6000);}catch(Exception e){}
		
		
	
	}	
	
}
	
	
