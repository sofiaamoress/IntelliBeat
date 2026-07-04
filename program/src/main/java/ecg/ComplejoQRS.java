package ecg;

public class ComplejoQRS extends Complejo{

	private OndaQ refOndaQ;
	private OndaR refOndaR;
	private OndaS refOndaS;
	
	public ComplejoQRS(Ciclo refCiclo, int inicio, int fin, OndaQ refOndaQ, OndaR refOndaR, OndaS refOndaS) {
		super(refCiclo, inicio, fin);
		this.refOndaQ = refOndaQ;
		this.refOndaR = refOndaR;
		this.refOndaS = refOndaS;
	}

	public OndaQ getRefOndaQ() {
		return refOndaQ;
	}

	public void setRefOndaQ(OndaQ refOndaQ) {
		this.refOndaQ = refOndaQ;
	}

	public OndaR getRefOndaR() {
		return refOndaR;
	}

	public void setRefOndaR(OndaR refOndaR) {
		this.refOndaR = refOndaR;
	}

	public OndaS getRefOndaS() {
		return refOndaS;
	}

	public void setRefOndaS(OndaS refOndaS) {
		this.refOndaS = refOndaS;
	}
	
}
