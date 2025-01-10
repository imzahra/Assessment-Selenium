package com.test.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RemoveCart {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By preloader = By.cssSelector(".preloader");
    private By removeButton = By.cssSelector("a.btn.btn-cart-remove");

    public RemoveCart(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitForPreloaderToDisappear() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(preloader));
    }

    public void clickRemoveButton() {
        waitForPreloaderToDisappear();
        WebElement removeElement = wait.until(ExpectedConditions.elementToBeClickable(removeButton));
        removeElement.click();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
