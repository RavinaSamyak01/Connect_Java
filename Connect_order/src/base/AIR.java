package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AIR extends ServiceDetail {

	@Test
	public static void airService() throws Exception
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebDriverWait wait = new WebDriverWait(driver, 50);// wait time
		
		Thread.sleep(8000);
		jse.executeScript("window.scrollBy(0,-450)", "");		
		
		
		driver.findElement(By.id("idSendByAir")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.id("txtVerifyFedex")).sendKeys("KSMS DONE");
		driver.findElement(By.id("txtVerifyFedex")).sendKeys(Keys.TAB);
		
		driver.findElement(By.id("btnYes")).click();
		
		Thread.sleep(8000);
		
			
		WebElement flight = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSelectFlights")));
		jse.executeScript("arguments[0].click();",flight);
		Thread.sleep(20000);
		
		WebElement sel = wait.until(ExpectedConditions.elementToBeClickable(By.id("hlkSel_0")));
		jse.executeScript("arguments[0].click();",sel);
		
		Thread.sleep(9000);
		WebElement assign = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'Assign')]")));
		jse.executeScript("arguments[0].click();",assign);
		Thread.sleep(15000);
		
		
		WebElement Check = wait.until(ExpectedConditions.elementToBeClickable(By.id("idcheckdelhaa")));
		 jse.executeScript("arguments[0].click();",Check);
		Thread.sleep(3000);
		
		
		
		jse.executeScript("window.scrollBy(0,450)", "");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='ShipmentChargeSection']/fieldset/div[1]/div[1]/div[1]/a")).click();
		Thread.sleep(7000);
		
		WebElement Order = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnOrderProcess")));
		 jse.executeScript("arguments[0].click();",Order);		
		Thread.sleep(9000);
		
		boolean sameairport = driver.getPageSource().contains("Pickup and Delivery airport are different. Do you want to make it same?");			
		
		if(sameairport == true) {
			driver.findElement(By.xpath("/html/body/div[11]/div/div/div/div/div/div[2]/span/button[1]")).click();							
		}
		WebElement recalc = driver.findElement(By.partialLinkText("recalc"));
		jse.executeScript("arguments[0].click();",recalc);

		pck = driver.findElement(By.xpath("//*[@id='lblPickup']/span/b")).getText();
		System.out.println("Service AIR :: Pickup # " +pck);
		logger.info("Service AIR :: Pickup # "+ pck + "\n");

		Thread.sleep(1000);
		
		ExcelDataProvider excelDataProvider = new ExcelDataProvider();
		excelDataProvider.writeData("Sheet1", 6, 32, pck);
		
		
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='hlkGoDirectlytoEditOrder']")).click();
		Thread.sleep(9000);
		
		//jse.executeScript("window.scrollBy(0,400)", "");
		//String cost = driver.findElement(By.id("lblActualRate")).getText();
		//excelDataProvider.writeData("Sheet1", 6, 31, cost);
		//Thread.sleep(3000);
		
		WebElement job  = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='idJobOverview']")));
		job.click();
		Thread.sleep(7000);
				
		//TC Acknowledge
		Thread.sleep(7000);
		TCAcknowledge.tcAcknowledge();
		
		//Pickup Alert
		Thread.sleep(7000);
		ReadyForDispatch.pickupAlert();

		//PICKEDUP
		Thread.sleep(3000);
		Pickup.confirmPickup();

		//DROP
		Thread.sleep(3000);
		Drop.dropAtOrigin();
		
//		// HAA Notify
//		Thread.sleep(3000);
//		HAANotify.haaNtfy();

		//Wait for Departure
		Thread.sleep(5000);
		WaitForDeptarture.waitForDept();
		
		//board
		 Thread.sleep(5000);
		 Board.onBoard();
				
		//XER wait for Arrival
		Thread.sleep(5000);
		XerWaitForArrival.xerWaitForArr();
				
		//XER Wait for Departure
		Thread.sleep(5000);
		XerWaitForDeparture.xerWaitForDept();
		
		//board1
		Thread.sleep(5000);
		Board1.onBoard1();
		
		//Wait for Arrival
		Thread.sleep(5000);
		WaitForArrival.waitForArr();
		
		// ONHAND @ DESTINATION
		Thread.sleep(5000);
		OnHandAtDestination.onHandDst();
		
//		//DELIVERED
//		Thread.sleep(3000);
//		Deliver.confirmDelivery();

		Thread.sleep(3000);
	}
}
