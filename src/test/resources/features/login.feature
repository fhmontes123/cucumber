@regression
Feature: Login
  Scenario: Acceso a login
    Given el usuario accede a la plataforma
    When agregar usuario correcto
    And agregar password correcto
    Then iniciar sesion a la plataforma