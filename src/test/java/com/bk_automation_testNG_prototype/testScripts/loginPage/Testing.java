package com.bk_automation_testNG_prototype.testScripts.loginPage;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.bk_automation_testNG_prototype.testbase.TestBase;

public class Testing extends TestBase {
	
	@Test
	public void testing() throws InterruptedException {
		
		System.out.println("browser opeened");
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("qsclms@beyondkey.com.qa");
		
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("pass@123");
		
		driver.findElement(By.id("Login")).click();
		Thread.sleep(10000);
		
		Thread.sleep(10000);
		Thread.sleep(10000);
		Thread.sleep(30000);
	
	}
}
