package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    public WebDriver driver;

   By email = By.xpath("//input[@id='email']");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getEmail(){
       return driver.findElement(email);
   }
   By password = By.xpath("//input[@id='password']");

    public WebElement getPassword(){
        return driver.findElement(password);
    }
    By signIn = By.xpath("//button[@type='submit']");
    public WebElement getsignIn(){
        return driver.findElement(signIn);
    }
    By showmore = By.xpath("//div[@class='expandable-expander flex items-center light-gray']");

    public WebElement clickShowMore(){
        return driver.findElement(showmore);
    }
    By tools = By.xpath("//span[normalize-space()='Tools']");
    public  WebElement clickTools(){
        return driver.findElement(tools);
    }
    By pActions = By.xpath("(//div[@class='listing-item-title truncate'])[8]");
    public WebElement clickParcelActions(){
        return driver.findElement(pActions);
    }

    By entPcode = By.cssSelector("textarea[class='ant-input textinput-component__textarea']");
    public WebElement enterPcode(){
        return driver.findElement(entPcode);

    }
    By title = By.xpath("//h2[normalize-space()='Tools']");
    public WebElement pgTitle(){
        return driver.findElement(title);
    }

}
