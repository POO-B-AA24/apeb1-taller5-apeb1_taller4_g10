
public class Pais {
    public String nombre;
    public boolean esDesarrollado;
    public int poblacion;
    public int bajas;

    public Pais(String nombre, boolean esDesarrollado, int poblacion) {
        this.nombre = nombre;
        this.esDesarrollado = esDesarrollado;
        this.poblacion = poblacion;
        this.bajas = 0;
    }

    public void actualizarBajas(int nuevasBajas) {
        this.bajas += nuevasBajas;
    }

    @Override
    public String toString() {
        return "País: " + nombre + ", Desarrollado: " + (esDesarrollado ? "Sí" : "No") + ", Población: " + poblacion + ", Bajas: " + bajas;
    }
}
