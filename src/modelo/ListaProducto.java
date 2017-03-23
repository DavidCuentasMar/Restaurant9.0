/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author pc
 */
public class ListaProducto {
        private Producto ptr;

    public ListaProducto() {
        this.ptr = null;
    }
    public void showList(){
        Producto p = ptr;
        while(p!=null){
            System.out.println(p.getName());
            p=p.getLink();
        }
    }
    public void LlenarList(Producto p){
        Producto k = this.ptr;
        if (k == null) {
            this.ptr = p;
        }else{
            Producto q = this.ptr;
            while(q.getLink() != null){
                q = q.getLink();
            }
            q.setLink(p);
        }        
    }

    public Producto getPtr() {
        return ptr;
    }

    public void setPtr(Producto ptr) {
        this.ptr = ptr;
    }
    
}
        
        

