package api.payload;

import com.github.javafaker.Faker;

public class UserPayload {
	public Faker faker;
	
	public User userPayLoad()
	{
		User payload =new User();
		payload.setId(faker.idNumber().hashCode());
		payload.setUsername(faker.name().username());
		payload.setFirstname(faker.name().firstName());
		payload.setLastname(faker.name().lastName());
		payload.setEmail(faker.internet().safeEmailAddress());
		payload.setPassword(faker.internet().password(6, 10));
		payload.setPhone(faker.phoneNumber().cellPhone());
		return payload;
	}

}
