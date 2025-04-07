package com.qlns.qlns.serevicelmpls;

import com.qlns.qlns.entitys.*;
import com.qlns.qlns.repositorys.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LuongServiceImpl implements LuongService {

    @Autowired
    private LuongRepository repository;

    @Override
    public List<Luong> findAll() {
        return repository.findAll();
    }

    @Override
    public Luong findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(Luong luong) {
        repository.save(luong);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
