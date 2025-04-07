package com.qlns.qlns.controllers.users;

import com.qlns.qlns.entitys.*;
import com.qlns.qlns.services.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping("/dashboard")
    public String userDashboard() {
        return "views/users/index";
    }

    @GetMapping("/thongtin-cap-nhat")
    public String userInfo(HttpSession session, Model model) {
        NhanVien nhanVien = (NhanVien) session.getAttribute("loggedInUser");

        if (nhanVien == null) {
            return "redirect:/";
        }

        model.addAttribute("nhanVien", nhanVien);
        return "views/users/thongtin";
    }

    @PostMapping("/user/thongtin-cap-nhat")
    public String updateUserInfo(@RequestParam String name, @RequestParam String email, HttpSession session,
            Model model) {
        NhanVien nhanVien = (NhanVien) session.getAttribute("loggedInUser");

        if (nhanVien == null) {
            return "redirect:/";
        }
        nhanVien.setUsername(name);
        nhanVien.setEmail(email);

        nhanVienService.save(nhanVien);

        session.setAttribute("loggedInUser", nhanVien);

        // Gửi lại thông tin và thông báo thành công đến view
        model.addAttribute("nhanVien", nhanVien);
        model.addAttribute("message", "Thông tin của bạn đã được cập nhật thành công!");

        return "views/users/thongtin";
    }
}
