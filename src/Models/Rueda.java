/**
 * 
 */
package Models;


public class Rueda {
	
	protected String marca;
	protected double diamDel;
	protected double diamTra;
	
	/**
	 * @param marcaDel
	 * @param diamDel
	 * @param marcaTra
	 * @param diamTra
	 */
	public Rueda(String marca, double diamDel, double diamTra) {
		this.marca = marca;
		this.diamDel = diamDel;
		this.diamTra = diamTra;
	}
	public String getMarcaDel() {
		return marca;
	}
	public void setMarcaDel(String marca) {
		this.marca = marca;
	}
	public double getDiamDel() {
		return diamDel;
	}
	public void setDiamDel(double diamDel) {
		this.diamDel = diamDel;
	}
	
	public double getDiamTra() {
		return diamTra;
	}
	public void setDiamTra(double diamTra) {
		this.diamTra = diamTra;
	}	
}
