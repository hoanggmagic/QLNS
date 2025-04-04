package com.qlns.qlns.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qlns.qlns.Mode.Attendance;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findByEmployeeIdAndDateBetween(Long employeeId, LocalDate startDate, LocalDate endDate);
}

