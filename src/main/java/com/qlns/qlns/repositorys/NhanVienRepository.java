package com.qlns.qlns.repositorys;

import com.qlns.qlns.Mode.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Long> {

    Optional<NhanVien> findByUsername(String username); // Phương thức này trả về Optional

    Optional<NhanVien> findBySdt(String sdt); // Phương thức tìm theo SĐT

    NhanVien findByEmail(String email); // Tìm theo email

}
