package com.aisha.DemoQASiteTestNG.TestClasses;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aisha.DemoQASiteTestNG.base.TestBase;
import com.aisha.DemoQASiteTestNG.pageClasses.ElementsTextBoxPageClass;
import com.aisha.DemoQASiteTestNG.util.TestUtil;

public class TextBoxTest extends TestBase{


	ElementsTextBoxPageClass elePageClass ;
	com.aisha.DemoQASiteTestNG.util.TestUtil testUtil;
	String sheetName="elementsForm";
	
	public TextBoxTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		elePageClass = new ElementsTextBoxPageClass();
	}
	
	@Test(groups="TextBox")
	public void isElementsCardClickable(){
		
		boolean elementsResult= elePageClass.validateElementsCardClickable();
		Assert.assertTrue(elementsResult, "The elements card is not clickable");
	}
	
	@Test(groups="TextBox")
	public void isTextBoxOptionClickable()
	{
		String url = elePageClass.validateTextBoxOption();
		Assert.assertEquals(url, "https://demoqa.com/text-box");
	}
	
	@Test
	public void isEmailBoxHighlighted() throws InterruptedException
	{
		Assert.assertEquals(elePageClass.validateEmailAddress(), "rgba(73, 80, 87, 1)");
	}
	
	@Test(groups="TextBox", dataProvider="getElementsTestData")
	public void verifyElementsForm(String name, String email, String currentAddress, String permanentAddress)
	{
		elePageClass.validateFormSubmit(name, email, currentAddress, permanentAddress);
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
