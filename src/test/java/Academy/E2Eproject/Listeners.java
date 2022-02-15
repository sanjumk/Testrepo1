package Academy.E2Eproject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtendReporterNG;
import resources.base;

public class Listeners extends base implements ITestListener {
	ExtentReports extent=ExtendReporterNG.getReportObject();
	ExtentTest test;
	
		public void onTestStart(ITestResult result) {
			// TODO Auto-generated method stub
			
			test= extent.createTest(result.getMethod().getMethodName());
		}

		public void onTestSuccess(ITestResult result) {
			// TODO Auto-generated method stub
			test.log(Status.PASS, "Passed");
		}

		public void onTestFailure(ITestResult result) {
			// TODO Auto-generated method stub
			test.fail(result.getThrowable());
			String testMethodName= result.getMethod().getMethodName();
			WebDriver driver=null;
			try {
				driver=(WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				getScreenShotPath(testMethodName,driver);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public void onTestSkipped(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		public void onStart(ITestContext context) {
			// TODO Auto-generated method stub
			
		}

		public void onFinish(ITestContext context) {
			// TODO Auto-generated method stub
			extent.flush();
		}

}
