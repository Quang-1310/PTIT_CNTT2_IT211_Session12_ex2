package ra.edu.ptit_cntt2_it211_session12_ex2.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ra.edu.ptit_cntt2_it211_session12_ex2.exception.NotFoundException;
import ra.edu.ptit_cntt2_it211_session12_ex2.model.entity.Course;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CourseService {
    private final List<Course> courses = new ArrayList<>();
    private Long currentId = 1L;

    public List<Course> getAllCourses() {
        return courses;
    }

    public Course getCourseById(Long id) {
        return courses.stream()
                .filter(course -> course.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> {
                    log.warn("Không tìm thấy Course có id = {}", id);
                    return new NotFoundException("Không tìm thấy khóa học có id = " + id);
                });
    }

    public Course createCourse(Course course) {
        course.setId(currentId++);
        courses.add(course);

        log.info("Tạo mới khóa học thành công: {}", course);
        return course;
    }

    public Course updateCourse(Long id, Course courseUpdate) {
        Course course = getCourseById(id);

        course.setCourseName(courseUpdate.getCourseName());
        course.setInstructor(courseUpdate.getInstructor());
        course.setDurationHours(courseUpdate.getDurationHours());
        course.setFee(courseUpdate.getFee());

        log.info("Cập nhật khóa học thành công: {}", course);
        return course;
    }

    public void deleteCourse(Long id) {
        Course course = getCourseById(id);
        courses.remove(course);
    }
}
