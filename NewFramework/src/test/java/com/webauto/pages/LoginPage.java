package com.webauto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	public WebDriver driver;
	public LoginPage(WebDriver driver){
		this.driver=driver;
	}
	
	@FindBy(how=How.NAME,using="log") WebElement uname;
	@FindBy(how=How.NAME,using="pwd") WebElement pass;
	@FindBy(how=How.NAME,using="wp-submit") WebElement logButton;
	
	

	public void loginToSite(String user, String passw) {
		// TODO Auto-generated method stub
		uname.sendKeys(user);
		pass.sendKeys(passw);
		logButton.click();
		
	}
}
