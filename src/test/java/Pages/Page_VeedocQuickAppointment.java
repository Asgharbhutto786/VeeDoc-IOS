package Pages;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;



public class Page_VeedocQuickAppointment extends BasePage{ 
	
	
	Utility utility = new Utility();
	
	
	//Following elements for top manu
		String create_appointment =	"label == \"new icon\"";
		MobileElement a_new_Appointment =  driver.findElement(MobileBy.iOSNsPredicateString(create_appointment));
		
		
	public Page_VeedocQuickAppointment (IOSDriver<MobileElement> driver) {
		super(driver);
		this.driver= driver;
		
	}
	
	
public void quickappointmentbtn() throws Exception {

		utility.clickButton(a_new_Appointment);
		
	}


	
}
