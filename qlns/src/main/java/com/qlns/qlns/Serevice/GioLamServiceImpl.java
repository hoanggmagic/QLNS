package com.qlns.qlns.Serevice;
import com.qlns.qlns.Mode.GioLam;
import com.qlns.qlns.Repository.GioLamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GioLamServiceImpl implements GioLamService {

    @Autowired
    private GioLamRepository repository;

    @Override
    public List<GioLam> findAll() {
        return repository.findAll();
    }

    @Override
    public GioLam findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(GioLam gioLam) {
        repository.save(gioLam);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
