package Utilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

@SuppressWarnings("serial")
public class Capabilities extends DesiredCapabilities {
	
	 static AppiumDriver<MobileElement> driver;
	public static IOSDriver<MobileElement> Driver;
    private static String jsonFilePath = "src/test/resources/Capabilities/config.json";
    private static String appFilePath = System.getProperty("user.dir");
    
    public static void startService() {
    	try {
    		JsonReader jsonReader = new JsonReader(jsonFilePath);
    		jsonReader = new JsonReader("src/test/resources/Capabilities/"+jsonReader.getValue("capability"));
    		DesiredCapabilities capabilities = new DesiredCapabilities();
    		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, jsonReader.getValue("pname"));
    		capabilities.setCapability(MobileCapabilityType.VERSION, jsonReader.getValue("version"));
    		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,  jsonReader.getValue("deviceName"));
    		capabilities.setCapability(MobileCapabilityType.UDID,  jsonReader.getValue("uid"));
    		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,  jsonReader.getValue("XCUITest"));
    		
    		capabilities.setCapability(MobileCapabilityType.APP,  jsonReader.getValue("app"));
    		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,  jsonReader.getValue("version"));
    		
    		
    		
//    		capabilities.setCapability(MobileCapabilityType.AppPackage,  jsonReader.getValue("VeeDoc.app"));
//    		capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY,  jsonReader.getValue("appActivity"));
//    		
			if(!appFilePath.contains(".app")) {
				appFilePath = appFilePath+jsonReader.getValue("app");
			
			}
    		capabilities.setCapability(MobileCapabilityType.APP, appFilePath);
    	
    		URL url = new URL("http://127.0.0.1:4723/wd/hub");
    		driver = new IOSDriver<MobileElement>(url,capabilities);
//    		
    		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	}
        catch (Exception e) {
			System.out.println("Cause: "+e.getCause());
			System.out.println("Message: "+e.getMessage());
			e.printStackTrace();
		}
    }
    
    
    public static void stopService() {
    	driver.quit();
    }
    
    public static AppiumDriver<MobileElement> getDriverInstance(){
    	return driver;
    }
}