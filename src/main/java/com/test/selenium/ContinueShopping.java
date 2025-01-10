package com.test.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class ContinueShopping {
    private WebDriver driver;
    private WebDriverWait wait;

    private By continueShoppingButton = By.cssSelector(".btn.text-white");

    public ContinueShopping(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }




    public void clickContinueShopping() {
        WebElement continueShoppingElement = wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
            continueShoppingElement.click();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
