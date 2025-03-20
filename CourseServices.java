package SystemWeek1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseServices {
    // 查询所有可选课程（未开课）
    public void listAvailableCourses() throws SQLException {
        String sql = "SELECT * FROM courses WHERE is_opened = 0";
        try (Connection conn = Util.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Course course = new Course();
                course.setCourse_id(rs.getInt("course_id"));
                course.setCourse_name(rs.getString("course_name"));
                System.out.println("课程ID: " + course.getCourse_id() + "，课程名: " + course.getCourse_name());
            }
        }
    }
}
