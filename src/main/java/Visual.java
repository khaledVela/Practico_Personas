import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Visual extends JFrame {
    private static final long serialVersionUID = 1L;
    private final static Logger logger = (Logger) LogManager.getRootLogger();
    private Persona modelo = new Persona();
    private PanelImagen panel = new PanelImagen(modelo);
    int x = 0;

    public Visual() {
        super("Practico 2");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        init();
    }

    public void init() {
        logger.debug("Creo menu");
        modelo.addObserver(panel);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panel, BorderLayout.CENTER);
        JMenuBar menuBar = new JMenuBar();
        JMenu mnuImagen = new JMenu("Personas");
        JMenuItem item = new JMenuItem("Nueva persona");
        JMenuItem item2 = new JMenuItem("Eliminar Todo");
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nuevaPeople();
            }
        });
        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.Eliminar();
            }
        });
        mnuImagen.add(item);
        mnuImagen.add(item2);
        menuBar.add(mnuImagen);
        this.setJMenuBar(menuBar);
        this.pack();
    }

    public void nuevaPeople() {
        JTextField nombreField = new JTextField();
        JTextField edadField = new JTextField();
        JTextField alturaField = new JTextField();
        JTextField generoField = new JTextField();
        Object[] message = {
                "Nombre: ", nombreField,
                "Edad: ", edadField,
                "Altura: ", alturaField,
                "Genero: ", generoField
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Nueva persona", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                int edad = Integer.parseInt(edadField.getText());
                int altura = Integer.parseInt(alturaField.getText());
                modelo = new Persona(nombreField.getText(), edad, altura, generoField.getText());
                panel.setImagen(modelo);
            } catch (Exception e) {
                logger.debug("Error: " + e);
            }
        }
    }
}

