package com.aisha.DemoQASiteTestNG.pageClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aisha.DemoQASiteTestNG.base.TestBase;

public class ElementsRadioPageClass extends TestBase{
	
	@FindBy(xpath="//div[@class='category-cards']//descendant::div[5]") WebElement elementsOptions;
	
	@FindBy(xpath="//span[contains(text(),'Radio Button')]") WebElement RadioButtonOption;
	
	@FindBy(xpath="//div[@class='mb-3' and contains(text(),'Do you')]") WebElement question;
	
	@FindBy(xpath="//div/input[@id='yesRadio']") WebElement yesradioButton;
	@FindBy(xpath="//div/input[@id='impressiveRadio']") WebElement impressiveradioButton;
	@FindBy(xpath="//div/input[@id='noRadio']") WebElement noradioButton;
	
	
	public ElementsRadioPageClass() {
		PageFactory.initElements(TestBase.getDriver(), this);
		
	}
	
	//Actions Class
	
	/*public boolean validateElementsCardClickable() {
		try {
			WebDriverWait d = new WebDriverWait(TestBase.getDriver(), 20);
			d.until(ExpectedConditions.visibilityOf(RadioButtonOptions));
			RadioButtonOptions.click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}*/
	
	public boolean yesRadioButtons()
	{
			WebDriverWait d = new WebDriverWait(TestBase.getDriver(), 20);
			d.until(ExpectedConditions.visibilityOf(elementsOptions));
			elementsOptions.click();
			RadioButtonOption.click();
			JavascriptExecutor js = (JavascriptExecutor)TestBase.getDriver();
			js.executeScript("arguments[0].click();", yesradioButton);
			return yesradioButton.isSelected();
		
	}
	
	public boolean impressiveRadioButtons()
	{
			WebDriverWait d = new WebDriverWait(TestBase.getDriver(), 20);
			d.until(ExpectedConditions.visibilityOf(elementsOptions));
			elementsOptions.click();
			RadioButtonOption.click();
			JavascriptExecutor js = (JavascriptExecutor)TestBase.getDriver();
			js.executeScript("arguments[0].click();", impressiveradioButton);
			return impressiveradioButton.isSelected();
		
	}
	
	public boolean noRadioButtons()
	{
			WebDriverWait d = new WebDriverWait(TestBase.getDriver(), 20);
			d.until(ExpectedConditions.visibilityOf(elementsOptions));
			elementsOptions.click();
		    d.until(ExpectedConditions.visibilityOf(RadioButtonOption)).click();
		    JavascriptExecutor js = (JavascriptExecutor)TestBase.getDriver();
			js.executeScript("arguments[0].click();", noradioButton);
		    return noradioButton.isEnabled();
	}


}
