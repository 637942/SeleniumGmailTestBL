package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

	public WebDriver driver;
	public static Properties prop;
	public static FileInputStream input;
	public static String testData = "src\\main\\java\\resources\\data.properties";

	private static final String chrome_win = "src\\main\\java\\browserDirectory\\chromedriver.exe";
	private static final String edge = "src\\main\\java\\browserDirectory\\MicrosoftWebDriver.exe";
	private static final String firefox_win = "src\\main\\java\\browserDirectory\\geckodriver.exe";
	
public WebDriver initializeDriver() 
{
	
 prop= new Properties();
 try {
		input = new FileInputStream(testData);
		prop.load(input);
		input.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
 
String browserName=prop.getProperty("browser");
System.out.println(browserName);

if(browserName.equals("chrome"))
{
	 System.setProperty("webdriver.chrome.driver",chrome_win);
	 driver= new ChromeDriver();
		//execute in chrome driver
	
}
else if (browserName.equals("firefox"))
{
	System.setProperty("webdriver.geckos.driver", firefox_win);
	 driver= new FirefoxDriver();
	
}
else if (browserName.equals("edge"))
{
	System.setProperty("webdriver.edges.driver", edge);
	driver = new EdgeDriver();
}

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
return driver;


}


public static String getData(String key) {
	prop = new Properties();

	try {
		input = new FileInputStream(testData);
		prop.load(input);
		input.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	return prop.getProperty(key);
}

public void getScreenshot(String result) throws IOException
{
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("C://test//"+result+"screenshot.png"));
	
}



}
