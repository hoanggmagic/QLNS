package com.qlns.qlns.entitys;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Luong")
public class Luong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal luongCoBan;
    private BigDecimal phuCap;
    private BigDecimal tongLuong;

    @OneToOne
    @JoinColumn(name = "nhanvien_id")
    private NhanVien nhanVien;

    // Constructor mặc định
    public Luong() {
    }

    // Constructor đầy đủ
    public Luong(Long id, BigDecimal luongCoBan, BigDecimal phuCap, BigDecimal tongLuong, NhanVien nhanVien) {
        this.id = id;
        this.luongCoBan = luongCoBan;
        this.phuCap = phuCap;
        this.tongLuong = tongLuong;
        this.nhanVien = nhanVien;
    }

    // Getters và Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(BigDecimal luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public BigDecimal getPhuCap() {
        return phuCap;
    }

    public void setPhuCap(BigDecimal phuCap) {
        this.phuCap = phuCap;
    }

    public BigDecimal getTongLuong() {
        return tongLuong;
    }

    public void setTongLuong(BigDecimal tongLuong) {
        this.tongLuong = tongLuong;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }
}
