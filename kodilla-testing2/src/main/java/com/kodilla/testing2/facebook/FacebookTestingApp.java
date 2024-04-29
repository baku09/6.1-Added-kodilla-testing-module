package com.kodilla.testing2.facebook;

import com.kodilla.testing2.google.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FacebookTestingApp {

    public static final String XPATH_ACCEPT_COOKIES = "//div[contains(@class, \"_4-i2\")]/div[4]/button";
    public static final String XPATH_REGISTER = "//div[contains(@class, \"_8iep\")]/div/form/div[5]/a";
    public static final String XPATH_SELECTDAY = "//div[contains(@class, \"_5k_5\")]/span/span/select[1]";
    public static final String XPATH_SELECTMONTH = "//div[contains(@class, \"_5k_5\")]/span/span/select[2]";
    public static final String XPATH_SELECTYEAR = "//div[contains(@class, \"_5k_5\")]/span/span/select[3]";



    public static void main(String[] args) {

        WebDriver webDriver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        webDriver.get("https://www.facebook.com/");

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(1));

        boolean cookiesAccepted = false;
        while (!cookiesAccepted) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_ACCEPT_COOKIES))).click();
                cookiesAccepted = true;
            } catch (Exception e) {
                webDriver.navigate().refresh();
            }
        }

        webDriver.findElement(By.xpath(XPATH_REGISTER)).click();

        WebElement selectComboDays = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_SELECTDAY)));
        Select selectDay = new Select(selectComboDays);
        selectDay.selectByValue("3");

        WebElement selectComboMonths = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_SELECTMONTH)));
        Select selectMonth = new Select(selectComboMonths);
        selectMonth.selectByValue("6");

        WebElement selectComboYears = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_SELECTYEAR)));
        Select selectYear = new Select(selectComboYears);
        selectYear.selectByValue("1999");

    }
}
