package org.hojatrabajo;

import java.util.*;

public class HuffmanCoding {
    
    public static PriorityQueue<HuffmanNode> tablaStringToCola(String tablaFrecuencias) {
        PriorityQueue<HuffmanNode> cola = new PriorityQueue<>();
        
        String[] pares = tablaFrecuencias.split("\\|");
        
        for (String par : pares) {
            if (par.trim().isEmpty()) continue;
            
            String[] partes = par.split(",");
            if (partes.length != 2) continue;
            
            char caracter;
            int frecuencia;
            
            if (partes[0].length() == 1) {
                caracter = partes[0].charAt(0);
            } else if (partes[0].equals("\\n")) {
                caracter = '\n';
            } else if (partes[0].equals(" ")) {
                caracter = ' ';
            } else {
                continue;
            }
            
            try {
                frecuencia = Integer.parseInt(partes[1]);
            } catch (NumberFormatException e) {
                continue;
            }
            
            HuffmanNode nodo = new HuffmanNode(caracter, null, null);
            nodo.frecuencia = frecuencia;
            cola.add(nodo);
        }
        
        return cola;
    }
}
