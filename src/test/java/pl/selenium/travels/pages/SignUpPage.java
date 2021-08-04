package pl.selenium.travels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class SignUpPage {

    private WebDriver driver;

    @FindBy(name = "firstname")
    private WebElement firstNameInput;

    @FindBy(name = "lastname")
    private WebElement lastnameInput;

    @FindBy(name = "phone")
    private WebElement phoneInput;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(name = "confirmpassword")
    private WebElement confirmPasswordInput;

    @FindBy(xpath = "//button[text()=' Sign Up']")
    private WebElement signUpButton;

    @FindBy(xpath = "//div[@class='alert alert-danger']//p")
    private List<WebElement> errors;


    public SignUpPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        ;


    }

    public void setFirstNameInput(String name) {
        firstNameInput.sendKeys(name);
    }

    public void setLastnameInput(String lastName) {
        lastnameInput.sendKeys(lastName);
    }

    public void setPhoneInput(String phone) {
        phoneInput.sendKeys(phone);
    }

    public void setEmailInput(String email) {
        emailInput.sendKeys(email);
    }

    public void setPasswordInput(String password) {
        passwordInput.sendKeys(password);
    }

    public void setConfirmPasswordInput(String confirmPassword) {
        confirmPasswordInput.sendKeys(confirmPassword);
    }

    public void performSignUp() {
        signUpButton.click();
    }

    public List<String> getErrors() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#headersignupform > div.resultsignup")));
        return errors.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }


}

