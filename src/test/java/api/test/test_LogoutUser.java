package api.test;

import org.testng.Assert;
import org.testng.annotations.*;

import api.endpoints.UserEndPoints;
import api.payload.BaseClass;


public class test_LogoutUser extends BaseClass {
	@Test(description = "test for validating of user logout", priority=1)
	public void test_logoutuser() {
		logger.info("validating of user logout");
		response = UserEndPoints.logoutuser();
		logResponse(response);
		Assert.assertTrue(response.jsonPath().getString("message").contains("ok"), "message should contain ok message");
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
