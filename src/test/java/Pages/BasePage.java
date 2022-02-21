package Pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class BasePage {
	
	protected IOSDriver<MobileElement> driver;
	
	public BasePage(IOSDriver<MobileElement> driver) {
		
		this.driver = driver;
		//PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}

}
