package br.chronos.academy.automacaoWeb;

import br.chronos.academy.core.Driver;
import br.chronos.academy.pages.CursoWeb;
import br.chronos.academy.pages.PrincipalPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;


class TestWeb {

    WebDriver driver;
    Driver driverWeb;
    PrincipalPage principalPage;
    CursoWeb cursoWeb;


    @BeforeEach
    public void inicializateste(){
        driverWeb = new Driver( "chrome");
        driver = driverWeb.getDriver();
        driver.get("https://www.chronosacademy.com.br");
        principalPage = new PrincipalPage(driver);
    }

    @Test
    public void primerioteste(){
        assertEquals("Porque Tempo É Conhecimento.", principalPage.getString());
    }

    @Test
    public void segundoTest() {
        principalPage.clickBotao();
        cursoWeb = new CursoWeb(driver);
        assertEquals("Conheça todos os nossos cursos.", cursoWeb.getTitulo2());
    }

    @AfterEach
    public void finalizateste(){
        driver.quit();
    }
}
