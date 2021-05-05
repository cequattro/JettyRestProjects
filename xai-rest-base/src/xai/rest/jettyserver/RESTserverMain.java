package xai.rest.jettyserver;

//import lsim.library.api.LSimLogger;

/**
 * 
 * @author Joan-Manuel Marques
 *
 */
public class RESTserverMain {
	public static void main(String[] args) {
		//LSimLogger.setLoggerAsLocalLogger("Rest_servidor", "./logs/", true);
		JettyWebServer jws = new JettyWebServer(7070);
		jws.run();
		jws.stopJettyServerAfter(30000);
	}
}