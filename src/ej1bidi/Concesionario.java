/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej1bidi;

import java.util.Arrays;
import utilidades.Alfanumericos;
import utilidades.Numero;

/**
 *
 * @author admin
 */
public class Concesionario {

    Modelo[] modelos;
    final String[] TIPOS = {"Turismo", "Deportivo","TodoTerreno"};
    final static String[] MESES = {"Enero", "Feb", "Mar", "abr", "may", "Jun"};
    final float[] IMPORTES = {15000F, 30000f, 50000f, 100000f, Float.MAX_VALUE};
    final float[][] PORCENTAJES = {
        {0.15f, 0.1f, 0.1f, 0.18f, 0.06f},
        {0.18f, 0.12f, 0.14f, 0.2f, 0.08f},
        {0.21f, 0.14f, 0.16f, 0.22f, 0.1f}
    };
  
    public Concesionario() {
        modelos = new Modelo[15];
    }

    public Concesionario(int numero) {
        modelos = new Modelo[numero];
    }

    public void pedirDatos() {
        String deno;
        int posTipo;

        for (int m = 0; m < modelos.length; m++) {
            deno = Alfanumericos.pedirAlfanumerico("Denominacion");
            posTipo = pedirTipo();
            modelos[m] = new Modelo(deno, posTipo);
        }
    }

    private int pedirTipo() {
        String tipo;
        int posTipo;

        tipo = Alfanumericos.pedirAlfanumerico("Tipo");
        posTipo = buscar(tipo);
        while (posTipo == -1) {
            tipo = Alfanumericos.pedirAlfanumerico("Tipo");
            posTipo = buscar(tipo);
        }

        return posTipo;
    }

    private int buscar(String tipo) {
        int posTipo = 0;
        boolean encontrado = false;
        while (!encontrado && posTipo < TIPOS.length) {
            if (TIPOS[posTipo].equalsIgnoreCase(tipo)) {
                encontrado = true;
            } else {
                posTipo++;
            }
        }
        if (!encontrado) {
            posTipo = -1;
        }
        return posTipo;
    }

    public void pedirVentas() {
        float importe;
        for (int mes = 0; mes < 6; mes++) {
            System.out.println("Ventas del mes " + MESES[mes]);

            for (int mo = 0; mo < modelos.length; mo++) {
                System.out.println("Del modelo: " + modelos[mo].getDenominacion());
                importe = Numero.pedirNumeroReal("ventas", 0);
                modelos[mo].setVentadeUnMes(mes, importe);
            }
        }
    }

    public void informe() {
        float primer, segundo, total;
        int columna;
        float beneficio;
        System.out.println("INFORME VENTAS");
        System.out.println("Modelo de coche \t Importe ventas 1er trimestre\t"
                + "Importe ventas 2º trimestre \t Beneficio");
        for (int mo = 0; mo < modelos.length; mo++) {
            primer = modelos[mo].sumar(0, 3);
            segundo = modelos[mo].sumar(3, 6);
            total = primer + segundo;
            columna = buscarImporte(total);
            beneficio = total *PORCENTAJES[modelos[mo].getTipo()][columna];
            System.out.println(modelos[mo].getDenominacion()+"\t"+
                    primer+"\t"+segundo+"\t"+beneficio);
            
        }
    }

    private int buscarImporte(float importe) {
        int pos = 0;
        boolean encontrado = false;
        while (!encontrado && pos < IMPORTES.length) {
            if (IMPORTES[pos]> importe) {
                encontrado = true;
            } else {
                pos++;
            }
        }
        return pos;
    }
}
