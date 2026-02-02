package br.chronos.academy.maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CursoMap {

    @FindBy(xpath = "//*[@id='block-214']//div[contains(@class,'large-h1')]")
    public WebElement txttitulo;

}
