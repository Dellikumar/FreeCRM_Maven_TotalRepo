package com.crm.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginTestCase extends TestBase {
	LoginPage loginpg;
	HomePage homepage;
	
	public LoginTestCase()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		
		intialization();
	    loginpg= new LoginPage();
	}
	@Test(priority=1)
	public void crmTitleTest()
	{
		boolean flag = loginpg.verifyCrmLogo();
		System.out.println(flag);
		Assert.assertTrue(flag);
	}
	@Test(priority=2)
	public void loginTitleTest()
	{
		String title = loginpg.verifyTitle();
		Assert.assertEquals(title, "Free CRM software in the cloud powers sales and customer service");
		System.out.println(title);
		
	}
	@Test(priority=3)
	public void loginTest()
	{
		homepage=loginpg.enterLoginCredentials(pro.getProperty("username"), pro.getProperty("password"));
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
