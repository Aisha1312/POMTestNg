package com.aisha.DemoQASiteTestNG.pageClasses;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aisha.DemoQASiteTestNG.base.TestBase;

public class ElementsLinksPageClass extends TestBase {

	@FindBy(xpath="//div[@class='category-cards']//descendant::div[5]") WebElement elementsOptions;
	@FindBy(xpath="//span[text()='Links']") WebElement linksOptions;
	
	@FindBy(id="simpleLink") WebElement homeLink;
	@FindBy(id="dynamicLink") WebElement secondHomeLink;
	
	//API Call links
	@FindBy(xpath="//a[@id='created']") WebElement created;
	@FindBy(xpath="//*[text()='201']") WebElement createdMessage;
	
	@FindBy(xpath="//a[@id='no-content']") WebElement noContent;
	@FindBy(xpath="//*[text()='204']") WebElement noContentMessage;
	
	@FindBy(xpath="//a[@id='moved']") WebElement moved;
	@FindBy(xpath="//*[text()='301']") WebElement movedMessage;
	
	@FindBy(xpath="//a[@id='bad-request']") WebElement badRequest;
	@FindBy(xpath="//*[text()='400']") WebElement badRequestMessage;
	
	@FindBy(xpath="//a[@id='unauthorized']") WebElement unAuthorized;
	@FindBy(xpath="//*[text()='401']") WebElement unAuthorizedMessage;
	
	@FindBy(xpath="//a[@id='forbidden']") WebElement forbidden;
	@FindBy(xpath="//*[text()='403']") WebElement ForbiddenMessage;
	
	@FindBy(xpath="//a[@id='invalid-url' and text()='Not Found']") WebElement notFound;
	@FindBy(xpath="//*[text()='404']") WebElement NotFoundMessage;
	
	
	public ElementsLinksPageClass() {
		PageFactory.initElements(TestBase.getDriver(), this);
		// TODO Auto-generated constructor stub
	}
	
	public String implementValidateHomeLink()
	{
		String nameNewTab = "https://www.demoqa.com/";
		String actualNewTabName="";
		WebDriverWait d = new WebDriverWait(TestBase.getDriver(), 20);
		d.until(ExpectedConditions.visibilityOf(elementsOptions));
		elementsOptions.click();
		linksOptions.click();
		Actions a = new Actions(TestBase.getDriver());
		a.moveToElement(homeLink).click().build().perform();
		
		Set<String> browserWindows = TestBase.getDriver().getWindowHandles();
		Iterator<String> it = browserWindows.iterator();
		while(it.hasNext())
		{
			TestBase.getDriver().switchTo().window(it.next());
			actualNewTabName = TestBase.getDriver().getCurrentUrl();
			TestBase.getDriver().close();
			
		}
		
		return actualNewTabName;
	}
	
	
	public String implementValidateHomepvlkLink()
	{
		WebDriverWait d = new WebDriverWait(TestBase.getDriver(), 20);
		d.until(ExpectedConditions.visibilityOf(elementsOptions));
		elementsOptions.click();
		linksOptions.click();
		Actions a = new Actions(TestBase.getDriver());
		a.moveToElement(secondHomeLink).click().build().perform();
		
		Set<String> browserWindows = TestBase.getDriver().getWindowHandles();
		Iterator<String> it = browserWindows.iterator();
		String currentWindow = TestBase.getDriver().getWindowHandle();
		String childWindow= "";
		String url = "";
		while(it.hasNext())
		{
			childWindow = it.next();
			if(!currentWindow.equalsIgnoreCase(childWindow))
			{
				TestBase.getDriver().switchTo().window(childWindow);
				url = TestBase.getDriver().getCurrentUrl();
				System.out.println(url);
				
			}
			TestBase.getDriver().switchTo().window(currentWindow);
		}
		return url;
	}
	
	//Tests to implementValidate Api calls
	
	public boolean implementValidateCreatedLink()
	{
		WebDriverWait d = new WebDriverWait(TestBase.getDriver(), 20);
		d.until(ExpectedConditions.visibilityOf(elementsOptions));
		elementsOptions.click();
		linksOptions.click();
		JavascriptExecutor jsCreated = (JavascriptExecutor)TestBase.getDriver();
		jsCreated.executeScript("arguments[0].click();", created);
		return TestBase.getDriver().getPageSource().contains("201");		
	}
	
	
	public boolean implementValidateNoContentLink()
	{
		WebDriverWait d = new WebDriverWait(TestBase.getDriver(), 20);
		d.until(ExpectedConditions.visibilityOf(elementsOptions));
		elementsOptions.click();
		linksOptions.click();
		JavascriptExecutor jsNoContent = (JavascriptExecutor)TestBase.getDriver();
		jsNoContent.executeScript("arguments[0].click();", noContent);
		return TestBase.getDriver().getPageSource().contains("204");
	}
	
	
	public boolean implementValidateMovedLink()
	{
		WebDriverWait d = new WebDriverWait(TestBase.getDriver(), 20);
		d.until(ExpectedConditions.visibilityOf(elementsOptions));
		elementsOptions.click();
		linksOptions.click();
		JavascriptExecutor jsMoved = (JavascriptExecutor)TestBase.getDriver();
		jsMoved.executeScript("arguments[0].click();", moved);
		return TestBase.getDriver().getPageSource().contains("301");
	}
	
	
	public boolean implementValidateBadRequestLink()
	{
		WebDriverWait d = new WebDriverWait(TestBase.getDriver(), 20);
		d.until(ExpectedConditions.visibilityOf(elementsOptions));
		elementsOptions.click();
		linksOptions.click();
		JavascriptExecutor jsBadRequest = (JavascriptExecutor)TestBase.getDriver();
		jsBadRequest.executeScript("arguments[0].click();", badRequest);
		return TestBase.getDriver().getPageSource().contains("400");
	}
	
	public boolean implementValidateUnauthorisedLink()
	{
		WebDriverWait d = new WebDriverWait(TestBase.getDriver(), 20);
		d.until(ExpectedConditions.visibilityOf(elementsOptions));
		elementsOptions.click();
		linksOptions.click();
		JavascriptExecutor jsUnautorised = (JavascriptExecutor)TestBase.getDriver();
		jsUnautorised.executeScript("arguments[0].click();", unAuthorized);
		return TestBase.getDriver().getPageSource().contains("401");
	}
	
	
	public boolean implementValidateForbiddenLink()
	{
		WebDriverWait d = new WebDriverWait(TestBase.getDriver(), 20);
		d.until(ExpectedConditions.visibilityOf(elementsOptions));
		elementsOptions.click();
		linksOptions.click();
		JavascriptExecutor jsForbidden = (JavascriptExecutor)TestBase.getDriver();
		jsForbidden.executeScript("arguments[0].click();", forbidden);
		return TestBase.getDriver().getPageSource().contains("403");
	}
	
	
	public boolean implementValidateNotFoundLink()
	{
		WebDriverWait d = new WebDriverWait(TestBase.getDriver(), 20);
		d.until(ExpectedConditions.visibilityOf(elementsOptions));
		elementsOptions.click();
		linksOptions.click();
		JavascriptExecutor jsNotFound = (JavascriptExecutor)TestBase.getDriver();
		jsNotFound.executeScript("arguments[0].click();",notFound);
		return TestBase.getDriver().getPageSource().contains("404");
	}
	

}
