import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class Persona {
    private String nombre;
    private int edad;
    private int altura;
    private boolean sex = false;
    private int two;
    private int tree;
    private String genero;
    private PropertyChangeSupport observed;
    private final static Logger logger = (Logger) LogManager.getRootLogger();

    public Persona() {
        observed = new PropertyChangeSupport(this);
    }

    public Persona(String nombre, int edad, int altura, String genero) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
        two = (int) (altura * 0.25);
        tree = (int) (altura * 0.35);
        this.genero = genero;
        logger.debug("Nombre: "+ nombre+" Edad: " +edad+" Altura: "+ altura+" Genero: "+genero);
        observed = new PropertyChangeSupport(this);
    }

    public void addObserver(PropertyChangeListener panel) {
        observed.addPropertyChangeListener(panel);
    }

    public void dibujar(Graphics g) {
        g.setColor(Color.black);
        g.drawOval(0, 0, two, two);
        g.drawLine(two / 2, two, two / 2, tree);
        g.drawLine(0, two + tree / 2, two, two + tree / 2);
        g.drawLine(two / 2, two + tree, 0, altura);
        g.drawLine(two / 2, two + tree, two, altura);

    }

    public void cambioOk() {
        observed.firePropertyChange("Imagen", 1, 2);
    }

}