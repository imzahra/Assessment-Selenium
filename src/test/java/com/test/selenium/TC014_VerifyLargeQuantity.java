package com.test.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC014_VerifyLargeQuantity {
    private WebDriver driver;
    private AddToCart addToCart;
    private ViewCart viewCart;
    private ModifyCart modifyCart;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();

        addToCart = new AddToCart(driver);
        viewCart = new ViewCart(driver);
        modifyCart = new ModifyCart(driver);

    }

    @Test
    public void testAddToCart() {
        driver.get("https://www.periplus.com/");

        addToCart.searchProduct("1989 the Berlin Wall: My Part in Its Downfall");
        addToCart.selectFirstProduct();
        addToCart.addToCart();
        viewCart.clickCartIcon();
        modifyCart.increaseQuantity(99);
        modifyCart.updateCart();
        String quantityValue = modifyCart.getQuantity();
        Assert.assertEquals(quantityValue, "100", "Quantity did not update correctly.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
