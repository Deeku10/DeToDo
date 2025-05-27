package in.builtbydeeku.detodo_springboot.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;

@Data
@AllArgsConstructor
public class ApiResponse{
    private Object data;
    private String message;
}
