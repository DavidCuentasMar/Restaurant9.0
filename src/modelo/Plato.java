/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author pollo4053
 */
public class Plato {
   private String name;
   private int price;
   ArrayList ingredientes;

    public Plato(String name, int price) {
        this.name = name;
        this.price = price;
        ingredientes = new ArrayList();
    }
    public void agregarIngredientes(String[] ingredientesV){
        for (int i = 0; i < ingredientesV.length; i++) {
            this.ingredientes.add(ingredientesV[i]);
        }
    }

    
}
