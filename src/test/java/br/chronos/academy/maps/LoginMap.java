package br.chronos.academy.maps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginMap {

    public LoginMap(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // -------- LOGIN (já cadastrado) --------

    @FindBy(css = "input[data-qa='login-email']")
    public WebElement inpUserName;

    @FindBy(css = "input[data-qa='login-password']")
    public WebElement inpPassword;

    @FindBy(css = "button[data-qa='login-button']")
    public WebElement btnLogin;

    // -------- MENSAGENS / VALIDAÇÕES --------

    @FindBy(css = "p[style='color: red;']")
    public WebElement msgErroLogin;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")
    public WebElement txtUsuarioLogado;

}