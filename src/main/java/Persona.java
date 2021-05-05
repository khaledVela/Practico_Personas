import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class Persona {
    private String nombre;
    private int edad;
     int altura;
    private boolean sex = false;
    int x,y;
    private int two;
    private int tree;
    private String genero;
    private PropertyChangeSupport observed;
    private final static Logger logger = (Logger) LogManager.getRootLogger();

    public Persona() {
        observed = new PropertyChangeSupport(this);
    }

    public Persona(String nombre, int edad, int altura, String genero,int x) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
        two = (int) (altura * 0.25);
        this.x=x;
        tree = (int) (altura * 0.35);
        this.genero = genero;
        logger.debug("Nombre: " + nombre + " Edad: " + edad + " Altura: " + altura + " Genero: " + genero);
        observed = new PropertyChangeSupport(this);
    }

    public void addObserver(PropertyChangeListener panel) {
        observed.addPropertyChangeListener(panel);
    }

    public void dibujar(Graphics g) {
        y=400-altura;
        g.setColor(Color.black);
        g.drawOval(x, y, two, two);//cabeza
        g.drawLine(x+two / 2,y +two, x+two / 2, y+tree + two);//torso
        g.drawLine(x, y+ two + tree / 2, two+x,y+ two + tree / 2);//brazo
        g.drawLine(x+two / 2,y+ two + tree, x,y+ altura);//pierna
        g.drawLine(x+two / 2,y+ two + tree, x+two, y+altura);//pierna

    }

    public void cambioOk() {
        observed.firePropertyChange("Imagen", 1, 2);
    }

}