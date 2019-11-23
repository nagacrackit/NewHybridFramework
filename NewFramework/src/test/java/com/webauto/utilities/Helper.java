package com.webauto.utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	public static String captureScreenshot(WebDriver driver){
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"/Screenshots"+cDateTime()+".png";
		try {
			FileHandler.copy(scr, new File(path));
			System.out.println("Screenshot captured");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to capture screenshot"+e.getMessage());
		}
		return path;
	}
	
	public static String cDateTime(){
		DateFormat customFormat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date d=new Date();
		return customFormat.format(d);
	}
}
