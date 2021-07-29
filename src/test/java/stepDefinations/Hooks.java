package stepDefinations;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

import common_Framework_Functions.LocalDriverFactory;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Hooks {
	public static WebDriver driver = null;
	
	@Before("@FirstFeature")
	public void configuration() {

		MutableCapabilities sauceOptions = new MutableCapabilities();
		sauceOptions.setCapability("build","Java-W3C-Examples");
		sauceOptions.setCapability("seleniumVersion","3.141.59");
		sauceOptions.setCapability("username","oauth-ankitpandey397-7d94d");
		//sauceOptions.setCapability("password","30AKSmane#");
		sauceOptions.setCapability("accessKey","bf4d1381-7cf1-49d8-a9b7-0783896c146a");
		//sauceOptions.setCapability("tags","w3c-chrome-tests"); //Not required because of that there was a error

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("sauce:options",sauceOptions);
		desiredCapabilities.setCapability("browserVersion", "latest");
		desiredCapabilities.setCapability("platformName","windows 10");


		desiredCapabilities.setCapability("browserName","chrome");


		//Driver URL = https://akshaymane04:cb0ed849-3d50-4948-8992-a0c26ec1182f@ondemand.apac-southeast-1.saucelabs.com:443/wd/hub
		try {
			//driver = new RemoteWebDriver(new URL("https://ondemand.apac-southeast-1.saucelabs.com:443/wd/hub"), desiredCapabilities);
			driver = new RemoteWebDriver(new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub"), desiredCapabilities);
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\asus\\Downloads\\chromedriver_win32_1\\chromedriver.exe");
			//driver =new ChromeDriver();
		} catch (Exception e){
			System.out.println(e);
		}

	/*	driver = LocalDriverFactory.createInstance("chrome");*/
		driver.get("https://flipkart.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@After
	public void tearDown(){
		driver.quit();
	}
	

}
