
import java.util.Scanner;

public class Ejecutor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear un caso de corrupción
        System.out.print("Ingrese el nombre del caso: ");
        String nombreCaso = scanner.nextLine();

        System.out.print("Ingrese los detalles del caso: ");
        String detalles = scanner.nextLine();

        System.out.print("Ingrese los días desde el inicio del caso: ");
        int diasDesdeInicio = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea

        CasoCorrupcion caso = new CasoCorrupcion(nombreCaso, diasDesdeInicio, detalles);

        // Agregar personas al caso
        while (true) {
            System.out.print("Ingrese el nombre de la persona implicada (o 'salir' para terminar): ");
            String nombrePersona = scanner.nextLine();
            if (nombrePersona.equalsIgnoreCase("salir")) {
                break;
            }

            System.out.print("Ingrese la edad de la persona: ");
            int edad = scanner.nextInt();

            System.out.print("Ingrese la ocupación de la persona: ");
            scanner.nextLine(); // Consumir el salto de línea
            String ocupacion = scanner.nextLine();

            System.out.print("Ingrese el nivel de implicación (acusado, testigo, víctima, etc.): ");
            String nivelImplicacion = scanner.nextLine();

            Persona persona = new Persona(nombrePersona, edad, ocupacion, nivelImplicacion);
            caso.agregarPersona(persona);

            if (nivelImplicacion.equalsIgnoreCase("acusado")) {
                System.out.print("¿Desea ofrecer colaboración (si/no)? ");
                String colaboracion = scanner.nextLine();
                if (colaboracion.equalsIgnoreCase("si")) {
                    persona.ofrecerColaboracion();
                }
            }
        }

        // Actualizar estado del caso
        caso.actualizarEstado();

        // Mostrar el caso con la información actualizada
        System.out.println(caso.toString());
    }
}
