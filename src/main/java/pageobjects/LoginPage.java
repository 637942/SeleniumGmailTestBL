package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public static WebDriver driver;

	public LoginPage(WebDriver driver) {
		LoginPage.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='identifierId']")
	WebElement loginemail;

	@FindBy(id = "identifierNext")
	WebElement loginnext;

	@FindBy(xpath = "//input[@name='password']")
	WebElement loginpassword;
	
	@FindBy(xpath = "//*[@id=\'gb\']/div[2]/div[3]/div[1]/div[2]/div/a")
	static WebElement profile;
	
	@FindBy(xpath = "//*[@id='gb_71']")
	static WebElement signout;

	public WebElement LoginEmail() {
		return loginemail;
	}

	public WebElement LoginNext() {
		return loginnext;
	}

	public WebElement LoginPassword() {
		return loginpassword;
	}
	
	public static WebElement Profile() {
		return profile;
	}
	
	public static WebElement Signout() {
		return signout;
	}

	
}
