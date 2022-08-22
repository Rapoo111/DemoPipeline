package com.bk_automation_testNG_prototype.testScripts.loginPage;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bk_automation_testNG_prototype.testbase.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BeyondIntranet extends TestBase{

	@Test
	public void testing() throws InterruptedException {
		
		System.out.println("browser opeened");
		long startTime = System.currentTimeMillis();
		
		 int numberOfFrame = driver.findElements(By.tagName("iframe")).size();
		 System.out.println("Number of Frames : " +numberOfFrame);
		 
		 Thread.sleep(2000);
		 driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
		 String captchaValue = driver.findElement(By.xpath("//input[@id='recaptcha-token']")).getAttribute("value");
		 System.out.println("Captcha value = " +driver.findElement(By.xpath("//input[@id='recaptcha-token']")).getAttribute("value"));
		
		 Thread.sleep(2000);
		 // REST API CODE
		 
			try {
				String baseUrl = "https://stage.beyondintranet.com/api/submit-contact-form/";

				RestAssured.baseURI = baseUrl;
			

				JSONObject requestParams = new JSONObject();
			    requestParams.put("message", "test Message for testing");
			    requestParams.put("UniqueRouteID", "76527cf5-9f39-4be2-beab-d10b8a401049"); 
			    requestParams.put("email", "ab12345@gmail.com"); 
			    requestParams.put("name", "Aditii Balurr"); 
			    requestParams.put("FirstName", "Aditii"); 
			    requestParams.put("LastName", "Balurr"); 
			    requestParams.put("contactNo", "7899800377"); 
			    requestParams.put("addIns", "M365 Services - SharePoint Intranet"); 
			    requestParams.put("IsSharePointForm", 0); 
			    requestParams.put("requestFrom", "BeyondIntranet-ContactUs"); 
			    requestParams.put("grecaptchaResponse", captchaValue); 
			    
			    Header h1= new Header("Accept", "application/json");
			    Header h2 = new Header("Content-Type", "application/json");
			    Header h3 = new Header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36");
			    List<Header> list = new ArrayList<Header>();
			    list.add(h1);
			    list.add(h2);
			    list.add(h3);

			    Headers header = new Headers(list);
			    //request.headers(header);
			    
				//Response response = RestAssured.given().header("Content-Type", "application/json").header("accept", "application/json").body(requestParams).request().post(baseUrl);
			   // Response response =   RestAssured.given().headers(header).body(requestParams).request().post(baseUrl);	
			    Response response =  RestAssured.given().when().log().all().headers(header).body(requestParams.toString()).request().post(baseUrl);
				//Assert.assertEquals(response.getStatusCode(), 200);

				String jsonString = response.asString();
				
				System.out.println("Response : " +jsonString);
				System.out.println("Response Code : " +response.getStatusCode());

			
			} catch (Exception e) {
				// TODO: handle exception
			}
	
	}
}
