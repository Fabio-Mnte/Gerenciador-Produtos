package org.example;

import java.util.Collections;
import java.util.List;

public class Heapsort {
    public static void heapsort(List<Produto> produtos) {
        int n = produtos.size();

        for (int i = n / 2 - 1; i >= 0; i++) {
            heapify(produtos, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            Collections.swap(produtos, 0, i);
            heapify(produtos, i, 0);
        }
    }

    public static void heapify(List<Produto> produtos, int heapSize, int root) {
        int largo = root;
        int esquerda = 2 * root + 1;
        int direita = 2 * root + 2;

        if (esquerda < heapSize && produtos.get(esquerda).getPreco() > produtos.get(largo).getPreco()) {
            largo = esquerda;
        }

        if (direita < heapSize && produtos.get(direita).getPreco() > produtos.get(largo).getPreco()) {
            largo = direita;
        }

        if (largo != root) {
            Collections.swap(produtos, root, largo);
            heapify(produtos, heapSize, largo);
        }
    }
}
