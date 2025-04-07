package com.qlns.qlns.entitys;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
}
