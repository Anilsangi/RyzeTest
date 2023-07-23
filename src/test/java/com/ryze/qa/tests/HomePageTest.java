package com.ryze.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ryze.qa.base.TestBase;
import com.ryze.qa.pages.HomePage;
import com.ryze.qa.pages.LoginPage;



public class HomePageTest extends TestBase{
	
	
	LoginPage lp;
	HomePage homepage;
	
	@BeforeMethod
	public void setup() throws InterruptedException  {
		
		initialization();

		lp = new LoginPage();
		homepage = new HomePage();
		lp.login(prop.getProperty("username"), prop.getProperty("password"));
		
				
	}
	
@Test(priority =1)
	
	public void verifyDescriptionTest() throws InterruptedException  {	
	
	homepage.addDescription();
	
	
			
	}


@AfterMethod
public void TearDown() {
driver.quit();
}
	

}
