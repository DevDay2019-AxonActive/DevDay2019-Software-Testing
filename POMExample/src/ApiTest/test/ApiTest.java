package ApiTest.test;

import javax.ws.rs.core.Response;
import org.testng.annotations.Test;
import ApiTest.model.ApiRequest;

public class ApiTest {

	/**
	 * This test will call REST service get single book with Id
	 */
	@Test
	public void test_get_single_book() {
		String bookID = "1";
		String serviceUrl = "http://getbook/" + bookID;
		ApiRequest request = new ApiRequest(serviceUrl);
		Response response = request.get();
		if(response.getStatus()==200) {
			System.out.println("Success: {" + response.getEntity()+ "}");
		} else {
			System.out.println("Failed: {" + response.getEntity() + "}");
		}
	}
}
