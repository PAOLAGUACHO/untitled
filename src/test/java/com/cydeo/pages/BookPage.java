package com.cydeo.pages;

import com.cydeo.utilites.Driver_util;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookPage {

    public BookPage(){
        PageFactory.initElements(Driver_util.getDriver(), this);
    }

    @FindBy(css="[href='#books']")
    public WebElement booksPage;

}
