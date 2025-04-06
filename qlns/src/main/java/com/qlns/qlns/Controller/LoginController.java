package com.qlns.qlns.Controller;

import com.qlns.qlns.Mode.NhanVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private com.qlns.qlns.Serevice.LoginService loginService;

    // Trang login
    @GetMapping
    public String loginPage() {
        return "login";  // Trang đăng nhập
    }

    // Xử lý đăng nhập
    @PostMapping
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {

        // Kiểm tra thông tin đăng nhập
        NhanVien nhanVien = loginService.authenticate(username, password);

        if (nhanVien == null) {
            model.addAttribute("error", "Sai thông tin đăng nhập!");
            return "login";  // Trả lại trang đăng nhập với lỗi
        }

        // Kiểm tra chức vụ của nhân viên
        String role = nhanVien.getChucVu().getName();  // Lấy tên chức vụ của nhân viên

        if ("Admin".equals(role)) {
            return "redirect:/user/dashboard";  // Chuyển hướng đến trang Admin
        } else {
            return "redirect:/admin/dashboard";  // Chuyển hướng đến trang Nhân viên
        }
    }
}
