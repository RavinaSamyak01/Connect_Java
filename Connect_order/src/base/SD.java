package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SD extends ServiceDetail {
    @Test
	public static void sdSameDay() throws Exception
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebDriverWait wait = new WebDriverWait(driver, 50);// wait time
		
		Thread.sleep(3000);
		WebElement order = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnOrderProcess")));
		jse.executeScript("arguments[0].click();",order);
		
		Thread.sleep(9000);
		
		boolean sameairport = driver.getPageSource().contains("Pickup and Delivery airport are different. Do you want to make it same?");			
		
		if(sameairport == true) {
			driver.findElement(By.xpath("/html/body/div[11]/div/div/div/div/div/div[2]/span/button[1]")).click();							
		}
		

		pck = driver.findElement(By.xpath("//*[@id='lblPickup']/span/b")).getText();
		System.out.println("Service SD :: Pickup # " +pck);
		logger.info("Service SD :: Pickup # "+ pck + "\n");

		Thread.sleep(1000);
		
		ExcelDataProvider excelDataProvider = new ExcelDataProvider();
		excelDataProvider.writeData("Sheet1", 2, 32, pck);
		
		Thread.sleep(5000);
		WebElement editOrder = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='hlkGoDirectlytoEditOrder']")));
		jse.executeScript("arguments[0].click();",editOrder);
		Thread.sleep(4000);
		
		WebElement EditSend = wait.until(ExpectedConditions.elementToBeClickable(By.id("idEditSendByAir")));
		jse.executeScript("arguments[0].click();",EditSend);
		Thread.sleep(4000);
		WebElement ConfirmExtrernal = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnConfirmExtrernal")));
		jse.executeScript("arguments[0].click();",ConfirmExtrernal);
		Thread.sleep(10000);
		
		
		jse.executeScript("window.scrollBy(0,400)", "");
		String cost = driver.findElement(By.id("lblActualRate")).getText();
		excelDataProvider.writeData("Sheet1", 2, 31, cost);
		Thread.sleep(5000);
		
		
		WebElement savechange = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveChanges")));
		jse.executeScript("arguments[0].click();",savechange);
		Thread.sleep(4000);
		WebElement idJob = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='idJobOverview']")));
		jse.executeScript("arguments[0].click();",idJob);
		Thread.sleep(4000);
		WebElement SelectFlights = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSelectFlights")));
		jse.executeScript("arguments[0].click();",SelectFlights);
		Thread.sleep(5000);
		
		WebElement hlkSel = wait.until(ExpectedConditions.elementToBeClickable(By.id("hlkSel_0")));
		jse.executeScript("arguments[0].click();",hlkSel);
		Thread.sleep(5000);
		WebElement assign = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'Assign')]")));
		jse.executeScript("arguments[0].click();",assign);
		Thread.sleep(15000);
		
		
		
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
		
		//Send Del Alert
		Thread.sleep(3000);
		SendDelAlert.delAlert();
		
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
		
		//Recover
		Thread.sleep(3000);
		Recover.recoverAtDestination();
		
		//DELIVERED
		Thread.sleep(3000);
		Deliver.confirmDelivery();

		Thread.sleep(3000);
	}
}
