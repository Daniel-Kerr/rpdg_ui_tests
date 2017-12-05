//Created by Daniel Kerr 6/25/17
package localhost.testing;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MultiOutputs {

	WebDriver driver;
	JavascriptExecutor jse;

	@BeforeTest
	public void setup() {
			
			driver = Driver.buildDriver();
			//driver = RemoteDriver.buildDriver();
	}

	@Test(priority = 1)
	public void addWiredFixtures() {
		try {
			// Navigate to Configuration page
			driver.findElement(By.linkText("Configuration")).click();

			// Scroll part-way down the page to find elements
			jse = (JavascriptExecutor) driver;
			jse.executeScript("scroll(0, 300)");

			Thread.sleep(250);
			
			// Create new fixture with unique properties
			driver.findElement(By.id("fixturename")).clear();
			driver.findElement(By.id("fixturename")).sendKeys("Test_FIX_DIM_1");
			new Select(driver.findElement(By.id("fixturetype"))).selectByIndex(1);
			new Select(driver.findElement(By.id("starting_output"))).selectByIndex(0);
			new Select(driver.findElement(By.id("fixtureparam_0"))).selectByIndex(1);
			new Select(driver.findElement(By.id("fixtureparam_1"))).selectByIndex(1);
			new Select(driver.findElement(By.id("fixtureparam_2"))).selectByIndex(1);
			new Select(driver.findElement(By.id("fixtureparam_3"))).selectByIndex(5);
			new Select(driver.findElement(By.id("fixtureparam_4"))).selectByIndex(3);
			new Select(driver.findElement(By.id("fixtureparam_5"))).selectByIndex(1);
		    new Select(driver.findElement(By.id("fixtureparam_6"))).selectByIndex(2);
		    new Select(driver.findElement(By.id("fixtureparam_7"))).selectByIndex(3);
		    new Select(driver.findElement(By.id("fixtureparam_8"))).selectByIndex(4);
		    new Select(driver.findElement(By.id("fixtureparam_9"))).selectByIndex(5);
		    new Select(driver.findElement(By.id("fixtureparam_10"))).selectByIndex(6);
			new Select(driver.findElement(By.id("fixtureparam_11"))).selectByIndex(1);
			new Select(driver.findElement(By.id("fixtureparam_12"))).selectByIndex(1);
			new Select(driver.findElement(By.id("fixtureparam_13"))).selectByIndex(1);
			new Select(driver.findElement(By.id("fixtureparam_14"))).selectByIndex(1);
			new Select(driver.findElement(By.id("fixtureparam_15"))).selectByIndex(0);
			driver.findElement(By.id("btsavefixture")).click();
			
			jse.executeScript("scroll(0, 350)");
			Thread.sleep(250);

			// Create new fixture with unique properties
			driver.findElement(By.id("fixturename")).clear();
			driver.findElement(By.id("fixturename")).sendKeys("Test_FIX_RGBW");
			new Select(driver.findElement(By.id("fixturetype"))).selectByIndex(4);
			new Select(driver.findElement(By.id("starting_output"))).selectByIndex(1);
			new Select(driver.findElement(By.id("fixtureparam_0"))).selectByIndex(0);
			new Select(driver.findElement(By.id("fixtureparam_1"))).selectByIndex(0);
			new Select(driver.findElement(By.id("fixtureparam_2"))).selectByIndex(0);
			new Select(driver.findElement(By.id("fixtureparam_3"))).selectByIndex(0);
			new Select(driver.findElement(By.id("fixtureparam_4"))).selectByIndex(0);
			new Select(driver.findElement(By.id("fixtureparam_5"))).selectByIndex(0);
		    new Select(driver.findElement(By.id("fixtureparam_6"))).selectByIndex(0);
		    new Select(driver.findElement(By.id("fixtureparam_7"))).selectByIndex(0);
		    new Select(driver.findElement(By.id("fixtureparam_8"))).selectByIndex(0);
		    new Select(driver.findElement(By.id("fixtureparam_9"))).selectByIndex(0);
		    new Select(driver.findElement(By.id("fixtureparam_10"))).selectByIndex(0);
			new Select(driver.findElement(By.id("fixtureparam_11"))).selectByIndex(0);
			new Select(driver.findElement(By.id("fixtureparam_12"))).selectByIndex(0);
			new Select(driver.findElement(By.id("fixtureparam_13"))).selectByIndex(0);
			new Select(driver.findElement(By.id("fixtureparam_14"))).selectByIndex(0);
			new Select(driver.findElement(By.id("fixtureparam_15"))).selectByIndex(1);
			driver.findElement(By.id("btsavefixture")).click();

			jse.executeScript("scroll(0, 400)");
			Thread.sleep(250);

			// Create new fixture with unique properties
			driver.findElement(By.id("fixturename")).clear();
			driver.findElement(By.id("fixturename")).sendKeys("Test_FIX_CCT_CD");
			new Select(driver.findElement(By.id("fixturetype"))).selectByIndex(2);
			new Select(driver.findElement(By.id("starting_output"))).selectByIndex(5);
			driver.findElement(By.id("candledim")).click();
			driver.findElement(By.id("minctemp")).clear();
			driver.findElement(By.id("minctemp")).sendKeys("3000");
			driver.findElement(By.id("maxctemp")).clear();
			driver.findElement(By.id("maxctemp")).sendKeys("5000");
			new Select(driver.findElement(By.id("fixtureparam_0"))).selectByIndex(0);
			new Select(driver.findElement(By.id("fixtureparam_1"))).selectByIndex(3);
			new Select(driver.findElement(By.id("fixtureparam_2"))).selectByIndex(4);
			new Select(driver.findElement(By.id("fixtureparam_3"))).selectByIndex(3);
			new Select(driver.findElement(By.id("fixtureparam_4"))).selectByIndex(5);
			new Select(driver.findElement(By.id("fixtureparam_5"))).selectByIndex(4);
		    new Select(driver.findElement(By.id("fixtureparam_6"))).selectByIndex(3);
		    new Select(driver.findElement(By.id("fixtureparam_7"))).selectByIndex(2);
		    new Select(driver.findElement(By.id("fixtureparam_8"))).selectByIndex(3);
		    new Select(driver.findElement(By.id("fixtureparam_9"))).selectByIndex(4);
		    new Select(driver.findElement(By.id("fixtureparam_10"))).selectByIndex(4);
			new Select(driver.findElement(By.id("fixtureparam_11"))).selectByIndex(4);
			new Select(driver.findElement(By.id("fixtureparam_12"))).selectByIndex(2);
			new Select(driver.findElement(By.id("fixtureparam_13"))).selectByIndex(0);
			new Select(driver.findElement(By.id("fixtureparam_14"))).selectByIndex(0);
			new Select(driver.findElement(By.id("fixtureparam_15"))).selectByIndex(2);
			driver.findElement(By.id("btsavefixture")).click();
			
			jse.executeScript("scroll(0, 400)");
			Thread.sleep(250);
			
			// Create new fixture with unique properties
			driver.findElement(By.id("fixturename")).clear();
			driver.findElement(By.id("fixturename")).sendKeys("Test_FIX_ON_OFF");
			driver.findElement(By.id("twelvevolt")).click();
			new Select(driver.findElement(By.id("fixturetype"))).selectByIndex(0);
			new Select(driver.findElement(By.id("starting_output"))).selectByIndex(7);
			new Select(driver.findElement(By.id("fixtureparam_0"))).selectByIndex(0);
			new Select(driver.findElement(By.id("fixtureparam_1"))).selectByIndex(0);
			new Select(driver.findElement(By.id("fixtureparam_2"))).selectByIndex(0);
			new Select(driver.findElement(By.id("fixtureparam_3"))).selectByIndex(6);
			new Select(driver.findElement(By.id("fixtureparam_4"))).selectByIndex(1);
			new Select(driver.findElement(By.id("fixtureparam_5"))).selectByIndex(0);
		    new Select(driver.findElement(By.id("fixtureparam_6"))).selectByIndex(0);
		    new Select(driver.findElement(By.id("fixtureparam_7"))).selectByIndex(0);
		    new Select(driver.findElement(By.id("fixtureparam_8"))).selectByIndex(0);
		    new Select(driver.findElement(By.id("fixtureparam_9"))).selectByIndex(0);
		    new Select(driver.findElement(By.id("fixtureparam_10"))).selectByIndex(0);
			new Select(driver.findElement(By.id("fixtureparam_11"))).selectByIndex(0);
			new Select(driver.findElement(By.id("fixtureparam_12"))).selectByIndex(0);
			new Select(driver.findElement(By.id("fixtureparam_13"))).selectByIndex(0);
			new Select(driver.findElement(By.id("fixtureparam_14"))).selectByIndex(0);
			new Select(driver.findElement(By.id("fixtureparam_15"))).selectByIndex(3);
			driver.findElement(By.id("btsavefixture")).click();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed due to an unhandled Exception");
		}
	}

	@Test(priority = 4)
	public void checkAllFixtures() {
		try {
			// Wait at least most 5 seconds before declaring item not visible
			//WebDriverWait wait = new WebDriverWait(driver, 5);

			jse = (JavascriptExecutor) driver;
			jse.executeScript("scroll(0, 300)");
			Thread.sleep(250);
		    
		    driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[2]/td")).click();
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[2]/td")).getText(), "Test_FIX_DIM_1");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[2]/td[2]")).getText(), "dim");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[2]/td[3]")).getText(), "rpdg-pwm");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[2]/td[4]")).getText(), "1");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_0']/option[2]")).getText(), "Forward Phase Dimming");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_1']/option[2]")).getText(), "<1 sec");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_2']/option[2]")).getText(), "<1 sec");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_3']/option[6]")).getText(), "75 %");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_4']/option[4]")).getText(), "25 %");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_5']/option[2]")).getText(), "Off");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_6']/option[3]")).getText(), "10 %");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_7']/option[4]")).getText(), "25 %");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_8']/option[5]")).getText(), "50 %");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_9']/option[6]")).getText(), "75 %");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_10']/option[7]")).getText(), "100 %");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_11']/option[2]")).getText(), "60%");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_12']/option[2]")).getText(), "0%");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_13']/option[2]")).getText(), "60%");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_14']/option[2]")).getText(), "0%");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_15']/option[1]")).getText(), "0 %");

			Thread.sleep(250);
			
		    driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[4]/td")).click();
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[4]/td")).getText(), "Test_FIX_RGBW");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[4]/td[2]")).getText(), "rgbw");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[4]/td[3]")).getText(), "rpdg-pwm");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[4]/td[4]")).getText(), "2");
		    jse.executeScript("scroll(0, 350)");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_0']/option[1]")).getText(), "0-10V DC Dimming");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_1']/option[1]")).getText(), "Instant");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_2']/option[1]")).getText(), "Instant");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_3']/option[1]")).getText(), "Ignore");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_4']/option[1]")).getText(), "Ignore");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_5']/option[1]")).getText(), "Ignore");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_6']/option[1]")).getText(), "Ignore");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_7']/option[1]")).getText(), "Ignore");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_8']/option[1]")).getText(), "Ignore");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_9']/option[1]")).getText(), "Ignore");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_10']/option[1]")).getText(), "Ignore");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_11']/option[1]")).getText(), "Ignore");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_12']/option[1]")).getText(), "Ignore");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_13']/option[1]")).getText(), "Ignore");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_14']/option[1]")).getText(), "Ignore");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_15']/option[2]")).getText(), "1 %");

			Thread.sleep(250);
			
		    driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr/td")).click();
			assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr/td")).getText(), "Test_FIX_CCT_CD");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr/td[2]")).getText(), "cct");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr/td[3]")).getText(), "rpdg-pwm");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr/td[4]")).getText(), "6");
		    jse.executeScript("scroll(0, 400)");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_0']/option[1]")).getText(), "0-10V DC Dimming");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_1']/option[4]")).getText(), "<5 sec");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_2']/option[5]")).getText(), "<10 sec");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_3']/option[4]")).getText(), "25 %");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_4']/option[6]")).getText(), "75 %");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_5']/option[5]")).getText(), "50 %");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_6']/option[4]")).getText(), "25 %");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_7']/option[3]")).getText(), "10 %");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_8']/option[4]")).getText(), "25 %");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_9']/option[5]")).getText(), "50 %");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_10']/option[5]")).getText(), "50 %");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_11']/option[5]")).getText(), "90 %");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_12']/option[3]")).getText(), "10 %");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_13']/option[1]")).getText(), "Ignore");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_14']/option[1]")).getText(), "Ignore");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_15']/option[3]")).getText(), "5 %");

			Thread.sleep(250);
			
		    driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[3]/td")).click();
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[3]/td")).getText(), "Test_FIX_ON_OFF");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[3]/td[2]")).getText(), "on_off");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[3]/td[3]")).getText(), "rpdg-pwm");
		    assertEquals(driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[3]/td[4]")).getText(), "8");
		    jse.executeScript("scroll(0, 400)");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_0']/option[1]")).getText(), "0-10V DC Dimming");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_1']/option[1]")).getText(), "Instant");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_2']/option[1]")).getText(), "Instant");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_3']/option[7]")).getText(), "100 %");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_4']/option[2]")).getText(), "Off");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_5']/option[1]")).getText(), "Ignore");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_6']/option[1]")).getText(), "Ignore");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_7']/option[1]")).getText(), "Ignore");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_8']/option[1]")).getText(), "Ignore");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_9']/option[1]")).getText(), "Ignore");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_10']/option[1]")).getText(), "Ignore");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_11']/option[1]")).getText(), "Ignore");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_12']/option[1]")).getText(), "Ignore");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_13']/option[1]")).getText(), "Ignore");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_14']/option[1]")).getText(), "Ignore");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fixtureparam_15']/option[4]")).getText(), "10 %");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed due to an unhandled Exception");
		}
	}
	
	@Test(priority = 5)
	public void changeFixtureIcon() throws Exception{
		try {
			// Wait at least most 5 seconds before declaring item not visible
			WebDriverWait wait = new WebDriverWait(driver, 5);

			jse = (JavascriptExecutor) driver;
			jse.executeScript("scroll(0, 300)");
		    
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='fixturetable']/tbody/tr[1]/td[5]")));
		    driver.findElement(By.xpath("//*[@id='fixturetable']/tbody/tr[1]/td[5]/img")).click();
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='myModal']/div/ul/li[18]/div/img")));
		    driver.findElement(By.xpath("//*[@id='myModal']/div/ul/li[18]/div/img")).click();
			Thread.sleep(500);
		    driver.findElement(By.id("btsaveimage")).click();
		    
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='fixturetable']/tbody/tr[2]/td[5]")));
		    driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[2]/td[5]/img")).click();
		    driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[2]/td[5]/img")).click();
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='myModal']/div/ul/li[3]/div/img")));
		    driver.findElement(By.xpath("//*[@id='myModal']/div/ul/li[3]/div/img")).click();
			Thread.sleep(500);
		    driver.findElement(By.id("btsaveimage")).click();
		    
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='fixturetable']/tbody/tr[3]/td[5]")));
		    driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[3]/td[5]/img")).click();
		    driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[3]/td[5]/img")).click();
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='myModal']/div/ul/li[5]/div/img")));
		    driver.findElement(By.xpath("//*[@id='myModal']/div/ul/li[5]/div/img")).click();
			Thread.sleep(500);
		    driver.findElement(By.id("btsaveimage")).click();
		    
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='fixturetable']/tbody/tr[4]/td[5]")));
		    driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[4]/td[5]/img")).click();
		    driver.findElement(By.xpath("//table[@id='fixturetable']/tbody/tr[4]/td[5]/img")).click();
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='myModal']/div/ul/li[6]/div/img")));
		    driver.findElement(By.xpath("//*[@id='myModal']/div/ul/li[6]/div/img")).click();
			Thread.sleep(500);
		    driver.findElement(By.id("btsaveimage")).click();
		    

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed due to an unhandled Exception");
		}
	}
	
	@Test(priority = 6)
	public void deleteAllFixtures() {
		try {
			// Wait at least most 5 seconds before declaring item not visible
			WebDriverWait wait = new WebDriverWait(driver, 5);

			jse = (JavascriptExecutor) driver;
			jse.executeScript("scroll(0, 200)");

			Thread.sleep(500);
			
			// Create new fixture with various parameters
			for (int j = 0; j < 4;) {
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

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}