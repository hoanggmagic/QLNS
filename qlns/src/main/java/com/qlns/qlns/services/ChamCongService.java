package com.qlns.qlns.services;

import java.util.List;
import com.qlns.qlns.entitys.*;

public interface ChamCongService {
    List<ChamCong> findAll();

    ChamCong findById(Long id);

    void save(ChamCong chamCong); // bạn đã có, dùng nếu không cần return

    void deleteById(Long id);

    // ✅ Thêm 2 phương thức sau để fix lỗi ở controller
    ChamCong saveChamCong(ChamCong chamCong); // để dùng trong controller

    List<ChamCong> findByNhanVien(NhanVien nhanVien); // để xem lịch sử chấm công theo nhân viên
}
