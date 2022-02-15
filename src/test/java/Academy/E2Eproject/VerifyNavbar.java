package Academy.E2Eproject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class VerifyNavbar extends base{
	public static Logger log=LogManager.getLogger(HomePageTest.class.getName());
	public WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();		
		driver.get(prop.getProperty("url"));
		log.info("site opened");
	}
	@Test
	public void basePageNavigation() throws IOException
	{
		
		LandingPage lp=new LandingPage(driver);
		Assert.assertFalse(lp.topnavbar().isDisplayed());
		log.info("top nav is present");
		Assert.assertEquals(driver.getTitle(), "hihi");
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
}
