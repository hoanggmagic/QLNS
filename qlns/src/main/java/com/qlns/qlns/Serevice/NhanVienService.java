package com.qlns.qlns.Serevice;

import com.qlns.qlns.Mode.NhanVien;
import java.util.List;

public interface NhanVienService {
    List<NhanVien> findAll();
    NhanVien findById(Long id);
    NhanVien save(NhanVien nhanVien);
    NhanVien update(Long id, NhanVien nhanVien);
    void delete(Long id);
}
