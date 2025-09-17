package com.clientname.projectname.business.ObjecRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver ;
	public LoginPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver ;
		
	}

	@FindBy(id = "")
	WebElement elemntName;
	
	
	
	
	
}
