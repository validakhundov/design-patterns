package structural.composite.antipattern;

import java.util.ArrayList;
import java.util.List;

public class Folder {
    String name;
    List<Object> children = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(Object o) {
        children.add(o);
    }

    public void remove(Object o) {
        children.remove(o);
    }
}
