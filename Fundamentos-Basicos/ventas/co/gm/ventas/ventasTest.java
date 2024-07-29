package ventas.co.gm.ventas;

public class ventasTest {
    public static void main(String[] args) {
        Product product1 = new Product("Camisa",5000.0);
        Product product2 = new Product("Pantalon",8500.0);

        Order orden1 = new Order();
        orden1.addProduct(product1);
        orden1.addProduct(product2);
        orden1.showOrder();

        Order orden2 = new Order();
        orden2.addProduct(product2);
        orden2.showOrder();


    }
}
