package structural.composite.pattern;

public class File extends FileNode {
    public File(String name, Integer size) {
        this.name = name;
        this.size = size;
    }

    @Override
    Integer getSize() {
        return this.size;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "- " + name + " (" + size + "B)");
    }

}
