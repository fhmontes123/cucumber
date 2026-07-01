package com.selenium.cucumber.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {

    @Given("el usuario accede a la plataforma")
    public void el_usuario_accede_a_la_plataforma() {
        System.out.println("Paso 1: El usuario accede a la plataforma");
    }

    @When("agregar usuario correcto")
    public void agregar_usuario_correcto() {
        System.out.println("Paso 2: Agregar usuario correcto");
    }

    @When("agregar password correcto")
    public void agregar_password_correcto() {
        System.out.println("Paso 3: Agregar password correcto");
    }

    @Then("iniciar sesion a la plataforma")
    public void iniciar_sesion_a_la_plataforma() {
        System.out.println("Paso 4: Iniciar sesion en la plataforma");
    }
}
