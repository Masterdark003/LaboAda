package trabajolabnº4;

import static java.lang.Math.sqrt;

public class Empresa {

    private Empleado empleados[];
    private final int NUMERO_EMPLEADOS = 20;
    private int intercambios = 0;
    private int comparaciones = 0;

    public Empresa() {
        int codigos[] = {204, 305, 105, 204, 415, 106, 500, 100, 540, 420,
            100, 215, 340, 180, 600, 312, 147, 165, 510, 601};
        String nombres[] = {"Juan", "Ana", "Rosa", "Carlos", "Raúl",
            "Pedro", "Rosario", "Martha", "Saúl", "Karen",
            "Rosa", "Francis", "Ricardo", "Luis", "Dámaris",
            "Diana", "Pablo", "Marcelo", "Carolina", "Ingrid"};
        float sueldos[] = {1500, 800, 2000, 550, 1200, 3500, 1800, 900, 750, 4000,
            750, 1500, 1200, 3500, 4000, 1800, 950, 1400, 600, 5500};
        empleados = new Empleado[NUMERO_EMPLEADOS];
        //Asigna los valores ya establecidos en el constructor.
        for (int i = 0; i < empleados.length; i++) {
            empleados[i] = new Empleado(codigos[i], nombres[i], sueldos[i]);
        }
    }

    public Empleado[] getEmpleados() {
        return empleados;
    }

    public int getCodigoDelEmpleado(int i) {
        return empleados[i].getCodigoDelEmpleado();
    }

    public void setCodigoDelEmpleado(int codigo, int i) {
        empleados[i].setCodigoDelEmpleado(codigo);
    }

    public String getNombreDelEmpleado(int i) {
        return empleados[i].getNombreDelEmpleado();
    }

    public void setNombreDelEmpleado(String nombre, int i) {
        empleados[i].setNombreDelEmpleado(nombre);
    }

    public float getSueldoDelEmpleado(int i) {
        return empleados[i].getSueldoDelEmpleado();
    }

    public void setSueldoDelEmpleado(float sueldo, int i) {
        empleados[i].setSueldoDelEmpleado(sueldo);
    }

    public int getNumeroDeEmpleados() {
        return NUMERO_EMPLEADOS;
    }

    public int getIntercambios() {
        return intercambios;
    }

    public int getComparaciones() {
        return comparaciones;
    }

    //Metodo de ordenamiento de la burbuja.
    public void OrdenBurbuja() {
        Empleado temp = new Empleado(0, "", 0);
        comparaciones = 0;
        intercambios = 0;
        for (int i = 1; i < empleados.length; i++) {
            for (int j = empleados.length - 1; j >= i; j--) {
                comparaciones++;
                if (empleados[j - 1].getCodigoDelEmpleado() > empleados[j].getCodigoDelEmpleado()) {
                    temp.setCodigoDelEmpleado(empleados[j - 1].getCodigoDelEmpleado());
                    empleados[j - 1].setCodigoDelEmpleado(empleados[j].getCodigoDelEmpleado());
                    empleados[j].setCodigoDelEmpleado(temp.getCodigoDelEmpleado());
                    temp.setNombreDelEmpleado(empleados[j - 1].getNombreDelEmpleado());
                    empleados[j - 1].setNombreDelEmpleado(empleados[j].getNombreDelEmpleado());
                    empleados[j].setNombreDelEmpleado(temp.getNombreDelEmpleado());
                    temp.setSueldoDelEmpleado(empleados[j - 1].getSueldoDelEmpleado());
                    empleados[j - 1].setSueldoDelEmpleado(empleados[j].getSueldoDelEmpleado());
                    empleados[j].setSueldoDelEmpleado(temp.getSueldoDelEmpleado());
                    intercambios++;
                }
            }
        }
    }

