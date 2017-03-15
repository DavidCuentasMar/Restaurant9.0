/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author pollo4053
 */

public class Pedido {
    
    public static class Pedidos{
        String Plato;
        String Bebida;
        String Postre;
        int NroMesa;
        int Mesero;
        Pedidos link;
    }
    public static Pedidos ptr = null;
    
    public static Pedidos AgregarPedido(Pedidos ptr,String Plato,String Bebida, String Postre, int NroMesa, int Mesero){
        Pedidos p = new Pedidos();
        p.Plato = Plato;
        p.Bebida = Bebida;
        p.Postre = Postre;
        p.NroMesa = NroMesa;
        p.Mesero = Mesero;
        if (ptr == null) {
            ptr = p;
        }else{
            Pedidos q = ptr;
            while (q.link != null) {                
                q = q.link;
            }
            q.link = p;
        }
        return ptr;
    }
  
}
