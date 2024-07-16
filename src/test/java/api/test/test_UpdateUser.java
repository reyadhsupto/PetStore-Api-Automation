package api.test;
//import api.test.BaseClass;

import org.testng.Assert;
import org.testng.annotations.*;

import api.endpoints.UserEndPoints;
import api.payload.BaseClass;
import api.payload.UserPayload;

public class test_UpdateUser extends BaseClass {
	UserPayload payload = new UserPayload();
	
	@Test(description="Test for Validating update user", priority = 1, enabled= true)
	public void test_updateuser() {
//		logger.info("validating status code for update user");
//		
//		logger.info("setting up modified data for operation update");
//		payload.setUsername(faker.name().username());
//		payload.setFirstname(faker.name().firstName());
//		payload.setLastname(faker.name().lastName());
//		payload.setEmail(faker.internet().safeEmailAddress());
//		payload.setPassword(faker.internet().password(5, 10));
//		response = UserEndPoints.updateUser(payload.getUsername(), payload);
//		logResponse(response);
		
		response = UserEndPoints.getUser(payload.userPayLoad().getUsername());
		logResponse(response);
		logger.info( "logging username is :" + response.jsonPath().getString("username"));
		
		logger.info("Checking Staus code to be 200");
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("checking reponse body");
		String expectedUsername = this.payload.userPayLoad().getUsername();
	    Assert.assertEquals(response.jsonPath().getString("username"), expectedUsername, "Username does not match");
	    Assert.assertNotNull(response.jsonPath().getString("id"), "User ID is null");
	    Assert.assertNotNull(response.jsonPath().getString("email"), "User email is null");
	}

}
