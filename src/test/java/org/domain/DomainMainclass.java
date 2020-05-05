package org.domain;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DomainMainclass extends DomainBaseclass{
static WebDriver driver;
	
	@BeforeClass
	public static void browser() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\PANDI\\eclipse-workspace\\Test\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		}
	@BeforeMethod
	public void startTime() {
		Date d=new Date();
		System.out.println(d);	
	}
	@AfterMethod
	public void endTime() {
		Date d=new Date();
		System.out.println(d);
	}
	@AfterClass
	public static void quitBrowser() {
	driver.quit();
	}
	
	@Test()
	public void product() throws Throwable {
		loadUrl("https://www.myntra.com/");
		Pomclass p=new Pomclass();
		mouseover(p.getMen());	
		btnClick(p.getTshirt());
	}
	

}
