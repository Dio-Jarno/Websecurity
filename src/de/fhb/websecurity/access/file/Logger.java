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
	
	protected static String path;
	protected static Logger instance;
	
	
	protected Logger() {
		super();
		path = System.getProperty("user.home") + "/log.txt";
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
		if (path != null) {
			Date date = new Date(System.currentTimeMillis());
			SimpleDateFormat df = new SimpleDateFormat("E dd.MM.yyyy - k:m:s z");
			message.append(" (");
			message.append(df.format(date));
			message.append(")");
			System.out.println(message);
			this.saveTextFile(path, message.toString());
		} else {
			System.out.println("ERROR: Your Logger is not initialized!");
		}
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
	
	public String getPath() {
		return path;
	}

}
