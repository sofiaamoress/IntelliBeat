package ecg;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EditorFicheros {

    private File ruta;

    public EditorFicheros(File ruta) {
        this.ruta = ruta;
    }

    public void anadirDiagnostico(String texto) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.ruta, true));
            writer.write(texto);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

}
