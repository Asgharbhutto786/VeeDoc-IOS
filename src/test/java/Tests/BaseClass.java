package Tests;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import Utilities.JsonReader;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;



public class BaseClass extends Reports {
	
	 static IOSDriver<MobileElement> driver;
	 private static String jsonFilePath = "src/test/resources/Capabilities/config.json";
	 private static String apkFilePath = System.getProperty("user.dir");
	 public static IOSDriver<MobileElement> Driver;
	
	
	 @BeforeTest
	 public void setup() {

	 try {
	 JsonReader jsonReader = new JsonReader(jsonFilePath);
	     jsonReader = new JsonReader("src/test/resources/Capabilities/"+jsonReader.getValue("capability"));
	 //  
    	
		DesiredCapabilities capa = new DesiredCapabilities();
		  
		
		
		 capa.setCapability(MobileCapabilityType.AUTOMATION_NAME, jsonReader.getValue("automationName"));
		 capa.setCapability(MobileCapabilityType.UDID,  jsonReader.getValue("uid"));
		 capa.setCapability(MobileCapabilityType.PLATFORM_NAME, jsonReader.getValue("pname"));
		 capa.setCapability(MobileCapabilityType.PLATFORM_VERSION, jsonReader.getValue("version"));
		 capa.setCapability(MobileCapabilityType.DEVICE_NAME, jsonReader.getValue("deviceName"));
		
	
		 capa.setCapability("no",true);
		 capa.setCapability("newCommandTimeout", 100000);

		 if(!apkFilePath.contains(".app")) {
			 apkFilePath = apkFilePath+jsonReader.getValue("app");
			 }
		 capa.setCapability(MobileCapabilityType.APP, apkFilePath);
		 
		 
		 
		 
		 
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new IOSDriver<MobileElement>(url,capa);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		catch(Exception exp) {
			System.out.println( exp.getCause());
			System.out.println( exp.getMessage());
			exp.printStackTrace();}
		
	}
	
	@AfterTest
	public void teardown() {
		
		
	}
//	
//	@Test
//	public void test() {
//		
//		
//		System.out.println("Test passed");
//		
//	}

	public static IOSDriver<MobileElement> getDriverInstance(){
    	return (IOSDriver<MobileElement>) driver;
    }


}
