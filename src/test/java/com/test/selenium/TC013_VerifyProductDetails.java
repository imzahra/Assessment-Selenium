package com.test.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC013_VerifyProductDetails {
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
        addToCart.addToCart();
        viewCart.clickCartIcon();
        String productName = driver.findElement(By.cssSelector(".product-name a")).getText().trim();
        Assert.assertEquals(productName, "1989 the Berlin Wall: My Part in Its Downfall", "Product name is incorrect.");

        String productImageSrc = driver.findElement(By.cssSelector(".row-cart-product img")).getAttribute("src");
        String expectedImageSrc = "https://static.periplus.com/vNHSBhLzr7cQxmb4kFDPZo0RWpQ88EcGLGZ1ixEo5Ty.9H3m7PcscorjptjjXZ1gQ--";
        Assert.assertEquals(productImageSrc, expectedImageSrc, "Product image URL is incorrect.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
