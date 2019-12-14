package utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersTest implements ITestListener{

	public void onFinish(ITestContext arg0) {
		System.out.println(arg0.getName()+" is finished");
	}

	public void onStart(ITestContext arg0) {
		System.out.println(arg0.getName()+" is started");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		System.out.println(arg0.getName()+" is completed with x percentage");
	}

	public void onTestFailure(ITestResult arg0) {
		System.out.println(arg0.getName()+" is failed");
		try {
			TestUtils.takeScreenshot(arg0.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult arg0) {
		System.out.println(arg0.getName()+" is skipped");
	}

	public void onTestStart(ITestResult arg0) {
		System.out.println(arg0.getName()+" is test started");
	}

	public void onTestSuccess(ITestResult arg0) {
		System.out.println(arg0.getName()+" is success");
	}

}
