package lendicoTests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Reporter;
import org.testng.annotations.Test;

import clients.lendicoServices.RazorPayIFSCSearchApi;
import io.restassured.response.Response;
import utils.TestHelper;

public class RazorPayIFSCSearchApi_Test {
	
	RazorPayIFSCSearchApi rezorPayIFSCSearch = new RazorPayIFSCSearchApi();
	
	String bankDetails = "UPI;IMPS;CENTRE;CONTACT;STATE;CITY;MICR;RTGS;NEFT;BANK;BANKCODE;IFSC";
	
	@Test(groups = {"RezorPay","valid_IFSC"})
	public void getBank_Details_For_Valid_IFSC()
	{
		 Response details = rezorPayIFSCSearch.getBankDetailsForIFSCnonPOJO("HDFC0001751");
		 
		 assertTrue(details.getStatusCode()==200);
		 
		 assertTrue(TestHelper.getObjectFromJsonBody(details,"BRANCH").equals("CHURCH STREET"));
		 Reporter.log("successfuly validated Branch as :-"+TestHelper.getObjectFromJsonBody(details,"BRANCH"),true);
		 assertTrue(TestHelper.getObjectFromJsonBody(details,"CITY").equals("BANGALORE URBAN"));
		 Reporter.log("successfuly validated CITY as :-"+TestHelper.getObjectFromJsonBody(details,"CITY"),true);
		 assertTrue(TestHelper.getObjectFromJsonBody(details,"BANK").equals("HDFC Bank"));
		 Reporter.log("successfuly validated BANK as :-"+TestHelper.getObjectFromJsonBody(details,"BANK"));

		
		
	}
	
	@Test(groups = {"RezorPay","invalid_IFSC"})
	public void validate_if_BankDetails_Shown_For_Invalid_IFSC()
	{
		 Response details = rezorPayIFSCSearch.getBankDetailsForIFSCnonPOJO("HDFC0001122");
		 
		 assertTrue(details.getStatusCode() == 404);
		 Reporter.log("No result shown for invalid IFSC code HDFC0001122 hence the validation successful, Since the status code is:-"+details.getStatusCode(),true);
		
	}
	
	@Test(groups = {"RezorPay","contract_Valid"})
	public void validate_Entire_JSON_ResponseBody()
	{
		 Response details = rezorPayIFSCSearch.getBankDetailsForIFSCnonPOJO("ICIC0000004");
		 assertTrue(details.getStatusCode() == 200);
		 
		 String[] jsonElement = bankDetails.split(";");
		 for(String s : jsonElement)
		 {
			 
			 Reporter.log("Sucessfully validated "+s+" with value "+TestHelper.getObjectFromJsonBody(details, s)+" from response json body",true);
		 }
	}

	
	@Test(groups = {"RezorPay","IFSC_valid"})
	public void validate_requested_IFSC_matches_with_response_IFSC()
	{
		 Response details = rezorPayIFSCSearch.getBankDetailsForIFSCnonPOJO("ICIC0000004");
		 assertTrue(details.getStatusCode() == 200);
		 
		 assertEquals("ICIC0000004", TestHelper.getObjectFromJsonBody(details, "IFSC"));
		 Reporter.log("Successfully validated the Actual IFSC:- "+TestHelper.getObjectFromJsonBody(details, "IFSC")+" with expected IFSC:- ICIC0000004",true);
	}
	
	
	@Test(groups = {"RezorPay","BankCode"})
	public void validate_IFSCCode_StartsWith_BankCode_in_ResBody()
	{
		 Response details = rezorPayIFSCSearch.getBankDetailsForIFSCnonPOJO("KARB0000001");
		 assertTrue(details.getStatusCode() == 200);
		 
		 assertTrue("KARB0000001".startsWith(TestHelper.getObjectFromJsonBody(details, "BANKCODE").toString()));
		 Reporter.log("Successfully validated the Bankcode:- "+TestHelper.getObjectFromJsonBody(details, "BANKCODE")+" present in IFSC code:- KARB0000001",true);
	}
}
 