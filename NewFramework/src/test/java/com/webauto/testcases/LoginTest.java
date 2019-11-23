package com.webauto.testcases;


import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;

import com.webauto.pages.BaseClass;
import com.webauto.pages.LoginPage;


public class LoginTest extends BaseClass {
	@Test
	public void testLogin(){
		logger=report.createTest("Login to Word");
		LoginPage log=PageFactory.initElements(driver, LoginPage.class);
		logger.info("Starting application");	
		log.loginToSite(excel.getStringData(0, 0, 0), excel.getStringData(0, 0, 1));
		logger.pass("Login success");
	
		
	}
	

}
