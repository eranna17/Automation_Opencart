package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstname;
	
	@FindBy(xpath="//input[@id='input-lastname']") //input[@id='input-lastname']
	WebElement txtLastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail; 
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtConfirmPwd; 
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTelephone;
	

	@FindBy(xpath="//input[@name='agree']")
	WebElement chkdPolicy;
	
//	@FindBy(xpath="//button[normalize-space()='Continue']")
//	WebElement btnContinue;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnCon;
	
	@FindBy(xpath= "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	
	

	public void setFirstName(String fname)
	{
		txtFirstname.sendKeys(fname);
	}

	public void setLastName(String lname)
	{
		txtLastname.sendKeys(lname);
	}
	
	public void  setEmail(String email)
	{
		txtEmail.sendKeys(email);
		System.out.println("Email : "+email);
	}
	 
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
		System.out.println("Password : "+pwd);
	}
	
	public void setConfirmPwd(String confirmPwd)
	{
		txtConfirmPwd.sendKeys(confirmPwd);
	}
	
	public void setTelephone(String teleNum)
	{
		txtTelephone.sendKeys(teleNum);
	}

	
	public void setPrivacyPolicy() {
        // Scroll to the Privacy Policy checkbox to ensure it's in view and clickable
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", chkdPolicy);
        
        // Wait for the element to be clickable and then click
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(chkdPolicy));
        chkdPolicy.click();
    }
	
//	public void clickContinue() {
//        // Wait for the Continue button to be clickable before clicking it
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(btnContinue));
//        btnContinue.click();
//    }
	
	public void clickContinue() {
        // Wait for the Continue button to be clickable before clicking it
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(btnCon));
        btnCon.click();
    }
	
	
	public String getConfirmationMsg() 
	{
		try 
		{
			return (msgConfirmation.getText());
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}
	
//	public void setPrivacyPolicy()
//	{
////		JavascriptExecutor js = (JavascriptExecutor) driver;
////		js.executeScript("arguments[0].scrollIntoView();", chkdPolicy);
//		chkdPolicy.click();
//	}
	
	
	
	
	
//	WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
	
	
	
	
//	public void clickContinue()
//	{
//		btnContinue.click();
//	}
//	
//	btnContinue.submit();
	
//	Actions act = new Actions(driver);
//	act.moveToElement(btnContinue).click().perform();
//	
//	
//	JavascriptExecutor js = (JavascriptExecutor) driver;
//	js.executeScript("arguments[0].click();", btnContinue);
//	
//	btnContinue.sendkeys(Keys.RETURN);
//	
//	WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
	
	
}
