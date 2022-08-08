import Resources.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjectModel.bookAReturnPage;
import org.apache.logging.log4j.LogManager;

import java.io.IOException;

public class bookAReturn extends Base {
    public static Logger log = LogManager.getLogger(bookAReturn.class.getName());
    @BeforeTest
    public void openZip()throws IOException{
        driver = initializeDriver();
        log.info("Driver Initialized");

        driver.get(prop.getProperty("url2"));
        log.info("URL tearing down");
    }
    @Test
    public  void bookAReturnParcel() {

        bookAReturnPage brp = new bookAReturnPage(driver);
        brp.clickBookReturn().click();
       // Assert.assertEquals(brp.chooseYourRetailer(),"Choose your retailer");

        brp.searchByRetailer().sendKeys("adidas");
        brp.searchretailer().click();
        brp.returnRetailer().click();
        brp.bookAReturn().click();
        brp.selectPpLocation().click();
        brp.Next().click();
        brp.AAUID().sendKeys(prop.getProperty("AUUID"));

        WebElement staticDropdown = brp.selectByststicDropdown();
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByIndex(8);

        System.out.println(dropdown.getFirstSelectedOption().getText());
        brp.ByadditionalDetails().sendKeys((prop.getProperty("additionalDetaiils")));

        System.out.println(prop.getProperty("additionalDetaiils"));
        brp.enterName().sendKeys(prop.getProperty("Name"));

        brp.enterEmail().sendKeys(prop.getProperty("Email"));

        brp.enterMobile().sendKeys(prop.getProperty("Mobile"));

        brp.confirm().click();

        System.out.println(brp.OrderDetails().getText());
        System.out.println(brp.PpTrackingID().getText());


    }
    @AfterTest
    public void teardown(){
        driver.close();
    }


}
