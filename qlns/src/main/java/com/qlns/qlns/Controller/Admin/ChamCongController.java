package com.qlns.qlns.Controller.Admin;

import com.qlns.qlns.Mode.ChamCong;
import com.qlns.qlns.Repository.ChamCongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/chamcong")
public class ChamCongController {

    @Autowired
    private ChamCongRepository chamCongRepository;

    // Hiển thị danh sách chấm công
    @GetMapping
    public String viewChamCong(Model model) {
        model.addAttribute("chamCongs", chamCongRepository.findAll()); // Lấy tất cả chấm công từ cơ sở dữ liệu
        return "admin/chamcong"; // Trả về trang chamcong.html
    }

    // Thêm mới chấm công
    @PostMapping("/add")
    public String addChamCong(ChamCong chamCong) {
        chamCongRepository.save(chamCong); // Lưu chấm công vào cơ sở dữ liệu
        return "redirect:/admin/chamcong"; // Chuyển hướng lại trang danh sách chấm công
    }

    // Có thể thêm một phương thức sửa chấm công nếu cần (ví dụ sửa thông tin giờ làm)
}
