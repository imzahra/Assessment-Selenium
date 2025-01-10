package com.test.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ViewCart {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By preloader = By.cssSelector(".preloader");
    private By cartIcon = By.id("show-your-cart");

    public ViewCart(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitForPreloaderToDisappear() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(preloader));
    }

    public void clickCartIcon() {
        waitForPreloaderToDisappear();
        WebElement cartElement = wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
        cartElement.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
