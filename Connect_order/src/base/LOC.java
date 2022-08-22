package base;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LOC extends BaseInit {
	@Test
	public static void locLocal() throws Exception
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;// scroll,click
		WebDriverWait wait = new WebDriverWait(driver, 50);// wait time
		
		Thread.sleep(2000);
		WebElement order = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnOrderProcess")));
		jse.executeScript("arguments[0].click();",order);
		System.out.println("Click on Order");
		Thread.sleep(2000);
		
		boolean sameairport = driver.getPageSource().contains("Pickup and Delivery airport are different. Do you want to make it same?");			
		
			if(sameairport == true) {
				driver.findElement(By.xpath("/html/body/div[11]/div/div/div/div/div/div[2]/span/button[1]")).click();							
			}
		
		String pck = driver.findElement(By.xpath("//*[@id='lblPickup']/span/b")).getText();
		System.out.println("Service LOC :: Pickup # " + pck);
		logger.info("Service LOC :: Pickup # "+ pck + "\n");
		Thread.sleep(2000);
		ExcelDataProvider excelDataProvider = new ExcelDataProvider();
		excelDataProvider.writeData("Sheet1", 1, 32, pck);
		Thread.sleep(2000);
		WebElement editOrder = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='hlkGoDirectlytoEditOrder']")));
		jse.executeScript("arguments[0].click();",editOrder);
		Thread.sleep(2000);
		
		
		jse.executeScript("window.scrollBy(0,400)", "");
		String cost = driver.findElement(By.id("lblActualRate")).getText();
		excelDataProvider.writeData("Sheet1", 1, 31, cost);
		Thread.sleep(2000);
		WebElement idJob = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='idJobOverview']")));
		jse.executeScript("arguments[0].click();",idJob);


			//TC Acknowledge
			Thread.sleep(7000);
			TCAcknowledge.tcAcknowledge();
			
			//Pickup Alert
			Thread.sleep(7000);
			ReadyForDispatch.pickupAlert();
	
			//PICKEDUP
			Thread.sleep(3000);
			Pickup.confirmPickup();
	
			//DELIVERED
			Thread.sleep(3000);
			Deliver.confirmDelivery();

		Thread.sleep(3000);
	}
}
