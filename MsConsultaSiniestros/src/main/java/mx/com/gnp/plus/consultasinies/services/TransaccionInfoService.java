package mx.com.gnp.plus.consultasinies.services;

import gnp.si.servidor.Ksilil06;
import gnp.si.servidor.Ksilvl06;
import mx.com.gnp.plus.consultasinies.exception.ExceptionEot;


/**
 * The Interface TransaccionInfoService.
 */
public interface TransaccionInfoService {
	
	/**
	 * Call ksilml06.
	 *
	 * @param mensajeIda the mensaje ida
	 * @return the ksilml06
	 * @throws ExceptionEot the exception eot
	 */
	Ksilvl06 callKsilml06(Ksilil06 mensajeIda)throws ExceptionEot;
	
	

}
