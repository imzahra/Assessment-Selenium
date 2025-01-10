package com.test.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC009_VerifyTotalPrice {
    private WebDriver driver;
    private AddToCart addToCart;
    private ViewCart viewCart;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();

        addToCart = new AddToCart(driver);
        viewCart = new ViewCart(driver);

    }

    @Test
    public void testAddToCart() {
        driver.get("https://www.periplus.com/");

        addToCart.searchProduct("1989 the Berlin Wall: My Part in Its Downfall");
        addToCart.selectFirstProduct();
        addToCart.addToCartLong();


        addToCart.searchProduct("How to Do the Work: Recognize Your Patterns, Heal from Your Past, and Create Your Self");
        addToCart.selectSecondProduct();
        addToCart.addToCartLong();
        viewCart.clickCartIcon();

        String totalAmountText = driver.findElement(By.id("sub_total")).getText().replace("Rp", "").replace(",", "").trim();
        int totalAmount = Integer.parseInt(totalAmountText);
        int expectedTotal = 284000 + 710000;
        Assert.assertEquals(totalAmount, expectedTotal, "The total amount in the cart is incorrect.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
