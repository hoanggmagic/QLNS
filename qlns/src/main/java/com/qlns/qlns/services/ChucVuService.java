package com.qlns.qlns.services;

import java.util.List;
import com.qlns.qlns.entitys.*;

public interface ChucVuService {
    List<ChucVu> findAll();

    ChucVu findById(Long id);

    void save(ChucVu chucVu);

    void deleteById(Long id);
}
