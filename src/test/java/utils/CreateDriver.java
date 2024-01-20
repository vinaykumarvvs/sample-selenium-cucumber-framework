package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class CreateDriver {

    private final String browser = System.getProperty("browser");

    WebDriver getDriver() {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("allow-running-insecure-content");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-notifications");
            return new ChromeDriver(options);
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("allow-running-insecure-content");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-notifications");
            return new FirefoxDriver(options);
        }
        throw new RuntimeException(String.format("Currently not supporting the %s browser, kindly pass chrome as browser", browser));
    }
}