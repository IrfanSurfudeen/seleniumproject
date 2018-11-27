package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class guru99login {
    WebDriver driver;
    By userName = By.name("uid");
    By password = By.name("password");
    By loginbtn = By.name("btnLogin");

    public guru99login(WebDriver driver){
        this.driver=driver;
    }

    public void setUserName(String strUserName){
        driver.findElement(userName).sendKeys(strUserName);
    }

    public void setPassword(String strPassword){
        driver.findElement(password).sendKeys(strPassword);
    }
    public void clickLogin(){
        driver.findElement(loginbtn).click();
    }

    public void logintoguru99(String strUserName,String strPassword){
        this.setUserName(strUserName);
        this.setPassword(strPassword);
        this.clickLogin();
    }
}