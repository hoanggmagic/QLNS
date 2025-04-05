package com.qlns.qlns.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qlns.qlns.Mode.Salary;
import com.qlns.qlns.Serevice.SalaryService;

@Controller
@RequestMapping("/admin/luong")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    // Hiển thị danh sách lương
    @GetMapping
    public String viewSalaries(Model model) {
        model.addAttribute("salaries", salaryService.getAllSalaries());
        return "admin/luong";  // Trả về view admin/luong.html
    }

    // Thêm mới lương
    @PostMapping("/add")
    public String addSalary(Salary salary) {
        salaryService.saveSalary(salary);
        return "redirect:/admin/luong";  // Redirect lại trang lương sau khi thêm
    }
}

