package SystemWeek1;

import SystemWeek1.CourseServices;
import SystemWeek1.StudentServices;
import SystemWeek1.User;
import SystemWeek1.UserServices;

import java.sql.SQLException;

public class Main{
    public static void main(String[] args) {
        UserServices userDAO = new UserServices();
        StudentServices studentDAO = new StudentServices();
        CourseServices courseDAO = new CourseServices();

        // 模拟用户注册
        User newUser = new User();
        newUser.setUsername("student_user");
        newUser.setPassword("123456");
        newUser.setEmail("student@example.com");
        newUser.setRole(2); // 1 代表学生
        try {
            userDAO.register(newUser);

            // 模拟用户登录
            User loginUser = userDAO.login("student_user", "123456");
            if (loginUser != null && loginUser.getRole() == 1) {
                System.out.println("学生登录成功");

                // 查询可选课程
                courseDAO.listAvailableCourses();

                // 学生选课（假设学生 ID 为 1，课程 ID 为 1）
                studentDAO.selectCourse(1, 1);

                // 查询已选课程
                System.out.println("已选课程：");
                studentDAO.listSelectedCourses(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}