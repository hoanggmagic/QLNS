package com.qlns.qlns.Repository;

import com.qlns.qlns.Mode.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    // Phương thức tìm nhân viên theo tên
    Optional<Employee> findByName(String name);
    
    // Phương thức xóa nhân viên theo ID
    void deleteById(Long id);

    // Thêm các phương thức tìm kiếm khác nếu cần
    Optional<Employee> findByEmail(String email);
    Optional<Employee> findByPhone(String phone);
}
