import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Message {

	final static Logger logger = LogManager.getLogger(Message.class);
	
	private void logMessages(String parameter) {
		logger.error("Este es un mensaje de Error: " + parameter);
		logger.fatal("Este es un mensaje de Error: " + parameter);
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Message mensaje1 = new Message();
			
			mensaje1.logMessages("parametros");
	}

}
