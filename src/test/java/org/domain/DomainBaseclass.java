package org.domain;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class DomainBaseclass {
	public static WebDriver driver;
	public static void lunchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\PANDI\\eclipse-workspace\\domain\\driver\\chromedriver.exe");
		 driver= new ChromeDriver();
		 
		
	}
	
	public static void loadUrl(String s) {
		driver.get(s);
		

	}
	public void mouseover(WebElement e) {
		
		Actions obj=new Actions(driver);
		obj.moveToElement(e).perform();
	}
	
	public static void selectText(WebElement e ,int a) {
				Select s=new Select(e);
				s.selectByIndex(a);
		}
		
	
	public static void btnClick(WebElement e) {
		e.click();
		
	}
	public static void fill(WebElement e, String s) {
		e.sendKeys(s);
		
	}
	
	
	public static String excelRead(String d,int a,int b) throws Throwable {
		
		File loc=new File("C:\\Users\\PANDI\\eclipse-workspace\\domain\\Data\\Data.xlsx");
		FileInputStream stream=new FileInputStream(loc);
	Workbook w = new XSSFWorkbook(stream);
	Sheet sheet = w.getSheet(d);
		Row r = sheet.getRow(a);
			Cell c = r.getCell(b);
		
		int type = c.getCellType();
		if (type==1) {
			String ss = c.getStringCellValue();
			return ss;
		}
			else if (type==0) {
				if (DateUtil.isCellDateFormatted(c)) {
					Date dateCellValue = c.getDateCellValue();
					SimpleDateFormat sim=new SimpleDateFormat("dd-MMM-yy");
					String ss = sim.format(dateCellValue);
					return ss;
					
				}
				else {
					double numericCellValue = c.getNumericCellValue();
					long l=(long)numericCellValue;
					String ss = String.valueOf(l);
					return ss;
				}
			}
		return d;
	}
	public void excelwright(String s) throws Throwable {
		File loc=new File("C:\\Users\\PANDI\\eclipse-workspace\\domain\\Data\\Data.xlsx");
	Workbook w=new XSSFWorkbook();
	Sheet wright = w.createSheet(s);	
	for (int i = 0; i >=0; i++) {
		Row row = wright.createRow(i);
		for (int j = 0; j >=0; j++) {
			Cell cell = row.createCell(j);
			FileOutputStream o=new FileOutputStream(loc);
			w.write(o);
			System.out.println("Sucessfully");
			
		}
		
	}
	}
	public static String getAtt(WebElement e) {
		String att = e.getAttribute("value");
		return att;
		
		
		
}
	



}
