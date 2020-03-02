package utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.testng.Reporter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;

public class TestHelper {

	public static String randomNumber() 
	{
        int random = (int) (Math.random() * (1000 - 1)) + 1;
        return new SimpleDateFormat("ddMMyyHHmmssSSS").format(new Date()) + random;
    }
	
	public static void wait(int milliSeconds) 
	{
        try 
        {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
    }
	
    public static String getJsonString(Object o) 
    {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.writeValueAsString(o);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }	
    
    public static boolean validateJsonSchema(Map<Object,Object> contractMap,String[] arr)
    {
    	boolean status =false;
    	
    	for(String field:arr)
    	{
    		if(contractMap.containsKey(field))
    		{
    			status = true;
    			Reporter.log("Response body contains field:- "+field+" = "+contractMap.get(field),true);
    		}else
    		{
    			status = false;
    		 Reporter.log("Response body does not contains field:- "+field,true);	
    		}
    	}
    	
    	return status;
    }
    
    public static double getParsedDoubleValue(String val)
    {	
    	double num = 0.00;
    	try {
    		num = Double.parseDouble(val);
			
		} catch (NumberFormatException  nPoint) {
			Reporter.log("please provide the number in valid format",true);
		}catch (NullPointerException nulP) {
			Reporter.log("please provide the number in valid format",true);
		}
    	return num;
    	
    }
    
    public static Object getObjectFromJsonBody(Response res , String jsonPath)
    {
    	Object o = null;
    	o = res.getBody().jsonPath().get(jsonPath);
    	return o;
    }
}