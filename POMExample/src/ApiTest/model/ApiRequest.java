package ApiTest.model;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.client.Invocation.Builder;

public class ApiRequest {
	
	private Builder request = null;
	private String serviceUrl = "";
	
	public ApiRequest() {
	}
	
	public ApiRequest(String serviceUrl) {
		this.serviceUrl = serviceUrl;
		initBuilder();
	}
	
	private void initBuilder() {
		if(this.serviceUrl == "") {
			throw new RuntimeException("Service url is empty");
		}
		Client client = ClientBuilder.newClient();
		WebTarget resource = client.target(serviceUrl);
		this.request = resource.request();
		this.request.accept(MediaType.APPLICATION_JSON);
	}

	public String getServiceUrl() {
		return serviceUrl;
	}

	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}
	
	public Response get() {
		initBuilder();
		return this.request.get();
	}
	
	public Response put(Entity<?> entity) {
		initBuilder();
		return this.request.put(entity);		
	}
	
	public Response post(Entity<?> entity) {
		initBuilder();
		return this.request.post(entity);		
	}
}
