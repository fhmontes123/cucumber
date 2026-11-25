package com.selenium.cucumber.stepdefinition;

import com.selenium.cucumber.page.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.selenium.cucumber.driver.DriverFactory.getDriver;
import static org.testng.Assert.assertEquals;

public class Login {

    private WebDriver driver = getDriver();
    private LoginPage loginPage;
    private WebDriverWait wait;

    @Given("el usuario accede a la plataforma")
    public void el_usuario_accede_a_la_plataforma() {
        System.out.println("Paso 1: el_usuario_accede_a_la_plataforma");
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        String tituloActual = driver.getTitle();
        assertEquals("OrangeHRM", tituloActual , "Titulo actual " + tituloActual);
    }

    @When("agrega usuario correcto")
    public void agrega_usuario_correcto() {
        System.out.println("Paso 2: agrega_usuario_correcto");
        loginPage.enterUsername("Admin");
        String valorActual = loginPage.getUsernameField().getAttribute("value");
        assertEquals(valorActual, "Admin", "El usuario no coincide");
    }

    @When("agrega password correcto")
    public void agrega_password_correcto() {
        System.out.println("Paso 3: agrega_password_correcto");
        loginPage.enterPassword("admin123");
        String valorActual = loginPage.getPasswordField().getAttribute("value");
        assertEquals(valorActual, "admin123", "El password no coincide");
    }

    @Then("inicia sesion a la plataforma")
    public void inicia_sesion_a_la_plataforma() {
        System.out.println("Paso 4: inicia_sesion_a_la_plataforma");
        loginPage.clickOnLoginButton();
        String urlEsperada = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        wait.until(ExpectedConditions.urlToBe(urlEsperada));
        String urlActual = driver.getCurrentUrl();
        assertEquals(urlActual, urlEsperada, "NO se ha redirigido a la url esperada");
    }
}
