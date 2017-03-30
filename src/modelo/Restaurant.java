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
    private JefeCocina jefeCocina;
    public Restaurant() {
        list = new Lista();
        cocina = new Cocina();
        jefeCocina=new JefeCocina();
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

    public Pedido findPedido(String noPedido){
        Pedido p = cocina.findPedido(Integer.parseInt(noPedido));
        return p;
    }

    public void actualizarStock(int NoPedido) {
        jefeCocina.actualizarStock(NoPedido, cocina);
    }

    public void addPedidoToCocina(Pedido p) {
        cocina.add(p);
    }
    
}
