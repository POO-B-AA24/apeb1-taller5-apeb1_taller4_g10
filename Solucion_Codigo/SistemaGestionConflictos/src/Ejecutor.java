
import java.util.Scanner;

public class Ejecutor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del conflicto:");
        String nombreConflicto = scanner.nextLine();

        System.out.println("Ingrese la fecha de inicio del conflicto (dd/mm/yyyy):");
        String fechaInicio = scanner.nextLine();

        System.out.println("Ingrese el estado actual del conflicto:");
        String estadoActual = scanner.nextLine();

        System.out.println("Ingrese los detalles adicionales del conflicto:");
        String detallesAdicionales = scanner.nextLine();

        Conflicto conflicto = new Conflicto(nombreConflicto, fechaInicio, 
                estadoActual, detallesAdicionales);

        System.out.println("Ingrese el número de países involucrados:");
        int numeroPaises = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numeroPaises; i++) {
            System.out.println("Ingrese el nombre del país " + (i + 1) + ":");
            String nombrePais = scanner.nextLine();

            System.out.println("¿El país es desarrollado? (true/false):");
            boolean esDesarrollado = Boolean.parseBoolean(scanner.nextLine());

            System.out.println("Ingrese la población del país " + (i + 1) + ":");
            int poblacion = Integer.parseInt(scanner.nextLine());

            Pais pais = new Pais(nombrePais, esDesarrollado, poblacion);
            conflicto.agregarPais(pais);
        }

        System.out.println("Ingrese el número de eventos:");
        int numeroEventos = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numeroEventos; i++) {
            System.out.println("Ingrese el nombre del evento " + (i + 1) + ":");
            String nombreEvento = scanner.nextLine();

            System.out.println("Ingrese la fecha del evento (dd/mm/yyyy):");
            String fechaEvento = scanner.nextLine();

            System.out.println("Ingrese la ubicación del evento " + (i + 1) + ":");
            String ubicacion = scanner.nextLine();

            System.out.println("Ingrese la descripción del evento " + (i + 1) + ":");
            String descripcion = scanner.nextLine();

            System.out.println("Ingrese el tipo del evento (batalla, tratado de "
                    + "paz, reunión diplomática, etc.):");
            String tipo = scanner.nextLine();

            Evento evento = new Evento(nombreEvento, fechaEvento, ubicacion,
                    descripcion, tipo);
            conflicto.agregarEvento(evento);
        }

        System.out.println(conflicto.toString());
        for (int i = 0; i < conflicto.eventos.length && conflicto.eventos[i] != null; i++) {
            System.out.println(conflicto.eventos[i].toString());
        }

        scanner.close();
    }
}
