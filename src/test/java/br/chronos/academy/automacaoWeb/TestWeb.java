package br.chronos.academy.automacaoWeb;

import br.chronos.academy.core.Driver;
import br.chronos.academy.enums.Browser;
import br.chronos.academy.pages.CursoWeb;
import br.chronos.academy.pages.PrincipalPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestWeb {

    private WebDriver driver;
    private Driver driverWeb;
    private PrincipalPage principalPage;
    private CursoWeb cursoWeb;

    @BeforeEach
    void inicializaTeste() {
        driverWeb = new Driver(Browser.CHROME);
        driver = driverWeb.getDriver();
        driver.get("https://www.chronosacademy.com.br");
        principalPage = new PrincipalPage(driver);
    }

    @Test
    void primeiroTeste() {
        assertEquals("Porque Tempo É Conhecimento.", principalPage.getString());
    }

    @Test
    void segundoTeste() {
        principalPage.clickBotao();
        cursoWeb = new CursoWeb(driver);
        assertEquals("Conheça todos os nossos cursos.", cursoWeb.getTitulo2());
    }

    @AfterEach
    void finalizaTeste() {
        if (driver != null) {
            driver.quit();
        }
    }
}
