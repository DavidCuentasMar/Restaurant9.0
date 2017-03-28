package modelo;

/**
 *
 * @author pollo4053
 */
public class Mesero {
    Cocina cocina;
    
    
    public void pedidoToCocina(Pedido p){
        cocina.add(p);   
    }
    
}
