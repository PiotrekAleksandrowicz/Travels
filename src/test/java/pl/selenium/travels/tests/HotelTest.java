package pl.selenium.travels.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.selenium.travels.pages.HotelPage;
import pl.selenium.travels.pages.HotelResultsPage;
import pl.selenium.travels.tests.BaseTest;

import java.util.List;
import java.util.stream.Collectors;

public class HotelTest extends BaseTest {

    @Test
    public void searchHotelTest1(){

        HotelPage hotelPage = new HotelPage(driver);
        hotelPage.setCity("London", driver);
        hotelPage.setDates("23/08/2021","30/08/2021");
        hotelPage.setTravellers(1, 1);
        hotelPage.performSearch();

        HotelResultsPage hotelResultsPage = new HotelResultsPage(driver);
        List<String> hotelNames = hotelResultsPage.getHotelName();

        Assert.assertEquals("Grand Plaza Apartments", hotelNames.get(0));
        }



    @Test
    public void searchHotelTest2(){

        HotelPage hotelPage = new HotelPage(driver);
        hotelPage.setCity("Dubai", driver);
        hotelPage.setDates("23/08/2021","30/08/2021");
        hotelPage.setTravellers(1, 1);
        hotelPage.performSearch();

        HotelResultsPage hotelResultsPage = new HotelResultsPage(driver);
        List<String> hotelNames = hotelResultsPage.getHotelName();
        Assert.assertEquals("Jumeirah Beach Hotel", hotelNames.get(0));
        Assert.assertEquals("Oasis Beach Tower", hotelNames.get(1));
        Assert.assertEquals("Rose Rayhaan Rotana", hotelNames.get(2));
        Assert.assertEquals("Hyatt Regency Perth", hotelNames.get(3));
    }

    @Test
    public void searchHotelwithoutName() {


        HotelPage hotelPage = new HotelPage(driver);
        hotelPage.setDates("23/08/2021","30/08/2021");
        hotelPage.setTravellers(1,1);
        hotelPage.performSearch();

        HotelResultsPage hotelResultsPage = new HotelResultsPage(driver);
        Assert.assertTrue(hotelResultsPage.headingNoResults.isDisplayed());
        Assert.assertEquals(hotelResultsPage.getText(),"No Results Found");
    }
}
