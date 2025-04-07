package com.qlns.qlns.controllers.users;

import com.qlns.qlns.entitys.*;
import com.qlns.qlns.services.*;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user/chamcong")
public class ChamCongUserController {

    @Autowired
    private ChamCongService chamCongService;

    @Autowired
    private NhanVienService nhanVienService;

    // Điều hướng gốc
    @GetMapping("")
    public String redirectToList() {
        return "redirect:/user/chamcong/list";
    }

    // Hiển thị form chấm công
    @GetMapping("/form")
    public String showChamCongForm(Model model, HttpSession session) {
        NhanVien nhanVien = (NhanVien) session.getAttribute("loggedInUser");

        if (nhanVien == null)
            return "redirect:/login";

        ChamCong chamCong = new ChamCong();
        chamCong.setNhanVien(nhanVien);

        model.addAttribute("chamCong", chamCong);
        return "user/chamcong_form";
    }

    // Lưu chấm công
    @PostMapping("/save")
    public String saveChamCong(@ModelAttribute ChamCong chamCong, HttpSession session) {
        NhanVien nhanVien = (NhanVien) session.getAttribute("loggedInUser");

        if (nhanVien == null)
            return "redirect:/login";

        chamCong.setNhanVien(nhanVien);
        chamCongService.saveChamCong(chamCong);

        return "redirect:/user/chamcong/list";
    }

    // Hiển thị danh sách chấm công của nhân viên đang đăng nhập
    @GetMapping("/list")
    public String viewLichSuChamCong(Model model, HttpSession session) {
        NhanVien nhanVien = (NhanVien) session.getAttribute("loggedInUser");

        if (nhanVien == null)
            return "redirect:/login";

        List<ChamCong> chamCongs = chamCongService.findByNhanVien(nhanVien);
        model.addAttribute("chamCongs", chamCongs);

        return "user/chamcong_list";
    }
}
