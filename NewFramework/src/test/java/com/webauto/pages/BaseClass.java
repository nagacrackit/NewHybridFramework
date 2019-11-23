package com.webauto.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.webauto.utilities.BrowserFactory;
import com.webauto.utilities.ConfigDataProvider;
import com.webauto.utilities.ExcelDataProvider;
import com.webauto.utilities.Helper;

public class BaseClass {
	//Base class is all about  preconditions and post conditions
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	@BeforeSuite
	public void setSuite(){
		
		Reporter.log("Settting up reports and test is trying get ready",true);
		excel=new ExcelDataProvider();
		config=new ConfigDataProvider();
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/"+Helper.cDateTime()+".html"));
		report=new ExtentReports();
		report.attachReporter(extent);
		Reporter.log("Setup is done-Test can be started");
	}
	@BeforeClass
	public void setUp(){
		Reporter.log("Launching the browser and application is getting ready", true);
		driver=BrowserFactory.startApp(driver, config.getBrowser(), config.getUrl());
		Reporter.log("Browser and app is up and running",true);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException{
		Reporter.log("Test is about to end",true);
		if(result.getStatus()==ITestResult.FAILURE){
			Helper.captureScreenshot(driver);
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			logger.pass("Test Passed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		
		report.flush();
		Reporter.log("Test completed>>>>> Reports generated",true);
	}
	
	@AfterClass
	public void tearDown(){
		BrowserFactory.quitBrowser(driver);
	}

}
