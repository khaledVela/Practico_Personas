import java.util.Comparator;

public class Comparador implements Comparator<Persona>{
    @Override
    public int compare(Persona o1, Persona o2) {
        //if (o2.getNombre().equals(o1.getNombre())) {
        if (o2.getAltura() == o1.getAltura())
            return 0;
        if (o2.getAltura() < o1.getAltura())
            return -1;
        if (o2.getAltura() > o1.getAltura())
            return 1;
       // }
        return o2.getNombre().compareTo(o1.getNombre());
    }
}
