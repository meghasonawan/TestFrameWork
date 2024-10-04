package com.qc.testng.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseIntergration{
	
	@BeforeMethod
	public void Locateelement()
	{
		email=driver.findElement(By.id("email"));
		email.clear();
		password=driver.findElement(By.id("password"));
		password.clear();
		login=driver.findElement(By.id("submit"));
		
	}

	@Test
	public void doLogin()
	{
		email.sendKeys("queuecodes@gmail.com");
		password.sendKeys("123456");
		login.click();
	}
	
	@AfterMethod
	public void doAssert()
	{
		String actResult=driver.getTitle();
		String expReuslt="Queue Codes | Dashboard";
		Assert.assertEquals(actResult,expReuslt);
	}
	
}
