package xai.rest.client;

//import lsim.library.api.LSimLogger;

/**
 * @author Joan-Manuel Marques
 *
 */

public class RESTclientMain {
	public static void main(String[] args) throws Exception {
		//LSimLogger.setLoggerAsLocalLogger("Rest_client", "./logs/", true);
		RESTclient rs = new RESTclient();
		System.out.println ("add: "+rs.add("localhost", 7070, 6, 2));                                           
		System.out.println ("sub: "+rs.sub("localhost", 7070, 6, 2));                                           
		System.out.println ("divide: "+ rs.divide("localhost", 7070, 6, 2));
	}
}