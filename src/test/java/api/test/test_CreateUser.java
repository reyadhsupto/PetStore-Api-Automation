package api.test;
import org.testng.Assert;
import org.testng.annotations.*;


import api.endpoints.UserEndPoints;
import api.payload.BaseClass;
import api.payload.UserPayload;

public class test_CreateUser extends BaseClass{
	
	UserPayload payload = new UserPayload();
	
	
	@Test(description="Test for validating a user creation in the pet store",priority=1,enabled=true)
	public void test_createuser() {
		logger.info("validating user creation");
		response = UserEndPoints.createUser(payload.userPayLoad());
		logResponse(response);
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertTrue(response.jsonPath().getString("message").contains("ok"), "message should contain ok message");
	}

}
