package com.qlns.qlns.Serevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qlns.qlns.Mode.NhanVien;
import com.qlns.qlns.Repository.NhanVienRepository;
import java.util.List;
import java.util.Optional;

@Service
public class NhanVienServiceImpl implements NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    // Lấy tất cả nhân viên
    @Override
    public List<NhanVien> findAll() {
        return nhanVienRepository.findAll();
    }

    // Tìm nhân viên theo ID
    @Override
    public NhanVien findById(Long id) {
        Optional<NhanVien> nhanVien = nhanVienRepository.findById(id);
        return nhanVien.orElse(null); // Trả về null nếu không tìm thấy
    }

    // Lưu nhân viên mới
    @Override
    public NhanVien save(NhanVien nhanVien) {
        if (nhanVien == null) {
            throw new IllegalArgumentException("Nhân viên không được phép null");
        }
        return nhanVienRepository.save(nhanVien);
    }

    // Cập nhật thông tin nhân viên
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
            updatedNhanVien.setChucVu(nhanVien.getChucVu());  // Cập nhật ChucVu
            return nhanVienRepository.save(updatedNhanVien);
        } else {
            throw new IllegalArgumentException("Nhân viên với ID " + id + " không tồn tại");
        }
    }

    // Xóa nhân viên theo ID
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
}
