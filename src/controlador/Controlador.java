/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Archivo;
import modelo.Lista;
import modelo.Restaurant;

/**
 *
 * @author Administrador
 */
public class Controlador {
    private Restaurant restaurant;
    private Archivo archivo;

    public Controlador() {
        restaurant = new Restaurant();
        archivo = new Archivo();

    }
    public void MostrarMenu(JPanel platosPanel, JPanel bebidasPanel, JPanel postresPanel){
        archivo.MostrarMenu(platosPanel,bebidasPanel,postresPanel);
    
    }
    public void CrearArchivoProductos(DefaultTableModel model, JTable Table){
        archivo.CrearArchivoProductos(model, Table);
    }
    
    public void AgregarLista(String Ingrediente){
        restaurant.addIngredienteList(Ingrediente);
    }

    public void CrearArchivoPlatos(String name, int price) {
        restaurant.CrearArchivoPlatos(name, price);
    }
    
    
    
}
