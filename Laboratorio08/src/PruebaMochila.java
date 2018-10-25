/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nagamine
 */
public class PruebaMochila {

    public static void main(String[] args) {
        int peso[] = {1, 2, 5, 6, 7}; //Pesos de los objetos
        int valor[] = {1, 6, 18, 22, 28}; //Valores de los objetos

        int capacidad = 11; // Capacidad de la mochila
        int valorMaximo; // Máximo valor de objetos elegidos
        int n = peso.length; // Número de objetos

        // Crea el objeto mochila
        Mochila miMochila = new Mochila(peso, valor, capacidad);

        //Calcula el valor máximo total de los objetos elegidos
        valorMaximo = miMochila.elegirObjetos();

        System.out.printf("Valor máximo total = %d\n\n", valorMaximo);

        System.out.printf("Tabla de valores máximos\n");
        System.out.printf("------------------------\n");
        System.out.printf("\t |");
        for (int j = 1; j <= capacidad; j++) {
            System.out.printf("\t%d", j);
        }
        System.out.println();
        for (int j = 1; j <= capacidad; j++) {
            System.out.print("-----");
        }
        System.out.println();

        for (int i = 1; i <= n; i++) {
            System.out.printf("\t%d|", i);
            for (int j = 1; j <= capacidad; j++) {
                System.out.printf("\t%d", miMochila.getV(i, j));
            }
            System.out.println();
        }

        // Hallar la secuencia de objetos elegidos
        miMochila.Componer();

        System.out.printf("\nObjetos elegidos\n");
        System.out.printf("----------------\n\n");
        for (int i = 1; i <= n; i++) {
            if (miMochila.getElegido(i) == 1) {
                System.out.printf("Objeto %d: \tPeso = %d,Valor = %d\n\n", i,
                        miMochila.getPeso(i),
                        miMochila.getValor(i));
            }
        }
    }
}
