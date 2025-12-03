package co.edu.gestionbanco.entity;

public class Turno implements Comparable<Turno> {
    private int id_turno;
    private String codigo;
    private int usuario_id;
    private int servicio_id;
    public TriagePrioridad prioridad;
    private String estado;
    private String fecha;
    private String hora;
    private int caja;

    public Turno(int id_turno,String codigo, int usuario_id, int servicio_id, TriagePrioridad prioridad, String estado, String fecha, String hora) {
        this.id_turno = id_turno;
        this.codigo = codigo;
        this.usuario_id = usuario_id;
        this.servicio_id = servicio_id;
        this.prioridad = prioridad;
        this.estado = estado;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Turno() {
    }

    public Turno(int id_turno, String estado) {
        this.id_turno = id_turno;
        this.estado = estado;
    }

    public int getCaja() {
        return caja;
    }

    public void setCaja(int caja) {
        this.caja = caja;
    }
    
    public int getId_turno() {
        return id_turno;
    }

    public void setId_turno(int id_turno) {
        this.id_turno = id_turno;
    }

    public TriagePrioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(TriagePrioridad prioridad) {
        this.prioridad = prioridad;
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
        sb.append(", prioridad_id=").append(prioridad);
        sb.append('}');
        return sb.toString();
    }
    
    @Override
    public int compareTo(Turno turno) {
       int currentLevel = this.prioridad.getLEVEL();
        int paramLevel = turno.prioridad.getLEVEL();
        return paramLevel - currentLevel;
    }
    
    
}
