package com.qlns.qlns.servicelmpls;

import com.qlns.qlns.entitys.*;
import com.qlns.qlns.repositorys.*;
import com.qlns.qlns.services.GioLamService;

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
