package com.bk_automation_testNG_prototype.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.bk_automation_testNG_prototype.helper.logger.LoggerHelper;
import com.bk_automation_testNG_prototype.helper.select.DropDownHelper;
import com.bk_automation_testNG_prototype.helper.wait.WaitHelper;
import com.bk_automation_testNG_prototype.testbase.TestBase;

public class Bk_ContactUsPage {

	
	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(LoginPage.class);
	
	WaitHelper waitHelper;

	@FindBy(id="user_fname")
	WebElement firstName;
	
	@FindBy(id="user_lname")
	WebElement lastName;
	
	@FindBy(id="user_email")
	WebElement email;
	
	@FindBy(id="user_ContactNumber")
	WebElement contactNumber;
	
	@FindBy(xpath="//select[@id='addIns']")
	WebElement productDropdown;
	
	@FindBy(id="user_message")
	WebElement notesMessage;
	
	@FindBy(id="H1Tag")
	WebElement thankYouText;
	
	@FindBy(id="cmdsubmit")
	WebElement submit;
	
	@FindBy(id="successMsg")
	WebElement errorMessage;
	
	public Bk_ContactUsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		TestBase.logExtentReport("ContactUs Object created");
	}
	
	public void landOnContactUsPage() {
		waitHelper.waitForElement(firstName,30);
		firstName.click();
		log.info("Landed on Contact Us page");
		logExtentReport("Landed on Contact Us page");
	}
	
	public void enterFirstName(String firstname) {
		this.firstName.clear();
		log.info("Entering firstName - "+firstname);
		this.firstName.sendKeys(firstname);
		logExtentReport("Entered First Name - "+firstname);
	}
	
	public void enterLastName(String lastname) {
		this.lastName.clear();
		log.info("Entering lastName - "+lastname);
		this.lastName.sendKeys(lastname);
		logExtentReport("Entered Last Name - "+lastname);
	}
	
	public void enterEmailAddress(String email) {
		this.email.clear();
		log.info("Entering email - "+email);
		this.email.sendKeys(email);
		logExtentReport("Entered Email Address - "+email);
	}
	
	public void enterContactNumber(String phone) {
		this.contactNumber.clear();
		log.info("Entering Contact Number - "+phone);
		this.contactNumber.sendKeys(phone);
		logExtentReport("Entered Contact Number - "+phone);
	}
	
	public void enterNotesMessage(String message) {
		this.notesMessage.clear();
		log.info("Entering notes message - "+message);
		this.notesMessage.sendKeys(message);
		logExtentReport("Entered Message Notes - "+message);
		
	}
	
	public void clickOnSubmit() {
		this.submit.click();
		log.info("Clicked on Submit button");
		logExtentReport("Clicked on Submit button");
	}
	
	public void fillContactInformationPage() throws InterruptedException {
		enterFirstName("BK_FirstName");
		Thread.sleep(1000);
		enterLastName("BK_LastName");
		Thread.sleep(1000);
		enterEmailAddress("automationtest@beyondkey.com");
		Thread.sleep(1000);
		enterContactNumber("1234567890");
		Thread.sleep(1000);
		selectProduct();
		Thread.sleep(1000);
		enterNotesMessage("This is a positive test scenario");
		Thread.sleep(1000);
		clickOnSubmit();

	}
	
	public void fillContactInformation() throws InterruptedException  {
		enterFirstName("BK_FirstName");
		Thread.sleep(1000);
		enterLastName("BK_LastName");
		Thread.sleep(1000);
		enterEmailAddress("automationtest@beyondkey.com");
		Thread.sleep(1000);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		//jsExecutor. executeScript("document.getElementById('contactNumber').value='contact'");
		jsExecutor.executeScript("arguments[0].value='PhoneNumber';", this.contactNumber);
		logExtentReport("Entered Contact Number  - PhoneNumber");
		Thread.sleep(1000);
		selectProduct();
		Thread.sleep(1000);
		enterNotesMessage("This is a negative test scenario");
		Thread.sleep(1000);
		clickOnSubmit();
		
		
	}
	
	public void selectProduct() {
		DropDownHelper dropdownHelper = new DropDownHelper(driver);
		dropdownHelper.selectUsingVisibleText(productDropdown, "Power BI");
	}
	
	
	public boolean  navigatedToThankYouPage() {
		 waitHelper.waitForElement(thankYouText, 15);
		 boolean textIsDisplayed = thankYouText.isDisplayed();
		return textIsDisplayed;
	}
	
	public boolean  navigatedThankYouPage() {
		 //waitHelper.waitForElement(thankYouText, 3);
		 boolean textIsDisplayed = thankYouText.isDisplayed();
		return textIsDisplayed;
	}
	
	public boolean waitForErrorMessage() {
		//waitHelper.waitForElement(errorMessage, 1);
		WebDriverWait wait = new WebDriverWait(driver,1);
		wait.until(ExpectedConditions.visibilityOf(this.errorMessage));
		boolean errMsg = errorMessage.isDisplayed();
		logExtentReport("Error Message displayed on UI: " +errorMessage.getText());
		return errMsg;
	}

	public void logExtentReport(String s1){
		TestBase.test.log(Status.INFO, s1);
	}
	
	
	
}
