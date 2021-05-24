package com.aisha.DemoQASiteTestNG.TestClasses;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aisha.DemoQASiteTestNG.base.TestBase;
import com.aisha.DemoQASiteTestNG.pageClasses.ElementsCheckBoxPageClass;
import com.aisha.DemoQASiteTestNG.pageClasses.ElementsTextBoxPageClass;

public class CheckBoxTest extends TestBase{
	
	ElementsCheckBoxPageClass eleCheckPage;
	com.aisha.DemoQASiteTestNG.util.TestUtil testUtil;
	String sheetName="checkBoxOptions";

	public CheckBoxTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		eleCheckPage = new ElementsCheckBoxPageClass();
	}
	
	@Test(groups="TextBox")
	public void isElementsCardClickable(){
		
		boolean elementsResult= eleCheckPage.validateElementsCardClickable();
		Assert.assertTrue(elementsResult, "The elements card is not clickable");
	}
	
	@Test(dataProvider="getElementsTestData")
	public void validatecheckBoxOptionsDescription(String option)
	{
		Assert.assertEquals(eleCheckPage.checkBoxOptionsDescription(option), true);
	}
	
	@DataProvider
	public Object[][] getElementsTestData(){
		Object data[][] = testUtil.getTestData(sheetName);
		return data;
	}
	
	@AfterMethod
	public void tearDown(){
		TestBase.getDriver().quit();
	}
}
