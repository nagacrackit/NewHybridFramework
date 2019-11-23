package com.webauto.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	WebDriver driver;
	public static WebDriver startApp(WebDriver driver,String bName,String url){
		if(bName.contains("chrome")){
			System.setProperty("webdriver.chrome.driver", "./Drives/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(bName.contains("firefox")){
			System.setProperty("webdriver.firefox.driver", "./Drives/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else{
			System.out.println("We do not support this browser");
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return driver;
	}
	public static void quitBrowser(WebDriver driver) {
		// TODO Auto-generated method stub
		driver.quit();
	}
	


}
