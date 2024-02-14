/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej1bidi;

/**
 *
 * @author admin
 */
public class Modelo {
    private String denominacion;
    private int tipo;
    private float [] ventas;

    public Modelo(String denominacion, int tipo) {
        this.denominacion = denominacion;
        this.tipo = tipo;
        ventas=new float[6];
    }

    public String getDenominacion() {
        return denominacion;
    }

       public float[] getVentas() {
        return ventas;
    }
   
    public int getTipo() {
        return tipo;
    }
     public void modificarVentadeUnMes(int mes,float importe){
        ventas[mes]=importe;
    }

    
}
