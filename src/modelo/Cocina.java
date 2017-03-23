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
public class Cocina {

    private Pedido ptr;
    private Cocina link;

    public void setLink(Pedido ptr) {
        this.ptr = ptr;
    }

    public Cocina(Pedido ptr) {
        this.ptr = ptr;
        this.link = null;
    }

    public Pedido getPtr() {
        return ptr;
    }

    public Cocina getLink() {
        return link;
    }

    public void setPtr(Pedido ptr) {
        this.ptr = ptr;
    }

    public void setLink(Cocina link) {
        this.link = link;
    }

}
