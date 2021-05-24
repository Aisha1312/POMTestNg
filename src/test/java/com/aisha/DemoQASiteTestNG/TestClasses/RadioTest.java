package com.aisha.DemoQASiteTestNG.TestClasses;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aisha.DemoQASiteTestNG.base.TestBase;
import com.aisha.DemoQASiteTestNG.pageClasses.ElementsRadioPageClass;


public class RadioTest extends TestBase{
	
	ElementsRadioPageClass eleRadioClass;
	SoftAssert sa = new SoftAssert();
	
	
	public RadioTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		eleRadioClass = new ElementsRadioPageClass();
	}
	
	@Test
	public void validateYESRadioButton()
	{
		
		sa.assertTrue(eleRadioClass.yesRadioButtons(),"Validation of YES radioButton Failed");
		sa.assertAll();
	}
	
	@Test
	public void validateImpressiveRadioButton()
	{
		
		sa.assertTrue(eleRadioClass.impressiveRadioButtons(),"Validation of Impressive radioButton Failed");
		sa.assertAll();
	}
	
	@Test
	public void validateNORadioButton()
	{
		
		sa.assertFalse(eleRadioClass.noRadioButtons(),"Validation of No radioButton Failed");
		sa.assertAll();
	}
	
	@AfterMethod
	public void tearDown(){
		TestBase.getDriver().quit();
	}

}
