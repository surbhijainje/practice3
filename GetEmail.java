package GmailApi;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;

public class GetEmail {
	 String access_token="ya29.a0AeTM1idSFSnxaKhe7_6-Pk1mRiWHy6y-nurKWhb9pV-exWYrIJBJURHGhu3JADOrVBb6IiKuMc3ICfT5C4IQ_dGCDf6inV3Wrf2WDc1z2mT6yvOmtMYU7JBlUWqGZKqyrOLxSNmPb6MzvRmzZgGpsWR3N70EaCgYKAaISARMSFQHWtWOmO-169VrTPcrIcpDIfHABug0163";
	@BeforeClass
	public void beforeclass() {
		RequestSpecBuilder rsb=new RequestSpecBuilder();
		rsb.setBaseUri("https://outh2.googleapi.com")
		.addHeader("Authorization","Bearer"+" "+access_token) .setContentType("application/json;charset=utf-8")
		.log(LogDetail.ALL);
		RestAssured.requestSpecification=rsb.build();
		
 	ResponseSpecBuilder resb=new ResponseSpecBuilder();
		resb.expectStatusCode(200)
		.expectContentType(ContentType.JSON)
		.log(LogDetail.ALL);
		RestAssured.responseSpecification =resb.build();
		
	}
  @Test
  public void f() {
	  RestAssured.given().pathParam("userId","apitesting1977@gmail.com")
	  .when().log().all()
	  .get("/gmail/v1/users/{userId}/profile");
  }
}
