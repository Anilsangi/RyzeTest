package com.ryze.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.ryze.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
		
		try
		{
			prop= new Properties();
			FileInputStream ip= new FileInputStream("C:\\Users\\DELL\\OneDrive\\Desktop\\Test\\ryzeTest\\src\\main\\java\\com\\ryze\\qa\\config\\config.properties");
			prop.load(ip);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
				
		}
	

     
	public static void initialization()
     {
    	 
    	 String browserName=prop.getProperty("browser");
    	 
    	 if(browserName.equals("chrome"))
    	 {
    		 driver=new ChromeDriver();
    	 }else if(browserName.equals("firefox"))
    	 {
    		 driver=new FirefoxDriver();
     }else if(browserName.equals("IE"))
	 {
		 driver=new InternetExplorerDriver();
     }else {
    	 driver=new EdgeDriver();
     }
    	 
     driver.manage().window().maximize();
	 driver.manage().deleteAllCookies();
	 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
	 
	 driver.get(prop.getProperty("url"));
}
}