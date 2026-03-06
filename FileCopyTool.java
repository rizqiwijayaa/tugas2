import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopyTool {

    public static void main(String[] args) {

        JFileChooser chooser = new JFileChooser();

        // memilih file sumber
        int openResult = chooser.showOpenDialog(null);
        if (openResult != JFileChooser.APPROVE_OPTION) {
            return;
        }

        File fileAsal = chooser.getSelectedFile();

        // memilih lokasi file tujuan
        int saveResult = chooser.showSaveDialog(null);
        if (saveResult != JFileChooser.APPROVE_OPTION) {
            return;
        }

        File fileTujuan = chooser.getSelectedFile();

        salinFile(fileAsal, fileTujuan);
    }

    private static void salinFile(File asal, File tujuan) {

        try {

            FileInputStream input = new FileInputStream(asal);
            FileOutputStream output = new FileOutputStream(tujuan);

            byte[] buffer = new byte[1024];
            int jumlahByte;

            while ((jumlahByte = input.read(buffer)) > 0) {
                output.write(buffer, 0, jumlahByte);
            }

            input.close();
            output.close();

            JOptionPane.showMessageDialog(null,
                    "File berhasil disalin!\n\nSumber : "
                            + asal.getAbsolutePath()
                            + "\nTujuan : "
                            + tujuan.getAbsolutePath());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menyalin file.");
        }
    }
}
```
