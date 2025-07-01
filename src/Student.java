// kế thừa
public class Student extends Person {
    // đóng gói
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

    // đa hình
    @Override
    public void displayRole() {
        System.out.println("Vai trò: Sinh viên");
    }

    // đa hình
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Mã sinh viên: " + studentId);
        System.out.println("GPA: " + gpa);
        displayRole();
    }
}