package com.qlns.qlns.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {

    // Trang dashboard của admin
    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "admin/index"; // Trả về trang admin/index.html
    }
    @GetMapping("/logout")
public String logout(HttpSession session) {
    session.invalidate(); // Xoá session
    return "redirect:/login";
}

}
    