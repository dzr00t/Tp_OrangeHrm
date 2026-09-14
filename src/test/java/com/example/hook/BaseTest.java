package com.example.hook;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.example.POM.HomePage;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BaseTest {
    public static WebDriver driver;
    public static HomePage homepage;

    @Before
    public void setUp() {
        URL gridUrl = null;
        try {
            gridUrl = new URL("http://selenium-hub:4444/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--start-maximized");
        driver = new RemoteWebDriver(gridUrl, option);
        homepage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;

        }
    }

}