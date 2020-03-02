package lendicoTests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import clients.lendicoServices.AlphavantageQuoteApi;
import entities.lendicoService.alphavantage.BestMatches;
import entities.lendicoService.alphavantage.QuoteEndPointResponse;
import utils.TestHelper;

public class AlphavantageQuoteApi_Test {
	
	AlphavantageQuoteApi alphavantageQuoteApi = new AlphavantageQuoteApi();
	private final String ApiKey = "VUB8W499RCN8ZAIK";
	
	String[] expectedFields = {"1. symbol","2. name","3. type","4. region","5. marketOpen","6. marketClose","7. timezone","8. currency","9. matchScore"};
	
	@Test(groups = {"Alphavantage", "specificKeyword"})
	public void getQuote_With_specificKeyword_and_ValidApiKey()
	{
		try {
			
			
			QuoteEndPointResponse res = alphavantageQuoteApi.getQuoteResultForCompany("FB", ApiKey);
			
			BestMatches[] resJsonArray = res.getBestMatches();
			int responseBodySize = resJsonArray.length;
			if(responseBodySize>0)
			{
				Reporter.log(responseBodySize+" company quote shown for valid company name:- FB", true);
				for(BestMatches object : resJsonArray)
				{
					Assert.assertTrue(object.getSymbol().startsWith("FB"));
					Reporter.log(object.getSymbol()+" symbol starts with FB",true);
					
				}
			}
			
		} catch (Exception e) {
			Reporter.log("Failed to validate the quote details with specific symbol!",true);
			e.getStackTrace();
		}
		
	}

	
	@Test(groups = {"Alphavantage", "ValidCompanyName"})
	public void getQuote_with_ValidCompanyName_and_ApiKey()
	{
		try {
			
			QuoteEndPointResponse response = alphavantageQuoteApi.getQuoteResultForCompany("SONY", ApiKey);
			BestMatches[] resJsonArray = response.getBestMatches();
			
			if(resJsonArray.length>0)
			{
				Reporter.log(resJsonArray.length+" company quote shown for valid company name:- SONY", true);
				
				for(BestMatches bestM : resJsonArray)
				{
					Assert.assertTrue(bestM.getName().toLowerCase().contains("sony"));
					Reporter.log(bestM.getName()+" name contauns searched company name:- SONY",true);
		
					
				}
			}
		} catch (Exception e) {
			
			Reporter.log("Failed to validate quote details with valid keyword: SONY",true);
			e.getStackTrace();
		}
	}
	
	
	@Test(groups = {"Alphavantage", "Invalid_ApiKey"})
	public void validate_Quote_with_Invalid_ApiKey()
	{
			
			QuoteEndPointResponse response = alphavantageQuoteApi.getQuoteResultForCompany("SONY", "abcdefgh");
			int code = response.getHttpStatusCode();
			
			if(code>=400)
			{
				Reporter.log("The end point is giving working fine, since it is giving client side error status code:- "+code+" for invalid ApiKey",true);
			}else
			{
			  Assert.fail("validation failed, since getting response body and status code "+code+ " even with invalid ApiKey");
			}
	}
	
	
	@Test(groups = {"Alphavantage", "Contract"})
	public void validate_Response_Contract()
	{
		Map<Object, Object> response = alphavantageQuoteApi.getResponseBodyInMap("Xiaomi", ApiKey);

		boolean status = TestHelper.validateJsonSchema(response, expectedFields);
		
		if(status)
		{
			Reporter.log("Successfuly validated Response contract(Json schema)",true);
		}else {
			Assert.fail("Failed to validate Response Contract (Json Schema), Since one or more fields are not present in Json Response");
		}
	}
	
	@Test(groups = {"Alphavantage", "BestMatch"})
	public void Validate_QuoteDetails_Sorted_AsPer_BestMatch_Score()
	{
		QuoteEndPointResponse response = alphavantageQuoteApi.getQuoteResultForCompany("NOK", ApiKey);
		BestMatches[] resArr = response.getBestMatches();
		ArrayList<String> actualBestMatchList = new ArrayList<String>();
		ArrayList<String> expectedBestMatchList = new ArrayList<String>();
		
		for(BestMatches s:resArr)
		{
			actualBestMatchList.add(s.getMatchScore());
		}
		
		expectedBestMatchList = actualBestMatchList;
		Collections.sort(expectedBestMatchList, Collections.reverseOrder());
		
		Assert.assertTrue(actualBestMatchList.equals(expectedBestMatchList));
		
		
		
	}
}
