package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class ExtentReporterNG {
    static ExtentReports extent;


    public static ExtentReports getReportObjects() {
        // File useDirectory  = org.apache.commons.io.FileUtils.getUserDirectory();
        //String path = System.getProperty("user.dir") + "\\reports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter("report.html");
        reporter.config().setReportName("PP results");  // set the name of the report
        reporter.config().setDocumentTitle("Test results");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Saroj Thapa");
        return extent;
    }
/*
    @Test
    public void initialDemo() {
        extent.createTest("testName");
        // pass the driver elements
        System.setProperty("webdriver.chrome.driver", "/Users/sarojthapa/Documents/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://parcelpoint.com.au/");
        extent.flush();
    }*/
}