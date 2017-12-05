//Created by Daniel Kerr 6/8/17
package localhost.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.*;
import org.testng.annotations.*;

public class MultiInputs {

	WebDriver driver;
	JavascriptExecutor jse;

	@BeforeTest
	public void setup() {

			driver = Driver.buildDriver();
			//driver = RemoteDriver.buildDriver();

	}
	
	@Test(priority = 0)
	public void createGroupAll() {
		try {
			// Navigate to Configuration page
			driver.findElement(By.linkText("Groups")).click();
			
			// Click the "New Group" Button and create an ALL group
			driver.findElement(By.id("btmakescene")).click();
			Thread.sleep(250);
			driver.findElement(By.id("group_name")).sendKeys("ALL");
			driver.findElement(By.cssSelector("button.btn.btn-primary")).click();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed due to an unhandled Exception");
		}
	}
	
	@Test(priority = 1)
	public void addWetDryContacts() {
		try {
			// Wait 1 second for screen fade to disappear and allow buttons to be clickable
			Thread.sleep(1000);
			driver.findElement(By.linkText("Configuration")).click();

			// Scroll part-way down the page to find elements
			jse = (JavascriptExecutor) driver;
			jse.executeScript("scroll(0, 1000)");
			
			driver.findElement(By.id("contactname")).sendKeys("Button_1");
			Thread.sleep(250);
			new Select(driver.findElement(By.id("active_action_sel_part1"))).selectByVisibleText("Invoke Scene");
			new Select(driver.findElement(By.id("active_action_sel_part2"))).selectByVisibleText("ALL_15");
			driver.findElement(By.id("btsaveinputcontactobj")).click();

			Thread.sleep(250);
			
			driver.findElement(By.id("contactname")).sendKeys("Switch_1");
			Thread.sleep(250);
			new Select(driver.findElement(By.id("contact_inputnum"))).selectByVisibleText("2");
			driver.findElement(By.id("maintained")).click();
			new Select(driver.findElement(By.id("active_action_sel_part1"))).selectByVisibleText("Invoke Scene");
			new Select(driver.findElement(By.id("active_action_sel_part2"))).selectByVisibleText("ALL_ON");
			new Select(driver.findElement(By.id("inactive_action_sel_part1"))).selectByVisibleText("Invoke Scene");
			new Select(driver.findElement(By.id("inactive_action_sel_part2"))).selectByVisibleText("ALL_OFF");
			driver.findElement(By.id("btsaveinputcontactobj")).click();

			jse.executeScript("scroll(0, 1100)");			
			Thread.sleep(250);
			
			driver.findElement(By.id("contactname")).sendKeys("Occupancy_1");
			Thread.sleep(250);
			new Select(driver.findElement(By.id("contact_inputnum"))).selectByVisibleText("3");
			driver.findElement(By.id("maintained")).click();
			new Select(driver.findElement(By.id("active_action_sel_part1"))).selectByVisibleText("Send Message");
			new Select(driver.findElement(By.id("active_action_sel_part2"))).selectByVisibleText("Occupancy");
			new Select(driver.findElement(By.id("inactive_action_sel_part1"))).selectByVisibleText("Send Message");
			new Select(driver.findElement(By.id("inactive_action_sel_part2"))).selectByVisibleText("Vacancy");
			driver.findElement(By.id("btsaveinputcontactobj")).click();

			jse.executeScript("scroll(0, 1200)");
			Thread.sleep(250);
			
			driver.findElement(By.id("contactname")).sendKeys("Script_Switch");
			Thread.sleep(250);
			new Select(driver.findElement(By.id("contact_inputnum"))).selectByVisibleText("4");
			driver.findElement(By.id("maintained")).click();
			new Select(driver.findElement(By.id("active_action_sel_part1"))).selectByVisibleText("Run Script");
			new Select(driver.findElement(By.id("active_action_sel_part2"))).selectByVisibleText("alarmmode.js");
			new Select(driver.findElement(By.id("inactive_action_sel_part1"))).selectByVisibleText("Run Script");
			new Select(driver.findElement(By.id("inactive_action_sel_part2"))).selectByVisibleText("quietmode.js");
			jse.executeScript("scroll(0, 1200)");
			driver.findElement(By.id("btsaveinputcontactobj")).click();
			driver.findElement(By.xpath("//*[@id='wetdrycontacttable']/thead/tr/th[3]")).click();
			jse.executeScript("scroll(0, 1200)");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed due to an unhandled Exception");
		}
	}
	
