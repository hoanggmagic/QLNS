package com.qlns.qlns.Serevice;

import com.qlns.qlns.Mode.WorkHours;
import com.qlns.qlns.Repository.WorkHoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkHoursService {

    private final WorkHoursRepository workHoursRepository;

    @Autowired
    public WorkHoursService(WorkHoursRepository workHoursRepository) {
        this.workHoursRepository = workHoursRepository;
    }

    // Lấy tất cả dữ liệu giờ làm việc
    public List<WorkHours> findAll() {
        return workHoursRepository.findAll();
    }

    // Lưu thông tin giờ làm việc
    public void save(WorkHours workHours) {
        workHoursRepository.save(workHours);
    }

    // Cập nhật giờ làm việc
    public void updateWorkHours(WorkHours workHours) {
        workHoursRepository.save(workHours);
    }

    // Tìm theo id
    public WorkHours findById(Long id) {
        Optional<WorkHours> workHours = workHoursRepository.findById(id);
        return workHours.orElse(null);
    }

    // Xóa giờ làm việc theo id
    public void deleteById(Long id) {
        workHoursRepository.deleteById(id);
    }
}
