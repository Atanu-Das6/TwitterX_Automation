package Utill;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ExtentReporter implements ITestListener {
    private ExtentReports extentReports;
    private ExtentTest extentTest;

    @Override
    public void onStart(ITestContext context) {
        extentReports = ExtentTestManager.getInstance();
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        extentTest = extentReports.createTest(result.getMethod().getMethodName());
        extentTest.assignCategory(result.getTestClass().getName()); // Assign category based on test class
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.log(Status.PASS, result.getMethod().getDescription());
        extentTest.log(Status.PASS, "Test Passed");
    }
    public void onTestFailure(ITestResult result) {
        extentTest.log(Status.FAIL, "Test Failed");
        extentTest.log(Status.FAIL, result.getThrowable());
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.log(Status.SKIP, result.getMethod().getDescription());
        extentTest.log(Status.SKIP, "Test Skipped");
    }

}