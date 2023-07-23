package com.ryze.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ryze.qa.base.TestBase;



public class HomePage extends TestBase{
	
	public String Descrption_Text=prop.getProperty("description_Text");
	LoginPage lp;
	HomePage homepage ;
	
	
	
	@FindBy(xpath = "//p[@class='fdxicon-regular fdx-repository fdx-main-nav-item-default']")
	WebElement Reposiory;
	
	@FindBy(xpath = "//li[@id='menuMdbStudies']")
	WebElement Studies;
	
	@FindBy(xpath="//span[@id='fdxMdbContainerListItem0MenuToggle']")
	WebElement ItemsMenu;
	
	@FindBy(xpath= "//li[@id='fdxMdbContainerListItem0View']")
	WebElement view;
	@FindBy(xpath= "//span[@id='dataAcquisitionName']")
	WebElement Dataaquisition;
	
	@FindBy(xpath= "//span[@id='FORMTypeName']")
	WebElement Forms;
	
	@FindBy(xpath= "//div[@class='fdx-ellipsis']//span[contains(text(),'Medical History')]")
	WebElement Medicalhistory;
	
	@FindBy(xpath= "//span[@translate='mdb.asset.btn.edit']")
	WebElement Editform;
	
	@FindBy(xpath= "//textarea[@id='assetLocaleEditTextTextareadescriptionus']")
	WebElement Description;
	
	@FindBy(xpath= "//button[@id='saveAsset']")
	WebElement Update;
	
	@FindBy(xpath= "//span[@translate='mdb.asset.btn.closeEdit']")
	WebElement closeEdit;
	
	@FindBy(xpath= "//*[@id=\"assetLocaleViewdescriptionus\"]/div/span[2]")
	WebElement DescriptionupdateText_properties;
	
	@FindBy(xpath= "//*[@id=\"formDescription\"]/span")
	WebElement DescriptionMedicalHistory;
	
	@FindBy(xpath= "//*[@id=\"menuUser\"]/fdx-main-nav-item/div/p[1]")
	WebElement testteamtechtest;
	
	@FindBy(xpath= "//span[normalize-space()='Sign out']")
	WebElement Signout;
	
	@FindBy(xpath= "//span[contains(@class,'action-text study')]")
	WebElement browseStudies;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
		lp=new LoginPage();
		
	}
	public void addDescription() throws InterruptedException
	{
		//Actions actionRepo = new Actions(driver);
		//actionRepo.moveToElement(Reposiory);
		//actionRepo.moveToElement(Studies).click();
		
		browseStudies.click();
		ItemsMenu.click();
		view.click();
		Dataaquisition.click();
		Forms.click();
		Medicalhistory.click();
		Editform.click();
		Description.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
		Thread.sleep(2);
		Description.sendKeys(Descrption_Text);
		
		Update.click();
		Thread.sleep(5);
		closeEdit.click();
		Thread.sleep(5);
		String Text=DescriptionupdateText_properties.getText();
		Assert.assertEquals(Text, Descrption_Text);
		String Text2=DescriptionMedicalHistory.getText();
		Assert.assertEquals(Text2, Descrption_Text);
		
		
	}
	
}
