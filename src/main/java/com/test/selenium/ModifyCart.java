package com.test.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ModifyCart {
    private WebDriver driver;
    private WebDriverWait wait;

    private By increaseQuantityButton = By.cssSelector("button[name='plus[31727083]']");
    private By quantityInput = By.cssSelector("input[name='quantity[31727083]']");
    private By updateButton = By.cssSelector("input[type='submit'][value='Update']");

    public ModifyCart(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void increaseQuantity(int times) {
        WebElement increaseButton = wait.until(ExpectedConditions.elementToBeClickable(increaseQuantityButton));
        for (int i = 0; i < times; i++) {
            increaseButton.click();
        }
    }

    public String getQuantity() {
        WebElement quantityField = wait.until(ExpectedConditions.visibilityOfElementLocated(quantityInput));
        return quantityField.getAttribute("value");
    }

    public void updateCart() {
        WebElement updateCartButton = wait.until(ExpectedConditions.elementToBeClickable(updateButton));
        updateCartButton.click();
    }
}
