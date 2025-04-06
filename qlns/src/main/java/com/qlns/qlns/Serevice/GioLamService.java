package com.qlns.qlns.Serevice;
import java.util.List;

import com.qlns.qlns.Mode.GioLam;

public interface GioLamService {
    List<GioLam> findAll();
    GioLam findById(Long id);
    void save(GioLam gioLam);
    void deleteById(Long id);
}
