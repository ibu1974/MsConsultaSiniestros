package mx.com.gnp.plus.consultasinies.model;

import java.io.Serializable;

public class ConsultaSiniestrosRequest implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cdnumpol;
	private String cdtipusu;
	private String insaneam;
	private int feocusin;



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
