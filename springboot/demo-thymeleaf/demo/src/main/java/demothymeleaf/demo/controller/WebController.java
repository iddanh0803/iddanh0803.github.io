package demothymeleaf.demo.controller;


import demothymeleaf.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {
    private final List<User> userList;

    public WebController() {
        userList = new ArrayList<>();
        userList.add(new User(1, "Nguyễn Văn A", "a@gmail.com"));
        userList.add(new User(2, "Trần Văn B", "b@gmail.com"));
        userList.add(new User(3, "Ngô Thị C", "c@gmail.com"));
    }

    @GetMapping("/")
    public String getHome(Model model) {
        String name = "Bùi Hiên";

        model.addAttribute("name", name);
        model.addAttribute("user", userList.get(0));
        model.addAttribute("userList", new ArrayList<>());

        LocalDateTime localDateTime = LocalDateTime.now();
        model.addAttribute("localDateTime", localDateTime);

        return "index";
    }

    @GetMapping("/admin")
    public String getAdminPage(Model model) {
        model.addAttribute("user1", userList.get(0));
        model.addAttribute("user2", userList.get(1));
        model.addAttribute("userList", userList);
        return "admin/admin";
    }
}