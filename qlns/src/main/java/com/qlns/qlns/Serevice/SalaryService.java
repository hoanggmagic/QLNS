package com.qlns.qlns.Serevice;

import com.qlns.qlns.Mode.Salary;
import com.qlns.qlns.Repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryService {

    @Autowired
    private SalaryRepository salaryRepository;

    // Lấy tất cả lương của nhân viên
    public List<Salary> getAllSalaries() {
        return salaryRepository.findAll();
    }

    // Thêm mới hoặc cập nhật lương
    public Salary saveSalary(Salary salary) {
        // Tính toán tổng lương trước khi lưu
        salary.setTotalSalary(salary.getBaseSalary() + salary.getBonus() - salary.getDeductions());
        return salaryRepository.save(salary);
    }

    // Lấy lương theo ID nhân viên
    public Salary getSalaryByEmployeeId(Long employeeId) {
        return salaryRepository.findById(employeeId).orElse(null);
    }

    // Xóa lương
    public void deleteSalary(Long id) {
        salaryRepository.deleteById(id);
    }
}
