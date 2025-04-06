package com.qlns.qlns.controllers.admins;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import com.qlns.qlns.entitys.*;
import com.qlns.qlns.services.*;

import java.util.List;

@Controller
@RequestMapping("/admin/chucvu")
public class ChucVuController {

    private final ChucVuService chucVuService;

    @Autowired
    public ChucVuController(ChucVuService chucVuService) {
        this.chucVuService = chucVuService;
    }

    @GetMapping
    public String listChucVus(Model model) {
        List<ChucVu> chucVus = chucVuService.findAll();
        model.addAttribute("positions", chucVus); // Đảm bảo tên thuộc tính nhất quán
        return "admin/chucvu"; // View danh sách chức vụ
    }

    @GetMapping("/add")
    public String showAddChucVuForm(Model model) {
        model.addAttribute("position", new ChucVu()); // Tạo đối tượng ChucVu mới
        return "admin/chucvu-form"; // Form thêm chức vụ
    }

    @PostMapping("/add")
    public String addChucVu(@ModelAttribute ChucVu chucVu) {
        chucVuService.save(chucVu);
        return "redirect:/admin/chucvu";
    }

    @GetMapping("/edit/{id}")
    public String showEditChucVuForm(@PathVariable Long id, Model model) {
        ChucVu chucVu = chucVuService.findById(id);
        if (chucVu != null) {
            model.addAttribute("position", chucVu); // Chuyển dữ liệu vào model
            return "admin/chucvu-form"; // Form sửa chức vụ
        }
        return "redirect:/admin/chucvu";
    }

    @PostMapping("/edit/{id}")
    public String updateChucVu(@PathVariable Long id, @ModelAttribute ChucVu chucVu) {
        // Chỉnh sửa và lưu lại chức vụ
        chucVuService.save(chucVu);
        return "redirect:/admin/chucvu";
    }

    @GetMapping("/delete/{id}")
    public String deleteChucVu(@PathVariable Long id) {
        chucVuService.deleteById(id);
        return "redirect:/admin/chucvu";
    }
}
