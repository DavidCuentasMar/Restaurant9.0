package modelo;

/**
 *
 * @author Administrador
 */
public class Producto {
    private String name;
    private int amount;
    private int price;

    public Producto(String name, int amount, int price) {
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public int getPrice() {
        return price;
    }
    
}
