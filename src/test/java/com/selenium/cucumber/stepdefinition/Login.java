package com.selenium.cucumber.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {

    @Given("el usuario accede a la plataforma")
    public void el_usuario_accede_a_la_plataforma() {
        System.out.println("Paso 1: el_usuario_accede_a_la_plataforma");
    }

    @When("agrega usuario correcto")
    public void agrega_usuario_correcto() {
        System.out.println("Paso 2: agrega_usuario_correcto");
    }

    @When("agrega password correcto")
    public void agrega_password_correcto() {
        System.out.println("Paso 3: agrega_password_correcto");
    }

    @Then("inicia sesion a la plataforma")
    public void inicia_sesion_a_la_plataforma() {
        System.out.println("Paso 4: inicia_sesion_a_la_plataforma");
    }
}
