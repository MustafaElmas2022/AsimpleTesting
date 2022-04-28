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
        driver.findElement(By.xpath("//input[@id=\"user-name\"]")).sendKeys("standard_user");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//input[@id=\"login-button\"]"));
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
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//input[@id=\"user-name\"]")).sendKeys("standard_user");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//input[@id=\"login-button\"]"));
        element.click();
        Thread.sleep(2000);
        WebElement product = driver.findElement(By.xpath("(//div[@class=\"inventory_item_name\"])[4]"));
        product.click();
        String actualResualt = driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']")).getText();
        System.out.println("actualResualt = " + actualResualt);
        String expectedResult = "Sauce Labs Fleece Jacket";
        Assert.assertEquals(actualResualt,expectedResult);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='back-to-products']")).click();

        System.out.println("TO VERIFY EXPECTED CURRENT URL:" + driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/inventory.html"));
    }

    //Test Case 3 - Add to Cart Function
    @Test
    public void test3() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//input[@id=\"user-name\"]")).sendKeys("standard_user");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//input[@id=\"login-button\"]"));
        element.click();
        Thread.sleep(3000);
        WebElement product1 = driver.findElement(By.id("add-to-cart-sauce-labs-onesie"));
        product1.click();
        WebElement productText = driver.findElement(By.xpath("//div[@id='shopping_cart_container']/a/span"));
        System.out.println("productText.getText() = " + productText.getText());

        Thread.sleep(3000);
        WebElement product2 = driver.findElement(By.id("remove-sauce-labs-onesie"));
        product2.click();
        Thread.sleep(3000);
        String productText1 = driver.findElement(By.xpath("//div[@id=\"shopping_cart_container\"]/a")).getText();
        System.out.println("productText1.getText() = " + productText1);
        Assert.assertEquals(productText1,"");

    }

    // Test Case 4 - Product Display Order On Page
    @Test
    public void test4() throws InterruptedException {

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//input[@id=\"user-name\"]")).sendKeys("standard_user");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//input[@id=\"login-button\"]"));
        element.click();
        Thread.sleep(3000);
        WebElement AdanZye = driver.findElement(By.xpath("//select[@class='product_sort_container']/../span"));
        System.out.println("AdanZye.getText() = " + AdanZye.getText());
        Assert.assertTrue(AdanZye.getText().contains("NAME (A TO Z)"));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
        Thread.sleep(2000);
        WebElement lowToHigh = driver.findElement(By.xpath("//select[@class='product_sort_container']/option[3]"));
        lowToHigh.click();
        Thread.sleep(2000);
        String text = driver.findElement(By.xpath("//select[@class='product_sort_container']/../span")).getText();
        System.out.println("text = " + text);
        String expectedResult = "PRICE (LOW TO HIGH)";
        Assert.assertEquals(text, expectedResult);



    }

    // Test Case 5 - Shopping Function
    @Test
    public void test5() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//input[@id=\"user-name\"]")).sendKeys("standard_user");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//input[@id=\"login-button\"]"));
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
            String itemTotalFiyat = driver.findElement(By.xpath("//div[@class='summary_subtotal_label']")).getText();
            System.out.println("totalFiyat = " + itemTotalFiyat);
        Assert.assertTrue(itemTotalFiyat.contains(orjinalFiyat), "Check the item total price is same with original price of product");
        boolean teyit = false;
        if (orjinalFiyat.equals(itemTotalFiyat)){
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
