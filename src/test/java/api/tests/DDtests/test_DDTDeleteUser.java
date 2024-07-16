package api.tests.DDtests;

import api.endpoints.UserEndPoints;
import api.payload.BaseClass;
import api.utilities.DataProviders;

import org.testng.Assert;
import org.testng.annotations.*;

public class test_DDTDeleteUser extends BaseClass {
	@Test(description="Testing the delete request for ddt", priority=1, dataProvider="UserNames", dataProviderClass = DataProviders.class)
	public void test_deleteuser(String username) {
		logger.info("Validating the delete user DELETE request in ddt");
		response = UserEndPoints.deleteUser(username);
		logResponse(response);
		System.out.println("--------"+response.asString());
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertTrue(response.jsonPath().getString("message").contains(username), "message should contain the deleted username");
		
	}

}
