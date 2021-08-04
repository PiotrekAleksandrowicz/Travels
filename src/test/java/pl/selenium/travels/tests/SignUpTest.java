package pl.selenium.travels.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pl.selenium.travels.pages.HotelPage;
import pl.selenium.travels.pages.LoggedUserPage;
import pl.selenium.travels.pages.SignUpPage;

import java.util.List;


public class SignUpTest extends BaseTest {


    @Test
    public void signUp() {

        int randomNumber = (int) (Math.random() * 100);

        HotelPage hotelPage = new HotelPage(driver);
        hotelPage.openSignUpForm();

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.setFirstNameInput("Jan");
        signUpPage.setLastnameInput("Kowalski");
        signUpPage.setPhoneInput("666666666");
        signUpPage.setEmailInput("kowalskiJan" + randomNumber + "@mail.pl");
        signUpPage.setPasswordInput("123456");
        signUpPage.setConfirmPasswordInput("123456");
        signUpPage.performSignUp();

        LoggedUserPage loggedUserPage = new LoggedUserPage(driver);
        loggedUserPage.getHeadingText();
        Assert.assertTrue(loggedUserPage.getHeadingText().contains("Hi, Jan Kowalski"));
    }

    @Test
    public void signUpEmptyForm() {

        HotelPage hotelPage = new HotelPage(driver);
        hotelPage.openSignUpForm();

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.performSignUp();

        List<String> errors = signUpPage.getErrors();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(errors.contains("The Email field is required."));
        softAssert.assertTrue(errors.contains("The Password field is required."));
        softAssert.assertTrue(errors.contains("The Password field is required."));
        softAssert.assertTrue(errors.contains("The First name field is required."));
        softAssert.assertTrue(errors.contains("The Last Name field is required."));
        softAssert.assertAll();
    }

    @Test
    public void signUpWrongEmail() {

        HotelPage hotelPage = new HotelPage(driver);
        hotelPage.openSignUpForm();

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.setFirstNameInput("Jan");
        signUpPage.setLastnameInput("Kowalski");
        signUpPage.setPhoneInput("666666666");
        signUpPage.setEmailInput("kowalskiJan");
        signUpPage.setPasswordInput("123456");
        signUpPage.setConfirmPasswordInput("123456");
        signUpPage.performSignUp();
        List<String> errors = signUpPage.getErrors();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(errors.contains("The Email field must contain a valid email address."));
    }
}
