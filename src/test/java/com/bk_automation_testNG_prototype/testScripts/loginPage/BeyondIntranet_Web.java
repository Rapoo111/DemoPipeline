package com.bk_automation_testNG_prototype.testScripts.loginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.bk_automation_testNG_prototype.helper.select.DropDownHelper;
import com.bk_automation_testNG_prototype.testbase.TestBase;

public class BeyondIntranet_Web  {

	@Test
	public void testing() throws InterruptedException {

		try {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Automation\\workspace\\QSC_Reflect\\Driver\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			
			long browserOpenStartTime = System.currentTimeMillis();
			System.out.println("browser Open start time: " +browserOpenStartTime);
			driver.get("https://stage.beyondintranet.com/contact");
			driver.manage().window().maximize();
			
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)", "");
			long browserLoadedTime = System.currentTimeMillis();
			System.out.println("browser Loaded time: " +browserLoadedTime);
				
			System.out.println("Time taken to load the browser : " +(browserLoadedTime - browserOpenStartTime));	
				
				
			long formFillStartTime = System.currentTimeMillis();
			driver.findElement(By.id("user_fname")).click();
			driver.findElement(By.id("user_fname")).sendKeys("Aditi");
			
			driver.findElement(By.id("user_lname")).click();
			driver.findElement(By.id("user_lname")).sendKeys("Balur");
			
			driver.findElement(By.id("user_email")).click();
			driver.findElement(By.id("user_email")).sendKeys("aditi@gmail.com");
			
			driver.findElement(By.id("user_ContactNumber")).click();
			driver.findElement(By.id("user_ContactNumber")).sendKeys("7899800377");
			
			DropDownHelper dropdownHelper = new DropDownHelper(driver);
			dropdownHelper.selectUsingVisibleText(driver.findElement(By.id("addIns")), "Power BI");
			
			driver.findElement(By.name("message")).click();
			driver.findElement(By.name("message")).sendKeys("Testing Message");
			
			//Thread.sleep(125000);
			Thread.sleep(10000);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']"))));
			//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("recaptcha-anchor-label"))));
			driver.findElement(By.id("recaptcha-anchor-label")).click();
			driver.switchTo().parentFrame();
			
			Thread.sleep(3000);
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,150)", "");
			driver.findElement(By.id("cmdsubmit")).click();
			//driver.findElement(By.id("cmdsubmit")).click();
			long formFillEndTime = System.currentTimeMillis();
			
			System.out.println("Time taken to fill form : " +(formFillEndTime - formFillStartTime));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
