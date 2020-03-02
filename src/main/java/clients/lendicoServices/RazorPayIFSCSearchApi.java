package clients.lendicoServices;

import static io.restassured.RestAssured.given;

import org.testng.Reporter;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RazorPayIFSCSearchApi {
	
	public Response getBankDetailsForIFSCnonPOJO(String IFSC)
	{
		String endpint ="https://ifsc.razorpay.com/"+IFSC;
		Reporter.log(String.format("getBankDetailsForIFSC Request URL: %s ", endpint),true);
		
		Response response=given()
				.contentType(ContentType.JSON).when().
				get(endpint);
		
		Reporter.log(String.format("getBankDetailsForIFSC Response status code: %s",response.getStatusCode()),true);
		Reporter.log(String.format("getBankDetailsForIFSC Response: %s",response.getBody().prettyPrint()),true);
		
		return response;
	}
	
	
}
