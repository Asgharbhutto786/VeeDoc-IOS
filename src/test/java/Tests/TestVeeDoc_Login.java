package Tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Pages.Page_VeeDocDashboard;
import Pages.Page_VeeDocLogin;
import Pages.Utility;
import Utilities.Xls_Reader;


public class TestVeeDoc_Login extends BaseClass{
	
	ExtentTest test;
	SoftAssert softAssert;
	Xls_Reader reader;
	Utility utility;
	
	String loginSheet = "login";
	String email;
	String password;
	String verifyName;
	
	@BeforeTest                                               
	 public void before_test()  
	  {  
		//BasicConfigurator.configure();
		reader = new Xls_Reader("./src/test/resources/TestData/TestData.xlsx");
		softAssert = new SoftAssert();
		utility = new Utility();
        
      //following lines are for getting the data from excel sheet
//      	email = reader.getCellData(loginSheet, 0, 2);
//      	password = reader.getCellData(loginSheet, 1, 2);
      	verifyName = reader.getCellData(loginSheet, 3, 2);
		
	  }  
	@Test
	public void Veedoc_Login() throws Exception {
		
		//Extent Report Test case Name  
        test = extent.createTest("VeeDoc", "Login Test");
       
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
		//following is the verification to Verify the Logged-in User name must be displayed on dashboard
		softAssert.assertEquals(dashboard.getName(), verifyName);
		System.out.println("User must be logged in with the Specified User, User name must be displayed");
		test.log(Status.INFO, "Test Completed");
		
		
	}
	@Test
	public void Veedoc_Navigation() throws Exception {
		Page_VeeDocDashboard dashboard =  new Page_VeeDocDashboard(driver);
		
		dashboard.navigateToAppointments("Appointments");
		
	}
}














