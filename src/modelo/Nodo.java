package modelo;
public class Nodo {
    private String Ingrediente;
    private Nodo siguiente;

    public void Nodo(){
        this.Ingrediente = "";
        this.siguiente = null;
    }

    public String getIngrediente() {
        return Ingrediente;
    }

    public void setIngrediente(String Ingrediente) {
        this.Ingrediente = Ingrediente;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }
    
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
