import javax.swing.*;
import java.awt.*;

public class PanelIzquierdo extends JPanel {

    public PanelIzquierdo(PanelCentral panelCentral) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(80, 75, 220)); //violeta oscuro

        add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel lblTitulo = new JLabel("Mis Tareas");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 24));
        lblTitulo.setAlignmentX(CENTER_ALIGNMENT);
        add(lblTitulo);

        add(Box.createRigidArea(new Dimension(0, 30)));

        //botón con menú desplegable para ordenar por prioridad
        JButton btnOrdenarPrioridad = crearBotonMenu("Ordenar por prioridad");
        JPopupMenu menuOrdenar = new JPopupMenu();

        JMenuItem altaABaja = crearMenuItem("Alta a baja", panelCentral, true);
        JMenuItem bajaAAlta = crearMenuItem("Baja a alta", panelCentral, false);

        menuOrdenar.add(altaABaja);
        menuOrdenar.add(bajaAAlta);

        btnOrdenarPrioridad.addActionListener(e -> {
            menuOrdenar.show(btnOrdenarPrioridad, 0, btnOrdenarPrioridad.getHeight());
        });

        add(btnOrdenarPrioridad);

        add(Box.createRigidArea(new Dimension(0, 10)));

        JButton btnCompletadas = crearBotonMenu("Completadas");
        JButton btnPendientes = crearBotonMenu("Pendientes");
        JButton btnTodas = crearBotonMenu("Todas");

        btnCompletadas.addActionListener(e -> panelCentral.filtrar("completadas"));
        btnPendientes.addActionListener(e -> panelCentral.filtrar("pendientes"));
        btnTodas.addActionListener(e -> panelCentral.filtrar("todas"));

        add(btnCompletadas);
        add(btnPendientes);
        add(btnTodas);
        add(Box.createVerticalGlue());

        JButton salir = crearBotonMenu("Salir");
        salir.addActionListener(e -> System.exit(0));
        add(salir);

        add(Box.createRigidArea(new Dimension(0, 20)));
    }

    private JButton crearBotonMenu(String texto) {
        JButton btn = new JButton(texto);
        btn.setMaximumSize(new Dimension(180, 40));
        btn.setAlignmentX(CENTER_ALIGNMENT);
        btn.setBackground(new Color(100, 95, 255));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setFont(new Font("SansSerif", Font.PLAIN, 14));
        return btn;
    }

    private JMenuItem crearMenuItem(String texto, PanelCentral panelCentral, boolean ordenarAlta) {
        JMenuItem item = new JMenuItem(texto);
        item.setFont(new Font("SansSerif", Font.PLAIN, 14));
        item.setBackground(new Color(100, 95, 255));
        item.setForeground(Color.WHITE);
        item.setOpaque(true);
        item.setFocusPainted(false);
        item.addActionListener(e -> {
            if (ordenarAlta) {
                panelCentral.ordenarPorPrioridad();
            } else {
                panelCentral.ordenarPorPrioridadInversa();
            }
        });
        //para que el color de fondo se mantenga al seleccionar el item
        item.addChangeListener(event -> {
            JMenuItem source = (JMenuItem) event.getSource();
            ButtonModel model = source.getModel();
            if (model.isArmed() || model.isSelected()) {
                source.setBackground(new Color(80, 75, 220));
            } else {
                source.setBackground(new Color(100, 95, 255));
            }
        });
        return item;
    }
}
