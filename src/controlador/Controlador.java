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
import modelo.ListaProducto;
import modelo.Restaurant;

/**
 *
 * @author Administrador
 */
public class Controlador {
    private Restaurant restaurant;
    private Archivo archivo;
    private ListaProducto producto;
    public Controlador() {
        restaurant = new Restaurant();
        archivo = new Archivo();
        producto = new ListaProducto();
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
    
//    public ListaProducto LLenarList(ListaProducto Ptr,String Producto,String Tipo,int NroPedido,String Mesa, String Camarero){
//        Ptr = producto.LlenarList(Ptr, Producto,Tipo,NroPedido,Mesa,Camarero);
//        return Ptr;
//    }
//    
//    public String GetMesa(ListaProducto Ptr,int NumeroPedido){
//       return producto.GetMesa(Ptr, NumeroPedido);
//    }
//    public String GetCamarero(ListaProducto Ptr,int NumeroPedido){
//        return producto.GetCamarero(Ptr, NumeroPedido);
//    }
//    public String GetPlato(ListaProducto Ptr,int NumeroPedido){
//        return producto.GetPlato(Ptr, NumeroPedido);
//    }
//    public String GetBebida(ListaProducto Ptr,int NumeroPedido){
//        return producto.GetBebida(Ptr, NumeroPedido);
//    }
//    public String GetPostre(ListaProducto Ptr,int NumeroPedido){
//        return producto.GetPostre(Ptr, NumeroPedido);
//    }
    
}
