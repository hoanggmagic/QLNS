package com.qlns.qlns.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qlns.qlns.Mode.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    // Có thể thêm các phương thức tìm kiếm tùy chỉnh ở đây nếu cần
}
