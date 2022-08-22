package base;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class OutForDelivery extends BaseInit{

	@Test
    public static void outForDel() throws Exception
	{
		try {
			Thread.sleep(10000);
			String stg = driver.findElement(By.id("lblStages")).getText();
			if (stg.contains("OUT FOR DELIVERY")) 
			{
				Thread.sleep(5000);
		Thread.sleep(5000);
		driver.findElement(By.id("btnViewGreenTickDropped")).click();
		logger.info("Submit the Out of Ddelivery stage");
		Thread.sleep(2000);
	}
		}catch(Exception e){
			System.out.println("skip the OUT FOR DELIVERY stage");
		}
}
}
