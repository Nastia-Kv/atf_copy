package com.lohika.atf.tests;

import org.testng.annotations.Test;

import com.lohika.atf.core.BaseTest;
import com.lohika.atf.core.web.pages.SearchForBooksPage;

public class SecondTest_2 extends BaseTest {
	
	@Test
	public void testMethod_22(){
		new SearchForBooksPage(driver)
		.signout();
		
	}
	

}
