
import java.util.ArrayList;

class Sach {
    String maSach;
    String tieuDe;
    String tacGia;
    int namXuatBan;
    int soLuong;

    public void hienThiThongTin() {
        System.out.println("Ma sach: " + maSach);
        System.out.println("Tieu de: " + tieuDe);
        System.out.println("Tac gia: " + tacGia);
        System.out.println("Nam xuat ban: " + namXuatBan);
        System.out.println("So luong: " + soLuong);
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Sach> danhSachSach = new ArrayList<>();

        Sach s1 = new Sach();
        s1.maSach = "S01";
        s1.tieuDe = "Lap trinh Java";
        s1.tacGia = "Nguyen Van A";
        s1.namXuatBan = 2024;
        s1.soLuong = 10;

        Sach s2 = new Sach();
        s2.maSach = "S02";
        s2.tieuDe = "Lap trinh C++";
        s2.tacGia = "Nguyen Van B";
        s2.namXuatBan = 2023;
        s2.soLuong = 15;

        danhSachSach.add(s1);
        danhSachSach.add(s2);

        for (Sach s : danhSachSach) {
            s.hienThiThongTin();
            System.out.println("----------------");
        }
    }
}
