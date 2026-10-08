import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ServicioDomicilario {

    private String codigo;
    private LocalDateTime fechaProgramada;
    private String direccionAtencion;
    private String motivo;
    private String estado;

    private Paciente paciente;
    private ProfesionalSalud profesionalSalud;
    private final List<AtencionMedica> atenciones = new ArrayList<>();

    public ServicioDomicilario() {

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDateTime getFechaProgramada() {
        return fechaProgramada;
    }

    public void setFechaProgramada(LocalDateTime fechaProgramada) {
        this.fechaProgramada = fechaProgramada;
    }

    public String getDireccionAtencion() {
        return direccionAtencion;
    }

    public void setDireccionAtencion(String direccionAtencion) {
        this.direccionAtencion = direccionAtencion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public ProfesionalSalud getProfesionalSalud() {
        return profesionalSalud;
    }

    public void setProfesionalSalud(ProfesionalSalud profesionalSalud) {
        this.profesionalSalud = profesionalSalud;
    }

    public List<AtencionMedica> getAtenciones() {
        return Collections.unmodifiableList(atenciones);
    }

    public void programar(LocalDateTime fecha) {
        this.fechaProgramada = fecha;
        this.estado = "PROGRAMADO";
    }

    public void asignarProfesional(ProfesionalSalud profesional) {
        if (!profesional.estaDisponible(fechaProgramada)) {
            throw new IllegalStateException("El profesional no esta disponible a esa hora");
        }
        this.profesionalSalud = profesional;
        profesional.registrarServicio(this);
    }

    public void iniciarAtencion() {
        if (!"PROGRAMADO".equals(estado) || profesionalSalud == null) {
            throw new IllegalStateException("El servicio debe estar programado y con profesional asignado");
        }
        AtencionMedica atencion = new AtencionMedica();
        atencion.setFechaHoraInicio(LocalDateTime.now());
        atenciones.add(atencion);
        this.estado = "EN_CURSO";
    }

    public void finalizar() {
        if (!"EN_CURSO".equals(estado)) {
            throw new IllegalStateException("Solo se puede finalizar un servicio en curso");
        }
        atenciones.get(atenciones.size() - 1).setFechaHoraFin(LocalDateTime.now());
        this.estado = "FINALIZADO";
    }

    public void cancelar() {
        if ("FINALIZADO".equals(estado)) {
            throw new IllegalStateException("No se puede cancelar un servicio finalizado");
        }
        this.estado = "CANCELADO";
    }

}
