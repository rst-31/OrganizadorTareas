public class Tarea {
    private String nombre;
    private int prioridad; // 1 = Alta, 2 = Media, 3 = Baja
    private boolean completada;

    public Tarea(String nombre, int prioridad) {
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.completada = false;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    @Override
    public String toString() {
        String prioridadTexto = switch (prioridad) {
            case 1 -> "Alta";
            case 2 -> "Media";
            default -> "Baja";
        };
        return nombre + " | Prioridad: " + prioridadTexto + " | " + (completada ? "Completada" : "Pendiente");
    }
}
