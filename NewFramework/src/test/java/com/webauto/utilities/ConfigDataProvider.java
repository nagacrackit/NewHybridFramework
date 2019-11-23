package com.webauto.utilities;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class ConfigDataProvider {
	Properties p;
	public ConfigDataProvider(){
		File f=new File("./Configuration/config.properties");
		try {
			FileInputStream fs=new FileInputStream(f);
			p=new Properties();
			p.load(fs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to read the file"+e.getMessage());
		} 
	}
	
	public String getBrowser(){
		return p.getProperty("browser");
	}
	public String getUrl(){
		return p.getProperty("url");
	}

}
