package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HoldAtOrigin extends BaseInit {
	
	@Test
	public static void hldAtOrigin() throws Exception
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;// scroll,click
		try {
			Thread.sleep(10000);
			String stg = driver.findElement(By.id("lblStages")).getText();
			if (stg.contains("HOLD @ ORIGIN")) {
		Thread.sleep(5000);
		WebElement greenTick = driver.findElement(By.id("btnViewGreenTickDropped"));
		jse.executeScript("arguments[0].click();",greenTick);
		logger.info("Submit the Hold at Origin stage");
		Thread.sleep(2000);
			}
		}catch (Exception e) {
			System.out.println("skip the Hold @origin stage");
		}
	}
}