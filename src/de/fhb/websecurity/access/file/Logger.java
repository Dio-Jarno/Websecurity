package de.fhb.websecurity.access.file;

import java.text.SimpleDateFormat;
import java.util.Date;

import aglib.dataaccess.file.FileAccessor;


/**
 * A logger, who writes a message to a file. This class is a singleton.
 * 
 * @author Arvid Grunenberg
 * @version 0.1
 *
 */
public class Logger extends FileAccessor {
	
	private final String PATH = "/users/Arvid/Documents/workspace/Websecurity/WebContent/res/log/log.txt";
	protected static Logger instance;
	
	
	private Logger() {
		super();
	}
	
	/**
	 * @return The instance of the logger.
	 */
	public static Logger getInstance() {
		if (instance == null) {
			instance = new Logger();
		}
		return instance;
	}
	
	/**
	 * It creates the log entry with the given message and a date.
	 * 
	 * @param message - The message, which should be inside the log entry.
	 */
	private void log(StringBuffer message) {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat df = new SimpleDateFormat("E dd.MM.yyyy - k:m:s z");
		message.append(" (");
		message.append(df.format(date));
		message.append(")");
		System.out.println(message);
		this.saveTextFile(PATH, message.toString());
	}
	
	/**
	 * It creates an information entry.
	 * 
	 * @param message - The message, which should be inside the log entry.
	 */
	public void logInfo(StringBuffer message) {
		log(message.insert(0, "INFO: "));
	}
	
	/**
	 * It creates a warning entry.
	 * 
	 * @param message - The message, which should be inside the log entry.
	 */
	public void logWarning(StringBuffer message) {
		log(message.insert(0, "WARNING: "));
	}
	
	/**
	 * It creates an error entry.
	 * 
	 * @param message - The message, which should be inside the log entry.
	 */
	public void logError(StringBuffer message) {
		log(message.insert(0, "ERROR: "));
	}

}
