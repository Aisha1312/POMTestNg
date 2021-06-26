package com.aisha.DemoQASiteTestNG.TestClasses;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aisha.DemoQASiteTestNG.base.TestBase;
import com.aisha.DemoQASiteTestNG.pageClasses.ElementButtonsPageClass;
import com.aisha.DemoQASiteTestNG.pageClasses.ElementsRadioPageClass;

public class ButtonTest extends TestBase{
	
	ElementButtonsPageClass eleButtonClass;
	SoftAssert sa = new SoftAssert();
	
	public ButtonTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		eleButtonClass = new ElementButtonsPageClass();
	}
	
	@Test
	public void validateDoubleClickMethod()
	{
		String s = eleButtonClass.doubleClick();
		Assert.assertEquals("You have done a double click", s);
	}
	@Test
	public void validateRightClickMethod()
	{
		sa.assertEquals(eleButtonClass.rightClickButton(),"You have done a right click");
		sa.assertAll();
	}
	@Test
	public void validateClickMethod()
	{
		String sc = eleButtonClass.clickButton();
		Assert.assertEquals(sc, "You have done a dynamic click");
		
	}
	
	@AfterMethod
	public void tearDown(){
		TestBase.getDriver().quit();
	}



}
