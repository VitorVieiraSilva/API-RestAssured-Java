package teste;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class testeAPI extends massaDados {
	// String vote_id;

	@BeforeClass
	public static void urlBase() {
		RestAssured.baseURI = "https://fakerestapi.azurewebsites.net/api/v1/";
	}

	/*
	 * @Test public void cadastro() { String url =
	 * "https://api.thecatapi.com/v1/user/passwordlesssignup"; String corpo =
	 * "{\"email\":\"vitor.vieira10@hotmail.com\", \"appDescription\": \"teste 2\"}"
	 * ;
	 * 
	 * Response response = given().contentType("application/json").body(corpo).
	 * when().post(url); response.then().statusCode(200).body("message",
	 * containsString("SUCCESS"));
	 * 
	 * System.out.println("RETORNO => " + response.body().asString());
	 * 
	 * }
	 */

	@Test
	public void postAutor() {

		Response response = given().contentType("application/json").body(corpoPost).when().post(epAutor);
		// response.then().statusCode(200); //.body("message",
		// containsString("SUCCESS"));

		// System.out.println("RETORNO => " + response.body().asString());
		validaStatus(response);
		String id = response.jsonPath().getString("id");
		System.out.println("ID => " + id);
		// String ID = response.jsonPath().getString("id");

	}
	/*
	 * @Test public void deletaVotacao() { votacao(); deletaVoto(); }
	 */

	@Test
	public void getAutors() {
		String url = "Authors/1";

		// Response response = given().header("Accept", "text/plain");
		Response response = when().get(url);
		validaStatus(response);
		// String resposta = "RETORNO => " + response.body().asString();
		// System.out.println(resposta);

	}

	@Test
	public void putAutor() {
		Response response = given().contentType("application/json").body(corpoPut).when().put("Authors/1");
		validaStatus(response);

	}
	
	@Test
	public void deleteAutor() {
		Response response = when().delete("Authors/1");
		validaStatus(response);
	}

	public void validaStatus(Response response) {
		response.then().statusCode(200);
		System.out.println("RETORNO => " + response.body().asString());
		System.out.println("-----------------------------------------");

	}

}
