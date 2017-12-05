//Created by Daniel Kerr 6/8/17
package localhost.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

public class CreateGroups {

	WebDriver driver;
	JavascriptExecutor jse;

	@BeforeTest
	public void setup() {

		driver = Driver.buildDriver();
		//driver = RemoteDriver.buildDriver();
	}
	
	@Test(priority = 0)
	public void addWiredFixtures() {
		try {
			// Navigate to Configuration page
			driver.findElement(By.linkText("Configuration")).click();

			// Scroll part-way down the page to find elements
			jse = (JavascriptExecutor) driver;
			jse.executeScript("scroll(0, 200)");

			// Create new fixture with various parameters
			for (int j = 1; j < 9;) {
				driver.findElement(By.id("fixturename")).clear();
				driver.findElement(By.id("fixturename")).sendKeys("Test_FIX_DIM_" + j);
				new Select(driver.findElement(By.id("fixturetype"))).selectByVisibleText("DIMMABLE");
				new Select(driver.findElement(By.id("starting_output"))).selectByIndex(j - 1);
				driver.findElement(By.id("btsavefixture")).click();
				Thread.sleep(500);
				j++;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed due to an unhandled Exception");
		}
	}

	@Test(priority = 1)
	public void createAllGroups() {
		try {
			// Create object of actions class
			Actions act = new Actions(driver);

			// Navigate to Configuration page
			driver.findElement(By.linkText("Groups")).click();

			// Click the "New Group" Button and create an ALL group
			driver.findElement(By.id("btmakescene")).click();
			driver.findElement(By.id("group_name")).sendKeys("ALL");
			driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("group_0")).click();
			for (int j = 0; j < 8;) {
				WebElement drag = driver.findElement(By.xpath(".//*[@id='fixholder']/div/img"));
				WebElement drop = driver.findElement(By.id("group_0"));
				act.dragAndDrop(drag, drop).build().perform();
				j++;
			}

			driver.findElement(By.id("btmakescene")).click();
			driver.findElement(By.id("group_name")).sendKeys("Evens");
			driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("group_1")).click();
			WebElement drag1 = driver.findElement(By.xpath(".//*[@id='fixholder']/div[2]/img"));
			WebElement drop1 = driver.findElement(By.id("group_1"));
			act.dragAndDrop(drag1, drop1).build().perform();
			WebElement drag2 = driver.findElement(By.xpath(".//*[@id='fixholder']/div[3]/img"));
			WebElement drop2 = driver.findElement(By.id("group_1"));
			act.dragAndDrop(drag2, drop2).build().perform();
			WebElement drag3 = driver.findElement(By.xpath(".//*[@id='fixholder']/div[4]/img"));
			WebElement drop3 = driver.findElement(By.id("group_1"));
			act.dragAndDrop(drag3, drop3).build().perform();
			WebElement drag4 = driver.findElement(By.xpath(".//*[@id='fixholder']/div[5]/img"));
			WebElement drop4 = driver.findElement(By.id("group_1"));
			act.dragAndDrop(drag4, drop4).build().perform();

			driver.findElement(By.id("btmakescene")).click();
			driver.findElement(By.id("group_name")).sendKeys("Odds");
			driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("group_2")).click();
			WebElement drag2_1 = driver.findElement(By.xpath(".//*[@id='fixholder']/div/img"));
			WebElement drop2_1 = driver.findElement(By.id("group_2"));
			act.dragAndDrop(drag2_1, drop2_1).build().perform();
			WebElement drag2_2 = driver.findElement(By.xpath(".//*[@id='fixholder']/div[2]/img"));
			WebElement drop2_2 = driver.findElement(By.id("group_2"));
			act.dragAndDrop(drag2_2, drop2_2).build().perform();
			WebElement drag2_3 = driver.findElement(By.xpath(".//*[@id='fixholder']/div[3]/img"));
			WebElement drop2_3 = driver.findElement(By.id("group_2"));
			act.dragAndDrop(drag2_3, drop2_3).build().perform();
			WebElement drag2_4 = driver.findElement(By.xpath(".//*[@id='fixholder']/div[4]/img"));
			WebElement drop2_4 = driver.findElement(By.id("group_2"));
			act.dragAndDrop(drag2_4, drop2_4).build().perform();

