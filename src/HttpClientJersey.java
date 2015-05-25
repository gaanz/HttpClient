import java.io.IOException;

import javax.ws.rs.core.MultivaluedMap;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.LoggingFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class HttpClientJersey {
	public static void main(String[] args) throws Exception, IOException {
		
		Client client = Client.create();
		client.addFilter(new LoggingFilter(System.out));
//		WebResource webResource = client
//				.resource("http://110.49.200.91/dynamic/status.xml");
		WebResource webResource = client
				.resource("http://127.0.0.1:8080/JerseyRest/dynamic/status.xml");
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();

		// Get response from RESTful Server get(ClientResponse.class);
		ClientResponse response = null;
		response = webResource.queryParams(queryParams)
				.header("Host", "110.49.200.91")
				.header("Accept", "*/*")
				.header("X-MSISDN", "0889081799")
				.get(ClientResponse.class);
		String responseHttp = response.getEntity(String.class);
		System.out.println(responseHttp);
	}
}