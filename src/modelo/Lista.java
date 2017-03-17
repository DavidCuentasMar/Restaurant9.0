package modelo;
public class Lista {
    private Nodo inicio;
    private int tamanio;
    public void Lista(){
        inicio = null;
        tamanio = 0;
    }
    public boolean esVacia(){
        return inicio == null;
    }
    public int getTamanio(){
        return tamanio;
    }
    public Nodo getPTR(){
        return inicio;
    }
    public Nodo remove(){
        this.inicio=null;
        return inicio;
    }
    public void agregar(String Name){        
        Nodo p = new Nodo();
        p.setIngrediente(Name);
        if (esVacia()) {            
            inicio = p;
        } else{
            Nodo aux = inicio;
            while(aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(p);
        }
        tamanio++;
    }  
}
