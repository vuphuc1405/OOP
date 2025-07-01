import java.util.Scanner;
import java.util.ArrayList;

public class PersonManager {
    private Scanner sc;
    private ArrayList<Person> people;

    public PersonManager() {
        this.sc = new Scanner(System.in);
        this.people = new ArrayList<>();
    }

    public void addStudent() {
        System.out.println("\n--- THÊM SINH VIÊN ---");

        System.out.print("Nhập tên: ");
        String name = sc.nextLine();

        int age;
        while (true) {
            System.out.print("Nhập tuổi: ");
            try {
                age = Integer.parseInt(sc.nextLine());
                if (age > 0)
                    break;
                else
                    System.out.println("Tuổi phải lớn hơn 0!");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        }

        System.out.print("Nhập địa chỉ: ");
        String address = sc.nextLine();

        System.out.print("Nhập mã sinh viên: ");
        String studentId = sc.nextLine();

        double gpa;
        while (true) {
            System.out.print("Nhập GPA (0.0 - 4.0): ");
            try {
                gpa = Double.parseDouble(sc.nextLine());
                if (gpa >= 0.0 && gpa <= 4.0)
                    break;
                else
                    System.out.println("GPA phải từ 0.0 đến 4.0!");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số thực hợp lệ!");
            }
        }

        Student student = new Student(name, age, address, studentId, gpa);
        people.add(student);

        System.out.println("Đã thêm sinh viên thành công!");
        student.displayInfo();
    }

    public void addTeacher() {
        System.out.println("\n--- THÊM GIẢNG VIÊN ---");

        System.out.print("Nhập tên: ");
        String name = sc.nextLine();

        int age;
        while (true) {
            System.out.print("Nhập tuổi: ");
            try {
                age = Integer.parseInt(sc.nextLine());
                if (age > 0)
                    break;
                else
                    System.out.println("Tuổi phải lớn hơn 0!");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        }

        System.out.print("Nhập địa chỉ: ");
        String address = sc.nextLine();

        System.out.print("Nhập mã giảng viên: ");
        String teacherId = sc.nextLine();

        double salary;
        while (true) {
            System.out.print("Nhập lương: ");
            try {
                salary = Double.parseDouble(sc.nextLine());
                if (salary >= 0)
                    break;
                else
                    System.out.println("Lương phải lớn hơn 0!");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số thực hợp lệ!");
            }
        }

        Teacher teacher = new Teacher(name, age, address, teacherId, salary);
        people.add(teacher);

        System.out.println("Đã thêm giảng viên thành công!");
        teacher.displayInfo();
    }

    public void displayAllPeople() {
        if (people.isEmpty()) {
            System.out.println("Chưa có ai trong danh sách!");
            return;
        }

        System.out.println("\n--- DANH SÁCH TẤT CẢ ---");
        for (int i = 0; i < people.size(); i++) {
            System.out.println("\n" + (i + 1) + ". ");
            people.get(i).displayInfo();
            System.out.println("-------------------");
        }
    }

    public void updatePerson() {
        if (people.isEmpty()) {
            System.out.println("Chưa có ai trong danh sách!");
            return;
        }

        displayAllPeople();
        int index;
        while (true) {
            System.out.print("Chọn số thứ tự để cập nhật (1-" + people.size() + "): ");
            try {
                index = Integer.parseInt(sc.nextLine()) - 1;
                if (index >= 0 && index < people.size())
                    break;
                else
                    System.out.println("Số thứ tự không hợp lệ!");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        }

        Person person = people.get(index);
        System.out.println("\n--- CẬP NHẬT THÔNG TIN ---");

        System.out.print("Nhập tên mới (hiện tại: " + person.getName() + "): ");
        String newName = sc.nextLine();
        if (!newName.trim().isEmpty()) {
            person.setName(newName);
        }

        int newAge;
        while (true) {
            System.out.print("Nhập tuổi mới (hiện tại: " + person.getAge() + "): ");
            try {
                newAge = Integer.parseInt(sc.nextLine());
                if (newAge > 0)
                    break;
                else
                    System.out.println("Tuổi phải lớn hơn 0!");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        }
        person.setAge(newAge);

        System.out.print("Nhập địa chỉ mới (hiện tại: " + person.getAddress() + "): ");
        String newAddress = sc.nextLine();
        if (!newAddress.trim().isEmpty()) {
            person.setAddress(newAddress);
        }

        if (person instanceof Student) {
            Student student = (Student) person;
            double newGpa;
            while (true) {
                System.out.print("Nhập GPA mới (hiện tại: " + student.getGpa() + "): ");
                try {
                    newGpa = Double.parseDouble(sc.nextLine());
                    if (newGpa >= 0.0 && newGpa <= 4.0)
                        break;
                    else
                        System.out.println("GPA phải từ 0.0 đến 4.0!");
                } catch (NumberFormatException e) {
                    System.out.println("Vui lòng nhập số thực hợp lệ!");
                }
            }
            student.setGpa(newGpa);
        } else if (person instanceof Teacher) {
            Teacher teacher = (Teacher) person;
            double newSalary;
            while (true) {
                System.out.print("Nhập lương mới (hiện tại: " + teacher.getSalary() + "): ");
                try {
                    newSalary = Double.parseDouble(sc.nextLine());
                    if (newSalary >= 0)
                        break;
                    else
                        System.out.println("Lương phải lớn hơn 0!");
                } catch (NumberFormatException e) {
                    System.out.println("Vui lòng nhập số thực hợp lệ!");
                }
            }
            teacher.setSalary(newSalary);
        }

        System.out.println("Cập nhật thành công!");
        person.displayInfo();
    }

    public void deletePerson() {
        if (people.isEmpty()) {
            System.out.println("Chưa có ai trong danh sách!");
            return;
        }

        displayAllPeople();
        int index;
        while (true) {
            System.out.print("Chọn số thứ tự để xóa (1-" + people.size() + "): ");
            try {
                index = Integer.parseInt(sc.nextLine()) - 1;
                if (index >= 0 && index < people.size())
                    break;
                else
                    System.out.println("Số thứ tự không hợp lệ!");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        }

        Person person = people.get(index);
        System.out.print("Bạn có chắc chắn muốn xóa " + person.getName() + "? (y/n): ");
        String confirm = sc.nextLine();

        if (confirm.equalsIgnoreCase("y") || confirm.equalsIgnoreCase("yes")) {
            people.remove(index);
            System.out.println("Đã xóa thành công!");
        } else {
            System.out.println("Hủy thao tác xóa.");
        }
    }

    public boolean isEmpty() {
        return people.isEmpty();
    }

    public int size() {
        return people.size();
    }
}
