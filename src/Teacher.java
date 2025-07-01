// kế thừa
public class Teacher extends Person {
    // đóng gói
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

    // đa hình
    @Override
    public void displayRole() {
        System.out.println("Vai trò: Giảng viên");
    }

    // đa hình
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Mã giảng viên: " + teacherId);
        System.out.println("Lương: " + String.format("%.0f", salary) + " VND");
        displayRole();
    }
}