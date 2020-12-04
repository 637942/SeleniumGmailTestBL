package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendMail {
	public static WebDriver driver;

	public SendMail(WebDriver driver) {
		SendMail.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "z0")
	WebElement composeMail;

	@FindBy(css = ".vO")
	WebElement toMail;

	@FindBy(css = ".aoT")
	WebElement subjectText;

	@FindBy(className = "Am")
	WebElement bodyText;

	@FindBy(css = ".aoO")
	WebElement sendBtn;

	@FindBy(xpath = "//*[@id='gb']/div[2]/div[3]/div[1]/div[2]/div/a")
	WebElement profile;

	@FindBy(xpath = "//*[@id='gb_71']")
	WebElement signout;

	@FindBy(xpath = "//*[@class='zF']")
	java.util.List<WebElement> unreademail;

	@FindBy(css = ".bog")
	java.util.List<WebElement> mailsubject;

	public WebElement ComposeMail() {
		return composeMail;
	}

	public WebElement ToMail() {
		return toMail;
	}

	public WebElement SubjectText() {
		return subjectText;
	}

	public WebElement BodyText() {
		return bodyText;
	}

	public WebElement SendBtn() {
		return sendBtn;
	}

	public WebElement Profile() {
		return profile;
	}

	public WebElement Signout() {
		return signout;
	}

	public java.util.List<WebElement> UnreadeMail() {
		return unreademail;
	}

	public java.util.List<WebElement> MailSubject() {
		return mailsubject;
	}

}
