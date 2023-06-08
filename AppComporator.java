package lessons.java.comparators;

import java.util.Comparator;

public class AppComporator<T> {
    public Comparator<T> comparator;
   public String name;

    public AppComporator(Comparator<T> comparator, String name) {
        this.comparator = comparator;
        this.name = name;
    }


}
