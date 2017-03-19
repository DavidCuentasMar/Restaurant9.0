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
import modelo.Pedido;
import modelo.Pedido.Productos;
import modelo.Restaurant;

/**
 *
 * @author Administrador
 */
public class Controlador {
    private Restaurant restaurant;
    private Archivo archivo;
    private Pedido pedido;
    
    public Controlador() {
        restaurant = new Restaurant();
        archivo = new Archivo();
        pedido = new Pedido();
    }
    public void MostrarMenu(JPanel platosPanel, JPanel bebidasPanel, JPanel postresPanel){
        archivo.MostrarMenu(platosPanel,bebidasPanel,postresPanel);
    
    }
    public void MostrarPrecio(String p, String precio, String ruta,JTable TablePedidos,String type){
        archivo.MostrarPrecio(p, precio, ruta, TablePedidos,type);
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
    
    public Productos LLenarList(Productos Ptr,String Producto){
        Ptr = pedido.LlenarList(Ptr, Producto);
        return Ptr;
    }
  
    
}
