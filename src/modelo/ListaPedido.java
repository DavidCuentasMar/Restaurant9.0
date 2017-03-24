/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author dell
 */
public class ListaPedido {

    Pedido ptr;

    public ListaPedido() {
        this.ptr = null;
    }
    
    public void addPedido(Pedido p) {
        if (ptr == null) {
            this.ptr = p;
        } else {
            Pedido q = this.ptr;
            while(q.getLink() != null){
                q = q.getLink();
            }
            q.setLink(p);
        }

    }

    public Pedido getPtr() {
        return ptr;
    }
    

}
