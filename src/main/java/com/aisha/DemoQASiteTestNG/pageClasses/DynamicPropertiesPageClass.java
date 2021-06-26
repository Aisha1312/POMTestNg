package com.aisha.DemoQASiteTestNG.pageClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aisha.DemoQASiteTestNG.base.TestBase;

public class DynamicPropertiesPageClass extends TestBase {
	
	@FindBy(xpath="//div[@class='category-cards']//descendant::div[5]") WebElement elementsOptions;
	@FindBy(xpath = "//span[contains(text(),'Dynamic Properties')]") WebElement dynamicPropertiesOptions;
	
	@FindBy(xpath="//button[@id='enableAfter']") WebElement enableButton;
	@FindBy(xpath="//button[@id='colorChange']") WebElement colorButton;
	@FindBy(xpath="//button[@id='visibleAfter']") WebElement visibleButton;
	
	public DynamicPropertiesPageClass() {
		PageFactory.initElements(TestBase.getDriver(),this);
	}
	
	public void AfterFiveSecond()
	{
		WebDriverWait d = new WebDriverWait(TestBase.getDriver(), 20);
		d.until(ExpectedConditions.visibilityOf(elementsOptions));
		elementsOptions.click();
		dynamicPropertiesOptions.click();
		d.until(ExpectedConditions.elementToBeClickable(enableButton));
		enableButton.click();
		System.out.println("enable button is clicked");
		
	}
	
	public boolean colorButton()
	{
		WebDriverWait d = new WebDriverWait(TestBase.getDriver(), 20);
		d.until(ExpectedConditions.visibilityOf(elementsOptions));
		elementsOptions.click();
		dynamicPropertiesOptions.click();
		d.until(ExpectedConditions.attributeContains(colorButton, "color", "rgba(220, 53, 69, 1)"));
		colorButton.click();
		boolean b = colorButton.isDisplayed();
		/*String colorInitial= colorButton.getCssValue("color");
		System.out.println(colorInitial);
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//TestBase.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String finalcolor = colorButton.getCssValue("color");
		System.out.println(finalcolor);
		String hexValue = Color.fromString(finalcolor).asHex();
		System.out.println(hexValue);
		
		return hexValue;
		*/
		return b;
		
	}
	
	public boolean visibleButton()
	{
		WebDriverWait d = new WebDriverWait(TestBase.getDriver(), 20);
		d.until(ExpectedConditions.visibilityOf(elementsOptions));
		elementsOptions.click();
		dynamicPropertiesOptions.click();
		d.until(ExpectedConditions.visibilityOf(visibleButton));
		boolean b = visibleButton.isDisplayed();
		return b;
	}
	
}
