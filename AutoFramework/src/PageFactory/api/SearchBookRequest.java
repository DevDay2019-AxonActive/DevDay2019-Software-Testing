package PageFactory.api;

public class SearchBookRequest extends ApiRequest {
	
	private String searchBookApi = prop.getProperty("searchBookApi");
	
	public SearchBookRequest() {
		this.setServiceUrl("http://" + this.endpoint + "/" + searchBookApi);
	}
}
