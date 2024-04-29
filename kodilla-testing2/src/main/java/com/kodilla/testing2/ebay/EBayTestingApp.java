package com.kodilla.testing2.ebay;
//
import com.kodilla.testing2.google.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class EBayTestingApp {
    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);

        // Otwieranie strony eBay
        driver.get("https://www.ebay.com/");

        // Wyszukiwanie laptopów
        driver.findElement(By.id("gh-ac")).sendKeys("Laptop");
        driver.findElement(By.id("gh-ac")).sendKeys(Keys.RETURN);

        // Zamykanie przeglądarki
        //driver.quit();
    }
}
