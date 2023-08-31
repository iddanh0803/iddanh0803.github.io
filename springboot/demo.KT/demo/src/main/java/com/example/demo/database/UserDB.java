package com.example.demo.database;

import com.example.demo.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDB {
    public static List<User> userList = new ArrayList<>(
            List.of(
                    new User(1, "Duc Thinh", "thinh@gmail.com", "0988888888","Hà Nội", "https://media.techmaster.vn/api/static/c2m5ou451cob24f6skeg/c3IwVOU2","thinh123"),
                    new User(2, "Pham Man", "man@gmail.com", "0988888887","Hồ Chí Minh", "https://media.techmaster.vn/api/static/crop/bv9jp4k51co7nj2mhht0","man123"),
                    new User(3, "Thanh Huong", "huong@gmail.com", "0988888886", "Hải Phòng","https://media.techmaster.vn/api/static/crop/brm3huc51co50mv77sag","huong123"),
                    new User(4, "Bui Hien", "hien@gmail.com", "0344005816", "Thái Bình",null,"hien123")
                    )
    );
}
