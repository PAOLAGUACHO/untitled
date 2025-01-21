package com.cydeo.step;

import com.cydeo.pages.BookPage;
import com.cydeo.pages.LoginPage;
import io.cucumber.java.en.And;

public class ui_and_db {

    LoginPage loginPage = new LoginPage();
    BookPage bookpage = new BookPage();


    //scenario 3 All Layers

    @And("I logged in Library UI as {string}")
    public void iLoggedInLibraryUIAs(String role) {
        loginPage.singInWithRole(role);
    }

    @And("I navigate to {string} page")
    public void iNavigateToPage(String page)  {
        bookpage.booksPage.click();
    }






}
