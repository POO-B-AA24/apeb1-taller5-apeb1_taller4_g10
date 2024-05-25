
public class Departamento {

    public String nombre;
    public int numeroEmpleados;
    public double produccionAnual;
    public String categoria;

    public Departamento(String nombre, int numeroEmpleados, double produccionAnual) {
        this.nombre = nombre;
        this.numeroEmpleados = numeroEmpleados;
        this.produccionAnual = produccionAnual;
        categoria();
    }

    public void categoria() {
        if (numeroEmpleados > 20 && produccionAnual > 1000000) {
            categoria = "A";
        } else if (numeroEmpleados >= 20 && produccionAnual >= 1000000) {
            categoria = "B";
        } else if (numeroEmpleados >= 10 && produccionAnual >= 500000) {
            categoria = "C";
        } else {
            categoria = "Sin categoría";
        }
    }

    @Override
    public String toString() {
        return "Departamento: " + nombre + ", Empleados: " + numeroEmpleados + ", "
                + "Producción: " + produccionAnual + ", Categoría: " + categoria;
    }
}
