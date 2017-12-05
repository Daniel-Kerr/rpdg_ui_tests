//Created by Daniel Kerr 7/5/17
package localhost.testing;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class WallStation {

	WebDriver driver;
	JavascriptExecutor jse;
	Screen myScreen;

	@BeforeTest
	public void setup() {

			driver = Driver.buildDriver();
	}

	@Test(priority = 0)
	public void addWiredFixtures() {
		try {
			// Navigate to Configuration page
			driver.findElement(By.linkText("Configuration")).click();

			// Scroll part-way down the page to find elements
			jse = (JavascriptExecutor) driver;
			jse.executeScript("scroll(0, 200)");

			// Create new fixture with unique properties
			driver.findElement(By.id("fixturename")).clear();
			driver.findElement(By.id("fixturename")).sendKeys("Test_FIX_DIM_1");
			new Select(driver.findElement(By.id("fixturetype"))).selectByVisibleText("DIMMABLE");
			new Select(driver.findElement(By.id("starting_output"))).selectByIndex(0);
			driver.findElement(By.id("btsavefixture")).click();

			// Create new fixture with unique properties
			driver.findElement(By.id("fixturename")).clear();
			driver.findElement(By.id("fixturename")).sendKeys("Test_FIX_RGBW");
			new Select(driver.findElement(By.id("fixturetype"))).selectByVisibleText("RGBW");
			new Select(driver.findElement(By.id("starting_output"))).selectByIndex(1);
			driver.findElement(By.id("btsavefixture")).click();

			jse.executeScript("scroll(0, 250)");

			// Create new fixture with unique properties
			driver.findElement(By.id("fixturename")).clear();
			driver.findElement(By.id("fixturename")).sendKeys("Test_FIX_CCT_CD");
			new Select(driver.findElement(By.id("fixturetype"))).selectByVisibleText("CCT");
			new Select(driver.findElement(By.id("starting_output"))).selectByIndex(5);
			driver.findElement(By.id("btsavefixture")).click();

			// Create new fixture with unique properties
			driver.findElement(By.id("fixturename")).clear();
			driver.findElement(By.id("fixturename")).sendKeys("Test_FIX_ON_OFF");
			driver.findElement(By.id("twelvevolt")).click();
			new Select(driver.findElement(By.id("fixturetype"))).selectByVisibleText("ON/OFF");
			new Select(driver.findElement(By.id("starting_output"))).selectByIndex(7);
			driver.findElement(By.id("btsavefixture")).click();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed due to an unhandled Exception");
		}
	}
	
	@Test(priority = 1)
	public void createAllScenes() {
		try {
			// Create object of actions class
			Actions act = new Actions(driver);

			// Navigate to Override/Scene page
			driver.findElement(By.linkText("Override/Scene Edit")).click();
			driver.findElement(By.cssSelector("i.ion-minus-round")).click();
			jse = (JavascriptExecutor) driver;
			jse.executeScript("scroll(0, 300)");

			// Click the "New" Button and create an ALL Scene
			driver.findElement(By.id("btalloff")).click();
			driver.findElement(By.id("btmakescene")).click();
			driver.findElement(By.id("scene_name")).sendKeys("All_to_0");
			driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
			
			Thread.sleep(1000);
			
			driver.findElement(By.id("group_0")).click();
			for (int j = 0; j < 4;) {
				WebElement drag = driver.findElement(By.xpath("//*[@id='fixholder']/div[1]/img"));
				WebElement drop = driver.findElement(By.id("group_0"));
				act.dragAndDrop(drag, drop).build().perform();
				j++;
			}
			
			// Click the "New" Button and create an ALL Scene
			driver.findElement(By.id("btall100")).click();
			driver.findElement(By.id("btmakescene")).click();
			driver.findElement(By.id("scene_name")).sendKeys("All_to_100");
			driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
			
			Thread.sleep(1000);
			
			driver.findElement(By.id("group_1")).click();
			for (int j = 0; j < 4;) {
				WebElement drag = driver.findElement(By.xpath("//*[@id='fixholder']/div[1]/img"));
				WebElement drop = driver.findElement(By.id("group_1"));
				act.dragAndDrop(drag, drop).build().perform();
				j++;
			}
			
			Thread.sleep(1000);
			
			// Click the "New" Button and create an ALL Scene
			driver.findElement(By.id("btall50")).click();
			driver.findElement(By.id("btmakescene")).click();
			driver.findElement(By.id("scene_name")).sendKeys("All_to_50");
			driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
			
			Thread.sleep(1000);
			
			driver.findElement(By.id("group_2")).click();
			for (int j = 0; j < 4;) {
				WebElement drag = driver.findElement(By.xpath("//*[@id='fixholder']/div[1]/img"));
				WebElement drop = driver.findElement(By.id("group_2"));
				act.dragAndDrop(drag, drop).build().perform();
				j++;
			}
			
			// Click the "New" Button and create an ALL Scene
			driver.findElement(By.id("btall15")).click();
			driver.findElement(By.id("btmakescene")).click();
			driver.findElement(By.id("scene_name")).sendKeys("All_to_15");
			driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
			
			Thread.sleep(1000);
			
			driver.findElement(By.id("group_3")).click();
			for (int j = 0; j < 4;) {
				WebElement drag = driver.findElement(By.xpath("//*[@id='fixholder']/div[1]/img"));
				WebElement drop = driver.findElement(By.id("group_3"));
				act.dragAndDrop(drag, drop).build().perform();
				j++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed due to an unhandled Exception");
		}
	}
	
	@Test(priority = 2)
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
			for (int j = 0; j < 4;) {
				WebElement drag = driver.findElement(By.xpath(".//*[@id='fixholder']/div/img"));
				WebElement drop = driver.findElement(By.id("group_0"));
				act.dragAndDrop(drag, drop).build().perform();
				j++;
			}
			
			driver.findElement(By.id("btmakescene")).click();
			driver.findElement(By.id("group_name")).sendKeys("CCT");
			new Select(driver.findElement(By.id("grouptype"))).selectByVisibleText("Color Temp");
			driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("group_1")).click();
			WebElement drag2_1 = driver.findElement(By.xpath(".//*[@id='fixholder']/div/img"));
			WebElement drop2_1 = driver.findElement(By.id("group_1"));
			act.dragAndDrop(drag2_1, drop2_1).build().perform();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed due to an unhandled Exception");
		}
	}
	
	@Test(priority = 3)
	public void checkScenes() {
		try {
			driver.get("http://localhost:3000/wallstation");
			
			driver.findElement(By.id("All_to_0")).click();
			driver.findElement(By.linkText("Status")).click();
			assertEquals(driver.findElement(By.cssSelector("div.level_label > label")).getText(), "0%");
		    assertEquals(driver.findElement(By.cssSelector("#fix1 > div.contentholder > div.status_right > div.level_holder > div.level_label > label")).getText(), "0");
		    assertEquals(driver.findElement(By.xpath("//div[@id='fix1']/div/div[2]/div[2]/div[2]/label")).getText(), "0");
		    assertEquals(driver.findElement(By.xpath("//div[@id='fix1']/div/div[2]/div[3]/div[2]/label")).getText(), "0");
		    assertEquals(driver.findElement(By.xpath("//div[@id='fix1']/div/div[2]/div[4]/div[2]/label")).getText(), "0");
		    assertEquals(driver.findElement(By.cssSelector("#fix2 > div.contentholder > div.status_right > div.level_holder > div.level_label > label")).getText(), "0%");
		    assertEquals(driver.findElement(By.cssSelector("#fix3 > div.contentholder > div.status_right > div.level_holder > div.level_label > label")).getText(), "0%");
		    driver.findElement(By.linkText("Scenes")).click();
		    
		    driver.findElement(By.id("All_to_100")).click();
			driver.findElement(By.linkText("Status")).click();
			assertEquals(driver.findElement(By.cssSelector("div.level_label > label")).getText(), "100%");
		    assertEquals(driver.findElement(By.cssSelector("#fix1 > div.contentholder > div.status_right > div.level_holder > div.level_label > label")).getText(), "100");
		    assertEquals(driver.findElement(By.xpath("//div[@id='fix1']/div/div[2]/div[2]/div[2]/label")).getText(), "100");
		    assertEquals(driver.findElement(By.xpath("//div[@id='fix1']/div/div[2]/div[3]/div[2]/label")).getText(), "100");
		    assertEquals(driver.findElement(By.xpath("//div[@id='fix1']/div/div[2]/div[4]/div[2]/label")).getText(), "100");
		    assertEquals(driver.findElement(By.cssSelector("#fix2 > div.contentholder > div.status_right > div.level_holder > div.level_label > label")).getText(), "100%");
		    assertEquals(driver.findElement(By.cssSelector("#fix3 > div.contentholder > div.status_right > div.level_holder > div.level_label > label")).getText(), "100%");
		    driver.findElement(By.linkText("Scenes")).click();
		    
		    driver.findElement(By.id("All_to_50")).click();
			driver.findElement(By.linkText("Status")).click();
			assertEquals(driver.findElement(By.cssSelector("div.level_label > label")).getText(), "50%");
		    assertEquals(driver.findElement(By.cssSelector("#fix1 > div.contentholder > div.status_right > div.level_holder > div.level_label > label")).getText(), "50");
		    assertEquals(driver.findElement(By.xpath("//div[@id='fix1']/div/div[2]/div[2]/div[2]/label")).getText(), "50");
		    assertEquals(driver.findElement(By.xpath("//div[@id='fix1']/div/div[2]/div[3]/div[2]/label")).getText(), "50");
		    assertEquals(driver.findElement(By.xpath("//div[@id='fix1']/div/div[2]/div[4]/div[2]/label")).getText(), "50");
		    assertEquals(driver.findElement(By.cssSelector("#fix2 > div.contentholder > div.status_right > div.level_holder > div.level_label > label")).getText(), "50%");
		    assertEquals(driver.findElement(By.cssSelector("#fix3 > div.contentholder > div.status_right > div.level_holder > div.level_label > label")).getText(), "100%");
		    driver.findElement(By.linkText("Scenes")).click();
		    
		    driver.findElement(By.id("All_to_15")).click();
			driver.findElement(By.linkText("Status")).click();
			assertEquals(driver.findElement(By.cssSelector("div.level_label > label")).getText(), "15%");
		    assertEquals(driver.findElement(By.cssSelector("#fix1 > div.contentholder > div.status_right > div.level_holder > div.level_label > label")).getText(), "15");
		    assertEquals(driver.findElement(By.xpath("//div[@id='fix1']/div/div[2]/div[2]/div[2]/label")).getText(), "15");
		    assertEquals(driver.findElement(By.xpath("//div[@id='fix1']/div/div[2]/div[3]/div[2]/label")).getText(), "15");
		    assertEquals(driver.findElement(By.xpath("//div[@id='fix1']/div/div[2]/div[4]/div[2]/label")).getText(), "15");
		    assertEquals(driver.findElement(By.cssSelector("#fix2 > div.contentholder > div.status_right > div.level_holder > div.level_label > label")).getText(), "15%");
		    assertEquals(driver.findElement(By.cssSelector("#fix3 > div.contentholder > div.status_right > div.level_holder > div.level_label > label")).getText(), "100%");
		    driver.findElement(By.linkText("Scenes")).click();
			driver.findElement(By.id("All_to_100")).click();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed due to an unhandled Exception");
		}
	}

	@Test(priority = 4)
	public void checkGroups() {
		try {
			driver.get("http://localhost:3000/wallstation");
			
			// Create object of actions class
			Actions act = new Actions(driver);
			
			driver.findElement(By.linkText("Groups")).click();
			driver.findElement(By.id("ALL")).click();
			
			WebElement slider = driver.findElement(By.xpath("//*[@id='js-rangeslider-0']/div[2]"));
		        Action action = (Action) act.dragAndDropBy(slider, 200, 0).build();
		        action.perform();
		        
		    assertEquals(driver.findElement(By.id("brightvalue")).getText(), "68");
			
			driver.findElement(By.linkText("Status")).click();
			assertEquals(driver.findElement(By.cssSelector("div.level_label > label")).getText(), "68%");
		    assertEquals(driver.findElement(By.cssSelector("#fix1 > div.contentholder > div.status_right > div.level_holder > div.level_label > label")).getText(), "100");
		    assertEquals(driver.findElement(By.xpath("//div[@id='fix1']/div/div[2]/div[2]/div[2]/label")).getText(), "100");
		    assertEquals(driver.findElement(By.xpath("//div[@id='fix1']/div/div[2]/div[3]/div[2]/label")).getText(), "100");
		    assertEquals(driver.findElement(By.xpath("//div[@id='fix1']/div/div[2]/div[4]/div[2]/label")).getText(), "68");
		    assertEquals(driver.findElement(By.cssSelector("#fix2 > div.contentholder > div.status_right > div.level_holder > div.level_label > label")).getText(), "68%");
		    assertEquals(driver.findElement(By.cssSelector("#fix3 > div.contentholder > div.status_right > div.level_holder > div.level_label > label")).getText(), "100%");
		    
			driver.findElement(By.linkText("Groups")).click();
			driver.findElement(By.id("ALL")).click();
			
			WebElement slider2 = driver.findElement(By.xpath("//*[@id='js-rangeslider-1']/div[2]"));
		    	Action action2 = (Action) act.dragAndDropBy(slider2, 750, 0).build();
		    	action2.perform();
			
		    assertEquals(driver.findElement(By.id("brightvalue")).getText(), "100");	
		    	
			driver.findElement(By.linkText("Status")).click();
			assertEquals(driver.findElement(By.cssSelector("div.level_label > label")).getText(), "100%");
		    assertEquals(driver.findElement(By.cssSelector("#fix1 > div.contentholder > div.status_right > div.level_holder > div.level_label > label")).getText(), "100");
		    assertEquals(driver.findElement(By.xpath("//div[@id='fix1']/div/div[2]/div[2]/div[2]/label")).getText(), "100");
		    assertEquals(driver.findElement(By.xpath("//div[@id='fix1']/div/div[2]/div[3]/div[2]/label")).getText(), "100");
		    assertEquals(driver.findElement(By.xpath("//div[@id='fix1']/div/div[2]/div[4]/div[2]/label")).getText(), "100");
		    assertEquals(driver.findElement(By.cssSelector("#fix2 > div.contentholder > div.status_right > div.level_holder > div.level_label > label")).getText(), "100%");
		    assertEquals(driver.findElement(By.cssSelector("#fix3 > div.contentholder > div.status_right > div.level_holder > div.level_label > label")).getText(), "100%");
		    
			driver.findElement(By.linkText("Groups")).click();
			driver.findElement(By.id("ALL")).click();
			
			WebElement slider3 = driver.findElement(By.xpath("//*[@id='js-rangeslider-2']/div[2]"));
		    	Action action3 = (Action) act.dragAndDropBy(slider3, -200, 0).build();
		    	action3.perform();
			
		    assertEquals(driver.findElement(By.id("brightvalue")).getText(), "32");
		    	
			driver.findElement(By.linkText("Status")).click();
			assertEquals(driver.findElement(By.cssSelector("div.level_label > label")).getText(), "32%");
		    assertEquals(driver.findElement(By.cssSelector("#fix1 > div.contentholder > div.status_right > div.level_holder > div.level_label > label")).getText(), "100");
		    assertEquals(driver.findElement(By.xpath("//div[@id='fix1']/div/div[2]/div[2]/div[2]/label")).getText(), "100");
		    assertEquals(driver.findElement(By.xpath("//div[@id='fix1']/div/div[2]/div[3]/div[2]/label")).getText(), "100");
		    assertEquals(driver.findElement(By.xpath("//div[@id='fix1']/div/div[2]/div[4]/div[2]/label")).getText(), "32");
		    assertEquals(driver.findElement(By.cssSelector("#fix2 > div.contentholder > div.status_right > div.level_holder > div.level_label > label")).getText(), "32%");
		    assertEquals(driver.findElement(By.cssSelector("#fix3 > div.contentholder > div.status_right > div.level_holder > div.level_label > label")).getText(), "100%");
		    
		    driver.findElement(By.linkText("Groups")).click();
			driver.findElement(By.id("ALL")).click();
			
			WebElement slider4 = driver.findElement(By.xpath("//*[@id='js-rangeslider-3']/div[2]"));
		    	Action action4 = (Action) act.dragAndDropBy(slider4, -547, 0).build();
		    	action4.perform();
			
		    assertEquals(driver.findElement(By.id("brightvalue")).getText(), "0");
		    	
			driver.findElement(By.linkText("Status")).click();
			assertEquals(driver.findElement(By.cssSelector("div.level_label > label")).getText(), "0%");
		    assertEquals(driver.findElement(By.cssSelector("#fix1 > div.contentholder > div.status_right > div.level_holder > div.level_label > label")).getText(), "100");
		    assertEquals(driver.findElement(By.xpath("//div[@id='fix1']/div/div[2]/div[2]/div[2]/label")).getText(), "100");
		    assertEquals(driver.findElement(By.xpath("//div[@id='fix1']/div/div[2]/div[3]/div[2]/label")).getText(), "100");
		    assertEquals(driver.findElement(By.xpath("//div[@id='fix1']/div/div[2]/div[4]/div[2]/label")).getText(), "0");
		    assertEquals(driver.findElement(By.cssSelector("#fix2 > div.contentholder > div.status_right > div.level_holder > div.level_label > label")).getText(), "0%");
		    assertEquals(driver.findElement(By.cssSelector("#fix3 > div.contentholder > div.status_right > div.level_holder > div.level_label > label")).getText(), "0%");
		    
		    driver.findElement(By.linkText("Groups")).click();
			driver.findElement(By.id("CCT")).click();
			
			WebElement slider5 = driver.findElement(By.xpath("//*[@id='js-rangeslider-4']/div[2]"));
		    	Action action5 = (Action) act.dragAndDropBy(slider5, 200, 0).build();
		    	action5.perform();
		    assertEquals(driver.findElement(By.id("brightvalue")).getText(), "68");
		    
			WebElement slider6 = driver.findElement(By.xpath("//*[@id='js-rangeslider-5']/div[2]"));
	    		Action action6 = (Action) act.dragAndDropBy(slider6, 200, 0).build();
	    		action6.perform();
	    	assertEquals(driver.findElement(By.id("colortempvalue")).getText(), "4410 K");
		    	
			driver.findElement(By.linkText("Status")).click();
			assertEquals(driver.findElement(By.cssSelector("div.level_label > label")).getText(), "0%");
		    assertEquals(driver.findElement(By.cssSelector("#fix1 > div.contentholder > div.status_right > div.level_holder > div.level_label > label")).getText(), "100");
		    assertEquals(driver.findElement(By.xpath("//div[@id='fix1']/div/div[2]/div[2]/div[2]/label")).getText(), "100");
		    assertEquals(driver.findElement(By.xpath("//div[@id='fix1']/div/div[2]/div[3]/div[2]/label")).getText(), "100");
		    assertEquals(driver.findElement(By.xpath("//div[@id='fix1']/div/div[2]/div[4]/div[2]/label")).getText(), "0");
		    assertEquals(driver.findElement(By.cssSelector("#fix2 > div.contentholder > div.status_right > div.level_holder > div.level_label > label")).getText(), "68%");
		    assertEquals(driver.findElement(By.xpath("//div[@id='fix2']/div/div[2]/div[2]/div[2]/label")).getText(), "4410K");
		    assertEquals(driver.findElement(By.cssSelector("#fix3 > div.contentholder > div.status_right > div.level_holder > div.level_label > label")).getText(), "0%");
		    
		    driver.findElement(By.linkText("Groups")).click();
			driver.findElement(By.id("CCT")).click();
			
			WebElement slider7 = driver.findElement(By.xpath("//*[@id='js-rangeslider-6']/div[2]"));
		    	Action action7 = (Action) act.dragAndDropBy(slider7, -200, 0).build();
		    	action7.perform();
		    assertEquals(driver.findElement(By.id("brightvalue")).getText(), "32");
		    
			WebElement slider8 = driver.findElement(By.xpath("//*[@id='js-rangeslider-7']/div[2]"));
	    		Action action8 = (Action) act.dragAndDropBy(slider8, -200, 0).build();
	    		action8.perform();
	    	assertEquals(driver.findElement(By.id("colortempvalue")).getText(), "3042 K");
		    	
			driver.findElement(By.linkText("Status")).click();
			assertEquals(driver.findElement(By.cssSelector("div.level_label > label")).getText(), "0%");
		    assertEquals(driver.findElement(By.cssSelector("#fix1 > div.contentholder > div.status_right > div.level_holder > div.level_label > label")).getText(), "100");
		    assertEquals(driver.findElement(By.xpath("//div[@id='fix1']/div/div[2]/div[2]/div[2]/label")).getText(), "100");
		    assertEquals(driver.findElement(By.xpath("//div[@id='fix1']/div/div[2]/div[3]/div[2]/label")).getText(), "100");
		    assertEquals(driver.findElement(By.xpath("//div[@id='fix1']/div/div[2]/div[4]/div[2]/label")).getText(), "0");
		    assertEquals(driver.findElement(By.cssSelector("#fix2 > div.contentholder > div.status_right > div.level_holder > div.level_label > label")).getText(), "32%");
		    assertEquals(driver.findElement(By.xpath("//div[@id='fix2']/div/div[2]/div[2]/div[2]/label")).getText(), "3042K");
		    assertEquals(driver.findElement(By.cssSelector("#fix3 > div.contentholder > div.status_right > div.level_holder > div.level_label > label")).getText(), "0%");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed due to an unhandled Exception");
		}
	}
	
	@Test(priority = 5)
	public void checkFixtures() {
		try {
			//driver.get("http://localhost:3000/wallstation");

			// Create object of actions class
			Actions act = new Actions(driver);

			driver.findElement(By.linkText("Fixture Control")).click();

			driver.findElement(By.id("Test_FIX_DIM_1")).click();
			Thread.sleep(1000);
			WebElement slider = driver.findElement(By.xpath("//*[@id='js-rangeslider-8']/div[2]"));
			Action action = (Action) act.dragAndDropBy(slider, 218, 0).build();
			action.perform();
			assertEquals(driver.findElement(By.id("brightvalue")).getText(), "20");
			assertEquals(driver.findElement(By.cssSelector("div.level_label > label")).getText(), "20%");
			Action action2 = (Action) act.dragAndDropBy(slider, 591, 0).build();
			action2.perform();
			assertEquals(driver.findElement(By.id("brightvalue")).getText(), "74");
			assertEquals(driver.findElement(By.cssSelector("div.level_label > label")).getText(), "74%");
			
			driver.findElement(By.id("Test_FIX_RGBW")).click();
			WebElement slider2 = driver.findElement(By.xpath("//*[@id='colorWheelDemo']/canvas[2]"));
			Action action3 = (Action) act.dragAndDropBy(slider2, 100, -100).build();
			action3.perform();
			Thread.sleep(1000);
			assertEquals(driver.findElement(By.xpath("//*[@id='fix1']/div/div[2]/div[1]/div[2]/label")).getText(), "100");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fix1']/div/div[2]/div[2]/div[2]/label")).getText(), "0");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fix1']/div/div[2]/div[3]/div[2]/label")).getText(), "63");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fix1']/div/div[2]/div[4]/div[2]/label")).getText(), "0");
			WebElement slider3 = driver.findElement(By.xpath("//*[@id='js-rangeslider-9']/div[2]"));
			Action action4 = (Action) act.dragAndDropBy(slider3, 0, -100).build();
			action4.perform();
			Thread.sleep(1000);
			assertEquals(driver.findElement(By.xpath("//div[@id='fix1']/div/div[2]/div[4]/div[2]/label")).getText(), "48");
			/*myScreen = new Screen();
			Pattern p1 = new Pattern("..\\rpdg_ui_tests\\Selenium\\Sikuli\\rgbwdim.jpg");
			myScreen.wait(p1, 1);
			myScreen.click(p1);
			Thread.sleep(1000);
			assertEquals(driver.findElement(By.xpath("//*[@id='fix1']/div/div[2]/div[1]/div[2]/label")).getText(), "44");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fix1']/div/div[2]/div[2]/div[2]/label")).getText(), "0");
		    assertEquals(driver.findElement(By.xpath("//*[@id='fix1']/div/div[2]/div[3]/div[2]/label")).getText(), "28");*/
			
			driver.findElement(By.id("Test_FIX_ON_OFF")).click();
			driver.findElement(By.cssSelector("span.switchery.switchery-default")).click();
			assertEquals(driver.findElement(By.cssSelector("div.level_label > label")).getText(), "100%");
			driver.findElement(By.cssSelector("small")).click();
			assertEquals(driver.findElement(By.cssSelector("div.level_label > label")).getText(), "0%");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed due to an unhandled Exception");
		}
	}
	
	@Test(priority = 6)
	public void deleteAllFixtures() {
		try {
			driver.get("http://localhost:3000/config");
			// Wait at least most 5 seconds before declaring item not visible
			WebDriverWait wait = new WebDriverWait(driver, 5);

			jse = (JavascriptExecutor) driver;
			jse.executeScript("scroll(0, 200)");
			
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
	
	@Test(priority = 7)
	public void clearAllScenes() {
		try {
			// Wait at least most 5 seconds before declaring item not visible
			WebDriverWait wait = new WebDriverWait(driver, 5);
			
			driver.findElement(By.linkText("Override/Scene Edit")).click();
			driver.findElement(By.cssSelector("i.ion-minus-round")).click();
			// Click Group ALL and select delete
			for (int j = 0; j < 4;) {
				driver.findElement(By.id("group_0")).click();
				driver.findElement(By.xpath("//input[@value='Delete']")).click();
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
	
	
	@Test(priority = 8)
	public void clearAllGroups() {
		try {
			// Wait at least most 5 seconds before declaring item not visible
			WebDriverWait wait = new WebDriverWait(driver, 5);
			// Navigate to Configuration page
			driver.findElement(By.linkText("Groups")).click();

			// Click Group ALL and select delete
			for (int j = 0; j < 2;) {
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

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}