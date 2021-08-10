package pl.selenium.travels.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private static final Logger logger  = LogManager.getLogger();

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
        logger.info("Add name: " + name + " in to name input");
        firstNameInput.sendKeys(name);
        logger.info("Add name: " + name + " DONE");
    }

    public void setLastnameInput(String lastName) {
        logger.info("Add last name: " + lastName + " in to last name input");
        lastnameInput.sendKeys(lastName);
        logger.info("Add last name: " + lastName + " DONE");
    }

    public void setPhoneInput(String phone) {

        logger.info("Add phone number: " + phone + " in to phone input");
        phoneInput.sendKeys(phone);
        logger.info("Add phone number: " + phone + " DONE");

    }

    public void setEmailInput(String email) {

        logger.info("Add email: " + email + " in to email input");
        emailInput.sendKeys(email);
        logger.info("Add email: " + email + " DONE");

    }

    public void setPasswordInput(String password) {
        logger.info("Add password: " + password + " in to password input");
        passwordInput.sendKeys(password);
        logger.info("Add password: " + password + " DONE");

    }

    public void setConfirmPasswordInput(String confirmPassword) {
        logger.info("Add password: " + confirmPassword + " in to confirm password input");
        confirmPasswordInput.sendKeys(confirmPassword);
        logger.info("Add password: " + confirmPassword + " DONE");

    }

    public void performSignUp() {

        logger.info("Perform Sing In Button");
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

