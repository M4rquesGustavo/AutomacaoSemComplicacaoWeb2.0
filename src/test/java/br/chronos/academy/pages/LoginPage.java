package br.chronos.academy.pages;

import br.chronos.academy.maps.LoginMap;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    LoginMap loginMap;

    public LoginPage() {
        this.driver = driver;
        loginMap = new LoginMap(driver);
    }

    public void clickBtnFechar() {
        loginMap.btnFechar.click();
    }

    public void clickDivFecharModal() {
        loginMap.divFecharModal.click();
    }

    public void setInpUserName(String username) {
        loginMap.inpUserName.sendKeys(username);
    }

    public void setInpPassword(String password) {
        loginMap.inpPassword.sendKeys(password);
    }

    public void clickInpRemember() {
        loginMap.inpRemember.click();
    }

    public void clickBtnLogin() {
        loginMap.btnLogin.click();
    }

    public boolean isBtnSingIn() {loginMap.btnSingin.click();
    }
}
