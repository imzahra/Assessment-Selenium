package com.test.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class TC022_VerifyMultipleProducts {
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

        addToCart.searchProduct("Wells Fargo and Danger Station");
        addToCart.selectThirdProduct();
        addToCart.addToCartLong();
        viewCart.clickCartIcon();

        List<WebElement> productRows = driver.findElements(By.cssSelector(".row-cart-product"));

        Assert.assertEquals(productRows.size(), 3, "The number of products in the cart is incorrect.");

        Assert.assertEquals(productRows.get(0).findElement(By.cssSelector(".product-name a")).getText().trim(), "Wells Fargo and Danger Station");
        Assert.assertEquals(productRows.get(0).findElement(By.cssSelector("img")).getAttribute("src"), "https://static.periplus.com/hDr0nG.B5QQIgrgWUkE.Y81gbpUM6wZggSUq9pk0KfIf9CocejFuHaMRP92OzScWA--");
        // Assert.assertEquals(productRows.get(0).findElement(By.xpath(".//div[contains(text(),'Rp 395,000 or 790 Points')]")).getText().trim(), "Rp 395,000 or 790 Points");

        Assert.assertEquals(productRows.get(1).findElement(By.cssSelector(".product-name a")).getText().trim(), "1989 the Berlin Wall: My Part in Its Downfall");
        Assert.assertEquals(productRows.get(1).findElement(By.cssSelector("img")).getAttribute("src"), "https://static.periplus.com/vNHSBhLzr7cQxmb4kFDPZo0RWpQ88EcGLGZ1ixEo5Ty.9H3m7PcscorjptjjXZ1gQ--");
        // Assert.assertEquals(productRows.get(1).findElement(By.xpath(".//div[contains(text(),'Rp 284,000 or 568 Points')]")).getText().trim(), "Rp 284,000 or 568 Points");

        Assert.assertEquals(productRows.get(2).findElement(By.cssSelector(".product-name a")).getText().trim(), "How to Do the Work: Recognize Your Patterns, Heal from Your Past, and Create Your Self");
        Assert.assertEquals(productRows.get(2).findElement(By.cssSelector("img")).getAttribute("src"), "https://static.periplus.com/rmbLANnOTQM5JDaUVwSWJh6l4QjAlDVeDKGTg3SZlFMI5LMn7C_Pl0ayrEB2HD90g--");
        // Assert.assertEquals(productRows.get(2).findElement(By.xpath(".//div[contains(text(),'Rp 710,000 or 1420 Points')]")).getText().trim(), "Rp 710,000 or 1420 Points");
        
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
