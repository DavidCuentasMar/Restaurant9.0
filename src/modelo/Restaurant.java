/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.File;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vista.Configuracion;
import vista.ConfiguracionPlatos;
import vista.General;

/**
 *
 * @author Administrador
 */
public class Restaurant {
    Lista list;
    private Archivo archivo;
    public Restaurant() {
        list = new Lista();
        archivo = new Archivo();
    }
    public void CrearArchivoProductos(DefaultTableModel model, JTable Table){
        archivo.CrearArchivoProductos(model, Table);
    }
    public void CrearArchivoPlatos(String name, int price){
        archivo.CrearArchivoPlatos(name, price, this.list);
    }
    public void AgregarLista(String Ingrediente){
        list.agregar(Ingrediente);
    }
    
    
        
    
    public static void main(String[] args) {
        if (new File("archivos/productos.txt").exists() && new File("archivos/platos.txt").exists()){
            General g = new General();
            g.setVisible(true);            
        }else{
            if (!new File("archivos/productos.txt").exists()) {
                Configuracion c = new Configuracion();
                c.setVisible(true);
            }else{
                ConfiguracionPlatos c = new ConfiguracionPlatos();
                c.setVisible(true);
            }
            
            
            
        }
        
        
    }
    
}
