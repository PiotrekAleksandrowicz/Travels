package pl.selenium.travels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {

    private WebDriver driver;

    @FindBy(name = "firstname")
    WebElement firstNameInput;

    @FindBy(name = "lastname")
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

    public SignUpPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, 10);
    }

    public void setFirstNameInput(String name){
        firstNameInput.sendKeys(name);
    }

    public void setLastnameInput(String lastName){
        lastnameInput.sendKeys(lastName);
    }

    public void setPhoneInput(String phone){
        phoneInput.sendKeys(phone);
    }

    public void setEmailInput(String email){
        emailInput.sendKeys(email);
    }

    public void setPasswordInput(String password){
        passwordInput.sendKeys(password);
    }

    public void setConfirmPasswordInput(String confirmPassword){
        confirmPasswordInput.sendKeys(confirmPassword);
    }

    public void performSignUp(){
        signUpButton.click();
    }


}

