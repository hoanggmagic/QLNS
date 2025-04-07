package com.qlns.qlns.services;

import java.util.List;

import com.qlns.qlns.entitys.*;

public interface KhenThuongKyLuatService {
    List<KhenThuongKyLuat> findAll();

    KhenThuongKyLuat findById(Long id);

    void save(KhenThuongKyLuat ktkl);

    void deleteById(Long id);
}
