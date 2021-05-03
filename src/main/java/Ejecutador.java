import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class Ejecutador {
    private final static Logger logger = (Logger) LogManager.getRootLogger();
    public static void main(String[] args) {
        Visual visu = new Visual();
        visu.setVisible(true);
        logger.debug("Corro el programa");
    }
}