
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class VowelAnalyzer {

    public static void main(String[] args) {

        JFileChooser pilih = new JFileChooser();

        if (pilih.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
            return;
        }

        File file = pilih.getSelectedFile();

        int[] vokal = new int[5]; // a i u e o

        try {

            BufferedReader reader = new BufferedReader(new FileReader(file));
            int data;

            while ((data = reader.read()) != -1) {

                char huruf = Character.toLowerCase((char) data);

                if (huruf == 'a') vokal[0]++;
                else if (huruf == 'i') vokal[1]++;
                else if (huruf == 'u') vokal[2]++;
                else if (huruf == 'e') vokal[3]++;
                else if (huruf == 'o') vokal[4]++;
            }

            reader.close();

            JOptionPane.showMessageDialog(null,
                    "File: " + file.getName() +
                    "\nJumlah huruf a: " + vokal[0] +
                    "\ni: " + vokal[1] +
                    "\nu: " + vokal[2] +
                    "\ne: " + vokal[3] +
                    "\no: " + vokal[4]);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat membaca file.");
        }
    }
}
```
