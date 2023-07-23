package com.ryze.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ryze.qa.base.TestBase;

import com.ryze.qa.pages.HomePage;
import com.ryze.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage lp;
	HomePage homepage;
	
	public LoginPageTest()
	{
		super();
	}
	
	
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		
		lp=new LoginPage();
		
	}
     
	@Test(priority=1)
	public void loginpageTitleTest()
	{
		String title=lp.validateLoginpageTitle();
		Assert.assertEquals(title, "Sign in - ryze");
	}
     @Test(priority=2)
     public void loginTest()
     {
    	homepage= lp.login(prop.getProperty("username"), prop.getProperty("password"));
     }

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
