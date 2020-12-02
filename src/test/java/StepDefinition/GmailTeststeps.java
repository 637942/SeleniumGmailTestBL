package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import resources.base;
import pageobjects.LoginPage;
import pageobjects.SendMail;

public class GmailTeststeps extends base {

	final String url = prop.getProperty("url");
	final String to = "test1@gmail.com";
	final String topassword = "password1";
	final String subject = "Test Email";
	final String body = "Test Email";

	@Given("^I login with username \"([^\"]*)\" and password \"([^\"]*)\" in Gmail$")
	public void i_login_with_username_something_and_password_something_in_gmail(String username, String password)
			throws Throwable {

		driver = initializeDriver();
		driver.get(url);
		LoginPage lp = new LoginPage(driver);
		lp.LoginEmail().sendKeys(username);
		lp.LoginNext().click();
		lp.LoginPassword().sendKeys(password);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		lp.LoginPassword().sendKeys(Keys.ENTER);
		System.out.println("Sender Mail page opened");

	}

	@When("^I compose a new Email from sender account$")
	public void i_compose_a_new_email_from_sender_account() throws Throwable {
		SendMail sm = new SendMail(driver);
		sm.ComposeMail().click();
		sm.ToMail().sendKeys(to);
		sm.SubjectText().sendKeys(subject);
		sm.BodyText().sendKeys(body);

	}

	@When("^I click send button$")
	public void i_click_send_button() throws Throwable {
		SendMail.SendBtn().click();
		Thread.sleep(2000);
		LoginPage.Profile().click();
		LoginPage.Signout().click();
	}

	@When("^I Login into receiver email account$")
	public void i_Login_into_receiver_email_account() throws Throwable {
		driver = initializeDriver();
		driver.get(url);
		LoginPage lp1 = new LoginPage(driver);
		lp1.LoginEmail().sendKeys(to);
		lp1.LoginNext().click();
		lp1.LoginPassword().sendKeys(topassword);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		lp1.LoginPassword().sendKeys(Keys.ENTER);
		System.out.println("Receiver Mail page opened");
	}

	@Then("^I should receive the email with same subject in receiver inbox$")
	public void i_should_receive_the_email_with_same_subject_in_receiver_inbox() throws Throwable {
		SendMail sm1 = new SendMail(driver);
		for (int i = 0; i < sm1.UnreadeMail().size(); i++) {
			if (sm1.UnreadeMail().get(i).isDisplayed() == true) {
				if (sm1.UnreadeMail().get(i).getText().equals(subject)) {
					System.out.println("Yes we have got mail  " + subject);
					break;
				} else {
					System.out.println("No mail  " + subject);
				}
			}

		}
	}
}
