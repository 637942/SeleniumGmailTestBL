package pageobjects;

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
	
	@FindBy(className = "aoO")
	static WebElement sendBtn;
	
	@FindBy(xpath = "//*[@class='zF']")
	 java.util.List<WebElement> unreademail;
	
	
	public WebElement ComposeMail() {
		return composeMail;
	}
	
	public WebElement ToMail(){
		return toMail;
	}
	
		
	public WebElement SubjectText(){
		return subjectText;
	}
	
	public WebElement BodyText(){
		return bodyText;
	}
	
	public static WebElement SendBtn(){
		return sendBtn;
	}
	
	public java.util.List<WebElement> UnreadeMail(){
		return unreademail;
	}
	
		




}
