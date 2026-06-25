import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int soHv = 0;
        float tongDiem = 0;
        float diemCaoNhat = -1;
        float diemThapNhat = 11;

        do {
            System.out.println("\n****************** MENU NHẬP ĐIỂM ******************");
            System.out.println("1.   Nhập điểm học viên");
            System.out.println("2.   Hiển thị thống kê");
            System.out.println("3.   Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("--- Nhập điểm học viên (nhập -1 để dừng) ---");
                    float diem;
                    while (true) {
                        System.out.print("Nhập điểm: ");
                        diem = Float.parseFloat(scanner.nextLine());

                        if (diem == -1) {
                            break;
                        }

                        // 2. Kiểm tra điểm hợp lệ
                        if (diem < 0 || diem > 10) {
                            System.out.println("Điểm không hợp lệ. Nhập lại.");
                            continue;
                        }

                        soHv++;
                        tongDiem += diem;
                        if (diem < diemThapNhat) {
                            diemThapNhat = diem;
                        }
                        if (diem > diemCaoNhat) {
                            diemCaoNhat = diem;
                        }

                        // 4. Chỉ phân loại học lực để in ra
                        String hl = "";
                        if (diem < 5) {
                            hl = "Yếu";
                        } else if (diem < 7) {
                            hl = "Trung Bình";
                        } else if (diem < 8) {
                            hl = "Khá";
                        } else if (diem < 9) {
                            hl = "Giỏi";
                        } else {
                            hl = "Xuất sắc";
                        }
                        System.out.println("Học lực: " + hl);
                    }
                    break;

                case 2:
                    System.out.println("\n----- KẾT QUẢ -----");
                    if (soHv == 0) {
                        System.out.println("Chua co du lieu");
                    } else {
                        System.out.printf("Số học viên đã nhập: %d\n", soHv);
                        System.out.printf("Điểm trung bình: %.2f\n", tongDiem / soHv);
                        System.out.printf("Điểm cao nhất: %.2f\n", diemCaoNhat);
                        System.out.printf("Điểm thấp nhất: %.2f\n", diemThapNhat); //
                    }
                    break;

                case 3:
                    System.out.println("Kết thúc chương trình.");
                    System.exit(0);
            }
        } while (true);
    }
}