package co.edu.gestionbanco.entity;

public class Turno {
    private String codigo;
    private String fecha;
    private String hora;
    private int servicio_id;
    private int cliente_id;
    private String estado;
    private int prioridad_id;

    public Turno(String codigo, String fecha, String hora, int servicio_id, int cliente_id, String estado, int prioridad_id) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.hora = hora;
        this.servicio_id = servicio_id;
        this.cliente_id = cliente_id;
        this.estado = estado;
        this.prioridad_id = prioridad_id;
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

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
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
        sb.append(", cliente_id=").append(cliente_id);
        sb.append(", estado=").append(estado);
        sb.append(", prioridad_id=").append(prioridad_id);
        sb.append('}');
        return sb.toString();
    }
    
}
