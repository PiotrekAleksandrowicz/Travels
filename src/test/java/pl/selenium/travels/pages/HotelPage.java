package pl.selenium.travels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class HotelPage {

    private WebDriver driver;

    @FindBy(xpath = "//span[text()='Search by Hotel or City Name']")
    private WebElement searchHotelSpan;

    @FindBy(xpath = "//*[@id=\"select2-drop\"]/div/input")
    private WebElement searchHotelInput;

    @FindBy(xpath = "//span[@class='select2-match' and text()='Dubai']" )
    private WebElement hotelMatch;

    @FindBy(name = "checkin")
    private WebElement checkInInput;

    @FindBy(name = "checkout")
    private WebElement checkOutInput;

    @FindBy(id = "travellersInput")
    private WebElement travellersInput;

    @FindBy(id = "adultPlusBtn")
    private WebElement adultPlusButton;

    @FindBy(id = "childPlusBtn")
    private WebElement childPlusButton;

    @FindBy(css = "button[class='btn btn-lg btn-block btn-primary pfb0 loader']")
    private WebElement searchButton;

    @FindBy(xpath = "//li[@id='li_myaccount']")
    private List<WebElement> myAccountLink;

    @FindBy(xpath = "//a[text()='  Sign Up']")
    private List<WebElement> signUpLink;

    public HotelPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, 10);

    }

    public void setCity(String cityName, WebDriver driver){

        searchHotelSpan.click();
        searchHotelInput.sendKeys(cityName);
        String xpath = String.format("//span[@class='select2-match' and text()='%s']",cityName);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath(xpath)));
        driver.findElement(By.xpath(xpath)).click();
    }

    public void setDates(String checkIn, String checkOut){
        checkInInput.sendKeys(checkIn);
        checkOutInput.sendKeys(checkOut);
    }

    public void setTravellers(int adultsToAdd, int childToAdd){
        travellersInput.click();
        for(int i = 0; i<adultsToAdd; i++){
            adultPlusButton.click();
        }
        for(int i = 0; i<childToAdd; i++){
            childPlusButton.click();
        }
    }

    public void performSearch(){
        searchButton.click();
    }

    public void openSignUpForm(){
        myAccountLink.stream()
                .filter(WebElement::isDisplayed).findFirst().ifPresent(WebElement::click);
        signUpLink.get(1).click();
    }



}
