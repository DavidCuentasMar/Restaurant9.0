package modelo;
public class Cocina {
    ListaPedido pedidos;

    public Cocina() {
        pedidos = new ListaPedido();
    }
    
    public void add(Pedido p){
        pedidos.addPedido(p);
    }
    
    public Pedido findPedido(int NoPedido){
         System.out.println("HOLA");
        Pedido p = pedidos.getPtr();
        System.out.println(p);
       
//        while(p.NroPedido!=NoPedido){
//            p=p.getLink();
//        }         
        return p;
    }
}
