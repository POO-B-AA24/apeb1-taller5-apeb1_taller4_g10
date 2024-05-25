
import java.util.ArrayList;
import java.util.List;

public class Empresa {

    public String nombre;
    public String ruc;
    public String direccion;
    public List<Departamento> departamentos;

    public Empresa(String nombre, String ruc, String direccion) {
        this.nombre = nombre;
        this.ruc = ruc;
        this.direccion = direccion;
        this.departamentos = new ArrayList<>();
    }

    public void agregarDepartamento(Departamento departamento) {
        departamentos.add(departamento);
    }

    public void mostrarDepartamentos() {
        for (Departamento depto : departamentos) {
            System.out.println(depto.toString());
        }
    }

    @Override
    public String toString() {
        return "Empresa: " + nombre + ", RUC: " + ruc + ", Dirección: " + direccion;
    }
}
