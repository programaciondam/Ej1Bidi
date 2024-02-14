/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej1bidi;

import java.util.Arrays;
import utilidades.Alfanumericos;

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
        do {
            tipo = Alfanumericos.pedirAlfanumerico("Tipo");
            posTipo = buscar(tipo);
        } while (posTipo == -1);

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
}
