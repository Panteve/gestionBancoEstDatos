package co.edu.gestionbanco.entity;

public class Turno {
    private String codigo;
    private int usuario_id;
    private int servicio_id;
    private int prioridad_id;
    private String estado;
    private String fecha;
    private String hora;

    public Turno(String codigo, int usuario_id, int servicio_id, int prioridad_id, String estado, String fecha, String hora) {
        this.codigo = codigo;
        this.usuario_id = usuario_id;
        this.servicio_id = servicio_id;
        this.prioridad_id = prioridad_id;
        this.estado = estado;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getServicio_id() {
        return servicio_id;
    }

    public void setServicio_id(int servicio_id) {
        this.servicio_id = servicio_id;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int cliente_id) {
        this.usuario_id = cliente_id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPrioridad_id() {
        return prioridad_id;
    }

    public void setPrioridad_id(int prioridad_id) {
        this.prioridad_id = prioridad_id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ticket{");
        sb.append("codigo=").append(codigo);
        sb.append(", fecha=").append(fecha);
        sb.append(", hora=").append(hora);
        sb.append(", servicio_id=").append(servicio_id);
        sb.append(", cliente_id=").append(usuario_id);
        sb.append(", estado=").append(estado);
        sb.append(", prioridad_id=").append(prioridad_id);
        sb.append('}');
        return sb.toString();
    }
    
}
