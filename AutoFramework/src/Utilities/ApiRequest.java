package Utilities;

import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.client.Invocation.Builder;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApiRequest {
	
	private Builder request = null;
	private String serviceUrl = "";
	
	public ApiRequest() {
	}
	
	public ApiRequest(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}
	
	private void initBuilder() {
		if(this.serviceUrl == "") {
			throw new RuntimeException("Service url is empty");
		}
		System.out.println("Init Client");
		Client client = JerseyClientBuilder.newBuilder().build();
		client.register(new LoggingFeature(Logger.getGlobal(), Level.INFO, null,null));
		client.property(ClientProperties.FOLLOW_REDIRECTS, Boolean.FALSE);
		client.property(LoggingFeature.LOGGING_FEATURE_VERBOSITY_CLIENT, LoggingFeature.Verbosity.PAYLOAD_ANY);
		client.register(JacksonFeature.class);
		client.register(MultiPartFeature.class);

		System.out.println("Init WebTarget");
		WebTarget resource = client.target(serviceUrl);
		System.out.println("Init request Builder");
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
