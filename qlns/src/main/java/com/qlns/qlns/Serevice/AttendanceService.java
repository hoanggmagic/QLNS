package com.qlns.qlns.Serevice;
import com.qlns.qlns.Mode.Attendance;
import com.qlns.qlns.Repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    // Lấy tất cả dữ liệu chấm công
    public List<Attendance> getAllAttendances() {
        return attendanceRepository.findAll();
    }

    // Thêm mới hoặc cập nhật chấm công
    public Attendance saveAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    // Tìm kiếm chấm công theo ID
    public Attendance getAttendanceById(Long id) {
        return attendanceRepository.findById(id).orElse(null);
    }

    // Xóa chấm công
    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }
}
