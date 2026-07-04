package ecg;

import java.io.InputStream;
import java.util.Scanner;

import org.kie.api.runtime.KieSession;

import java.util.List;
import java.util.ArrayList;

public class LecturaFichero {

	public List<Onda> leerFichero(InputStream is, KieSession kSession) {
        List<Onda> ondas = new ArrayList<>();
        Scanner sc = null;
      
        try {
            sc = new Scanner(is);
            while (sc.hasNextLine()) {
            	
            	Ciclo ciclo = new Ciclo(0);
            	kSession.insert(ciclo);

            	while (sc.hasNextLine()) {
            		String linea = sc.nextLine().trim();
            		
            		if (linea.startsWith("#") || linea.isEmpty()) {
            			continue;
            		}
                
            		char tipo = linea.charAt(0); 
            		String datos = linea.substring(2, linea.length() - 1); 
            		String[] partes = datos.split(",");
            		
            		int inicio = Integer.parseInt(partes[0]);
            		int fin = Integer.parseInt(partes[1]);
            		double pico = Double.parseDouble(partes[2]);

            		Onda onda = null;
            		switch (tipo) {
		            	case 'P': 
		            		onda = new OndaP(ciclo, inicio, fin, pico); 
		            		break;
		            	case 'Q':
		            		onda = new OndaQ (ciclo, inicio, fin, pico); 
		            		break;
		            	case 'R' :
		            		onda = new OndaR (ciclo, inicio, fin, pico); 
		            		break;
		            	case 'S':
		            		onda = new OndaS(ciclo, inicio, fin, pico); 
		            		break;
		            	case 'T':
		            		onda = new OndaT(ciclo, inicio, fin, pico); 
		            		break;
		            	default:
            		};
            		
            		if (onda != null) {
            			ondas.add(onda);
            		}
            		
            	
            		}
            }
           
        
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sc != null) {
                sc.close();
            }
        
        }
    
        return ondas;
	}
		
}
