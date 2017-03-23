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

    Cocina ptr = null;
    Cocina q = null;

    public void LlenarList(Pedido p) {
        if (ptr == null) {
            ptr = new Cocina(p);
            q = ptr;
        } else {
            q.setLink(new Cocina(p));
            q = q.getLink();
        }

    }

    public void showList() {
        Cocina p = ptr;
        while (p != null) {
            System.out.println(p.getPtr().NroPedido);
            p.getPtr().getProductos().showList();
            p = p.getLink();
        }
    }

}
