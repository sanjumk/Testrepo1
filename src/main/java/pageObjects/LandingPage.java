package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By signin=By.xpath("//span[contains(text(),'Login')]");
	By topnavbar=By.xpath("//nav[@class='navbar-collapse collapse']");
	
	public WebElement signin()
	{
		return driver.findElement(signin);
	}
	public WebElement topnavbar()
	{
		return driver.findElement(topnavbar);
		
	}

}
