package com.qlns.qlns.Controller.Admin;

import com.qlns.qlns.Mode.Luong;
import com.qlns.qlns.Mode.NhanVien;
import com.qlns.qlns.Serevice.LuongService;
import com.qlns.qlns.Serevice.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/admin/luong")
public class LuongController {

    @Autowired
    private LuongService luongService;

    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping
    public String listLuong(Model model) {
        model.addAttribute("luongs", luongService.findAll());
        model.addAttribute("nhanViens", nhanVienService.findAll());
        model.addAttribute("luong", new Luong());
        return "admin/luong";
    }

    @PostMapping("/add")
public String addLuong(@ModelAttribute Luong luong) {
    if (luong.getNhanVien() != null && luong.getNhanVien().getId() != null) {
        NhanVien nv = nhanVienService.findById(luong.getNhanVien().getId());
        luong.setNhanVien(nv);
        luong.setTongLuong(luong.getLuongCoBan().add(luong.getPhuCap()));
        luongService.save(luong);
    }
    return "redirect:/admin/luong";
}


    @GetMapping("/edit/{id}")
    public String editLuong(@PathVariable("id") Long id, Model model) {
        Luong luong = luongService.findById(id);
        List<NhanVien> nhanViens = nhanVienService.findAll();
        model.addAttribute("luong", luong);
        model.addAttribute("nhanViens", nhanViens);
        return "admin/edit_luong";
    }

    @PostMapping("/update")
public String updateLuong(@ModelAttribute Luong luong) {
    if (luong.getNhanVien() != null) {
        luong.setTongLuong(luong.getLuongCoBan().add(luong.getPhuCap()));
        luongService.save(luong);
    }
    return "redirect:/admin/luong";
}

    @GetMapping("/delete/{id}")
    public String deleteLuong(@PathVariable("id") Long id) {
        luongService.deleteById(id);
        return "redirect:/admin/luong";
    }
}
