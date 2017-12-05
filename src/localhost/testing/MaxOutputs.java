//Created by Daniel Kerr 6/7/17
package localhost.testing;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MaxOutputs {

	WebDriver driver;
	JavascriptExecutor jse;

	@BeforeTest
	public void setup() {

			driver = Driver.buildDriver();
			//driver = RemoteDriver.buildDriver();
	}

	@Test(priority = 0)
	public void addWirelessDevices() {
		try {
			// Navigate to Configuration page
			driver.findElement(By.linkText("Configuration")).click();
			// Navigate to Wireless(enocean) page
			driver.findElement(By.linkText("Wireless(enocean)")).click();

			// Add new wireless devices
			driver.findElement(By.id("deviceid")).sendKeys("019D35B9");
			Thread.sleep(100);
			driver.findElement(By.id("btadddevice")).click();
			
			driver.findElement(By.id("deviceid")).clear();
			driver.findElement(By.id("deviceid")).sendKeys("019D36B9");
			Thread.sleep(100);
			driver.findElement(By.id("btadddevice")).click();
			
			driver.findElement(By.id("deviceid")).clear();
			driver.findElement(By.id("deviceid")).sendKeys("019D37B9");
			Thread.sleep(100);
			driver.findElement(By.id("btadddevice")).click();
			
			driver.findElement(By.id("deviceid")).clear();
			driver.findElement(By.id("deviceid")).sendKeys("019D38B9");
			Thread.sleep(100);
			driver.findElement(By.id("btadddevice")).click();
			
			driver.findElement(By.id("deviceid")).clear();
			driver.findElement(By.id("deviceid")).sendKeys("019D39B9");
			Thread.sleep(100);
			driver.findElement(By.id("btadddevice")).click();
			
			driver.findElement(By.id("deviceid")).clear();
			driver.findElement(By.id("deviceid")).sendKeys("019D40B9");
			Thread.sleep(100);
			driver.findElement(By.id("btadddevice")).click();
			
			driver.findElement(By.id("deviceid")).clear();
			driver.findElement(By.id("deviceid")).sendKeys("019D41B9");
			Thread.sleep(100);
			driver.findElement(By.id("btadddevice")).click();
			
			driver.findElement(By.id("deviceid")).clear();
			driver.findElement(By.id("deviceid")).sendKeys("019D42B9");
			Thread.sleep(100);
			driver.findElement(By.id("btadddevice")).click();
			
			driver.findElement(By.id("deviceid")).clear();
			driver.findElement(By.id("deviceid")).sendKeys("019D43B9");
			Thread.sleep(100);
			jse = (JavascriptExecutor) driver;
			jse.executeScript("scroll(0, 500)");
			driver.findElement(By.id("btadddevice")).click();
			
			driver.findElement(By.id("deviceid")).clear();
			driver.findElement(By.id("deviceid")).sendKeys("019D44B9");
			Thread.sleep(100);
			jse = (JavascriptExecutor) driver;
			jse.executeScript("scroll(0, 500)");
			driver.findElement(By.id("btadddevice")).click();
			
			driver.findElement(By.id("deviceid")).clear();
			driver.findElement(By.id("deviceid")).sendKeys("019D45B9");
			Thread.sleep(100);
			jse = (JavascriptExecutor) driver;
			jse.executeScript("scroll(0, 500)");
			driver.findElement(By.id("btadddevice")).click();
			
			driver.findElement(By.id("deviceid")).clear();
			driver.findElement(By.id("deviceid")).sendKeys("019D46B9");
			Thread.sleep(100);
			jse = (JavascriptExecutor) driver;
			jse.executeScript("scroll(0, 500)");
			driver.findElement(By.id("btadddevice")).click();

			// Navigate back to the Configuration page
			jse = (JavascriptExecutor) driver;
			jse.executeScript("scroll(0, 0)");
			driver.findElement(By.linkText("Back to Config")).click();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed due to an unhandled Exception");
		}
	}

	@Test(priority = 1)
	public void addWiredFixtures() {
		try {
			// Navigate to Configuration page
			driver.findElement(By.linkText("Configuration")).click();

			// Scroll part-way down the page to find elements
			//jse = (JavascriptExecutor) driver;
			//jse.executeScript("scroll(0, 200)");

			// Create new fixture with various parameters
			for (int j = 1; j < 9;) {
				driver.findElement(By.id("fixturename")).clear();
				driver.findElement(By.id("fixturename")).sendKeys("Test_FIX_DIM_" + j);
				new Select(driver.findElement(By.id("fixturetype"))).selectByVisibleText("DIMMABLE");
				new Select(driver.findElement(By.id("starting_output"))).selectByIndex(j - 1);
				driver.findElement(By.id("btsavefixture")).click();
				Thread.sleep(200);
				j++;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed due to an unhandled Exception");
		}
	}

	@Test(priority = 2)
	public void addWirelessFixtures() {
		try {
			// Create new fixture with various parameters
			for (int j = 1; j < 13;) {
				driver.findElement(By.id("fixturename")).clear();
				driver.findElement(By.id("fixturename")).sendKeys("Test_FIX_ENO_" + j);
				new Select(driver.findElement(By.id("fixturetype"))).selectByVisibleText("DIMMABLE");
				new Select(driver.findElement(By.id("interface"))).selectByVisibleText("Enocean");
				new Select(driver.findElement(By.id("starting_output"))).selectByIndex(j - 1);
				driver.findElement(By.id("btsavefixture")).click();
				Thread.sleep(200);
				j++;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed due to an unhandled Exception");
		}
	}
	
	@Test(priority = 3)
	public void checkOutputs() {
		try {
			
			assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr/td")).getText(), "Test_FIX_DIM_1");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr/td[2]")).getText(), "dim");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr/td[3]")).getText(), "rpdg-pwm");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr/td[4]")).getText(), "1");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[2]/td")).getText(), "Test_FIX_DIM_2");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[2]/td[2]")).getText(), "dim");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[2]/td[3]")).getText(), "rpdg-pwm");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[2]/td[4]")).getText(), "2");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[3]/td")).getText(), "Test_FIX_DIM_3");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[3]/td[2]")).getText(), "dim");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[3]/td[3]")).getText(), "rpdg-pwm");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[3]/td[4]")).getText(), "3");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[4]/td")).getText(), "Test_FIX_DIM_4");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[4]/td[2]")).getText(), "dim");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[4]/td[3]")).getText(), "rpdg-pwm");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[4]/td[4]")).getText(), "4");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[5]/td")).getText(), "Test_FIX_DIM_5");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[5]/td[2]")).getText(), "dim");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[5]/td[3]")).getText(), "rpdg-pwm");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[5]/td[4]")).getText(), "5");
		    driver.findElement(By.linkText("Next")).click();
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr/td")).getText(), "Test_FIX_DIM_6");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr/td[2]")).getText(), "dim");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr/td[3]")).getText(), "rpdg-pwm");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr/td[4]")).getText(), "6");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[2]/td")).getText(), "Test_FIX_DIM_7");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[2]/td[2]")).getText(), "dim");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[2]/td[3]")).getText(), "rpdg-pwm");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[2]/td[4]")).getText(), "7");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[3]/td")).getText(), "Test_FIX_DIM_8");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[3]/td[2]")).getText(), "dim");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[3]/td[3]")).getText(), "rpdg-pwm");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[3]/td[4]")).getText(), "8");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[4]/td")).getText(), "Test_FIX_ENO_1");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[4]/td[2]")).getText(), "dim");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[4]/td[3]")).getText(), "enocean");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[4]/td[4]")).getText(), "019D35B9");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[5]/td")).getText(), "Test_FIX_ENO_10");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[5]/td[2]")).getText(), "dim");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[5]/td[3]")).getText(), "enocean");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[5]/td[4]")).getText(), "019D44B9");
		    driver.findElement(By.linkText("Next")).click();
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr/td")).getText(), "Test_FIX_ENO_11");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr/td[2]")).getText(), "dim");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr/td[3]")).getText(), "enocean");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr/td[4]")).getText(), "019D45B9");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[2]/td")).getText(), "Test_FIX_ENO_12");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[2]/td[2]")).getText(), "dim");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[2]/td[3]")).getText(), "enocean");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[2]/td[4]")).getText(), "019D46B9");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[3]/td")).getText(), "Test_FIX_ENO_2");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[3]/td[2]")).getText(), "dim");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[3]/td[3]")).getText(), "enocean");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[3]/td[4]")).getText(), "019D36B9");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[4]/td")).getText(), "Test_FIX_ENO_3");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[4]/td[2]")).getText(), "dim");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[4]/td[3]")).getText(), "enocean");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[4]/td[4]")).getText(), "019D37B9");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[5]/td")).getText(), "Test_FIX_ENO_4");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[5]/td[2]")).getText(), "dim");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[5]/td[3]")).getText(), "enocean");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[5]/td[4]")).getText(), "019D38B9");
		    driver.findElement(By.linkText("Next")).click();
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr/td")).getText(), "Test_FIX_ENO_5");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr/td[2]")).getText(), "dim");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr/td[3]")).getText(), "enocean");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr/td[4]")).getText(), "019D39B9");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[2]/td")).getText(), "Test_FIX_ENO_6");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[2]/td[2]")).getText(), "dim");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[2]/td[3]")).getText(), "enocean");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[2]/td[4]")).getText(), "019D40B9");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[3]/td")).getText(), "Test_FIX_ENO_7");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[3]/td[2]")).getText(), "dim");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[3]/td[3]")).getText(), "enocean");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[3]/td[4]")).getText(), "019D41B9");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[4]/td")).getText(), "Test_FIX_ENO_8");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[4]/td[2]")).getText(), "dim");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[4]/td[3]")).getText(), "enocean");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[4]/td[4]")).getText(), "019D42B9");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[5]/td")).getText(), "Test_FIX_ENO_9");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[5]/td[2]")).getText(), "dim");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[5]/td[3]")).getText(), "enocean");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[5]/td[4]")).getText(), "019D43B9");
		    driver.findElement(By.linkText("1")).click();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed due to an unhandled Exception");
		}
	}

	@Test(priority = 4)
	public void deleteAllFixtures() {
		try {
			// Wait at least most 5 seconds before declaring item not visible
			WebDriverWait wait = new WebDriverWait(driver, 5);

			//jse = (JavascriptExecutor) driver;
			//jse.executeScript("scroll(0, 200)");
			
			// Create new fixture with various parameters
			for (int j = 0; j < 20;) {
				// Wait for table element to be clickable after delete
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("td.sorting_1")));
				// Select the first table value
				driver.findElement(By.cssSelector("td.sorting_1")).click();
				// Delete selected fixture
				driver.findElement(By.id("btdelfixture")).click();
				Thread.sleep(500);
				j++;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed due to an unhandled Exception");
		}
	}

	@Test(priority = 5)
	public void deleteAllDevices() {
		try {
			// Navigate to Wireless(enocean) page
			driver.findElement(By.linkText("Wireless(enocean)")).click();

			// Wait at least most 5 seconds before declaring item not visible
			WebDriverWait wait = new WebDriverWait(driver, 5);

			// Create new fixture with various parameters
			for (int j = 0; j < 12;) {
				// Wait for table element to be clickable after delete
				wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//*[@id='outputdevtable']/tbody/tr/td[7]/input")));
				// Select the first table value
				driver.findElement(By.xpath("//table[@id='outputdevtable']/tbody/tr/td[7]/input")).click();
				Thread.sleep(200);
				j++;
			}

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