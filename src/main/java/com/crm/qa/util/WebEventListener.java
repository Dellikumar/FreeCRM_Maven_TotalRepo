package com.crm.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.crm.qa.base.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener{

	@Override
	public void afterAlertAccept(WebDriver arg0) {
		System.out.println("Alert is succesfully accepted");
		
	}

	@Override
	public void afterAlertDismiss(WebDriver arg0) {
		System.out.println("Alert is succesfully dismiised");
		
	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] arg2) {
		System.out.println("Element value changed to : " + element.toString());
		
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println(" Element is clicked " + element.toString());
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println(" Found element By : " +by.toString());
		
	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateBack(WebDriver arg0) {
		System.out.println("Navigated back to previous page");
		
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		
		System.out.println(" Navigated forwad to next page ");
	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		System.out.println(" Navigation of refresh is done");
		
	}

	@Override
	public void afterNavigateTo(String url , WebDriver driver) {
		System.out.println("navigated to : '" + url + "'  ");
		
	}

	@Override
	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] arg2) {
		System.out.println("Value of the :" + element.toString() + " before any changes made");
		
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println(" Trying to click on : " + element.toString());
		
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
	System.out.println("Trying to find element By  : " + by.toString() );
		
	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Navigating back to previous page");
		
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		System.out.println(" Navigating forwad to next page");
	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		
		System.out.println("Navigating to refresh the page");
	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("before navigating to: '" + url + "' ");
		
	}

	@Override
	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeSwitchToWindow(String arg0, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onException(Throwable error, WebDriver driver) {
		System.out.println("Exception occured " +error);
	    try {
			TestUtil.TakeScreenShotAtEndOfTest();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}

}
