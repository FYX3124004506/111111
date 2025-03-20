package SystemWeek1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Adminservices {
    // 1. 添加课程
    public void addCourse(Course course) throws SQLException {
        String sql = "INSERT INTO courses (course_name, credit, is_opened, timeplace, capacity, start_time) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Util.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, course.getCourse_name());
            pstmt.setInt(2, course.getCredit());
            pstmt.setInt(3, course.getIs_opened());
            pstmt.setString(4, course.getTimePlace());
            pstmt.setInt(5, course.getCapacity());
            pstmt.setString(6, course.getStart_time());
            pstmt.executeUpdate();
        }
    }

    // 2. 删除课程
    public void deleteCourse(int courseId) throws SQLException {
        String sql = "DELETE FROM courses WHERE course_id = ?";
        try (Connection conn = Util.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, courseId);
            pstmt.executeUpdate();
        }
    }

    // 3. 查询所有学生列表
    public void listAllStudents() throws SQLException {
        String sql = "SELECT s.student_id, u.username, s.student_name, s.class_info " +
                "FROM students s " +
                "JOIN users u ON s.user_id = u.user_id";
        try (Connection conn = Util.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("学生ID：" + rs.getInt("student_id") +
                        "，用户名：" + rs.getString("username") +
                        "，姓名：" + rs.getString("student_name") +
                        "，班级：" + rs.getString("class_info"));
            }
        }
    }

    // 4. 查看学生选课详情
    public void viewStudentEnrollment(int studentId) throws SQLException {
        String sql = "SELECT c.course_id, c.course_name, cs.choose_time " +
                "FROM course_selection cs " +
                "JOIN courses c ON cs.course_id = c.course_id " +
                "WHERE cs.student_id = ?";
        try (Connection conn = Util.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, studentId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("课程ID：" + rs.getInt("course_id") +
                        "，课程名：" + rs.getString("course_name") +
                        "，选课时间：" + rs.getString("choose_time"));
            }
        }
    }
}