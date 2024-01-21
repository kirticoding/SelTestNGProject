package org.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="email")
	WebElement loginEmail;
	
	@FindBy(id="input-password")
	WebElement loginPwd;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginBtn;
	
	public WebElement loginEmail() {
		return loginEmail;
	}
	
	public WebElement loginPwd() {
		return loginPwd;
	}
	
	public WebElement loginBtn() {
		return loginBtn;
	}
			
}
