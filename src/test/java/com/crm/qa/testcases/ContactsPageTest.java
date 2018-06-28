package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	TestUtil testutil;
	
	public ContactsPageTest()
	{
		super();
		
	}
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		intialization();
		 loginpage =new LoginPage();
		 homepage = loginpage.enterLoginCredentials(pro.getProperty("username"), pro.getProperty("password"));
		 testutil=new TestUtil();
		 testutil.switchToFrame();
		 homepage.clickOnContactsLink();
		 contactspage=new ContactsPage();
		 
		 testutil=new TestUtil();
		 
	}
	@Test(priority=1)
	public void verifyContactLabelTest()
	{
		boolean flag = contactspage.verifyContactsLabel();
		Assert.assertTrue(flag);
	}
	@Test(priority=2)
	public void clickOnSelectedContact()
	{
		contactspage.selectContactName("David Cris");
	}
	
	@DataProvider
	public Object[][] getCRMTestData()
	{
		Object[][] data = TestUtil.getTestData("contacts");
		return data;
		
	}
	
	
	
	@Test(priority=3,dataProvider="getCRMTestData")
	public void verifyCreateNewContact(String title, String ftname, String ltname ,String comp)
	{
		homepage.clickOnNewContactLink();
		contactspage.createNewContact(title,ftname,ltname,comp);
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
