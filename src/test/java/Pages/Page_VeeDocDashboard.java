package Pages;
import org.openqa.selenium.By;

import Utilities.Xls_Reader;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class Page_VeeDocDashboard  extends BasePage{

	Utility utility = new Utility();
	String loginSheet = "login";
	Xls_Reader reader = new Xls_Reader("./src/test/resources/TestData/TestData.xlsx");
	
	 //following lines are for getting the data from excel sheet
	String verifyName = reader.getCellData(loginSheet, 2, 2);

	String abc = "//XCUIElementTypeStaticText[@name='";
	
	String xyz = "']";

	
	//Following elements for top manu
	MobileElement inpatient_tab =  driver.findElement(By.name("Inpatient"));

	MobileElement outpatient_tab =  driver.findElement(By.name("Outpatient"));

	MobileElement appointments_tab = driver.findElement(By.name("Appointments"));


	//Following elements for bottom manu
	MobileElement sessions_tab =  driver.findElement(By.name("Sessions"));
	
	MobileElement invites_tab =  driver.findElement(By.name("Invites"));
	
	MobileElement messages_tab = driver.findElement(By.name("Messages"));
	
	MobileElement endpoints_tab =  driver.findElement(By.name("Endpoints"));
	
	MobileElement more_tab = driver.findElement(By.name("More"));
	
	
	public Page_VeeDocDashboard (IOSDriver<MobileElement> driver) {
		super(driver);
		this.driver= driver;
	}
	
	

	public String getName(){
		
	String ab= abc + verifyName + xyz;
	MobileElement userName=  driver.findElement(By.xpath(ab));
		
	return utility.getTextFunc(userName);

	}
	
	//following function for navigates to Appointments Tab
	public void navigateToAppointments(String menuName) throws Exception {

	utility.Wait();
	if(menuName == "Appointments") {
	utility.clickButton(appointments_tab);
	}
			}	
		
	//following function for navigates to Outpatient Tab
		public void navigateToOutpatient(String menuName) throws Exception {
			

		utility.Wait();
		if(menuName == "Outpatient") {
			
			utility.clickButton(outpatient_tab);
		}

		}	
	
	
	
	//following function for navigates to Inpatient Tab
	public void navigateToInpatient(String menuName) throws Exception {

	utility.Wait();
	if(menuName == "Inpatient") {
		
		utility.clickButton(inpatient_tab);
	}

	}	
	
	
	
	
	
	
	
//following function for navigates to Sessions Tab
public void navigateToSession(String menuName) throws Exception {

utility.Wait();
if(menuName == "Sessions") {
	
	utility.clickButton(sessions_tab);
}

}

//following function for navigates to Invites Tab
public void navigateToInvites(String menuName) throws Exception {

utility.Wait();
if(menuName == "Invites") {
	
	utility.clickButton(invites_tab);
}

}
//following function for navigates to Messages Tab	
public void navigateToMessages(String menuName) throws Exception {

utility.Wait();
if(menuName == "Messages") {
	
	utility.clickButton(messages_tab);
}

}
//following function for navigates to Endpoints Tab	
public void navigateToEndpoints(String menuName) throws Exception {

utility.Wait();
if(menuName == "Endpoints") {
	
	utility.clickButton(endpoints_tab);
}

}

//following function for navigates to More Tab
public void navigateToMore(String menuName) throws Exception {

utility.Wait();
if(menuName == "More") {
	
	utility.clickButton(more_tab);
}

}

}

