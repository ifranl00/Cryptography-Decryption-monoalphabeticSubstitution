

public class Simbolo {
	String simbolo;
	int sustitucion;
	
	public Simbolo(String simbolo, int sustitucion) {
		this.simbolo = simbolo;
		this.sustitucion = sustitucion;
	}
	
	public String getSim() {
		return this.simbolo;
	}
	public int getSus() {
		return this.sustitucion;
	}
	
}
