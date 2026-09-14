package com.example.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    public static final String URL = "https://opensource-demo.orangehrmlive.com/";

    
    private By username = By.name("username");
    private By password = By.name("password");
    private By btn_login = By.cssSelector(".orangehrm-login-button");   
    private By cadron_MyActions = By.xpath("//p[text()='My Actions']");
    private By cadron_QuickLaunch = By.xpath("//p[text()='Quick Launch']");




    public HomePage(WebDriver driver){
        this.driver = driver ; 
    }


    public void login(String name,String pass){
        driver.findElement(username).sendKeys(name);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(btn_login).click();
    }
    public boolean isMyActionsDisplayed(){
        return driver.findElement(cadron_MyActions).isDisplayed();
    }

    public boolean isQuickLaunchDisplayed(){
        return driver.findElement(cadron_QuickLaunch).isDisplayed();
    }
}
