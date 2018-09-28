
package trabajolabnº4;

public class Empleado{
    
    private int codigoDelEmpleado;
    private String nombreDelEmpleado;
    private float sueldoDelEmpleado;
    
 public Empleado(int codigo, String nombre, float sueldo) {
     codigoDelEmpleado = codigo;
    nombreDelEmpleado = nombre;
    sueldoDelEmpleado = sueldo;
 }
 
 public void setCodigoDelEmpleado(int codigo){
    codigoDelEmpleado = codigo;
 }
 
 public int getCodigoDelEmpleado(){
    return codigoDelEmpleado;
 }
 
 public void setNombreDelEmpleado(String nombre){
    nombreDelEmpleado = nombre;
 }

 public String getNombreDelEmpleado() {
     return nombreDelEmpleado;
 }

 public void setSueldoDelEmpleado(float sueldo) {
    sueldoDelEmpleado = sueldo;
 }
 
 public float getSueldoDelEmpleado(){
    return sueldoDelEmpleado;
 }
 public String toString(){
     return "codigo: " + codigoDelEmpleado + "\nNombre: " + nombreDelEmpleado + "\nsueldo: " + sueldoDelEmpleado;
 }
 
}
 
