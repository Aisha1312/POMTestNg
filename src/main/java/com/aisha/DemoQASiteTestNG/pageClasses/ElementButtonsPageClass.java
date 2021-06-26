package com.aisha.DemoQASiteTestNG.pageClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aisha.DemoQASiteTestNG.base.TestBase;

public class ElementButtonsPageClass extends TestBase {
	
	@FindBy(xpath="//div[@class='category-cards']//descendant::div[5]") WebElement elementsOptions;
	@FindBy(xpath = "//span[contains(text(),'Buttons')]") WebElement buttonsOptions;
	
	@FindBy(xpath="//button[@id='doubleClickBtn']") WebElement doubleClickButton;
	@FindBy(xpath="//p[@id='doubleClickMessage']") WebElement doubleClickMessage;
	
	@FindBy(xpath="//button[@id='rightClickBtn']") WebElement rightClickButton;
	@FindBy(xpath="//p[@id='rightClickMessage']") WebElement rightClickMessage;
	
	@FindBy(xpath="//button[starts-with(text(),'Click Me')]") WebElement clickButton;
	@FindBy(xpath="//p[@id='dynamicClickMessage']") WebElement clickMessage;
	
	public ElementButtonsPageClass() {
		PageFactory.initElements(TestBase.getDriver(), this);
		// TODO Auto-generated constructor stub
	}
	
	public String doubleClick()
	{
		WebDriverWait d = new WebDriverWait(TestBase.getDriver(), 20);
		d.until(ExpectedConditions.visibilityOf(elementsOptions));
		elementsOptions.click();
		buttonsOptions.click();
		
		try {
			Actions a = new Actions(TestBase.getDriver());
			a.moveToElement(doubleClickButton).doubleClick().build().perform();
			String text= doubleClickMessage.getText();
			return text;
			}
		catch(Exception e){
			return "Not displayed";
		}
	}
	
	public String rightClickButton()
	{
		WebDriverWait d = new WebDriverWait(TestBase.getDriver(), 20);
		d.until(ExpectedConditions.visibilityOf(elementsOptions));
		elementsOptions.click();
		buttonsOptions.click();
		
		try {
			Actions a = new Actions(TestBase.getDriver());
			a.moveToElement(rightClickButton).contextClick().build().perform();
			String textRightClick = rightClickMessage.getText();
			return textRightClick;
			}
		catch(Exception e){
			return "Not displayed";
		}
	}
	
	public String clickButton()
	{
		WebDriverWait d = new WebDriverWait(TestBase.getDriver(), 20);
		d.until(ExpectedConditions.visibilityOf(elementsOptions));
		elementsOptions.click();
		buttonsOptions.click();
		
		try {
			Actions a = new Actions(TestBase.getDriver());
			a.moveToElement(clickButton).click().build().perform();
			String textClickButton = clickMessage.getText();
			return textClickButton;
			}
		catch(Exception e){
			return "Not displayed";
		}
	}
	

}
