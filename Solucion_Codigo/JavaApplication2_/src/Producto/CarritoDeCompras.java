package Producto;
public class CarritoDeCompras {
    private Producto[] productos;
    private int[] cantidades;
    private int size;
    public CarritoDeCompras() {
        this.productos = new Producto[10]; 
        this.cantidades = new int[10]; 
        this.size = 0;
    }
    public void agregarProducto(Producto producto, int cantidad) {
        if (producto != null && cantidad > 0) {
            if (size < productos.length) {
                productos[size] = producto;
                cantidades[size] = cantidad;
                size++;
                System.out.println("Producto agregado al carrito.");
            } else {
                System.out.println("El carrito está lleno. No se puede agregar más productos.");
            }
        } 
    }
    public double calcularTotal() {
        double total = 0;
        for (int i = 0; i < size; i++) {
            total += productos[i].getPrecio() * cantidades[i];
        }
        return total;
    }
    public boolean descuentoAplicado;
    public double totalFinal;
    public String realizarPago(double monto) {
        double total = calcularTotal();
        descuentoAplicado = false;
        if (total == 0) {
            return "No hay productos en el carrito. No se puede realizar el pago.";
        }

        // Aplicar descuento si el monto supera $1000
        double descuento = 0;
        if (monto > 1000) {
            descuento = total * 0.1; // Descuento del 10%
            total -= descuento;
            descuentoAplicado = true;
        }

        if (monto >= total) {
            // Actualizar la cantidad disponible en la tienda
            for (int i = 0; i < size; i++) {
                Producto productoActual = productos[i];
                int cantidadAdquirida = cantidades[i];
                int cantidadDisponible = productoActual.getCantidad() - cantidadAdquirida;
                productoActual.setCantidad(cantidadDisponible);
            }

            totalFinal = total; // Almacenar el total final de la compra
            if (descuento > 0) {
                return "Pago realizado con descuento del 10%\nTotal: $" + totalFinal + "\nDescuento aplicado: $" + descuento + "\nGracias por su compra.";
            } else {
                return "Pago realizado. Total: $" + totalFinal + ". Gracias por su compra.";
            }
        } else {
            return "Monto insuficiente. Faltan $" + (total - monto) + " para completar la compra.";
        }
    }

    public void mostrarDetalleCompra() {
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                Producto productoActual = productos[i];
                int cantidadAdquirida = cantidades[i];
                int cantidadDisponible = productoActual.getCantidad() - cantidadAdquirida;
                System.out.println(productoActual.toString());
                System.out.println("Cantidad que adquirio: " + cantidadAdquirida);
                System.out.println("Cantidad disponible en la tienda: " + cantidadDisponible);
                // Actualizar la cantidad disponible en el objeto Producto
                productoActual.setCantidad(cantidadDisponible);
            }
        } else {
            System.out.println("No hay productos en el carrito.");
        }
    }

    @Override
    public String toString() {
        String resultado = "\nProductos en el carrito de compras:\n";
        for (int i = 0; i < size; i++) {
            Producto productoActual = productos[i];
            int cantidadAdquirida = cantidades[i];
            resultado += "Producto: " + productoActual.getNombre() + ", Precio: $" + productoActual.getPrecio()
                    + ", Cantidad: " + cantidadAdquirida + "\n";
        }
        if (descuentoAplicado) {
            resultado += "Descuento aplicado: 10%\n";
        } else {
            resultado += "Descuento aplicado: No\n";
        }
        resultado += "Total de la compra: $" + totalFinal;
        return resultado;
    }
}
