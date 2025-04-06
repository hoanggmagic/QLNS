package com.qlns.qlns.Serevice;

import com.qlns.qlns.Mode.ChucVu;
import com.qlns.qlns.Repository.ChucVuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChucVuServiceImpl implements ChucVuService {

    private final ChucVuRepository repository;

    // Constructor Injection
    public ChucVuServiceImpl(ChucVuRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ChucVu> findAll() {
        return repository.findAll();
    }

    @Override
    public ChucVu findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(ChucVu chucVu) {
        repository.save(chucVu);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
