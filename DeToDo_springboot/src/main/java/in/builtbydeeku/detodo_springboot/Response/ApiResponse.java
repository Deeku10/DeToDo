package in.builtbydeeku.detodo_springboot.Response;

import lombok.Data;

@Data
public class ApiResponse {
    private Object data;
    private String message;
}
