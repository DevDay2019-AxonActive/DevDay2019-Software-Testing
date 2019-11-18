package pages.api;

import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

import javax.ws.rs.client.Client;
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
	public String endpoint = "";
	public Properties prop;
	
	public ApiRequest() {
		loadApiProp();
	}
	
	public ApiRequest(String apiPath) {
		loadApiProp();
		this.apiUrl = "http://" + this.endpoint + apiPath;
	}
	
	private void loadApiProp() {
		try {
			InputStream input = new FileInputStream("conf/api.properties");
			prop = new Properties();

            // load a properties file
            prop.load(input);
    		this.endpoint = prop.getProperty("apiEndpoint");
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
		Client client = JerseyClientBuilder.newBuilder().build();
		client.register(new LoggingFeature(Logger.getGlobal(), Level.INFO, null,null));
		client.property(ClientProperties.FOLLOW_REDIRECTS, Boolean.FALSE);
		client.property(LoggingFeature.LOGGING_FEATURE_VERBOSITY_CLIENT, LoggingFeature.Verbosity.PAYLOAD_ANY);
		client.register(JacksonFeature.class);
		client.register(MultiPartFeature.class);

		WebTarget resource = client.target(apiUrl);
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
