package structural.composite.antipattern;

public class FileSystem {
    static int totalSize(Object node) {
        if (node instanceof File f) {
            return f.size;
        } else if (node instanceof Folder d) {
            int sum = 0;
            for (Object child : d.children) {
                sum += totalSize(child);
            }
            return sum;
        } else throw new IllegalArgumentException("Unknown node type");
    }

    static void print(Object node, String indent) {
        if (node instanceof File f) {
            System.out.println(indent + "- " + f.name + " (" + f.size + "B)");
        } else if (node instanceof Folder d) {
            System.out.println(indent + "+ " + d.name + "/");
            for (Object child : d.children) {
                print(child, indent + "  ");
            }
        } else throw new IllegalArgumentException("Unknown node type");
    }

//    Why it hurts?
//    List<Object> breaks type safety.
//    Every new operation repeats the same instanceof logic → shotgun surgery.
//    Hard to extend without touching many places.
}
