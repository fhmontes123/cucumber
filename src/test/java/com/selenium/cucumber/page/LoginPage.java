package com.selenium.cucumber.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.selenium.cucumber.driver.DriverFactory.getDriver;

public class LoginPage {

    private WebDriver driver = getDriver();
    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By btnIngresar = By.xpath("//button[@type='submit']");
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    // CONSTRUCTOR
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // METODOS
    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickOnLoginButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnIngresar));
        driver.findElement(btnIngresar).click();
    }

    public WebElement getUsernameField() {
        return driver.findElement(usernameField);
    }

    public WebElement getPasswordField() {
        return driver.findElement(passwordField);
    }

    public String getLoginButtonText() {
        return driver.findElement(btnIngresar).getText();
    }

}
