package com.qlns.qlns.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cham_cong")
public class ChamCong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date ngay;

    @Temporal(TemporalType.TIME)
    @Column(name = "gio_vao")
    private Date gioVao;

    @Temporal(TemporalType.TIME)
    @Column(name = "gio_ra")
    private Date gioRa;

    @Column(nullable = true)
    private Boolean tre; // Có thể null

    @Column(name = "trang_thai")
    private String trangThai;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nhanvien_id")
    private NhanVien nhanVien;

}
