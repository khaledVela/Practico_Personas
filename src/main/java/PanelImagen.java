import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class PanelImagen extends JPanel implements PropertyChangeListener {
    private static final long serialVersionUID = 1L;
    Lista<Persona> lista = new Lista<Persona>();

    private Persona imagen;
    private final static Logger logger = (Logger) LogManager.getRootLogger();
    public PanelImagen(Persona img) {
        imagen = img;
        setBackground(Color.gray);
    }

    public void setImagen(Persona imagen) {
        this.imagen =imagen;
        lista.add(imagen);
        logger.debug("Confirmo lo de antes");
    }
    public void Eliminar(){
        Lista<Persona> eliminar = new Lista<Persona>();
        lista=eliminar;
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1000, 400);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Iterator<Persona> iterador= lista.iterator();
        super.paintComponent(g);
        while (iterador.hasNext()){
            imagen=iterador.next();
            imagen.dibujar(g);
        }
        repaint();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        repaint();
    }
}