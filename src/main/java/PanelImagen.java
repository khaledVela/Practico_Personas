import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class PanelImagen extends JPanel implements PropertyChangeListener {
    private static final long serialVersionUID = 1L;
    ListaOrdenada<Persona> lista = new ListaOrdenada<>();
    private Persona imagen;
    private final static Logger logger = (Logger) LogManager.getRootLogger();
    public PanelImagen(Persona img) {
        imagen = img;
        setBackground(Color.gray);
    }

    public void setImagen(Persona imagen) {
        this.imagen =imagen;
        lista.insertar(imagen);
        logger.debug("Confirmo lo de antes");
    }
    public void Eliminar(){
        ListaOrdenada<Persona> eliminar = new ListaOrdenada<>();
        lista=eliminar;
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1000, 400);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Iterator<Persona> iterador= lista.iterator();
        int x=0;
        super.paintComponent(g);
        while (iterador.hasNext()){
            imagen=iterador.next();
            imagen.setF(x);
            imagen.dibujar(g);
            x++;
        }
        repaint();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        repaint();
    }
}