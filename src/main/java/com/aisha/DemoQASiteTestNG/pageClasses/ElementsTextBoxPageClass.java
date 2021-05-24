package com.aisha.DemoQASiteTestNG.pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aisha.DemoQASiteTestNG.base.TestBase;

public class ElementsTextBoxPageClass extends TestBase {

	// By Locators
	private By elementsOptions = By.xpath("//div[@class='category-cards']//descendant::div[5]");
	private By textBoxOptions = By.xpath("//li//span[text()='Text Box']");
	private By fullName = By.xpath("//*[@id=\'userName\']");
	private By email = By.id("userEmail");
	private By currentAddress = By.xpath("//*[@id=\'currentAddress\']");
	private By permanentAddress = By.id("permanentAddress");
	private By submitButton = By.id("submit");

	public ElementsTextBoxPageClass() {
		PageFactory.initElements(TestBase.getDriver(), this);
	}


	// Actions Method
	public boolean validateElementsCardClickable() {
		try {
			WebDriverWait d = new WebDriverWait(TestBase.getDriver(), 20);
			d.until(ExpectedConditions.visibilityOfElementLocated(elementsOptions));
			TestBase.getDriver().findElement(elementsOptions).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
	
	public String validateTextBoxOption()
	{
		try {
			WebDriverWait d = new WebDriverWait(TestBase.getDriver(), 20);
			d.until(ExpectedConditions.visibilityOfElementLocated(elementsOptions));
			TestBase.getDriver().findElement(elementsOptions).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		TestBase.getDriver().findElement(textBoxOptions).click();
		String url = TestBase.getDriver().getCurrentUrl();
		return url;
		
	}
	
	public boolean validateFormSubmit(String name, String email1, String address, String permanentAddress1)
	{
		try {
			WebDriverWait d = new WebDriverWait(TestBase.getDriver(), 20);
			d.until(ExpectedConditions.visibilityOfElementLocated(elementsOptions));
			TestBase.getDriver().findElement(elementsOptions).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		TestBase.getDriver().findElement(textBoxOptions).click();
		try {
			TestBase.getDriver().findElement(fullName).sendKeys(name);
			TestBase.getDriver().findElement(email).sendKeys(email1);
			TestBase.getDriver().findElement(currentAddress).sendKeys(address);
			TestBase.getDriver().findElement(permanentAddress).sendKeys(permanentAddress1);
			TestBase.getDriver().findElement(submitButton).click();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public String validateEmailAddress() throws InterruptedException
	{
		try {
			WebDriverWait d = new WebDriverWait(TestBase.getDriver(), 20);
			d.until(ExpectedConditions.visibilityOfElementLocated(elementsOptions));
			TestBase.getDriver().findElement(elementsOptions).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		TestBase.getDriver().findElement(textBoxOptions).click();
		TestBase.getDriver().findElement(email).sendKeys("aaa");
		TestBase.getDriver().findElement(submitButton).click();
		String colour = TestBase.getDriver().findElement(email).getCssValue("color");	
		System.out.println(colour);
		return colour;
	
	}

}
