package clients.lendicoServices;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.testng.Reporter;

import entities.lendicoService.alphavantage.QuoteEndPointResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AlphavantageQuoteApi 
{

	public QuoteEndPointResponse getQuoteResultForCompany(String Symbol,String apiKey)
	{
		String endpint ="https://www.alphavantage.co/query?function=SYMBOL_SEARCH&keywords="+Symbol+"&apikey="+apiKey;
		Reporter.log(String.format("getQuoteResultForCompany Request URL: %s ", endpint),true);
		
		Response response=given()
				.contentType(ContentType.JSON).when().
				get(endpint);
		
		Reporter.log(String.format("getQuoteResultForCompany Response status code: %s",response.getStatusCode()),true);
		Reporter.log(String.format("getQuoteResultForCompany Response: %s",response.asString()),true);
		
		QuoteEndPointResponse quoteEndPointResponse =response.as(QuoteEndPointResponse.class);
		quoteEndPointResponse.setHttpStatusCode(response.getStatusCode());
		
		return quoteEndPointResponse;
	}
	
	public Map<Object,Object> getResponseBodyInMap(String Symbol,String apiKey)
	{
		String endpint ="https://www.alphavantage.co/query?function=SYMBOL_SEARCH&keywords="+Symbol+"&apikey="+apiKey;
		Reporter.log(String.format("getQuoteResultForCompany Request URL: %s ", endpint),true);
		
		Response response=given()
				.contentType(ContentType.JSON).when().
				get(endpint);
		
		Reporter.log(String.format("getQuoteResultForCompany Response status code: %s",response.getStatusCode()),true);
		Reporter.log(String.format("getQuoteResultForCompany Response: %s",response.asString()),true);
		
		QuoteEndPointResponse quoteEndPointResponse =response.as(QuoteEndPointResponse.class);
		quoteEndPointResponse.setHttpStatusCode(response.getStatusCode());
		
		return response.getBody().jsonPath().getMap("bestMatches[0]");
	}
	
}


