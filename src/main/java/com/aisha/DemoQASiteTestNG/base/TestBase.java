package com.aisha.DemoQASiteTestNG.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.aisha.DemoQASiteTestNG.util.WebEventListener;
import com.aisha.DemoQASiteTestNG.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();

	public TestBase() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("src/main/java/com/aisha/DemoQASiteTestNG/config/config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

	}

	public static void initialization() {
		String url = prop.getProperty("URL");
		String browser = prop.getProperty("browser");

		if (browser.equalsIgnoreCase("Chrome")) {
			//System.setProperty("webdriver.chrome.driver", "C:\\work\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver());
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new FirefoxDriver()); 
		}

		getDriver().manage().deleteAllCookies();
		getDriver().get(url);
		getDriver().manage().window().maximize();

		// e_driver = new EventFiringWebDriver(driver);
		// eventListener = new WebEventListener();
		// e_driver.register(eventListener);
		// driver = e_driver;

		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		getDriver().manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		JavascriptExecutor js = ((JavascriptExecutor)getDriver());
		js.executeScript("window.scrollBy(0,600)");
		
		
		
	}
	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}


}
