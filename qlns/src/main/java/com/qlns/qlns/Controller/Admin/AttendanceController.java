package com.qlns.qlns.Controller.Admin;
import com.qlns.qlns.Mode.Attendance;
import com.qlns.qlns.Repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/chamcong")
public class AttendanceController {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @GetMapping
    public String viewAttendance(Model model) {
        model.addAttribute("attendances", attendanceRepository.findAll());
        return "admin/chamcong";
    }

    @PostMapping("/add")
    public String addAttendance(Attendance attendance) {
        attendanceRepository.save(attendance);
        return "redirect:/admin/chamcong";
    }
}
