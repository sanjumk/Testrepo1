package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
      prop=new Properties();
//FileInputStream fis=new FileInputStream("C:\\Users\\sajit\\eclipse-workspace\\E2Eproject\\src\\main\\java\\resources\\data.properties");
FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
	prop.load(fis);	
	String browserName=prop.getProperty("browser");		
	if(browserName.equals("chrome"))
	{
		//System.setProperty("webdriver.chrome.driver", "/Users/sajit/Documents/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	else if(browserName.equals("edge"))
	{
		System.setProperty("webdriver.edge.driver", "/Users/sajit/Documents/msedgedriver.exe");
		driver = new EdgeDriver();
	}
	else if(browserName.equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", "/Users/sajit/Documents/geckodriver.exe");
		 driver = new FirefoxDriver();
	}
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	return driver;
	
	}
	public void getScreenShotPath(String testMethodName,WebDriver driver) throws IOException
	{
		
		File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testMethodName+".png";
		FileUtils.copyFile(screen, new File(destinationFile));
	}
	}
