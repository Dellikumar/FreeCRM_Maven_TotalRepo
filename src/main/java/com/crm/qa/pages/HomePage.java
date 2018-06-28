package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//declaration
	
	@FindBy(xpath="//td[@class='headertext']//*[contains(text(),'Naveen K')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[@title='Contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[@title='Deals']")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[@title='Tasks']")
	WebElement tasksLink;
	
	@FindBy(xpath="//a[@title='New Contact']")
	WebElement newContact;
	
	//intialisation
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
   public String verifyHomePageTitle()
   {
	   return driver.getTitle();
   }
   
   public boolean verifyHomeUserName()
   {
	   return userNameLabel.isDisplayed();
   }
   
    public ContactsPage clickOnContactsLink()
   {
	   contactsLink.click();
	   return new ContactsPage() ;
   }
    
    public DealsPage clickOnDealsLink()
    {
 	   dealsLink.click();
 	   return new DealsPage() ;
    }
    
    public TasksPage clickOnTasksLink()
    {
    	tasksLink.click();
 	   return new TasksPage() ;
    }
    
    public void clickOnNewContactLink()
    {
    	Actions action= new Actions(driver);
    	action.moveToElement(contactsLink).build().perform();
    	newContact.click();
    	
    }
	

}
