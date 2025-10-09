package structural.composite.pattern;

import java.util.ArrayList;
import java.util.List;

public class Folder extends FileNode {
    List<FileNode> children;

    public Folder(String name) {
        this.name = name;
        children = new ArrayList<>();
    }

    public void add(FileNode fileNode) {
        children.add(fileNode);
    }

    @Override
    public Integer getSize() {
        int totalSize = 0;
        for (FileNode fn : children) {
            totalSize += fn.getSize();
        }
        return totalSize;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "+ " + name + "/");
        for (FileNode c : children) {
            c.print(indent + "  ");
        }
    }

}
