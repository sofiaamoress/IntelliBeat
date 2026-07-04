package ecg;

public abstract class DatosCiclo {
	
	private Ciclo refCiclo;

	protected DatosCiclo(Ciclo refCiclo) {
		this.refCiclo = refCiclo;
	}

	public Ciclo getRefCiclo() {
		return refCiclo;
	}

	public void setRefCiclo(Ciclo refCiclo) {
		this.refCiclo = refCiclo;
	}
	
}
