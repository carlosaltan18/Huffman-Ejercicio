package org.hojatrabajo;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequencyGenerator {
    Reader r = new Reader();
    String texto = r.readFile("texto.txt");

    public static Map<Character, Integer> getMap(String texto) {
        Map<Character, Integer> mapaFrecuencias = new HashMap<>();

        if (texto == null || texto.isEmpty()) {
            return mapaFrecuencias;
        }

        for (char c : texto.toCharArray()) {
            mapaFrecuencias.put(c, mapaFrecuencias.getOrDefault(c, 0) + 1);
        }

        return mapaFrecuencias;
    }

    public static String getString(String texto) {
        Map<Character, Integer> mapaFrecuencias = getMap(texto);

        if (mapaFrecuencias.isEmpty()) {
            return "";
        }

        return mapaFrecuencias.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(entrada -> String.valueOf(entrada.getKey()) + entrada.getValue())
                .collect(Collectors.joining("|"));
    }
}