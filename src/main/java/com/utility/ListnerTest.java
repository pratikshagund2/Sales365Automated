package com.utility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.testbase.TestBase;
import com.aventstack.extentreports.Status;
//import com.extentreport.ExtentManager;
//import com.extentreport.ExtentTestManager;

public class ListnerTest extends TestBase implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
		//ExtentTestManager.startTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
		//ExtentTestManager.getTest().log(Status.PASS, "Test passed");
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		try {
			capture(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
		//ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
		//ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("*** Test Suite " + context.getName() + " started ***");
		System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
		//ExtentTestManager.endTest();
	//	ExtentManager.getInstance().flush();
	//	ExtentManager.createInstance().flush();
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
