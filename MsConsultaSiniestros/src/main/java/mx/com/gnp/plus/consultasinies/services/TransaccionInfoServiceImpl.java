package mx.com.gnp.plus.consultasinies.services;




import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import gnp.si.servidor.ConsultaSiniestrosStub;
import gnp.si.servidor.Ksilil06;
import gnp.si.servidor.Ksilvl06;
import mx.com.gnp.plus.consultasinies.exception.ExceptionEot;
import mx.com.gnp.plus.consultasinies.utils.Utils;



/**
 * The Class TransaccionInfoServiceImpl.
 */
@Service
public class TransaccionInfoServiceImpl  implements TransaccionInfoService {
	
	/** The Constant LOG. */
	private static final Logger LOG = LogManager.getLogger(TransaccionInfoServiceImpl.class);
	
	/**
	 * Call Ksilml06. 
	 *
	 * @param mensajeIda the mensaje ida
	 * @return the Ksilvl06 
	 * @throws ExceptionEot the exception eot
	 */
	@Override
	public final Ksilvl06 callKsilml06(final Ksilil06 mensajeIda)throws ExceptionEot {
		ConsultaSiniestrosStub servidor = new ConsultaSiniestrosStub();
		Ksilvl06 resultado;
		LOG.info("llamando callKsilml06");
		try {
			resultado = servidor.Ksilml06(mensajeIda);
		} catch (Exception e) {
			LOG.error(Utils.getStackTrace(e));
			throw new ExceptionEot(Utils.getCause(e), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resultado;
	}
	

}
