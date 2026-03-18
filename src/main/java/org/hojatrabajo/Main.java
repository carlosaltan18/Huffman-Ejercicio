package org.hojatrabajo;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        String tablaFrecuencias = " ,679|E,280|O,253|T,241|I,216|A,209|N,188|H,143|\\n,134|L,125|M,121|D,114|.,93|U,90|R,86|W,71|S,60|Y,57|K,53|G,42|,,39|!,38|-,24|C,21|?,16|B,14|X,14|F,8|e,4|s,4|t,3|h,2|\",2|),2|r,2|o,2|(,2|u,1|c,1|y,1|b,1|a,1|n,1|d,1|i,1|m,1";
        
        System.out.println("=== TABLA DE FRECUENCIAS ===");
        System.out.println(tablaFrecuencias);
        System.out.println();
        
        PriorityQueue<HuffmanNode> cola = HuffmanCoding.tablaStringToCola(tablaFrecuencias);
        
        System.out.println("=== NODOS EN LA COLA DE PRIORIDAD ===");
        while (!cola.isEmpty()) {
            HuffmanNode nodo = cola.poll();
            if (nodo.c == '\n') {
                System.out.println("'\\n': " + nodo.frecuencia);
            } else if (nodo.c == ' ') {
                System.out.println("' ': " + nodo.frecuencia);
            } else {
                System.out.println("'" + nodo.c + "': " + nodo.frecuencia);
            }
        }
    }
}