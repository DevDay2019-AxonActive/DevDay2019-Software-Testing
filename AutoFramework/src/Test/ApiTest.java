package Test;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Utilities.ApiRequest;

public class ApiTest {

	/**
	 * This test will call REST service get single book with Id
	 */
	@Test
	public void test_search_book_with_keyword() {
		String apiPath = "/library-core/api/books/search";
		ApiRequest request = new ApiRequest(apiPath);
		System.out.println("Start test with service: " + request.getServiceUrl());
		
		Map<String, String> jsonBody = new HashMap<>();
		jsonBody.put("keyword", "Charlotte's Web");
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			System.out.println("Search book with keyword: " + mapper.writeValueAsString(jsonBody));
			Response response = request.post(Entity.entity(mapper.writeValueAsString(jsonBody), MediaType.APPLICATION_JSON));

			if(response.getStatus()==200) {
				System.out.println("Success: {" + response.readEntity(String.class)+ "}");
			} else {
				System.out.println("Failed: {" + response.readEntity(String.class) + "}");
			}
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			System.out.println("Cannot execute service api " + apiPath);
			e.printStackTrace();
		}
	}
}
