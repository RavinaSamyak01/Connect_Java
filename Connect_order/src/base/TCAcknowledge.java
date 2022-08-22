package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TCAcknowledge extends BaseInit {
	
	@Test
	public static void tcAcknowledge() throws Exception
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;// scroll,click
		WebDriverWait wait = new WebDriverWait(driver, 50);// wait time
		Thread.sleep(2000);
		String svc = driver.findElement(By.id("lblServiceID")).getText();
		System.out.println(svc);
		if(svc.equals("LOC") || svc.equals("P3P") || svc.equals("DRV")|| svc.equals("SDC")|| svc.equals("FRG"))
			{
			WebElement Tick =wait.until(ExpectedConditions.elementToBeClickable(By.id("GreenTick")));
			jse.executeScript("arguments[0].click();",Tick);
			System.out.println("Submit the TCK Stage");
			logger.info("Submit the TCK stage");
			Thread.sleep(2000);
			}
		
		if(svc.equals("SD") || svc.equals("PA") || svc.equals("AIR")|| svc.equals("FRA"))
			{
//			if(driver.findElement(By.id("btnSelectFlights")).isDisplayed()) {
//				
//			
//			WebElement SelectFlights = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSelectFlights")));
//			jse.executeScript("arguments[0].click();",SelectFlights);
//			Thread.sleep(5000);
//			
//			WebElement hlkSel = wait.until(ExpectedConditions.elementToBeClickable(By.id("hlkSel_0")));
//			jse.executeScript("arguments[0].click();",hlkSel);
//			Thread.sleep(5000);
//			WebElement assign = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'Assign')]")));
//			jse.executeScript("arguments[0].click();",assign);
//			Thread.sleep(10000);
//			}
			WebElement Tick =wait.until(ExpectedConditions.elementToBeClickable(By.id("btnGreenTick")));
			jse.executeScript("arguments[0].click();",Tick);
			System.out.println("Submit the TCK Stage");
			logger.info("Submit the TCK stage");
			Thread.sleep(2000);
			}
	}
}
