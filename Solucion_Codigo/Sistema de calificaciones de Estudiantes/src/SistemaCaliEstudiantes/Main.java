package SistemaCaliEstudiantes;
import java.util.Scanner;
public class Main {
   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del estudiante:");
        String nombreEstudiante = scanner.nextLine();
        System.out.println("Ingrese la edad del estudiante:");
        int edadEstudiante = scanner.nextInt();
        scanner.nextLine(); 
        Estudiante estudiante = new Estudiante(nombreEstudiante, edadEstudiante);
        System.out.println("Ingrese el nombre de la materia:");
        String nombreMateria = scanner.nextLine();
        double acd = ingresarCalificacion(scanner,nombreMateria, "ACD");
        double ape = ingresarCalificacion(scanner,nombreMateria, "APE");
        double aa = ingresarCalificacion(scanner,nombreMateria, "AA");
        Materia materia = new Materia(nombreMateria, acd, ape, aa);
        estudiante.setMateria(materia);

        if (estudiante.verificarAprobacion()) {
            System.out.println("El estudiante " + estudiante.getNombre() + " ha aprobado " + materia.nombre);
        } else {
            System.out.println("El estudiante " + estudiante.getNombre() + " no ha aprobado " + materia.nombre);
            System.out.println("Se requiere un examen de recuperacion.");
            double notaRecuperacion = ingresarCalificacion(scanner,nombreMateria, "Recuperacion");
            
            if (materia.verificarAprobacionConRecuperacion(notaRecuperacion)) {
                System.out.println("El estudiante " + estudiante.getNombre() + " "
                        + "ha aprobado "+materia.nombre+" con el examen de recuperacion.");
            } else {
                System.out.println("El estudiante " + estudiante.getNombre() + " no "
                        + "ha aprobado "+materia.nombre+" incluso despues del examen de recuperacion.");
            }
        }
    }

    public static double ingresarCalificacion(Scanner scanner,String materia, String tipoCalificacion) {
        double calificacion;
        while (true) {
            System.out.println("Ingrese la calificacion de "+materia +" en el apartado de "+
                    tipoCalificacion + " (0 a 10):");
            calificacion = scanner.nextDouble();
            if (calificacion >= 0 && calificacion <= 10) {
                break;
            } else {
                System.out.println("Error: La calificacion debe estar entre 0 y 10. Intente nuevamente.");
            }
        }
        scanner.nextLine();
        return calificacion;
    }
}
