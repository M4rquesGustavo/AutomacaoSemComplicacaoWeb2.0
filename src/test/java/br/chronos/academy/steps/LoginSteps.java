package br.chronos.academy.steps;

import br.chronos.academy.core.Driver;
import br.chronos.academy.maps.LoginMap;
import br.chronos.academy.pages.LoginPage;
import dev.failsafe.internal.util.Assert;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;

import java.util.Map;

public class LoginSteps {
    LoginPage loginPage;

    @Before
    public void iniciaNavegador(){
        new Driver("chrome");
    }

    @After
    public void fecharNavegador(){
        Driver.getDriver().quit();
    }

    @Dado("que a modal de login esteja sendo exibida")
    public void que_a_modal_de_login_esteja_sendo_exibida() {
        System.out.println("Modal de login exibida");
        Driver.getDriver().get("https://automationexercise.com/");
        loginPage = new LoginPage();
        loginPage.clickBtnLogin();
    }

    @Quando("for realizado o clique fora da modal")
    public void for_realizado_o_clique_fora_da_modal() {
        System.out.println("Clique fora da modal");
        loginPage.clickDivFecharModal();
    }

    @Quando("for realizado o clique no ícone de fechar")
    public void for_realizado_o_clique_no_icone_de_fechar() {
        System.out.println("Clique no ícone fechar");
        loginPage.clickBtnFechar();
    }

    @Então("a janela modal deve ser fechada")
    public void a_janela_modal_deve_ser_fechada() {
        System.out.println("Modal fechada");
    }

    @Quando("for realizado um clique no link Create New Account")
    public void for_realizado_um_clique_no_link_create_new_account() {
        System.out.println("Clique em Create New Account");
    }

    @Então("a página de criação de conta deve ser exibida")
    public void a_pagina_de_criacao_de_conta_deve_ser_exibida() {
        System.out.println("Página de criação exibida");
    }

    @Quando("os campos de login forem preenchidos com dados válidos:")
    public void os_campos_de_login_forem_preenchidos_com_dados_validos(DataTable dataTable) {

        System.out.println("Preenchendo campos com dados válidos");

        Map<String, String> map = dataTable.asMap(String.class, String.class);

        String username = map.get("login");
        String password = map.get("password");
        boolean remember = Boolean.parseBoolean(map.get("remember"));

        loginPage.setInpUserName(username);
        loginPage.setInpPassword(password);

        if(remember) loginPage.clickInpRemember();
    }

    @Quando("os campos de login forem preenchidos com dados inválidos:")
    public void os_campos_de_login_forem_preenchidos_com_dados_invalidos(DataTable dataTable) {
        System.out.println("Preenchendo campos com dados inválidos");
        System.out.println(dataTable.asMaps());
    }

    @Quando("for realizado um clique no botão Sign In")
    public void for_realizado_um_clique_no_botao_sign_in() {
        System.out.println("Clique no botão Sign In");
    }

    @Então("o usuário deve ser autenticado com sucesso")
    public void o_usuario_deve_ser_autenticado_com_sucesso() {
        System.out.println("Usuário autenticado");
        loginPage.isBtnSingIn();
    }

    @Então("o sistema deve exibir uma mensagem de erro de autenticação")
    public void o_sistema_deve_exibir_uma_mensagem_de_erro() {
        System.out.println("Mensagem de erro exibida");
    }

    @Quando("nenhum campo obrigatório for preenchido")
    public void nenhum_campo_obrigatorio_for_preenchido() {
        System.out.println("Campos obrigatórios não preenchidos");
    }

    @Então("o botão Sign In deve permanecer desabilitado")
    public void o_botao_sign_in_deve_permanecer_desabilitado() {
        System.out.println("Botão Sign In desabilitado");
        boolean enabled = loginPage.isBtnSingIn();
        Assert.assertFalse(enabled);

    }
}
