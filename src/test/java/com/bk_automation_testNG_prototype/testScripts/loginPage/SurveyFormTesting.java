package com.bk_automation_testNG_prototype.testScripts.loginPage;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.bk_automation_testNG_prototype.testbase.TestBase;

public class SurveyFormTesting extends TestBase{
	
	@Test
	public void testSurveyForm() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    //driver.get("https://emea.focusvision.com/survey/selfserve/1da7/211212");
	    //driver.manage().window().maximize();
	    
	    Thread.sleep(5000);
	    driver.findElement(By.id("btn_continue")).click();
	    logExtentReport("Survey Started");
	    Thread.sleep(2000);
	    
	    driver.findElement(By.xpath("(//strong[contains(text(),'Laundry Fabric Enhancers')])[1]")).click();
	    logExtentReport("Question : Have you participated in a market research study within the past 2 weeks, on any of the following topics? -- Selected Laundry Fabric Enhancer");
	    driver.findElement(By.id("btn_continue")).click();
	    logExtentReport("Clicked on Continue button");
	    Thread.sleep(1000);
	    
	    driver.findElement(By.xpath("//span[contains(text(),'None of these')]")).click();
	    logExtentReport("Question : Do you, or does anyone in your immediate family work for any of the following industries? -- Selected None of these");
	    driver.findElement(By.id("btn_continue")).click();
	    logExtentReport("Clicked on Continue button");
	    Thread.sleep(1000);
	    
	    driver.findElement(By.xpath("//span[contains(text(),'Half of it or more')]")).click();
	    logExtentReport("Question : How much of the household grocery shopping do you, yourself do? -- Selected Half of it or more");
	    Thread.sleep(3000);
	    
	    driver.findElement(By.xpath("//li[@data-label='r2']")).click();
	    logExtentReport("Question : With which gender do you identify most? -- Selected Female");
	    Thread.sleep(1000);
	    
	    
	    driver.findElement(By.xpath("//input[@class='input text-input']")).click();
	    driver.findElement(By.xpath("//input[@class='input text-input']")).sendKeys("28");
	    logExtentReport("Question : Please type in your age below. -- Entered 28");
	    driver.findElement(By.id("btn_continue")).click();
	    logExtentReport("Clicked on Continue button");
	    
	    Thread.sleep(2000);
	    
	    driver.findElement(By.xpath("//span[contains(text(),'Once every 2 weeks')]")).click();
	    logExtentReport("Question : How often have you purchased products in each of the following categories? - Laundry Detergent  --- Selected Once every 2 weeks");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//span[contains(text(),'Once every 2 weeks')]")).click();
	    logExtentReport("Question : How often have you purchased products in each of the following categories? - Frozen Desserts  --- Selected Once every 2 weeks");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//span[contains(text(),'Once every 2 weeks')]")).click();
	    logExtentReport("Question : How often have you purchased products in each of the following categories? - Laundry Fabric Enhancers  --- Selected Once every 2 weeks");
	    Thread.sleep(1000);
	    
	    
	    driver.findElement(By.xpath("//span[contains(text(),'Dreft')]")).click();
	    logExtentReport("Question : Which brand or brands of Laundry Detergent have you purchased and used in the past 6 months? -- Selected Dreft");
	    driver.findElement(By.id("btn_continue")).click();
	    logExtentReport("Clicked on Continue button");
	    
	    
	    driver.findElement(By.xpath("(//td[@class='sq-atm1d-td sq-atm1d-content'])[2]")).click();
	    logExtentReport("Question : Select Phase? -- Selected Phase 2");
	    Thread.sleep(1000);
	    
	    
	    driver.findElement(By.xpath("//span[contains(text(),'Television')]")).click();
	    logExtentReport("Question : Which of the following is not an animal? -- Selected Television");
	    Thread.sleep(2000);
	    
	    driver.findElement(By.xpath("//span[@class='sq-atm1d-legend']//b[contains(text(),'I hereby acknowledge and agree to the terms.')]")).click();
	    logExtentReport("Clicked on - I hereby acknowledge and agree to the terms.");
	    Thread.sleep(2000);
	    
	    driver.findElement(By.id("btn_continue")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.id("btn_continue")).click();
	    
