package com.cydeo.pages;

import com.cydeo.utilites.Driver_util;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver_util.getDriver(), this);
    }

    @FindBy(css = "#navbarDropdown>span")
    public WebElement accountHolderName;



}
