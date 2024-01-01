package TestFramework.java.Pages;

import TestFramework.java.Modules.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class basepage extends Browser {

    public static void click(String locator) {
        driver.findElement(By.xpath(locator)).click();
    }

    public static void wait(int timeoutMillis) throws InterruptedException {
        driver.wait(timeoutMillis);
    }

    public static String get_text(String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        return element.getText();
    }

    public static void set_text(String locator, String input) {
        driver.findElement(By.xpath(locator)).sendKeys(input);
    }

    public static void check_if_item_is_displayed(String locator) {
        driver.findElement(By.xpath(locator)).isDisplayed();
    }


}
