package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class bookAReturnPage {
    public WebDriver driver;
    By clickBook = By.xpath("//a[normalize-space()='Book A Return']");

    public bookAReturnPage (WebDriver driver){
        this.driver=driver;
    }
public WebElement clickBookReturn(){
     return driver.findElement(clickBook);
}
By chooseRetailer= By.xpath("//h3[normalize-space()='Choose your retailer']");
public WebElement chooseYourRetailer(){
    return driver.findElement(chooseRetailer);
}
By searchRetailer= By.cssSelector("input[placeholder='Search for your retailer']");
public WebElement searchByRetailer(){
    return driver.findElement(searchRetailer);
}
By search = By.xpath("//button[@class='button-pp button-primary']//img");
public WebElement searchretailer(){
    return driver.findElement(search);
}
By retailerName = By.cssSelector("img[src='/a/logo-retailer?id=133']");
public WebElement returnRetailer(){
    return driver.findElement(retailerName);
}
By bookreturn = By.xpath("//a[@id='determineProcess']");
public WebElement bookAReturn(){
    return driver.findElement(bookreturn);
}
By ppLocation = By.xpath("(//button[@type='button'])[2]");
public WebElement selectPpLocation(){
    return driver.findElement(ppLocation);
}
By next = By.xpath("//button[@id='parcelPointSubmitButton']");
public WebElement Next(){
    return driver.findElement(next);
}
By orderID = By.xpath("//input[@id='order-number-returns']");
public WebElement AAUID(){
    return driver.findElement(orderID);
}
By staticDropdown= By.xpath("//select[@id='retailerReturnsReasonsId']");
public WebElement selectByststicDropdown(){
    return  driver.findElement(staticDropdown);
}
By addDet = By.xpath("//textarea[@id='retailerAdditionalDetails']");
public WebElement ByadditionalDetails(){
    return driver.findElement(addDet);
}
By name = By.xpath("//input[@id='delivery-name-createAccount']");
public WebElement enterName(){
    return driver.findElement(name);
}
By email = By.xpath("//input[@id='delivery-email-createAccount']");
public WebElement enterEmail(){
    return driver.findElement(email);
}
By ph = By.xpath("//input[@id='delivery-mobile-createAccount']");
public WebElement enterMobile(){
    return driver.findElement(ph);
}
By ConfirmNext= By.xpath("//button[@id='submitReturnsForm']");
public WebElement confirm(){
    return driver.findElement(ConfirmNext);
}
By returnOrderId =By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(2) > p:nth-child(2)");
public WebElement OrderDetails(){
    return driver.findElement(returnOrderId);
}
By tracking = By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(2) > p:nth-child(3)");
public WebElement PpTrackingID(){
    return driver.findElement(tracking);
}
}
