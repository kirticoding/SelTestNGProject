package org.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseReference {
	public WebDriver driver;
	public Properties props;
	String browserName;
	
	public WebDriver initDriver() throws InterruptedException, IOException {
		props = new Properties();
		String pathProp = System.getProperty("user.dir")+"\\src\\main\\java\\org\\resources\\config.properties";
		FileInputStream inputStream = new FileInputStream(pathProp);
		props.load(inputStream);
		browserName = props.getProperty("browserName");
		
		if (browserName.equals("Chrome")) {
			driver = new ChromeDriver();
		}
		if (browserName.equals("Firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		return driver;
	}
	
	public void takeScreenshot(String testname, WebDriver driver) throws IOException {
		File SourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destFile = System.getProperty("user.dir")+"\\screenshots\\"+testname+".png";
		FileUtils.copyFile(SourceFile, new File(destFile));
	}
}
