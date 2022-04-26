package com.eurotech.Ödevler;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class SauceDemoTest {

    /**
     * We have some test cases to be done in automation. The environment is given below:
     * url = https://www.saucedemo.com/
     * - Create a class as name "SauceDemoTest".
     * - Create BeforeMethod, AfterMethod to setup webdriver and quit driver at the end of test.
     * - Then create test methods with @Test annotaion and develope your tests according to the cases written below
     */

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    //Test Case 1 - Login Function
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
        element.click();
        //driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

        String actualResult = driver.getCurrentUrl();
        System.out.println("CURRENT URL:" + actualResult);
        String expectedResult = "https://www.saucedemo.com/inventory.html";
        //Assert.assertTrue(actualResult.contains(expectedResult));

        Assert.assertEquals(actualResult,expectedResult);
    }

    //Test Case 2 - Product Page Function
    @Test
    public void test2() throws InterruptedException {
        driver.get(" https://www.saucedemo.com/");
        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
        element.click();
        Thread.sleep(2000);
        WebElement product = driver.findElement(By.xpath("//*[@id=\"item_5_title_link\"]/div"));
        product.click();
        String actualResualt = driver.findElement(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[1]")).getText();
        System.out.println("actualResualt = " + actualResualt);
        String expectedResult = "Sauce Labs Fleece Jacket";
        Assert.assertEquals(actualResualt,expectedResult);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"back-to-products\"]")).click();

        System.out.println("TO VERIFY EXPECTED CURRENT URL:" + driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/inventory.html"));
    }

    //Test Case 3 - Add to Cart Function
    @Test
    public void test3() throws InterruptedException {
        driver.get(" https://www.saucedemo.com/");
        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
        element.click();
        Thread.sleep(3000);
        WebElement product1 = driver.findElement(By.id("add-to-cart-sauce-labs-onesie"));
        product1.click();
        WebElement productText = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span"));
        System.out.println("productText.getText() = " + productText.getText());
        Assert.assertTrue(productText.isDisplayed());
        Thread.sleep(3000);
        WebElement product2 = driver.findElement(By.id("remove-sauce-labs-onesie"));
        product2.click();
        Thread.sleep(3000);
        WebElement productText1 = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
        System.out.println("productText1.getText() = " + productText1.getText());
        Assert.assertTrue(productText1.isDisplayed());
    }

    // Test Case 4 - Product Display Order On Page
    @Test
    public void test4() throws InterruptedException {

        driver.get(" https://www.saucedemo.com/");
        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
        element.click();
        Thread.sleep(3000);
        WebElement AdanZye = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[1]"));
        System.out.println("AdanZye.getText() = " + AdanZye.getText());
        Assert.assertTrue(AdanZye.getText().contains("Name (A to Z)"));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select")).click();
        Thread.sleep(2000);
        WebElement lowToHigh = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[3]"));
        lowToHigh.click();
        Thread.sleep(2000);
        String text = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[3]")).getText();
        System.out.println("text = " + text);


    }

    // Test Case 5 - Shopping Function
    @Test
    public void test5() throws InterruptedException {
        driver.get(" https://www.saucedemo.com/");
        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
        element.click();
        Thread.sleep(3000);
        WebElement ürün = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        ürün.click();
        Thread.sleep(2000);
        WebElement cart = driver.findElement(By.className("shopping_cart_link"));
        cart.click();
        Thread.sleep(2000);
        WebElement checkOut = driver.findElement(By.xpath("//button[@id=\"checkout\"]"));
        checkOut.click();
        Thread.sleep(2000);
        driver.findElement(By.id("first-name")).sendKeys("Mustafa");
        Thread.sleep(2000);
        driver.findElement(By.id("last-name")).sendKeys("Elmas");
        Thread.sleep(2000);
        driver.findElement(By.id("postal-code")).sendKeys("45697");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id=\"continue\"]")).click();
        Thread.sleep(2000);

            String orjinalFiyat = driver.findElement(By.xpath("//div[@class=\"inventory_item_price\"]")).getText();
            System.out.println("orjinalFiyat = " + orjinalFiyat);
            String totalFiyat = driver.findElement(By.xpath("//div[@class='summary_total_label']")).getText();
            System.out.println("totalFiyat = " + totalFiyat);
        Assert.assertFalse(orjinalFiyat.contains(totalFiyat), "Check the item total price is same with original price of product");
        boolean teyit = false;
        if (orjinalFiyat.equals(totalFiyat)){
            System.out.println("Teyit 1 : " +teyit);
        }
        else {
            System.out.println("Teyit 2 : " + teyit);
        }
        driver.findElement(By.xpath("//button[@id='finish']")).click();
        Thread.sleep(2000);
        String actualResult = driver.findElement(By.xpath("//h2[@class='complete-header']")).getText();
        String expectedrResult = "THANK YOU FOR YOUR ORDER";
        Assert.assertEquals(actualResult,expectedrResult,"Expected result : \"THANK YOU FOR YOUR ORDER\"");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
