
import java.util.Scanner;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);

        System.out.print("Nhap ho va ten: ");
        String hoTen = sc.nextLine();

        System.out.println("Ho va ten cua ban la: " + hoTen);

        sc.close();
    }
}
