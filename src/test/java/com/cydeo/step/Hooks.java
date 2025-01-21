package com.cydeo.step;

import com.cydeo.utilites.ConfigurationReader;
import com.cydeo.utilites.DB_util;
import com.cydeo.utilites.Driver_util;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;

public class Hooks {

    @Before("@ui")
    public void setUp() {
        Driver_util.getDriver().manage().window().maximize();
        Driver_util.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Driver_util.getDriver().get(ConfigurationReader.getProperty("library_url"));
    }

    @After("@ui")
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver_util.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
        Driver_util.closeDriver();

    }

    @Before("@db")
    public void dbHook() {
        DB_util.connectToDatabase();
    }

    @After("@db")
    public void afterdbHook() {
        DB_util.closeConnection();
        System.out.println("Successfully Closed database");
    }


    @Before()
    public void setBaseURI() {
        RestAssured.baseURI = ConfigurationReader.getProperty("base_url");
    }
}

