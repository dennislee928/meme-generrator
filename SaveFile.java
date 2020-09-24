import java.awt.*;
import java.io.*;
import java.net.URI;

public class SaveFile {
    public static String save(String fileName) {
        FileDialog fileDialog = new FileDialog(new Frame(), "Save", FileDialog.SAVE);
        fileDialog.setFilenameFilter(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".png");
            }
        });
        fileDialog.setFile(fileName);
        fileDialog.setVisible(true);
        return fileDialog.getDirectory() + fileDialog.getFile();
    }
}