package base;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ReAlertForDelivery extends BaseInit{
    @Test
	public static void reAlertfordel() throws Exception
	{
    	try {
			Thread.sleep(10000);
			String stg = driver.findElement(By.id("lblStages")).getText();
			if (stg.contains("RE-ALERT FOR DELIVERY")) 
			{
				Thread.sleep(5000);
			
				
			
		Thread.sleep(5000);
		driver.findElement(By.id("AlertConfirmbtn")).click();
	    logger.info("Submit the Alert Confirm Delivery stage");
	}
    	}catch(Exception e) {
    		System.out.println("skip the RE-ALERT FOR DELIVERY stage");
    	}

}
}
