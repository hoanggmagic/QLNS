package com.qlns.qlns.Serevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlns.qlns.Mode.RewardAndDiscipline;
import com.qlns.qlns.Repository.RewardAndDisciplineRepository;

@Service
public class RewardAndDisciplineService {

    @Autowired
    private RewardAndDisciplineRepository rewardAndDisciplineRepository;

    public RewardAndDiscipline saveRewardOrDiscipline(RewardAndDiscipline rewardAndDiscipline) {
        return rewardAndDisciplineRepository.save(rewardAndDiscipline);
    }
}

