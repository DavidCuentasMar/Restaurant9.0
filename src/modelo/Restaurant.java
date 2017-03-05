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
    private Menu menu;
    public Restaurant() {
        bodega = new Bodega();
        menu = new Menu();
    }
    public void InitialConfig(String type, String name, int price, String[] ingredientes){
        if (type.equals("PLT")) {
            Plato p = new Plato(name,price);
            p.agregarIngredientes(ingredientes);
            menu.agregarPlato(p);
            bodega.agregarIngrediente(ingredientes);
        }
        if (type.equals("B")) {
            Bebida b = new Bebida(name,price);
            bodega.agregarBebida(b);
            menu.agregarBebida(b);
        }
        if (type.equals("P")) {
            Postre p = new Postre(name,price);
            menu.agregarPostre(p);
            bodega.agregarPostre(p);
        }
        
    
    }
    
    public static void main(String[] args) {
        Configuracion c = new Configuracion();
        c.setVisible(true);
    }
    
}
