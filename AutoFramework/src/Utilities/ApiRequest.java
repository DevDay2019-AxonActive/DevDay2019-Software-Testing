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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApiRequest {
	
	private Builder request = null;
	private String apiUrl = "";
	private String endpoint = "";
	private Properties prop;
	
	public ApiRequest() {
		loadEndpoint();
		this.endpoint = prop.getProperty("apiEndpoint");
	}
	
	public ApiRequest(String apiPath) {
		loadEndpoint();
		this.endpoint = prop.getProperty("apiEndpoint");
		this.apiUrl = "http://" + this.endpoint + apiPath;
	}
	
	private void loadEndpoint() {
		try {
			InputStream input = new FileInputStream("src/Properties/api.properties");
			prop = new Properties();

            // load a properties file
            prop.load(input);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void initBuilder() {
		if(this.apiUrl == "") {
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
		WebTarget resource = client.target(apiUrl);
		System.out.println("Init request Builder");
		this.request = resource.request();
		this.request.accept(MediaType.APPLICATION_JSON);
	}

	public String getServiceUrl() {
		return apiUrl;
	}

	public void setServiceUrl(String serviceUrl) {
		this.apiUrl = serviceUrl;
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
