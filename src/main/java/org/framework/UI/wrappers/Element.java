package org.framework.UI.wrappers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import static org.framework.Drivers.DriverHelper.driver;

public class Element {
    private WebElement webElement;
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public Element(WebElement webElement){
        this.webElement = webElement;
    }

    public WebElement getWebElement() {
        return webElement;
    }

    public void setWebElement(WebElement webElement) {
        this.webElement = webElement;
    }

    public WebElement getWebElementAndWait(){
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement;
    }

    public WebElement getWebElementAndWaitBeClickable() {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return webElement;
    }
}