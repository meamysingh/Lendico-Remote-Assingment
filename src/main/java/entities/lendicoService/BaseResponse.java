package entities.lendicoService;

import static org.testng.Assert.assertEquals;

public class BaseResponse {
	private int httpStatusCode;
	
	public void verifyStatusCode(int statusCode)
	{
		assertEquals(getHttpStatusCode(), statusCode);
	}

	public int getHttpStatusCode() {
		return httpStatusCode;
	}

	public void setHttpStatusCode(int httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}

}
