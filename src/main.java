import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static PersonManager manager = new PersonManager();

    public static void main(String[] args) {
        System.out.println("=== CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN VÀ GIẢNG VIÊN ===\n");

        while (true) {
            System.out.println("\n=== MENU CHÍNH ===");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Thêm giảng viên");
            System.out.println("3. Hiển thị tất cả");
            System.out.println("4. Cập nhật thông tin");
            System.out.println("5. Xóa người");
            System.out.println("0. Thoát");
            
            int choice;
            while (true) {
                try {
                    choice = Integer.parseInt(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Vui lòng nhập số hợp lệ!");
                }
            }

            switch (choice) {
                case 1:
                    manager.addStudent();
                    break;
                case 2:
                    manager.addTeacher();
                    break;
                case 3:
                    manager.displayAllPeople();
                    break;
                case 4:
                    manager.updatePerson();
                    break;
                case 5:
                    manager.deletePerson();
                    break;
                case 0:
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
            }
        }
    }
}