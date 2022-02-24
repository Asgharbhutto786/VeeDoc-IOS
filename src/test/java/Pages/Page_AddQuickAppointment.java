package Pages;
import org.openqa.selenium.By;

import Utilities.Xls_Reader;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class Page_AddQuickAppointment extends BasePage{
	
	
	Utility utility = new Utility();
	String quickAppointmentSheet = "quickappointment";
	Xls_Reader reader = new Xls_Reader("./src/test/resources/TestData/TestData.xlsx");
	
	 //following lines are for getting the data from excel sheet
	String lname = reader.getCellData(quickAppointmentSheet, 0, 2);
	String fname = reader.getCellData(quickAppointmentSheet, 1, 2);
	String email = reader.getCellData(quickAppointmentSheet, 3, 2);
	String mobileNum = reader.getCellData(quickAppointmentSheet, 2, 2);
	String reason = reader.getCellData(quickAppointmentSheet, 5, 2);
	
	
	String lastName =	"value == \"Last Name\" AND type == \"XCUIElementTypeTextField\"";
	MobileElement  last_name =  driver.findElement(MobileBy.iOSNsPredicateString(lastName));
	
	String firstName =	"value == \"First Name\" AND type == \"XCUIElementTypeTextField\"";
	MobileElement  first_name =  driver.findElement(MobileBy.iOSNsPredicateString(firstName));
	
	String mobile =	"//XCUIElementTypeApplication[@name=\"VeeDoc\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField";
	
	MobileElement  mobile_num =  driver.findElement(MobileBy.xpath(mobile));

	String email_type =	"value == \"Email\" AND type == \"XCUIElementTypeTextField\"";
	MobileElement  email_box =  driver.findElement(MobileBy.iOSNsPredicateString(email_type));
	
	
	String reason_input =	"**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeTextField[5]";
	
	MobileElement  reason_box =  driver.findElement(MobileBy.iOSClassChain(reason_input));
	
	
	MobileElement  create_btn =  driver.findElement(By.name("Create"));

	public Page_AddQuickAppointment (IOSDriver<MobileElement> driver) {
		super(driver);
		this.driver= driver;
		
	}
	
	
	public void quickappointmentform() throws Exception {
		

		utility.setText(this.last_name, lname);
		
		utility.setText(this.first_name, fname);
		utility.hideKeyboard();
		utility.setText(this.mobile_num, mobileNum);
		utility.hideKeyboard();
		utility.setText(this.email_box, email);
		utility.hideKeyboard();
		utility.setText(this.reason_box, reason);
		utility.hideKeyboard();
		utility.clickButton(create_btn);
		
	}
	
	
	
	
}
