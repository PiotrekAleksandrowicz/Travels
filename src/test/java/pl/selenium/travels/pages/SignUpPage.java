package pl.selenium.travels.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage {


    @FindBy(name = "firstname")
    WebElement firstNameInput;

    @FindBy(name = "lastName")
    WebElement lastnameInput;

    @FindBy(name = "phone")
    WebElement phoneInput;

    @FindBy(name = "email")
    WebElement emailInput;

    @FindBy(name = "password")
    WebElement passwordInput;

    @FindBy(name = "confirmpassword")
    WebElement confirmPasswordInput;

    @FindBy(xpath = "//button[text()=' Sign Up']")
    WebElement signUpButton;


}

