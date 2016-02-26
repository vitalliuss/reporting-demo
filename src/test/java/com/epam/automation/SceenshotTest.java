package com.epam.automation;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Vitali_Shulha on 26-Feb-16.
 */
public class SceenshotTest {

    Logger logger = LogManager.getRootLogger();

    @Test
    public void oneCanTakeScreenshot(){
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.epam.com/");

        WebElement logo = driver.findElement(By.xpath("//a[@class='logo']"));
        highlightElement(driver, logo, 2000);
    }

    private void highlightElement(WebDriver driver, WebElement element, int durationMills){
        String bg = element.getCssValue("backgroundColor");
        JavascriptExecutor js = ((JavascriptExecutor)driver);
        js.executeScript("arguments[0].style.backgroundColor = '" + "yellow" + "'", element);
        takeScreenshot(driver);
        sleep(durationMills);
        js.executeScript("arguments[0].style.backgroundColor = '" + bg + "'", element);
    }

    private void sleep(int durationMills) {
        try {
            Thread.sleep(durationMills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void takeScreenshot(WebDriver driver) {
        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String screenshotPath = "./target/screenshots/" + getTimestamp() + ".png";
        try {
            FileUtils.copyFile(source, new File(screenshotPath));
        } catch (IOException e) {
            logger.error("Error copy file: " + e.getMessage());
        }
        logger.info("Screenshot saved at: " + screenshotPath);
    }

    private String getTimestamp() {
        return new SimpleDateFormat("yyyy_dd-MMM_HH_mm_sss").format(new Date());
    }
}














