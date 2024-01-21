package com.tests;

import java.io.IOException;

import org.pageObjects.AccountPage;
import org.pageObjects.LandingPage;
import org.pageObjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.resources.BaseReference;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest2 extends BaseReference {
	WebDriver driver;
	
	@BeforeMethod
	public void siteSetup() throws InterruptedException, IOException {
		driver = initDriver();
		driver.get(props.getProperty("URL"));
	}
	
	@Test(dataProvider = "LoginData")
	public void Login(String Name, String Password, String ExpectedResult) throws InterruptedException {
		
		LandingPage landingPage = new LandingPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		AccountPage accountPage = new AccountPage(driver);
		
		landingPage.myAcctMenu().click();
		Thread.sleep(3000);
		//landingPage.loginMenu().click();
		loginPage.loginEmail().sendKeys(Name);
		Thread.sleep(3000);
		loginPage.loginPwd().sendKeys(Password);
		Thread.sleep(3000);
		loginPage.loginBtn().click();
		Assert.assertTrue(accountPage.editAccount().isDisplayed(), ExpectedResult);
		
	}
	@AfterMethod
	
	public void teardown() {
		driver.quit();
	}
	
	@DataProvider(name = "LoginData")
	public Object[][] getLoginData() {
		Object[][] loginData = {{"kirti.sudhakaran@gmail.com", "Ninja@1403", "Pass"},
								{"kirticoding@gmail.com", "Seleniumjobs@1403", "Pass"},
								{"dummy@dummy.com", "dummy", "Fail"}};
		return loginData;
	}
	
}
