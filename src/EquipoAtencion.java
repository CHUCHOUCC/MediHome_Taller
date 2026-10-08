import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EquipoAtencion {

    private String codigo;
    private String nombre;
    private String zonaCobertura;
    private final List<ProfesionalSalud> profesionales = new ArrayList<>();

    public EquipoAtencion() {

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getZonaCobertura() {
        return zonaCobertura;
    }

    public void setZonaCobertura(String zonaCobertura) {
        this.zonaCobertura = zonaCobertura;
    }

    public void agregarProfesional(ProfesionalSalud profesional) {
        if (profesional != null && !profesionales.contains(profesional)) {
            profesionales.add(profesional);
        }
    }

    public void retirarProfesional(ProfesionalSalud profesional) {
        profesionales.remove(profesional);
    }

    public List<ProfesionalSalud> getProfesionales() {
        return Collections.unmodifiableList(profesionales);
    }
}
