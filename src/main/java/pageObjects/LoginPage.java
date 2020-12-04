package pageObjects;

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

	@FindBy(xpath = "//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div/div/ul/li[2]/div/div/div[2]")
	WebElement aaccount;

	public WebElement LoginEmail() {
		return loginemail;
	}

	public WebElement LoginNext() {
		return loginnext;
	}

	public WebElement LoginPassword() {
		return loginpassword;
	}

	public WebElement AAccount() {
		return aaccount;
	}
	/*
	 * public static void BaseUrl() { driver.get(
	 * "https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin"
	 * );
	 * 
	 * }
	 */

}
