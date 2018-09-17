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
public class exponenciar {
    public static double potencia(double base, int exp) {
        double result;
        if (exp <= 1) {
            return base;
        } else if (exp % 2 == 1) {
               return base*potencia(base,exp-1);                      
        } else {
            result =base*base;
            System.out.println(result);
            return potencia(result, exp / 2);
        }
    }
}
