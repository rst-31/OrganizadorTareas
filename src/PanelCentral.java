import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class PanelCentral extends JPanel {

    private JTextField txtNombre;
    private JComboBox<String> comboPrioridad;
    private JList<Tarea> listaTareasUI;
    private DefaultListModel<Tarea> modeloLista;
    private ArrayList<Tarea> listaTareas;

    public PanelCentral(ArrayList<Tarea> listaTareas) {
        this.listaTareas = listaTareas;
        setLayout(new BorderLayout(10, 10));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Panel superior con GridBagLayout para mejor control
        JPanel panelEntrada = new JPanel(new GridBagLayout());
        panelEntrada.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        txtNombre = new JTextField(30);
        comboPrioridad = new JComboBox<>(new String[]{"Alta", "Media", "Baja"});

        JButton btnAgregar = new JButton("Agregar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnCompletar = new JButton("Completada");

        //etiqueta "Tarea:"
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        panelEntrada.add(new JLabel("Tarea:"), gbc);

        //campo de texto para el nombre de la tarea (se expande horizontalmente)
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelEntrada.add(txtNombre, gbc);

        //etiqueta "Prioridad:"
        gbc.gridx = 2;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        panelEntrada.add(new JLabel("Prioridad:"), gbc);

        //combo para la prioridad
        gbc.gridx = 3;
        panelEntrada.add(comboPrioridad, gbc);

        //botón Agregar
        gbc.gridx = 4;
        panelEntrada.add(btnAgregar, gbc);

        //botón Eliminar
        gbc.gridx = 5;
        panelEntrada.add(btnEliminar, gbc);

        //botón Completada
        gbc.gridx = 6;
        panelEntrada.add(btnCompletar, gbc);

        add(panelEntrada, BorderLayout.NORTH);

        //lista para mostrar tareas
        modeloLista = new DefaultListModel<>();
        listaTareasUI = new JList<>(modeloLista);
        listaTareasUI.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaTareasUI.setFont(new Font("Monospaced", Font.PLAIN, 13));
        add(new JScrollPane(listaTareasUI), BorderLayout.CENTER);

        //eventos
        btnAgregar.addActionListener(e -> agregarTarea());
        btnEliminar.addActionListener(e -> eliminarTarea());
        btnCompletar.addActionListener(e -> completarTareaSeleccionada());

        actualizarArea();
    }

    private void agregarTarea() {
        String nombre = txtNombre.getText().trim();
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el nombre de la tarea.");
            return;
        }
        int prioridad = comboPrioridad.getSelectedIndex() + 1;
        listaTareas.add(new Tarea(nombre, prioridad));
        txtNombre.setText("");
        actualizarArea();
    }

    private void eliminarTarea() {
        Tarea tareaSeleccionada = listaTareasUI.getSelectedValue();
        if (tareaSeleccionada != null) {
            listaTareas.remove(tareaSeleccionada);
            actualizarArea();
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una tarea para eliminar.");
        }
    }

    private void completarTareaSeleccionada() {
        Tarea tareaSeleccionada = listaTareasUI.getSelectedValue();
        if (tareaSeleccionada != null) {
            tareaSeleccionada.setCompletada(true);
            actualizarArea();
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una tarea para marcar como completada.");
        }
    }

    public void actualizarArea() {
        modeloLista.clear();
        for (Tarea t : listaTareas) {
            modeloLista.addElement(t);
        }
    }

    public void filtrar(String tipo) {
        modeloLista.clear();
        for (Tarea t : listaTareas) {
            if (tipo.equals("todas") ||
                    (tipo.equals("completadas") && t.isCompletada()) ||
                    (tipo.equals("pendientes") && !t.isCompletada())) {
                modeloLista.addElement(t);
            }
        }
    }

    public void ordenarPorPrioridad() {
        listaTareas.sort(Comparator.comparingInt(Tarea::getPrioridad));
        actualizarArea();
    }

    //ordenar prioridad de baja a alta (3 → 1)
    public void ordenarPorPrioridadInversa() {
        listaTareas.sort(Comparator.comparingInt(Tarea::getPrioridad).reversed());
        actualizarArea();
    }
}
