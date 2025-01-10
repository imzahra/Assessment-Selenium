package com.test.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC010_AddUnavailableProduct {
    private WebDriver driver;
    private AddToCart addToCart;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();

        addToCart = new AddToCart(driver);
    }

    @Test
    public void testAddToCart() {
        driver.get("https://www.periplus.com/");

        addToCart.searchProduct("Rules of the Road for Entrepreneurs");
        addToCart.selectUnavailableProduct();
        addToCart.addToCart();
        String modalText = driver.findElement(By.cssSelector(".modal-text")).getText();
        Assert.assertEquals(modalText, "Your desired qty is not available, approximately 0 stock(s) available in our warehouse.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
