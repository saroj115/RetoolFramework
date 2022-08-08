package Resources;

import org.apache.commons.io.FileUtils;
import org.apache.xmlbeans.impl.xpath.Path;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public WebDriver driver;
   public Properties prop;
    public WebDriver initializeDriver() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream("/Users/sarojthapa/Documents/Intellij projects/RetoolFramework/src/main/java/Resources/data.properties");
        prop.load(fis);
        String browserName = prop.getProperty("browser");
        if(browserName.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver","/Users/sarojthapa/Documents/chromedriver");
             driver  = new ChromeDriver();
        } else if (browserName.equals("firefox"))
        {
            driver = new FirefoxDriver();
            //execute in firefox
            
        } else if(browserName.equals("IE"))
        {
            driver = new InternetExplorerDriver();
            //ececute in nternet explorer
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver;
    }
    public String getScreenShot(String testCaseName, WebDriver driver) throws IOException{
        TakesScreenshot ts= (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destinationpath = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
        FileUtils.copyFile(source, new File(destinationpath));
        return destinationpath;


    }


}
