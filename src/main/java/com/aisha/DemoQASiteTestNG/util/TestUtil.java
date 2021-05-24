package com.aisha.DemoQASiteTestNG.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aisha.DemoQASiteTestNG.base.TestBase;

public class TestUtil extends TestBase {
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	
	public static String TESTDATA_SHEET_PATH = "src/main/java/com/aisha/DemoQASiteTestNG/testdata/elementsFormTestData.xlsx";
	public static String RETRIEVE_DATA_SHEETPATH = "src/main/java/com/aisha/DemoQASiteTestNG/testdata/webTableRetrieveData.xlsx";
	

	static Workbook book;
	static Sheet sheet;
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		System.out.println("Current working directory in Java : " + currentDir);
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	public static void settingCellData(String sheetName, int columnNumber, int rowNumber, String Data) {
		
		FileInputStream file = null;
		FileOutputStream fo=null;
		try {
			file = new FileInputStream(RETRIEVE_DATA_SHEETPATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int n = book.getNumberOfSheets();
		System.out.println("The number of sheets is " + n);
		
		while((n-1)>=0)
		{
			--n;
			if(book.getSheetAt(n).getSheetName().equalsIgnoreCase(sheetName))
				break;
			
		}
		if(n==0)
		{
			book.createSheet(sheetName);
		}
		sheet = book.getSheet(sheetName);
		Row r=  sheet.createRow(rowNumber);
		System.out.println("inside testUtil saving data " + Data);
		r.createCell(columnNumber).setCellValue(Data);
		try {
			fo= new FileOutputStream(RETRIEVE_DATA_SHEETPATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			book.write(fo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fo.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fo.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
