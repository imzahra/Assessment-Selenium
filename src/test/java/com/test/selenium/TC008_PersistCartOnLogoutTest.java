package com.test.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TC008_PersistCartOnLogoutTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private AddToCart addToCart;
    private ViewCart viewCart;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();

        loginPage = new LoginPage(driver);
        addToCart = new AddToCart(driver);
        viewCart = new ViewCart(driver);
    }

    @Test
    public void testAddToCart() {
        driver.get("https://www.periplus.com/");
        driver.findElement(By.id("nav-signin-text")).click();
        loginPage.login("saheurora@gmail.com", "Password123");

        addToCart.searchProduct("1989 the Berlin Wall: My Part in Its Downfall");
        addToCart.selectFirstProduct();
        addToCart.addToCart();
        driver.get("https://www.periplus.com/_index_/Logout");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.get("https://www.periplus.com/");
        driver.findElement(By.id("nav-signin-text")).click();
        loginPage.login("saheurora@gmail.com", "Password123");
        viewCart.clickCartIcon();
        String productLinkText = driver.findElement(By.linkText("1989 the Berlin Wall: My Part in Its Downfall")).getText();
        Assert.assertEquals(productLinkText, "1989 the Berlin Wall: My Part in Its Downfall", "The product was not found in the cart after re-login.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
