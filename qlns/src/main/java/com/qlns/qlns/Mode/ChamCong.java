package com.qlns.qlns.Mode;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ChamCong")
public class ChamCong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date ngay;
    private String trangThai; // Có thể là "Đi làm", "Nghỉ", "Muộn",...

    @ManyToOne
    @JoinColumn(name = "nhanvien_id")
    private NhanVien nhanVien;

    // Getters, Setters, Constructors
}
