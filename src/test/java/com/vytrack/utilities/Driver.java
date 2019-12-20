package com.vytrack.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    private static WebDriver driver;

// you cannot do it like this, if constructor is private Driver obj = new Driver()
  private Driver(){

  }

    public static WebDriver get() {
        if (driver == null) {
            String browser = ConfigurationReader.getProperty("browser");
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    //to configure chrome browser for tests
                    driver = new ChromeDriver();
                    break;
                case "chrome_headless":
                    WebDriverManager.chromedriver().setup();
                    //to configure chrome browser for tests
                    ChromeOptions options = new ChromeOptions();
                    //to run tests without interface, set to true
                    options.setHeadless(true);
                    driver = new ChromeDriver(options);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    //if browser type is wrong, stop tests and throw exception
                    throw new RuntimeException("Wrong browser type!");
            }
        }
        return driver;
    }

  public static void close(){
      // if driver still exists
      if (driver != null){
          driver.quit();
          driver = null;
      }
  }


}
