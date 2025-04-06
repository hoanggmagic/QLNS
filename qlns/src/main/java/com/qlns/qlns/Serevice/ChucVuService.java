package com.qlns.qlns.Serevice;

import java.util.List;
import com.qlns.qlns.Mode.ChucVu;

public interface ChucVuService {
    List<ChucVu> findAll();
    ChucVu findById(Long id);
    void save(ChucVu chucVu);
    void deleteById(Long id);
}
