package Tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;

import Pages.Page_VeeDocDashboard;
import Pages.Page_VeeDocLogin;
import Pages.Utility;
import Pages.Page_VeedocQuickAppointment;
import Pages.Page_AddQuickAppointment;
import Utilities.Xls_Reader;

public class TestVeedoc_QuickAppointment extends BaseClass{
	ExtentTest test;
	SoftAssert softAssert;
	Xls_Reader reader;
	Utility utility;
	
	String loginSheet = "login";
	String verifyName;
	
	@BeforeTest                                               
	 public void before_test()  
	  {  
		//BasicConfigurator.configure();
		reader = new Xls_Reader("./src/test/resources/TestData/TestData.xlsx");
		softAssert = new SoftAssert();
		utility = new Utility();
        
      //following lines are for getting the data from excel sheet
      	verifyName = reader.getCellData(loginSheet, 3, 2);
		
	  }  
	@Test
	public void QuickAppointment() throws Exception {
		
		//Extent Report Test case Name  
        test = extent.createTest("VeeDoc", "Quick appointment Test");
       
        //*********Page class of Veedoc Login**********
        Page_VeeDocLogin loginpage = new Page_VeeDocLogin(driver);
 
		//functions for login to Veedoc with valid credentials
		loginpage.enterCreds();
		System.out.println("Enter Email, Password to Login");
		
		//functions for Click on Login Button
		loginpage.clickonLoginBtn();
		System.out.println("Clicked on Login Button");
		
		//**********Page class of Veedoc Dashboard*********
		Page_VeeDocDashboard dashboard =  new Page_VeeDocDashboard(driver);
		
		dashboard.navigateToAppointments("Appointments");
		
		//**********Page class of Veedoc Dashboard*********
		Page_VeedocQuickAppointment quickappointment =  new Page_VeedocQuickAppointment(driver);
				
		dashboard.navigateToAppointments("Appointments");
		
		
		//**********Page class of Veedoc Appointment Page*********
		quickappointment.quickappointmentbtn();
		
		//**********Page class of Veedoc create Quick Appointment Page*********
		
		Page_AddQuickAppointment addquickappointment =  new Page_AddQuickAppointment(driver);
				
		addquickappointment.quickappointmentform();
}}
