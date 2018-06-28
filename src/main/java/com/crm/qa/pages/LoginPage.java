package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//declaration
	
	@FindBy(name="username")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement passWord;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement submitBtn;
	
	@FindBy(xpath="//img[@alt='free crm logo']")
	WebElement freeCRMLogoImg;
	
	//intialisation
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilisation
	
	public boolean verifyCrmLogo()
	{
		 return freeCRMLogoImg.isDisplayed();
	}
	
	public String verifyTitle()
	{
		return driver.getTitle();
	}
	public HomePage enterLoginCredentials(String uname,String pwd)
	{
		userName.sendKeys(uname);
		passWord.sendKeys(pwd);
		submitBtn.click();
		return new HomePage();
		
	}

}
