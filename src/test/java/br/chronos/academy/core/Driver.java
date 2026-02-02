package br.chronos.academy.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver {
    private WebDriver driver;

    public Driver(String navegador) {
            switch (navegador){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions options = new EdgeOptions();
                    driver = new EdgeDriver(options);
                    break;
                default:
                    throw new IllegalArgumentException("Navegador não suportado: " + navegador);
            }

        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;

    }
}
