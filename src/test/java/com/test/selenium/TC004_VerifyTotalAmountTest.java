package com.test.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC004_VerifyTotalAmountTest {
    private WebDriver driver;
    private AddToCart addToCart;
    private ViewCart viewCart;
    private ContinueShopping continueShopping;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();

        addToCart = new AddToCart(driver);
        viewCart = new ViewCart(driver);
        continueShopping = new ContinueShopping(driver);

    }

    @Test
    public void testAddToCart() {
        driver.get("https://www.periplus.com/");

        addToCart.searchProduct("1989 the Berlin Wall: My Part in Its Downfall");
        addToCart.selectFirstProduct();
        addToCart.addToCart();

        viewCart.clickCartIcon();
        continueShopping.clickContinueShopping();

        addToCart.searchProduct("How to Do the Work: Recognize Your Patterns, Heal from Your Past, and Create Your Self");
        addToCart.selectSecondProduct();
        addToCart.addToCart();
        viewCart.clickCartIcon();

        List<WebElement> cartItems = driver.findElements(By.cssSelector(".row-cart-product")); // Locate all products in the cart
        int actualTotalItems = cartItems.size();
        int expectedTotalItems = 2;
        Assert.assertEquals(actualTotalItems, expectedTotalItems, "The total number of items in the cart is incorrect.");
    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
