package LFMC;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class StepDef extends Baseclass {
	private static boolean loggedIn = false;
	 @BeforeClass
	    public void setUp() throws InterruptedException {
	        if (!loggedIn) {
	            browserconfig();
	            launchbrowser("https://origin-factory-serialisation-react-qa12.vercel.app/login");
	            maxiwindow();
	            driver.findElement(By.id("mobile")).sendKeys("9884893210");
	            driver.findElement(By.xpath("//input[@type='password']")).sendKeys("1234");
	            driver.findElement(By.xpath("//button[text()='Submit']")).click();
	            loggedIn = true;
	            Thread.sleep(2000);
	            String title2 = driver.getTitle();
	            System.out.println(title2);
	            Assert.assertEquals(title2,"LFMC-ORIGIN");
	        }
	    }

		@Test(priority=1)
		public void the_user_clicks_on_Code_Mapping_and_selects_Testing_company_from_the_Dropdown_option() throws InterruptedException, AWTException {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		    WebElement a = driver.findElement(By.xpath("//input[@class = 'MuiAutocomplete-input MuiAutocomplete-inputFocused']"));
		   a.sendKeys("testCompany");
		a.sendKeys(Keys.ARROW_DOWN);
		a.sendKeys(Keys.ENTER);  
		    };
		    
		@Test(priority=2)
		public void enter_aa_as_and_bb_as_and_cc_as_and_dd_as_and_ee_as() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			   driver.findElement(By.xpath("//input[@name='products']")).sendKeys("TAL");
			   WebElement a = driver.findElement(By.xpath("//div[text()='TALSTAR 10EC_100ML_IN']"));
			   Actions a1=new Actions(driver);
			   a1.moveToElement(a).click().build().perform();
			   driver.findElement(By.xpath("//input[@name='batchNo']")).sendKeys("AutomationTestmarch25");
			   driver.findElement(By.name("startValue")).sendKeys("1");
			   driver.findElement(By.name("endValue")).sendKeys("2");
			   driver.findElement(By.name("totalNumberofBox")).sendKeys("10");
			   driver.findElement(By.name("totalNumberofValume")).sendKeys("1000");
			   driver.findElement(By.name("mfgDate")).sendKeys("03-12-2024");
			}
		
		
		@Test(priority=3)
		public void the_user_clicks_the_Submit_Button() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));			 
			WebElement a = driver.findElement(By.xpath("//button[@class ='common-active-btn']"));
			 Actions a1=new Actions(driver);
			 a1.moveToElement(a).click().build().perform();
		}

		@Test(priority=4)
		public void the_user_should_receive_a_mapping_successful_message() throws InterruptedException {
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

//			Alert al = driver.switchTo().alert();
//			String text2 = al.getText();
//			System.out.println(text2);
//		    WebElement element = driver.findElement(By.xpath("//div[@class='dialog-content d-flex flex-column  align-center details-popup']"));
//			String text = element.getText();
//			System.out.println(text);
			
			WebElement e = driver.findElement(By.xpath("//div[@class ='status-img']/following-sibling::p"));
			System.out.print(e.getText());
			String text = e.getText();
			
		   Assert.assertEquals(text,"Submitted Successfully !!");
		}

		@Test(priority=5)
		public void the_user_clicks_on_the_History_module() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			driver.findElement(By.xpath("//div[@class ='close']/child::*")).click();
		    driver.findElement(By.xpath("//span[text()='History']")).click();
		    driver.findElement(By.xpath("//button[text()='Get History Data']")).click();
		   Thread.sleep(5000);
		    
		}

		@Test(priority=6)
		public void the_user_validates_whether_the_mapping_has_occurred_or_not() throws AWTException, InterruptedException {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			// Find and click the button
			WebElement button = driver.findElement(By.xpath("(//div[@class='container']/descendant::div)[11]/child::*/child::button[1]"));
			// Scroll to the button
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()",button);

			

			// Wait for the overlay to disappear
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("MuiBackdrop-root")));

			// Now, find the input element and perform actions on it
			WebElement searchInput = driver.findElement(By.xpath("//input[@placeholder='Search']"));
			searchInput.sendKeys("AutomationTestmarch25");

			// Wait for the search results to appear
			WebElement searchResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='AutomationTestmarch25']")));
			String text = searchResult.getText();
			System.out.println(text);
			Assert.assertEquals(text, "AutomationTestmarch25");

			
			
//		Robot r=new Robot();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.findElement(By.xpath("(//div[@class='container']/descendant::div)[11]/child::*/child::button[1]")).click();
////		r.keyPress(KeyEvent.VK_TAB);
////			r.keyRelease(KeyEvent.VK_TAB);
////			r.keyPress(KeyEvent.VK_ENTER);
////			r.keyRelease(KeyEvent.VK_ENTER);
////			r.keyPress(KeyEvent.VK_ENTER);
////			r.keyRelease(KeyEvent.VK_ENTER);
//			
//			Thread.sleep(5000);
//			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
//			WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search']")));
//			until.sendKeys("AutomationTestmarch25");
//			    //driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("AutomationTestmarch25");
//			
////			  
//			WebElement element = driver.findElement(By.xpath("//td[text()='AutomationTestmarch25']"));
//			    String text = element.getText();
//			    System.out.println(text);
//			    Assert.assertEquals(text,"AutomationTestmarch25");
//			    
//			//a.click();
//			
////			Robot r=new Robot();
////			r.keyPress(KeyEvent.VK_ENTER);
//			
//			
//			
		}

		@Test(priority=7)
			public void the_user_performs_demapping() throws InterruptedException {
				driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
				driver.findElement(By.xpath("//div[text()='Action']")).click();
				Thread.sleep(5000);
				WebElement aa = driver.findElement(By.xpath("(//tr[@class='MuiTableRow-root css-m5zuvj']/child::*/following::p[1])[1]"));
				String text = aa.getText();
				driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
				aa.click();
				Alert a=driver.switchTo().alert();
				a.accept();			   
			}
			
		@Test(priority=8)
		public void the_user_should_receive_a_demapping_successful_message() {
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		    WebElement a = driver.findElement(By.xpath("//div[@class='status-img']/following::p[1]"));
		    String text = a.getText();
		    System.out.println(text);
		    Assert.assertEquals(text,"Submitted Successfully !!");
		}
		
		@AfterClass
		  public void tearDown() {
	        driver.quit();
	    }



}
