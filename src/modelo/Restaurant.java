package modelo;

import java.io.File;
import vista.Configuracion;
import vista.ConfiguracionPlatos;
import vista.General;

/**
 *
 * @author Administrador
 */
public class Restaurant {
    Lista list;
    Cocina cocina;
    private Archivo archivo;
    ListaPedido listaAllPedidos;
    public Restaurant() {
        listaAllPedidos = new ListaPedido();
        list = new Lista();
        cocina = new Cocina();
        archivo = new Archivo();
    }
    public void CrearArchivoPlatos(String name, int price){
        archivo.CrearArchivoPlatos(name, price, this.list);
    }
    public void addIngredienteList(String Ingrediente){
        list.add(Ingrediente);
    }
    
    
    
        
    
    public static void main(String[] args) {
        if (new File("archivos/productos.txt").exists() && new File("archivos/platos.txt").exists()){
            General g = new General();
            g.setVisible(true);            
        }else{
            if (!new File("archivos/productos.txt").exists()) {
                Configuracion c = new Configuracion();
                c.setVisible(true);
            }else{
                ConfiguracionPlatos c = new ConfiguracionPlatos();
                c.setVisible(true);
            }
            
            
            
        }
        
        
    }
    public void addPedidoToList(Pedido p) {
        listaAllPedidos.addPedido(p); // Agrega el pedido a la lista de todos
                                      // los pedidos del restaurante  
    }
    public Pedido findPedido(String noPedido){
        Pedido q = listaAllPedidos.getPtr();
        while(q.NroPedido!=Integer.parseInt(noPedido)){
            q=q.getLink();            
        }
        return q;
    }
    
}
