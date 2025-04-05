package com.qlns.qlns.Controller.Admin;

import com.qlns.qlns.Mode.Position;
import com.qlns.qlns.Serevice.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/chucvu")
public class PositionController {

    private final PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    // Hiển thị danh sách chức vụ
    @GetMapping
    public String listPositions(Model model) {
        List<Position> positions = positionService.findAll();
        model.addAttribute("positions", positions);
        return "admin/chucvu";  // Trả về view danh sách chức vụ
    }

    // Hiển thị form thêm chức vụ mới
    @GetMapping("/add")
    public String showAddPositionForm(Model model) {
        model.addAttribute("position", new Position());  // Tạo đối tượng Position mới
        return "admin/chucvu-form";  // Form thêm chức vụ
    }

    // Thêm chức vụ mới vào cơ sở dữ liệu
    @PostMapping("/add")
    public String addPosition(@ModelAttribute Position position) {
        positionService.save(position);  // Lưu vào cơ sở dữ liệu
        return "redirect:/admin/chucvu";  // Quay lại danh sách chức vụ
    }

    // Hiển thị form chỉnh sửa chức vụ
    @GetMapping("/edit/{id}")
    public String showEditPositionForm(@PathVariable Long id, Model model) {
        Position position = positionService.findById(id);
        if (position != null) {
            model.addAttribute("position", position);
            return "admin/chucvu-form";  // Form chỉnh sửa chức vụ
        }
        return "redirect:/admin/chucvu";  // Nếu không tìm thấy chức vụ, quay lại danh sách
    }

    // Cập nhật chức vụ
    @PostMapping("/edit/{id}")
    public String updatePosition(@PathVariable Long id, @ModelAttribute Position position) {
        position.setId(id);  // Đảm bảo id không thay đổi khi chỉnh sửa
        positionService.updatePosition(position);  // Cập nhật chức vụ
        return "redirect:/admin/chucvu";  // Quay lại danh sách chức vụ
    }

    // Xóa chức vụ
    @GetMapping("/delete/{id}")
    public String deletePosition(@PathVariable Long id) {
        positionService.deleteById(id);  // Xóa chức vụ
        return "redirect:/admin/chucvu";  // Quay lại danh sách chức vụ
    }
}
