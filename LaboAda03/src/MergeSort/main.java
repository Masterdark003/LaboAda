/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MergeSort;

/**
 *
 * @author Nagamine
 */
public class main {

    public static void main(String[] args) {
        int arr[] = {32, 4, 5, 1, 43323, 432, 21, 354, 52, 32, 55, 1, 5566};
        for (int x : arr) {
            System.out.print(x + ",");
        }
        MergeSort.mergeSort(arr, 0, arr.length - 1);
        for (int x : arr) {
            System.out.print(x + ",");
        }
        System.out.println(MergeSort.contador);

    }

}
