//Created by Daniel Kerr 6/27/17
package localhost.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.sikuli.script.Pattern;
//import org.sikuli.script.Screen;
import org.testng.annotations.*;

public class CreateSchedule {

	WebDriver driver;
	//Screen myScreen;

	@BeforeTest
	public void setup() {

			driver = Driver.buildDriver();
			//driver = RemoteDriver.buildDriver();
	}

	/*@Test(priority = 0)
	public void createItems() {
		try {
			driver.findElement(By.linkText("Schedule")).click();

			// Use Actions to simulate a double click on a calendar date that is desired.
			Actions action = new Actions(driver);
			
			Thread.sleep(500);
			
			action.moveToElement(
					driver.findElement(By.xpath("//*[@id='scheduler_here']/div[3]/table/tbody/tr[2]/td[3]/div[2]")))
					.doubleClick().perform();
			new Select(driver.findElement(By.id("eventname"))).selectByVisibleText("ALL_ON");
			new Select(driver.findElement(By.id("eventtimebasesel"))).selectByIndex(1);
			new Select(driver.findElement(By.id("eventtimehour"))).selectByValue("0");
			new Select(driver.findElement(By.id("eventtimemin"))).selectByIndex(30);
			new Select(driver.findElement(By.id("eventrepeat"))).selectByVisibleText("Daily");
			driver.findElement(By.id("save")).click();
			
			Thread.sleep(1500);
			
			action.moveToElement(
					driver.findElement(By.xpath("//*[@id='scheduler_here']/div[3]/table/tbody/tr[2]/td[3]/div[2]")))
					.doubleClick().perform();
			new Select(driver.findElement(By.id("eventname"))).selectByVisibleText("ALL_OFF");
			new Select(driver.findElement(By.id("eventtimebasesel"))).selectByVisibleText("After SunRise");
			new Select(driver.findElement(By.id("eventtimehour"))).selectByValue("0");
			new Select(driver.findElement(By.id("eventtimemin"))).selectByIndex(20);
			new Select(driver.findElement(By.id("eventrepeat"))).selectByVisibleText("Daily");
			driver.findElement(By.id("save")).click();
			
			Thread.sleep(1500);
			
			action.moveToElement(
					driver.findElement(By.xpath("//*[@id='scheduler_here']/div[3]/table/tbody/tr[2]/td[2]/div[2]")))
					.doubleClick().perform();
			new Select(driver.findElement(By.id("eventname"))).selectByVisibleText("ALL_50");
			new Select(driver.findElement(By.id("eventtimebasesel"))).selectByIndex(0);
			driver.findElement(By.id("eventtime")).click();
			Thread.sleep(250);
			driver.findElement(By.cssSelector("input.bootstrap-timepicker-hour")).click();
		    driver.findElement(By.cssSelector("input.bootstrap-timepicker-hour")).clear();
		    driver.findElement(By.cssSelector("input.bootstrap-timepicker-hour")).sendKeys("10");
		    driver.findElement(By.cssSelector("input.bootstrap-timepicker-meridian")).click();
		    driver.findElement(By.cssSelector("input.bootstrap-timepicker-meridian")).clear();
		    driver.findElement(By.cssSelector("input.bootstrap-timepicker-meridian")).sendKeys("PM");
			new Select(driver.findElement(By.id("eventrepeat"))).selectByVisibleText("Weekly");
			driver.findElement(By.id("save")).click();
			
			Thread.sleep(1500);
			
			action.moveToElement(
					driver.findElement(By.xpath("//*[@id='scheduler_here']/div[3]/table/tbody/tr[2]/td[3]/div[2]")))
					.doubleClick().perform();
			new Select(driver.findElement(By.id("eventname"))).selectByVisibleText("ALL_15");
			new Select(driver.findElement(By.id("eventtimebasesel"))).selectByIndex(0);
			driver.findElement(By.id("eventtime")).click();
			Thread.sleep(250);
			driver.findElement(By.cssSelector("input.bootstrap-timepicker-hour")).click();
		    driver.findElement(By.cssSelector("input.bootstrap-timepicker-hour")).clear();
		    driver.findElement(By.cssSelector("input.bootstrap-timepicker-hour")).sendKeys("1");
		    driver.findElement(By.cssSelector("input.bootstrap-timepicker-meridian")).click();
		    driver.findElement(By.cssSelector("input.bootstrap-timepicker-meridian")).clear();
		    driver.findElement(By.cssSelector("input.bootstrap-timepicker-meridian")).sendKeys("AM");
			new Select(driver.findElement(By.id("eventrepeat"))).selectByVisibleText("None");
			driver.findElement(By.id("save")).click();
			
			Thread.sleep(1500);
			
			action.moveToElement(
			driver.findElement(By.xpath("//*[@id='scheduler_here']/div[3]/table/tbody/tr[2]/td[4]/div[2]")))
			.doubleClick().perform();
			new Select(driver.findElement(By.id("eventname"))).selectByVisibleText("ALL_50");
			new Select(driver.findElement(By.id("eventtimebasesel"))).selectByIndex(1);
			new Select(driver.findElement(By.id("eventtimehour"))).selectByValue("1");
			new Select(driver.findElement(By.id("eventtimemin"))).selectByValue("15");
			new Select(driver.findElement(By.id("eventrepeat"))).selectByVisibleText("Daily");
			driver.findElement(By.id("save")).click();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed due to an unhandled Exception");
		}
	}*/
	
