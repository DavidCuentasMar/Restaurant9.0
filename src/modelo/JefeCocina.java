/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author pollo4053
 */
public class JefeCocina {
    ListaProducto productList;
    Archivo archivo;
    
    public void actualizarStock(int NoPedido, Cocina cocina) {
      Pedido p = cocina.findPedido(NoPedido); //Buscamos el pedido
      productList=p.getProductos(); // Tomamos la lista de productos pedidos
      productList.showList();
        //Recorremos y vamos verificando y/o actualizando el stock
      Producto q = productList.getPtr();
      while(q!=null){
        String name = q.getName();
//        int cant = archivo.getCantidad(name);
        System.out.println(name + ":"+0);
        q=q.getLink();
      }

        
    }
    
    
    
    
}
