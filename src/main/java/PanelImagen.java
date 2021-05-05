import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class PanelImagen extends JPanel implements PropertyChangeListener {
    private static final long serialVersionUID = 1L;
    private Persona imagen;
    private final static Logger logger = (Logger) LogManager.getRootLogger();
    public PanelImagen(Persona img) {
        imagen = img;
    }

    public void setImagen(Persona imagen) {
        this.imagen = imagen;
        imagen.cambioOk();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1000, 400);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        imagen.dibujar(g);
        logger.debug(imagen.altura);
        imagen.cambioOk();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        repaint();
    }
}