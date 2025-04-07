package com.qlns.qlns.entitys;

import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "GioLam")
public class GioLam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalTime gioBatDau;
    private LocalTime gioKetThuc;

    @OneToOne
    @JoinColumn(name = "nhanvien_id")
    private NhanVien nhanVien;

    // Getter và Setter cho gioBatDau và gioKetThuc
    public LocalTime getGioBatDau() {
        return gioBatDau;
    }

    public void setGioBatDau(LocalTime gioBatDau) {
        this.gioBatDau = gioBatDau;
    }

    public LocalTime getGioKetThuc() {
        return gioKetThuc;
    }

    public void setGioKetThuc(LocalTime gioKetThuc) {
        this.gioKetThuc = gioKetThuc;
    }

    // Getter và Setter cho id và nhanVien (nếu cần)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }
}
