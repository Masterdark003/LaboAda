/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboAda03;

/**
 *
 * @author LaboratorioFISI
 */
public class MergeSort {

    public static void mergeSort(int arreglo[], int inicio, int fin) {
        int mitad;
        if (inicio < fin) {
            mitad = (inicio + fin) / 2;
            mergeSort(arreglo, inicio, mitad);
            mergeSort(arreglo, mitad + 1, fin);
            fusionar(arreglo,inicio,mitad,fin);
        }
    }

    public static void fusionar(int arreglo[], int inicio, int mitad, int fin) {
        int b[] = new int[arreglo.length];
        int i = inicio;
        int j = mitad + 1;
        int k = 0;
        while (i <= mitad && j <= fin) {
            System.out.println(i + "," + j + "," + k);
            if (arreglo[i] < arreglo[j]) {
                b[k] = arreglo[i];
                i++;
                System.out.println("i:" +i);
            } else {
                b[k] = arreglo[j];
                j++;
                System.out.println("j:" +j);
            }
            System.out.println("B:" + b[k]);
            k++;
        }
        for (int l = 0; l < fin; l++) {
            arreglo[l] = b[l];
        }
    }
}
