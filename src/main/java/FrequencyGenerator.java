import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequencyGenerator {

    public static void main(String[] args) {
        String texto = "casa\n casa ";

        String resultado = getFrequencyTable(texto);

        System.out.println(resultado);
    }

    public static String getFrequencyTable(String texto) {
        if (texto == null || texto.isEmpty()) {
            return "";
        }

        Map<Character, Integer> mapaFrecuencias = new HashMap<>();
        for (char c : texto.toCharArray()) {
            mapaFrecuencias.put(c, mapaFrecuencias.getOrDefault(c, 0) + 1);
        }

        return mapaFrecuencias.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(entrada -> String.valueOf(entrada.getKey()) + entrada.getValue())
                .collect(Collectors.joining("|"));
    }
}