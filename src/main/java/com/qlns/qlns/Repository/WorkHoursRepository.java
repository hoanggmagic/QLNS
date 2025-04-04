package com.qlns.qlns.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qlns.qlns.Mode.WorkHours;

import java.time.LocalDate;
import java.util.List;

public interface WorkHoursRepository extends JpaRepository<WorkHours, Long> {
    List<WorkHours> findByEmployeeIdAndDateBetween(Long employeeId, LocalDate startDate, LocalDate endDate);
}

