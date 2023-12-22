package Utill;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentTestManager {
    private static ExtentReports extentReports;

    public static synchronized ExtentReports getInstance() {
        if (extentReports == null) {
            extentReports = createExtentReport();
        }
        return extentReports;
    }

    private static ExtentReports createExtentReport() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\reports\\spark.html");
        //System.getProperty("user.dir")+"\\screenshots\\fullscreenREPOST.jpg")
        //"target/extent-report.html
        sparkReporter.config().setReportName("TwitterX Automation Report");
        sparkReporter.config().setDocumentTitle("TwitterX  Extent Report ");


        extentReports = new ExtentReports();
        extentReports.setSystemInfo("OS","WINDOWS");
        extentReports.setSystemInfo("Host Name", "RonoDastan");
        extentReports.setSystemInfo("Environment", "Prod_Public");
        extentReports.setSystemInfo("User Name", "Atanu Das");
        extentReports.attachReporter(sparkReporter);

        return extentReports;
    }
}
