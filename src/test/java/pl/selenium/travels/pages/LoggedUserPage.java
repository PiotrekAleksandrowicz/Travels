package pl.selenium.travels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoggedUserPage {

    private WebDriver driver;

    @FindBy(xpath = "//h3[@class='RTL']")
    private WebElement heading;

    public LoggedUserPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='RTL']")));

    }

    public String getHeadingText(){
        return heading.getText();
    }


}