	@Test(priority = 0)
	public void deleteItems() {
			try {
				driver.findElement(By.linkText("Schedule")).click();
				Actions action = new Actions(driver);
				WebDriverWait wait = new WebDriverWait(driver, 5);
				
				Thread.sleep(2000);
				
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='scheduler_here']/div[3]/div[26]")));
				action.moveToElement(driver.findElement(By.xpath("//*[@id='scheduler_here']/div[3]/div[26]"))).doubleClick().perform();
				wait.until(ExpectedConditions.elementToBeClickable(By.id("delete")));
				driver.findElement(By.id("delete")).click();
				Thread.sleep(1500);
				
				action.moveToElement(driver.findElement(By.xpath("//*[@id='scheduler_here']/div[3]/div[28]"))).doubleClick().perform();
				wait.until(ExpectedConditions.elementToBeClickable(By.id("delete")));
				driver.findElement(By.id("delete")).click();
				Thread.sleep(1500);
				
				action.moveToElement(driver.findElement(By.xpath("//*[@id='scheduler_here']/div[3]/div[28]"))).doubleClick().perform();
				wait.until(ExpectedConditions.elementToBeClickable(By.id("delete")));
				driver.findElement(By.id("delete")).click();
				Thread.sleep(1500);
				
				action.moveToElement(driver.findElement(By.xpath("//*[@id='scheduler_here']/div[3]/div[19]"))).doubleClick().perform();
				wait.until(ExpectedConditions.elementToBeClickable(By.id("delete")));
				driver.findElement(By.id("delete")).click();
				Thread.sleep(1500);
				
				action.moveToElement(driver.findElement(By.xpath("//*[@id='scheduler_here']/div[3]/div[10]"))).doubleClick().perform();
				wait.until(ExpectedConditions.elementToBeClickable(By.id("delete")));
				driver.findElement(By.id("delete")).click();
				Thread.sleep(1500);
				
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Failed due to an unhandled Exception");
			}
	}
	
	/*@Test(priority = 0)
	public void deleteItems() {
			try {
				myScreen = new Screen();
				
				Pattern p1 = new Pattern("..\\rpdg_ui_tests\\Selenium\\Sikuli\\1AM_ALL_15.jpg");
				Pattern p2 = new Pattern("..\\rpdg_ui_tests\\Selenium\\Sikuli\\SR_ALL_OFF.jpg");
				Pattern p3 = new Pattern("..\\rpdg_ui_tests\\Selenium\\Sikuli\\SS_ALL_50.jpg");
				Pattern p4 = new Pattern("..\\rpdg_ui_tests\\Selenium\\Sikuli\\SS_ALL_ON.jpg");
				Pattern p5 = new Pattern("..\\rpdg_ui_tests\\Selenium\\Sikuli\\10PM_ALL_50.jpg");

				//Wait 1 seconds for pattern to show on page, then try to double click it
				myScreen.wait(p1, 1);
				myScreen.doubleClick(p1);
				Thread.sleep(1000);
				driver.findElement(By.id("delete")).click();
				Thread.sleep(1000);
				myScreen.wait(p2, 1);
				myScreen.doubleClick(p2);
				Thread.sleep(1000);
				driver.findElement(By.id("delete")).click();
				Thread.sleep(1000);
				myScreen.wait(p3, 1);
				myScreen.doubleClick(p3);
				Thread.sleep(1000);
				driver.findElement(By.id("delete")).click();
				Thread.sleep(1000);
				myScreen.wait(p4, 1);
				myScreen.doubleClick(p4);
				Thread.sleep(1000);
				driver.findElement(By.id("delete")).click();
				Thread.sleep(1000);
				myScreen.wait(p5, 1);
				myScreen.doubleClick(p5);
				Thread.sleep(1000);
				driver.findElement(By.id("delete")).click();
				
				Thread.sleep(250);
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Failed due to an unhandled Exception");
			}
	}*/
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}