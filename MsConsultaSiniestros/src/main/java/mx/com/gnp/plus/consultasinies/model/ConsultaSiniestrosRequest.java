package mx.com.gnp.plus.consultasinies.model;

import java.io.Serializable;

public class ConsultaSiniestrosRequest implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String cdnumpol;
	public String cdtipusu;
	public String insaneam;
	public int feocusin;





	public ConsultaSiniestrosRequest()
	{

		cdnumpol = new String();

		cdtipusu = new String();

		insaneam = new String();


	}


	public String getCdnumpol() {
		return cdnumpol;
	}


	public void setCdnumpol(String cdnumpol) {
		this.cdnumpol = cdnumpol;
	}


	public String getCdtipusu() {
		return cdtipusu;
	}


	public void setCdtipusu(String cdtipusu) {
		this.cdtipusu = cdtipusu;
	}


	public String getInsaneam() {
		return insaneam;
	}


	public void setInsaneam(String insaneam) {
		this.insaneam = insaneam;
	}


	public int getFeocusin() {
		return feocusin;
	}


	public void setFeocusin(int feocusin) {
		this.feocusin = feocusin;
	}



}
