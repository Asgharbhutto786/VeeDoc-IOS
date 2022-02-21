package Tests;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.URL;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class OpenVeedocApp {
	public static IOSDriver<MobileElement> driver;
	public static void main(String[] args) {
		
		
try {
	OpenVeedoc();
}
catch(Exception exp) {
System.out.println( exp.getCause());
System.out.println( exp.getMessage());
exp.printStackTrace();

}

}
	@Test
public static void OpenVeedoc()throws Exception{


DesiredCapabilities cap = new DesiredCapabilities();
  

 cap.setCapability("platformName", "iOS");
 cap.setCapability("deviceName", "iPhone 12");
 cap.setCapability("platformVersion", "15.2"); 
 cap.setCapability("automationName", "XCUITest");
 cap.setCapability("UDID", "7ADCFFFF-BA10-4A34-B977-2DEDB6104C89");
 cap.setCapability("app", "/Users/umairasif/Downloads/VeeDoc.app");
 
URL url = new URL("http://127.0.0.1:4723/wd/hub");
driver = new IOSDriver<MobileElement>(url,cap);



Thread.sleep(8000);
driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"VeeDoc\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeTextField").sendKeys("qaguy786@gmail.com");
driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"VeeDoc\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeSecureTextField").sendKeys("Supreme@123");
Thread.sleep(500);
driver.hideKeyboard(); 



driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Sign in\"]").click();
Thread.sleep(6000);


driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Never\"]").click();
Thread.sleep(8000);


driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Allow\"]").click();
Thread.sleep(6000);

driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Never\"]").click();
Thread.sleep(8000);


driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Allow\"]").click();
Thread.sleep(6000);



Thread.sleep(300);
driver.findElementByXPath("com.veemed.veedoc:id/btnAppointments").click();
Thread.sleep(300);


//driver.findElementById("com.veemed.veedoc:id/btnAppointments").click();
//Thread.sleep(300);
//driver.findElementById("com.veemed.veedoc:id/btnCreateAppointment").click();
//Thread.sleep(300);
//driver.findElementById("com.veemed.veedoc:id/etPatientLastName").sendKeys("bhutto");
//Thread.sleep(300);
//driver.findElementById("com.veemed.veedoc:id/etFirstName").sendKeys("Asghar");
//driver.hideKeyboard(); 
//Thread.sleep(300);
//driver.findElementById("com.veemed.veedoc:id/etMobileNo").sendKeys("3162833883");
//driver.hideKeyboard(); 
//Thread.sleep(300);
//driver.findElementById("com.veemed.veedoc:id/etEmail").sendKeys("qaguy786@gmail.com");
//driver.hideKeyboard(); 
//Thread.sleep(300);
//driver.findElementById("com.veemed.veedoc:id/etReason").sendKeys("urgent");
//driver.hideKeyboard(); 
//Thread.sleep(300);
//driver.findElementById("com.veemed.veedoc:id/btnCreateAppointment").click();
//Thread.sleep(300);


}}