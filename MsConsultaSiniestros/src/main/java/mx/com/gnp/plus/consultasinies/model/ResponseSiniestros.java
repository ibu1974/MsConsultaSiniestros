package mx.com.gnp.plus.consultasinies.model;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class RespuestaMovimientoInfo.
 */
public class ResponseSiniestros {
	
	/** The response code. */
	@ApiModelProperty(hidden = true)
	private HttpStatus responseCode;

	/**
	 * Gets the response code status.
	 *
	 * @return the response code status
	 */
	@JsonIgnore
	public final HttpStatus getResponseCodeStatus() {
		return responseCode;
	}
	
	/**
	 * Gets the response code.
	 *
	 * @return the response code
	 */
	public final int getResponseCode() {
		return responseCode.value();
	}

	/**
	 * Sets the response code.
	 *
	 * @param responseCode the new response code
	 */
	public final void setResponseCode(final HttpStatus responseCode) {
		this.responseCode = responseCode;
	}

}
