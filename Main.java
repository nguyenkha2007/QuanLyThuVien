
import java.util.Scanner;

class Sach {
    String maSach, tenSach, tacGia;
    int namXuatBan, soLuong;
    double donGia;

    double thanhTien() {
        return donGia * soLuong;
    }
}

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Sach[] dsSach = new Sach[100];
    static int n = 0;

    static void nhapSach() {
        System.out.print("Nhap so luong sach: ");
        n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            dsSach[i] = new Sach();

            System.out.println("\nNhap sach thu " + (i + 1));

            System.out.print("Ma sach: ");
            dsSach[i].maSach = sc.nextLine();

            System.out.print("Ten sach: ");
            dsSach[i].tenSach = sc.nextLine();

            System.out.print("Tac gia: ");
            dsSach[i].tacGia = sc.nextLine();

            System.out.print("Nam xuat ban: ");
            dsSach[i].namXuatBan = sc.nextInt();

            System.out.print("Don gia: ");
            dsSach[i].donGia = sc.nextDouble();

            System.out.print("So luong: ");
            dsSach[i].soLuong = sc.nextInt();
            sc.nextLine();
        }
    }

    static void hienThi() {
        if (n == 0) {
            System.out.println("Chua co sach!");
            return;
        }

        for (int i = 0; i < n; i++) {
            System.out.println("\nSach thu " + (i + 1));
            System.out.println("Ma sach: " + dsSach[i].maSach);
            System.out.println("Ten sach: " + dsSach[i].tenSach);
            System.out.println("Tac gia: " + dsSach[i].tacGia);
            System.out.println("Nam xuat ban: " + dsSach[i].namXuatBan);
            System.out.println("Don gia: " + dsSach[i].donGia);
            System.out.println("So luong: " + dsSach[i].soLuong);
            System.out.println("Thanh tien: " + dsSach[i].thanhTien());
        }
    }

    static void tinhTong() {
        int tongSoLuong = 0;
        double tongGiaTri = 0;

        for (int i = 0; i < n; i++) {
            tongSoLuong += dsSach[i].soLuong;
            tongGiaTri += dsSach[i].thanhTien();
        }

        System.out.println("Tong so luong sach: " + tongSoLuong);
        System.out.println("Tong gia tri sach: " + tongGiaTri);
    }

    static void timSach() {
        sc.nextLine();

        System.out.print("Nhap ma sach can tim: ");
        String ma = sc.nextLine();

        boolean timThay = false;

        for (int i = 0; i < n; i++) {
            if (dsSach[i].maSach.equalsIgnoreCase(ma)) {
                System.out.println("Tim thay sach:");
                System.out.println("Ma sach: " + dsSach[i].maSach);
                System.out.println("Ten sach: " + dsSach[i].tenSach);
                System.out.println("Tac gia: " + dsSach[i].tacGia);
                System.out.println("Don gia: " + dsSach[i].donGia);
                System.out.println("So luong: " + dsSach[i].soLuong);
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay sach!");
        }
    }

    public static void main(String[] args) {
        int chon;

        do {
            System.out.println("\n===== QUAN LY THU VIEN =====");
            System.out.println("1. Nhap sach");
            System.out.println("2. Hien thi sach");
            System.out.println("3. Tinh tong so luong va gia tri sach");
            System.out.println("4. Tim sach theo ma");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");

            chon = sc.nextInt();

            switch (chon) {
                case 1:
                    nhapSach();
                    break;
                case 2:
                    hienThi();
                    break;
                case 3:
                    tinhTong();
                    break;
                case 4:
                    timSach();
                    break;
                case 0:
                    System.out.println("Ket thuc chuong trinh!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (chon != 0);
    }
}
