package com.cydeo.utilites;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver_util {
    private Driver_util(){}

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    public static WebDriver getDriver() {
        if(driverPool.get()==null){
            String browser = System.getProperty("browser") != null ?  System.getProperty("browser") : ConfigurationReader.getProperty("browser");

            switch(browser){


                case "chrome":
//                    driverPool.set(new ChromeDriver());
//                    driverPool.get().manage().window().maximize();
//                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    break;
                case "firefox":
//                    driverPool.set(new FirefoxDriver());
//                    driverPool.get().manage().window().maximize();
//                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    break;

            }
        }

        return driverPool.get();
    }

    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }

    }
}
