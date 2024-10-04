package com.qc.testng.test;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.qc.testng.utils.TestUtils;

public class BaseIntergration {
	
	WebDriver driver;
	WebElement email,password,login,logout;
	Properties prob;
	TestUtils t1=new TestUtils();

	@BeforeSuite
	public void doSetup() throws IOException
	{
		prob = t1.readprob();
		if(prob.getProperty("browser").equals("Chrome"))
		{
			driver=new ChromeDriver();
			
		}else if(prob.getProperty("browser").equals("edge"))
		{
			driver=new EdgeDriver();
		}else
		{
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(prob.getProperty("siteUrl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@AfterSuite
	public void tearDown()
	{
		driver.close();
	}
	
}
