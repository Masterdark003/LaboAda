/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Multiplicacion;
import static exponenciar.exponenciar.potencia;
/**
 *
 * @author Nagamine
 */
public class mult {

    public static int multiplica2(int x, int y) {
        int n = max(x, y);
        if (n <= 1) {
            return x * y;
        } else {
//Obtener xi, xd, yi, yd (Dividir)
            int s = n / 2;
            int xi = x / potencia(10,s);
            int xd = x % potencia(10,s);
            int yi = x / potencia(10,s);
            int yd = x % potencia(10,s);
            int r = multiplica2(xi + xd, yi + yd);
            int p = multiplica2(xi, yi);
            int q = multiplica2(xi, yd);
//Combinar
            return p * potencia(10, 2*s)+ (r - p - q) * potencia(10,s) + q;
        }
    }

    public static int max(int x, int y) {
        int xi = 0, yi = 0;
        while (x > 10) {
            x = x % 10;
            xi++;
        }
        while (y > 10) {
            y = y % 10;
            yi++;
        }
        if (xi < yi) {
            return yi;
        } else {
            return xi;
        }
    }

}
