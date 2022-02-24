package Pages;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;



public class Page_VeedocAppointment extends BasePage{ 
	
	
	Utility utility = new Utility();
	
	
	//Following elements for top manu
		String create_appointment =	"label == \"new icon\"";
		MobileElement a_new_Appointment =  driver.findElement(MobileBy.iOSNsPredicateString(create_appointment));
		
		
	public Page_VeedocAppointment (IOSDriver<MobileElement> driver) {
		super(driver);
		this.driver= driver;
		
	}
	
	
public void quickappointmentbtn() throws Exception {

		utility.clickButton(a_new_Appointment);
		
	}
public void VerifyAppointment() throws Exception {


	//Function for Verify End Point  
//
//String 	verifyEndpointName(MRN, endpoint)
//     {
//	        cy.get(this.getMRNColumn).each(($e, index, $list) =>{
//	        const text=$e.text() 
//			if(text.includes(MRN))
//			{
//	      cy.get(this.getStateColumn).eq(index).then(function(getendpoint){
//		
//	      const endpointname= getendpoint.text() 
//	      expect(endpointname).to.equal(endpoint)   
//	      System.out.println("Checking the Value Presence based on created MRN by iterating rows., Verify that the Session record must be displayed along with Endpoint Name")
//
//	})   
//	}})
//	 
//	  }
//
//
//





}
	
}
