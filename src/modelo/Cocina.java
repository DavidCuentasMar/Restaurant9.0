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
        Pedido p = pedidos.getPtr();
        while(p.NroPedido!=NoPedido){
            p=p.getLink();
        }        
//        System.out.println("ENCONTRADO " + p.NroPedido);
        return p;
    }
}
