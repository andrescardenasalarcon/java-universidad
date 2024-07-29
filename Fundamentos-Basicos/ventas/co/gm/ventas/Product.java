package ventas.co.gm.ventas;

public class Product {
    private final int idProduct;
    private String name;
    private double price;
    private static int counterProducts;

    private Product(){
        this.idProduct = ++Product.counterProducts;
    }

    public Product(String name, double price) {
        this();//Llamada al construcotr privado y vacio de arriba
        this.name = name;
        this.price = price;
    }

    public int getIdProduct() {
        return idProduct;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
