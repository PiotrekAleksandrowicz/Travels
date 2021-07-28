import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.List;
import java.util.stream.Collectors;


public class SignUpTest extends BaseTest {


    @Test
    public void signUp(){

        int randomNumber = (int) (Math.random()*100);
        driver.findElements(By.xpath("//li[@id='li_myaccount']")).stream()
                .filter(WebElement::isDisplayed).findFirst().ifPresent(WebElement::click);
        driver.findElements(By.xpath("//a[text()='  Sign Up']")).get(1).click();
        driver.findElement(By.name("firstname")).sendKeys("Jan");
        driver.findElement(By.name("lastname")).sendKeys("Kowalski");
        driver.findElement(By.name("phone")).sendKeys("666666666");
        driver.findElement(By.name("email")).sendKeys("kowalskiJan" + randomNumber + "@mail.pl");
        driver.findElement(By.name("password")).sendKeys("123456");
        driver.findElement(By.name("confirmpassword")).sendKeys("123456");
        driver.findElement(By.xpath("//button[text()=' Sign Up']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='RTL']")));
        WebElement heading =  driver.findElement(By.xpath("//h3[@class='RTL']"));
        Assert.assertTrue(heading.getText().contains("Hi, Jan Kowalski"));
    }

    @Test
    public void signUpEmptyForm(){

        driver.findElements(By.xpath("//li[@id='li_myaccount']")).stream()
                .filter(WebElement::isDisplayed).findFirst().ifPresent(WebElement::click);
        driver.findElements(By.xpath("//a[text()='  Sign Up']")).get(1).click();
        driver.findElement(By.xpath("//button[text()=' Sign Up']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#headersignupform > div.resultsignup")));
        List<String> resultOfTest = driver.findElements(By.xpath("//div[@class='alert alert-danger']//p"))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        System.out.println(resultOfTest.size());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(resultOfTest.contains("The Email field is required."));
        softAssert.assertTrue(resultOfTest.contains("The Password field is required."));
        softAssert.assertTrue(resultOfTest.contains("The Password field is required."));
        softAssert.assertTrue(resultOfTest.contains("The First name field is required."));
        softAssert.assertTrue(resultOfTest.contains("The Last Name field is required."));
        softAssert.assertAll();
    }

    @Test
    public void signUpWrongEmail(){

        int randomNumber = (int) (Math.random()*100);
        driver.findElements(By.xpath("//li[@id='li_myaccount']")).stream()
                .filter(WebElement::isDisplayed).findFirst().ifPresent(WebElement::click);
        driver.findElements(By.xpath("//a[text()='  Sign Up']")).get(1).click();
        driver.findElement(By.name("firstname")).sendKeys("Jan");
        driver.findElement(By.name("lastname")).sendKeys("Kowalski");
        driver.findElement(By.name("phone")).sendKeys("666666666");
        driver.findElement(By.name("email")).sendKeys("kowalskiJan" + randomNumber);
        driver.findElement(By.name("password")).sendKeys("123456");
        driver.findElement(By.name("confirmpassword")).sendKeys("123456");
        driver.findElement(By.xpath("//button[text()=' Sign Up']")).click();
        List<String> resultOfTest = driver.findElements(By.xpath("//div[@class='alert alert-danger']//p"))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        System.out.println(resultOfTest.size());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(resultOfTest.contains("The Email field must contain a valid email address."));
    }
}
