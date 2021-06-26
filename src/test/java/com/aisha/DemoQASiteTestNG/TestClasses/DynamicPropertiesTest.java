package com.aisha.DemoQASiteTestNG.TestClasses;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aisha.DemoQASiteTestNG.base.TestBase;
import com.aisha.DemoQASiteTestNG.pageClasses.DynamicPropertiesPageClass;


public class DynamicPropertiesTest extends TestBase{

	DynamicPropertiesPageClass dynamicProperties;
	
	public DynamicPropertiesTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		dynamicProperties = new DynamicPropertiesPageClass();
	}
	
	@Test
	public void validateAfterFiveSecond()
	{
		dynamicProperties.AfterFiveSecond();
	}
	
	@Test
	public void validateColorButton()
	{
		Assert.assertTrue(dynamicProperties.colorButton());
	}
	
	@Test
	public void validateVisibleButton()
	{
		Assert.assertTrue(dynamicProperties.visibleButton());
	}
	
	@AfterMethod
	public void tearDown(){
		TestBase.getDriver().quit();
	}

}
