package base;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CSRAcknowledge extends BaseInit  {

        @Test	
		public static void csrAcknowledge() throws Exception
		{
			Thread.sleep(7000);
			String svc = driver.findElement(By.id("lblServiceID")).getText();
			System.out.println(svc);

			if(svc.equals("LOC") || svc.equals("P3P"))
				{
				driver.findElement(By.id("GreenTick")).click();
				logger.info("Submit the CSR acknowledge stage");
				Thread.sleep(2000);
				}
			
			if(svc.equals("SD") || svc.equals("PA"))
				{
				driver.findElement(By.id("btnGreenTick")).click();
				logger.info("Submit the CSR acknowledge stage");
				Thread.sleep(2000);
				}
		}
}
