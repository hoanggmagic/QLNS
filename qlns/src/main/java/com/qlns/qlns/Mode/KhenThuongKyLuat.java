package com.qlns.qlns.Mode;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "KhenThuongKyLuat")
public class KhenThuongKyLuat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String loai; // "Khen thưởng" hoặc "Kỷ luật"
    private String lyDo;
    private Date ngay;

    @ManyToOne
    @JoinColumn(name = "nhanvien_id")
    private NhanVien nhanVien;

    // Getters, Setters, Constructors
}
