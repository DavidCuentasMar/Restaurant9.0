/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.StringTokenizer;

/**
 *
 * @author pollo4053
 */
public class JefeCocina {
    ListaProducto productList;
    Archivo archivo;

    public JefeCocina( ) {
        archivo = new Archivo();
    }
    
    
    public void actualizarStock(int NoPedido, Cocina cocina) {
        Pedido p = cocina.findPedido(NoPedido); //Buscamos el pedido
        productList=p.getProductos(); // Tomamos la lista de productos pedidos
        //productList.showList();
            //Recorremos y vamos verificando y/o actualizando el stock
        Producto q = productList.getPtr();
        while (q!=null){
            if (q.getType().equals("Postre") || q.getType().equals("Bebida")) {
                int cant = archivo.getCantidad(q.getName());
                int price = archivo.getPrice(q.getName());
                if (cant>=1) {
                    archivo.archivoTemp(q.getName(),q.getType(),cant-1, price);
                }else{
                    System.out.println(q.getName()+" no tiene en el stock");
                    p.setPrice(price+"");
                }                                    
            }else{
                String name = q.getName();
                String ingredientesTxt = archivo.getPlatoIngredientes(name);
                System.out.println(ingredientesTxt);
                StringTokenizer st = new StringTokenizer(ingredientesTxt,"+");
                boolean ok=true; //se puede cocinar el plato (todos los ingredientes tienen mas de 1 cant)
                while(st.hasMoreElements() && ok==true){
                    String token=st.nextElement().toString();
//                    System.out.println(token);
                    int cant = archivo.getCantidad(token);
                    if (cant<=0) {
                        ok=false;
                    }                   
                }
                if (ok==true) {
                    st = new StringTokenizer(ingredientesTxt,"+");
                    while(st.hasMoreElements()){
                        String token=st.nextElement().toString();
//                      System.out.println(token);
                        int cant = archivo.getCantidad(token);
                        int price = archivo.getPrice(token);
                        archivo.archivoTemp(token,"Ingrediente",cant-1, price);               
                    }
                }else{
                    System.out.println("El plato " + name + "no tiene los ingredientes completos"+ "[NO COCINADO]");
                }
                // AQUI ENTRA SI EN UN PLATO, SE TIENE QUE BUSCAR QUE INGREDIENTES
                //TIENE EN EL ARCHIVO PLATO UNA VEZ SE RECORRE Y MIENTRAS QUE SE RECCORE
                // ESA LISTA SE UNA archivo.archivoTEMP()
        
            }

            q=q.getLink();
        }
        
      
    }
    
    
    
    
}
