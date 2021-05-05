package xai.rest.jettyserver.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/*import edu.uoc.dpcs.lsim.logger.LoggerManager.Level;
import lsim.library.api.LSimLogger;*/

/**
 * @author Joan-Manuel Marques
 *
 */
@Path("/api")
public class RestServerAPI {

	/**
	 * Adds two numbers
	 *
	 * @param num_1
	 * @param num_2
	 * @return
	 */
	@GET
	@Path("/add/{num_1}/{num_2}")
	@Produces(MediaType.TEXT_PLAIN)
	public String add(@PathParam("num_1") int n1,
			@PathParam("num_2") int n2) {
		//LSimLogger.log(Level.INFO, "add");		

		int result = Integer.MIN_VALUE;

		result = n1 + n2;

		return (new Integer(result)).toString();
	}

	/**
	 * Subtract two numbers
	 *
	 * @param num_1
	 * @param num_2
	 * @return
	 */
	@GET
	@Path("/sub/{num_1}/{num_2}")
	@Produces(MediaType.APPLICATION_JSON)
	public String sub(@PathParam("num_1") int n1,
			@PathParam("num_2") int n2) {

		//LSimLogger.log(Level.INFO, "sub");
		
		/* COMPLETAR */

		int result = Integer.MIN_VALUE;

		result = n1 - n2;
		
		Gson gson = new Gson();
		String json = gson.toJson(result);

		return json;
	}

	/**
	 * Divides two numbers
	 *
	 * @param num_1
	 * @param num_2
	 * @return a json object containing the quotient and the remainder
	 */
	@GET
	@Path("/divide/{num_1}/{num_2}")
	@Produces(MediaType.APPLICATION_JSON)
	public String div(@PathParam("num_1") int n1,
			@PathParam("num_2") int n2) {
		//LSimLogger.log(Level.INFO, "divide");
		
		/* COMPLETAR */

		Division result = new Division(n1, n2);
		
		Gson gson = new Gson();
		String json = gson.toJson(result);

		return json;
	}
}