	    driver.findElement(By.xpath("//div[@id='container']")).click();
	    logExtentReport("Clicked on centre of the image");
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//div[@id='container']")).click();
	    logExtentReport("Clicked on centre of the image");
	    driver.findElement(By.xpath("//div[@id='container']")).click();
	   // Thread.sleep(5000);
	    
	    
	    WebDriverWait wait = new WebDriverWait(driver, 20);
	    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//img[@class='magnify-image']"))));
	    WebElement target = driver.findElement(By.xpath("//img[@class='magnify-image']"));
	    Actions builder = new Actions(driver);    
	    int clickAtX = 54;     
	    int clickAtY = 193; 
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(400,400)", "");
	    wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//img[@class='magnify-image']"))));
	    builder.moveToElement(target,clickAtX,clickAtY).click().build().perform(); 
	    builder.moveToElement(target,clickAtX,clickAtY).click().build().perform(); 
	    logExtentReport("Question : Please go shopping for Laundry Products, assuming you are on a typical shopping trip -- Selected product by clicking on co-ordinates(54,193)");
	   // driver.findElement(By.xpath("//div[@class='revealPic']")).click();
	    Thread.sleep(4000);
	    
	    driver.findElement(By.xpath("//div[@class='modal-content']")).click();
	    
	    String productName = driver.findElement(By.xpath("//li[@ng-show='popupShowName']")).getText().toString();
	    System.out.println("Product Name : " +productName);
	    logExtentReport("Product Name : " +productName);
	    
	    String productPrice = driver.findElement(By.xpath("//li[@ng-show='popupShowPrice']")).getText().toString();
	    System.out.println("Product Price : " +productPrice);
	    logExtentReport("Product Price : " +productPrice);
	    
	    String productQuant = driver.findElement(By.xpath("//li[@ng-show='popupShowQuantity']")).getText().toString();
	    System.out.println("Product Quantity : " +productQuant);
	    logExtentReport("Product Quantity : " +productQuant);
	    
	    String productTotal = driver.findElement(By.xpath("//li[@ng-show='popupShowSubtotal']")).getText().toString();
	    System.out.println("Product Total : " +productTotal);
	    logExtentReport("Product Total : " +productTotal);
	    
	    driver.findElement(By.xpath("//button[normalize-space()='Purchase']")).click();
	    logExtentReport("Clicked on purchase button");
	    driver.findElement(By.id("btn_continue")).click();
	    
	    Thread.sleep(2000);
	    
	    logExtentReport("Question : Is cluttered -- Selected Option 1");
	    driver.findElement(By.id("btn_continue")).click();
	    Thread.sleep(2000);
	    
	    logExtentReport("Question : Is fresh-scented -- Selected Option 1");
	    driver.findElement(By.id("btn_continue")).click();
	    Thread.sleep(2000);
	    
	    logExtentReport("Question : Removes stains -- Selected Option 1");
	    driver.findElement(By.id("btn_continue")).click();
	    Thread.sleep(2000);
	    
	    logExtentReport("Question : Is gentle -- Selected Option 1");
	    driver.findElement(By.id("btn_continue")).click();
	    Thread.sleep(2000);
	    
	    logExtentReport("Question : Is unique and different from other brands -- Selected Option 1");
	    driver.findElement(By.id("btn_continue")).click();
	    Thread.sleep(2000);
	    
	    logExtentReport("Question : Is natural -- Selected Option 1");
	    driver.findElement(By.id("btn_continue")).click();
	    Thread.sleep(2000);
	    
	    logExtentReport("Question : Is efficient -- Selected Option 1");
	    driver.findElement(By.id("btn_continue")).click();
	    Thread.sleep(2000);
	    
	    driver.findElement(By.id("btn_continue")).click();
	    
	    Thread.sleep(2000);
	    driver.findElement(By.id("btn_continue")).click();
	    
	    logExtentReport("Clicked on 1st image show button");
	    driver.findElement(By.xpath("//button[@class='start-btn']")).click();
	    driver.findElement(By.xpath("//textarea[@class='input textarea']")).click();
	    driver.findElement(By.xpath("//textarea[@class='input textarea']")).sendKeys("Testing1");
	    logExtentReport("Entered 1st image description - Testing1 ");
	    driver.findElement(By.id("btn_continue")).click();
	    
