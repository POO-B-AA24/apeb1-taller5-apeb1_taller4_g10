package SistemaCaliEstudiantes;
public class Estudiante {
    public String nombre;
    public int edad;
    public Materia materia;

    public Estudiante(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public boolean verificarAprobacion() {
        if (materia == null) {
            return false; // Si el estudiante no tiene materia, no puede aprobarla
        }
        return materia.verificarAprobacion();
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", materia=" + materia +
                '}';
    }
}