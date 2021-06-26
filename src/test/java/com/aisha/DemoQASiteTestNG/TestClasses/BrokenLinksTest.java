package com.aisha.DemoQASiteTestNG.TestClasses;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aisha.DemoQASiteTestNG.base.TestBase;
import com.aisha.DemoQASiteTestNG.pageClasses.ElementButtonsPageClass;
import com.aisha.DemoQASiteTestNG.pageClasses.ElementsBrokenLinkPageClass;

public class BrokenLinksTest extends TestBase{
	
	ElementsBrokenLinkPageClass elebrokenLinkTest;
	
	public BrokenLinksTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		elebrokenLinkTest = new ElementsBrokenLinkPageClass();
	}
	@Test
	public void validateValidImage()
	{
		Assert.assertTrue(elebrokenLinkTest.validImage());
	}
	
	@Test
	public void validateBrokenImage()
	{
		Assert.assertFalse(elebrokenLinkTest.brokenImage());
	}
	
	@Test
	public void validateValidLink()
	{
		Assert.assertTrue(elebrokenLinkTest.validLink("https://demoqa.com/"));
	}
	
	@Test
	public void validateBrokenLink()
	{
		Assert.assertTrue(elebrokenLinkTest.brokenLink("http://the-internet.herokuapp.com/status_codes/500"));
	}
	
	@AfterMethod
	public void tearDown(){
		TestBase.getDriver().quit();
	}

}
