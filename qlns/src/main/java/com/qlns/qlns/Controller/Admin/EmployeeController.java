package com.qlns.qlns.Controller.Admin;

import com.qlns.qlns.Mode.Employee;
import com.qlns.qlns.Serevice.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/nhansu")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Hiển thị danh sách nhân viên
    @GetMapping
    public String listEmployees(Model model) {
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "admin/nhansu";  // Trả về view danh sách nhân viên
    }

    // Hiển thị form chỉnh sửa nhân viên
    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable Long id, Model model) {
        Employee employee = employeeService.findById(id);
        if (employee != null) {
            model.addAttribute("employee", employee);
            return "admin/employee-form";
        }
        model.addAttribute("error", "Employee not found");
        return "redirect:/admin/nhansu";  // Quay lại danh sách nếu không tìm thấy nhân viên
    }

    // Xử lý form chỉnh sửa nhân viên
    @PostMapping("/edit/{id}")
    public String updateEmployee(@PathVariable Long id, @ModelAttribute Employee employee) {
        employee.setId(id);
        employeeService.updateEmployee(employee);
        return "redirect:/admin/nhansu";
    }

    // Hiển thị form thêm nhân viên
    @GetMapping("/add")
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "admin/employee-form";  // Form dùng chung cho việc thêm và chỉnh sửa nhân viên
    }

    // Xử lý form thêm nhân viên
    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Employee employee) {
        employeeService.save(employee);
        return "redirect:/admin/nhansu";  // Quay lại danh sách sau khi thêm
    }

    // Xóa nhân viên
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteById(id);
        return "redirect:/admin/nhansu";  // Quay lại danh sách sau khi xóa
    }
}
