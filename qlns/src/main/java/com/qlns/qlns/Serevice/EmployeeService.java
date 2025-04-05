package com.qlns.qlns.Serevice;

import com.qlns.qlns.Mode.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    
    // Tìm nhân viên theo ID
    Employee findById(Long id);
    
    // Lưu nhân viên mới
    void save(Employee employee);
    
    // Lấy tất cả nhân viên
    List<Employee> findAll();
    
    // Xóa nhân viên theo ID
    void deleteById(Long id);

    // Cập nhật thông tin nhân viên
    void updateEmployee(Employee employee);
    
    // Tìm nhân viên theo tên
    Optional<Employee> findByName(String name);
    
    // Tìm nhân viên theo email
    Optional<Employee> findByEmail(String email);
    
    // Tìm nhân viên theo số điện thoại
    Optional<Employee> findByPhone(String phone);
}
