package com.qlns.qlns.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qlns.qlns.Mode.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartment(String department);
}
