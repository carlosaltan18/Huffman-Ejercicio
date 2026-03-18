package org.hojatrabajo;

public class HuffmanNode implements Comparable<HuffmanNode> {
    char c;
    HuffmanNode left;
    HuffmanNode right;
    int frecuencia;

    public HuffmanNode(char c, HuffmanNode left, HuffmanNode right) {
        this.c = c;
        this.left = null;
        this.right = null;
        this.frecuencia = frecuencia;
    }

    public HuffmanNode(int frecuencia, HuffmanNode izq, HuffmanNode der) {
        this.c = '\0';
        this.frecuencia = frecuencia;
        this.left = izq;
        this.right = der;
    }

    public boolean esHoja() {
        return left == null && right == null;
    }

    @Override
    public int compareTo(HuffmanNode otro) {
        return this.frecuencia - otro.frecuencia;
    }
}
