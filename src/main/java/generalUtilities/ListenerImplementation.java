package generalUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ListenerImplementation implements ITestListener{

	ExtentReports reports;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		
		String testscriptName=result.getMethod().getMethodName();
		System.out.println(testscriptName+"===TestScript Execution Started===");
		
		 test=reports.createTest(testscriptName);
	}

	public void onTestSuccess(ITestResult result) {
		String testscriptName=result.getMethod().getMethodName();
		System.out.println(testscriptName+"===TestScript Execution Passed===");
		//log the success
		test.log(Status.PASS,testscriptName+"===Pass==");
	}

	public void onTestFailure(ITestResult result) {
		String testscriptName=result.getMethod().getMethodName();
		//log for failure
		test.log(Status.FAIL, testscriptName+"==Fail==");
		test.log(Status.INFO,result.getThrowable());
		//screenshot
		String screenshotName=testscriptName+new JavaUtility().getSystemData();
		WebDriverUtility web=new WebDriverUtility();
		try {
	  String path=web.captureScreenshot(BaseClass.sDriver, screenshotName);
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(testscriptName+"===TestScript execution failure");
		System.out.println(result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		String testscriptName=result.getMethod().getMethodName();
		System.out.println(testscriptName+"===TestScript execution skipped");
		System.out.println(result.getThrowable());
		
		test.log(Status.SKIP, testscriptName+"==Skip==");
		test.log(Status.INFO,result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		System.out.println("===Suite Execution Started===");
		ExtentSparkReporter htm=new ExtentSparkReporter(".\\ExtentReports\\Report"+new JavaUtility().getSystemData()+".html");
		htm.config().setTheme(Theme.DARK);
		htm.config().setDocumentTitle("Execution Report");
		htm.config().setReportName("vtiger execution report");
		
		
		 reports=new ExtentReports();
		 reports.attachReporter(htm);
		reports.setSystemInfo("Base Browser", "chrome");
		reports.setSystemInfo("Base Platform", "window");
		reports.setSystemInfo("Base Environment", "Testing");
		reports.setSystemInfo("Reporter Name", "ashutosh");
	}

	public void onFinish(ITestContext context) {
		System.out.println("===Suite Execution Finish===");
		reports.flush();
		
	}

}
