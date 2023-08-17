package vn.techmaster.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vn.techmaster.demo.model.User;

@CrossOrigin
@RestController
public class LoginController {
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        // Kiểm tra username và password
        if (isValidCredentials(user.getUsername(), user.getPassword())) {
            // Tạo thông tin user chỉ bao gồm username, email, avatar
            User userInfo = createUserInfo(user.getUsername());
            return new ResponseEntity<>(userInfo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    private boolean isValidCredentials(String username, String password) {
        // Kiểm tra username và password có chính xác hay không
        // Thực hiện logic kiểm tra trong cơ sở dữ liệu hoặc bất kỳ phương thức nào phù hợp
        return username.equals("admin") && password.equals("123456");
    }

    private User createUserInfo(String username) {
        // Tạo thông tin user chỉ bao gồm username, email, avatar
        // Thực hiện logic truy vấn cơ sở dữ liệu hoặc bất kỳ phương thức nào phù hợp
        User user = new User();
        user.setUsername(username);
        user.setEmail("example@example.com");
        user.setAvatar("avatar.jpg");
        return user;
    }
}
