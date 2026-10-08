import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AtencionMedica {

    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
    private String observaciones;
    private String recomendaciones;
    private final List<MedicionSignosVitales> mediciones = new ArrayList<>();

    public AtencionMedica() {
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public LocalDateTime getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public void agregarMedicion(MedicionSignosVitales medicion) {
        mediciones.add(medicion);
    }

    public List<MedicionSignosVitales> getMediciones() {
        return Collections.unmodifiableList(mediciones);
    }

}
