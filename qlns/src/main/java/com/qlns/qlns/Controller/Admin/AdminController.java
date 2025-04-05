package com.qlns.qlns.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    // Trang dashboard của admin
    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "admin/index"; // Trả về trang admin/index.html
    }
}
