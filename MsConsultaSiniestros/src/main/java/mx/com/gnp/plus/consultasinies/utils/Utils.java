package mx.com.gnp.plus.consultasinies.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import mx.com.gnp.plus.consultasinies.exception.ExceptionEot;


/**
 * The Class Utils.
 */
public final class Utils {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(Utils.class);
	
	/** The Constant MAX_BUFFER. */
	private static final int MAX_BUFFER = 1000;

	/**
	 * Instantiates a new utils.
	 */
	private Utils() {

	}

	/**
	 * Gets the stack trace.
	 *
	 * @param ex the ex
	 * @return the stack trace
	 */
	public static String getStackTrace(final Exception ex) {
		StringBuilder sb = new StringBuilder(MAX_BUFFER);
		StackTraceElement[] st = ex.getStackTrace();
		sb.append(ex.getClass().getName() + ": " + ex.getMessage() + "\n");
		for (int i = 0; i < st.length; i++) {
			sb.append("\t at " + st[i].toString() + "\n");
		}
		return sb.toString();
	}

	/**
	 * Gets the cause.
	 *
	 * @param ex the ex
	 * @return the cause
	 */
	public static String getCause(final Exception ex) {
		String trace = getStackTrace(ex);
		trace =trace.substring(0, trace.indexOf('\n'));
		return trace;
	}
	

	/**
	 * Sets the date format.
	 *
	 * @param dateToFormate the date to formate
	 * @return the string
	 */
	public static String setDateFormat(final String dateToFormate) {
		DateFormat fromFormate = new SimpleDateFormat("yyyyMMdd");
    	DateFormat toFormate = new SimpleDateFormat("dd/MM/yyyy");
    	Date d = null;
		try {
			d = fromFormate.parse(dateToFormate);
		} catch (ParseException e) {
			LOG.error(Utils.getStackTrace(e));
			return "";
		}
    	return toFormate.format(d);
    	
	}
	
	/**
	 * Gets the messages.
	 *
	 * @param errors the errors
	 * @return the messages
	 */
	public static String getMessages(final List<FieldError> errors) {
		Set<String> messages = new HashSet<>(errors.size());
		for (FieldError error : errors) {
			String json = "{" + error.getField() + " | " + error.getRejectedValue() + " | " + error.getDefaultMessage() + "}";
			messages.add(json);
		}
		return messages.toString();
	}
	
	/**
	 * Creates the excepcion.
	 *
	 * @param mensaje the mensaje
	 * @param httpStatus the http status
	 * @return the exception eot
	 */
	public static ExceptionEot createExcepcion(final String mensaje, final HttpStatus httpStatus) {
		return new ExceptionEot(mensaje, httpStatus);
	}

}
