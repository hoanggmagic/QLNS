package com.qlns.qlns.Repository;

import com.qlns.qlns.Mode.ChucVu;
import com.qlns.qlns.Mode.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Long> {

    Optional<NhanVien> findByUsername(String username);
    
    Optional<NhanVien> findByEmail(String email);

    Optional<NhanVien> findBySdt(String sdt);

    // Thêm phương thức tìm nhân viên theo chức vụ
    List<NhanVien> findByChucVu(ChucVu chucVu);
}
