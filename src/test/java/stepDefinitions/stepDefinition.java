package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LoginPage;
import pageObjects.SendMail;
import resources.base;

public class stepDefinition extends base {

	@Before
	public void setup() {
		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Given("^I login with sender username and password in Gmail$")
	public void i_login_with_sender_username_and_password_in_Gmail() {

		driver.get(getData("url"));
		LoginPage lp = new LoginPage(driver);
		lp.LoginEmail().sendKeys(getData("senderemail"));
		lp.LoginNext().click();
		lp.LoginPassword().sendKeys(getData("senderpassword"));
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		lp.LoginPassword().sendKeys(Keys.ENTER);
		System.out.println("Sender Mail page opened");

	}

	@When("^I compose a new Email from sender account$")
	public void i_compose_a_new_Email_from_sender_account() {
		SendMail sm = new SendMail(driver);
		sm.ComposeMail().click();
		sm.ToMail().sendKeys(getData("receiveremail"));
		sm.SubjectText().sendKeys(getData("subject"));
		sm.BodyText().sendKeys(getData("bodytext"));

	}

	@When("^I click send button$")
	public void i_click_send_button() {

		SendMail sm1 = new SendMail(driver);
		sm1.SendBtn().click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		sm1.Profile().click();
		sm1.Signout().click();

	}

	@When("^I Login into receiver email account$")
	public void i_Login_into_receiver_email_account() {

		LoginPage lp1 = new LoginPage(driver);
		lp1.AAccount().click();
		lp1.LoginEmail().sendKeys(getData("receiveremail"));
		lp1.LoginNext().click();
		lp1.LoginPassword().sendKeys(getData("password"));
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		lp1.LoginPassword().sendKeys(Keys.ENTER);
		System.out.println("Receiver Mail page opened");
	}

	@Then("^I should receive the email with same subject in receiver inbox$")
	public void i_should_receive_the_email_with_same_subject_in_receiver_inbox() {
		SendMail sm1 = new SendMail(driver);
		for (int i = 0; i < sm1.UnreadeMail().size(); i++) {
			if (sm1.UnreadeMail().get(i).isDisplayed() == true) {
				if (sm1.UnreadeMail().get(i).getText().equals(getData("mailername"))) {
					for (int j = 0; j < sm1.MailSubject().size(); j++) {
						if (sm1.MailSubject().get(j).getText().contains(getData("subject"))) {
							sm1.MailSubject().get(0).click();
							System.out.println(sm1.MailSubject().get(0).getText());
							System.out.println("Yes we have got mail with subject  " + (getData("subject")));
							break;

						}
					}

				} else {
					System.out.println("No mail  " + getData("subject"));
				}
			}

		}

	}

	@After
	public void close() {
		driver.quit();
	}

}
