package ra.edu.ptit_cntt2_it211_session12_ex2.model.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApiDataResponse<T> {
    private Boolean success;
    private String message;
    private T data;
    private HttpStatus status;
}
