package com.aisha.DemoQASiteTestNG.pageClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aisha.DemoQASiteTestNG.base.TestBase;

public class ElementsWebTablesPageClass extends TestBase {

	@FindBy(xpath="//div[@class='category-cards']//descendant::div[5]") WebElement elementsOptions;
	
	@FindBy(xpath="//span[contains(text(),'Web Tables')]") WebElement webTableOption;
	
	@FindBy(xpath="//button[@id='addNewRecordButton']") WebElement addButton;
	@FindBy(xpath="//input[@id='searchBox']") WebElement searchBox;
	@FindBy(xpath="//span[@id='basic-addon2']") WebElement magnifyButton;
	
	@FindBy(id="firstName") WebElement firstName;
	@FindBy(id="lastName") WebElement lastName;
	@FindBy(id="userEmail") WebElement userEmail;
	@FindBy(id="age") WebElement ageBox;
	@FindBy(id="salary") WebElement salaryBox;
	@FindBy(id="department") WebElement department;
	@FindBy(xpath="//button[@id='submit']") WebElement submit;
	
	@FindBy(xpath="//div[contains(@class,'ReactTable')]") WebElement webtable;
	
	
	@FindBy(xpath="//div[contains(@class,'rt-td') and text()]/ancestor::div[contains(@class,'rt-tr-group')]//descendant::div[contains(@class,'rt-td') and text()][1]") WebElement namesLocator;
	
	public ElementsWebTablesPageClass() {
		PageFactory.initElements(TestBase.getDriver(), this);
		}
	
	//Actions
	public boolean savingData(String fName, String lName, String Age, String uMail,  String sal, String dept)
	{
		try {

			WebDriverWait d = new WebDriverWait(TestBase.getDriver(), 20);
			d.until(ExpectedConditions.visibilityOf(elementsOptions));
			elementsOptions.click();
			webTableOption.click();
			addButton.click();
			firstName.sendKeys(fName);
			lastName.sendKeys(lName);
			userEmail.sendKeys(uMail);
			ageBox.sendKeys(String.valueOf(Age));
			salaryBox.sendKeys(String.valueOf(sal));
			department.sendKeys(dept);
			submit.click();
			return true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean savingInvalidData(String fName, String lName, String Age, String uMail,  String sal, String dept)
	{
		WebDriverWait d = new WebDriverWait(TestBase.getDriver(), 20);
		d.until(ExpectedConditions.visibilityOf(elementsOptions));
		elementsOptions.click();
		webTableOption.click();
		addButton.click();
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		submit.click();
		String highlight="url(\"data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' width='12' height='12' fill='none' stroke='%23dc3545' viewBox='0 0 12 12'%3e%3ccircle cx='6' cy='6' r='4.5'/%3e%3cpath stroke-linejoin='round' d='M5.8 3.6h.4L6 6.5z'/%3e%3ccircle cx='6' cy='8.2' r='.6' fill='%23dc3545' stroke='none'/%3e%3c/svg%3e\")";
		 String emailHighlight = userEmail.getCssValue("background-image");
		 System.out.println(emailHighlight);
		 String ageHighlight =ageBox.getCssValue("background-image");
		 System.out.println(ageHighlight);
		 String salaryBoxHighlight = salaryBox.getCssValue("background-image");
		 System.out.println(salaryBoxHighlight);
		 String depBoxHighlight = department.getCssValue("background-image");
		 System.out.println(depBoxHighlight);
		 
		 if((emailHighlight.equalsIgnoreCase(highlight)) && (ageHighlight.equalsIgnoreCase(highlight)) && (salaryBoxHighlight.equalsIgnoreCase(highlight)) && (depBoxHighlight.equalsIgnoreCase(highlight)))
		 {
			 return true;
		 }
		 else
			 return false;
	}
	
	public String searchData(String fName, String lName, String Age, String uMail,  String sal, String dept)
	{
		WebDriverWait d = new WebDriverWait(TestBase.getDriver(), 20);
		d.until(ExpectedConditions.visibilityOf(elementsOptions));
		elementsOptions.click();
		webTableOption.click();
		addButton.click();
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		userEmail.sendKeys(uMail);
		ageBox.sendKeys(String.valueOf(Age));
		salaryBox.sendKeys(String.valueOf(sal));
		department.sendKeys(dept);
		submit.click();
		
		TestBase.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		List<WebElement> row = webtable.findElements(By.xpath("//div[contains(@class,'rt-tr-group')]"));
		int size= row.size();
		System.out.println(size);
		List<WebElement> rowsWithData = webtable.findElements(By.xpath("//div[contains(@class,'rt-td') and text()]/ancestor::div[contains(@class,'rt-tr-group')]")); 
		System.out.println(rowsWithData.size());
		String text= rowsWithData.get(2).getText();//.contains("Aisha");
		System.out.println(text);
		return text;
		
	}
	
	public List<String> saveData()
	{
		
		ArrayList<String> names = new ArrayList<String>();
		WebDriverWait d = new WebDriverWait(TestBase.getDriver(), 20);
		d.until(ExpectedConditions.visibilityOf(elementsOptions));
		elementsOptions.click();
		webTableOption.click();
		
		List<WebElement> row = webtable.findElements(By.xpath("//div[contains(@class,'rt-tr-group')]"));
		List<WebElement> rowsWithData = webtable.findElements(By.xpath("//div[contains(@class,'rt-td') and text()]/ancestor::div[contains(@class,'rt-tr-group')]")); 
		System.out.println(rowsWithData.size());
		
		List<WebElement> nameColumn = TestBase.getDriver().findElements(By.xpath("//div[contains(@class,'rt-td') and text()]/ancestor::div[contains(@class,'rt-tr-group')]"
				+ "//descendant::div[contains(@class,'rt-td') and text()][1]"));
		for(int i=0;i<nameColumn.size();i++)
		{
			names.add(nameColumn.get(i).getText());
		}
		
		return names;
		
	}
	
	

}
