package framework;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static io.restassured.RestAssured.responseSpecification;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import pojo_classes_create_playlist.PlaylistWithPojo;

public class create_playlist_with_pojo_classes {
	String access_token="BQAYp-sDRQwkXZ5TUi6j6WoCk11e86upYKxccTfNduwF6B_rAomZiOsv5oMR0bGTK09g-qa0JMnJSgt9lA5t9YiZ7uAKNOktXpbarfez23TKPYQKmjxf_O83QH2p0ineAmyMFgIQT8DELkObiZ-ML2feCncqpwxlEGZZMiPSK-Jwjde1GIYirBtXaEWh8nKUVa2Q88R3i6oimCOwGdARjyEMD-W9v-pcPuZb8m_WyxE_7yKtGisFC1bWkyREDLGqnAtu68Ii15aEMbeJ";
	@BeforeClass
	public void beforeclass() {
		RequestSpecBuilder rsb=new RequestSpecBuilder();
		rsb.setBaseUri("https://api.spotify.com")
		.addHeader("Authorization","Bearer"+" "+access_token) .setContentType("application/json;charset=utf-8")
		.log(LogDetail.ALL);
		requestSpecification=rsb.build();
		
 	ResponseSpecBuilder resb=new ResponseSpecBuilder();
		resb//expectStatusCode(200)
		//.expectContentType(ContentType.JSON)
		.log(LogDetail.ALL);
		responseSpecification =resb.build();}
	
  @Test(enabled=false)
  public void create_playlist_withpojo() {
	  PlaylistWithPojo withpojo=new PlaylistWithPojo();
	  withpojo.setName("beauty");
	  withpojo.setDescription("beauty songs");
	  withpojo.setPublic(false);
	  
	 PlaylistWithPojo responses = given().body(withpojo).
	  when().post("/v1/users/31v2gus2luj4tbr7y6gnzc2xrtai/playlists")
	  .then().log().all().extract().response().as(PlaylistWithPojo.class);
	 
	 assertThat(responses.getName(),equalTo(withpojo.getName()));
	
  }
  @Test
  public void update_playlist_withpojo() {
	  PlaylistWithPojo withpojo=new PlaylistWithPojo();
	  withpojo.setName("Hippo");
	  withpojo.setDescription("Hippo songs");
	  withpojo.setPublic(false);
	  
PlaylistWithPojo updatedresponse = given().body(withpojo).when()
	  .put("/v1/playlists/66t7CObnlQ5yvh2ynuJSTG").
	  then().log().all().extract().response().as(PlaylistWithPojo.class);

    assertThat(updatedresponse.getName(), equalTo(withpojo.getName()));
	  
}
}
