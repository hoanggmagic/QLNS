package com.qlns.qlns.Controller.Admin;

import com.qlns.qlns.Mode.WorkHours;
import com.qlns.qlns.Serevice.WorkHoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/giolam")
public class WorkHoursController {

    private final WorkHoursService workHoursService;

    @Autowired
    public WorkHoursController(WorkHoursService workHoursService) {
        this.workHoursService = workHoursService;
    }

    // Hiển thị danh sách giờ làm
    @GetMapping
    public String listWorkHours(Model model) {
        List<WorkHours> workHoursList = workHoursService.findAll();
        model.addAttribute("workHoursList", workHoursList);
        return "admin/giolam";  // Trả về view danh sách giờ làm
    }

    // Hiển thị form thêm giờ làm
    @GetMapping("/add")
    public String showAddWorkHoursForm(Model model) {
        model.addAttribute("workHours", new WorkHours());  // Tạo đối tượng WorkHours mới
        return "admin/giolam-form";  // Form thêm giờ làm
    }

    // Thêm giờ làm mới
    @PostMapping("/add")
    public String addWorkHours(@ModelAttribute WorkHours workHours) {
        workHoursService.save(workHours);
        return "redirect:/admin/giolam";  // Quay lại danh sách giờ làm
    }

    // Hiển thị form chỉnh sửa giờ làm
    @GetMapping("/edit/{id}")
    public String showEditWorkHoursForm(@PathVariable Long id, Model model) {
        WorkHours workHours = workHoursService.findById(id);
        if (workHours != null) {
            model.addAttribute("workHours", workHours);
            return "admin/giolam-form";  // Form chỉnh sửa giờ làm
        }
        return "redirect:/admin/giolam";  // Nếu không tìm thấy, quay lại danh sách
    }

    // Cập nhật giờ làm
    @PostMapping("/edit/{id}")
    public String updateWorkHours(@PathVariable Long id, @ModelAttribute WorkHours workHours) {
        workHours.setId(id);  // Đảm bảo id không thay đổi
        workHoursService.updateWorkHours(workHours);
        return "redirect:/admin/giolam";  // Quay lại danh sách giờ làm
    }

    // Xóa giờ làm
    @GetMapping("/delete/{id}")
    public String deleteWorkHours(@PathVariable Long id) {
        workHoursService.deleteById(id);
        return "redirect:/admin/giolam";  // Quay lại danh sách giờ làm
    }
}
