package com.aisha.DemoQASiteTestNG.TestClasses;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aisha.DemoQASiteTestNG.base.TestBase;
import com.aisha.DemoQASiteTestNG.pageClasses.ElementsCheckBoxPageClass;
import com.aisha.DemoQASiteTestNG.pageClasses.ElementsWebTablesPageClass;
import com.aisha.DemoQASiteTestNG.util.TestUtil;

import junit.framework.Assert;

public class WebTableTest extends TestBase {

	ElementsWebTablesPageClass tablePage;
	TestUtil testUtil;
	String sheetName = "webTable";
	String sheetCreatedName = "webTableData";

	public WebTableTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		tablePage = new ElementsWebTablesPageClass();
	}

	@Test(dataProvider = "getElementsTestData")
	public void validateSavingData(String fName, String lName, String age, String email, String sal,
			String department) {
		Assert.assertTrue(tablePage.savingData(fName, lName, age, email, sal, department));

	}

	@Test(dataProvider = "getElementsTestData")
	public void validateInvalidSavingData(String fName, String lName, String age, String email, String sal,
			String department) {
		Assert.assertTrue(tablePage.savingInvalidData(fName, lName, age, email, sal, department));

	}

	@Test(dataProvider = "getElementsTestData")
	public void validatesearchData(String fName, String lName, String age, String email, String sal,
			String department) {
		tablePage.searchData(fName, lName, age, email, sal, department);

	}

	@Test
	public void savingData() {
		List<String> names = new ArrayList<String>();
		names = tablePage.saveData();
		System.out.println(names);
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
			TestUtil.settingCellData(sheetCreatedName, 1, i + 1, names.get(i));
		}
	}

	@AfterMethod
	public void teardown() {
		TestBase.getDriver().quit();
	}

	@DataProvider
	public Object[][] getElementsTestData() {
		Object data[][] = testUtil.getTestData(sheetName);
		return data;
	}
}
