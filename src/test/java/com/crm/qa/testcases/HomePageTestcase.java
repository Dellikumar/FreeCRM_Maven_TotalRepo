package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTestcase extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	TestUtil testutil;
	
	public HomePageTestcase()
	{
		super();
	}
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		intialization();
	    loginpage=new LoginPage();
	    testutil= new TestUtil();
	    homepage=loginpage.enterLoginCredentials(pro.getProperty("username"), pro.getProperty("password"));
	}
	@Test(priority=1)
	public void verifyHomePageTitle()
	{
		String homepageTitle=driver.getTitle();
		Assert.assertEquals(homepageTitle, "CRMPRO");
	}
	@Test(priority=2)
	public void verifyUserName()
	{
		 testutil.switchToFrame();
		 boolean flag = homepage.verifyHomeUserName();
		 Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void verifyClickContactLink()
	{
	   testutil.switchToFrame();
	   contactspage = homepage.clickOnContactsLink();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
