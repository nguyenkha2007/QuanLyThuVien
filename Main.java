
import java.util.Scanner;
import java.util.ArrayList;

class Sach {
    String maSach, nhaXuatBan;
    int ngay, thang, nam;
    double donGia;
    int soLuong;

    void nhap(Scanner sc) {
        System.out.print("Ma sach: ");
        maSach = sc.nextLine();

        System.out.print("Ngay: ");
        ngay = sc.nextInt();

        System.out.print("Thang: ");
        thang = sc.nextInt();

        System.out.print("Nam: ");
        nam = sc.nextInt();

        System.out.print("Don gia: ");
        donGia = sc.nextDouble();

        System.out.print("So luong: ");
        soLuong = sc.nextInt();
        sc.nextLine();

        System.out.print("Nha xuat ban: ");
        nhaXuatBan = sc.nextLine();
    }

    void xuat() {
        System.out.println("Ma sach: " + maSach);
        System.out.println("Ngay nhap: " + ngay + "/" + thang + "/" + nam);
        System.out.println("Don gia: " + donGia);
        System.out.println("So luong: " + soLuong);
        System.out.println("Nha xuat ban: " + nhaXuatBan);
    }
}

class SachGiaoKhoa extends Sach {
    String tinhTrang;

    void nhap(Scanner sc) {
        super.nhap(sc);

        do {
            System.out.print("Tinh trang (moi/cu): ");
            tinhTrang = sc.nextLine();
        } while (!tinhTrang.equalsIgnoreCase("moi")
                && !tinhTrang.equalsIgnoreCase("cu"));
    }

    double thanhTien() {
        if (tinhTrang.equalsIgnoreCase("moi"))
            return soLuong * donGia;
        else
            return soLuong * donGia * 0.5;
    }

    void xuat() {
        super.xuat();
        System.out.println("Tinh trang: " + tinhTrang);
        System.out.println("Thanh tien: " + thanhTien());
    }
}

class SachThamKhao extends Sach {
    double thue;

    void nhap(Scanner sc) {
        super.nhap(sc);

        System.out.print("Thue: ");
        thue = sc.nextDouble();
        sc.nextLine();
    }

    double thanhTien() {
        return soLuong * donGia + thue;
    }

    void xuat() {
        super.xuat();
        System.out.println("Thue: " + thue);
        System.out.println("Thanh tien: " + thanhTien());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<SachGiaoKhoa> ds1 = new ArrayList<>();
        ArrayList<SachThamKhao> ds2 = new ArrayList<>();

        int n;

        System.out.print("Nhap so sach giao khoa: ");
        n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nSach giao khoa thu " + (i + 1));
            SachGiaoKhoa s = new SachGiaoKhoa();
            s.nhap(sc);
            ds1.add(s);
        }

        System.out.print("\nNhap so sach tham khao: ");
        n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nSach tham khao thu " + (i + 1));
            SachThamKhao s = new SachThamKhao();
            s.nhap(sc);
            ds2.add(s);
        }

        double tong1 = 0;
        double tong2 = 0;
        double tongGia = 0;

        System.out.println("\nDANH SACH SACH GIAO KHOA");

        for (SachGiaoKhoa s : ds1) {
            s.xuat();
            tong1 += s.thanhTien();
            System.out.println("----------------");
        }

        System.out.println("Tong tien sach giao khoa: " + tong1);

        System.out.println("\nDANH SACH SACH THAM KHAO");

        for (SachThamKhao s : ds2) {
            s.xuat();
            tong2 += s.thanhTien();
            tongGia += s.donGia;
            System.out.println("----------------");
        }

        System.out.println("Tong tien sach tham khao: " + tong2);

        if (ds2.size() > 0) {
            System.out.println("Trung binh don gia: " + tongGia / ds2.size());
        }

        System.out.println("\nSACH GIAO KHOA CUA NHA XUAT BAN X");

        for (SachGiaoKhoa s : ds1) {
            if (s.nhaXuatBan.equalsIgnoreCase("X")) {
                s.xuat();
                System.out.println("----------------");
            }
        }

        sc.close();
    }
}
