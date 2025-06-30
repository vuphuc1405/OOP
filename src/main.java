import java.util.Scanner;
import java.util.ArrayList;

abstract class Person {
    private String name;
    private int age;
    private String address;

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public abstract void displayRole();

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
    }
}

class Student extends Person {
    private String studentId;
    private double gpa;

    public Student(String name, int age, String address, String studentId, double gpa) {
        super(name, age, address);
        this.studentId = studentId;
        this.gpa = gpa;
    }

    public String getStudentId() {
        return studentId;
    }

    public double getGpa() {
        return gpa;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setGpa(double gpa) {
        if (gpa >= 0.0 && gpa <= 4.0) {
            this.gpa = gpa;
        }
    }

    @Override
    public void displayRole() {
        System.out.println("Vai trò: Sinh viên");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Mã sinh viên: " + studentId);
        System.out.println("GPA: " + gpa);
        displayRole();
    }
}

class Teacher extends Person {
    private String teacherId;
    private double salary;

    public Teacher(String name, int age, String address, String teacherId, double salary) {
        super(name, age, address);
        this.teacherId = teacherId;
        this.salary = salary;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public double getSalary() {
        return salary;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        }
    }

    @Override
    public void displayRole() {
        System.out.println("Vai trò: Giảng viên");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Mã giảng viên: " + teacherId);
        System.out.println("Lương: " + String.format("%.0f", salary) + " VND");
        displayRole();
    }
}

public class main {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Person> people = new ArrayList<>();

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
                    addStudent();
                    break;
                case 2:
                    addTeacher();
                    break;
                case 3:
                    displayAllPeople();
                    break;
                case 4:
                    updatePerson();
                    break;
                case 5:
                    deletePerson();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
            }
        }
    }

    private static void addStudent() {
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

    private static void addTeacher() {
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

    private static void displayAllPeople() {
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

    private static void updatePerson() {
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

    private static void deletePerson() {
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

}