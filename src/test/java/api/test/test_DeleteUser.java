package api.test;

import org.testng.Assert;
import org.testng.annotations.*;

import api.endpoints.UserEndPoints;
import api.payload.BaseClass;

public class test_DeleteUser extends BaseClass{
	@Test(description="Test for Validating delete user through status code", priority = 6, enabled= true)
	public void test_deleteuser() {
		logger.info("validating status code for delete user");
		
		response = UserEndPoints.deleteUser(payload.getUsername());
		logResponse(response);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertTrue(response.jsonPath().getString("message").contains(payload.getUsername()), "message should contain the deleted username");
	}

}
