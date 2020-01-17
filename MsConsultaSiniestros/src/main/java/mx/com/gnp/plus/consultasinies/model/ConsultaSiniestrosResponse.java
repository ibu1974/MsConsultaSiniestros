package mx.com.gnp.plus.consultasinies.model;


import gnp.si.ModeloDatos.*;


public class ConsultaSiniestrosResponse extends ResponseSiniestros{
	/**
	 * 
	 */
	public short codigoError;
	public String descripError;
	
	public Ksirgres[] estrgres = new Ksirgres[25];


	public ConsultaSiniestrosResponse()
	{
			for (int i0=0;i0 < 25; i0++) {
		estrgres[i0] = new Ksirgres();
		}


	}


	public Ksirgres[] getEstrgres() {
		return estrgres;
	}


	public void setEstrgres(Ksirgres[] estrgres) {
		this.estrgres = estrgres;
	}


	public short getCodigoError() {
		return codigoError;
	}


	public void setCodigoError(short codigoError) {
		this.codigoError = codigoError;
	}


	public String getDescripError() {
		return descripError;
	}


	public void setDescripError(String descripError) {
		this.descripError = descripError;
	}


}
