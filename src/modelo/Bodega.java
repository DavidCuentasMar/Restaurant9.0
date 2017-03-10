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
    public void agregarBebida(Bebida b){
        bebidas.add(b);
        System.out.println(b.getName()+" [Bebida agregada]");
    }
    public void agregarIngrediente(String[] ingredienteV){
        for (int i = 0; i < ingredienteV.length; i++) {
            if (ingredientes.isEmpty()) {
                ingredientes.add(new Ingrediente(ingredienteV[i]));
                System.out.println(ingredienteV[i]+ "[Ingrediente agregado]");
            }else{
                if (!ingredienteV[i].equals("*")) {
                    boolean check = false;
                    for (int j = 0; j < ingredientes.size(); j++) {
                        if (ingredientes.get(j).getName().equals(ingredienteV[i])) {
                            check = true;
                            System.out.println(ingredienteV[i]+" [Ya existe]");
                        }
                    }
                    if (check==false) {
                        ingredientes.add(new Ingrediente(ingredienteV[i]));
                        System.out.println(ingredienteV[i]+ "[Ingrediente agregado]");
                    }                    
                }
            }
        }
    }
    public void agregarPostre(Postre p){
        postres.add(p);
        System.out.println(p.getName()+" [Postre agregado]");
    }

    
    
}
