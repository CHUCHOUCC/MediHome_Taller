import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProfesionalSalud extends Usuario implements INotificable {

    private String numeroRegistroProfesional;
    private String especialidad;
    private final List<ServicioDomicilario> servicios = new ArrayList<>();

    public ProfesionalSalud() {

    }

    public String getNumeroRegistroProfesional() {
        return numeroRegistroProfesional;
    }

    public void setNumeroRegistroProfesional(String numeroRegistroProfesional) {
        this.numeroRegistroProfesional = numeroRegistroProfesional;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public void notificar(String mensaje) {
        System.out.println(mensaje);
    }

    // Disponible si no tiene otro servicio activo programado a esa misma hora.
    public boolean estaDisponible(LocalDateTime hora) {
        for (ServicioDomicilario servicio : servicios) {
            boolean activo = !"CANCELADO".equals(servicio.getEstado())
                    && !"FINALIZADO".equals(servicio.getEstado());
            if (activo && hora.equals(servicio.getFechaProgramada())) {
                return false;
            }
        }
        return true;
    }

    void registrarServicio(ServicioDomicilario servicio) {
        servicios.add(servicio);
    }

}
