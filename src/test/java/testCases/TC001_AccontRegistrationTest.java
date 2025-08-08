package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccontRegistrationTest extends BaseClass{
	
	
	@Test(groups= {"Sanity","Master"})
	public void verify_Account_Registratio()
	{
		
		try
		{
			logger.info("**Starting thr test TC001_AccontRegistrationTest**");

		HomePage hp=new HomePage(driver);
		hp.clickMyAcount();
		logger.info("Click on my account..");

		hp.clickRegister();
		logger.info("Click on register..");

		AccountRegistrationPage ar=new AccountRegistrationPage(driver);
		logger.info("Providing customer details..");

		ar.setFirstName(randomString().toUpperCase());
		ar.setLastName(randomString().toUpperCase());
		ar.setEmail(randomString()+"@gmail.com");
		ar.setTelephone(randomNumber());
		
		String password=randomAlphaNumber();
		ar.setPassword(password);
		ar.setConfirmPass(password);
		ar.setPrivecyPolicy();
		ar.clkContinue();
		
		logger.info("Validate the massage");
		String congmsg=ar.setConfirmationMassage();
		//Assert.assertEquals(congmsg, "Your Account Has Been Created!...");
		
		if(congmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test Failed..");
			logger.debug("Debug logs..");
			Assert.assertTrue(false);

		}
		
		}
		
		catch(Exception e)
		{
			Assert.fail();
			
		}
		logger.info("Test Finished");
		
	}
		

	
}
