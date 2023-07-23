package com.ryze.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ryze.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	
	
	
	
	@FindBy(xpath="//input[@id='username']")
	WebElement userName;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement passWord;
	
	@FindBy(xpath="//button[@id='btnSubmit']")
	WebElement signinBtn;
	
	
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
		
	}
	public String validateLoginpageTitle()
	{
		return driver.getTitle();
	}
	
	public HomePage login(String un, String Pwd)
	{
		userName.sendKeys(un);
		passWord.sendKeys(Pwd);
		signinBtn.click();
		return new HomePage();
	}
	
	
	
}
