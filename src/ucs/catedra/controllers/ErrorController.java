package ucs.catedra.controllers;

public class ErrorController {


	Boolean hayError;
	String mensajeRespueta;
	int    codError;


	public ErrorController() {
		super();
		this.hayError = false;
		this.mensajeRespueta = "";
		this.codError = 0;
	}	

	public ErrorController(Boolean hayError, String descripError, int codError) {
		super();
		this.hayError = hayError;
		this.mensajeRespueta = descripError;
		this.codError = codError;
	}	
	
	
	public Boolean getHayError() {
		return hayError;
	}
	public void setHayError(Boolean hayError) {
		this.hayError = hayError;
	}
	public String getMensajeRespuesta() {
		return mensajeRespueta;
	}
	public void setMensajeRespuesta(String mensajeRespuesta) {
		this.mensajeRespueta = mensajeRespuesta;
	}
	public int getCodError() {
		return codError;
	}
	public void setCodError(int codError) {
		this.codError = codError;
	}

	
	
	
	
}
