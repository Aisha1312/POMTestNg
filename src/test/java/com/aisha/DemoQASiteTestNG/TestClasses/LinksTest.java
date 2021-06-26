package com.aisha.DemoQASiteTestNG.TestClasses;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aisha.DemoQASiteTestNG.base.TestBase;
import com.aisha.DemoQASiteTestNG.pageClasses.ElementButtonsPageClass;
import com.aisha.DemoQASiteTestNG.pageClasses.ElementsLinksPageClass;

public class LinksTest extends TestBase {

	ElementsLinksPageClass eleLinksClass;

	public LinksTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		eleLinksClass = new ElementsLinksPageClass();
	}
	
	@Test
	public void validateHomeLink()
	{
		String windowName = "https://demoqa.com/";
		Assert.assertEquals(eleLinksClass.implementValidateHomeLink(), windowName);
	}
	
	@Test
	public void validateHomepvlkLink()
	{
		String windowName = "https://demoqa.com/";
		Assert.assertEquals(eleLinksClass.implementValidateHomepvlkLink(), windowName);
	}
	
	//Tests to validate Api calls
	
	@Test
	public void validateCreatedLink()
	{
		Assert.assertTrue(eleLinksClass.implementValidateCreatedLink());
	}
	
	@Test
	public void validateNoContentLink()
	{
		Assert.assertTrue(eleLinksClass.implementValidateNoContentLink());
		
	}
	
	@Test
	public void validateMovedLink()
	{
		Assert.assertTrue(eleLinksClass.implementValidateMovedLink());
	}
	
	@Test
	public void validateBadRequestLink()
	{
		Assert.assertTrue(eleLinksClass.implementValidateBadRequestLink());
	}
	@Test
	public void validateUnauthorisedLink()
	{
		Assert.assertTrue(eleLinksClass.implementValidateUnauthorisedLink());
	}
	
	@Test
	public void validateForbiddenLink()
	{
		Assert.assertTrue(eleLinksClass.implementValidateForbiddenLink());
	}
	
	@Test
	public void validateNotFoundLink()
	{
		Assert.assertTrue(eleLinksClass.implementValidateNotFoundLink());
		
	}
	
	@AfterMethod
	public void tearDown(){
		TestBase.getDriver().quit();
	}


}
