package ecg;

public abstract class Onda extends DatosCiclo{
	
	private int inicio;
	private int fin;
	private double pico;
	
	protected Onda(Ciclo refCiclo, int inicio, int fin, double pico) {
		super(refCiclo);
		this.inicio = inicio;
		this.fin = fin;
		this.pico = pico;
	}

	public int getInicio() {
		return inicio;
	}

	public void setInicio(int inicio) {
		this.inicio = inicio;
	}

	public int getFin() {
		return fin;
	}

	public void setFin(int fin) {
		this.fin = fin;
	}

	public double getPico() {
		return pico;
	}

	public void setPico(double pico) {
		this.pico = pico;
	}
	
}
