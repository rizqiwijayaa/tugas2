
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class WriteTextFile {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan kalimat = ");
        String kalimat = scanner.nextLine();

        tulisKeFile(kalimat);

        scanner.close();
    }

    private static void tulisKeFile(String teks) {

        try {
            FileOutputStream file = new FileOutputStream("praktek1.txt");

            byte[] data = teks.getBytes();
            file.write(data);

            file.close();

            System.out.println("pengiriman data berhasil");

        } catch (IOException e) {
            System.out.println("Pengiriman data tidak berhasil");
        }
    }
}
```
