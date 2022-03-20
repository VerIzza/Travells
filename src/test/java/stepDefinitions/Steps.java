package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.Mapping;

public class Steps {

	String driverPath = "src/test/resources/chromedriver";
	public WebDriver driver;
	public String baseUrl = "https://www.phptravels.net/";
	Mapping map;
	WebDriverWait wait;
	Util util;

	@SuppressWarnings("deprecation")	
	@BeforeMethod
	private void startDriver(){
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		map = new Mapping(this.driver);
		driver.get(baseUrl);
		driver.manage().window().maximize();
		wait = new WebDriverWait(this.driver, 10);
		util = new Util();
	}
		
	@Test
	public void testTravells() {
		
		//Change to flight tab from hotels which is the default tab
		this.map.flightTab.click();
		this.wait.until(ExpectedConditions.visibilityOf(map.roundRadio));
		
		//Select type of flight to Round instead of OneWay
		assert(map.roundRadio.isDisplayed());
		this.map.roundRadio.click();
		wait.until(ExpectedConditions.visibilityOf(map.departureDateField));
		
		//Select Class of flight to first instead of economy
		this.map.flyghtClassDD.click();
		
		//Set Flying from and Destination
		this.map.flyingFromIn.sendKeys("MTY");
		this.map.destinationIn.sendKeys("CUN");
		
		//Set Departure date as tomorrow and return date as tomorrow plus 10 days
		assert(map.dateReturnForm.isDisplayed());
		this.map.dateLeftForm.clear();
		this.map.dateLeftForm.sendKeys(util.departureD());
		this.map.dateReturnForm.clear();
		this.map.dateReturnForm.sendKeys(util.returnD());
		
		//In order to add passengers the passengers dropdown must be clicked 
		this.map.passengers.click();
		wait.until(ExpectedConditions.visibilityOf(map.adultQt));
		
		//From dropdown set Adult to 3 and child to 1
		this.map.adultQt.clear();
		this.map.adultQt.sendKeys("3");
		this.map.childQt.clear();
		this.map.childQt.sendKeys("1");
		
		//Search button will show results of sent data, this will end successfully when a result is shown
		this.map.searchBtn.click();
		wait.until(ExpectedConditions.visibilityOf(map.result));
	}

	@AfterMethod
	public void terminateBrowser() {
		driver.quit();
	}

}
