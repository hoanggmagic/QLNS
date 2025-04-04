package com.qlns.qlns.Serevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlns.qlns.Mode.Salary;
import com.qlns.qlns.Repository.SalaryRepository;

@Service
public class SalaryService {

    @Autowired
    private SalaryRepository salaryRepository;

    public Salary calculateSalary(Long employeeId) {
        // Your logic to calculate salary
        return salaryRepository.findByEmployeeId(employeeId).orElseThrow(() -> new RuntimeException("Salary not found"));
    }
}
