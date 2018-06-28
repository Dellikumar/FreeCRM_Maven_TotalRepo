package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	//declaration
	@FindBy(xpath="(//*[contains(text(),'Contacts')])[3]")
	WebElement contactsLabel;
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//*[@type='button' ]//following-sibling::input[@value='Save']")
	WebElement saveBtn;
	
	
	
	//intialisation
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public boolean verifyContactsLabel()
	{
		return contactsLabel.isDisplayed();
		
	}
	
	public void selectContactName(String chooseName)
	{
		driver.findElement(By.xpath("//a[text()='"+chooseName+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	public void createNewContact(String title,String ftName,String ltName, String cmpName)
	{
		Select select =new Select(driver.findElement(By.xpath("//select[@name='title']")));
		select.selectByVisibleText(title);
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(cmpName);
		saveBtn.click();
		
	}
	
	
	

}
