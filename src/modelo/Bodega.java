package modelo;

import java.util.ArrayList;

public class Bodega {
    ArrayList<Bebida>bebidas;
    ArrayList<Ingrediente>ingredientes;
    ArrayList<Postre>postres;

    public Bodega() {
        bebidas = new ArrayList<>();
        ingredientes = new ArrayList<>();
        postres = new ArrayList<>();
    }
    
    public void agregarBebida(String name, int amount, int price){
        bebidas.add(new Bebida(name, amount, price));        
    }
    public void agregarIngrediente(String name, int amount, int price){
        ingredientes.add(new Ingrediente(name, amount, price));
    }
    public void agregarPostre(String name, int amount, int price){
        postres.add(new Postre(name, amount, price));
    }

    
    
}
