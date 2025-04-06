package com.qlns.qlns.Serevice;

import com.qlns.qlns.Mode.NhanVien;
import com.qlns.qlns.Repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhanVienServiceImpl implements NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Override
    public List<NhanVien> findAll() {
        return nhanVienRepository.findAll();
    }

    @Override
    public NhanVien findById(Long id) {
        Optional<NhanVien> nhanVien = nhanVienRepository.findById(id);
        return nhanVien.orElse(null);  // Trả về null nếu không tìm thấy
    }

    @Override
    public NhanVien save(NhanVien nhanVien) {
        if (nhanVien == null) {
            throw new IllegalArgumentException("Nhân viên không được phép null");
        }
        return nhanVienRepository.save(nhanVien);
    }

    @Override
    public NhanVien update(Long id, NhanVien nhanVien) {
        if (nhanVien == null || id == null) {
            throw new IllegalArgumentException("ID và Nhân viên không thể null");
        }
        Optional<NhanVien> existingNhanVien = nhanVienRepository.findById(id);
        if (existingNhanVien.isPresent()) {
            NhanVien updatedNhanVien = existingNhanVien.get();
            updatedNhanVien.setUsername(nhanVien.getUsername());
            updatedNhanVien.setPassword(nhanVien.getPassword());
            updatedNhanVien.setEmail(nhanVien.getEmail());
            updatedNhanVien.setSdt(nhanVien.getSdt());
            updatedNhanVien.setChucVu(nhanVien.getChucVu());
            return nhanVienRepository.save(updatedNhanVien);
        } else {
            throw new IllegalArgumentException("Nhân viên với ID " + id + " không tồn tại");
        }
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID không thể null");
        }
        if (!nhanVienRepository.existsById(id)) {
            throw new IllegalArgumentException("Nhân viên với ID " + id + " không tồn tại");
        }
        nhanVienRepository.deleteById(id);
    }

    @Override
    public NhanVien findByUsername(String username) {
        return nhanVienRepository.findByUsername(username).orElse(null);  // Xử lý Optional
    }

    @Override
    public NhanVien findByEmail(String email) {
        return nhanVienRepository.findByEmail(email);
    }
}
