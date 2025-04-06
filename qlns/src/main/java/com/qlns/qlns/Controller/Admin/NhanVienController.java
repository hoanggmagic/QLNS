package com.qlns.qlns.Controller.Admin;

import com.qlns.qlns.Mode.NhanVien;
import com.qlns.qlns.Serevice.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;

    // 📋 Hiển thị danh sách nhân viên (kèm tên chức vụ)
    @GetMapping("/nhansu")
    public String getAllNhanVien(Model model) {
        List<NhanVien> nhanViens = nhanVienService.findAll(); // đã JOIN FETCH chucVu ở Service
        model.addAttribute("nhanViens", nhanViens);  // ✅ sửa từ nhanVien → nhanViens

        return "admin/nhansu";
    }

    // 📝 Hiển thị form thêm nhân viên
    @GetMapping("/nhansu/add")
    public String showAddForm(Model model) {
        model.addAttribute("nhanVien", new NhanVien());
        return "admin/add_nhanvien";
    }

    // ✅ Xử lý thêm nhân viên
    @PostMapping("/nhansu/add")
    public String addNhanVien(@ModelAttribute NhanVien nhanVien, Model model) {
        try {
            nhanVienService.save(nhanVien);
            return "redirect:/admin/nhansu";
        } catch (Exception e) {
            model.addAttribute("message", "Có lỗi khi thêm nhân viên.");
            return "admin/add_nhanvien";
        }
    }

    // ✏️ Hiển thị form sửa nhân viên
    @GetMapping("/nhansu/edit/{id}")
    public String editNhanVien(@PathVariable Long id, Model model) {
        NhanVien nv = nhanVienService.findById(id);
        if (nv != null) {
            model.addAttribute("nhanVien", nv);
            return "admin/edit_nhanvien";
        } else {
            model.addAttribute("message", "Nhân viên không tồn tại.");
            return "redirect:/admin/nhansu";
        }
    }

    // 🛠️ Xử lý cập nhật nhân viên
    @PostMapping("/nhansu/edit/{id}")
    public String updateNhanVien(@PathVariable Long id, @ModelAttribute NhanVien nhanVien, Model model) {
        NhanVien existing = nhanVienService.findById(id);
        if (existing != null) {
            nhanVien.setId(id); // giữ nguyên ID
            nhanVienService.update(id, nhanVien);
            return "redirect:/admin/nhansu";
        } else {
            model.addAttribute("message", "Nhân viên không tồn tại.");
            return "redirect:/admin/nhansu";
        }
    }

    // ❌ Xóa nhân viên
    @GetMapping("/nhansu/delete/{id}")
    public String deleteNhanVien(@PathVariable Long id, Model model) {
        try {
            nhanVienService.delete(id);
        } catch (Exception e) {
            model.addAttribute("message", "Có lỗi khi xóa nhân viên.");
        }
        return "redirect:/admin/nhansu";
    }
}
