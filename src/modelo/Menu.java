package modelo;

import java.util.ArrayList;

public class Menu {
    ArrayList<Postre>postres;
    ArrayList<Plato>platos;
    ArrayList<Bebida>bebidas;
    
    public Menu() {
        bebidas = new ArrayList<>();
        platos = new ArrayList<>();
        postres = new ArrayList<>();
    }
    
    public void agregarBebida(Bebida b){
        bebidas.add(b);
    }   
    public void agregarPlato(Plato p){
        platos.add(p);         
    }   
    public void agregarPostre(Postre p){
        postres.add(p);
    }   
}
