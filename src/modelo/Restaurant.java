/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import vista.Configuracion;

/**
 *
 * @author Administrador
 */
public class Restaurant {

    private Bodega bodega;

    public Restaurant() {
        bodega = new Bodega();
    }
    public void InitialConfig(String type, String name, int amount, int price){
    // Llenar la bodega de productos //
    //se te olvide los arraylist para que se pueda testiar si sirve
        if (type.equals("B")) {
            bodega.agregarBebida(name, amount, price);         
        }
        if (type.equals("P")) {
            bodega.agregarPostre(name, amount, price);
        }
        if (type.equals("I")) {
            bodega.agregarIngrediente(name, amount, price);
        }
    }
    
    public static void main(String[] args) {
        Configuracion c = new Configuracion();
        c.setVisible(true);
    }
    
}
