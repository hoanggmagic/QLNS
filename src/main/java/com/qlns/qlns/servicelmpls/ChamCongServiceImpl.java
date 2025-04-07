package com.qlns.qlns.servicelmpls;

import com.qlns.qlns.entitys.*;
import com.qlns.qlns.repositorys.*;
import com.qlns.qlns.services.ChamCongService;

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

    // ✅ Thêm để dùng trong controller
    @Override
    public ChamCong saveChamCong(ChamCong chamCong) {
        return repository.save(chamCong);
    }

    // ✅ Thêm để lấy danh sách chấm công theo nhân viên
    @Override
    public List<ChamCong> findByNhanVien(NhanVien nhanVien) {
        return repository.findByNhanVien(nhanVien);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
