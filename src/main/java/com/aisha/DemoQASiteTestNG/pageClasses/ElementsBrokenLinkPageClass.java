package com.aisha.DemoQASiteTestNG.pageClasses;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aisha.DemoQASiteTestNG.base.TestBase;

public class ElementsBrokenLinkPageClass extends TestBase{
	
	@FindBy(xpath="//div[@class='category-cards']//descendant::div[5]") WebElement elementsOptions;
	@FindBy(xpath = "//span[contains(text(),'Broken Links - Images')]") WebElement brokenLinksOptions;
	
	@FindBy(xpath = "(//img[@src='/images/Toolsqa.jpg'])[2]") WebElement validImage;
	@FindBy(xpath = "//img[@src='/images/Toolsqa_1.jpg']") WebElement brokenImage;
	@FindBy(xpath = "//a[contains(text(),'Click Here for Valid Link')]") WebElement validLink;
	@FindBy(xpath="//a[@href='http://the-internet.herokuapp.com/status_codes/500']") WebElement brokenLink;
	
	public ElementsBrokenLinkPageClass() {
		PageFactory.initElements(TestBase.getDriver(), this);
	}
	
	
	public boolean validImage()
	{
		String brokenUrl = null;
		WebDriverWait d = new WebDriverWait(TestBase.getDriver(), 20);
		d.until(ExpectedConditions.visibilityOf(elementsOptions));
		elementsOptions.click();
		d.until(ExpectedConditions.visibilityOf(brokenLinksOptions));
		brokenLinksOptions.click();
		brokenUrl = TestBase.getDriver().getCurrentUrl();
		System.out.println("the url is " + brokenUrl);		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Boolean ImagePresent = (Boolean) ((JavascriptExecutor)TestBase.getDriver())
				.executeScript("return arguments[0].complete"+ 
		                       "&& typeof arguments[0].naturalWidth != \"undefined\""+
						       "&& arguments[0].naturalWidth > 0",validImage);
		System.out.println(ImagePresent);
		if (!ImagePresent)
        {
             System.out.println("Image not displayed.");
             return false;
        }
        else
        {
            System.out.println("Image displayed.");
            return true;
        }
		
	}
	
	public boolean brokenImage()
	{
		
		WebDriverWait d = new WebDriverWait(TestBase.getDriver(), 20);
		d.until(ExpectedConditions.visibilityOf(elementsOptions));
		elementsOptions.click();
		brokenLinksOptions.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Boolean brokenImagePresent = (Boolean) ((JavascriptExecutor)TestBase.getDriver())
				.executeScript("return arguments[0].complete"+ 
		                       "&& typeof arguments[0].naturalWidth != \"undefined\""+
						       "&& arguments[0].naturalWidth > 0",brokenImage);
		System.out.println(brokenImagePresent);
		if (!brokenImagePresent)
        {
             System.out.println("Image not displayed.");
             return false;
        }
        else
        {
            System.out.println("Image displayed.");
            return true;
        }
		
	}
	
	public boolean validLink(String str)
	{
		WebDriverWait d = new WebDriverWait(TestBase.getDriver(), 20);
		d.until(ExpectedConditions.visibilityOf(elementsOptions));
		elementsOptions.click();
		brokenLinksOptions.click();
		String urlString = validLink.getAttribute("href");
		
		//Checking response code of url
		URL url = null;
		try {
			url = new URL(urlString);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		int code = 0;
		try {
			HttpURLConnection myHttpConnection= (HttpURLConnection)url.openConnection();
			myHttpConnection.setConnectTimeout(5000);
			myHttpConnection.connect();
			code = myHttpConnection.getResponseCode();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		if (code>=400)
		{
			return false;
			
		}
		else
		{
			return true;
		}

		
	}
	
	public boolean brokenLink(String urlTemp)
	{
		WebDriverWait d = new WebDriverWait(TestBase.getDriver(), 20);
		d.until(ExpectedConditions.visibilityOf(elementsOptions));
		elementsOptions.click();
		brokenLinksOptions.click();
		
		URL url = null;
		HttpURLConnection urlConnection = null;
		String brokenLinkurl = brokenLink.getAttribute("href");
		try {
			url = new URL(brokenLinkurl);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		try {
				urlConnection = (HttpURLConnection)url.openConnection();
				urlConnection.setConnectTimeout(5000);
				urlConnection.connect();
				int code = urlConnection.getResponseCode();  
				if(code>=400)
				{
					return true;
				}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	

}
