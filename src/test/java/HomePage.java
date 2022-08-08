import Resources.Base;
import dataBase.DbOperations;
import io.opentelemetry.sdk.metrics.data.Data;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UsernameAndPassword;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjectModel.LandingPage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HomePage extends Base {
    @BeforeTest
    public void openZip() throws IOException{
        driver = initializeDriver();
        driver.get(prop.getProperty("url1"));
    }
    @Test(dataProvider = "getData")
    public void loginInout(String Username, String Password) throws SQLException {

        // be aware of null pointer exception ::create a constructor driver
        LandingPage lp = new LandingPage(driver);
        lp.getEmail().sendKeys(Username);
        lp.getPassword().sendKeys(Password);
      //  lp.getEmail().sendKeys("gourab.saha@parcelpoint.com.au");// here can be done by inheritance too
        //lp.getPassword().sendKeys("fQaxa25SgTvJguF");
         lp.getsignIn().click();
         lp.clickShowMore().click();
         lp.clickTools().click();
        Assert.assertEquals(lp.pgTitle().getText(),"Tools");
         lp.clickParcelActions().click();


        DbOperations dbOperations = new DbOperations();
        Connection con = null;
        con = dbOperations.getConnection("Staging");
        Statement s= con.createStatement();
        ResultSet rs = s.executeQuery("select * from parcel where external_id in ( select external_id from automation_parcel) order by  created_on desc limit 4;");
        while (rs.next()) {
            //System.out.println(rs.getString("external_id"));
            // lp.enterPcode().sendKeys(rs.getString("external_id"));
            //System.out.println(rs.getString("external_id"));
            String pcode = rs.getString("external_id");
            String[] parts = pcode.split("p");
            for (int i = 0; i <pcode.length(); i++) {
                pcode = pcode.replace("\n", Keys.chord(Keys.SHIFT, Keys.ENTER));
                lp.enterPcode().sendKeys(pcode);

                System.out.println(pcode);
//\n 
            }


            //String [] parts = pcode.split("p");
            // for(int i=0;i<pcode.length();i++){
            //    System.out.println(parts[i]);
            // }
            // System.out.println(parts);

        }
    }

    @DataProvider
    public Object[][] getData(){
        // row stands for how many different types test shoulr run
        //column stands for hpw many values per each second
        Object[][] userdata= new Object[1][2];
        //0th row
        userdata[0][0]="gourab.saha@parcelpoint.com.au";
        userdata[0][1]="fQaxa25SgTvJguF";
        return  userdata;

    }
@AfterTest
    public void teardown(){
        driver.close();
}

}
