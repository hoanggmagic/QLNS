package com.qlns.qlns.services;

import com.qlns.qlns.entitys.*;
import java.util.List;

public interface NhanVienService {
    List<NhanVien> findAll();

    NhanVien findById(Long id);

    NhanVien save(NhanVien nhanVien);

    NhanVien update(Long id, NhanVien nhanVien);

    void delete(Long id);

    NhanVien findByUsername(String username);

    NhanVien findByEmail(String email);

}
