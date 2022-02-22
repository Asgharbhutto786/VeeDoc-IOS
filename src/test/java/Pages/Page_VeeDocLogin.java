package Pages;


import org.openqa.selenium.By;

import Utilities.Xls_Reader;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class Page_VeeDocLogin extends BasePage{

	Utility utility = new Utility();
	String loginSheet = "login";
	Xls_Reader reader = new Xls_Reader("./src/test/resources/TestData/TestData.xlsx");
	
	 //following lines are for getting the data from excel sheet
	String email = reader.getCellData(loginSheet, 0, 2);
	String pass = reader.getCellData(loginSheet, 1, 2);
	
	
	MobileElement email_txt=  driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"VeeDoc\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeTextField");
	
	MobileElement password_txt=  driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"VeeDoc\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeSecureTextField");
	
	MobileElement login_btn = driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Sign in\"]");

	
	String dialog_Never = "Never";

	String Cam_allow = "OK";
	
	String notif_allow = "Allow";
	
	String Video_allow = "OK";
	
	
	
	public Page_VeeDocLogin(IOSDriver<MobileElement> driver) {
		super(driver);
		
		this.driver= driver;
	}
	
	public void enterCreds() throws Exception {
		
		//utility.Wait();
		utility.setText(this.email_txt, email);
		utility.setText(this.password_txt, pass);
		
	
	}
	
	public void clickonLoginBtn() throws Exception {
		
		
		utility.clickButton(login_btn);
		//utility.Wait();
	
//	Thread.sleep(10000);
	

	MobileElement NotificatioAllow = driver.findElement(By.name(notif_allow));
	utility.clickButton(NotificatioAllow);

	
	MobileElement never_opt = driver.findElement(By.name(dialog_Never));
	utility.clickButton(never_opt);
		


	MobileElement cam_opt = driver.findElement(By.name(Cam_allow));
	utility.clickButton(cam_opt);
	
	
	MobileElement vid_opt = driver.findElement(By.name(Video_allow));
	utility.clickButton(vid_opt);
	
	
	}
	


}
