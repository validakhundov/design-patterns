package structural.composite.antipattern;

public class Main {
    public static void main(String[] args) {
        File reportPdf = new File("report.pdf", 1_200);
        File logoPng = new File("logo.png", 8_000);
        File readmeMd = new File("README.md", 600);

        Folder docs = new Folder("docs");
        Folder images = new Folder("images");

        Folder root = new Folder("root");

        images.add(logoPng);
        docs.add(reportPdf);

        root.add(docs);
        root.add(images);
        root.add(readmeMd);

        FileSystem.print(root, "");
        System.out.println("Total size: " + FileSystem.totalSize(root) + "B");
    }
}
