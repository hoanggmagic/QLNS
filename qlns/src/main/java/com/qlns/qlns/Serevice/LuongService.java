package com.qlns.qlns.Serevice;
import java.util.List;

import com.qlns.qlns.Mode.Luong;

public interface LuongService {
    List<Luong> findAll();
    Luong findById(Long id);
    void save(Luong luong);
    void deleteById(Long id);
}
