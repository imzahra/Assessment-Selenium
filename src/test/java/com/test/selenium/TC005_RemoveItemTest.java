package com.test.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC005_RemoveItemTest {
    private WebDriver driver;
    private AddToCart addToCart;
    private ViewCart viewCart;
    private RemoveCart removeCart;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();

        addToCart = new AddToCart(driver);
        viewCart = new ViewCart(driver);
        removeCart = new RemoveCart(driver);

    }

    @Test
    public void testAddToCart() {
        driver.get("https://www.periplus.com/");

        addToCart.searchProduct("1989 the Berlin Wall: My Part in Its Downfall");
        addToCart.selectFirstProduct();
        addToCart.addToCart();
        viewCart.clickCartIcon();
        removeCart.clickRemoveButton();

        String emptyCartMessage = driver.findElement(By.cssSelector(".content")).getText();
        Assert.assertEquals(emptyCartMessage, "Your shopping cart is empty", "The cart is not empty after removing the product.");

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
