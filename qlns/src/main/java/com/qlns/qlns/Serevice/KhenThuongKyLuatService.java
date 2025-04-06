package com.qlns.qlns.Serevice;

import java.util.List;

import com.qlns.qlns.Mode.KhenThuongKyLuat;

public interface KhenThuongKyLuatService {
    List<KhenThuongKyLuat> findAll();
    KhenThuongKyLuat findById(Long id);
    void save(KhenThuongKyLuat ktkl);
    void deleteById(Long id);
}
