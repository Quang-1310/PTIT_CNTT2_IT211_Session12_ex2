package ra.edu.ptit_cntt2_it211_session12_ex2.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.edu.ptit_cntt2_it211_session12_ex2.model.dto.ApiDataResponse;
import ra.edu.ptit_cntt2_it211_session12_ex2.model.entity.Course;
import ra.edu.ptit_cntt2_it211_session12_ex2.service.CourseService;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
@Slf4j
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<ApiDataResponse<?>> getAllCourses() {
        log.info("Request đến method getAllCourses - endpoint GET /api/courses");

        try {
            return new ResponseEntity<>(new ApiDataResponse<>(
                    true,
                    "Lấy danh sách khóa học thành công!",
                    courseService.getAllCourses(),
                    HttpStatus.OK
            ), HttpStatus.OK);
        } catch (RuntimeException e) {
            log.error("Lỗi tại method getAllCourses: {}", e.getMessage());
            throw e;
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiDataResponse<?>> getCourseById(@PathVariable Long id) {
        log.info("Request đến method getCourseById - endpoint GET /api/courses/{}", id);

        try {
            return new ResponseEntity<>(new ApiDataResponse<>(
                    true,
                    "Lấy khóa học theo id thành công!",
                    courseService.getCourseById(id),
                    HttpStatus.OK
            ), HttpStatus.OK);
        } catch (RuntimeException e) {
            log.error("Lỗi tại method getCourseById: {}", e.getMessage());
            throw e;
        }
    }

    @PostMapping
    public ResponseEntity<ApiDataResponse<?>> createCourse(@RequestBody Course course) {
        log.info("Request đến method createCourse - endpoint POST /api/courses");

        try {
            return new ResponseEntity<>(new ApiDataResponse<>(
                    true,
                    "Thêm khóa học thành công!",
                    courseService.createCourse(course),
                    HttpStatus.CREATED
            ), HttpStatus.CREATED);
        } catch (RuntimeException e) {
            log.error("Lỗi tại method createCourse: {}", e.getMessage());
            throw e;
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiDataResponse<?>> updateCourse(
            @PathVariable Long id,
            @RequestBody Course course
    ) {
        log.info("Request đến method updateCourse - endpoint PUT /api/courses/{}", id);

        try {
            return new ResponseEntity<>(new ApiDataResponse<>(
                    true,
                    "Cập nhật khóa học thành công!",
                    courseService.updateCourse(id, course),
                    HttpStatus.OK
            ), HttpStatus.OK);
        } catch (RuntimeException e) {
            log.error("Lỗi tại method updateCourse: {}", e.getMessage());
            throw e;
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Long id) {
        log.info("Request đến method deleteCourse - endpoint DELETE /api/courses/{}", id);

        try {
            courseService.deleteCourse(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            log.error("Lỗi tại method deleteCourse: {}", e.getMessage());
            throw e;
        }
    }
}
