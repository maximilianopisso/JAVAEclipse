package paquetes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Message {

	public Logger logger=  LogManager.getLogger(Message.class);
	
				
	public void logMjsWarning(String parameter) {
		logger.warn("Advertencia: " + parameter);		
	}
	
	public void logMjsFatal(String parameter) {	
		logger.fatal("Fatal: " + parameter);
	}
	
	public void logMjsInfo(String parameter) {
			    
		logger.info("Info: " + parameter);
		
	}
	}
	

