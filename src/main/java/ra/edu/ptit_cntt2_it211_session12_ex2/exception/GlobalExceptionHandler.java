package ra.edu.ptit_cntt2_it211_session12_ex2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ra.edu.ptit_cntt2_it211_session12_ex2.model.dto.ApiDataResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiDataResponse<?>> handleNotFound(NotFoundException e) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                false,
                e.getMessage(),
                null,
                HttpStatus.NOT_FOUND
        ), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiDataResponse<?>> handleException(Exception e) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                false,
                "Dữ liệu gửi lên không hợp lệ!",
                null,
                HttpStatus.BAD_REQUEST
        ), HttpStatus.BAD_REQUEST);
    }
}
