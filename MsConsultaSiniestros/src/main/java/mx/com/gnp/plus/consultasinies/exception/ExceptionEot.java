
package mx.com.gnp.plus.consultasinies.exception;



import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;



/**
 * The Class ExceptionEot.
 */

public final class ExceptionEot extends Exception {

	  /** The Constant serialVersionUID. */
	  private static final long serialVersionUID = 1L;

	  /** The response code. */
	  private final HttpStatus responseCode;


	  /**
  	 * Instantiates a new exception eot.
  	 *
  	 * @param mensaje the mensaje
  	 * @param responseCode the response code
  	 */
	  public ExceptionEot(final String mensaje, final HttpStatus responseCode) {
	    super(mensaje);
	    this.responseCode = responseCode;
		throw new ResponseStatusException(responseCode,mensaje);

	  }

	  /**
  	 * Gets the response code.
  	 *
  	 * @return the response code
  	 */
	  public HttpStatus getResponseCode() {
	    return responseCode;
	  }


	}


