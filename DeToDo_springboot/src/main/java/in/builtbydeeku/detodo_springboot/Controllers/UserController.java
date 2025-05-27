package in.builtbydeeku.detodo_springboot.Controllers;

import in.builtbydeeku.detodo_springboot.Models.Users;
import in.builtbydeeku.detodo_springboot.Response.ApiResponse;
import in.builtbydeeku.detodo_springboot.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody Users user) {
        try {
            return ResponseEntity.ok(new ApiResponse(userService.login(user.getUsername(), user.getPassword()), "Login Success"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiResponse(e.getMessage(), "Login Unsuccessful"));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@RequestBody Users user) {
        try {
            return ResponseEntity.ok(new ApiResponse(userService.register(user), "User successfully registered"));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), "User not registered"));
        }
    }
}
