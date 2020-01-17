package mx.com.gnp.plus.consultasinies.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import gnp.si.servidor.Ksilvl06;
import lombok.extern.slf4j.Slf4j;
import mx.com.gnp.plus.consultasinies.exception.ExceptionEot;
import mx.com.gnp.plus.consultasinies.model.ConsultaSiniestrosRequest;
import mx.com.gnp.plus.consultasinies.model.ConsultaSiniestrosResponse;
import mx.com.gnp.plus.consultasinies.services.TransaccionInfoService;
import mx.com.gnp.plus.consultasinies.utils.*;

/**
 * Clase controller para aplicación microservicio java.
 * 
 * @author jsetien
 *
 */
@RestController
@Slf4j
public class AppController  implements ConsultaSiniestrosApi{
	public static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AppController.class);

	/** The service. */
	@Autowired
	private TransaccionInfoService service;
	
	/**

	/**
	 * Consulta los siniestros asociados a la p�liza
	 *
	 * @param request the request
	 * @param bindingResult the binding result
	 * @return the response entity
	 * @throws ExceptionEot the exception eot
	 */
	
@Override
	public final ResponseEntity<ConsultaSiniestrosResponse> consultaSiniestrosporPoliza(
			@Valid @ModelAttribute final ConsultaSiniestrosRequest request, final BindingResult bindingResult) throws ExceptionEot {
		if (bindingResult.hasErrors()) {
			throw Utils.createExcepcion(Utils.getMessages(bindingResult.getFieldErrors()), HttpStatus.BAD_REQUEST);
		}
			Ksilvl06 Ksilvl06 = service.callKsilml06(Mappers.consultaSiniestrosRequest(request));
			
			ConsultaSiniestrosResponse response = Mappers.consultaSiniestrosResponse(Ksilvl06);
			
			return new ResponseEntity<>(response, response.getResponseCodeStatus());
		
	}	

	
}
