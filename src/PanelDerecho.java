import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelDerecho extends JPanel {

    private JLabel lblTotal;
    private JLabel lblCompletadas;
    private JLabel lblPendientes;
    private JProgressBar barraProgreso;
    private ArrayList<Tarea> listaTareas;
    private PanelCentral panelCentral;

    public PanelDerecho(ArrayList<Tarea> listaTareas, PanelCentral panelCentral) {
        this.listaTareas = listaTareas;
        this.panelCentral = panelCentral;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(240, 240, 250));
        setPreferredSize(new Dimension(220, 0));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblTitulo = new JLabel("Estadísticas");
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        lblTotal = new JLabel();
        lblCompletadas = new JLabel();
        lblPendientes = new JLabel();

        lblTotal.setFont(new Font("SansSerif", Font.PLAIN, 14));
        lblCompletadas.setFont(new Font("SansSerif", Font.PLAIN, 14));
        lblPendientes.setFont(new Font("SansSerif", Font.PLAIN, 14));

        barraProgreso = new JProgressBar(0, 100);
        barraProgreso.setStringPainted(true);
        barraProgreso.setForeground(new Color(100, 95, 255));

        add(lblTitulo);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(lblTotal);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(lblCompletadas);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(lblPendientes);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(barraProgreso);

        //temporizador para actualizar estadísticas cada 0.5 segundos
        Timer timer = new Timer(500, e -> actualizarEstadisticas());
        timer.start();
    }

    private void actualizarEstadisticas() {
        int total = listaTareas.size();
        long completadas = listaTareas.stream().filter(Tarea::isCompletada).count();
        long pendientes = total - completadas;
        int porcentaje = total == 0 ? 0 : (int) ((completadas * 100) / total);

        lblTotal.setText("Total: " + total);
        lblCompletadas.setText("Completadas: " + completadas);
        lblPendientes.setText("Pendientes: " + pendientes);
        barraProgreso.setValue(porcentaje);
    }
}
