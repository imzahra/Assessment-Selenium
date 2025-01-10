package com.test.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC003_IncrementCartQuantityTest {
    private WebDriver driver;
    private ViewCart viewCart;
    private ModifyCart modifyCart;
    private AddToCart addToCart;

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
        modifyCart.increaseQuantity(1);
        modifyCart.updateCart();
        String quantityValue = driver.findElement(By.id("qty_31727083")).getAttribute("value");
        Assert.assertEquals(quantityValue, "2", "The quantity was not updated correctly.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
