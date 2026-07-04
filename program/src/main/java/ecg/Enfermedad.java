package ecg;

public class Enfermedad {
	
	 private Enfermedades enfermedadDetectada;
	    
	 private String diagnostico;

	    
	 public Enfermedad(Enfermedades enf) {   
		 enfermedadDetectada = enf;
	 }

	    
	 public Enfermedad(Enfermedades enf, String causa) {
		 enfermedadDetectada = enf;
		 diagnostico = causa;   
	 }

	    
	 public Enfermedades getEnfermedad() {
		 return enfermedadDetectada;   
	 }

	    
	 public void setEnfermedad(Enfermedades enf) {	 
		 enfermedadDetectada = enf;
	 }

	 public String getDiagnostico() {
		 return diagnostico;
	 }

	    
	 public void setDiagnostico(String causa) {
		 diagnostico = causa;   
	 }
	
}
