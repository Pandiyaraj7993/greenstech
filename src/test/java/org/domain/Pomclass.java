package org.domain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pomclass extends DomainBaseclass {
	public Pomclass() {
	PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath="(//a[text()='Men'])[1]")
	private WebElement men;
	@FindBy(xpath="(//a[text()='T-Shirts'])[1]")
	private WebElement tshirt;
	public WebElement getMen() {
		return men;
	}
	public WebElement getTshirt() {
		return tshirt;
	}
	
	
}
