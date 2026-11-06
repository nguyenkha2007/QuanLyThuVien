
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static int[] soLuong = new int[5];

    static ArrayList<String> dsMaSach = new ArrayList<>();
    static ArrayList<String> danhSachSach = new ArrayList<>();

    static void bai1() {
        int tong = 0;
        int max = 0;

        System.out.println("NHAP SO LUONG 5 CUON SACH");

        for (int i = 0; i < 5; i++) {
            System.out.print("Nhap so luong sach thu " + (i + 1) + ": ");
            soLuong[i] = Integer.parseInt(sc.nextLine());
            tong += soLuong[i];

            if (i == 0 || soLuong[i] > max) {
                max = soLuong[i];
            }
        }

        System.out.println("So luong 5 cuon sach:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Sach " + (i + 1) + ": " + soLuong[i]);
        }

        System.out.println("Tong so luong: " + tong);
        System.out.println("So luong lon nhat: " + max);
    }

    static void themSach() {
        System.out.print("Nhap ma sach: ");
        String ma = sc.nextLine();

        if (dsMaSach.contains(ma)) {
            System.out.println("Ma sach da ton tai!");
            return;
        }

        System.out.print("Nhap ten sach: ");
        String ten = sc.nextLine();

        System.out.print("Nhap tac gia: ");
        String tacGia = sc.nextLine();

        System.out.print("Nhap nam xuat ban: ");
        String nam = sc.nextLine();

        System.out.print("Nhap don gia: ");
        String gia = sc.nextLine();

        System.out.print("Nhap so luong: ");
        String sl = sc.nextLine();

        String sach = ma + ";" + ten + ";" + tacGia + ";" + nam + ";" + gia + ";" + sl;

        danhSachSach.add(sach);
        dsMaSach.add(ma);

        System.out.println("Them sach thanh cong!");
    }

    static void hienThiSach() {
        if (danhSachSach.isEmpty()) {
            System.out.println("Danh sach sach trong!");
            return;
        }

        for (int i = 0; i < danhSachSach.size(); i++) {
            String[] sach = danhSachSach.get(i).split(";");

            System.out.println("\nSach thu " + (i + 1));
            System.out.println("Ma sach: " + sach[0]);
            System.out.println("Ten sach: " + sach[1]);
            System.out.println("Tac gia: " + sach[2]);
            System.out.println("Nam xuat ban: " + sach[3]);
            System.out.println("Don gia: " + sach[4]);
            System.out.println("So luong: " + sach[5]);
        }
    }

    static int timSach(String ma) {
        for (int i = 0; i < dsMaSach.size(); i++) {
            if (dsMaSach.get(i).equalsIgnoreCase(ma)) {
                return i;
            }
        }

        return -1;
    }

    static void timSach() {
        System.out.print("Nhap ma sach can tim: ");
        String ma = sc.nextLine();

        int vt = timSach(ma);

        if (vt == -1) {
            System.out.println("Khong tim thay sach!");
        } else {
            String[] sach = danhSachSach.get(vt).split(";");

            System.out.println("Ma sach: " + sach[0]);
            System.out.println("Ten sach: " + sach[1]);
            System.out.println("Tac gia: " + sach[2]);
            System.out.println("Nam xuat ban: " + sach[3]);
            System.out.println("Don gia: " + sach[4]);
            System.out.println("So luong: " + sach[5]);
        }
    }

    static void xoaSach() {
        System.out.print("Nhap ma sach can xoa: ");
        String ma = sc.nextLine();

        int vt = timSach(ma);

        if (vt == -1) {
            System.out.println("Khong tim thay sach!");
        } else {
            dsMaSach.remove(vt);
            danhSachSach.remove(vt);
            System.out.println("Xoa sach thanh cong!");
        }
    }

    static void suaSach() {
        System.out.print("Nhap ma sach can sua: ");
        String ma = sc.nextLine();

        int vt = timSach(ma);

        if (vt == -1) {
            System.out.println("Khong tim thay sach!");
            return;
        }

        System.out.print("Nhap ten sach moi: ");
        String ten = sc.nextLine();

        System.out.print("Nhap tac gia moi: ");
        String tacGia = sc.nextLine();

        System.out.print("Nhap nam xuat ban moi: ");
        String nam = sc.nextLine();

        System.out.print("Nhap don gia moi: ");
        String gia = sc.nextLine();

        System.out.print("Nhap so luong moi: ");
        String sl = sc.nextLine();

        String sach = ma + ";" + ten + ";" + tacGia + ";" + nam + ";" + gia + ";" + sl;

        danhSachSach.set(vt, sach);

        System.out.println("Sua sach thanh cong!");
    }

    static void tinhTongSoLuong() {
        int tong = 0;

        for (int i = 0; i < danhSachSach.size(); i++) {
            String[] sach = danhSachSach.get(i).split(";");
            tong += Integer.parseInt(sach[5]);
        }

        System.out.println("Tong so luong sach: " + tong);
    }

    static void tinhTongGiaTri() {
        double tong = 0;

        for (int i = 0; i < danhSachSach.size(); i++) {
            String[] sach = danhSachSach.get(i).split(";");

            double gia = Double.parseDouble(sach[4]);
            int sl = Integer.parseInt(sach[5]);

            tong += gia * sl;
        }

        System.out.println("Tong gia tri sach: " + tong);
    }

    public static void main(String[] args) {
        bai1();

        int chon;

        do {
            System.out.println("\n===== QUAN LY THU VIEN =====");
            System.out.println("1. Them sach");
            System.out.println("2. Hien thi sach");
            System.out.println("3. Tim sach");
            System.out.println("4. Xoa sach");
            System.out.println("5. Sua sach");
            System.out.println("6. Tinh tong so luong");
            System.out.println("7. Tinh tong gia tri");
            System.out.println("8. Thoat");
            System.out.print("Nhap lua chon: ");

            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    themSach();
                    break;
                case 2:
                    hienThiSach();
                    break;
                case 3:
                    timSach();
                    break;
                case 4:
                    xoaSach();
                    break;
                case 5:
                    suaSach();
                    break;
                case 6:
                    tinhTongSoLuong();
                    break;
                case 7:
                    tinhTongGiaTri();
                    break;
                case 8:
                    System.out.println("Ket thuc chuong trinh!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (chon != 8);
    }
}