    public void OrdenInsercionDirecta() {
        Empleado temp = new Empleado(0, "", 0);
        comparaciones = 0;
        intercambios = 0;
        int k;
        for (int i = 1; i < empleados.length; i++) {
            comparaciones++;
            temp.setCodigoDelEmpleado(empleados[i].getCodigoDelEmpleado());
            temp.setNombreDelEmpleado(empleados[i].getNombreDelEmpleado());
            temp.setSueldoDelEmpleado(empleados[i].getSueldoDelEmpleado());
            k = i - 1;
            while (k >= 0 && temp.getCodigoDelEmpleado() < empleados[k].getCodigoDelEmpleado()) {
                empleados[k + 1].setCodigoDelEmpleado(empleados[k].getCodigoDelEmpleado());
                empleados[k + 1].setNombreDelEmpleado(empleados[k].getNombreDelEmpleado());
                empleados[k + 1].setSueldoDelEmpleado(empleados[k].getSueldoDelEmpleado());
                k--;
                intercambios++;
            }
            empleados[k + 1].setCodigoDelEmpleado(temp.getCodigoDelEmpleado());
            empleados[k + 1].setNombreDelEmpleado(temp.getNombreDelEmpleado());
            empleados[k + 1].setSueldoDelEmpleado(temp.getSueldoDelEmpleado());
        }
    }

    public void OrdenamientoSeleccionDirecta() {
        Empleado menor = new Empleado(0, "", 0);
        comparaciones = 0;
        intercambios = 0;
        for (int i = 0; i <= empleados.length - 2; i++) {
            menor = empleados[i];
            int k = i;
            for (int j = i + 1; j <= empleados.length - 1; j++) {
                comparaciones++;
                if (empleados[j].getCodigoDelEmpleado() < menor.getCodigoDelEmpleado()) {
                    menor = empleados[j];
                    k = j;
                }
            }
            intercambios++;
            empleados[k] = empleados[i];
            empleados[i] = menor;
        }

    }

    public int BusquedaSecuencialDesordenado(int codigo) {
        comparaciones = 0;
        boolean encontrado = false;
        int pos = -1;
        for (int i = 1; i < empleados.length && !encontrado; i++) {
            comparaciones++;
            if (empleados[i].getCodigoDelEmpleado() == codigo) {
                pos = i;
                encontrado = true;
            }
        }
        return pos;
    }

    public int BusquedaSecuencialOrdenado(int codigo) {
        
        OrdenamientoSeleccionDirecta();
        comparaciones = 0;
        boolean salir = false;
        int pos = -1;
        for (int i = 1; i < empleados.length && !salir; i++) {
            comparaciones++;
            if (empleados[i].getCodigoDelEmpleado() == codigo) {
                pos = i;
                salir = true;
            }
            if (codigo > empleados[i].getCodigoDelEmpleado()) {

                salir = true;
            }
        }
        return pos;
    }

    public int BusquedaBinaria(int dato) {
        OrdenamientoSeleccionDirecta();
        comparaciones = 0;
        int n = empleados.length;
        int centro, inf = 0, sup = n - 1;
        while (inf <= sup) {
            comparaciones++;
            centro = (sup + inf) / 2;
            if (empleados[centro].getCodigoDelEmpleado() == dato) {
                return centro;
            } else if (dato < empleados[centro].getCodigoDelEmpleado()) {
                sup = centro - 1;
            } else {
                inf = centro + 1;
            }
        }
        return -1;
    }

    public int BusquedaBloquesSecuencial(int codigo) {
        OrdenamientoSeleccionDirecta();
        comparaciones = 0;
        
        int pos = -1;
        int n = empleados.length;// Valor devuelto: pos = -1 No existe valor
        Double raiz = sqrt(n);
        int k = raiz.intValue();// Tamaño del bloque

        int inicio = 0; // Posición inicial del primer bloque
        int fin = k - 1; // Posición final del primer bloque
        int m;
        int j;
        int i = 1;
        if (n % k == 0) {
            m = n / k;
        } else {
            m = n / k + 1;
        }

        while (pos == -1 && i <= m) {
            if (codigo == empleados[fin].getCodigoDelEmpleado()) {
                comparaciones++;// Valor encontrado
                pos = fin;
            } else {
                if (codigo < empleados[fin].getCodigoDelEmpleado()) { //Búsqueda secuencial en el bloque
                    j = inicio;
                    while (j <= fin - 1 && pos == -1 && empleados[j].getCodigoDelEmpleado() <= codigo) {
                        comparaciones++;
                        if (codigo == empleados[j].getCodigoDelEmpleado()) {
                            pos = j;
                        }
                        j = j + 1;
                    }
                } //Búsqueda Secuencial usando bloques
                else { // Si valor > A [ fin ] incrementa k
                    comparaciones++;
                    fin = fin + k;
                    if (fin > n - 1) { //El último bloque es de otro tamaño
                        fin = n - 1;
                    }
                }
                i = i + 1;
                inicio = inicio + k;
            }
        }

        return pos;
    }

}
