package api.tests.DDtests;

import org.testng.Assert;
import org.testng.annotations.*;

import api.endpoints.UserEndPoints;
import api.payload.BaseClass;
import api.payload.User;
import api.utilities.DataProviders;

public class test_DDTCreateUser extends BaseClass {
	@Test(description="Test case for creating user through post method", dataProvider = "Data", dataProviderClass = DataProviders.class, priority=1)
	public void test_creteuser(String userID, String userName,String fname,String lname,String useremail,String pwd,String ph) {
		logger.info("Validating create user in ddt test suite");
		payload = new User();
		payload.setId(Integer.parseInt(userID));
		payload.setUsername(userName);
		payload.setFirstname(fname);
		payload.setLastname(lname);
		payload.setEmail(useremail);
		payload.setPassword(pwd);
		payload.setPhone(ph);
		
		response = UserEndPoints.createUser(payload);
		logResponse(response);
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertTrue(response.jsonPath().getString("message").contains("ok"), "message should contain ok message");
		
	}

}
