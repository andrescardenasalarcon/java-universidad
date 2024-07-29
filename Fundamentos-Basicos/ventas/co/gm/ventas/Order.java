package ventas.co.gm.ventas;

public class Order {
    private final int idOrder;
    private Product products[];
    private static int countOrders;
    private int countProducts;
    private static final int MAX_PRODUCTS = 10;

    public Order() {
        this.idOrder = ++Order.countOrders;
        this.products = new Product[Order.MAX_PRODUCTS];
    }

    public void addProduct(Product product) {
        if (this.countProducts < Order.MAX_PRODUCTS) {
            this.products[this.countProducts++] = product;
        } else {
            System.out.println("Se ha superado el máx de prodyctos " + Order.MAX_PRODUCTS);
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (int i = 0; i < this.countProducts; i++) {
            total += products[i].getPrice();
        }
        return total;
    }

    public void showOrder(){
        System.out.println("idOrder = " + this.idOrder);
        double totalOrder = this.calculateTotal();
        System.out.println("Total of the Order = $" + totalOrder);
        System.out.println("Products of Order: ");
        for (int i = 0; i < this.countProducts; i++) {
            System.out.println(products[i]);
        }
    }

}
