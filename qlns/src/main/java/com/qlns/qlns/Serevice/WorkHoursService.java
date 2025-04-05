package com.qlns.qlns.Serevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlns.qlns.Mode.WorkHours;
import com.qlns.qlns.Repository.WorkHoursRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class WorkHoursService {

    @Autowired
    private WorkHoursRepository workHoursRepository;

    public WorkHours saveWorkHours(WorkHours workHours) {
        return workHoursRepository.save(workHours);
    }

    public List<WorkHours> getWorkHours(Long employeeId, LocalDate startDate, LocalDate endDate) {
        return workHoursRepository.findByEmployeeIdAndDateBetween(employeeId, startDate, endDate);
    }
}

