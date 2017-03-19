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

public class Pedido {
    private int NroPedido;
    private int NroMesa;
    private String Camarero;
    private int Total;

    /*public Pedido() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
    public static class Productos{
        public String Producto;
        public int Cant;
        public Productos link;
    }
    public Productos LlenarList(Productos ptr,String X){
        Productos p = new Productos();
        Productos r = ptr;
        boolean SW = true;
         while(r != null && SW == true){
             if (r.Producto.equals(X)) {
                 SW = false;
             }else{
                r = r.link;
             }
        }
        p.Producto = X;
        p.Cant = 1;
        if (ptr == null) {
            ptr = p;
        }else if(SW != false){
            Productos q = ptr;
            while(q.link != null){
                q = q.link;
            }
            q.link = p;
        }else{
            r.Cant++;
        }
        return ptr;
    }
   
    
    
    
  
}
