package com.crm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.WebEventListener;

public class TestBase {
	
	public static Properties pro;
	public static WebDriver driver;
	
	
	public TestBase()
	{
		try {
			File f= new File("D:\\Eclipse\\FreeCRM\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			FileInputStream fis = new FileInputStream(f);
			 pro=new Properties();
			pro.load(fis);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void intialization() throws InterruptedException
	{
		String browserName = pro.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","D:\\Delli_Selenium_Practice\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","D:\\Delli_Selenium_Practice\\geckodriver.exe");
			driver = new FirefoxDriver();
		};
		
		
		EventFiringWebDriver e_driver= new EventFiringWebDriver(driver);
		WebEventListener eListener= new WebEventListener();
		e_driver.register(eListener);
		driver=e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(pro.getProperty("url"));
		Thread.sleep(3000);
	}

}
