package api.test;

import org.testng.Assert;
import org.testng.annotations.*;

import api.endpoints.UserEndPoints;
import api.payload.BaseClass;

public class test_LoginUser extends BaseClass {
	@Test(description="Test for validating login user",priority=1,enabled=true)
	public void test_loginuser() {
		logger.info("validating of user login through username and password");
		response = UserEndPoints.loginuser(payload.getUsername(), payload.getPassword());
		logResponse(response);
		Assert.assertEquals(response.getStatusCode(), 200);
		String message = response.jsonPath().getString("message");
		Assert.assertTrue(message.startsWith("logged in user session:"), "Message should start with 'logged in user session:'");
	}

}
