package com.test.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC012_LoginCart {
    private WebDriver driver;
    private LoginPage loginPage;
    private AddToCart addToCart;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        addToCart = new AddToCart(driver);
    }

    @Test
    public void testAddToCart() {
        driver.get("https://www.periplus.com/");
        driver.findElement(By.id("nav-signin-text")).click();
        loginPage.login("saheurora@gmail.com", "Password123");
        
        addToCart.searchProduct("1989 the Berlin Wall: My Part in Its Downfall");
        addToCart.selectFirstProduct();
        addToCart.addToCart();

        String modalText = driver.findElement(By.cssSelector(".modal-text")).getText();
        Assert.assertEquals(modalText, "Success add to cart");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}