package com.qlns.qlns.Serevice;
import com.qlns.qlns.Mode.ChamCong;
import com.qlns.qlns.Repository.ChamCongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChamCongServiceImpl implements ChamCongService {

    @Autowired
    private ChamCongRepository repository;

    @Override
    public List<ChamCong> findAll() {
        return repository.findAll();
    }

    @Override
    public ChamCong findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(ChamCong chamCong) {
        repository.save(chamCong);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
