import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class PanelImagen extends JPanel implements PropertyChangeListener {
    private static final long serialVersionUID = 1L;
    ArrayList<Persona> lista = new ArrayList();
    private Persona imagen;
    private final static Logger logger = (Logger) LogManager.getRootLogger();
    public PanelImagen(Persona img) {
        imagen = img;
        setBackground(Color.gray);
    }

    public void setImagen(Persona imagen) {
        this.imagen =imagen;
        lista.add(imagen);
        logger.debug("añado al array");
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1000, 400);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < lista.toArray().length; i++) {
            lista.get(i).dibujar(g);
        }
        repaint();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        repaint();
    }
}