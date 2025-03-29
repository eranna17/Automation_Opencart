package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups={"Regression","Master"})
	public void verify_accout_registraion()
	{
		try {
		logger.info("***Starting the TC001_AccountRegistrationTest *** ");
		HomePage hp = new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("Clicked on my account");
		
		hp.clickRegister();
		logger.info("Clicked on registration");
		
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		
		logger.info("Providing the customer details");
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com"); //randomely generated email
		
		
		String password = randomeAlphaNumeric();
		regpage.setPassword(password);
		
		
		regpage.setConfirmPwd(password);
		
		
		regpage.setTelephone(randomeNumber());
		
		
		regpage.setPrivacyPolicy();
		
		regpage.clickContinue();
		
		logger.info("Validating the expected message");
		String confmsg=regpage.getConfirmationMsg();
		System.out.println(confmsg);
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			logger.error("Test Failed");
			logger.debug("Debug logs");
			Assert.fail();
		}
		logger.info(" *** Finished the TC001_AccountRegistrationTest *** ");
		
	}
	

	
		
}
