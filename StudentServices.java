package SystemWeek1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentServices {
    // 学生选课
    public void selectCourse(int studentId, int courseId) throws SQLException {
        String checkSql = "SELECT COUNT(*) FROM course_selection WHERE student_id = ?";
        try (Connection conn = Util.getConnection();
             PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {
            checkStmt.setInt(1, studentId);
            ResultSet rs = checkStmt.executeQuery();
            rs.next();
            if (rs.getInt(1) >= 5) {
                throw new SQLException("最多选五门课");
            }

            String insertSql = "INSERT INTO course_selection (student_id, course_id, choose_time) " +
                    "VALUES (?, ?, NOW())";
            PreparedStatement insertStmt = conn.prepareStatement(insertSql);
            insertStmt.setInt(1, studentId);
            insertStmt.setInt(2, courseId);
            insertStmt.executeUpdate();
        }
    }

    // 查询学生已选课程
    public void listSelectedCourses(int studentId) throws SQLException {
        String sql = "SELECT c.course_id, c.course_name " +
                "FROM course_selection cs " +
                "JOIN courses c ON cs.course_id = c.course_id " +
                "WHERE cs.student_id = ?";
        try (Connection conn = Util.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, studentId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("课程ID: " + rs.getInt("course_id") + "，课程名: " + rs.getString("course_name"));
            }
        }
    }
}