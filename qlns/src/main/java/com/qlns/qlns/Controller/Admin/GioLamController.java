package com.qlns.qlns.Controller.Admin;

import com.qlns.qlns.Mode.GioLam;
import com.qlns.qlns.Mode.NhanVien;
import com.qlns.qlns.Serevice.GioLamService;
import com.qlns.qlns.Serevice.NhanVienService;

import java.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    model.addAttribute("nhanViens", nhanVienService.findAll()); // Bắt buộc phải có dòng này
    return "admin/addGioLam";
}

    // Xử lý thêm giờ làm
    @PostMapping("/add")
    public String addGioLam(@RequestParam("gioBatDau") String gioBatDauStr,
                            @RequestParam("gioKetThuc") String gioKetThucStr,
                            @RequestParam("nhanVienId") Long nhanVienId) {

        LocalTime gioBatDau = LocalTime.parse(gioBatDauStr);
        LocalTime gioKetThuc = LocalTime.parse(gioKetThucStr);
        NhanVien nhanVien = nhanVienService.findById(nhanVienId);

        GioLam gioLam = new GioLam();
        gioLam.setGioBatDau(gioBatDau);
        gioLam.setGioKetThuc(gioKetThuc);
        gioLam.setNhanVien(nhanVien);

        gioLamService.save(gioLam);
        return "redirect:/admin/giolam";
    }

    // Hiển thị form chỉnh sửa
    @GetMapping("/edit")
    public String editGioLam(@RequestParam("id") Long id, Model model) {
        GioLam gioLam = gioLamService.findById(id);
        model.addAttribute("gioLam", gioLam);
        model.addAttribute("nhanViens", nhanVienService.findAll());
        return "admin/editGioLam";
    }

    // Xử lý cập nhật
    @PostMapping("/update")
public String updateGioLam(@ModelAttribute("gioLam") GioLam gioLam) {
    // Lấy lại đối tượng nhân viên vì chỉ có id được binding
    NhanVien nhanVien = nhanVienService.findById(gioLam.getNhanVien().getId());
    gioLam.setNhanVien(nhanVien);

    gioLamService.save(gioLam);
    return "redirect:/admin/giolam";
}


    // Xóa giờ làm
    @GetMapping("/delete")
    public String deleteGioLam(@RequestParam("id") Long id) {
        gioLamService.deleteById(id);
        return "redirect:/admin/giolam";
    }
}
