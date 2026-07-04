package ecg;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class Main {

	public static void main(String[] args) throws IOException {

        //Leemos los directorios de entrada/salida, los creamos en caso contrario
    	File directorioEntrada;
    	File directorioSalida;
    	if (args.length == 2) {
    		String dirEnt = args[0];
            directorioEntrada = new File(dirEnt);
            if (!directorioEntrada.exists() || !directorioEntrada.isDirectory()) {
                System.out.println("La ruta de entrada especificada no es un directorio válido.");
                return;
            }
            
            String dirSal = args[1];
            directorioSalida = new File(dirSal);
            if (!directorioSalida.exists() || !directorioSalida.isDirectory()) {
                directorioSalida.mkdirs();
            }
    	} else if (args.length == 1) {
    		String dirEnt = args[0];
            directorioEntrada = new File(dirEnt);
            if (!directorioEntrada.exists() || !directorioEntrada.isDirectory()) {
                System.out.println("La ruta de entrada especificada no es un directorio válido.");
                return;
            }
            
            directorioSalida = new File("src/main/resources/salidas");
            directorioSalida.mkdirs();
    	} else {
    		directorioEntrada = new File("src/main/resources/ficheros");
    		
    		directorioSalida = new File("src/main/resources/salidas");
            directorioSalida.mkdirs();
    	}
    	
    	//Leemos los archivos del directorio de entrada
        File[] archivos = directorioEntrada.listFiles();
        if (archivos == null || archivos.length == 0) {
            System.out.println("El directorio está vacío o no se pudieron leer sus contenidos.");
            return;
        }

        //Creamos el fichero de salida global
        File salidaTotal = new File(directorioSalida, "todo.salida.txt");
        salidaTotal.createNewFile();

        //Tratamos uno a uno los ecg del fichero de entrada
        for (File archivo : archivos) {

            try (BufferedWriter writerTotal = new BufferedWriter(new FileWriter(salidaTotal, true))) {
                writerTotal.newLine();
                writerTotal.write("Evaluando el fichero: " + archivo.getName());
                writerTotal.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("ksession-rules-ecg");

            InputStream is = new FileInputStream(archivo);
            if (is == null) {
                System.err.println("Fichero no encontrado.");
                return;
            }

            LecturaFichero lector = new LecturaFichero();
            List<Onda> ondas = lector.leerFichero(is, kSession);

            for (Onda o : ondas) {
                kSession.insert(o);
            }

            kSession.getAgenda().getAgendaGroup("crearDatos").setFocus();
            kSession.fireAllRules();
            kSession.getAgenda().getAgendaGroup("detectarEnfermedades").setFocus();
            kSession.fireAllRules();

            String fileNameWithOutExtParts[] = archivo.getName().split("\\.");  //ningún fichero de entrada contiene puntos
            File diagnosticoFich = new File(directorioSalida, fileNameWithOutExtParts[0] + ".salida.txt");
            diagnosticoFich.createNewFile();
            kSession.setGlobal("editorFichero", new EditorFicheros(diagnosticoFich));
            kSession.setGlobal("editorFicheroTotal", new EditorFicheros(salidaTotal));

            kSession.getAgenda().getAgendaGroup("crearReport").setFocus();
            kSession.fireAllRules();

        }

        //Imprimimos el fichero global con todos los diagnósticos
        InputStream is = new FileInputStream(salidaTotal);
        Scanner sc = new Scanner(is);
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
        sc.close();
    }

}
