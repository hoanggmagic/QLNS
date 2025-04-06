package com.qlns.qlns.controllers.users;

import com.qlns.qlns.entitys.*;
import com.qlns.qlns.services.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private NhanVienService nhanVienService;

    // Hiển thị trang dashboard của người dùng
    @GetMapping("/user/dashboard")
    public String userDashboard() {
        return "users/index"; // Trả về trang user/index.html
    }

    // Hiển thị thông tin cá nhân của người dùng
    @GetMapping("/user/thongtin-cap-nhat")
    public String userInfo(HttpSession session, Model model) {
        NhanVien nhanVien = (NhanVien) session.getAttribute("loggedInUser");

        if (nhanVien == null) {
            return "redirect:/login"; // Nếu không có session, chuyển hướng về trang đăng nhập
        }

        model.addAttribute("nhanVien", nhanVien); // Gửi thông tin nhân viên ra trang
        return "users/thongtin"; // Trả về trang thông tin người dùng
    }

    // Cập nhật thông tin cá nhân
    @PostMapping("/user/thongtin-cap-nhat")
    public String updateUserInfo(@RequestParam String name, @RequestParam String email, HttpSession session,
            Model model) {
        NhanVien nhanVien = (NhanVien) session.getAttribute("loggedInUser");

        if (nhanVien == null) {
            return "redirect:/login"; // Nếu không có session, chuyển hướng về trang đăng nhập
        }

        // Cập nhật thông tin người dùng
        nhanVien.setUsername(name);
        nhanVien.setEmail(email);

        // Lưu thông tin cập nhật vào cơ sở dữ liệu
        nhanVienService.save(nhanVien); // Lưu lại thông tin vào DB

        // Cập nhật lại thông tin trong session
        session.setAttribute("loggedInUser", nhanVien);

        // Gửi lại thông tin và thông báo thành công đến view
        model.addAttribute("nhanVien", nhanVien);
        model.addAttribute("message", "Thông tin của bạn đã được cập nhật thành công!");

        return "users/thongtin"; // Trả về trang thông tin người dùng
    }
}
