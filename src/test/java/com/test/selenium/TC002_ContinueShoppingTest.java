package com.test.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC002_ContinueShoppingTest {
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

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.periplus.com/_index_/index", "URL after continue shopping is incorrect.");


        addToCart.searchProduct("How to Do the Work: Recognize Your Patterns, Heal from Your Past, and Create Your Self");
        addToCart.selectSecondProduct();
        addToCart.addToCart();

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
