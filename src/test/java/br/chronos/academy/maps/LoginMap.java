package br.chronos.academy.maps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginMap {

    public LoginMap(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // ===== CAMPOS DE LOGIN =====

    @FindBy(css = "input[data-qa='login-email']")
    public WebElement inpUserName;

    @FindBy(css = "input[data-qa='login-password']")
    public WebElement inpPassword;

    // (Automation Exercise NÃO tem remember,
    // mas o Page espera, então criamos)
    @FindBy(id = "remember")
    public WebElement inpRemember;

    // Botão Login
    @FindBy(css = "button[data-qa='login-button']")
    public WebElement btnLogin;

    // ===== ELEMENTOS DE MODAL (mockados para compatibilidade) =====

    @FindBy(className = "close")
    public WebElement btnFechar;

    @FindBy(css = ".modal-backdrop")
    public WebElement divFecharModal;

    // ===== BOTÃO SIGN IN (erro de nome mantido de propósito) =====
    @FindBy(css = "button[data-qa='login-button']")
    public WebElement btnSingin;
}