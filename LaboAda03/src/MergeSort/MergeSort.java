/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MergeSort;

/**
 *
 * @author LaboratorioFISI
 */
public class MergeSort {
    static int contador = 0;
    public static void mergeSort(int arreglo[], int inicio, int fin) {
        System.out.println("Merge " + inicio + " " + fin);
        int mitad;
        if (inicio < fin) {
            mitad = inicio + (fin - inicio) / 2;
            mergeSort(arreglo, inicio, mitad);
            mergeSort(arreglo, mitad + 1, fin);
            fusionar(arreglo, inicio, mitad, fin);
        }
    }

    public static void fusionar(int arreglo[], int inicio, int mitad, int fin) {
        System.out.println("Fusion " + inicio + " " + mitad + " " + fin);
        int b[] = new int[arreglo.length];
        int i = inicio;
        int j = mitad + 1;
        int k = inicio;
        while (i <= mitad && j <= fin) {
            contador++;
            System.out.println(i + "," + j + "," + k);
            if (arreglo[i] < arreglo[j]) {
                b[k] = arreglo[i];
                i++;
                System.out.println("i:" + i);
            } else {
                b[k] = arreglo[j];
                j++;
                System.out.println("j:" + j);
            }
            System.out.println("B[" + k + "] " + b[k]);
            k++;
        }
        if (i > mitad) { //se acabó arreglo izquierdo
            for (int q = j; q <= fin; q++) {
                contador++;
                System.out.println("for i: " + q + " " + k +" " + fin + "," + j); 
                b[k] = arreglo[q];
                k++;
            }
        } else { //se acabó arreglo derecho
            for (int q = i; q <= mitad; q++) {
                contador++;
                System.out.println("for j: " + q + " " + k +" " + fin + "," + i); 
                b[k] = arreglo[q];
                k++;
            }

        }
        for (int e = inicio; e <= fin; e++) {
            contador++;
            arreglo[e] = b[e];
        }
    }
}
