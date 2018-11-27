package test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.guru99login;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class Testguru99login {
    public static WebDriver driver;
    guru99login objLogin;
/*
guru 99
userid: mngr162137
password: gujatUn
*/

@BeforeTest
    public void setup(){
    System.setProperty("webdriver.chrome.driver","C:\\Users\\irfan\\Downloads\\chromedriver.exe");
    driver=new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("http://demo.guru99.com/V4/");
}
@Test
    public void login_invalid(){
    SoftAssert softAssert = new SoftAssert();
    objLogin= new guru99login(driver);
    objLogin.logintoguru99("irfan","surfudeen");
    Alert alert= driver.switchTo().alert();
    assertEquals(alert.getText().toString(),"User or Password is not valid");
    //softAssert.("verify",alert.getText().toString(),"123User or Password is not valid");
    alert.accept();
}
    @Test
    public void login_valid(){
        SoftAssert softAssert = new SoftAssert();
        objLogin= new guru99login(driver);
        objLogin.logintoguru99("mngr162137","gujatUn");
        Boolean homepage = driver.findElement(By.xpath("//*[text()= 'Guru99 Bank']")).isDisplayed();

        softAssert.assertEquals(homepage.booleanValue(),true);
        softAssert.assertAll();
    }
@AfterTest
    public void closeBrowser(){
    driver.close();
}

}
