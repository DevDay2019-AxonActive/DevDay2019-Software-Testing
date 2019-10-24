package ApiTest.test;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ApiTest.model.ApiRequest;

public class ApiTest {

	/**
	 * This test will call REST service get single book with Id
	 */
	@Test
	public void test_get_single_book() {
		String serviceUrl = "http://192.168.70.59:8080/library-core/api/books/search";
		ApiRequest request = new ApiRequest(serviceUrl);
		
		Map<String, String> jsonBody = new HashMap<>();
		jsonBody.put("keyword", "Charlotte's Web");
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			Response response = request.post(Entity.entity(mapper.writeValueAsString(jsonBody), MediaType.APPLICATION_JSON));

			if(response.getStatus()==200) {
				System.out.println("Success: {" + response.getEntity()+ "}");
			} else {
				System.out.println("Failed: {" + response.getEntity() + "}");
			}
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			System.out.println("Cannot execute service api " + serviceUrl);
			e.printStackTrace();
		}
	}
}
