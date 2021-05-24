package com.aisha.DemoQASiteTestNG.pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aisha.DemoQASiteTestNG.base.TestBase;

public class ElementsCheckBoxPageClass extends TestBase {
	
	@FindBy(xpath="//div[@class='category-cards']//descendant::div[5]") WebElement elementsOptions;
	@FindBy(xpath="//span[contains(text(),'Check Box')]") WebElement checkBoxOptions;
	@FindBy(xpath="//button[@title='Expand all']") WebElement plusSymbol;
	String fPath="//span[contains(text(),'";
	String lPath="')]//preceding-sibling::span[@class='rct-checkbox']"; 
	
	public ElementsCheckBoxPageClass() {
		PageFactory.initElements(TestBase.getDriver(), this);
		// TODO Auto-generated constructor stub
	}
	
	// Actions Method
		public boolean validateElementsCardClickable() {
			try {
				WebDriverWait d = new WebDriverWait(TestBase.getDriver(), 20);
				d.until(ExpectedConditions.visibilityOf((elementsOptions)));
				elementsOptions.click();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}

		}
		
	public boolean checkBoxOptionsDescription(String option)
	{
		try {
			WebDriverWait d = new WebDriverWait(TestBase.getDriver(), 20);
			d.until(ExpectedConditions.visibilityOf(elementsOptions));
			elementsOptions.click();
			d.until(ExpectedConditions.visibilityOf(checkBoxOptions)).click();
			d.until(ExpectedConditions.visibilityOf(plusSymbol)).click();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		TestBase.getDriver().findElement(By.xpath("//span[contains(text(),'"+option+"')]//preceding-sibling::span[@class='rct-checkbox']")).click();
		return TestBase.getDriver().findElement(By.xpath("//span[contains(text(),'"+option+"')]//preceding-sibling::span[@class='rct-checkbox']")).isEnabled();
		
	}

}
