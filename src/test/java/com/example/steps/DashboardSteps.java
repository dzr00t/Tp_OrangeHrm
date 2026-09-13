package com.example.steps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;

import com.example.POM.HomePage;
import com.example.hook.BaseTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DashboardSteps {
    WebDriver driver = BaseTest.driver ;
    HomePage homePage = BaseTest.homepage ;


    @Given("Aller sur la page de connexion OrangeHRM")
    public void Aller_sur_la_page_de_connexion_OrangeHRM() {
        driver.get(HomePage.URL);

    }

    @When("je saisis lidentifiant {string} et le mot de passe {string}")
    public void je_saisis_lidentifiant_et_le_mot_de_passe(String username, String password) {
        homePage.login(username, password);
    }


    @Then("je suis automatiquement dirige vers mon dashboard")
    public void je_suis_automatiquement_dirige_vers_mon_dashboard() {
        assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }

    @Then("je vois le cadran {string}")
    public void je_vois_le_cadran(String s) {
        switch (s) {
            case "My Actions":
                assertTrue(homePage.isMyActionsDisplayed());          
                break;
            case "Quick Launch":
                assertTrue(homePage.isQuickLaunchDisplayed());
                break;          
            default: 
                throw new IllegalArgumentException("Cadran non implémenté dans le test : " + s);
        }

    }




}
