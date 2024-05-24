package Producto;

public class Main {

    public static void main(String[] args) {
        Producto producto1 = new Producto("Producto1", 20.0, 1000);
        Producto producto2 = new Producto("Producto2", 30.0, 500);
        CarritoDeCompras carrito = new CarritoDeCompras();
        // Agregar el productos
        carrito.agregarProducto(producto1, 50);
        carrito.agregarProducto(producto2, 30);
        carrito.mostrarDetalleCompra();
        double total = carrito.calcularTotal();
        System.out.println("Total de la compra: $" + total);
        String mensajePago = carrito.realizarPago(total);
        System.out.println(mensajePago);
        System.out.println("---------------------------");
        System.out.println(carrito.toString());
    }
}
