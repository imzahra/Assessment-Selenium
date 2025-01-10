package com.test.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC006_RemoveItemMessageTest {
    private WebDriver driver;
    private AddToCart addToCart;
    private ViewCart viewCart;
    private RemoveCart removeCart;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

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


        addToCart.searchProduct("How to Do the Work: Recognize Your Patterns, Heal from Your Past, and Create Your Self");
        addToCart.selectSecondProduct();
        addToCart.addToCart();

        viewCart.clickCartIcon();
        removeCart.clickRemoveButton();

        String successMessage = driver.findElement(By.cssSelector(".success")).getText();
        Assert.assertEquals(successMessage, "Success: You have modified your shopping cart!", "The success message did not appear as expected.");

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
