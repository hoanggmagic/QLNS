package com.qlns.qlns.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qlns.qlns.Mode.Salary;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long> {
}
