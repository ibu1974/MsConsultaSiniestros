package mx.com.gnp.plus.consultasinies.utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;

import gnp.ae.distribucion.AqCabeceraArquitectura;
import gnp.si.servidor.Ksilil06;
import gnp.si.servidor.Ksilvl06;
import mx.com.gnp.plus.consultasinies.exception.ExceptionEot;
import mx.com.gnp.plus.consultasinies.model.ConsultaSiniestrosRequest;
import mx.com.gnp.plus.consultasinies.model.ConsultaSiniestrosResponse;
import mx.com.gnp.plus.consultasinies.utils.*;


// TODO: Auto-generated Javadoc
/**
 * The Class Mappers.
 */
public final class Mappers {
	
	/** The Constant LOG. */
	private static final Logger LOG = LogManager.getLogger(Mappers.class);
	
	private static final String idioma ="ES";
	
	/** Idioma de la aplicacion */ 

	private static final String aplicacion ="AE";
	
	
	/**
	 * Instantiates a new mappers.
	 */
	private Mappers() {
	}
	
	/**
	 * Creates the ksilil06.
	 *
	 * @param request the request
	 * @return the ksilil06
	 */
	public static Ksilil06 consultaSiniestrosRequest(final ConsultaSiniestrosRequest msgEntrada) throws ExceptionEot{
		Ksilil06 respuesta;
		respuesta = new Ksilil06();
		respuesta.setCdnumpol(msgEntrada.getCdnumpol());
		respuesta.setCdtipusu(msgEntrada.getCdtipusu());
		respuesta.setInsaneam(msgEntrada.getInsaneam());
		respuesta.setFeocusin(msgEntrada.getFeocusin());
		complementaCabecera(respuesta.getCabeceraArquitectura());
		return respuesta;
		}
	


	/**
	 * Creates the response consultar siniestros por poliza.
	 *
	 * @param Ksilvl06
	 * @return the response consultar siniestros por poliza
	 * @throws ExceptionEot the exception eot
	 */
	
	
	public static ConsultaSiniestrosResponse consultaSiniestrosResponse(final Ksilvl06 msgVta) throws ExceptionEot {
		ConsultaSiniestrosResponse respuesta;
		respuesta = new ConsultaSiniestrosResponse();
		if (msgVta != null) {
			int resul = Short.compare(ConstantesGenerales.OK, msgVta.getCderror());
			if (resul == 0) {
				for (int i=0;i<msgVta.getNuocurre();i++) {
					respuesta.getEstrgres()[i].setCdnumpol(msgVta.getEstrgsib()[i].getCdnumpol());
					respuesta.getEstrgres()[i].setDntomseg(msgVta.getEstrgsib()[i].getDntomseg());
					respuesta.getEstrgres()[i].setNoproduc(msgVta.getEstrgsib()[i].getNoproduc());
					respuesta.getEstrgres()[i].setCdsinies(msgVta.getEstrgsib()[i].getCdsinies());
					respuesta.getEstrgres()[i].setFeocusin(msgVta.getEstrgsib()[i].getFeocusin());
					respuesta.getEstrgres()[i].setFecomuni(msgVta.getEstrgsib()[i].getFecomuni());
					respuesta.getEstrgres()[i].setTcsitsin(msgVta.getEstrgsib()[i].getTcsitsin());
					respuesta.getEstrgres()[i].setCdtipacc(msgVta.getEstrgsib()[i].getCdtipacc());
				}
				respuesta.setResponseCode(HttpStatus.OK);
			} else {
				LOG.error("ERROR EN RESPUESTA DE INFO");
				LOG.error("Cderror: " + msgVta.getCderror());
				LOG.error("Dsdareg: " + msgVta.getDsarg1() + " " + 
				                        msgVta.getDsarg2()+ " " + 
						                msgVta.getDsarg3());
				throw new ExceptionEot(
						"Error en INFO, descripcion " + msgVta.getDsarg1() + " " + 
				                                        msgVta.getDsarg2()+ " " + 
								                        msgVta.getDsarg3() + " : " + 
				                                        msgVta.getCderror(),
						HttpStatus.BAD_REQUEST);
			}
		}

		return respuesta;
	}	
	
    public static void complementaCabecera(final AqCabeceraArquitectura cabeceraArquitectura) {
            cabeceraArquitectura.setCdidioma(idioma);
            cabeceraArquitectura.setCdaplic(aplicacion);
    }

}
