package ecg;

public class SegmentoST extends Segmento{

	private OndaS refOndaS;
	private OndaT refOndaT;
	
	public SegmentoST(Ciclo refCiclo, int inicio, int fin, OndaS refOndaS, OndaT refOndaT) {
		super(refCiclo, inicio, fin);
		this.refOndaS = refOndaS;
		this.refOndaT = refOndaT;
	}

	public OndaS getRefOndaS() {
		return refOndaS;
	}

	public void setRefOndaS(OndaS refOndaS) {
		this.refOndaS = refOndaS;
	}

	public OndaT getRefOndaT() {
		return refOndaT;
	}

	public void setRefOndaT(OndaT refOndaT) {
		this.refOndaT = refOndaT;
	}
	
}
