package com.qlns.qlns.Serevice;

import com.qlns.qlns.Mode.KhenThuongKyLuat;
import com.qlns.qlns.Repository.KhenThuongKyLuatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhenThuongKyLuatServiceImpl implements KhenThuongKyLuatService {

    @Autowired
    private KhenThuongKyLuatRepository repository;

    @Override
    public List<KhenThuongKyLuat> findAll() {
        return repository.findAll();
    }

    @Override
    public KhenThuongKyLuat findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(KhenThuongKyLuat ktkl) {
        repository.save(ktkl);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
