
public class Conflicto {

    public String nombre;
    public Pais[] paisesInvolucrados;
    public String fechaInicio;
    public String estadoActual;
    public String detallesAdicionales;
    public Evento[] eventos;
    public int contadorPaises;
    public int contadorEventos;

    public Conflicto(String nombre, String fechaInicio, String estadoActual, 
            String detallesAdicionales) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.estadoActual = estadoActual;
        this.detallesAdicionales = detallesAdicionales;
        this.paisesInvolucrados = new Pais[195];
        this.eventos = new Evento[1000];
        this.contadorPaises = 0;
        this.contadorEventos = 0;
    }

    public void agregarEvento(Evento evento) {
        if (contadorEventos < eventos.length) {
            this.eventos[contadorEventos++] = evento;
            this.actualizarEstado();
        } else {
            System.out.println("No se pueden agregar más eventos.");
        }
    }

    public void agregarPais(Pais pais) {
        if (contadorPaises < paisesInvolucrados.length) {
            this.paisesInvolucrados[contadorPaises++] = pais;
        } else {
            System.out.println("No se pueden agregar más países.");
        }
    }

    public void actualizarEstado() {
        int totalPaises = 195;
        int paisesEnBatalla = 0;
        boolean armasNuclearesUsadas = false;

        for (int i = 0; i < contadorEventos; i++) {
            if (eventos[i].tipo.equalsIgnoreCase("batalla")) {
                paisesEnBatalla++;
                if (eventos[i].descripcion.toLowerCase().contains("nuclear")) {
                    armasNuclearesUsadas = true;
                }
            }
        }

        if ((paisesEnBatalla > totalPaises * 0.5) || (armasNuclearesUsadas && 
                paisesEnBatalla > 0)) {
            this.estadoActual = "Guerra Mundial";
        } else if (paisesEnBatalla >= totalPaises * 0.3) {
            this.estadoActual = "Convocar a la ONU a reunión urgente";
        }
    }

    @Override
    public String toString() {
        return "Conflicto: " + nombre + ", Fecha de Inicio: " + fechaInicio + ", "
                + "Estado Actual: " + estadoActual + ", Detalles: " + detallesAdicionales;
    }
}
