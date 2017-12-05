package localhost.testing;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class ErrorValidation {

	WebDriver driver;
	JavascriptExecutor jse;

	@BeforeTest
	public void setup() {

		driver = Driver.buildDriver();
		//driver = RemoteDriver.buildDriver();
	}

	@Test(priority = 0)
	public void siteZip() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			
			driver.findElement(By.linkText("Configuration")).click();
			driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div[1]/div[1]/a[2]/i")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("btsavesiteinfo")));

			driver.findElement(By.id("sitezip")).clear();
			driver.findElement(By.id("btsavesiteinfo")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")));
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[1]")).getText(),
					"Site Info Save Error");
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).getText(),
					"Zip is too short (minimum is 3 characters)");
			driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).click();
			
			driver.findElement(By.id("sitezip")).clear();
			driver.findElement(By.id("sitezip")).sendKeys("62");
			driver.findElement(By.id("btsavesiteinfo")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")));
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[1]")).getText(),
					"Site Info Save Error");
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).getText(),
					"Zip is too short (minimum is 3 characters)");
			driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).click();

			driver.findElement(By.id("sitezip")).clear();
			driver.findElement(By.id("sitezip")).sendKeys("9752360");
			driver.findElement(By.id("btsavesiteinfo")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")));
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[1]")).getText(),
					"Site Info Save Error");
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).getText(),
					"Zip is too long (maximum is 5 characters)");
			driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).click();

			driver.findElement(By.id("sitezip")).clear();
			driver.findElement(By.id("sitezip")).sendKeys("645_2");
			driver.findElement(By.id("btsavesiteinfo")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")));
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[1]")).getText(),
					"Site Info Save Error");
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).getText(),
					"Zip must be 5 numeric values");
			driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).click();

			driver.findElement(By.id("sitezip")).clear();
			driver.findElement(By.id("sitezip")).sendKeys("00025");
			driver.findElement(By.id("btgpslookup")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")));
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[1]")).getText(),
					"Zip Code Not Found");
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).getText(),
					"Zip code not found");
			driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).click();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed due to an unhandled Exception");
		}
	}
	
	@Test(priority = 1)
	public void siteLat() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("btsavesiteinfo")));

			driver.findElement(By.id("sitelatt")).clear();
			driver.findElement(By.id("btsavesiteinfo")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")));
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[1]")).getText(),
					"Site Info Save Error");
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).getText(),
					"Latt is not a number");
			driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).click();
			
			driver.findElement(By.id("sitelatt")).clear();
			driver.findElement(By.id("sitelatt")).sendKeys("-91");
			driver.findElement(By.id("btsavesiteinfo")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")));
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[1]")).getText(),
					"Site Info Save Error");
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).getText(),
					"Latt must be greater than or equal to -90");
			driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).click();

			driver.findElement(By.id("sitelatt")).clear();
			driver.findElement(By.id("sitelatt")).sendKeys("91");
			driver.findElement(By.id("btsavesiteinfo")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")));
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[1]")).getText(),
					"Site Info Save Error");
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).getText(),
					"Latt must be less than or equal to 90");
			driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).click();

			driver.findElement(By.id("sitelatt")).clear();
			driver.findElement(By.id("sitelatt")).sendKeys("9_");
			driver.findElement(By.id("btsavesiteinfo")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")));
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[1]")).getText(),
					"Site Info Save Error");
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).getText(),
					"Latt is not a number");
			driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).click();
			
			driver.findElement(By.id("sitelatt")).clear();
			driver.findElement(By.id("sitelatt")).sendKeys("45");
			driver.findElement(By.id("btsavesiteinfo")).click();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed due to an unhandled Exception");
		}
	}
	
	@Test(priority = 2)
	public void siteLong() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("btsavesiteinfo")));

			driver.findElement(By.id("sitelong")).clear();
			driver.findElement(By.id("btsavesiteinfo")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")));
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[1]")).getText(),
					"Site Info Save Error");
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).getText(),
					"Long is not a number");
			driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).click();
			
			driver.findElement(By.id("sitelong")).clear();
			driver.findElement(By.id("sitelong")).sendKeys("-181");
			driver.findElement(By.id("btsavesiteinfo")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")));
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[1]")).getText(),
					"Site Info Save Error");
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).getText(),
					"Long must be greater than or equal to -180");
			driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).click();

			driver.findElement(By.id("sitelong")).clear();
			driver.findElement(By.id("sitelong")).sendKeys("181");
			driver.findElement(By.id("btsavesiteinfo")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")));
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[1]")).getText(),
					"Site Info Save Error");
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).getText(),
					"Long must be less than or equal to 180");
			driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).click();

			driver.findElement(By.id("sitelong")).clear();
			driver.findElement(By.id("sitelong")).sendKeys("11_");
			driver.findElement(By.id("btsavesiteinfo")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")));
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[1]")).getText(),
					"Site Info Save Error");
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).getText(),
					"Long is not a number");
			driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).click();

			driver.findElement(By.id("sitelong")).clear();
			driver.findElement(By.id("sitelong")).sendKeys("-112");
			driver.findElement(By.id("btsavesiteinfo")).click();
			
			driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/div[1]/div[1]/a[2]/i")).click();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed due to an unhandled Exception");
		}
	}

	@Test(priority = 3)
	public void nodeName() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			driver.findElement(By.xpath("html/body/div[1]/div[1]/div[1]/div[1]/div/div[1]/div[1]/a[2]/i")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("btsaveip")));
			
			driver.findElement(By.id("nodename")).clear();
			driver.findElement(By.id("btsaveip")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")));
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[1]")).getText(),
					"Node Name Save Error");
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).getText(),
					"Name is too short (minimum is 3 characters)");
			driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).click();

			driver.findElement(By.id("nodename")).clear();
			driver.findElement(By.id("nodename")).sendKeys("This_Name_is_too_Long_Now__Now_");
			driver.findElement(By.id("btsaveip")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")));
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[1]")).getText(),
					"Node Name Save Error");
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).getText(),
					"Name is too long (maximum is 25 characters)");
			driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).click();

			driver.findElement(By.id("nodename")).clear();
			driver.findElement(By.id("nodename")).sendKeys("Spaces are Bad");
			driver.findElement(By.id("btsaveip")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")));
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[1]")).getText(),
					"Node Name Save Error");
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).getText(),
					"Name of object only contain a-z ,0-9, and _");
			driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).click();

			driver.findElement(By.id("nodename")).clear();
			driver.findElement(By.id("nodename")).sendKeys("$peci@l");
			driver.findElement(By.id("btsaveip")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")));
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[1]")).getText(),
					"Node Name Save Error");
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).getText(),
					"Name of object only contain a-z ,0-9, and _");
			driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).click();

			driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div[1]/div[1]/a[2]/i")).click();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed due to an unhandled Exception");
		}
	}

	@Test(priority = 4)
	public void fixtureName() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			jse = (JavascriptExecutor) driver;
			jse.executeScript("scroll(0, 200)");
			Thread.sleep(400);
			
			driver.findElement(By.id("btsavefixture")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")));
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[1]")).getText(),
					"Fixture Save Error");
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).getText(),
					"Name is too short (minimum is 3 characters)");
			driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).click();

			driver.findElement(By.id("fixturename")).clear();
			driver.findElement(By.id("fixturename")).sendKeys("This_Name_is_too_Long_Now_");
			driver.findElement(By.id("btsavefixture")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")));
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[1]")).getText(),
					"Fixture Save Error");
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).getText(),
					"Name is too long (maximum is 25 characters)");
			driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).click();

			driver.findElement(By.id("fixturename")).clear();
			driver.findElement(By.id("fixturename")).sendKeys("Spaces are Bad");
			driver.findElement(By.id("btsavefixture")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")));
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[1]")).getText(),
					"Fixture Save Error");
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).getText(),
					"Name of object only contain a-z ,0-9, and _");
			driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).click();

			driver.findElement(By.id("fixturename")).clear();
			driver.findElement(By.id("fixturename")).sendKeys("$peci@l");
			driver.findElement(By.id("btsavefixture")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")));
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[1]")).getText(),
					"Fixture Save Error");
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).getText(),
					"Name of object only contain a-z ,0-9, and _");
			driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).click();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed due to an unhandled Exception");
		}
	}

	@Test(priority = 5)
	public void contactinputName() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			jse = (JavascriptExecutor) driver;
			jse.executeScript("scroll(0, 1000)");
			Thread.sleep(500);
			
			driver.findElement(By.id("btsaveinputcontactobj")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")));
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[1]")).getText(),
					"Contact Save Error");
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).getText(),
					"Name is too short (minimum is 3 characters)");
			driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).click();

			driver.findElement(By.id("contactname")).clear();
			driver.findElement(By.id("contactname")).sendKeys("This_Name_is_too_Long_Now_");
			driver.findElement(By.id("btsaveinputcontactobj")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")));
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[1]")).getText(),
					"Contact Save Error");
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).getText(),
					"Name is too long (maximum is 25 characters)");
			driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).click();

			driver.findElement(By.id("contactname")).clear();
			driver.findElement(By.id("contactname")).sendKeys("Spaces are Bad");
			driver.findElement(By.id("btsaveinputcontactobj")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")));
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[1]")).getText(),
					"Contact Save Error");
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).getText(),
					"Name of object only contain a-z ,0-9, and _");
			driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).click();

			driver.findElement(By.id("contactname")).clear();
			driver.findElement(By.id("contactname")).sendKeys("$peci@l");
			driver.findElement(By.id("btsaveinputcontactobj")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")));
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[1]")).getText(),
					"Contact Save Error");
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).getText(),
					"Name of object only contain a-z ,0-9, and _");
			driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).click();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed due to an unhandled Exception");
		}
	}

	@Test(priority = 6)
	public void levelinputName() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);

			driver.findElement(By.id("btsavelevelinput")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")));
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[1]")).getText(),
					"Level Input Save Error");
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).getText(),
					"Name is too short (minimum is 3 characters)");
			driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).click();

			driver.findElement(By.id("levelinputname")).clear();
			driver.findElement(By.id("levelinputname")).sendKeys("This_Name_is_too_Long_Now_");
			driver.findElement(By.id("btsavelevelinput")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")));
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[1]")).getText(),
					"Level Input Save Error");
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).getText(),
					"Name is too long (maximum is 25 characters)");
			driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).click();

			driver.findElement(By.id("levelinputname")).clear();
			driver.findElement(By.id("levelinputname")).sendKeys("Spaces are Bad");
			driver.findElement(By.id("btsavelevelinput")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")));
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[1]")).getText(),
					"Level Input Save Error");
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).getText(),
					"Name of object only contain a-z ,0-9, and _");
			driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).click();

			driver.findElement(By.id("levelinputname")).clear();
			driver.findElement(By.id("levelinputname")).sendKeys("$peci@l");
			driver.findElement(By.id("btsavelevelinput")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")));
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[1]")).getText(),
					"Level Input Save Error");
			assertEquals(driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).getText(),
					"Name of object only contain a-z ,0-9, and _");
			driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div[2]/div[2]")).click();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed due to an unhandled Exception");
		}
	}
	
	@Test(priority = 7)
	public void sceneName() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			
			driver.findElement(By.linkText("Override/Scene Edit")).click();
			
			driver.findElement(By.id("btmakescene")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.btn-primary")));
			driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[2]/div/div[2]/div/div[2]/div[1]")));
			assertEquals(driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div[2]/div[1]")).getText(),
					"Error");
			assertEquals(driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div[2]/div[2]")).getText(),
					"Incomplete Name, please try again");

			driver.findElement(By.id("btmakescene")).click();
			driver.findElement(By.id("scene_name")).sendKeys("as");
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.btn-primary")));
			driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]")));
			assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[1]")).getText(),
					"Error");
			assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]")).getText(),
					"Name is too short (minimum is 3 characters)");
			
			driver.findElement(By.id("scene_name")).clear();
			driver.findElement(By.id("scene_name")).sendKeys("This_Name_is_too_Long_Now_");
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.btn-primary")));
			driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[2]/div/div[2]/div/div[2]/div[1]")));
			assertEquals(driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div[2]/div[1]")).getText(),
					"Error");
			assertEquals(driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div[2]/div[2]")).getText(),
					"Name is too long (maximum is 15 characters)");
			
			driver.findElement(By.id("scene_name")).clear();
			driver.findElement(By.id("scene_name")).sendKeys("Spaces are Bad");
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.btn-primary")));
			driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[2]/div/div[2]/div/div[2]/div[1]")));
			assertEquals(driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div[2]/div[1]")).getText(),
					"Error");
			assertEquals(driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div[2]/div[2]")).getText(),
					"Name of object only contain a-z ,0-9, and _");

			driver.findElement(By.id("scene_name")).clear();
			driver.findElement(By.id("scene_name")).sendKeys("$peci@l");
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.btn-primary")));
			driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[2]/div/div[2]/div/div[2]/div[2]")));
			assertEquals(driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div[2]/div[1]")).getText(),
					"Error");
			assertEquals(driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div[2]/div[2]")).getText(),
					"Name of object only contain a-z ,0-9, and _");

			driver.findElement(By.cssSelector("button.btn.btn-default")).click();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed due to an unhandled Exception");
		}
	}
	
	@Test(priority = 8)
	public void groupName() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			
			Thread.sleep(500);
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Groups")));
			driver.findElement(By.linkText("Groups")).click();
			
			driver.findElement(By.id("btmakescene")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.btn-primary")));
			driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[2]/div/div[2]/div/div[2]/div[1]")));
			assertEquals(driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div[2]/div[1]")).getText(),
					"Error");
			assertEquals(driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div[2]/div[2]")).getText(),
					"Incomplete Name, please try again");

			driver.findElement(By.id("btmakescene")).click();
			driver.findElement(By.id("group_name")).sendKeys("as");
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.btn-primary")));
			driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[2]/div/div[2]/div/div[2]/div[1]")));
			assertEquals(driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div[2]/div[1]")).getText(),
					"Error");
			assertEquals(driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div[2]/div[2]")).getText(),
					"Name is too short (minimum is 3 characters)");
			
			driver.findElement(By.id("group_name")).clear();
			driver.findElement(By.id("group_name")).sendKeys("This_Name_is_too_Long_Now_");
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.btn-primary")));
			driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[2]/div/div[2]/div/div[2]/div[1]")));
			assertEquals(driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div[2]/div[1]")).getText(),
					"Error");
			assertEquals(driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div[2]/div[2]")).getText(),
					"Name is too long (maximum is 15 characters)");
			
			driver.findElement(By.id("group_name")).clear();
			driver.findElement(By.id("group_name")).sendKeys("Spaces are Bad");
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.btn-primary")));
			driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[2]/div/div[2]/div/div[2]/div[1]")));
			assertEquals(driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div[2]/div[1]")).getText(),
					"Error");
			assertEquals(driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div[2]/div[2]")).getText(),
					"Name of object only contain a-z ,0-9, and _");

			driver.findElement(By.id("group_name")).clear();
			driver.findElement(By.id("group_name")).sendKeys("$peci@l");
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.btn-primary")));
			driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[2]/div/div[2]/div/div[2]/div[1]")));
			assertEquals(driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div[2]/div[1]")).getText(),
					"Error");
			assertEquals(driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div[2]/div[2]")).getText(),
					"Name of object only contain a-z ,0-9, and _");

			driver.findElement(By.cssSelector("button.btn.btn-default")).click();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed due to an unhandled Exception");
		}
	}
	
	@Test(priority = 9)
	public void scenelistName() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			Thread.sleep(500);
			driver.findElement(By.linkText("Scene Lists")).click();
			
			driver.findElement(By.id("btmakescene")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.btn-primary")));
			driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[2]/div/div[2]/div/div[2]/div[1]")));
			assertEquals(driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div[2]/div[1]")).getText(),
					"Error");
			assertEquals(driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div[2]/div[2]")).getText(),
					"Incomplete Name, please try again");

			driver.findElement(By.id("btmakescene")).click();
			driver.findElement(By.id("scenelist_name")).sendKeys("as");
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.btn-primary")));
			driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[2]/div/div[2]/div/div[2]/div[1]")));
			assertEquals(driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div[2]/div[1]")).getText(),
					"Error");
			assertEquals(driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div[2]/div[2]")).getText(),
					"Name is too short (minimum is 3 characters)");
			
			driver.findElement(By.id("scenelist_name")).clear();
			driver.findElement(By.id("scenelist_name")).sendKeys("This_Name_is_too_Long_Now_");
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.btn-primary")));
			driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[2]/div/div[2]/div/div[2]/div[1]")));
			assertEquals(driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div[2]/div[1]")).getText(),
					"Error");
			assertEquals(driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div[2]/div[2]")).getText(),
					"Name is too long (maximum is 15 characters)");
			
			driver.findElement(By.id("scenelist_name")).clear();
			driver.findElement(By.id("scenelist_name")).sendKeys("Spaces are Bad");
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.btn-primary")));
			driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[2]/div/div[2]/div/div[2]/div[1]")));
			assertEquals(driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div[2]/div[1]")).getText(),
					"Error");
			assertEquals(driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div[2]/div[2]")).getText(),
					"Name of object only contain a-z ,0-9, and _");

			driver.findElement(By.id("scenelist_name")).clear();
			driver.findElement(By.id("scenelist_name")).sendKeys("$peci@l");
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.btn-primary")));
			driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[2]/div/div[2]/div/div[2]/div[1]")));
			assertEquals(driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div[2]/div[1]")).getText(),
					"Error");
			assertEquals(driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div/div[2]/div[2]")).getText(),
					"Name of object only contain a-z ,0-9, and _");
			
			Thread.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed due to an unhandled Exception");
		}
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}