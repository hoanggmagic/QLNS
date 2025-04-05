package com.qlns.qlns.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    // Trang dashboard của user
    @GetMapping("/user/dashboard")
    public String userDashboard() {
        return "index"; // Trả về trang user/index.html
    }
}