	    Thread.sleep(2000);
	    driver.findElement(By.id("btn_continue")).click();
	    
	    logExtentReport("Clicked on 2nd image show button");
	    driver.findElement(By.xpath("//button[@class='start-btn']")).click();
	    driver.findElement(By.xpath("//textarea[@class='input textarea']")).click();
	    driver.findElement(By.xpath("//textarea[@class='input textarea']")).sendKeys("Testing2");
	    logExtentReport("Entered 2nd image description - Testing2 ");
	    driver.findElement(By.id("btn_continue")).click();
	    
	    Thread.sleep(2000);
	    driver.findElement(By.id("btn_continue")).click();
	    
	    logExtentReport("Clicked on 3rd image show button");
	    driver.findElement(By.xpath("//button[@class='start-btn']")).click();
	    driver.findElement(By.xpath("//textarea[@class='input textarea']")).click();
	    driver.findElement(By.xpath("//textarea[@class='input textarea']")).sendKeys("Testing3");
	    logExtentReport("Entered 3rd image description - Testing3 ");
	    driver.findElement(By.id("btn_continue")).click();
	    logExtentReport("Clicked on Continue button");
	    
	    Thread.sleep(2000);
	    
	    driver.findElement(By.xpath("(//td[@headers='F_Flash3_c1'])[1]")).click();
	    logExtentReport("The packaging fits very well with what I expect from laundry detergent -- Rating " +driver.findElement(By.xpath("//th[@id='F_Flash3_c1']")).getText());
	    Thread.sleep(1000);
	    
	    driver.findElement(By.xpath("(//td[@headers='F_Flash3_c1'])[2]")).click();
	    logExtentReport("It is easy to understand what product it is -- Rating " +driver.findElement(By.xpath("//th[@id='F_Flash3_c1']")).getText());
	    Thread.sleep(1000);
	    
	    driver.findElement(By.xpath("(//td[@headers='F_Flash3_c1'])[3]")).click();
	    logExtentReport("The packaging is clear -- Rating " +driver.findElement(By.xpath("//th[@id='F_Flash3_c1']")).getText());
	    Thread.sleep(1000);
	    
	    driver.findElement(By.xpath("(//td[@headers='F_Flash3_c1'])[4]")).click();
	    logExtentReport("It will make my clothes smell great -- Rating " +driver.findElement(By.xpath("//th[@id='F_Flash3_c1']")).getText());
	    Thread.sleep(1000);
	    
	    driver.findElement(By.xpath("(//td[@headers='F_Flash3_c1'])[5]")).click();
	    logExtentReport("It is a high quality product -- Rating " +driver.findElement(By.xpath("//th[@id='F_Flash3_c1']")).getText());
	    Thread.sleep(1000);
	    
	    driver.findElement(By.xpath("(//td[@headers='F_Flash3_c1'])[6]")).click();
	    logExtentReport("It is effective -- Rating " +driver.findElement(By.xpath("//th[@id='F_Flash3_c1']")).getText());
	    Thread.sleep(1000);
	    
	    
	    driver.findElement(By.id("btn_continue")).click();
	    logExtentReport("Clicked on Continue button");
	    
	    driver.findElement(By.id("btn_continue")).click();
	    
	    driver.navigate().refresh();
	    Thread.sleep(2000);
	    //Actions action = new Actions(driver);    
	   // js.executeScript("window.scrollBy(400,400)", "");
	   WebElement target1 = driver.findElement(By.xpath("//img[@class='magnify-image']"));
	   // wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//img[@class='magnify-image']"))));
	    //action.doubleClick(target1);
		
		  //action.moveToElement(target1,347,580).click().build().perform();
		  //action.moveToElement(target1,54,193).click().build().perform();
		  
		 // action.moveByOffset(54, 193).click().build().perform(); 
		  //action.moveToElement(target1,100,193).click().build().perform();
		  
		  
		  Actions action = new Actions(driver);    
		    int clickAtX1 = 100;     
		    int clickAtY1 = 250; 
		    JavascriptExecutor js1 = (JavascriptExecutor) driver;
		    js1.executeScript("window.scrollBy(400,400)", "");
		    wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//img[@class='magnify-image']"))));
		    
