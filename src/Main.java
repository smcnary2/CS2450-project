import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //create machine obj
        var m1 = new Machine();

        //file chooser
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select a Text File with ML Data");
        fileChooser.showOpenDialog(null);
        m1.parse(fileChooser.getSelectedFile());

        //machine.run
        m1.run();
    }
}