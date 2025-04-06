package com.qlns.qlns.controllers.admins;

import com.qlns.qlns.entitys.*;
import com.qlns.qlns.services.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/chamcong")
public class ChamCongController {

    @Autowired
    private ChamCongService chamCongService;

    @GetMapping
    public String listChamCong(Model model) {
        List<ChamCong> list = chamCongService.findAll();
        model.addAttribute("listChamCong", list);
        return "admin/chamcong";
    }
}
