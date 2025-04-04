package com.qlns.qlns.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qlns.qlns.Mode.RewardAndDiscipline;

import java.util.List;

public interface RewardAndDisciplineRepository extends JpaRepository<RewardAndDiscipline, Long> {
    List<RewardAndDiscipline> findByEmployeeId(Long employeeId);
}
