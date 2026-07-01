package com.selenium.cucumber.driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

// Fabrica de WebDrivers
public class DriverFactory {
    // ThreadLocal almacena una instancia de WebDriver por cada hilo de ejecución
    // Esto evita conflictos entre pruebas que se ejecutan en paralelo
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    // Obtiene el WebDriver para el hilo actual.
    public static WebDriver getDriver() {
        // Verificar si el hilo actual ya tiene un driver
        if (webDriver.get() == null) {
            // Si no tiene, crear uno nuevo y guardarlo
            webDriver.set(createDriver());
        }
        return webDriver.get();
    }

    // Crea y configura una nueva instancia de ChromeDriver.
    private static WebDriver createDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        // Establecer estrategia de carga: NORMAL espera que la página cargue completamente
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        return driver;
    }

    // Limpia y cierra el WebDriver para el hilo actual.
    public static void cleanupDriver() {
        if (webDriver.get() != null) {
            webDriver.get().quit();
            webDriver.remove();
        }
    }

}
