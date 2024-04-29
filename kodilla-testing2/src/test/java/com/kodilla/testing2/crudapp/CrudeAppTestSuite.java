package com.kodilla.testing2.crudapp;


import com.kodilla.testing2.google.config.WebDriverConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CrudeAppTestSuite {
    private static final String BASE_URL = "https://baku09.github.io";
    private WebDriver driver;

    private Random generator;

    @BeforeEach
    public void initTests() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(BASE_URL);
        generator = new Random();
    }

    @AfterEach
    public void cleanUpAfterTest() {
        try {
        driver.close();
        // Obsługa alertu
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    } catch (Exception e) {
        System.err.println("Exception during test cleanup: " + e.getMessage());
    } finally {
        // Zamykanie drivera
        driver.quit();
    }
}

    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {
        String taskName = createCrudAppTestTask();
        sendTestTaskToTrello(taskName);
        assertTrue(checkTaskExistsInTrello(taskName));
    }

    private boolean checkTaskExistsInTrello(String taskName) throws InterruptedException {
        final String TRELLO_URL = "https://trello.com/login";
        boolean result = false;
        WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driverTrello.get(TRELLO_URL);

        Thread.sleep(2000);

        driverTrello.findElement(By.id("username")).sendKeys("ktb.1999.ktb@gmail.com");
        WebElement el = driverTrello.findElement(By.id("login-submit"));
        el.submit();

        Thread.sleep(2000);

        driverTrello.findElement(By.id("password")).sendKeys("CocaCola07%");
        el.submit();

        Thread.sleep(4000);

        // Obsługa alertu
        try {
            WebDriverWait wait = new WebDriverWait(driverTrello, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driverTrello.switchTo().alert();
            alert.dismiss();
        } catch (Exception e) {
            // Ignoruj, jeśli alert nie pojawił się
        }

        Thread.sleep(4000);

        driverTrello.findElements(By.xpath("//a[@class=\"board-tile\"]")).stream()
                .filter(aHref -> !aHref.findElements(By.xpath(".//div[@title=\"Kodilla Application\"]")).isEmpty())
                .forEach(WebElement::click);

        Thread.sleep(10000);

        result = driverTrello.findElements(By.xpath("//a")).stream()
                .anyMatch(theA -> theA.getText().equals(taskName));

        Thread.sleep(4000);

        driverTrello.close();

        return result;
    }

    private void sendTestTaskToTrello(String taskName) throws InterruptedException {
        driver.navigate().refresh();                                         // [1]

        while(!driver.findElement(By.xpath("//select[1]")).isDisplayed());   // [2]

        driver.findElements(
                        By.xpath("//form[@class=\"datatable__row\"]")).stream()           // [3]
                .filter(anyForm ->                                             // [4]
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]")) // [5]
                                .getText().equals(taskName))                        // [6]
                .forEach(theForm -> {                                          // [7]
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));    // [8]
                    Select select = new Select(selectElement);                 // [9]
                    select.selectByIndex(1);                                   // [10]

                    WebElement buttonCreateCard =                              // [11]
                            theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]")); // [12]
                    buttonCreateCard.click();                                  // [13]
                });                                                            // [14]
        Thread.sleep(5000);                                                  // [15]
    }

    private String createCrudAppTestTask() throws InterruptedException {
        final String XPATH_TASK_NAME = "//form[contains(@action,\"createTask\")]/fieldset[1]/input";
        final String XPATH_TASK_CONTENT = "//form[contains(@action,\"createTask\")]/fieldset[2]/textarea";
        final String XPATH_ADD_BUTTON = "//form[contains(@action,\"createTask\")]/fieldset[3]/button";
        String taskName = "Task number " + generator.nextInt(100000);
        String taskContent = taskName + " content";

        WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);

        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);

        WebElement addButton = driver.findElement(By.xpath(XPATH_ADD_BUTTON));
        addButton.click();
        Thread.sleep(2000);

        return taskName;
    }

}