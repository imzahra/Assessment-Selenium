package com.test.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCart {
    private WebDriver driver;
    private WebDriverWait wait;

    private By searchBox = By.id("filter_name");
    private By searchButton = By.cssSelector("button.btnn[type='submit']");
    private By addToCartButton = By.cssSelector("button.btn.btn-add-to-cart");
    private By preloader = By.cssSelector(".preloader");

    private By firstProduct = By.cssSelector(".product-img a[href*='1989-the-berlin-wall-my-part-in-its-downfall']");
    private By secondProduct = By.cssSelector(".product-img a[href*='how-to-do-the-work-recognize-your-patterns-heal-from-your-past-and-create-your-self']");
    private By thirdProduct = By.cssSelector(".product-img a[href*='wells-fargo-and-danger-station']");
    private By unavailableProduct = By.cssSelector(".product-img a[href*='rules-of-the-road-for-entrepreneurs']");

    public AddToCart(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void searchProduct(String productName) {
        waitForPreloaderToDisappear();
        WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(searchBox));
        searchField.clear();
        searchField.sendKeys(productName);
        driver.findElement(searchButton).click();
    }

    public void waitForPreloaderToDisappear() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(preloader));
    }

    public void selectProduct(By productLocator) {
        waitForPreloaderToDisappear();
        WebElement productElement = wait.until(ExpectedConditions.elementToBeClickable(productLocator));
        productElement.click();
    }

    public void selectFirstProduct() {
        selectProduct(firstProduct);
    }

    public void selectSecondProduct() {
        selectProduct(secondProduct);
    }

    public void selectThirdProduct() {
        selectProduct(thirdProduct);
    }

    public void selectUnavailableProduct() {
        selectProduct(unavailableProduct);
    }


    public void addToCart() {
        waitForPreloaderToDisappear();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        cartButton.click();
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    

    public void addToCartLong() {
        waitForPreloaderToDisappear();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        cartButton.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

    
