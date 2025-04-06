package com.qlns.qlns.Serevice;
import java.util.List;

import com.qlns.qlns.Mode.ChamCong;

public interface ChamCongService {
    List<ChamCong> findAll();
    ChamCong findById(Long id);
    void save(ChamCong chamCong);
    void deleteById(Long id);
}
