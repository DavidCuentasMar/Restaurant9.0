/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author pollo4053
 */
public class JefeCocina {
    ListaProducto productList;
    Archivo archivo;
    String Factura;

    public JefeCocina( ) {
        archivo = new Archivo();

    }
    
    
    public void actualizarStock(int NoPedido, Cocina cocina) {
        Factura = "Factura"+"\n";
        String noCocinados="";
        int noCocinadosPrice=0;
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
                    Factura = Factura + q.getName()+".............."+price+"$"+"\n";
                }else{
//                    System.out.println(q.getName()+" no tiene en el stock");
                    //p.setPrice(price);
                    noCocinados=noCocinados+q.getType()+"/"+q.getName()+",";
                    noCocinadosPrice=noCocinadosPrice+price;
                }                                    
            }else{
                String name = q.getName();
                String ingredientesTxt = archivo.getPlatoIngredientes(name);
//                System.out.println(ingredientesTxt);
                StringTokenizer st = new StringTokenizer(ingredientesTxt,"+");
                boolean ok=true; //se puede cocinar el plato (todos los ingredientes tienen mas de 1 cant)
                while(st.hasMoreElements() && ok==true){
                    String token=st.nextElement().toString();
//                    System.out.println(token);
                    int cant = archivo.getCantidad(token);
                    int price= archivo.getPricePlato(name);
                    if (cant<=0) {
                        ok=false;
                        noCocinadosPrice=noCocinadosPrice+price;
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
                    Factura = Factura + q.getName()+".........."+archivo.getPrice(name)+"$"+"\n";
                }else{
//                    System.out.println("El plato " + name + "no tiene los ingredientes completos"+ "[NO COCINADO]");
                    noCocinados=noCocinados+"Plato/"+name+",";    
                }                        
            }
            q=q.getLink();
        }
        if (noCocinadosPrice!=0) {
            noCocinados=noCocinados.substring(0, noCocinados.length()-1);
            System.out.println("Productos no cocinados: " + noCocinados); //String con productos que no se cocinaron
            System.out.println("Precio no cocinados: " + noCocinadosPrice); // lo que se tiene que restar al valor pedido
            p.setPrice(noCocinadosPrice);
        }  
        Factura = Factura + "Total"+"..........."+p.getValor()+"$"+"\n";
        Factura = Factura + "IVA 5%"+".........."+(p.getValor()*0.05)+"$"+"\n";
        Factura = Factura + "Propina 10%"+"......."+(p.getValor()*0.1)+"$"+"\n";
        Factura = Factura + "Total a Pagar"+".........."+(p.getValor()+(p.getValor()*0.05+p.getValor()*0.1))+"$"+"\n";
        Factura = Factura + ".....................................";
        JOptionPane.showMessageDialog(null,Factura);
        //System.out.println("Precio del pedido: "+ p.getValor());
    }
    
    
    
    
}
