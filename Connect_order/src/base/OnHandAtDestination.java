package base;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class OnHandAtDestination extends BaseInit{

	@Test
	public static void onHandDst() throws Exception
	{
		Thread.sleep(4000);
		
		try {
			Thread.sleep(5000);
			String stg = driver.findElement(By.id("lblStages")).getText();
				if(stg.contains("ONHAND"))
				{
					Thread.sleep(5000);
					WebElement ZoneID = driver.findElement(By.id("spnOnHand"));
					String ZOneID = ZoneID.getText();
					System.out.println("ZoneID of is==" + ZOneID);

					if (ZOneID.equalsIgnoreCase("EDT")) {
						ZOneID = "America/New_York";
					} else if (ZOneID.equalsIgnoreCase("CDT")) {
						ZOneID = "CST";
					} else if (ZOneID.equalsIgnoreCase("PDT")) {
						ZOneID = "PST";
					}

					WebElement Time = driver.findElement(By.id("txtTimeOnhand"));
					Time.clear();
					Date date = new Date();
					SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
					dateFormat.setTimeZone(TimeZone.getTimeZone(ZOneID));

					Time.sendKeys(dateFormat.format(date));
					Time.sendKeys(Keys.TAB);

					Thread.sleep(3000);
					driver.findElement(By.id("txtSpokeWithOnhand")).sendKeys("Tathya");
					driver.findElement(By.id("txtSpokeWithOnhand")).sendKeys(Keys.TAB);
					driver.findElement(By.id("btnHAAOnHandDeliveryStages")).click();
					Thread.sleep(3000);
					logger.info("Submit the On hand stage");
				}
	}
		catch (Exception e) {
			System.out.println("OnHand Stage is not displayed !!");
			}
		
	
	}
	
	
	public static String getTime(String timeZone)
	{
		
		LocalDateTime localNow = LocalDateTime.now(TimeZone.getTimeZone(timeZone).toZoneId());
	System.out.println(localNow);
	//DateTimeFormatter formatter = DateTimeFormatter.ISO_TIME;     
	String text = Integer.toString(localNow.getHour());
	String text1 = "";
    if(localNow.getMinute()<10) {
    	text1 = "0".concat(Integer.toString(localNow.getMinute()));
    }
    else {
    	text1 = Integer.toString(localNow.getMinute());
    }
	text = text.concat(text1);
	
	System.out.println(text);
	return text;
	}

}
