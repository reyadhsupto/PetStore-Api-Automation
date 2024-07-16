package api.test;

import org.testng.Assert;
import org.testng.annotations.*;

import api.endpoints.UserEndPoints;
import api.payload.BaseClass;

public class test_GetUser extends BaseClass {
	@Test(description="Test for Validating Get user",priority=1,enabled=true)
	public void test_getuser() {
		
		logger.info("validating status code of the get method for showing created user");
		response = UserEndPoints.getUser(payload.getUsername());
		logResponse(response);
		
		Assert.assertEquals(response.getStatusCode(), 200, "Response status code shouldbe 200");
		Assert.assertEquals(response.jsonPath().getString("username"),payload.getUsername()," Response Username should be same as the payload username");
		Assert.assertEquals(response.jsonPath().getString("email"),payload.getEmail(),"Response email should be same as the payload email");
		Assert.assertEquals(response.jsonPath().getString("password"),payload.getPassword(),"Response password should be same as the payload password");
		Assert.assertEquals(response.jsonPath().getString("firstName"),payload.getFirstname(),"Response firstname should be same as the payload firstname");
		Assert.assertEquals(response.jsonPath().getString("lastName"),payload.getLastname(),"Response lastname should be same as the payload lastname");
		Assert.assertEquals(response.jsonPath().getString("phone"),payload.getPhone(),"Response phone should be same as the payload phone");
		
	}

}

