import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

    // Devuelve el contenido completo como String (para Huffman)
    public static String readFile(String path) {
        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            int c;
            while ((c = br.read()) != -1) {
                sb.append((char) c);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + path);
        } catch (IOException e) {
            System.out.println("Error leyendo el archivo: " + e.getMessage());
        }

        return sb.toString();
    }
}