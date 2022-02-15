package Academy.E2Eproject;

import java.io.IOException;
//import java.lang.System.Logger;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.base;

public class HomePageTest extends base{
	
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
		lp.signin().click();
		log.info("signed in");
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

}
