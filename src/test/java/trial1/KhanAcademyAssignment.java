package trial1;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
public class KhanAcademyAssignment {
	 RemoteWebDriver driver;


	 @Test
	  public void verifyLifeSkillsCampKhan() throws InterruptedException
	  {
		Thread.sleep(3000);
		driver.findElement(AppiumBy.accessibilityId("Search tab")).click();
		Thread.sleep(3000);
		Dimension d= driver.manage().window().getSize();
		int width=d.width;
		int height=d.height;
		int x1=width/2;
		int y1=(int) (height * 0.8);
		int x2=width/2;
		int y2=(int) (height * 0.4);
		while(driver.findElements(AppiumBy.androidUIAutomator("UiSelector().text(\"Life skills\")")).size()==0) 
		{
			driver.executeScript("mobile:shell", ImmutableMap.of("command","input swipe "+x1+" "+y1+" "+x2+" "+y2));
			Thread.sleep(3000);
		}
		
		driver.findElement(AppiumBy.androidUIAutomator("UiSelector().text(\"Life skills\")")).click();
		Thread.sleep(3000);
		  
	

		while(driver.findElements(AppiumBy.androidUIAutomator("UiSelector().text(\"Camp Khan\")")).size()==0) 
		{
			driver.executeScript("mobile:shell", ImmutableMap.of("command","input swipe "+x1+" "+y1+" "+x2+" "+y2));
			Thread.sleep(3000);
		}
		driver.findElement(AppiumBy.androidUIAutomator("UiSelector().text(\"Camp Khan\")")).click();
		Thread.sleep(3000);
		
		driver.findElement(AppiumBy.androidUIAutomator("UiSelector().text(\"Camp Khan 2021\")")).click();
		Thread.sleep(3000);
		
		driver.findElement(AppiumBy.androidUIAutomator("UiSelector().text(\"Camp Khan program overview\")")).click();
		Thread.sleep(3000);
		
		Assert.assertEquals("Camp Khan program overview", driver.findElement(AppiumBy.androidUIAutomator("UiSelector().text(\"Camp Khan program overview\")")).getText());
		Thread.sleep(3000);  
		
		//click Home
		driver.findElement(AppiumBy.accessibilityId("Explore tab")).click();
		Thread.sleep(3000);
	  }	  
	  

	  @BeforeClass
	  public void LaunchBrowser() throws InterruptedException, MalformedURLException 
	  {
		  DesiredCapabilities capability = new DesiredCapabilities();
		  capability.setCapability("deviceName", "emulator-5554");
		  capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		  capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"org.khanacademy.android");
		  capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"org.khanacademy.android.ui.library.MainActivity");
		  driver= new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
		  Thread.sleep(3000);	  
	  }

	  @AfterClass
	  public void CloseBrowser()
	  {
		  driver.quit();
	  }

}
