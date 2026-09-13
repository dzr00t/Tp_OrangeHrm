package com.example.hook;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.example.POM.HomePage;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BaseTest {
public static WebDriver driver;
public static HomePage homepage;


@Before 
public void setUp(){
    ChromeOptions option = new ChromeOptions();
    option.addArguments("--start-maximized");
    driver = new ChromeDriver();
    homepage = new HomePage(driver);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

}

@After 
public void tearDown(){
    if (driver != null) {
        driver.quit();
        driver = null;
        
    }
}

    
}