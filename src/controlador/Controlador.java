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
import modelo.JefeCocina;
import modelo.Pedido;
import modelo.ListaProducto;
import modelo.Mesero;
import modelo.Restaurant;

/**
 *
 * @author Administrador
 */
public class Controlador {
    private Restaurant restaurant;
    private Archivo archivo;
    private ListaProducto producto;
    private Mesero mesero;
    private JefeCocina jefeCocina;
    public Controlador() {
        restaurant = new Restaurant();
        archivo = new Archivo();
        producto = new ListaProducto();
    }
    public void FormarMenu(JPanel platosPanel, JPanel bebidasPanel, JPanel postresPanel){
        archivo.FormarMenu(platosPanel,bebidasPanel,postresPanel);
    
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
    
    public void addPedidoToList(Pedido p) {
        restaurant.addPedidoToList(p);
    }
    public Pedido findPedido(String noPedido){
        return restaurant.findPedido(noPedido);
    }

    public void addPedidoToCocina(Pedido p) {
        mesero.pedidoToCocina(p);
    }

    public boolean validarPedido() {
        return archivo.validarPedido();
    }

    public void validarPedido(int NoPedido) {
        jefeCocina.validarPedido(NoPedido);
    }
}
