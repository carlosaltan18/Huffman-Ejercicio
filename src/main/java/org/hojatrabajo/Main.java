package org.hojatrabajo;


import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Reader rd = new Reader();
        FrequencyGenerator fg = new FrequencyGenerator();
        String text = rd.readFile("texto.txt");

        TreeHuffman huffman = new TreeHuffman();
        Map<Character, Integer> frecuencias  = fg.getMap(text);
        huffman.construirArbol(frecuencias);
        huffman.generarCodigos();
        huffman.imprimirTablaCodigos();

        System.out.println("Comprimir");
        String bitsCodificados = huffman.comprimir(text);
        System.out.println("Primeros 64 bits codificados:");
        System.out.println("   " + bitsCodificados.substring(0, Math.min(64, bitsCodificados.length())) + "...");

        System.out.println("Descomprimir");
        String textoRecuperado = huffman.descomprimir(bitsCodificados);
        boolean esIdentico = text.equals(textoRecuperado);
        System.out.println("\n" + (esIdentico
                ? "VERIFICACIÓN EXITOSA: El texto descomprimido es idéntico al original."
                : "ERROR: El texto descomprimido NO coincide con el original."));


    }
}
