package br.chronos.academy.steps;

import br.chronos.academy.core.Driver;
import br.chronos.academy.enums.Browser;
import br.chronos.academy.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Entao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

public class LoginSteps {

    private LoginPage loginPage;

    // -------------------------
    // SETUP / TEARDOWN
    // -------------------------

    @Before
    public void iniciarNavegador() {
        new Driver(Browser.CHROME);
    }

    @After
    public void fecharNavegador() {
        Driver.getDriver().quit();
    }

    // -------------------------
    // CONTEXTO
    // -------------------------

    @Dado("que o usuario esteja na pagina principal")
    public void que_o_usuario_esteja_na_pagina_principal() {
        Driver.getDriver().get("https://automationexercise.com/login");
        loginPage = new LoginPage();
    }

    // -------------------------
    // ACOES
    // -------------------------

    @Quando("os campos de login forem preenchidos com dados validos:")
    @Quando("os campos de login forem preenchidos com dados invalidos:")
    public void preencherCamposLogin(DataTable dataTable) {
        Map<String, String> dados = dataTable.asMap(String.class, String.class);
        loginPage.preencherLogin(dados.get("email"), dados.get("password"));
    }

    @Quando("for realizado um clique no botao Login")
    public void clicarNoBotaoLogin() {
        loginPage.clickBtnLogin();
    }

    // -------------------------
    // VALIDACOES
    // -------------------------

    @Entao("o usuario deve ser autenticado com sucesso")
    public void usuarioAutenticadoComSucesso() {
        assertTrue(loginPage.loginRealizadoComSucesso());
    }

    @Entao("o sistema deve exibir uma mensagem de erro de autenticacao")
    public void sistemaExibeMensagemDeErro() {
        String mensagem = loginPage.getMsgErroLogin();
        assertTrue(mensagem.contains("Your email or password is incorrect!"));
    }
}