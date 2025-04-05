package com.qlns.qlns.Controller;

import com.qlns.qlns.Mode.Users;
import com.qlns.qlns.Repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    // Trang đăng nhập
    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Trả về trang login.html (trong templates)
    }

    // Xử lý đăng nhập
    @PostMapping("/login")
    public String processLogin(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String role,
            HttpSession session,
            Model model
    ) {
        Optional<Users> userOptional = userRepository.findByUsername(username);

        // Kiểm tra xem người dùng có tồn tại trong cơ sở dữ liệu không
        if (userOptional.isPresent()) {
            Users user = userOptional.get();
            // Kiểm tra mật khẩu và vai trò
            if (user.getPassword().equals(password) && user.getRole().equals(role)) {
                session.setAttribute("username", username);
                session.setAttribute("role", role);
                
                // Chuyển hướng dựa trên vai trò
                if ("admin".equals(role)) {
                    return "redirect:/admin/dashboard"; // Chuyển tới trang admin/dashboard
                } else {
                    return "redirect:/user/dashboard"; // Chuyển tới trang user/dashboard
                }
            } else {
                // Nếu mật khẩu hoặc vai trò không khớp
                model.addAttribute("error", "Mật khẩu hoặc vai trò không đúng!");
                return "login"; // Trả về trang login với thông báo lỗi
            }
        } else {
            // Nếu không tìm thấy người dùng trong cơ sở dữ liệu
            model.addAttribute("error", "Tên người dùng không hợp lệ!");
            return "login"; // Trả về trang login với thông báo lỗi
        }
    }

    // Đăng xuất
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Xóa thông tin session
        return "redirect:/login"; // Chuyển về trang đăng nhập
    }
}
