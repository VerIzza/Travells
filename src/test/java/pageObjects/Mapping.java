package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Mapping {
	
	WebDriver driver;
	public Mapping(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//li[2]/button[@data-bs-target='#flights']")
	public WebElement flightTab;
	
	@FindBy(xpath = "//input[@id='round-trip']")
	public WebElement roundRadio;
	
	@FindBy(xpath = "//select[@id='flight_type']//option[@value='first']")
	public WebElement flyghtClassDD;
	
	@FindBy(xpath = "//input[@id='autocomplete' and @placeholder='Flying From']")
	public WebElement flyingFromIn;
	
	@FindBy(xpath = "//input[@id='autocomplete2' and @placeholder='To Destination']")
	public WebElement destinationIn;
	
	@FindBy(xpath = "//input[@class='depart form-control dateleft border-top-r0']")
	public WebElement dateLeftForm;

	@FindBy(xpath = "//input[@name='returning']")
	public WebElement dateReturnForm;
	
	@FindBy(xpath = "//input[@id='fadults']") //following-sibling::div/i")
	public WebElement adultQt;
	
	@FindBy(xpath = "//input[@id='fchilds']")
	public WebElement childQt;
	
	@FindBy(xpath = "//button[@id='flights-search']")
	public WebElement searchBtn;
	
	@FindBy(xpath = "//section[@id='data']")
	public WebElement result;
	
	@FindBy(xpath = "//label[contains(text(),'Departure Date')]")
	public WebElement departureDateField;
	
	@FindBy(xpath = "//span[@class='guest_flights d-block text-center']")
	public WebElement passengers;

}
