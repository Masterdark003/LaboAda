/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exponenciar;

/**
 *
 * @author LaboratorioFISI
 */
public class exponenciar {
    public static int potencia(int base, int exp) {
        int result = base * base;
        if (exp <= 1) {
            return base;
        } else if (exp % 2 == 1) {
               return base*potencia(result,(exp-1)/2);                      
        } else {
            //System.out.println(result);
            return potencia(result, exp / 2);
        }
    }
     public static double potencia(double base, int exp) {
        double result = base * base;
        if (exp <= 1) {
            return base;
        } else if (exp % 2 == 1) {
               return base*potencia(result,(exp-1)/2);                      
        } else {
            //System.out.println(result);
            return potencia(result, exp / 2);
        }
    }
}
