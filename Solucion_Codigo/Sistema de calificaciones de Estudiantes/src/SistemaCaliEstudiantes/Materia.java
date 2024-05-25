package SistemaCaliEstudiantes;

public class Materia {

    public String nombre;
    public double acd;
    public double ape;
    public double aa;

    public double MAX_ACD = 0.35;
    public double MAX_APE = 0.35;
    public double MAX_AA = 0.30;
    public double RECUPERACION = 0.35;
    public double PORCENTAJE_APROBACION = 7.0;

    public Materia(String nombre, double acd, double ape, double aa) {
        this.nombre = nombre;
        this.acd = acd;
        this.ape = ape;
        this.aa = aa;
    }

    public String getNombre() {
        return nombre;
    }

    public double getAcd() {
        return acd;
    }

    public double getApe() {
        return ape;
    }

    public double getAa() {
        return aa;
    }

    public boolean verificarAprobacion() {
        double porcentajeAcd = acd * MAX_ACD;
        double porcentajeApe = ape * MAX_APE;
        double porcentajeAa = aa * MAX_AA;

        double porcentajeTotal = porcentajeAcd + porcentajeApe + porcentajeAa;
        return porcentajeTotal >= PORCENTAJE_APROBACION;
    }

    public boolean verificarAprobacionConRecuperacion(double notaRecuperacion) {
        double porcentajeAcd = acd * MAX_ACD;
        double porcentajeApe = ape * MAX_APE;
        double porcentajeAa = aa * MAX_AA;
        double porcentajeTotal = porcentajeAcd + porcentajeApe + porcentajeAa;
        
        double acumulado60 = porcentajeTotal * 0.60;
        double notaRecuperacionFinal = notaRecuperacion * 0.35;

        return (acumulado60 + notaRecuperacionFinal) >= PORCENTAJE_APROBACION;
    }

    @Override
    public String toString() {
        return "Materia{"
                + "nombre='" + nombre + '\''
                + ", acd=" + acd
                + ", ape=" + ape
                + ", aa=" + aa
                + '}';
    }
}
