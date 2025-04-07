package com.qlns.qlns.services;

import java.util.List;

import com.qlns.qlns.entitys.*;

public interface LuongService {
    List<Luong> findAll();

    Luong findById(Long id);

    void save(Luong luong);

    void deleteById(Long id);
}