			driver.findElement(By.id("btmakescene")).click();
			driver.findElement(By.id("group_name")).sendKeys("FirstHalf");
			driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("group_3")).click();
			WebElement drag3_1 = driver.findElement(By.xpath(".//*[@id='fixholder']/div/img"));
			WebElement drop3_1 = driver.findElement(By.id("group_3"));
			act.dragAndDrop(drag3_1, drop3_1).build().perform();
			WebElement drag3_2 = driver.findElement(By.xpath(".//*[@id='fixholder']/div/img"));
			WebElement drop3_2 = driver.findElement(By.id("group_3"));
			act.dragAndDrop(drag3_2, drop3_2).build().perform();
			WebElement drag3_3 = driver.findElement(By.xpath(".//*[@id='fixholder']/div/img"));
			WebElement drop3_3 = driver.findElement(By.id("group_3"));
			act.dragAndDrop(drag3_3, drop3_3).build().perform();
			WebElement drag3_4 = driver.findElement(By.xpath(".//*[@id='fixholder']/div/img"));
			WebElement drop3_4 = driver.findElement(By.id("group_3"));
			act.dragAndDrop(drag3_4, drop3_4).build().perform();

			driver.findElement(By.id("btmakescene")).click();
			driver.findElement(By.id("group_name")).sendKeys("SecondHalf");
			driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("group_4")).click();
			WebElement drag4_1 = driver.findElement(By.xpath(".//*[@id='fixholder']/div[5]/img"));
			WebElement drop4_1 = driver.findElement(By.id("group_4"));
			act.dragAndDrop(drag4_1, drop4_1).build().perform();
			WebElement drag4_2 = driver.findElement(By.xpath(".//*[@id='fixholder']/div[5]/img"));
			WebElement drop4_2 = driver.findElement(By.id("group_4"));
			act.dragAndDrop(drag4_2, drop4_2).build().perform();
			WebElement drag4_3 = driver.findElement(By.xpath(".//*[@id='fixholder']/div[5]/img"));
			WebElement drop4_3 = driver.findElement(By.id("group_4"));
			act.dragAndDrop(drag4_3, drop4_3).build().perform();
			WebElement drag4_4 = driver.findElement(By.xpath(".//*[@id='fixholder']/div[5]/img"));
			WebElement drop4_4 = driver.findElement(By.id("group_4"));
			act.dragAndDrop(drag4_4, drop4_4).build().perform();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed due to an unhandled Exception");
		}
	}

	@Test(priority = 2)
	public void clearAllGroups() {
		try {
			// Wait at least most 5 seconds before declaring item not visible
			WebDriverWait wait = new WebDriverWait(driver, 5);
			// Navigate to Configuration page
			driver.findElement(By.linkText("Groups")).click();

			// Click Group ALL and select delete
			for (int j = 0; j < 5;) {
				driver.findElement(By.id("group_0")).click();
				driver.findElement(By.id("actionbuttons_0")).click();
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.btn-primary")));
				driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
				Thread.sleep(500);
				j++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed due to an unhandled Exception");
		}
	}

	@Test(priority = 3)
	public void deleteAllFixtures() {
		try {
			// Navigate Configuration page
			driver.findElement(By.linkText("Configuration")).click();
			// Wait at least most 5 seconds before declaring item not visible
			WebDriverWait wait = new WebDriverWait(driver, 5);

			jse = (JavascriptExecutor) driver;
			jse.executeScript("scroll(0, 200)");
			
			// Create new fixture with various parameters
			for (int j = 0; j < 8;) {
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