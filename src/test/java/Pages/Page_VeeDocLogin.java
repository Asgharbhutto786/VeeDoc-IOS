package Pages;


import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class Page_VeeDocLogin extends BasePage{

	Utility utility = new Utility();
	
	
	MobileElement email=  driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"VeeDoc\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeTextField");
	
	MobileElement password=  driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"VeeDoc\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeSecureTextField");
	
	MobileElement login_btn = driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Sign in\"]");


	
	
	String dialog_Never = "Never";

	
	String Cam_allow = "OK";
	
	
	String notif_allow = "Allow";
	
	String Video_allow = "OK";
	
	
	
	public Page_VeeDocLogin(IOSDriver<MobileElement> driver) {
		super(driver);
		
		this.driver= driver;
	}
	
	public void enterCreds(String email, String pass) throws Exception {
		
		utility.Wait();
		utility.setText(this.email, email);
		utility.setText(this.password, pass);
		
	
	}
	
	public void clickonLoginBtn() throws Exception {
		
		
		utility.clickButton(login_btn);
		utility.Wait();
	
	Thread.sleep(10000);
	

	MobileElement NotificatioAllow = driver.findElement(By.name(notif_allow));
	utility.clickButton(NotificatioAllow);
	Thread.sleep(5000);
	
	MobileElement never_opt = driver.findElement(By.name(dialog_Never));
	utility.clickButton(never_opt);
		

	Thread.sleep(5000);
	MobileElement cam_opt = driver.findElement(By.name(Cam_allow));
	utility.clickButton(cam_opt);
	
	
	Thread.sleep(5000);
	MobileElement vid_opt = driver.findElement(By.name(Video_allow));
	utility.clickButton(vid_opt);
	
	
	}
	


}
