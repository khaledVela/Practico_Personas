import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class Persona {
    private String nombre;
    private int edad;
     int altura = 500;
    private boolean sex = false;
    int x;
    private int two;
    private int tree;
    private String genero;
    private PropertyChangeSupport observed;
    private final static Logger logger = (Logger) LogManager.getRootLogger();

    public Persona() {
        two = (int) (altura * 0.25);
        tree = (int) (altura * 0.35);
        observed = new PropertyChangeSupport(this);
    }

    public Persona(String nombre, int edad, int altura, String genero) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
        two = (int) (altura * 0.25);
        tree = (int) (altura * 0.35);
        this.genero = genero;
        logger.debug("Nombre: " + nombre + " Edad: " + edad + " Altura: " + altura + " Genero: " + genero);
        observed = new PropertyChangeSupport(this);
    }

    public void addObserver(PropertyChangeListener panel) {
        observed.addPropertyChangeListener(panel);
    }

    public void dibujar(Graphics g) {
        g.setColor(Color.black);
        g.drawOval(x, 0, two, two);//cabeza
        g.drawLine(x+two / 2, +two, x+two / 2, +tree + two);//torso
        g.drawLine(x, two + tree / 2, two+x, two + tree / 2);//brazo
        g.drawLine(x+two / 2, two + tree, x, altura);
        g.drawLine(x+two / 2, two + tree, x+two, altura);

    }

    public void cambioOk() {
        observed.firePropertyChange("Imagen", 1, 2);
    }

}