	@Test(priority = 2)
	public void checkInputs() {
		try {

			Thread.sleep(250);
		    assertEquals(driver.findElement(By.xpath("//table[@id='wetdrycontacttable']/tbody/tr/td")).getText(), "Button_1");
		    assertEquals(driver.findElement(By.xpath("//table[@id='wetdrycontacttable']/tbody/tr/td[2]")).getText(), "rpdg");
		    assertEquals(driver.findElement(By.xpath("//table[@id='wetdrycontacttable']/tbody/tr/td[3]")).getText(), "1");
		    assertEquals(driver.findElement(By.xpath("//table[@id='wetdrycontacttable']/tbody/tr/td[4]")).getText(), "momentary");
		    assertEquals(driver.findElement(By.xpath("//table[@id='wetdrycontacttable']/tbody/tr/td[5]")).getText(), "scene_@@_ALL_15");
		    assertEquals(driver.findElement(By.xpath("//table[@id='wetdrycontacttable']/tbody/tr/td[6]")).getText(), "action_none");
			Thread.sleep(250);
			assertEquals(driver.findElement(By.xpath("//table[@id='wetdrycontacttable']/tbody/tr[2]/td")).getText(), "Occupancy_1");
		    assertEquals(driver.findElement(By.xpath("//table[@id='wetdrycontacttable']/tbody/tr[2]/td[2]")).getText(), "rpdg");
		    assertEquals(driver.findElement(By.xpath("//table[@id='wetdrycontacttable']/tbody/tr[2]/td[3]")).getText(), "3");
		    assertEquals(driver.findElement(By.xpath("//table[@id='wetdrycontacttable']/tbody/tr[2]/td[4]")).getText(), "maintained");
		    assertEquals(driver.findElement(By.xpath("//table[@id='wetdrycontacttable']/tbody/tr[2]/td[5]")).getText(), "msg_@@_Occupancy_@@_ALL_@@_0");
		    assertEquals(driver.findElement(By.xpath("//table[@id='wetdrycontacttable']/tbody/tr[2]/td[6]")).getText(), "msg_@@_Vacancy_@@_ALL_@@_0");
			Thread.sleep(250);
		    assertEquals(driver.findElement(By.xpath("//table[@id='wetdrycontacttable']/tbody/tr[3]/td")).getText(), "Script_Switch");
		    assertEquals(driver.findElement(By.xpath("//table[@id='wetdrycontacttable']/tbody/tr[3]/td[2]")).getText(), "rpdg");
		    assertEquals(driver.findElement(By.xpath("//table[@id='wetdrycontacttable']/tbody/tr[3]/td[3]")).getText(), "4");
		    assertEquals(driver.findElement(By.xpath("//table[@id='wetdrycontacttable']/tbody/tr[3]/td[4]")).getText(), "maintained");
		    assertEquals(driver.findElement(By.xpath("//table[@id='wetdrycontacttable']/tbody/tr[3]/td[5]")).getText(), "script_@@_alarmmode.js");
		    assertEquals(driver.findElement(By.xpath("//table[@id='wetdrycontacttable']/tbody/tr[3]/td[6]")).getText(), "script_@@_quietmode.js");
			Thread.sleep(250);
		    assertEquals(driver.findElement(By.xpath("//table[@id='wetdrycontacttable']/tbody/tr[4]/td")).getText(), "Switch_1");
		    assertEquals(driver.findElement(By.xpath("//table[@id='wetdrycontacttable']/tbody/tr[4]/td[2]")).getText(), "rpdg");
		    assertEquals(driver.findElement(By.xpath("//table[@id='wetdrycontacttable']/tbody/tr[4]/td[3]")).getText(), "2");
		    assertEquals(driver.findElement(By.xpath("//table[@id='wetdrycontacttable']/tbody/tr[4]/td[4]")).getText(), "maintained");
		    assertEquals(driver.findElement(By.xpath("//table[@id='wetdrycontacttable']/tbody/tr[4]/td[5]")).getText(), "scene_@@_ALL_ON");
		    assertEquals(driver.findElement(By.xpath("//table[@id='wetdrycontacttable']/tbody/tr[4]/td[6]")).getText(), "scene_@@_ALL_OFF");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed due to an unhandled Exception");
		}
	}
	
	@Test(priority = 3)
	public void clearInputs() {
		try {
			// Wait at least most 5 seconds before declaring item not visible
			WebDriverWait wait = new WebDriverWait(driver, 5);
			
			jse = (JavascriptExecutor) driver;
			jse.executeScript("scroll(0, 1500)");
			
			for (int j = 0; j < 4;) {
				// Wait for table element to be clickable after delete
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='wetdrycontacttable']/tbody/tr[1]/td[1]")));
				// Select the first table value
				driver.findElement(By.xpath(".//*[@id='wetdrycontacttable']/tbody/tr[1]/td[1]")).click();
				// Delete selected input
				driver.findElement(By.id("btdelcontact")).click();
				Thread.sleep(500);
				j++;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed due to an unhandled Exception");
		}
	}
	
	@Test(priority = 4)
	public void clearGroupAll() {
		try {
			// Wait at least most 5 seconds before declaring item not visible
			WebDriverWait wait = new WebDriverWait(driver, 5);
			// Navigate to Configuration page
			driver.findElement(By.linkText("Groups")).click();
			
			// Click Group ALL and select delete
			driver.findElement(By.id("group_0")).click();
			driver.findElement(By.id("actionbuttons_0")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.btn-primary")));
			driver.findElement(By.cssSelector("button.btn.btn-primary")).click();

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