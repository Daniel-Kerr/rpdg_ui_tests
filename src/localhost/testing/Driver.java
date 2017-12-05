package localhost.testing;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Driver {

	@Parameters("browser")
	@BeforeClass
	public static WebDriver buildDriver() {

		try {
			System.setProperty("webdriver.chrome.driver", "Selenium/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().setSize(new Dimension(1920,1080));
			//driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

			driver.get("http://localhost:3000");

			return driver;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed due to an unhandled Exception");
			return null;
		}
	}
}
