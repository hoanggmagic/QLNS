package com.qlns.qlns.entitys;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
}
