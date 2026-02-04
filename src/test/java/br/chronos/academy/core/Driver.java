package br.chronos.academy.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.exception.ExceptionContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Driver {

    private static WebDriver driver;
    private static WebDriverWait wait;

    public Driver(String navegador) {

        switch (navegador.toLowerCase()) {

            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver(new EdgeOptions());
                break;

            default:
                throw new IllegalArgumentException("Navegador não suportado: " + navegador);
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    public static void visibilityOf(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void invisibilityOf(WebElement element){
        wait.until(ExpectedConditions.invisibilityOf(element));
    }


    public static WebDriver getDriver() {
        return driver;
    }
}
