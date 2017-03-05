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
    private int NumMesa;
    private int MeseroID;
    ArrayList<Postre>postres;
    ArrayList<Bebida>bebidas;
    ArrayList platoslist;

    public Pedido(int NumMesa, int MeseroID) {
        this.NumMesa = NumMesa;
        this.MeseroID = MeseroID;
        postres = new ArrayList();
        bebidas = new ArrayList();
        platoslist = new ArrayList();
    }
    public void agregarPlato(int cantidad, String name){
        
    }
    public void agregarBebida(int cantidad, String name){
    
    }
    public void agregarPostre(int cantidad, String name){}
    
    

}
