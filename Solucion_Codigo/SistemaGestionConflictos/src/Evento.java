
public class Evento {
    public String nombre;
    public String fecha;
    public String ubicacion;
    public String descripcion;
    public String tipo;

    public Evento(String nombre, String fecha, String ubicacion, String descripcion, 
            String tipo) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Evento: " + nombre + ", Fecha: " + fecha + ", Ubicación: " + ubicacion 
                + ", Descripción: " + descripcion + ", Tipo: " + tipo;
    }
}
