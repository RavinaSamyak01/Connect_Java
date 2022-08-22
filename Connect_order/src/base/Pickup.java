package base;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Pickup extends ServiceDetail {
	
	@Test
	public static void confirmPickup() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 50);// wait time
		
		String svc = driver.findElement(By.id("lblServiceID")).getText();
		System.out.println(svc);
		if(svc.equals("LOC") || svc.equals("P3P") || svc.equals("DRV")|| svc.equals("SDC")|| svc.equals("FRG"))
		{		
			Thread.sleep(5000);
			WebElement ZoneID = driver.findElement(By.id("lblEditActuPickupTimeSZone"));
			String ZOneID = ZoneID.getText();
			System.out.println("ZoneID of is==" + ZOneID);

			if (ZOneID.equalsIgnoreCase("EDT")) {
				ZOneID = "America/New_York";
			} else if (ZOneID.equalsIgnoreCase("CDT")) {
				ZOneID = "CST";
			} else if (ZOneID.equalsIgnoreCase("PDT")) {
				ZOneID = "PST";
			}else if (ZOneID.equalsIgnoreCase("MDT")){
				   ZOneID = "MST";
			}		

			WebElement Time = driver.findElement(By.id("txtEditActualPickupTime"));
			Time.clear();
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
			dateFormat.setTimeZone(TimeZone.getTimeZone(ZOneID));

			Time.sendKeys(dateFormat.format(date));
			Time.sendKeys(Keys.TAB);
			Thread.sleep(9000);
			driver.findElement(By.id("GreenTickDropped")).click();
			logger.info("Submit the Pickup stage");
			System.out.println("Submit the Pickup Stage");
			Thread.sleep(8000);
		}
		
		if(svc.equals("SD") || svc.equals("PA") || svc.equals("AIR")|| svc.equals("FRA"))
		{		
			Thread.sleep(5000);
			WebElement ZoneID = driver.findElement(By.id("lblEditActuPickupTimeSZone"));
			String ZOneID = ZoneID.getText();
			System.out.println("ZoneID of is==" + ZOneID);

			if (ZOneID.equalsIgnoreCase("EDT")) {
				ZOneID = "America/New_York";
			} else if (ZOneID.equalsIgnoreCase("CDT")) {
				ZOneID = "CST";
			} else if (ZOneID.equalsIgnoreCase("PDT")) {
				ZOneID = "PST";
			}else if (ZOneID.equalsIgnoreCase("MDT")){
				   ZOneID = "MST";
			}		

			WebElement Time = driver.findElement(By.id("txtEditActualPickupTime"));
			Time.clear();
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
			dateFormat.setTimeZone(TimeZone.getTimeZone(ZOneID));

			Time.sendKeys(dateFormat.format(date));
			Time.sendKeys(Keys.TAB);
			Thread.sleep(9000);
			driver.findElement(By.id("btnGreenTickDropped")).click();
			logger.info("Submit the Pickup stage");
			System.out.println("Submit the Pickup Stage");
			Thread.sleep(8000);
		}
		
	}

}
