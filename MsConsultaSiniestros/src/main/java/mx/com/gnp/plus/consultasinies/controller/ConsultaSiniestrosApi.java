package mx.com.gnp.plus.consultasinies.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import mx.com.gnp.plus.consultasinies.exception.ExceptionEot;
import mx.com.gnp.plus.consultasinies.model.ConsultaSiniestrosRequest;
import mx.com.gnp.plus.consultasinies.model.ConsultaSiniestrosResponse;
import mx.com.gnp.plus.consultasinies.utils.ConstantesGenerales;

public interface ConsultaSiniestrosApi {
	/**
	 * Consulta los siniestros asociados a la póliza
	 *
	 * @param request the request
	 * @param bindingResult the binding result
	 * @return the response entity
	 * @throws ExceptionEot the exception eot
	 */
	@ApiOperation(value = "Actualiza el estado de una operacion de endoso no economico en INFO.", 
			notes = "Ejecuta el programa KSILML06.", 
			response = ConsultaSiniestrosResponse.class, 
			tags = { "Consulta Siniestros por poliza INFO" })
	@ApiResponses(value = { @ApiResponse(code = ConstantesGenerales.BAD_REQUEST, message = ConstantesGenerales.BAD_REQUEST_MESSAGE),
			@ApiResponse(code = ConstantesGenerales.UNAUTHORIZED, message = ConstantesGenerales.UNAUTHORIZED_MESSAGE),
			@ApiResponse(code = ConstantesGenerales.FORBIDDEN, message = ConstantesGenerales.FORBIDDEN_MESSAGE),
			@ApiResponse(code = ConstantesGenerales.NOT_FOUND, message = ConstantesGenerales.NOT_FOUND_MESSAGE),
			@ApiResponse(code = ConstantesGenerales.INTERNAL_SERVER_ERROR, message = ConstantesGenerales.INTERNAL_SERVER_ERROR_MESSAGE) })
	@RequestMapping(path = "/Consultas/consultarSiniestros", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	ResponseEntity<ConsultaSiniestrosResponse> consultaSiniestrosporPoliza(
			ConsultaSiniestrosRequest request, BindingResult bindingResult) throws ExceptionEot;

}
