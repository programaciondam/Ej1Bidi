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
    String[] tipos = {"Turismo", "TodoTerreno", "Deportivo"};

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
        while (!encontrado && posTipo < tipos.length) {
            if (tipos[posTipo].equalsIgnoreCase(tipo)) {
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
    public void pedirVentas(){
        float importe;
        for( int mes=0;mes <6;mes++)
            for(int mo=0; mo<modelos.length;mo++)
            {
                importe=Numero.pedirNumeroReal("ventas", 0);
                modelos[mo].setVentadeUnMes(mes, importe);
            }
    }
}
