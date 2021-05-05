package xai.rest.client;

import java.io.File;

import lsim.library.api.LSimLogger;

/**
 * @author Joan-Manuel Marques
 *
 */

public class RESTclientMain {
	public static void main(String[] args) throws Exception {
		LSimLogger.setLoggerAsLocalLogger("Rest_client", "." + File.separator + "logs" + File.separator, true);
		RESTclient rs = new RESTclient();
		System.out.println ("sup: "+rs.sup("localhost", 7070, 6, 2));  
		System.out.println ("per: "+rs.per("localhost", 7070, 6, 2));		
		System.out.println ("vol: "+rs.vol("localhost", 7070, 6, 2));		                                          
	}
}