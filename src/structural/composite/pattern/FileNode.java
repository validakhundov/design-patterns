package structural.composite.pattern;

public abstract class FileNode {
    String name;
    Integer size;

    abstract Integer getSize();

    abstract void print(String indent);
}
