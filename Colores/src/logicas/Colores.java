package logicas;

public class Colores {
	
	String nombreColor;
	
	int r,g,b;

	public Colores(String nombreColor, int r, int g, int b) {
		super();
		this.nombreColor = nombreColor;
		this.r = r;
		this.g = g;
		this.b = b;
	}

	public String getNombreColor() {
		return nombreColor;
	}

	public void setNombreColor(String nombreColor) {
		this.nombreColor = nombreColor;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}
	
	
	
}
