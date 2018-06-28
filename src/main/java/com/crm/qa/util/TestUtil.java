package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;
import com.google.common.io.Files;

public class TestUtil extends TestBase {
	
	static String path="C:\\Users\\Dell-pc\\Desktop\\CRMTestData.xlsx";
	static FileInputStream  file;
	 static Workbook workbook;
	 static Sheet sheet;
	
	public void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}
	
	public static void TakeScreenShotAtEndOfTest() throws Exception
	{
		
		
		File srcFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currDir =System.getProperty("user.dir");
		File destFile= new File(currDir + "/ScreenShots/" +System.currentTimeMillis() + ".png");
		Files.copy(srcFile, destFile);
		
	}
	public static Object[][] getTestData(String sheetName)
	{
	  try {
	  file = new FileInputStream(path);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 try {
		workbook=WorkbookFactory.create(file);
	} catch (InvalidFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 sheet = workbook.getSheet(sheetName);
	 Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	int rows = sheet.getLastRowNum();
	int columns=sheet.getRow(0).getLastCellNum();
	
	System.out.println("No of rowsis " +rows);
	System.out.println("No of columns is " +columns);
	
	 for(int i=0;i<sheet.getLastRowNum();i++)
	 {
		 for(int k=0;k<sheet.getLastRowNum();k++)
		 {
			 data[i][k] =sheet.getRow(i+1).getCell(k).toString();
			 System.out.print(   data[i][k]   );
		 }
	 }
	return data;
	
	 
	  
		
	}

}
