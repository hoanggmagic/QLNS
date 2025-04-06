package com.qlns.qlns.Controller.Admin;

import com.qlns.qlns.Mode.GioLam;
import com.qlns.qlns.Mode.NhanVien;
import com.qlns.qlns.Serevice.GioLamService;
import com.qlns.qlns.Serevice.NhanVienService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;

@Controller
@RequestMapping("/admin/giolam")
public class GioLamController {

    @Autowired
    private GioLamService gioLamService;

    @Autowired
    private NhanVienService nhanVienService;

    // Hiển thị danh sách giờ làm
    @GetMapping
    public String viewGioLams(Model model) {
        model.addAttribute("gioLams", gioLamService.findAll());
        return "admin/giolam";
    }

    // Hiển thị form thêm giờ làm
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("gioLam", new GioLam());
        model.addAttribute("nhanViens", nhanVienService.findAll());
        return "admin/addGioLam";
    }

    // Xử lý thêm giờ làm
    @PostMapping("/add")
    public String addGioLam(@RequestParam("gioBatDau") String gioBatDauStr,
                            @RequestParam("gioKetThuc") String gioKetThucStr,
                            @RequestParam("nhanVienId") Long nhanVienId) {

        // Kiểm tra xem nhân viên có tồn tại không
        NhanVien nhanVien = nhanVienService.findById(nhanVienId);
        if (nhanVien == null) {
            // Xử lý lỗi: Nhân viên không tồn tại
            return "redirect:/admin/giolam?error=nhanVienNotFound";
        }

        try {
            LocalTime gioBatDau = LocalTime.parse(gioBatDauStr);
            LocalTime gioKetThuc = LocalTime.parse(gioKetThucStr);
            
            GioLam gioLam = new GioLam();
            gioLam.setGioBatDau(gioBatDau);
            gioLam.setGioKetThuc(gioKetThuc);
            gioLam.setNhanVien(nhanVien);

            gioLamService.save(gioLam);
        } catch (Exception e) {
            // Xử lý lỗi khi không thể phân tích giờ làm
            return "redirect:/admin/giolam?error=invalidTimeFormat";
        }
        return "redirect:/admin/giolam";
    }

    // Hiển thị form chỉnh sửa
    @GetMapping("/edit")
    public String showEditForm(@RequestParam("id") Long id, Model model) {
        GioLam gioLam = gioLamService.findById(id);
        if (gioLam == null) {
            return "redirect:/admin/giolam?error=gioLamNotFound";  // Điều hướng về trang giolam nếu không tìm thấy gioLam
        }
        model.addAttribute("gioLam", gioLam);
        model.addAttribute("nhanViens", nhanVienService.findAll());
        return "admin/editGioLam";
    }

    // Xử lý cập nhật giờ làm
    @PostMapping("/update")
    public String updateGioLam(@RequestParam("id") Long id,
                               @RequestParam("gioBatDau") String gioBatDauStr,
                               @RequestParam("gioKetThuc") String gioKetThucStr,
                               @RequestParam("nhanVienId") Long nhanVienId) {

        GioLam gioLam = gioLamService.findById(id);
        if (gioLam == null) {
            // Xử lý lỗi: Giờ làm không tồn tại
            return "redirect:/admin/giolam?error=gioLamNotFound";
        }

        // Kiểm tra xem nhân viên có tồn tại không
        NhanVien nhanVien = nhanVienService.findById(nhanVienId);
        if (nhanVien == null) {
            // Xử lý lỗi: Nhân viên không tồn tại
            return "redirect:/admin/giolam?error=nhanVienNotFound";
        }

        try {
            gioLam.setGioBatDau(LocalTime.parse(gioBatDauStr));
            gioLam.setGioKetThuc(LocalTime.parse(gioKetThucStr));
            gioLam.setNhanVien(nhanVien);
            gioLamService.save(gioLam);
        } catch (Exception e) {
            // Xử lý lỗi khi không thể phân tích giờ làm
            return "redirect:/admin/giolam?error=invalidTimeFormat";
        }

        return "redirect:/admin/giolam";
    }

    // Xóa giờ làm
    @GetMapping("/delete")
    public String deleteGioLam(@RequestParam("id") Long id) {
        gioLamService.deleteById(id);
        return "redirect:/admin/giolam";
    }
}
