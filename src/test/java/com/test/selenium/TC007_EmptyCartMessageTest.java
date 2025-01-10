package com.test.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC007_EmptyCartMessageTest {
    private WebDriver driver;
    private ViewCart viewCart;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        viewCart = new ViewCart(driver);

    }

    @Test
    public void testAddToCart() {
        driver.get("https://www.periplus.com/");
        viewCart.clickCartIcon();
        String emptyCartMessage = driver.findElement(By.cssSelector(".content")).getText();
        Assert.assertEquals(emptyCartMessage, "Your shopping cart is empty", "The cart is not empty after removing the product.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }}
