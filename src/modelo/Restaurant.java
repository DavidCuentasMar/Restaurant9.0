/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.File;
import vista.Configuracion;
import vista.ConfiguracionPlatos;

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
            Plato p = new Plato(name,price);
            p.agregarIngredientes(ingredientes);
            menu.agregarPlato(p);
            bodega.agregarIngrediente(ingredientes);                    
    }
    public void InitialConfig(String type, String name, int price){
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
        if (new File("archivos/productos.txt").exists()){
            ConfiguracionPlatos cp = new ConfiguracionPlatos();
            cp.setVisible(true);
        }else{
            Configuracion c = new Configuracion();
            c.setVisible(true);
        }
        
        
    }
    
}
