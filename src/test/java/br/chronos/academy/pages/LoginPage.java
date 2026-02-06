package br.chronos.academy.pages;

import br.chronos.academy.core.Driver;
import br.chronos.academy.maps.LoginMap;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    LoginMap loginMap;

    public LoginPage() {
        this.driver = Driver.getDriver();
        loginMap = new LoginMap(driver);
    }

    public void preencherLogin(String email, String password) {
        Driver.visibilityOf(loginMap.inpUserName);
        loginMap.inpUserName.clear();
        loginMap.inpUserName.sendKeys(email);

        Driver.visibilityOf(loginMap.inpPassword);
        loginMap.inpPassword.clear();
        loginMap.inpPassword.sendKeys(password);
    }

    public void clickBtnLogin() {
        Driver.visibilityOf(loginMap.btnLogin);
        loginMap.btnLogin.click();
    }

    public String getMsgErroLogin() {
        Driver.visibilityOf(loginMap.msgErroLogin);
        return loginMap.msgErroLogin.getText();
    }

    public boolean loginRealizadoComSucesso() {
        Driver.visibilityOf(loginMap.txtUsuarioLogado);
        return loginMap.txtUsuarioLogado.isDisplayed();
    }
}