import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Dashboard extends JFrame {

    private ArrayList<Tarea> listaTareas;

    public Dashboard() {
        super("Panel de Tareas");

        listaTareas = new ArrayList<>();

        setLayout(new BorderLayout());
        setSize(1000, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        PanelCentral panelCentral = new PanelCentral(listaTareas);
        PanelIzquierdo panelIzquierdo = new PanelIzquierdo(panelCentral);
        PanelDerecho panelDerecho = new PanelDerecho(listaTareas, panelCentral);

        add(panelIzquierdo, BorderLayout.WEST);
        add(panelCentral, BorderLayout.CENTER);
        add(panelDerecho, BorderLayout.EAST);

        setVisible(true);
    }
}
