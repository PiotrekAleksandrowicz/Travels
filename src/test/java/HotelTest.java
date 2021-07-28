import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import java.util.stream.Collectors;

public class HotelTest extends BaseTest {



    @Test
    public void searchHotel(){


        driver.findElement(By.xpath("//span[text()='Search by Hotel or City Name']")).click();
        driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/div/input")).sendKeys("Dubai");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='select2-match' and text()='Dubai']")));
        driver.findElement(By.xpath("//span[@class='select2-match' and text()='Dubai']")).click();
        driver.findElement(By.name("checkin")).sendKeys("23/07/2021");
        driver.findElement(By.name("checkout")).click();
        driver.findElements(By.xpath("//td[@class='day ' and text()='30']"))
                .stream()
                .filter(el ->el.isDisplayed())
                .findFirst()
                .ifPresent(el ->el.click());
        driver.findElement(By.id("travellersInput")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("adultPlusBtn")));
        driver.findElement(By.id("adultPlusBtn")).click();
        driver.findElement(By.id("childPlusBtn")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='btn btn-lg btn-block btn-primary pfb0 loader']")));
        driver.findElement(By.cssSelector("button[class='btn btn-lg btn-block btn-primary pfb0 loader']")).click();
        List<String> hotelNames = driver.findElements(By.xpath("//h4[@class='RTL go-text-right mt0 mb4 list_title']//b")).stream()
                .map(el ->el.getAttribute("textContent"))
                .collect(Collectors.toList());
        System.out.println("Quantity of hotel names " + hotelNames.size());
        hotelNames.forEach(el -> System.out.println(el));
        Assert.assertEquals("Jumeirah Beach Hotel", hotelNames.get(0));
        Assert.assertEquals("Oasis Beach Tower", hotelNames.get(1));
        Assert.assertEquals("Rose Rayhaan Rotana", hotelNames.get(2));
        Assert.assertEquals("Hyatt Regency Perth", hotelNames.get(3));
    }

    @Test
    public void searchHotelwithoutName() {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.findElement(By.name("checkin")).sendKeys("23/07/2021");
        driver.findElement(By.name("checkout")).click();
        driver.findElements(By.xpath("//td[@class='day ' and text()='30']"))
                .stream()
                .filter(el -> el.isDisplayed())
                .findFirst()
                .ifPresent(el -> el.click());
        driver.findElement(By.id("travellersInput")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("adultPlusBtn")));
        driver.findElement(By.id("adultPlusBtn")).click();
        driver.findElement(By.id("childPlusBtn")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='btn btn-lg btn-block btn-primary pfb0 loader']")));
        driver.findElement(By.cssSelector("button[class='btn btn-lg btn-block btn-primary pfb0 loader']")).click();
        WebElement result = driver.findElement(By.xpath("//h2[@class='text-center']"));
        Assert.assertTrue(result.isDisplayed());
        Assert.assertEquals(result.getText(),"No Results Found");
    }
}
