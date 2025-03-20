package SystemWeek1;

public class Course {
    private int course_id;
    private String course_name;
    private int credit;
    private int is_opened;
    private String TimePlace;
    private int capacity;
    private String start_time;

    public Course() {
    }

    @Override
    public String toString() {
        return "Course{" +
                "course_id=" + course_id +
                ", course_name='" + course_name + '\'' +
                ", credit=" + credit +
                ", is_opened=" + is_opened +
                ", TimePlace='" + TimePlace + '\'' +
                ", capacity=" + capacity +
                ", start_time='" + start_time + '\'' +
                '}';
    }

    public Course(int course_id, String course_name, int credit, int is_opened, String TimePlace, int capacity, String start_time) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.credit = credit;
        this.is_opened = is_opened;
        this.TimePlace = TimePlace;
        this.capacity = capacity;
        this.start_time = start_time;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getIs_opened() {
        return is_opened;
    }

    public void setis_opened(int is_opened) {
        this.is_opened = is_opened;
    }

    public String getTimePlace() {
        return TimePlace;
    }

    public void setTimePlace(String TimePlace) {
        this.TimePlace = TimePlace;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }
}
