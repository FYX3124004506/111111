package SystemWeek1;

public class Students {
    private int student_id;
    private int user_id;
    private String student_name;
    private String gender;
    private String class_info;
    private String phoneNumber;

    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", user_id=" + user_id +
                ", student_name='" + student_name + '\'' +
                ", gender='" + gender + '\'' +
                ", class_info='" + class_info + '\'' +
                ", phoneNumber='" + phoneNumber+ '\'' +
                '}';
    }

    public Students() {
    }

    public Students(int student_id, int user_id, String student_name, String gender, String class_info, String phonenumber) {
        this.student_id = student_id;
        this.user_id = user_id;
        this.student_name = student_name;
        this.gender = gender;
        this.class_info = class_info;
        this.phoneNumber = phonenumber;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getClass_info() {
        return class_info;
    }

    public void setClass_info(String class_info) {
        this.class_info = class_info;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}