		    //actions.move_to_element_with_offset(driver.find_element_by_tag_name('body'), 0,0)
		    //actions.move_by_offset(X coordinates, Y coordinates).click().perform()
		    action.moveToElement(target1,0,0).click().build().perform(); 
		    action.moveByOffset(clickAtX1,clickAtY1).click().perform(); 
		    logExtentReport("Clicked on the product having the co-ordinates (100, 250)");
		    Thread.sleep(3000);
		   // action.moveByOffset(clickAtX1,clickAtY1).click().perform(); 
		    //action.moveToElement(target1,clickAtX1,clickAtY1).click().build().perform(); 
		    
		    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='modal-content']"))));
		    driver.findElement(By.xpath("//div[@class='modal-content']")).click();
		    
		    driver.findElement(By.xpath("//button[contains(text(),'Select')]")).click();
		    logExtentReport("Clicked on modal select button");
		    Thread.sleep(1000);
		    
		    driver.findElement(By.xpath("//span[contains(text(),'Very easy to find')]")).click();
		    logExtentReport("How easy or difficult do you think it was to find this product? -- Selected Very easy to find");
		    Thread.sleep(1000);
		    
		    driver.findElement(By.xpath("//span[contains(text(),'Very easy to tell the difference')]")).click();
		    logExtentReport("How easy or difficult do you think it is to tell the difference between these Behaviorally products? -- Selected Very easy to tell the difference");
		    Thread.sleep(1000);
		    
		    driver.findElement(By.xpath("//span[contains(text(),'Extremely well')]")).click();
		    logExtentReport("How well do the Behaviorally products fit together as a family? -- Selected Extremely well");
		    Thread.sleep(1000);
		    
		    js1.executeScript("window.scrollBy(500,500)", "");
		    driver.findElement(By.xpath("//div[@class='sq-imgmap-marker-button sq-imgmap-state-selected']")).click();
		    
		    Thread.sleep(3000);
		    WebElement high = driver.findElement(By.xpath("//img[@class='sq-imgmap-image']"));//canvas element
	        Actions action2 = new Actions(driver);
	        action.moveToElement(high,0,0).perform(); 
	        action2.clickAndHold(high).moveByOffset(96, 146).moveByOffset(110, 146).release().build().perform();
	        logExtentReport("Highlight the aspects of the packaging you like most  -- Highlighted area between co-ordinates (96,146) and (110,146)");
	        //action2.moveByOffset(96, 146).perform();
		   
	        driver.findElement(By.id("btn_continue")).click();
	        logExtentReport("Clicked on Continue button");
	        
	        //Dislike
	        js1.executeScript("window.scrollBy(500,500)", "");
		    driver.findElement(By.xpath("//div[@class='sq-imgmap-marker-button sq-imgmap-state-selected']")).click();
		    WebElement high1 = driver.findElement(By.xpath("//img[@class='sq-imgmap-image']"));//canvas element
	        action.moveToElement(high1,0,0).perform(); 
	        action2.clickAndHold(high1).moveByOffset(96, 146).moveByOffset(110, 146).release().build().perform();
	        logExtentReport("Highlight the aspects of the packaging you dislike most  -- Highlighted area between co-ordinates (96,146) and (110,146)");
	        driver.findElement(By.id("btn_continue")).click(); 
		    
	        Thread.sleep(2000);
	        driver.findElement(By.id("btn_continue")).click(); 
	        driver.findElement(By.xpath("//textarea[@class='input textarea']")).click();
	        driver.findElement(By.xpath("//textarea[@class='input textarea']")).sendKeys("Testing");
	        logExtentReport("Question : what are your impressions of these products? -- Entered Testing");
	        driver.findElement(By.id("btn_continue")).click(); 
	        
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//span[contains(text(),'Like it very much')]")).click();
	        logExtentReport("Question : How much do you like or dislike the Behaviorally packaging? -- Selected Like it very much");
	        Thread.sleep(1000);
	        
	        driver.findElement(By.xpath("(//span[contains(text(),'Exciting')])[2]")).click();
	        logExtentReport("Question : Do you think the Behaviorally packaging is -- Selected Exciting");
	        driver.findElement(By.id("btn_continue")).click(); 
	        
	        logExtentReport("Question : How much do you agree or disagree that the following phrases apply to this Behaviorally product?");
	        driver.findElement(By.xpath("//span[contains(text(),'Agree Strongly')]")).click();
	        logExtentReport("This Behaviorally product Is made by a brand I can trust -- Selected Agree Strongly");
	        Thread.sleep(1000);
	        
	        driver.findElement(By.xpath("//span[contains(text(),'Agree Strongly')]")).click();
	        logExtentReport("This Behaviorally product Is worth paying more for -- Selected Agree Strongly");
	        Thread.sleep(1000);
	        
	        driver.findElement(By.xpath("//span[contains(text(),'Agree Strongly')]")).click();
	        logExtentReport("This Behaviorally product Is effective -- Selected Agree Strongly");
	        Thread.sleep(1000);
	        
	        driver.findElement(By.xpath("//span[contains(text(),'Agree Strongly')]")).click();
	        logExtentReport("This Behaviorally product Is for someone like me -- Selected Agree Strongly");
	        Thread.sleep(1000);
	        
	        driver.findElement(By.xpath("//span[contains(text(),'Agree Strongly')]")).click();
	        logExtentReport("This Behaviorally product Is for someone like me -- Selected Agree Strongly");
	        Thread.sleep(1000);
	        
	        driver.findElement(By.xpath("//span[contains(text(),'Agree Strongly')]")).click();
	        logExtentReport("This Behaviorally product Is a high quality product -- Selected Agree Strongly");
	        Thread.sleep(1000);
	        
	        driver.findElement(By.xpath("//span[contains(text(),'Agree Strongly')]")).click();
	        logExtentReport("This Behaviorally product Is better than other brands -- Selected Agree Strongly");
	        Thread.sleep(1000);
	        
	        driver.findElement(By.xpath("//span[contains(text(),'Definitely would buy')]")).click();
	        logExtentReport("Question : How likely would you be to buy one of these Behaviorally products, if they are available for the prices below? -- Selected Definitely would buy");
	        Thread.sleep(1000);
	        
	        driver.findElement(By.id("btn_continue")).click();
	        
	        
	        Select select1 = new Select(driver.findElement(By.xpath("(//select)[1]")));
	        select1.selectByVisibleText("Working full-time");
	        logExtentReport("Question : Which of the following best describes your current employment status? -- Selected Working full-time ");
	        Thread.sleep(1000);
	        
	        Select select2 = new Select(driver.findElement(By.xpath("(//select)[2]")));
	        select2.selectByVisibleText("Married");
	        logExtentReport("Question : What is your relationship status? -- Selected Married");
	        Thread.sleep(1000);
	        
	        Select select3 = new Select(driver.findElement(By.xpath("(//select)[3]")));
	        select3.selectByVisibleText("Masters degree");
	        logExtentReport("Question : What is the highest level of education you have completed? -- Selected Masters degree");
	        Thread.sleep(1000);
	        
	        Select select4 = new Select(driver.findElement(By.xpath("(//select)[4]")));
	        select4.selectByVisibleText("Less than $15 000");
	        logExtentReport("Question : Please select the range that best represents your total annual household income. -- Selected Less than $15 000");
	        Thread.sleep(1000);
	        
	        Select select5 = new Select(driver.findElement(By.xpath("(//select)[5]")));
	        select5.selectByVisibleText("Asian");
	        logExtentReport("Question : Please select one of these races/ethnicities that best describes you. -- Selected Asian");
	        Thread.sleep(1000);
	        
	        Select select6 = new Select(driver.findElement(By.xpath("(//select)[6]")));
	        select6.selectByVisibleText("Yes, European (e.g., Spain)");
	        logExtentReport("Question : Are you of Hispanic, Latino, or Spanish origin? -- Selected Yes, European (e.g., Spain)");
	        Thread.sleep(1000);
	        
	        driver.findElement(By.id("btn_continue")).click();
	        logExtentReport("Clicked on Continue button");
	        
	        String exitMsg = driver.findElement(By.xpath("//p[@class='exit-message-text']")).getText();
	        System.out.println("Exit Message Shown : " +exitMsg);
	        logExtentReport("Survey End Message : " +exitMsg);
	        
	        System.out.println("Survey is now Complete");
	        logExtentReport("Survey Complete");
		
	}
	

}
