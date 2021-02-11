/**
 * 
 */
package Models;

/**
 * @author User
 *
 */
public class Rueda {
	
	protected String marcaDel;
	protected double diamDel;
	protected String marcaTra;
	protected double diamTra;
	/**
	 * @param marcaDel
	 * @param diamDel
	 * @param marcaTra
	 * @param diamTra
	 */
	public Rueda(String marcaDel, double diamDel, String marcaTra, double diamTra) {
		this.marcaDel = marcaDel;
		this.diamDel = diamDel;
		this.marcaTra = marcaTra;
		this.diamTra = diamTra;
	}
	public String getMarcaDel() {
		return marcaDel;
	}
	public void setMarcaDel(String marcaDel) {
		this.marcaDel = marcaDel;
	}
	public double getDiamDel() {
		return diamDel;
	}
	public void setDiamDel(double diamDel) {
		this.diamDel = diamDel;
	}
	public String getMarcaTra() {
		return marcaTra;
	}
	public void setMarcaTra(String marcaTra) {
		this.marcaTra = marcaTra;
	}
	public double getDiamTra() {
		return diamTra;
	}
	public void setDiamTra(double diamTra) {
		this.diamTra = diamTra;
	}	
}
