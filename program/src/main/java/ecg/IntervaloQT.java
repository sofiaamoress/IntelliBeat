package ecg;

public class IntervaloQT extends Intervalo{

	private OndaQ refOndaQ;
	private OndaT refOndaT;
	
	public IntervaloQT(Ciclo refCiclo, int inicio, int fin, OndaQ refOndaQ, OndaT refOndaT) {
		super(refCiclo, inicio, fin);
		this.refOndaQ = refOndaQ;
		this.refOndaT = refOndaT;
	}

	public OndaQ getRefOndaQ() {
		return refOndaQ;
	}

	public void setRefOndaQ(OndaQ refOndaQ) {
		this.refOndaQ = refOndaQ;
	}

	public OndaT getRefOndaT() {
		return refOndaT;
	}

	public void setRefOndaT(OndaT refOndaT) {
		this.refOndaT = refOndaT;
	}
	
}