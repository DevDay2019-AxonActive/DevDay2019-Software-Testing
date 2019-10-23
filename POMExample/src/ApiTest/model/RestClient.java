package ApiTest.model;

import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import java.security.cert.X509Certificate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RestClient {
	
	private Client client=null;
    private ClientResponseFilter filter;
    private String monexioEndpoint = Settings.getProperties().getProperty("twint.smartphone.url");
    private String adminEndpoint = Settings.getProperties().getProperty("twint.admin.url");
    private String portalEndpoint = Settings.getProperties().getProperty("twint.portal.url");
    private String schemeEndpoint = Settings.getProperties().getProperty(("twint.scheme.url"));

    public boolean console = false;

    private enum EndPoint {
        SMARTPHONE, ADMIN, PORTAL, SCHEME
    }

    public RestClient(ClientResponseFilter filter) {
        this.filter = filter;
        if(client == null ){
            try {
                SSLContext sslcontext = SSLContext.getInstance("TLS");

                sslcontext.init(null, new TrustManager[]{new X509TrustManager()
                {
                    public void checkClientTrusted(X509Certificate[] arg0, String arg1) {}
                    public void checkServerTrusted(X509Certificate[] arg0, String arg1) {}
                    public X509Certificate[] getAcceptedIssuers()
                    {
                        return new X509Certificate[0];
                    }

                }}, new java.security.SecureRandom());

                HostnameVerifier allowAll = (hostname, session) -> true;

                if(!console){
                    ResteasyProviderFactory factory = ResteasyProviderFactory.getInstance();
                    ResteasyProviderFactory.pushContext(javax.ws.rs.ext.Providers.class, factory);
                }

                client = JerseyClientBuilder.newBuilder().sslContext(sslcontext).hostnameVerifier(allowAll).build();
                client.register(new LoggingFeature(Logger.getGlobal(), Level.INFO, null,null));
                client.property(ClientProperties.FOLLOW_REDIRECTS, Boolean.FALSE);
                client.property(LoggingFeature.LOGGING_FEATURE_VERBOSITY_CLIENT, LoggingFeature.Verbosity.PAYLOAD_ANY);
                client.register(JacksonFeature.class);
                client.register(MultiPartFeature.class);
                client.register(RestObjectMapper.class);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
