package br.chronos.academy.pages;

import br.chronos.academy.maps.CursoMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CursoWeb {
    WebDriver driver;
    CursoMap cursoMap;

    public CursoWeb(WebDriver driver) {
        this.driver = driver;
        cursoMap = new CursoMap();
        PageFactory.initElements(driver, cursoMap);
    }

    public String getTitulo2() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait
                .until(ExpectedConditions.visibilityOf(cursoMap.txttitulo))
                .getText();
    }
}
