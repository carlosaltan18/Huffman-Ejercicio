package org.hojatrabajo;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TreeHuffman {
    private HuffmanNode root;
    private Map<Character, String> tablaDeCodigos;

    public TreeHuffman() {
        this.tablaDeCodigos = new HashMap<Character, String>();

    }
    public void construirArbol(Map<Character, Integer> frecuencia) {
        PriorityQueue<HuffmanNode> cola = new PriorityQueue<HuffmanNode>();
        for (Map.Entry<Character, Integer> entry : frecuencia.entrySet()) {
            cola.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }
        if (cola.size() == 1) {
            HuffmanNode unico = cola.poll();
            root = new HuffmanNode(unico.frecuencia, unico, null);
        }
        while (cola.size() > 1) {
            HuffmanNode menor1 = cola.poll();
            HuffmanNode menor2 = cola.poll();
            HuffmanNode padre = new HuffmanNode(
                    menor1.frecuencia + menor2.frecuencia,
                    menor1,
                    menor2
            );
            cola.add(padre);
        }

        root = cola.poll();
    }

    public Map<Character, String> getTablaCodigos() {
        return tablaDeCodigos;
    }

    public HuffmanNode getRaiz() {
        return root;
    }

    public void generarCodigos() {
        tablaDeCodigos.clear();
        generarCodigosRecursivo(root, "");
    }

    private void generarCodigosRecursivo(HuffmanNode nodo, String codigoActual) {
        if (nodo == null) return;

        if (nodo.esHoja()) {
            tablaDeCodigos.put(nodo.c, codigoActual.isEmpty() ? "0" : codigoActual);
            return;
        }

        generarCodigosRecursivo(nodo.left,  codigoActual + "0");
        generarCodigosRecursivo(nodo.right,     codigoActual + "1");
    }

    public String comprimir(String texto) {
        StringBuilder bits = new StringBuilder();
        for (char c : texto.toCharArray()) {
            bits.append(tablaDeCodigos.get(c));
        }
        return bits.toString();
    }

    public String descomprimir(String bits) {
        StringBuilder resultado = new StringBuilder();
        HuffmanNode actual = root;

        for (char bit : bits.toCharArray()) {
            if (bit == '0') {
                actual = actual.left;
            } else {
                actual = actual.right;
            }
            if (actual == null) {
                actual = root.left != null ? root.left : root.right;
            }

            if (actual.esHoja()) {
                resultado.append(actual.c);
                actual = root;
            }
        }

        return resultado.toString();
    }


    public void imprimirTablaCodigos() {
        System.out.println("\n╔══════════════════════════════╗");
        System.out.println("║     TABLA DE CÓDIGOS         ║");
        System.out.println("╠═══════════╦══════════════════╣");
        System.out.println("║ Carácter  ║ Código Huffman   ║");
        System.out.println("╠═══════════╬══════════════════╣");

        tablaDeCodigos.entrySet().stream()
                .sorted(Map.Entry.<Character, String>comparingByValue(
                        (a, b) -> Integer.compare(a.length(), b.length()))
                )
                .forEach(e -> {
                    String displayChar = e.getKey() == ' '  ? "ESPACIO"
                            : e.getKey() == '\n' ? "NEWLINE"
                            : e.getKey() == '\t' ? "TAB"
                            : String.valueOf(e.getKey());
                    System.out.printf("║ %-9s ║ %-16s ║%n", displayChar, e.getValue());
                });

        System.out.println("╚═══════════╩══════════════════╝");
    }


}
