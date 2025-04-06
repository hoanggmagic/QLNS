package com.qlns.qlns.controllers.users;

import com.qlns.qlns.entitys.*;
import com.qlns.qlns.services.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class ProfileController {

    @Autowired
    private NhanVienService nhanVienService; // Service để lấy thông tin nhân viên từ DB

    @GetMapping("/user/thongtin")
    public String thongTinNguoiDung(Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/login"; // Nếu principal là null (người dùng chưa đăng nhập), chuyển hướng đến trang
                                      // đăng nhập
        }

        // Lấy tên người dùng từ principal
        String username = principal.getName();

        // Tìm thông tin người dùng từ cơ sở dữ liệu
        NhanVien nhanVien = nhanVienService.findByUsername(username);

        // Nếu không tìm thấy nhân viên, có thể trả về thông báo lỗi
        if (nhanVien == null) {
            model.addAttribute("errorMessage", "Không tìm thấy thông tin người dùng.");
            return "users/thongtin"; // Trả về trang thông tin người dùng với thông báo lỗi
        }

        model.addAttribute("nhanVien", nhanVien); // Gửi thông tin nhân viên ra trang
        return "users/thongtin"; // Trả về trang thông tin người dùng
    }
}
