package xai.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import edu.uoc.dpcs.lsim.logger.LoggerManager.Level;
import lsim.library.api.LSimLogger;
import xai.rest.jettyserver.api.Surface;
import xai.rest.jettyserver.api.Volum;
import xai.rest.jettyserver.api.Perimeter;

/**
 * @author Joan-Manuel Marques
 *
 */

public class RESTclient {

	public double sup(String address, int port, int value1, int value2) {
		LSimLogger.log(Level.INFO, "http://"+address+":"+port+"/cil/sup/"+value1+"/"+value2);
		LSimLogger.log(Level.INFO, "media type: application/json");

		/* COMPLETAR */
		
		Response res = operation("http://"+address+":"+port+"/cil/sup/"+value1+"/"+value2, "application/json");
		if (res != null) 
			return ((Surface)res.readEntity(Surface.class)).getSur();	
		return Double.MIN_VALUE;
	}
	
	public double per(String address, int port, int value1, int value2) {
		LSimLogger.log(Level.INFO, "http://"+address+":"+port+"/cil/per/"+value1+"/"+value2);
		LSimLogger.log(Level.INFO, "media type: application/json");

		/* COMPLETAR */
		
		Response res = operation("http://"+address+":"+port+"/cil/per/"+value1+"/"+value2, "application/json");
		if (res != null) 
			return ((Perimeter)res.readEntity(Perimeter.class)).getPer();	
		return Double.MIN_VALUE;
	}

	public Volum vol(String address, int port, int value1, int value2) {
		LSimLogger.log(Level.INFO, "http://"+address+":"+port+"/cil/vol/"+value1+"/"+value2);
		LSimLogger.log(Level.INFO, "media type: application/json");

		/* COMPLETAR */
		
		Response res = operation("http://"+address+":"+port+"/cil/vol/"+value1+"/"+value2, "application/json");
		if (res != null) 
			return ((Volum)res.readEntity(Volum.class));	
		return null;
	}
	
	private Response operation(String rest_service_url, String media_type) {
		Client client;
		Response res = null;

		/* COMPLETAR */
		client = ClientBuilder.newClient(); 

		WebTarget target = client.target(rest_service_url);//

		res =target.request(media_type).get();
		
		return res;
	}
}
