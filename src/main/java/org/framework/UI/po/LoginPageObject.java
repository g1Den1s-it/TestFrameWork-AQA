package org.framework.UI.po;

import org.framework.UI.wrappers.Decorator;
import org.framework.UI.wrappers.Element;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.framework.Drivers.DriverHelper.driver;

public class LoginPageObject {
    @FindBy(id = "identifierId")
    private Element emailInput;
    @FindBy(xpath = "//button[@class=\"VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 qIypjc TrZEUc lw1w4b\"]")
    private Element nextButton;
    @FindBy(xpath = "//*[@id=\"password\"]/div[1]/div/div[1]/input")
    private Element passwordInput;
    public LoginPageObject() {
        PageFactory.initElements(new Decorator(driver), this);
    }
    public void inputEmail(String email){
        emailInput.getWebElement().sendKeys(email);
        nextButton.getWebElement().click();
    }
    public void inputPassword(String password){
        passwordInput.getWebElementAndWait().sendKeys(password);
        nextButton.getWebElement().click();
    }
}
