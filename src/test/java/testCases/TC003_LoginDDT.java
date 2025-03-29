package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;



public class TC003_LoginDDT extends BaseClass {
	
	@Test(dataProvider ="LoginData", dataProviderClass=DataProviders.class, groups="Datadriven") // getting data from different class
	public void verify_loginDDT(String email, String pwd, String exp) throws InterruptedException
	{
		logger.info("*****Starting the TC003_LoginDDT ********");
		
		try {
		//HomePage  
		HomePage hp=  new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//Login
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clicklogin();
		
		//MyAccount
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage =macc.isMyAccoutPageExists();
		//Assert.assertTrue(targetPage); //Assert.assertEquals(targetPage, true, "Login Failed");
		
		/*
		 * Data is valid -- login  success -- test pass - logout
		 * data is valid -- login failed - test failed
		
		 * Data is invalid -- login  success -- test fail - logout
		 * data is invalid -- login failed - test passed
		 */
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetPage==false)
				Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
		}
		
	}
	catch(Exception e)
	{
		Assert.fail();
	}
		Thread.sleep(3000);
		logger.info("*****Finished the TC003_LoginDDT ********");

	}
}
