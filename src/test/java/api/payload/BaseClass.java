package api.payload;

import org.testng.annotations.*;

import reports.ExtentManager;

import com.github.javafaker.Faker;

import api.test.UserTests;
import io.restassured.response.Response;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class BaseClass {
	public Faker faker;
	public User payload;
	public Response response;
	public static final Logger logger = LoggerFactory.getLogger(UserTests.class);
	public ExecutorService service;
	
	public void logResponse(Response response) {
		logger.info("logging response body");
		response.then().log().all();
	}
//	@BeforeTest
//	public void setupData() {
//		logger.info("setting up userdata for request body");
//		faker = new Faker();
//		payload = new User();
//		
//		payload.setId(faker.idNumber().hashCode());
//		payload.setUsername(faker.name().username());
//		payload.setFirstname(faker.name().firstName());
//		payload.setLastname(faker.name().lastName());
//		payload.setEmail(faker.internet().safeEmailAddress());
//		payload.setPassword(faker.internet().password(6, 10));
//		payload.setPhone(faker.phoneNumber().cellPhone());
//		logger.info("userdata setup complete");
//	}
	
	
	@BeforeSuite
	  public void beforeSuite() throws IOException {
	    ExtentManager.setExtent();
	    service = Executors.newFixedThreadPool(5);
	  }

	  @AfterSuite
	  public void afterSuite() {
		  if (service != null && !service.isShutdown()) {
	            service.shutdown();
	        }
		  else {
			  System.out.println("Service is null");
		  }
	    ExtentManager.endReport();
	  }

}
