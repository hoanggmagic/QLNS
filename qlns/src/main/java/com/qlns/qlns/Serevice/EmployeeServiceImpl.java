package com.qlns.qlns.Serevice;

import com.qlns.qlns.Mode.Employee;
import com.qlns.qlns.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(null);  // Trả về null nếu không tìm thấy
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);  // Lưu hoặc cập nhật nhân viên
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();  // Trả về tất cả danh sách nhân viên
    }

    public void deleteById(Long id) {
        employeeRepository.deleteById(id);  // Xóa nhân viên theo ID
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);  // Cập nhật thông tin nhân viên
    }

    @Override
    public Optional<Employee> findByName(String name) {
        return employeeRepository.findByName(name);  // Tìm nhân viên theo tên
    }

    @Override
    public Optional<Employee> findByEmail(String email) {
        return employeeRepository.findByEmail(email);  // Tìm nhân viên theo email
    }

    @Override
    public Optional<Employee> findByPhone(String phone) {
        return employeeRepository.findByPhone(phone);  // Tìm nhân viên theo số điện thoại
    }
}
