package com.lohika.atf.core.web;

import org.openqa.selenium.WebDriver;

//import com.lohika.atf.core.web.pages.PleaseTryAgainWrongNamePassPage;

public abstract class Component<T extends Component<T>> {
	
	protected WebDriver driver;
	
	public Component(WebDriver driver){
		this.driver = driver;
		
	}
	public abstract boolean isAvailable();
	
	public T waitUntilAvailable(){
		return new Wait<T>().forComponent((T) this).toBeAvailable();
		
	}


}
