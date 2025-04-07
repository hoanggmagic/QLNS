package com.qlns.qlns.services;

import java.util.List;

import com.qlns.qlns.entitys.*;

public interface GioLamService {
    List<GioLam> findAll();

    GioLam findById(Long id);

    void save(GioLam gioLam);

    void deleteById(Long id);
}
